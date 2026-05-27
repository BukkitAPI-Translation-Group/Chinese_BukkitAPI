package org.bukkit.inventory.view;

import org.bukkit.inventory.BeaconInventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 一个提供与信标视图数据相关额外方法的 {@link InventoryView} 实例。
 */
public interface BeaconView extends InventoryView {

    @NotNull
    @Override
    BeaconInventory getTopInventory();

    /**
     * 获取信标的等级。
     * <p>
     * 信标等级由其所在金字塔的高度推断得出。除非信标被激活，否则其等级为0。
     *
     * @return 信标的等级
     * <p>
     * 原文：Gets the tier of the beacon
     * <p>
     * Beacon tier is deduced by the height of the pyramid the beacon is
     * standing on. The level of the beacon is 0 unless the beacon is activated.
     *
     * @return The tier of the beacon
     */
    int getTier();

    /**
     * 获取信标的主要效果。
     * <p>
     * 如果信标等级足够高，主要效果可以升级到二级，例如速度II。此时
     * {@link #getSecondaryEffect()} 不会返回null，而是返回与本方法相同的
     * {@link PotionEffectType}。
     *
     * @return 信标上启用的主要效果
     * <p>
     * 原文：Gets the primary effect of the beacon.
     * <p>
     * If the beacon level is high enough where the primary effect can be
     * upgraded to level two, e.g. Speed 2. Instead of
     * {@link #getSecondaryEffect()} being null it {@link #getSecondaryEffect()}
     * returns the same {@link PotionEffectType} as this method.
     *
     * @return The primary effect enabled on the beacon
     */
    @Nullable
    PotionEffectType getPrimaryEffect();

    /**
     * 获取信标的次要效果。
     * <p>
     * 如果信标等级足够高，主要效果可以升级到二级，例如速度II。次要效果将返回与
     * {@link #getPrimaryEffect()} 相同的效果。
     *
     * @return 信标上启用的次要效果
     * <p>
     * 原文：Gets the secondary effect of the beacon.
     * <p>
     * If the beacon level is high enough where the primary effect can be
     * upgraded to level two, e.g. Speed 2. The secondary effect will return the
     * same effect as {@link #getPrimaryEffect()}.
     *
     * @return The secondary effect enabled on the beacon
     */
    @Nullable
    PotionEffectType getSecondaryEffect();

    /**
     * 设置信标的主要效果，或传入null以清除。
     * <p>
     * 提供的 {@link PotionEffectType} 必须是信标中已存在的有效选项之一。
     * <ol>
     * <li>{@link PotionEffectType#SPEED}
     * <li>{@link PotionEffectType#HASTE}
     * <li>{@link PotionEffectType#RESISTANCE}
     * <li>{@link PotionEffectType#JUMP_BOOST}
     * <li>{@link PotionEffectType#STRENGTH}
     * <li>{@link PotionEffectType#REGENERATION}
     * </ol>
     *
     * @param effect 期望的主要效果
     * <p>
     * 原文：Sets the primary effect of the beacon, or null to clear
     * <p>
     * The {@link PotionEffectType} provided must be one that is already within
     * the beacon as a valid option.
     * <ol>
     * <li>{@link PotionEffectType#SPEED}
     * <li>{@link PotionEffectType#HASTE}
     * <li>{@link PotionEffectType#RESISTANCE}
     * <li>{@link PotionEffectType#JUMP_BOOST}
     * <li>{@link PotionEffectType#STRENGTH}
     * <li>{@link PotionEffectType#REGENERATION}
     * </ol>
     *
     * @param effect desired primary effect
     */
    void setPrimaryEffect(@Nullable final PotionEffectType effect);

    /**
     * 设置信标的次要效果，或传入null以清除。注意，等级必须大于等于4且已设置主要效果，此效果才会激活。
     * <p>
     * 提供的 {@link PotionEffectType} 必须是信标中已存在的有效选项之一。
     * <ol>
     * <li>{@link PotionEffectType#SPEED}
     * <li>{@link PotionEffectType#HASTE}
     * <li>{@link PotionEffectType#RESISTANCE}
     * <li>{@link PotionEffectType#JUMP_BOOST}
     * <li>{@link PotionEffectType#STRENGTH}
     * <li>{@link PotionEffectType#REGENERATION}
     * </ol>
     *
     * @param effect 期望的次要效果
     * <p>
     * 原文：Sets the secondary effect on this beacon, or null to clear. Note that
     * tier must be &gt;= 4 and a primary effect must be set in order for this
     * effect to be active.
     * <p>
     * The {@link PotionEffectType} provided must be one that is already within
     * the beacon as a valid option.
     * <ol>
     * <li>{@link PotionEffectType#SPEED}
     * <li>{@link PotionEffectType#HASTE}
     * <li>{@link PotionEffectType#RESISTANCE}
     * <li>{@link PotionEffectType#JUMP_BOOST}
     * <li>{@link PotionEffectType#STRENGTH}
     * <li>{@link PotionEffectType#REGENERATION}
     * </ol>
     *
     * @param effect the desired secondary effect
     */
    void setSecondaryEffect(@Nullable final PotionEffectType effect);
}
