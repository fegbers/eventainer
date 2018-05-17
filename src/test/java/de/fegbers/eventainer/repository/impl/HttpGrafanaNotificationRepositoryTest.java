package de.fegbers.eventainer.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.getCurrentArguments;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;
import static org.powermock.reflect.Whitebox.setInternalState;

import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.MockStrict;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import de.fegbers.eventainer.domain.GrafanaAnnotation;
import de.fegbers.eventainer.repository.NotificationRepository;
import de.fegbers.eventainer.test.util.DomainTestSupport;

@RunWith(PowerMockRunner.class)
public class HttpGrafanaNotificationRepositoryTest implements DomainTestSupport
{
    @TestSubject
    private NotificationRepository notificationRepository = new HttpGrafanaNotificationRepository();

    @MockStrict
    private RestTemplate grafanaRestTemplate;

    @Before
    public void before()
    {
        setInternalState(notificationRepository, "http://grafana.test.de");
    }

    @Test
    public void testCreateNotification()
    {
        grafanaRestTemplate.postForObject(eq("http://grafana.test.de"), anyObject(GrafanaAnnotation.class), eq(Void.class));
        expectLastCall().andAnswer(() ->
        {
            assertThat(getCurrentArguments()[1]).isEqualToComparingFieldByFieldRecursively(getContainerGrafanaAnnotation());
            return Void.class;
        });

        replayAll();
        notificationRepository.createNotification(getContainerStartedDockerEvent());
        verifyAll();
    }

    @Test
    public void testCreateNotificationWithRestClientException()
    {
        grafanaRestTemplate.postForObject(eq("http://grafana.test.de"), anyObject(GrafanaAnnotation.class), eq(Void.class));
        expectLastCall().andThrow(new RestClientException("Failed"));

        replayAll();
        notificationRepository.createNotification(getContainerStartedDockerEvent());
        verifyAll();
    }
}
