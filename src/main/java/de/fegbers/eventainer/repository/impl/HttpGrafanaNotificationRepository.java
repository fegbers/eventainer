package de.fegbers.eventainer.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.domain.GrafanaAnnotation;
import de.fegbers.eventainer.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class HttpGrafanaNotificationRepository implements NotificationRepository
{
    @Value("${grafana.http.url}")
    private String url;

    @Autowired
    private RestTemplate grafanaRestTemplate;

    @Override
    public void createNotification(DockerEvent dockerEvent)
    {
        GrafanaAnnotation annotation = new GrafanaAnnotation(dockerEvent);

        try
        {
            grafanaRestTemplate.postForObject(url, annotation, Void.class);
        }
        catch (RestClientException e)
        {
            log.warn("Creating " + annotation + " for " + dockerEvent + " failed", e);
        }
    }
}
