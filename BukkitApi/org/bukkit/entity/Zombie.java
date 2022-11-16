package org.bukkit.entity;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * 代表僵尸.
 */
public interface Zombie extends Monster, Ageable {

    /**
     * 获取这个僵尸是否为小僵尸.
     * <p>
     * 原文:
     * Gets whether the zombie is a baby
     *
     * @return 这个僵尸是否为小僵尸
     * @deprecated 另请参阅 {@link Ageable#isAdult()}
     */
    @Deprecated
    public boolean isBaby();

    /**
     * 设置这个僵尸是否为小僵尸.
     * <p>
     * 原文:
     * Sets whether the zombie is a baby
     *
     * @param flag 这个僵尸是否为小僵尸
     * @deprecated 另请参阅 {@link Ageable#setBaby()} 和 {@link Ageable#setAdult()}
     */
    @Deprecated
    public void setBaby(boolean flag);

    /**
     * 获取这个僵尸是否为村民僵尸.
     * <p>
     * 原文:
     * Gets whether the zombie is a villager
     *
     * @return 这个僵尸是否为村民僵尸
    * @deprecated 检查 instanceof {@link ZombieVillager} 的是与否.
     */
    @Deprecated
    public boolean isVillager();

    /**
     * @param flag flag
     * @deprecated must spawn {@link ZombieVillager}.
     */
    @Deprecated
    @Contract("_ -> fail")
    public void setVillager(boolean flag);

    /**
     * @param profession profession
     * @see ZombieVillager#getVillagerProfession()
     */
    @Deprecated
    @Contract("_ -> fail")
    public void setVillagerProfession(Villager.Profession profession);

    /**
     * @return profession
     * @see ZombieVillager#getVillagerProfession()
     */
    @Deprecated
    @Nullable
    @Contract("-> null")
    public Villager.Profession getVillagerProfession();

    /**
     * Get if this entity is in the process of converting to a Drowned as a
     * result of being underwater.
     *
     * @return conversion status
     */
    boolean isConverting();

    /**
     * Gets the amount of ticks until this entity will be converted to a Drowned
     * as a result of being underwater.
     *
     * When this reaches 0, the entity will be converted.
     *
     * @return conversion time
     * @throws IllegalStateException if {@link #isConverting()} is false.
     */
    int getConversionTime();

    /**
     * Sets the amount of ticks until this entity will be converted to a Drowned
     * as a result of being underwater.
     *
     * When this reaches 0, the entity will be converted. A value of less than 0
     * will stop the current conversion process without converting the current
     * entity.
     *
     * @param time new conversion time
     */
    void setConversionTime(int time);

    /**
     * 获得这个僵尸是否能破坏门.
     * <p>
     * 原文:
     * Gets whether this zombie can break doors
     *
     * @return 僵尸是否能破坏门
     */
    boolean canBreakDoors();

    /**
     * 设置僵尸是否能破坏门.
     *
     * 当实体是溺尸时将被忽略.当实体破坏门时也会停止破坏.
     * <p>
     * 原文:
     * Sets whether this zombie can break doors
     *
     * This will be ignored if the entity is a Drowned. Will also stop the action if
     * the entity is currently breaking a door.
     *
     * @param flag Whether this zombie can break doors
     */
    void setCanBreakDoors(boolean flag);
}