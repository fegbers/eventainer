package de.fegbers.eventainer.domain;

public enum DockerAction
{
    ATTACH,

    COMMIT,

    COPY,

    CREATE,

    CONNECT,

    DESTROY,

    DETACH,

    DELETE,

    DIE,

    DISABLE,

    DISCONNECT,

    ENABLE,

    EXEC_CREATE,

    EXEC_DETACH,

    EXEC_START,

    EXPORT,

    IMPORT,

    INSTALL,

    HEALTH_STATUS,

    KILL,

    LOAD,

    MOUNT,

    OOM,

    PAUSE,

    PUSH,

    PULL,

    RENAME,

    RESIZE,

    RESTART,

    REMOVE,

    RELOAD,

    SAVE,

    START,

    STOP,

    TAG,

    TOP,

    UNTAG,

    UNPAUSE,

    UPDATE,

    UNMOUNT;

    public static DockerAction resolveAction(String action)
    {
        for (DockerAction a : DockerAction.values())
        {
            if (a.name().equalsIgnoreCase(action))
            {
                return a;
            }
        }
        throw new IllegalArgumentException("Unsupported action");
    }
}
