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
import com.spotify.docker.client.messages.Event.Actor;

@RunWith(PowerMockRunner.class)
public class DockerActorTest
{
    @MockStrict
    private Actor spotifyDockerActor;

    @Test
    public void testSpotifyDockerActorConstructor()
    {
        spotifyDockerActor.attributes();
        expectLastCall().andReturn(ImmutableMap.of("image", "hello-world", "name", "container_name")).times(2);

        replayAll();
        DockerActor dockerActor = new DockerActor(spotifyDockerActor);
        verifyAll();

        assertEquals(2, dockerActor.getAttributes().size());
        assertEquals("hello-world", dockerActor.getAttributes().get("image"));
        assertEquals("container_name", dockerActor.getAttributes().get("name"));
    }

    @Test
    public void testSpotifyDockerActorConstructorWithAttributesIsNull()
    {
        spotifyDockerActor.attributes();
        expectLastCall().andReturn(null);

        replayAll();
        DockerActor dockerActor = new DockerActor(spotifyDockerActor);
        verifyAll();

        assertNull(dockerActor.getAttributes());
    }

    @Test
    public void testSpotifyDockerActorConstructorWithAttributesIsEmpty()
    {
        spotifyDockerActor.attributes();
        expectLastCall().andReturn(ImmutableMap.of());

        replayAll();
        DockerActor dockerActor = new DockerActor(spotifyDockerActor);
        verifyAll();

        assertNull(dockerActor.getAttributes());
    }

    @Test
    public void testDefaultValueOnAttributes()
    {
        assertNull(new DockerActor().getAttributes());
    }
}
