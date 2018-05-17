package de.fegbers.eventainer.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.getCurrentArguments;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;
import static org.powermock.reflect.Whitebox.setInternalState;

import java.util.Arrays;

import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.MockStrict;
import org.powermock.modules.junit4.PowerMockRunner;

import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.service.DockerEventService;
import de.fegbers.eventainer.service.NotificationService;
import de.fegbers.eventainer.test.util.DomainTestSupport;

@RunWith(PowerMockRunner.class)
public class DefaultDockerEventServiceTest implements DomainTestSupport
{
    @TestSubject
    private DockerEventService dockerEventService = new DefaultDockerEventService();

    @MockStrict
    private NotificationService filteredNotificationService;

    @MockStrict
    private NotificationService notFilteredNotificationService;

    @Before
    public void before()
    {
        setInternalState(dockerEventService, Arrays.asList(filteredNotificationService, notFilteredNotificationService));
    }

    @Test
    public void testProcessEvent()
    {
        filteredNotificationService.isNotFiltered(anyObject(DockerEvent.class));
        expectLastCall().andAnswer(() ->
        {
            assertThat(getCurrentArguments()[0]).isEqualToComparingFieldByFieldRecursively(getContainerStartedDockerEvent());
            return Boolean.FALSE;
        });

        notFilteredNotificationService.isNotFiltered(anyObject(DockerEvent.class));
        expectLastCall().andAnswer(() ->
        {
            assertThat(getCurrentArguments()[0]).isEqualToComparingFieldByFieldRecursively(getContainerStartedDockerEvent());
            return Boolean.TRUE;
        });

        notFilteredNotificationService.process(anyObject(DockerEvent.class));
        expectLastCall().andAnswer(() ->
        {
            assertThat(getCurrentArguments()[0]).isEqualToComparingFieldByFieldRecursively(getContainerStartedDockerEvent());
            return null;
        });

        replayAll();
        dockerEventService.processEvent(getContainerStartedDockerEvent());
        verifyAll();
    }
}
