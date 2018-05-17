package de.fegbers.eventainer.config;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.getCurrentArguments;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.MockStrict;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import de.fegbers.eventainer.config.HttpGrafanaConfig.GrafanaClientHttpRequestInterceptor;

@RunWith(PowerMockRunner.class)
public class HttpGrafanaConfigTest
{
    private HttpGrafanaConfig httpGrafanaConfig = new HttpGrafanaConfig();

    @MockStrict
    private ClientHttpRequestExecution clientHttpRequestExecution;

    @Test
    public void testGrafanaRestTemplate()
    {
        RestTemplate restTemplate = httpGrafanaConfig.grafanaRestTemplate();
        assertEquals(1, restTemplate.getInterceptors().size());
        assertTrue(restTemplate.getInterceptors().get(0) instanceof GrafanaClientHttpRequestInterceptor);
    }

    @Test
    public void testGrafanaClientHttpRequestInterceptorIntercept() throws IOException, URISyntaxException
    {
        clientHttpRequestExecution.execute(anyObject(HttpRequest.class), anyObject());
        expectLastCall().andAnswer(() ->
        {
            HttpRequest httpRequest = (HttpRequest) getCurrentArguments()[0];
            byte[] body = (byte[]) getCurrentArguments()[1];

            assertEquals(Collections.singletonList("Bearer testBearerToken"), httpRequest.getHeaders().get("Authorization"));
            assertEquals(Collections.singletonList("application/json"), httpRequest.getHeaders().get("Accept"));

            assertEquals("TestBody", new String(body));

            return null;
        });

        replayAll();
        GrafanaClientHttpRequestInterceptor grafanaClientHttpRequestInterceptor = new GrafanaClientHttpRequestInterceptor("testBearerToken");
        grafanaClientHttpRequestInterceptor
                .intercept(new SimpleClientHttpRequestFactory().createRequest(new URI("http://fegbers.de"), HttpMethod.GET), "TestBody"
                        .getBytes(), clientHttpRequestExecution);
        verifyAll();
    }
}
