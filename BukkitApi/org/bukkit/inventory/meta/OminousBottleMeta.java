package org.bukkit.inventory.meta;

import org.jetbrains.annotations.NotNull;

/**
 * 代表不祥之瓶的物品元数据.
 * <p>
 * 原文:
 * Represents meta for an Ominous Bottle.
 */
public interface OminousBottleMeta extends ItemMeta {

    /**
     * 检查是否设置了不祥之瓶的厄运效果放大器.
     * <p>
     * 原文:
     * Checks for the presence of an amplifier.
     *
     * @return 如果设置了自定义的厄运效果放大器则返回 true
     */
    boolean hasAmplifier();

    /**
     * 获取不祥之瓶的厄运效果放大器等级.
     * <p>
     * 译注: 厄运效果(不祥之兆)的等级会影响突袭的波次.
     * <p>
     * 插件在调用此方法前应检查 hasAmplifier() 是否返回 true.
     * <p>
     * 原文:
     * Gets the amplifier amount for an Ominous Bottle's bad omen effect.
     * <p>
     * Plugins should check that hasAmplifier() returns true before calling this
     * method.
     *
     * @return 厄运效果放大器等级
     */
    int getAmplifier();

    /**
     * 设置不祥之瓶的厄运效果放大器等级.
     * <p>
     * 原文:
     * Sets the amplifier amount for an Ominous Bottle's bad omen effect.
     *
     * @param amplifier 厄运效果放大器等级, 应在 0 到 4 之间(包含边界)
     */
    void setAmplifier(int amplifier);

    @Override
    @NotNull
    OminousBottleMeta clone();
}