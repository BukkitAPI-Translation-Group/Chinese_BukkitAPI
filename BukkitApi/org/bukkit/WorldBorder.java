package org.bukkit;

public interface WorldBorder {

    /**
     * 将世界的边界恢复为默认值.
     * <p>
     * 原文:Resets the border to default values.
     */
    public void reset();

    /**
     * 获得指定世界当前的边界长度.
     * <p>
     * 原文:Gets the current side length of the border.
     * 
     * @return 世界的当前边界长度.
     */
    public double getSize();

    /**
     * 以方块为单位，将边界设置为一个指定长度的正方形.
     * <p>
     * 原文:Sets the border to a square region with the specified side length in blocks.
     * 
     * @param newSize 边界的新长度.
     */
    public void setSize(double newSize);

    /**
     * 以方块为单位，将边界设置为一个指定长度的正方形.
     * <p>
     * 原文:Sets the border to a square region with the specified side length in blocks.
     * 
     * @param newSize 边界的新长度.
     * @param seconds The time in seconds in which the border grows or shrinks from the previous size to that being set.
     */
    public void setSize(double newSize, long seconds);

    /**
     * 得到当前边界的中心.
     * <p>
     * 原文:Gets the current border center.
     *
     * @return 当前边界的中心.
     */
    public Location getCenter();

    /**
     * 设置新的边界中心.
     * <p>
     * 原文:Sets the new border center.
     *
     * @param x 新中心的x坐标.
     * @param z 新中心的z坐标.
     */
    public void setCenter(double x, double z);

    /**
     * 设置新的边界中心
     * <p>
     * 原文:Sets the new border center.
     *
     * @param location 边界新中心的位置. (该位置只包含x z)
     */
    public void setCenter(Location location);

    /**
     * 得到当前边界的破坏缓冲.
     * <p>
     * 原文：Gets the current border damage buffer.
     *
     * @return 当前边界的破坏缓存.
     */
    public double getDamageBuffer();

    /**
     * Sets the amount of blocks a player may safely be outside the border before taking damage.
     *
     * @param blocks The amount of blocks. (The default is 5 blocks.)
     */
    public void setDamageBuffer(double blocks);

    /**
     * Gets the current border damage amount.
     *
     * @return The current border damage amount.
     */
    public double getDamageAmount();

    /**
     * Sets the amount of damage a player takes when outside the border plus the border buffer.
     *
     * @param damage The amount of damage. (The default is 0.2 damage per second per block.)
     */
    public void setDamageAmount(double damage);

    /**
     * Gets the current border warning time in seconds.
     *
     * @return The current border warning time in seconds.
     */
    public int getWarningTime();

    /**
     * Sets the warning time that causes the screen to be tinted red when a contracting border will reach the player within the specified time.
     *
     * @param seconds The amount of time in seconds. (The default is 15 seconds.)
     */
    public void setWarningTime(int seconds);

    /**
     * Gets the current border warning distance.
     *
     * @return The current border warning distance.
     */
    public int getWarningDistance();

    /**
     * Sets the warning distance that causes the screen to be tinted red when the player is within the specified number of blocks from the border.
     *
     * @param distance The distance in blocks. (The default is 5 blocks.)
     */
    public void setWarningDistance(int distance);
}