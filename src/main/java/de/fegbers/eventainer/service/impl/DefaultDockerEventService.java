package de.fegbers.eventainer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.service.DockerEventService;
import de.fegbers.eventainer.service.NotificationService;

@Service
public class DefaultDockerEventService implements DockerEventService
{
    @Autowired
    private List<NotificationService> notificationServices;

    @Override
    public void processEvent(DockerEvent dockerEvent)
    {
        notificationServices.forEach(notificationService ->
        {
            if (notificationService.isNotFiltered(dockerEvent))
            {
                notificationService.process(dockerEvent);
            }
        });
    }
}
