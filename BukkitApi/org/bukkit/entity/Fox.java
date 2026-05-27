package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表狐狸.
 * <p>
 * 原文:
 * What does the fox say?
 */
public interface Fox extends Animals, Sittable {

    /**
     * 获取此狐狸品种.
     * <p>
     * 原文:
     * Gets the current type of this fox.
     *
     * @return 狐狸品种.
     */
    @NotNull
    public Type getFoxType();

    /**
     * 设置狐狸的品种.
     * <p>
     * 原文:
     * Sets the current type of this fox.
     *
     * @param type 要设置的新品种.
     */
    public void setFoxType(@NotNull Type type);

    /**
     * 判断是否蜷缩.
     * <p>
     * 原文:
     * Checks if this animal is crouching
     *
     * @return 蜷缩中返回true.
     */
    boolean isCrouching();

    /**
     * 设置是否蜷缩.
     * <p>
     * 原文:
     * Sets if this animal is crouching.
     *
     * @param crouching 设置为true则蜷缩.
     */
    void setCrouching(boolean crouching);

    /**
     * 设置是否正在睡觉.
     * <p>
     * 原文:
     * Sets if this animal is sleeping.
     *
     * @param sleeping 设置为true则进入睡眠状态
     */
    void setSleeping(boolean sleeping);

    /**
     * 获取第一个受信任的玩家.
     * <p>
     * 原文:
     * Gets the first trusted player.
     *
     * @return 拥有此狐狸的 AnimalTamer，若无则返回 null.
     */
    @Nullable
    public AnimalTamer getFirstTrustedPlayer();

    /**
     * 设置第一个受信任的玩家.
     * <p>
     * 第一个受信任的玩家只能在第二个之后被移除.
     * <p>
     * 原文:
     * Set the first trusted player.
     * <p>
     * The first trusted player may only be removed after the second.
     *
     * @param player 要信任的 AnimalTamer.
     */
    public void setFirstTrustedPlayer(@Nullable AnimalTamer player);

    /**
     * 获取第二个受信任的玩家.
     * <p>
     * 原文:
     * Gets the second trusted player.
     *
     * @return 拥有此狐狸的 AnimalTamer，若无则返回 null.
     */
    @Nullable
    public AnimalTamer getSecondTrustedPlayer();

    /**
     * 设置第二个受信任的玩家.
     * <p>
     * 第二个受信任的玩家只能在第一个之后被添加.
     * <p>
     * 原文:
     * Set the second trusted player.
     * <p>
     * The second trusted player may only be added after the first.
     *
     * @param player 要信任的 AnimalTamer.
     */
    public void setSecondTrustedPlayer(@Nullable AnimalTamer player);

    /**
     * 判断狐狸是否正在面部朝地.
     * <p>
     * 原文:
     * Gets whether the fox is faceplanting the ground.
     *
     * @return 如果狐狸正在面部朝地则返回 true.
     */
    boolean isFaceplanted();

    /**
     * 代表各种狐狸品种.
     * <p>
     * 原文:
     * Represents the various different fox types there are.
     */
    public enum Type {
        RED,
        SNOW;
    }
}
