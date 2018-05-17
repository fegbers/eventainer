package de.fegbers.eventainer.domain;

import com.spotify.docker.client.messages.Event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class DockerEvent
{
    private DockerType type;

    private DockerAction action;

    private DockerActor actor;

    public DockerEvent(Event event)
    {
        this.type = DockerType.resolveType(event.type().name());
        this.action = DockerAction.resolveAction(event.action());

        if (event.actor() != null)
        {
            this.actor = new DockerActor(event.actor());
        }
    }
}
