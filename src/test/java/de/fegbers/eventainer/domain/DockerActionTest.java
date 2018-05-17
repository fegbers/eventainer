package de.fegbers.eventainer.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DockerActionTest
{
    @Test
    public void testResolveActionWithActionIsNull()
    {
        try
        {
            DockerAction.resolveAction(null);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Unsupported action", e.getMessage());
        }
    }

    @Test
    public void testResolveActionWithActionIsEmpty()
    {
        try
        {
            DockerAction.resolveAction("");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Unsupported action", e.getMessage());
        }
    }

    @Test
    public void testResolveActionWithActionIsBlank()
    {
        try
        {
            DockerAction.resolveAction(" ");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Unsupported action", e.getMessage());
        }
    }

    @Test
    public void testResolveActionWithUnknown()
    {
        try
        {
            DockerAction.resolveAction("unknown");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Unsupported action", e.getMessage());
        }
    }

    @Test
    public void testResolveActionWithUpperCaseAttach()
    {
        DockerAction retrunValue = DockerAction.resolveAction("ATTACH");
        assertEquals(DockerAction.ATTACH, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseAttach()
    {
        DockerAction retrunValue = DockerAction.resolveAction("attach");
        assertEquals(DockerAction.ATTACH, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseCommit()
    {
        DockerAction retrunValue = DockerAction.resolveAction("COMMIT");
        assertEquals(DockerAction.COMMIT, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseCommit()
    {
        DockerAction retrunValue = DockerAction.resolveAction("commit");
        assertEquals(DockerAction.COMMIT, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseCopy()
    {
        DockerAction retrunValue = DockerAction.resolveAction("COPY");
        assertEquals(DockerAction.COPY, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseCopy()
    {
        DockerAction retrunValue = DockerAction.resolveAction("copy");
        assertEquals(DockerAction.COPY, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseCreate()
    {
        DockerAction retrunValue = DockerAction.resolveAction("CREATE");
        assertEquals(DockerAction.CREATE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseCreate()
    {
        DockerAction retrunValue = DockerAction.resolveAction("create");
        assertEquals(DockerAction.CREATE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseConnect()
    {
        DockerAction retrunValue = DockerAction.resolveAction("CONNECT");
        assertEquals(DockerAction.CONNECT, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseConnect()
    {
        DockerAction retrunValue = DockerAction.resolveAction("connect");
        assertEquals(DockerAction.CONNECT, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseDestroy()
    {
        DockerAction retrunValue = DockerAction.resolveAction("DESTROY");
        assertEquals(DockerAction.DESTROY, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseDestroy()
    {
        DockerAction retrunValue = DockerAction.resolveAction("destroy");
        assertEquals(DockerAction.DESTROY, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseDetach()
    {
        DockerAction retrunValue = DockerAction.resolveAction("DETACH");
        assertEquals(DockerAction.DETACH, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseDetach()
    {
        DockerAction retrunValue = DockerAction.resolveAction("detach");
        assertEquals(DockerAction.DETACH, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseDelete()
    {
        DockerAction retrunValue = DockerAction.resolveAction("DELETE");
        assertEquals(DockerAction.DELETE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseDelete()
    {
        DockerAction retrunValue = DockerAction.resolveAction("delete");
        assertEquals(DockerAction.DELETE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseDie()
    {
        DockerAction retrunValue = DockerAction.resolveAction("DIE");
        assertEquals(DockerAction.DIE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseDie()
    {
        DockerAction retrunValue = DockerAction.resolveAction("die");
        assertEquals(DockerAction.DIE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseDisable()
    {
        DockerAction retrunValue = DockerAction.resolveAction("DISABLE");
        assertEquals(DockerAction.DISABLE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseDisable()
    {
        DockerAction retrunValue = DockerAction.resolveAction("disable");
        assertEquals(DockerAction.DISABLE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseDisconnect()
    {
        DockerAction retrunValue = DockerAction.resolveAction("DISCONNECT");
        assertEquals(DockerAction.DISCONNECT, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseDisconnect()
    {
        DockerAction retrunValue = DockerAction.resolveAction("disconnect");
        assertEquals(DockerAction.DISCONNECT, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseEnable()
    {
        DockerAction retrunValue = DockerAction.resolveAction("ENABLE");
        assertEquals(DockerAction.ENABLE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseEnable()
    {
        DockerAction retrunValue = DockerAction.resolveAction("enable");
        assertEquals(DockerAction.ENABLE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseExecCreate()
    {
        DockerAction retrunValue = DockerAction.resolveAction("EXEC_CREATE");
        assertEquals(DockerAction.EXEC_CREATE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseExecCreate()
    {
        DockerAction retrunValue = DockerAction.resolveAction("exec_create");
        assertEquals(DockerAction.EXEC_CREATE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseExecDetach()
    {
        DockerAction retrunValue = DockerAction.resolveAction("EXEC_DETACH");
        assertEquals(DockerAction.EXEC_DETACH, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseExecDetach()
    {
        DockerAction retrunValue = DockerAction.resolveAction("exec_detach");
        assertEquals(DockerAction.EXEC_DETACH, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseExecStart()
    {
        DockerAction retrunValue = DockerAction.resolveAction("EXEC_START");
        assertEquals(DockerAction.EXEC_START, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseExecStart()
    {
        DockerAction retrunValue = DockerAction.resolveAction("exec_start");
        assertEquals(DockerAction.EXEC_START, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseExport()
    {
        DockerAction retrunValue = DockerAction.resolveAction("EXPORT");
        assertEquals(DockerAction.EXPORT, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseExport()
    {
        DockerAction retrunValue = DockerAction.resolveAction("export");
        assertEquals(DockerAction.EXPORT, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseImport()
    {
        DockerAction retrunValue = DockerAction.resolveAction("IMPORT");
        assertEquals(DockerAction.IMPORT, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseImport()
    {
        DockerAction retrunValue = DockerAction.resolveAction("import");
        assertEquals(DockerAction.IMPORT, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseInstall()
    {
        DockerAction retrunValue = DockerAction.resolveAction("INSTALL");
        assertEquals(DockerAction.INSTALL, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseInstall()
    {
        DockerAction retrunValue = DockerAction.resolveAction("install");
        assertEquals(DockerAction.INSTALL, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseHealthStatus()
    {
        DockerAction retrunValue = DockerAction.resolveAction("HEALTH_STATUS");
        assertEquals(DockerAction.HEALTH_STATUS, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseHealthStatus()
    {
        DockerAction retrunValue = DockerAction.resolveAction("health_status");
        assertEquals(DockerAction.HEALTH_STATUS, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseKill()
    {
        DockerAction retrunValue = DockerAction.resolveAction("KILL");
        assertEquals(DockerAction.KILL, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseKill()
    {
        DockerAction retrunValue = DockerAction.resolveAction("kill");
        assertEquals(DockerAction.KILL, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseLoad()
    {
        DockerAction retrunValue = DockerAction.resolveAction("LOAD");
        assertEquals(DockerAction.LOAD, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseLoad()
    {
        DockerAction retrunValue = DockerAction.resolveAction("load");
        assertEquals(DockerAction.LOAD, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseMount()
    {
        DockerAction retrunValue = DockerAction.resolveAction("MOUNT");
        assertEquals(DockerAction.MOUNT, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseMount()
    {
        DockerAction retrunValue = DockerAction.resolveAction("mount");
        assertEquals(DockerAction.MOUNT, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseOom()
    {
        DockerAction retrunValue = DockerAction.resolveAction("OOM");
        assertEquals(DockerAction.OOM, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseOom()
    {
        DockerAction retrunValue = DockerAction.resolveAction("oom");
        assertEquals(DockerAction.OOM, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCasePause()
    {
        DockerAction retrunValue = DockerAction.resolveAction("PAUSE");
        assertEquals(DockerAction.PAUSE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCasePause()
    {
        DockerAction retrunValue = DockerAction.resolveAction("PAUSE");
        assertEquals(DockerAction.PAUSE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCasePull()
    {
        DockerAction retrunValue = DockerAction.resolveAction("PULL");
        assertEquals(DockerAction.PULL, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCasePull()
    {
        DockerAction retrunValue = DockerAction.resolveAction("pull");
        assertEquals(DockerAction.PULL, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseRename()
    {
        DockerAction retrunValue = DockerAction.resolveAction("RENAME");
        assertEquals(DockerAction.RENAME, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseRename()
    {
        DockerAction retrunValue = DockerAction.resolveAction("rename");
        assertEquals(DockerAction.RENAME, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseResize()
    {
        DockerAction retrunValue = DockerAction.resolveAction("RESIZE");
        assertEquals(DockerAction.RESIZE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseResize()
    {
        DockerAction retrunValue = DockerAction.resolveAction("resize");
        assertEquals(DockerAction.RESIZE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseRestart()
    {
        DockerAction retrunValue = DockerAction.resolveAction("RESTART");
        assertEquals(DockerAction.RESTART, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseRestart()
    {
        DockerAction retrunValue = DockerAction.resolveAction("restart");
        assertEquals(DockerAction.RESTART, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseRemove()
    {
        DockerAction retrunValue = DockerAction.resolveAction("REMOVE");
        assertEquals(DockerAction.REMOVE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseRemove()
    {
        DockerAction retrunValue = DockerAction.resolveAction("remove");
        assertEquals(DockerAction.REMOVE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseReload()
    {
        DockerAction retrunValue = DockerAction.resolveAction("RELOAD");
        assertEquals(DockerAction.RELOAD, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseReload()
    {
        DockerAction retrunValue = DockerAction.resolveAction("reload");
        assertEquals(DockerAction.RELOAD, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseSave()
    {
        DockerAction retrunValue = DockerAction.resolveAction("SAVE");
        assertEquals(DockerAction.SAVE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseSave()
    {
        DockerAction retrunValue = DockerAction.resolveAction("save");
        assertEquals(DockerAction.SAVE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseStart()
    {
        DockerAction retrunValue = DockerAction.resolveAction("START");
        assertEquals(DockerAction.START, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseStart()
    {
        DockerAction retrunValue = DockerAction.resolveAction("start");
        assertEquals(DockerAction.START, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseStop()
    {
        DockerAction retrunValue = DockerAction.resolveAction("STOP");
        assertEquals(DockerAction.STOP, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseStop()
    {
        DockerAction retrunValue = DockerAction.resolveAction("stop");
        assertEquals(DockerAction.STOP, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseTag()
    {
        DockerAction retrunValue = DockerAction.resolveAction("TAG");
        assertEquals(DockerAction.TAG, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseTag()
    {
        DockerAction retrunValue = DockerAction.resolveAction("tag");
        assertEquals(DockerAction.TAG, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseTop()
    {
        DockerAction retrunValue = DockerAction.resolveAction("TOP");
        assertEquals(DockerAction.TOP, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseTop()
    {
        DockerAction retrunValue = DockerAction.resolveAction("top");
        assertEquals(DockerAction.TOP, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseUntag()
    {
        DockerAction retrunValue = DockerAction.resolveAction("UNTAG");
        assertEquals(DockerAction.UNTAG, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseUntag()
    {
        DockerAction retrunValue = DockerAction.resolveAction("untag");
        assertEquals(DockerAction.UNTAG, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseUnpause()
    {
        DockerAction retrunValue = DockerAction.resolveAction("UNPAUSE");
        assertEquals(DockerAction.UNPAUSE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseUnpause()
    {
        DockerAction retrunValue = DockerAction.resolveAction("unpause");
        assertEquals(DockerAction.UNPAUSE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseUpdate()
    {
        DockerAction retrunValue = DockerAction.resolveAction("UPDATE");
        assertEquals(DockerAction.UPDATE, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseUpdate()
    {
        DockerAction retrunValue = DockerAction.resolveAction("update");
        assertEquals(DockerAction.UPDATE, retrunValue);
    }

    @Test
    public void testResolveActionWithUpperCaseUnmount()
    {
        DockerAction retrunValue = DockerAction.resolveAction("UNMOUNT");
        assertEquals(DockerAction.UNMOUNT, retrunValue);
    }

    @Test
    public void testResolveActionWithLowerCaseUnmount()
    {
        DockerAction retrunValue = DockerAction.resolveAction("unmount");
        assertEquals(DockerAction.UNMOUNT, retrunValue);
    }
}
