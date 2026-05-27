package org.bukkit.entity;

/**
 * 代表一只疣猪兽。
 */
public interface Hoglin extends Animals, Enemy {

    /**
     * 获取疣猪兽是否免疫僵尸化。
     * <p>原文：Gets whether the hoglin is immune to zombification.
     *
     * @return Whether the hoglin is immune to zombification
     */
    public boolean isImmuneToZombification();

    /**
     * 设置疣猪兽是否免疫僵尸化。
     * <p>原文：Sets whether the hoglin is immune to zombification.
     *
     * @param flag Whether the hoglin is immune to zombification
     */
    public void setImmuneToZombification(boolean flag);

    /**
     * 获取疣猪兽是否能被猪灵猎杀。
     * <p>原文：Get whether the hoglin is able to be hunted by piglins.
     *
     * @return Whether the hoglin is able to be hunted by piglins
     */
    public boolean isAbleToBeHunted();

    /**
     * 设置疣猪兽是否能被猪灵猎杀。
     * <p>原文：Sets whether the hoglin is able to be hunted by piglins.
     *
     * @param flag Whether the hoglin is able to be hunted by piglins.
     */
    public void setIsAbleToBeHunted(boolean flag);

    /**
     * 获取此实体转换为僵尸疣猪兽所需的刻数。
     * <p>原文：Gets the amount of ticks until this entity will be converted to a Zoglin.
     *
     * When this reaches 300, the entity will be converted.
     *
     * @return conversion time
     * @throws IllegalStateException if {@link #isConverting()} is false.
     */
    public int getConversionTime();

    /**
     * 设置此实体转换为僵尸疣猪兽所需的刻数。
     * <p>原文：Sets the amount of ticks until this entity will be converted to a Zoglin.
     *
     * When this reaches 0, the entity will be converted. A value of less than 0
     * will stop the current conversion process without converting the current
     * entity.
     *
     * @param time new conversion time
     */
    public void setConversionTime(int time);

    /**
     * 获取此实体是否正在转换为僵尸疣猪兽。
     * <p>原文：Get if this entity is in the process of converting to a Zoglin.
     *
     * @return conversion status
     */
    boolean isConverting();
}
