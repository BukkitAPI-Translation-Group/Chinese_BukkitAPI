package org.bukkit.inventory.meta.components;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 表示一个决定使用此物品时动画的组件。
 */
@ApiStatus.Experimental
public interface SwingAnimationComponent extends ConfigurationSerializable {

    /**
     * 获取动画类型。
     * <p>原文：Gets the animation type.
     *
     * @return 动画类型
     */
    @NotNull
    Type getType();

    /**
     * 设置动画类型。
     * <p>原文：Sets the animation type.
     *
     * @param type 动画类型
     */
    void setType(@NotNull Type type);

    /**
     * 获取动画持续时间。
     * <p>原文：Gets the animation duration.
     *
     * @return 动画持续时间（以刻为单位）
     */
    int getDuration();

    /**
     * 设置动画持续时间。
     * <p>原文：Sets the animation duration.
     *
     * @param ticks 持续时间（以刻为单位）
     */
    void setDuration(int ticks);

    /**
     * 不同类型的动画。
     */
    public enum Type {

        /**
         * 无动画。
         */
        NONE,
        /**
         * 挥击动画。
         */
        WHACK,
        /**
         * 刺击动画。
         */
        STAB;
    }
}
