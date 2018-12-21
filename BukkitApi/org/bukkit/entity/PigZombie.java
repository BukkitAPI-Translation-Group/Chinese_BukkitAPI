package org.bukkit.entity;

/**
 * 代表僵尸猪人.
 */
public interface PigZombie extends Zombie {

    /**
     * 获取僵尸猪人当前的愤怒程度.
     * <p>
     * 原文:
     * Get the pig zombie's current anger level.
     *
     * @return 愤怒程度
     */
    int getAnger();

    /**
     * 设置僵尸猪人当前的愤怒程度.
     * <p>
     * 原文:
     * Set the pig zombie's current anger level.
     *
     * @param level 愤怒程度.更高的愤怒程度需要更多的时间来摆脱.
     */
    void setAnger(int level);

    /**
     * 将僵尸猪人的愤怒程度设置为0或默认等级.
     * <p>
     * 原文:
     * Shorthand; sets to either 0 or the default level.
     *
     * @param angry 僵尸猪人是否愤怒
     */
    void setAngry(boolean angry);

    /**
     * 获取僵尸是否愤怒.
     * <p>
     * 原文:
     * Shorthand; gets whether the zombie is angry.
     *
     * @return 僵尸猪人愤怒为true,否则为false
     */
    boolean isAngry();

    /**
     * <b>Not applicable to this entity</b>
     *
     * @return false
     */
    @Override
    public boolean isConverting();

    /**
     * <b>Not applicable to this entity</b>
     *
     * @return UnsuppotedOperationException
     */
    @Override
    public int getConversionTime();

    /**
     * <b>Not applicable to this entity</b>
     *
     * @param time unused
     */
    @Override
    public void setConversionTime(int time);
}