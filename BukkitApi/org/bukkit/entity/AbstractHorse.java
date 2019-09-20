package org.bukkit.entity;

import org.bukkit.inventory.AbstractHorseInventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * 代表一个马基对象.
 * 译注: 基于马的对象,比如羊驼,驴.
 * <p>
 * 原文:
 * Represents a Horse-like creature.
 */
public interface AbstractHorse extends Animals, Vehicle, InventoryHolder, Tameable {

    /**
     * Gets the horse's variant.
     * <p>
     * A horse's variant defines its physical appearance and capabilities.
     * Whether a horse is a regular horse, donkey, mule, or other kind of horse
     * is determined using the variant.
     *
     * @return a {@link Horse.Variant} representing the horse's variant
     * @deprecated different variants are different classes
     */
    @Deprecated
    public Horse.Variant getVariant();

    /**
     * @param variant
     * @deprecated you are required to spawn a different entity
     */
    @Deprecated
    public void setVariant(Horse.Variant variant);

    /**
     * 获得此马的驯化等级.
     * <p>
     * 更高的驯化等级表明此马更容易被驯服, 当此马的驯化等级接近最高驯化等级时,驯服的几率会增加.
     * <p>
     * 原文:
     * Gets the domestication level of this horse.
     * <p>
     * A higher domestication level indicates that the horse is closer to
     * becoming tame. As the domestication level gets closer to the max
     * domestication level, the chance of the horse becoming tame increases.
     *
     * @return 驯化等级
     */
    public int getDomestication();

    /**
     
     * 设置此马的驯化等级.
     * <p>
     * 设置此马的驯化等级更高将让这匹马的驯化几率提升.
     * <p>
     * 驯化等级必须 大于0 且 小于最高驯化等级, 由 {@link #getMaxDomestication()} 定义.
     * <p>
     * 原文:
     * Sets the domestication level of this horse.
     * <p>
     * Setting the domestication level to a high value will increase the
     * horse's chances of becoming tame.
     * <p>
     * Domestication level must be greater than zero and no greater than
     * the max domestication level of the horse, determined with
     * {@link #getMaxDomestication()}
     *
     * @param level 驯化等级
     */
    public void setDomestication(int level);

    /**
     * 获得此马的最高驯化等级.
     * <p>
     * 此等级越高, 驯化的时间将会更长.
     * <p>
     * 原文:
     * Gets the maximum domestication level of this horse.
     * <p>
     * The higher this level is, the longer it will likely take
     * for the horse to be tamed.
     *
     * @return 最高驯化等级
     */
    public int getMaxDomestication();

    /**
     * 设置此马的最高驯化等级.
     * 设定一个更高的驯化等级将会增加需要驯化的次数(例如喂食, 骑乘), 反之减少.
     * <p>
     * 最高驯化等级必须大于0.
     * <p>
     * 原文:
     * Sets the maximum domestication level of this horse.
     * <p>
     * Setting a higher max domestication will increase the amount of
     * domesticating (feeding, riding, etc.) necessary in order to tame it,
     * while setting a lower max value will have the opposite effect.
     * <p>
     * Maximum domestication must be greater than zero.
     *
     * @param level 最高驯化等级
     */
    public void setMaxDomestication(int level);

    /**
     * 获得此马的跳跃强度.
     * <p>
     * 跳跃强度定义这匹马能跳多高. 更高的跳跃等级将增加跳跃高度.
     * <p>
     * 原文:
     * Gets the jump strength of this horse.
     * <p>
     * Jump strength defines how high the horse can jump. A higher jump strength
     * increases how high a jump will go.
     *
     * @return 跳跃等级
     */
    public double getJumpStrength();

    /**
     * 设置此马的跳跃强度.
     * <p>
     * 跳跃强度定义这匹马能跳多高. 更高的跳跃等级将增加跳跃高度.
     * 设置为0将导致马无法跳跃.
     * 只能设置0至2之间的数值.
     * <p>
     * 原文:
     * Sets the jump strength of this horse.
     * <p>
     * A higher jump strength increases how high a jump will go.
     * Setting a jump strength to 0 will result in no jump.
     * You cannot set a jump strength to a value below 0 or
     * above 2.
     *
     * @param strength 跳跃等级
     */
    public void setJumpStrength(double strength);

    @Override
    public AbstractHorseInventory getInventory();
}
