package de.fegbers.eventainer.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import de.fegbers.eventainer.repository.impl.HttpGrafanaNotificationRepository;
import lombok.RequiredArgsConstructor;

@Configuration
public class HttpGrafanaConfig
{
    @Value("${grafana.http.bearer.token}")
    private String bearerToken;

    @Bean
    public RestTemplate grafanaRestTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new GrafanaClientHttpRequestInterceptor(bearerToken)));
        return restTemplate;
    }

    /**
     * An implementation of the {@link ClientHttpRequestInterceptor} for the {@link HttpGrafanaNotificationRepository} to intercept HTTP requests, adding an
     * authorization and other necessary headers. The authorization is a Bearer and uses the {@link #bearerToken} passed through
     * {@link GrafanaClientHttpRequestInterceptor#GrafanaClientHttpRequestInterceptor(String)}.
     */
    // visible only for testing
    @RequiredArgsConstructor
    static class GrafanaClientHttpRequestInterceptor implements ClientHttpRequestInterceptor
    {
        private final String bearerToken;

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException
        {
            request.getHeaders().add("Authorization", "Bearer " + bearerToken);
            request.getHeaders().add("Accept", "application/json");
            return execution.execute(request, body);
        }
    }
}
