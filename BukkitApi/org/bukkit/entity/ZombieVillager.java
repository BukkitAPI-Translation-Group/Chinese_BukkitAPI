package org.bukkit.entity;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示曾经是{@link Villager}的{@link Zombie}。
 */
public interface ZombieVillager extends Zombie {

    /**
     * 设置此僵尸的村民职业。
     * <p>
     * 原文：Sets the villager profession of this zombie.
     */
    @Override
    void setVillagerProfession(@Nullable Villager.Profession profession);

    /**
     * 返回此僵尸的村民职业。
     *
     * @return 职业或null
     * <p>
     * 原文：Returns the villager profession of this zombie.
     *
     * @return the profession or null
     */
    @Override
    @Nullable
    Villager.Profession getVillagerProfession();

    /**
     * 获取此村民的当前类型。
     *
     * @return 当前类型。
     * <p>
     * 原文：Gets the current type of this villager.
     *
     * @return Current type.
     */
    @NotNull
    public Villager.Type getVillagerType();

    /**
     * 设置此村民的新类型。
     *
     * @param type 新类型。
     * <p>
     * 原文：Sets the new type of this villager.
     *
     * @param type New type.
     */
    public void setVillagerType(@NotNull Villager.Type type);

    /**
     * 获取此实体是否正在因被治愈而转换为村民。
     *
     * @return 转换状态
     * <p>
     * 原文：Get if this entity is in the process of converting to a Villager as a
     * result of being cured.
     *
     * @return conversion status
     */
    @Override
    boolean isConverting();

    /**
     * 获取此实体因被治愈而转换为村民的剩余刻数。
     *
     * 当此值达到0时，实体将被转换。
     *
     * @return 转换时间
     * @throws IllegalStateException 如果{@link #isConverting()}为false。
     * <p>
     * 原文：Gets the amount of ticks until this entity will be converted to a
     * Villager as a result of being cured.
     *
     * When this reaches 0, the entity will be converted.
     *
     * @return conversion time
     * @throws IllegalStateException if {@link #isConverting()} is false.
     */
    @Override
    int getConversionTime();

    /**
     * 设置此实体因被治愈而转换为村民的剩余刻数。
     *
     * 当此值达到0时，实体将被转换。小于0的值将停止当前转换过程，而不会转换当前实体。
     *
     * @param time 新转换时间
     * <p>
     * 原文：Sets the amount of ticks until this entity will be converted to a
     * Villager as a result of being cured.
     *
     * When this reaches 0, the entity will be converted. A value of less than 0
     * will stop the current conversion process without converting the current
     * entity.
     *
     * @param time new conversion time
     */
    @Override
    void setConversionTime(int time);

    /**
     * 获取发起转换的玩家。
     *
     * @return 玩家，如果玩家未知或实体当前未在转换则返回<code>null</code>
     * <p>
     * 原文：Gets the player who initiated the conversion.
     *
     * @return the player, or <code>null</code> if the player is unknown or the
     * entity isn't converting currently
     */
    @Nullable
    OfflinePlayer getConversionPlayer();

    /**
     * 设置发起转换的玩家。
     * <p>
     * 如果此实体当前未在转换，则此方法无效。
     *
     * @param conversionPlayer 玩家
     * <p>
     * 原文：Sets the player who initiated the conversion.
     * <p>
     * This has no effect if this entity isn't converting currently.
     *
     * @param conversionPlayer the player
     */
    void setConversionPlayer(@Nullable OfflinePlayer conversionPlayer);
}
