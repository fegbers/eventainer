package de.fegbers.eventainer.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import de.fegbers.eventainer.utils.DockerUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GrafanaAnnotation
{
    private List<String> tags = new ArrayList<>(Collections.singletonList("eventainer"));

    private String text;

    public GrafanaAnnotation(DockerEvent dockerEvent)
    {
        tags.add(dockerEvent.getType().name().toLowerCase() + "-eventainer");
        text = createText(dockerEvent);
    }

    private static String createText(DockerEvent dockerEvent)
    {
        StringBuilder textBuilder = new StringBuilder(dockerEvent.getType().name() + " " + dockerEvent.getAction().name());

        if (dockerEvent.getActor() != null && StringUtils.isNotBlank(dockerEvent.getActor().getAttributes().get("image")))
        {
            textBuilder.append("\n");
            textBuilder.append("IMAGE " + DockerUtils.cleanImage(dockerEvent.getActor().getAttributes().get("image")));
        }

        return textBuilder.toString();
    }
}
