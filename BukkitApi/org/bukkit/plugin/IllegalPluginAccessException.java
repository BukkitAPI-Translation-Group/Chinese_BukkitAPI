package org.bukkit.plugin;

/**
 * 当插件在未启用的状态下尝试与服务器交互时抛出异常
 */
@SuppressWarnings("serial")
public class IllegalPluginAccessException extends RuntimeException {

    /**
     * 创建一个没有细节信息的<code>IllegalPluginAccessException</code>实例.
     */
    public IllegalPluginAccessException() {}

    /**
     * 创建一个有错误细节的<code>IllegalPluginAccessException</code>实例.
     *
     * @param msg 细节信息
     */
    public IllegalPluginAccessException(String msg) {
        super(msg);
    }
}
