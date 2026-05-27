package org.bukkit.inventory.meta.components.consumable;

import java.util.List;
import org.bukkit.Sound;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.meta.components.consumable.effects.ConsumableEffect;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示一个物品可以在使用时被消耗的组件。
 */
@ApiStatus.Experimental
public interface ConsumableComponent extends ConfigurationSerializable {

    /**
     * 获取消耗此物品所需的时间（以秒为单位）。
     * <p>原文：Gets the time in seconds it will take for this item to be consumed.
     *
     * @return 消耗时间
     */
    float getConsumeSeconds();

    /**
     * 设置消耗此物品所需的时间（以秒为单位）。
     * <p>原文：Sets the time in seconds it will take for this item to be consumed.
     *
     * @param consumeSeconds 新的消耗时间
     */
    void setConsumeSeconds(float consumeSeconds);

    /**
     * 获取消耗物品时使用的动画。
     * <p>原文：Gets the animation used during consumption of the item.
     *
     * @return 动画
     */
    @NotNull
    Animation getAnimation();

    /**
     * 设置消耗物品时使用的动画。
     * <p>原文：Sets the animation used during consumption of the item.
     *
     * @param animation 新的动画
     */
    void setAnimation(@NotNull Animation animation);

    /**
     * 获取在物品消耗期间和完成时播放的音效。
     * <p>原文：Gets the sound to play during and on completion of the item's consumption.
     *
     * @return 音效
     */
    @Nullable
    Sound getSound();

    /**
     * 设置在物品消耗期间和完成时播放的音效。
     * <p>原文：Sets the sound to play during and on completion of the item's consumption.
     *
     * @param sound 音效或null表示使用当前默认值
     */
    void setSound(@Nullable Sound sound);

    /**
     * 获取消耗此物品时是否发射消耗粒子。
     * <p>原文：Gets whether consumption particles are emitted while consuming this item.
     *
     * @return 如果消耗时发射粒子则返回true，否则返回false
     */
    boolean hasConsumeParticles();

    /**
     * 设置消耗此物品时是否发射消耗粒子。
     * <p>原文：Sets whether consumption particles are emitted while consuming this item.
     *
     * @param consumeParticles 消耗物品时是否需要发射粒子
     */
    void setConsumeParticles(boolean consumeParticles);

    /**
     * 获取消耗此物品时可能应用的效果。
     * <p>原文：Gets the effects which may be applied by this item when consumed.
     *
     * @return 消耗效果
     */
    @NotNull
    List<ConsumableEffect> getEffects();

    /**
     * 设置消耗此物品时可能应用的效果。
     * <p>原文：Sets the effects which may be applied by this item when consumed.
     *
     * @param effects 新的效果
     */
    void setEffects(@NotNull List<ConsumableEffect> effects);

    /**
     * 添加一个消耗此物品时可能应用的效果。
     * <p>原文：Adds an effect which may be applied by this item when consumed.
     *
     * @param effect 效果
     * @return 添加的效果
     */
    @NotNull
    ConsumableEffect addEffect(@NotNull ConsumableEffect effect);

    /**
     * 表示物品被消耗时的动画。
     */
    public enum Animation {

        DRINK,
        EAT,
        NONE,
        BLOCK,
        BOW,
        BRUSH,
        CROSSBOW,
        SPEAR,
        SPYGLASS,
        TOOT_HORN;
    }
}
