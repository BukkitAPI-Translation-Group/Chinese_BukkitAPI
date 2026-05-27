package org.bukkit.entity;

/**
 * 代表一个可以被剪刀剪毛的实体.
 */
public interface Shearable {

    /**
     * 获取实体是否处于已剪毛状态.
     * <p>
     * 原文：
     * Gets whether the entity is in its sheared state.
     *
     * @return 实体是否已剪毛
     */
    boolean isSheared();

    /**
     * 设置实体是否处于已剪毛状态.
     * <p>
     * 原文：
     * Sets whether the entity is in its sheared state.
     *
     * @param flag 是否剪毛
     */
    void setSheared(boolean flag);
}
