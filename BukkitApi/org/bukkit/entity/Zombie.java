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
     */
    public boolean isVillager();

    /**
     * 设置这个僵尸是否为村民僵尸
     * <p>
     * 原文:
     * Sets whether the zombie is a villager
     *
     * @param flag 这个僵尸是否为村民僵尸
     * @deprecated 默认是{@link Villager.Profession#NORMAL}
     */
    @Deprecated
    public void setVillager(boolean flag);

    /**
     * Sets whether the zombie is a villager
     *
     * @param profession the profession of the villager or null to clear
     */
    public void setVillagerProfession(Villager.Profession profession);

    /**
     * Returns the villager profession of the zombie if the
     * zombie is a villager
     *
     * @return the profession or null
     */
    public Villager.Profession getVillagerProfession();
}