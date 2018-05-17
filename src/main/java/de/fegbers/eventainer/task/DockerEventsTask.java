package de.fegbers.eventainer.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.EventStream;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;

import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.service.DockerEventService;
import lombok.extern.slf4j.Slf4j;

@EnableScheduling
@Component
@Slf4j
public class DockerEventsTask
{
    @Autowired
    private DockerEventService dockerEventService;

    @Scheduled(fixedDelay = 1, initialDelay = 1000)
    public void run() throws DockerCertificateException
    {
        log.info("DockerEventsTask started");

        try (EventStream eventStream = DefaultDockerClient.fromEnv().build().events())
        {
            eventStream.forEachRemaining(event ->
            {
                DockerEvent dockerEvent = new DockerEvent(event);
                dockerEventService.processEvent(dockerEvent);
            });
        }
        catch (DockerException | InterruptedException e)
        {
            log.error(e.getMessage(), e);
        }
    }
}
