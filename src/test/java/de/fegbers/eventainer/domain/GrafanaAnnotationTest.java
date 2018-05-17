package de.fegbers.eventainer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collections;

import org.junit.Test;

import de.fegbers.eventainer.test.util.DomainTestSupport;

public class GrafanaAnnotationTest implements DomainTestSupport
{
    @Test
    public void testConstructorWithDockerEvent()
    {
        GrafanaAnnotation grafanaAnnotation = new GrafanaAnnotation(getContainerStartedDockerEvent());
        assertEquals(2, grafanaAnnotation.getTags().size());
        assertEquals("eventainer", grafanaAnnotation.getTags().get(0));
        assertEquals("container-eventainer", grafanaAnnotation.getTags().get(1));
        assertEquals("CONTAINER START\nIMAGE hello-world", grafanaAnnotation.getText());
    }

    @Test
    public void testConstructorWithDockerEventAndActorIsNull()
    {
        DockerEvent dockerEvent = getCompleteDockerEvent();
        dockerEvent.setActor(null);

        GrafanaAnnotation grafanaAnnotation = new GrafanaAnnotation(dockerEvent);
        assertEquals(2, grafanaAnnotation.getTags().size());
        assertEquals("eventainer", grafanaAnnotation.getTags().get(0));
        assertEquals("container-eventainer", grafanaAnnotation.getTags().get(1));
        assertEquals("CONTAINER START", grafanaAnnotation.getText());
    }

    @Test
    public void testConstructorWithDockerEventAndImageIsNull()
    {
        DockerEvent dockerEvent = getCompleteDockerEvent();
        dockerEvent.getActor().setAttributes(Collections.singletonMap("name", "container_name"));

        GrafanaAnnotation grafanaAnnotation = new GrafanaAnnotation(dockerEvent);
        assertEquals(2, grafanaAnnotation.getTags().size());
        assertEquals("eventainer", grafanaAnnotation.getTags().get(0));
        assertEquals("container-eventainer", grafanaAnnotation.getTags().get(1));
        assertEquals("CONTAINER START", grafanaAnnotation.getText());
    }

    @Test
    public void testDefaultValueOnTags()
    {
        GrafanaAnnotation grafanaAnnotation = new GrafanaAnnotation();
        assertEquals(1, grafanaAnnotation.getTags().size());
        assertEquals("eventainer", grafanaAnnotation.getTags().get(0));
    }

    @Test
    public void testDefaultValueOnText()
    {
        assertNull(new GrafanaAnnotation().getText());
    }
}
