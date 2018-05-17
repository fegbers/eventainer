package de.fegbers.eventainer.test.util;

import java.util.HashMap;
import java.util.Map;

import de.fegbers.eventainer.domain.DockerAction;
import de.fegbers.eventainer.domain.DockerActor;
import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.domain.DockerType;
import de.fegbers.eventainer.domain.GrafanaAnnotation;

public interface DomainTestSupport
{
    default DockerEvent getCompleteDockerEvent()
    {
        DockerEvent dockerEvent = new DockerEvent();
        dockerEvent.setAction(DockerAction.START);
        dockerEvent.setType(DockerType.CONTAINER);
        dockerEvent.setActor(getContainerActor());
        return dockerEvent;
    }

    default DockerEvent getContainerStartedDockerEvent()
    {
        DockerEvent dockerEvent = new DockerEvent();
        dockerEvent.setAction(DockerAction.START);
        dockerEvent.setType(DockerType.CONTAINER);
        dockerEvent.setActor(getContainerActor());
        return dockerEvent;
    }

    default DockerActor getContainerActor()
    {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("image", "hello-world");
        attributes.put("name", "container_name");

        DockerActor actor = new DockerActor();
        actor.setAttributes(attributes);
        return actor;
    }

    default GrafanaAnnotation getContainerGrafanaAnnotation()
    {
        return new GrafanaAnnotation(getContainerStartedDockerEvent());
    }
}
