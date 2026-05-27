package org.bukkit.inventory.meta.tags;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataHolder;
import org.jetbrains.annotations.NotNull;

/**
 * 此接口表示 {@link ItemTagType} 可以序列化和反序列化传入值的上下文.
 *
 * @deprecated 此 API 部分已被 {@link PersistentDataHolder} 取代。请使用 {@link PersistentDataAdapterContext} 代替.
 */
@Deprecated(since = "1.14")
public interface ItemTagAdapterContext {

    /**
     * 创建一个新的空标签容器实例.
     * <p>
     * 原文：Creates a new and empty tag container instance.
     *
     * @return 新的容器实例
     */
    @NotNull
    CustomItemTagContainer newTagContainer();
}