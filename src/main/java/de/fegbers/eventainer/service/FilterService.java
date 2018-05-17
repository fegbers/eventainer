package de.fegbers.eventainer.service;

import de.fegbers.eventainer.domain.DockerEvent;

public interface FilterService
{
    boolean isNotFiltered(DockerEvent dockerEvent);
}
