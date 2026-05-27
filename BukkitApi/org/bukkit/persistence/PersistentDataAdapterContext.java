package org.bukkit.persistence;

import org.jetbrains.annotations.NotNull;

/**
 * 此接口代表{@link PersistentDataType}可以序列化和反序列化传入值的上下文.
 */
public interface PersistentDataAdapterContext {

    /**
     * 创建一个新的空元数据容器实例.
     * <p>
     * 原文：
     * Creates a new and empty meta container instance.
     *
     * @return 新的容器实例
     */
    @NotNull
    PersistentDataContainer newPersistentDataContainer();
}
