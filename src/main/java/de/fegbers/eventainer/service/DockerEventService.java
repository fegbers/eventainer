package de.fegbers.eventainer.service;

import de.fegbers.eventainer.domain.DockerEvent;

public interface DockerEventService
{
    void processEvent(DockerEvent dockerEvent);
}
