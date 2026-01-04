package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表可被拴住的实体.
 */
public interface Leashable {

    /**
     * 返回实体当前是否被拴住.
     * <p>
     * 原文：
     * Returns whether the entity is currently leashed.
     *
     * @return 实体是否被拴住
     */
    public boolean isLeashed();

    /**
     * 获取当前牵引此实体的实体.
     * <p>
     * 原文：
     * Gets the entity that is currently leading this entity.
     *
     * @return 握持拴绳的实体
     * @throws IllegalStateException 如果当前实体没被拴住则抛出异常
     */
    @NotNull
    public Entity getLeashHolder() throws IllegalStateException;

    /**
     * 设置握持拴绳的实体.
     * <p>
     * 此方法对末影龙，凋零，玩家或蝙蝠无效。除拴绳外的非生物实体将不会像握持拴绳者一样持续存在.
     * <p>
     * 原文：
     * Sets the leash on this entity to be held by the supplied entity.
     * <p>
     * This method has no effect on EnderDragons, Withers, Players, or Bats.
     * Non-living entities excluding leashes will not persist as leash
     * holders.
     *
     * @param holder 握持拴绳的实体
     * @return 操作是否成功
     */
    public boolean setLeashHolder(@Nullable Entity holder);
}
