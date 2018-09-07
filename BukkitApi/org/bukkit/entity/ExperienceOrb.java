package org.bukkit.entity;

/**
 * 代表一个经验球.
 * <p>
 * 原文:
 * Represents an Experience Orb.
 */
public interface ExperienceOrb extends Entity {

    /**
     * 获取此经验球中所包含的经验
     * <p>
     * 原文:
     * Gets how much experience is contained within this orb
     *
     * @return 经验的数量
     */
    public int getExperience();

    /**
     * 设置此经验球中所包含的经验
     * <p>
     * 原文:
     * Sets how much experience is contained within this orb
     *
     * @param value 经验的数量
     */
    public void setExperience(int value);
}
