package org.bukkit.persistence;

import org.jetbrains.annotations.NotNull;

/**
 * {@link PersistentDataHolder} 接口定义了一个可以在其上存储自定义持久元数据的对象。
 */
public interface PersistentDataHolder {

    /**
     * 返回一个可以在对象上存储标签的自定义标签容器。
     * <p>
     * 原文：
     * Returns a custom tag container capable of storing tags on the object.
     *
     * Note that the tags stored on this container are all stored under their
     * own custom namespace therefore modifying default tags using this
     * {@link PersistentDataHolder} is impossible.
     *
     * @return 持久元数据容器
     */
    @NotNull
    PersistentDataContainer getPersistentDataContainer();

}
