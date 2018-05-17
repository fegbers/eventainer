package de.fegbers.eventainer.domain;

/**
 * Container<br>
 * <li>attach</li>
 * <li>commit</li>
 * <li>copy</li>
 * <li>create</li>
 * <li>destroy</li>
 * <li>detach</li>
 * <li>die</li>
 * <li>exec_create</li>
 * <li>exec_detach</li>
 * <li>exec_start</li>
 * <li>exec_die</li>
 * <li>export</li>
 * <li>health_status</li>
 * <li>kill</li>
 * <li>oom</li>
 * <li>pause</li>
 * <li>rename</li>
 * <li>resize</li>
 * <li>restart</li>
 * <li>start</li>
 * <li>stop</li>
 * <li>top</li>
 * <li>unpause</li>
 * <li>update</li><br>
 * Images<br>
 * <li>delete</li>
 * <li>import</li>
 * <li>load</li>
 * <li>pull</li>
 * <li>push</li>
 * <li>save</li>
 * <li>tag</li>
 * <li>untag</li><br>
 * Volumes<br>
 * <li>create</li>
 * <li>mount</li>
 * <li>unmount</li>
 * <li>destroy</li><br>
 * Networks<br>
 * <li>create</li>
 * <li>connect</li>
 * <li>disconnect</li>
 * <li>destroy</li>
 * <li>update</li>
 * <li>remove</li><br>
 * Deamon<br>
 * <li>reload</li><br>
 * Services<br>
 * <li>create</li>
 * <li>update</li>
 * <li>remove</li></br>
 * Nodes<br>
 * <li>create</li>
 * <li>update</li>
 * <li>remove</li></br>
 * Secrets<br>
 * <li>create</li>
 * <li>update</li>
 * <li>remove</li></br>
 * Configs<br>
 * <li>create</li>
 * <li>update</li>
 * <li>remove</li></br>
 * Plugins<br>
 * <li>disable</li>
 * <li>enable</li>
 * <li>install</li>
 * <li>remove</li>
 */
public enum DockerType
{
    CONTAINER,
    IMAGE,
    VOLUME,
    NETWORK,
    DAEMON,
    PLUGIN,
    NODE,
    SERVICE,
    SECRET,
    CONFIG;

    public static DockerType resolveType(String type)
    {
        for (DockerType t : DockerType.values())
        {
            if (t.name().equalsIgnoreCase(type))
            {
                return t;
            }
        }
        throw new IllegalArgumentException("Usupported type");
    }
}
