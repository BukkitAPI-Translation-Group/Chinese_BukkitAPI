package org.bukkit.plugin;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * PluginLogger类是经过修改的{@link Logger}, 用途是在日志记录方法调用前
 * 加上记录日志的插件的名称. 本类提供的API与{@link Logger}完全一致.
 *
 * @see Logger
 */
public class PluginLogger extends Logger {
    private String pluginName;

    /**
     * 以指定插件创建一个新的 PluginLogger, 其插件名从插件对象中提取.
     * <p>
     * 原文:Creates a new PluginLogger that extracts the name from a plugin.
     *
     * @param context 插件对象
     */
    public PluginLogger(@NotNull Plugin context) {
        super(context.getClass().getCanonicalName(), null);
        String prefix = context.getDescription().getPrefix();
        pluginName = prefix != null ? new StringBuilder().append("[").append(prefix).append("] ").toString() : "[" + context.getDescription().getName() + "] ";
        setParent(context.getServer().getLogger());
        setLevel(Level.ALL);
    }

    @Override
    public void log(@NotNull LogRecord logRecord) {
        logRecord.setMessage(pluginName + logRecord.getMessage());
        super.log(logRecord);
    }

}
