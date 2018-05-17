package de.fegbers.eventainer.repository.impl;

import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;
import static org.powermock.reflect.Whitebox.setInternalState;

import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.MockStrict;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.seratch.jslack.Slack;

import de.fegbers.eventainer.repository.NotificationRepository;
import de.fegbers.eventainer.test.util.DomainTestSupport;

@Ignore
@RunWith(PowerMockRunner.class)
public class HttpSlackNotificationRepositoryTest implements DomainTestSupport
{
    @TestSubject
    private NotificationRepository notificationRepository = new HttpSlackNotificationRepository();;

    @MockStrict
    private Slack slack;

    @Before
    public void before()
    {
        setInternalState(notificationRepository, "https://test.slack.com/services/test");
    }

    @Test
    public void testCreateNotification()
    {
        replayAll();
        notificationRepository.createNotification(getContainerStartedDockerEvent());
        verifyAll();
    }

    @Test
    public void testCreateNotificationWithIOException()
    {
        replayAll();
        notificationRepository.createNotification(getContainerStartedDockerEvent());
        verifyAll();
    }
}
