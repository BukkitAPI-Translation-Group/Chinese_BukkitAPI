package org.bukkit;

import org.jetbrains.annotations.NotNull;

/**
 * 代表附加了 {@link NamespacedKey} 的对象.
 */
public interface Keyed {

    /**
     * 返回用于此对象的命名空间标识符.
     * <p>
     * 原文:Return the namespaced identifier for this object.
     *
     * @return 标识此对象的 key
     */
    @NotNull
    NamespacedKey getKey();
}
