package de.fegbers.eventainer.service.impl;

import org.springframework.stereotype.Service;

import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.service.FilterService;

@Service
public class SlackFilterService implements FilterService
{
    @Override
    public boolean isNotFiltered(DockerEvent dockerEvent)
    {
        return true;
    }
}
