package org.bukkit.plugin;

import java.util.Set;

/**
 * 表示插件所感知的概念.
 * <p>
 * 内部表示可以是单例或参数化实例, 但必须是不可变的.
 */
public interface PluginAwareness {
    /**
     * 此处每个条目代表一个特定的插件感知. 可以通过 {@link PluginDescriptionFile#getAwareness()}.{@link Set#contains(Object) contains(flag)} 进行检查.
     */
    public enum Flags implements PluginAwareness {
        /**
         * 指定插件 jar 中存储的所有 (文本) 资源使用 UTF-8 编码.
         *
         * @deprecated 现在假定所有插件都具有 UTF-8 感知能力.
         */
        @Deprecated(since = "1.9")
        UTF8,
        ;
    }
}