package org.bukkit.entity;

/**
 * 代表一只疣猪兽。
 */
public interface Hoglin extends Animals, Enemy {

    /**
     * 获取疣猪兽是否免疫僵尸化.
     * <p>原文：Gets whether the hoglin is immune to zombification.
     *
     * @return 疣猪兽是否免疫僵尸化
     */
    public boolean isImmuneToZombification();

    /**
     * 设置疣猪兽是否免疫僵尸化.
     * <p>原文：Sets whether the hoglin is immune to zombification.
     *
     * @param flag 疣猪兽是否免疫僵尸化
     */
    public void setImmuneToZombification(boolean flag);

    /**
     * 获取疣猪兽是否能被猪灵猎杀.
     * <p>原文：Get whether the hoglin is able to be hunted by piglins.
     *
     * @return 疣猪兽是否能被猪灵猎杀
     */
    public boolean isAbleToBeHunted();

    /**
     * 设置疣猪兽是否能被猪灵猎杀.
     * <p>原文：Sets whether the hoglin is able to be hunted by piglins.
     *
     * @param flag 疣猪兽是否能被猪灵猎杀
     */
    public void setIsAbleToBeHunted(boolean flag);

    /**
     * 获取此实体转换为僵尸疣猪兽所需的刻数.
     * <p>原文：Gets the amount of ticks until this entity will be converted to a Zoglin.
     *
     * 当达到300刻时,该实体将会被转换.
     *
     * @return 转换所需时间
     * @throws IllegalStateException 如果 {@link #isConverting()} 为false
     */
    public int getConversionTime();

    /**
     * 设置此实体转换为僵尸疣猪兽所需的刻数.
     * <p>原文：Sets the amount of ticks until this entity will be converted to a Zoglin.
     *
     * 当达到0刻时,该实体将会被转换.小于0的值将停止当前的转换过程,而不会转换当前实体.
     *
     * @param time 新的转换时间
     */
    public void setConversionTime(int time);

    /**
     * 获取此实体是否正在转换为僵尸疣猪兽.
     * <p>原文：Get if this entity is in the process of converting to a Zoglin.
     *
     * @return 转换状态
     */
    boolean isConverting();
}
