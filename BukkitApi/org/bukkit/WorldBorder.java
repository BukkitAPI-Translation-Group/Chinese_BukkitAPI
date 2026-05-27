package org.bukkit;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface WorldBorder {

    /**
     * 获取边界所在的 {@link World}.
     * <p>
     * 原文：Get the {@link World} in which the border resides.
     *
     * @return 关联的世界，如果此世界边界未关联任何特定世界则返回 null，例如通过 {@link Server#createWorldBorder()} 创建的边界
     */
    @Nullable
    public World getWorld();

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
     *
     * @throws IllegalArgumentException 如果 newSize 小于 1.0D 或大于 {@link #getMaxSize()}
     */
    public void setSize(double newSize);

    /**
     * 以方块为单位，将边界设置为一个指定长度的正方形.
     * <p>
     * 原文：Sets the border to a square region with the specified side length in blocks.
     * 
     * @param newSize 边界的新长度.
     * @param seconds 边界从先前大小增长或缩小到新大小所需的时间（秒）.
     *
     * @throws IllegalArgumentException 如果 newSize 小于 1.0D 或大于 {@link #getMaxSize()}
     */
    public void setSize(double newSize, long seconds);

    /**
     * 以方块为单位，将边界设置为一个指定长度的正方形.
     * <p>
     * 原文：Sets the border to a square region with the specified side length in blocks.
     *
     * @param newSize 边界的新长度.
     * @param unit 时间单位.
     * @param time 边界从先前大小增长或缩小到新大小所需的时间.
     *
     * @throws IllegalArgumentException 如果 unit 为 <code>null</code>，或 newSize 小于 1.0D 或大于 {@link #getMaxSize()}
     */
    public void setSize(double newSize, @NotNull TimeUnit unit, long time);

    /**
     * 得到当前边界的中心.
     * <p>
     * 原文:Gets the current border center.
     *
     * @return 当前边界的中心.
     */
    @NotNull
    public Location getCenter();

    /**
     * 设置新的边界中心.
     * <p>
     * 原文:Sets the new border center.
     *
     * @param x 新中心的x坐标.
     * @param z 新中心的z坐标.
     *
     * @throws IllegalArgumentException 如果 x 或 z 的绝对值大于 {@link #getMaxCenterCoordinate()}
     */
    public void setCenter(double x, double z);

    /**
     * 设置新的边界中心
     * <p>
     * 原文:Sets the new border center.
     *
     * @param location 边界新中心的位置. (该位置只包含x z)
     *
     * @throws IllegalArgumentException 如果 location 为 <code>null</code>，或 {@link Location#getX()} 或 {@link Location#getZ()} 的绝对值大于 {@link #getMaxCenterCoordinate()}
     */
    public void setCenter(@NotNull Location location);

    /**
     * 得到当前边界的破坏缓冲.
     * <p>
     * 原文：Gets the current border damage buffer.
     *
     * @return 当前边界的破坏缓存.
     */
    public double getDamageBuffer();

    /**
     * 设置玩家在越过结界后几个方块后受到伤害（也就是玩家越界后安全的范围），切忌填写负数参数
     * <P>
     * 原文：Sets the amount of blocks a player may safely be outside the border before taking damage.
     *
     * @param blocks 越过结界的缓冲方块数量，如果不设置的话默认是5个方块
     */
    public void setDamageBuffer(double blocks);

    /**
     * 获取越过结界后所受到的伤害值
     * <P>
     * 原文：Gets the current border damage amount.
     *
     * @return 返回越界后受到的伤害值.
     */
    public double getDamageAmount();

    /**
     * 设置越界后所受到的伤害值
     * <P> 
     * 原文：Sets the amount of damage a player takes when outside the border plus the border buffer.
     *
     * @param  damage 要设置的伤害值，默认的是超过一个方块一秒受到0.2伤害
     */
    public void setDamageAmount(double damage);

    /**
     * 获取临近结界的时候屏幕变红警告玩家的时间
     * <p>
     * 原文：Gets the current border warning time in seconds.
     *
     * @return 接近结界的时候警告玩家的秒数.
     */
    public int getWarningTime();

    /**
     * 设置玩家接近结界的时候警告玩家的秒数（警告也就是当玩家接近结界的时候，玩家的屏幕会被渲染成红色边框以此来警告玩家不要越界）
     * <p>
     * 原文：Sets the warning time that causes the screen to be tinted red when a contracting border will reach the player within the specified time.
     *
     * @param seconds 警告玩家的秒数，默认是15秒钟
     */
    public void setWarningTime(int seconds);

    /**
     * 获取玩家离方块多远时会被警告
     * <p>
     * 原文：Gets the current border warning distance.
     *
     * @return 离结界多少方块的时候会被警告
     */
    public int getWarningDistance();

    /**
     * 设置玩家离结界几个方块的时候会被警告
     * <p>
     * 原文：Sets the warning distance that causes the screen to be tinted red when the player is within the specified number of blocks from the border.
     *
     * @param distance 要设置玩家会被警告的距离
     */
    public void setWarningDistance(int distance);

    /**
     * 检查指定的位置是否在这个边界里面.
     * <p>
     * 原文:Check if the specified location is inside this border.
     *
     * @param location 要检查的位置
     * @return 指定的位置是否在这个边界里面
     */
    public boolean isInside(@NotNull Location location);

    /**
     * 获取世界边界的最大可能大小.
     * <p>
     * 原文：Gets the maximum possible size of a WorldBorder.
     *
     * @return 世界边界的最大大小
     */
    public double getMaxSize();

    /**
     * 获取世界边界最大 x/z 中心坐标的绝对值.
     * <p>
     * 原文：Gets the absolute value of the maximum x/z center coordinate of a WorldBorder.
     *
     * @return 世界边界的最大中心坐标绝对值
     */
    public double getMaxCenterCoordinate();
}
