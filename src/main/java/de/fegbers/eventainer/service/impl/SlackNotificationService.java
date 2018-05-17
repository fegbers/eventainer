package de.fegbers.eventainer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.repository.NotificationRepository;
import de.fegbers.eventainer.service.FilterService;
import de.fegbers.eventainer.service.NotificationService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SlackNotificationService implements NotificationService
{
    @Autowired
    private FilterService slackFilterService;

    @Autowired
    private NotificationRepository httpSlackNotificationRepository;

    @Override
    public boolean isNotFiltered(DockerEvent dockerEvent)
    {
        return slackFilterService.isNotFiltered(dockerEvent);
    }

    @Override
    public void process(DockerEvent dockerEvent)
    {
        log.debug("Process {}", dockerEvent);
        httpSlackNotificationRepository.createNotification(dockerEvent);
    }
}
