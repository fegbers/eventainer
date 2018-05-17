package de.fegbers.eventainer.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import de.fegbers.eventainer.utils.DockerUtils;

public class DockerUtilsTest
{
    @Test
    public void testCleanImageWithImageIsNull()
    {
        String returnValue = DockerUtils.cleanImage(null);
        assertNull(returnValue);
    }

    @Test
    public void testCleanImageWithImageIsEmpty()
    {
        String returnValue = DockerUtils.cleanImage("");
        assertNull(returnValue);
    }

    @Test
    public void testCleanImageWithImageIsBlank()
    {
        String returnValue = DockerUtils.cleanImage(" ");
        assertNull(returnValue);
    }

    @Test
    public void testCleanImageWithHashValue()
    {
        String returnValue = DockerUtils.cleanImage("ubuntu:17.10@sha256:35bc48a1ca97c3971611dc4662d08d131869daa692acb281c7e9e052924e38b1");
        assertEquals("ubuntu:17.10", returnValue);
    }

    @Test
    public void testCleanImageWithNoHashValue()
    {
        String returnValue = DockerUtils.cleanImage("ubuntu:17.10");
        assertEquals("ubuntu:17.10", returnValue);
    }
}
