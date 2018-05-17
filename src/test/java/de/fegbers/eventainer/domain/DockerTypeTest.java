package de.fegbers.eventainer.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DockerTypeTest
{
    @Test
    public void testResolveTypeWithTypeIsNull()
    {
        try
        {
            DockerType.resolveType(null);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Usupported type", e.getMessage());
        }
    }

    @Test
    public void testResolveTypeWithTypeIsEmpty()
    {
        try
        {
            DockerType.resolveType("");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Usupported type", e.getMessage());
        }
    }

    @Test
    public void testResolveTypeWithTypeIsBlank()
    {
        try
        {
            DockerType.resolveType(" ");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Usupported type", e.getMessage());
        }
    }

    @Test
    public void testResolveTypeWithTypeIsUnknown()
    {
        try
        {
            DockerType.resolveType("unknown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Usupported type", e.getMessage());
        }
    }

    @Test
    public void testResolveTypeWithUpperCaseContainer()
    {
        DockerType returnType = DockerType.resolveType("CONTAINER");
        assertEquals(DockerType.CONTAINER, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseContainer()
    {
        DockerType returnType = DockerType.resolveType("container");
        assertEquals(DockerType.CONTAINER, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCaseImage()
    {
        DockerType returnType = DockerType.resolveType("IMAGE");
        assertEquals(DockerType.IMAGE, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseImage()
    {
        DockerType returnType = DockerType.resolveType("image");
        assertEquals(DockerType.IMAGE, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCaseVolume()
    {
        DockerType returnType = DockerType.resolveType("VOLUME");
        assertEquals(DockerType.VOLUME, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseVolume()
    {
        DockerType returnType = DockerType.resolveType("volume");
        assertEquals(DockerType.VOLUME, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCaseNetwork()
    {
        DockerType returnType = DockerType.resolveType("NETWORK");
        assertEquals(DockerType.NETWORK, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseNetwork()
    {
        DockerType returnType = DockerType.resolveType("network");
        assertEquals(DockerType.NETWORK, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCaseDaemon()
    {
        DockerType returnType = DockerType.resolveType("DAEMON");
        assertEquals(DockerType.DAEMON, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseDaemon()
    {
        DockerType returnType = DockerType.resolveType("daemon");
        assertEquals(DockerType.DAEMON, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCasePlugin()
    {
        DockerType returnType = DockerType.resolveType("PLUGIN");
        assertEquals(DockerType.PLUGIN, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCasePlugin()
    {
        DockerType returnType = DockerType.resolveType("plugin");
        assertEquals(DockerType.PLUGIN, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCaseNode()
    {
        DockerType returnType = DockerType.resolveType("NODE");
        assertEquals(DockerType.NODE, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseNode()
    {
        DockerType returnType = DockerType.resolveType("node");
        assertEquals(DockerType.NODE, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCaseService()
    {
        DockerType returnType = DockerType.resolveType("SERVICE");
        assertEquals(DockerType.SERVICE, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseService()
    {
        DockerType returnType = DockerType.resolveType("service");
        assertEquals(DockerType.SERVICE, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCaseSecret()
    {
        DockerType returnType = DockerType.resolveType("SECRET");
        assertEquals(DockerType.SECRET, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseSecret()
    {
        DockerType returnType = DockerType.resolveType("secret");
        assertEquals(DockerType.SECRET, returnType);
    }

    @Test
    public void testResolveTypeWithUpperCaseConfig()
    {
        DockerType returnType = DockerType.resolveType("CONFIG");
        assertEquals(DockerType.CONFIG, returnType);
    }

    @Test
    public void testResolveTypeWithLowerCaseConfig()
    {
        DockerType returnType = DockerType.resolveType("config");
        assertEquals(DockerType.CONFIG, returnType);
    }
}
