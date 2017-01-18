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
}