package org.bukkit.block.data.type;

import org.bukkit.block.data.Orientable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 'creaking_heart_state' 表示方块当前的运行阶段.
 * <br>
 * 'natural' 表示这是否是自然生成的方块.
 */
@ApiStatus.Experimental
public interface CreakingHeart extends Orientable {

    /**
     * 获取 'active' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'active' property.
     *
     * @return 'active' 的值
     * @deprecated 使用 {@link #getCreakingHeartState()}
     */
    @Deprecated(since = "1.21.5")
    boolean isActive();

    /**
     * 设置 'active' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'active' property.
     *
     * @param active 新的 'active' 值
     * @deprecated 使用 {@link #setCreakingHeartState(org.bukkit.block.data.type.CreakingHeart.State)}
     */
    @Deprecated(since = "1.21.5")
    void setActive(boolean active);

    /**
     * 获取 'natural' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'natural' property.
     *
     * @return 'natural' 的值
     */
    boolean isNatural();

    /**
     * 设置 'natural' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'natural' property.
     *
     * @param natural 新的 'natural' 值
     */
    void setNatural(boolean natural);

    /**
     * 获取 'creaking_heart_state' 属性的值.
     * <p>
     * 原文：
     * Gets the value of the 'creaking_heart_state' property.
     *
     * @return 'creaking_heart_state' 的值
     */
    @NotNull
    State getCreakingHeartState();

    /**
     * 设置 'creaking_heart_state' 属性的值.
     * <p>
     * 原文：
     * Sets the value of the 'creaking_heart_state' property.
     *
     * @param state 新的 'creaking_heart_state' 值
     */
    void setCreakingHeartState(@NotNull State state);

    public enum State {

        UPROOTED,
        DORMANT,
        AWAKE;
    }
}
