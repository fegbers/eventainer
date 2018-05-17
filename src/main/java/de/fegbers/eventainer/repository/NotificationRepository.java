package de.fegbers.eventainer.repository;

import de.fegbers.eventainer.domain.DockerEvent;

public interface NotificationRepository
{
    void createNotification(DockerEvent dockerEvent);
}
