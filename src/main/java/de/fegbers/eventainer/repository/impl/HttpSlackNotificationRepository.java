package de.fegbers.eventainer.repository.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.model.Attachment;
import com.github.seratch.jslack.api.model.Field;
import com.github.seratch.jslack.api.webhook.Payload;

import de.fegbers.eventainer.domain.DockerEvent;
import de.fegbers.eventainer.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class HttpSlackNotificationRepository implements NotificationRepository
{
    @Value("${slack.webhook.url}")
    private String webhookUrl;

    @Autowired
    private Slack slack;

    @Override
    public void createNotification(DockerEvent dockerEvent)
    {
        try
        {
            Payload payload = createPayload(dockerEvent);
            log.debug("Sending Slack-{}", payload);
            slack.send(webhookUrl, payload);
        }
        catch (IOException e)
        {
            log.warn(e.getMessage(), e);
        }
    }

    private static Payload createPayload(DockerEvent dockerEvent)
    {
        List<Field> fields = dockerEvent.getActor()
                .getAttributes()
                .entrySet()
                .stream()
                .map(entry -> Field.builder().value(entry.getKey() + ":" + entry.getValue()).build())
                .collect(Collectors.toList());

        List<Attachment> attachments = Collections
                .singletonList(Attachment.builder()
                        .fields(fields)
                        .build());

        return Payload.builder()
                .username("eventainer")
                .text(dockerEvent.getType().name() + " " + dockerEvent.getAction().name())
                .attachments(attachments)
                .build();
    }
}
