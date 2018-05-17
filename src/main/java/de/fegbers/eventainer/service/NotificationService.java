package de.fegbers.eventainer.service;

import de.fegbers.eventainer.domain.DockerEvent;

public interface NotificationService
{
    boolean isNotFiltered(DockerEvent dockerEvent);

    void process(DockerEvent dockerEvent);
}
