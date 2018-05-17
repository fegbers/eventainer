package de.fegbers.eventainer.domain;

import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.spotify.docker.client.messages.Event.Actor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class DockerActor
{
    private Map<String, String> attributes;

    public DockerActor(Actor actor)
    {
        if (!CollectionUtils.isEmpty(actor.attributes()))
        {
            this.attributes = actor.attributes();
        }
    }
}
