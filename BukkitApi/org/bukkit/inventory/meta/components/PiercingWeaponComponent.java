package org.bukkit.inventory.meta.components;

import org.bukkit.Sound;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * 表示一个可以将任何物品转变为穿透武器的组件，该武器可以伤害多个实体。
 */
@ApiStatus.Experimental
public interface PiercingWeaponComponent extends ConfigurationSerializable {

    /**
     * 获取攻击是否会对目标造成击退效果。
     * <p>原文：Gets whether the attack deals knockback to the target.
     *
     * @return 如果有击退效果则返回true
     */
    boolean isDealsKnockback();

    /**
     * 设置攻击是否会对目标造成击退效果。
     * <p>原文：Sets whether the attack deals knockback to the target.
     *
     * @param knockback 如果有击退效果则为true
     */
    void setDealsKnockback(boolean knockback);

    /**
     * 获取攻击是否会使目标下马。
     * <p>原文：Gets whether the attack dismounts the target.
     *
     * @return 如果会使目标下马则返回true
     */
    boolean isDismounts();

    /**
     * 设置攻击是否会使目标下马。
     * <p>原文：Sets whether the attack dismounts the target.
     *
     * @param dismounts 如果会使目标下马则为true
     */
    void setDismounts(boolean dismounts);

    /**
     * 获取使用物品时播放的音效。
     * <p>原文：Gets the sound to play when the item is used.
     *
     * @return 音效
     */
    @Nullable
    Sound getSound();

    /**
     * 设置使用物品时播放的音效。
     * <p>原文：Sets the sound to play when the item is used.
     *
     * @param sound 音效或null表示使用当前默认值
     */
    void setSound(@Nullable Sound sound);

    /**
     * 获取物品成功击中目标时播放的音效。
     * <p>原文：Gets the sound to play when the item successfully hits a target.
     *
     * @return 音效
     */
    @Nullable
    Sound getHitSound();

    /**
     * 设置物品成功击中目标时播放的音效。
     * <p>原文：Sets the sound to play when the item successfully hits a target.
     *
     * @param sound 音效或null表示使用当前默认值
     */
    void setHitSound(@Nullable Sound sound);
}
