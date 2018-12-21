package org.bukkit.entity;

/**
 * 代表僵尸.
 */
public interface Zombie extends Monster {

    /**
     * 获取这个僵尸是否为小僵尸.
     * <p>
     * 原文:
     * Gets whether the zombie is a baby
     *
     * @return 这个僵尸是否为小僵尸
     */
    public boolean isBaby();

    /**
     * 设置这个僵尸是否为小僵尸.
     * <p>
     * 原文:
     * Sets whether the zombie is a baby
     *
     * @param flag 这个僵尸是否为小僵尸
     */
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
     * @param flag
     * @deprecated must spawn {@link ZombieVillager}.
     */
    @Deprecated
    public void setVillager(boolean flag);

    /**
     * @param profession
     * @see ZombieVillager#getVillagerProfession()
     */
    @Deprecated
    public void setVillagerProfession(Villager.Profession profession);

    /**
     * @return profession
     * @see ZombieVillager#getVillagerProfession()
     */
    @Deprecated
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
}