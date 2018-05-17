package de.fegbers.eventainer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.powermock.api.easymock.PowerMock.expectLastCall;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.MockStrict;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.common.collect.ImmutableMap;
import com.spotify.docker.client.messages.Event;
import com.spotify.docker.client.messages.Event.Actor;
import com.spotify.docker.client.messages.Event.Type;

@RunWith(PowerMockRunner.class)
public class DockerEventTest
{
    @MockStrict
    private Event event;

    @Test
    public void testConstructorWithSpotifyEvent()
    {
        event.type();
        expectLastCall().andReturn(Type.CONTAINER);

        event.action();
        expectLastCall().andReturn("start");

        event.actor();
        expectLastCall().andReturn(new SpotifyActor()).times(2);

        replayAll();
        DockerEvent dockerEvent = new DockerEvent(event);
        verifyAll();

        assertEquals(DockerType.CONTAINER, dockerEvent.getType());
        assertEquals(DockerAction.START, dockerEvent.getAction());
        assertEquals(2, dockerEvent.getActor().getAttributes().size());
        assertEquals("hello-world", dockerEvent.getActor().getAttributes().get("image"));
        assertEquals("container_name", dockerEvent.getActor().getAttributes().get("name"));
    }

    @Test
    public void testConstructorWithSpotifyEventAndActorIsNull()
    {
        event.type();
        expectLastCall().andReturn(com.spotify.docker.client.messages.Event.Type.CONTAINER);

        event.action();
        expectLastCall().andReturn("start");

        event.actor();
        expectLastCall().andReturn(null);

        replayAll();
        DockerEvent dockerEvent = new DockerEvent(event);
        verifyAll();

        assertEquals(DockerType.CONTAINER, dockerEvent.getType());
        assertEquals(DockerAction.START, dockerEvent.getAction());
        assertNull(dockerEvent.getActor());
    }

    @Test
    public void testDefaultValueOnType()
    {
        assertNull(new DockerEvent().getType());
    }

    @Test
    public void testDefaultValueOnAction()
    {
        assertNull(new DockerEvent().getAction());
    }

    @Test
    public void testDefaultValueOnActor()
    {
        assertNull(new DockerEvent().getActor());
    }

    private class SpotifyActor extends Actor
    {
        @Override
        public String id()
        {
            return "a4a6d77f1967";
        }

        @Override
        public ImmutableMap<String, String> attributes()
        {
            return ImmutableMap.of("image", "hello-world", "name", "container_name");
        }
    }
}
