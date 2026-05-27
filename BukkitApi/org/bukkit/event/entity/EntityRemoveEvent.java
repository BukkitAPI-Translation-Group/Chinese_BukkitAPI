package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当 {@link Entity} 被移除时调用。
 * <p>
 * 此事件仅应用于监控。在此事件期间或之后修改实体的结果是未指定的。
 * 此事件不会为 {@link org.bukkit.entity.Player} 调用。
 */
public class EntityRemoveEvent extends EntityEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Cause cause;

    public EntityRemoveEvent(@NotNull Entity what, @NotNull Cause cause) {
        super(what);
        this.cause = cause;
    }

    /**
     * 获取实体被移除的原因。
     * <p>
     * 原文：
     * Gets the cause why the entity got removed.
     *
     * @return 实体被移除的原因
     */
    @NotNull
    public Cause getCause() {
        return cause;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 表示实体被移除的各种方式。
     */
    public enum Cause {
        /**
         * 当实体死亡时。
         */
        DEATH,
        /**
         * 当实体消失时。这包括距离太远的生物、在地面上放置时间过长的物品或箭矢，或区域效果云。
         */
        DESPAWN,
        /**
         * 当实体因作为物品掉落而被移除时。
         * 例如，三叉戟或下落的沙子。
         * <p>
         * <b>注意：</b> 根据其他因素，如游戏规则，实际上可能不会掉落物品，但原因仍然是掉落。
         */
        DROP,
        /**
         * 当实体因进入方块而被移除时。
         * 例如，蜜蜂或蠹虫。
         */
        ENTER_BLOCK,
        /**
         * 当实体因爆炸而被移除时。
         * 例如，苦力怕、TNT 或烟花火箭。
         */
        EXPLODE,
        /**
         * 当实体因击中某物而被移除时。这主要适用于弹射物。
         */
        HIT,
        /**
         * 当实体因与另一个实体合并而被移除时。
         * 例如，物品或经验值。
         */
        MERGE,
        /**
         * 当实体因位于世界底部以下而被移除时。
         * 这仅适用于立即被移除的实体，有些实体会受到伤害。
         */
        OUT_OF_WORLD,
        /**
         * 当实体因被拾取而被移除时。
         * 例如，物品、箭矢、经验值或落在玩家肩膀上的鹦鹉。
         */
        PICKUP,
        /**
         * 当实体因玩家退出游戏而与玩家一起被移除时。
         * 例如，玩家退出时与玩家一起被移除的船。
         */
        PLAYER_QUIT,
        /**
         * 当插件手动移除实体时。
         */
        PLUGIN,
        /**
         * 当实体因转化为另一个实体而被移除时。
         */
        TRANSFORMATION,
        /**
         * 当实体所在的区块被卸载时。
         */
        UNLOAD,
    }
}
