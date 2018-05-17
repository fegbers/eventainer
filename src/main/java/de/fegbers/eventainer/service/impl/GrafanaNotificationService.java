package de.fegbers.eventainer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.repository.NotificationRepository;
import de.fegbers.eventainer.service.FilterService;
import de.fegbers.eventainer.service.NotificationService;

@Service
public class GrafanaNotificationService implements NotificationService
{
    @Autowired
    private FilterService grafanaFilterService;

    @Autowired
    private NotificationRepository httpGrafanaNotificationRepository;

    @Override
    public boolean isNotFiltered(DockerEvent dockerEvent)
    {
        return grafanaFilterService.isNotFiltered(dockerEvent);
    }

    @Override
    public void process(DockerEvent dockerEvent)
    {
        httpGrafanaNotificationRepository.createNotification(dockerEvent);
    }
}
