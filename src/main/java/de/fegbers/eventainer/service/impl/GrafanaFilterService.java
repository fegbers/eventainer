package de.fegbers.eventainer.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import de.fegbers.eventainer.domain.DockerAction;
import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.domain.DockerType;
import de.fegbers.eventainer.service.FilterService;

@Service
public class GrafanaFilterService implements FilterService
{
    @Override
    public boolean isNotFiltered(DockerEvent dockerEvent)
    {
        return supportsEvent(dockerEvent.getType(), dockerEvent.getAction());
    }

    private static boolean supportsEvent(DockerType type, DockerAction action)
    {
        if (DockerType.CONTAINER.equals(type))
        {
            return new ArrayList<>(Arrays.asList(DockerAction.START, DockerAction.STOP)).contains(action);
        }
        return false;
    }
}
