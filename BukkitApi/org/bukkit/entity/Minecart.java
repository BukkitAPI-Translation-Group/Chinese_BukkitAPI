package org.bukkit.entity;

import org.bukkit.GameRule;
import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表矿车实体.
 */
public interface Minecart extends Vehicle {

    /**
     * 设置对矿车的伤害.
     * <p>
     * 原文:Sets a minecart's damage.
     *
     * @param damage 超过40的伤害将"杀死"矿车
     */
    public void setDamage(double damage);

    /**
     * 获取对矿车的伤害.
     * <p>
     * 原文:Gets a minecart's damage.
     *
     * @return 伤害值
     */
    public double getDamage();

    /**
     * 获取矿车的最大速率. 这是速率不是速度.
     * <p>
     * 原文:Gets the maximum speed of a minecart. The speed is unrelated to the
     * velocity.
     *
     * @return 最大速率
     */
    public double getMaxSpeed();

    /**
     * 设置矿车的最大速率. 此值不能是负数(速率是标量). 默认值为0.4D或{@link GameRule#MAX_MINECART_SPEED}.
     * <p>
     * 原文:Sets the maximum speed of a minecart. Must be nonnegative. Default is
     * 0.4D or {@link GameRule#MAX_MINECART_SPEED}.
     *
     * @param speed 最大速率
     */
    public void setMaxSpeed(double speed);

    /**
     * 返回此矿车在无乘客乘坐时是否会加快减速 (可理解为有更大的负的加速度).
     * <p>
     * 原文:Returns whether this minecart will slow down faster without a passenger
     * occupying it
     *
     * @return 是否加快减速
     */
    public boolean isSlowWhenEmpty();

    /**
     * 设置此矿车在无乘客乘坐时是否会加快减速 (可理解为有更大的负的加速度).
     * <p>
     * 原文:Sets whether this minecart will slow down faster without a passenger
     * occupying it
     *
     * @param slow 是否加快减速
     */
    public void setSlowWhenEmpty(boolean slow);

    /**
     * Gets the flying velocity modifier. Used for minecarts that are in
     * mid-air. A flying minecart's velocity is multiplied by this factor each
     * tick.
     *
     * @return The vector factor
     */
    @NotNull
    public Vector getFlyingVelocityMod();

    /**
     * Sets the flying velocity modifier. Used for minecarts that are in
     * mid-air. A flying minecart's velocity is multiplied by this factor each
     * tick.
     *
     * @param flying velocity modifier vector
     */
    public void setFlyingVelocityMod(@NotNull Vector flying);

    /**
     * Gets the derailed velocity modifier. Used for minecarts that are on the
     * ground, but not on rails.
     * <p>
     * A derailed minecart's velocity is multiplied by this factor each tick.
     *
     * @return derailed visible speed
     */
    @NotNull
    public Vector getDerailedVelocityMod();

    /**
     * Sets the derailed velocity modifier. Used for minecarts that are on the
     * ground, but not on rails. A derailed minecart's velocity is multiplied
     * by this factor each tick.
     *
     * @param derailed visible speed
     */
    public void setDerailedVelocityMod(@NotNull Vector derailed);

    /**
     * 设置示在矿车中的方块.
     * 传递null值清除矿车中展示的方块.
     * <p>
     * 原文:Sets the display block for this minecart.
     * Passing a null value will set the minecart to have no display block.
     *
     * @param material 设置为展示方块的物品
     */
    public void setDisplayBlock(@Nullable MaterialData material);

    /**
     * 获取展示在矿车中的方块.
     * 如果矿车内无方块, 会返回AIR类型.
     * <p>
     * 原文:Gets the display block for this minecart.
     * This function will return the type AIR if none is set.
     *
     * @return 展示在矿车中的方块
     */
    @NotNull
    public MaterialData getDisplayBlock();

    /**
     * 设置展示在矿车中的方块.
     * 传递null值清除矿车中展示的方块.
     * <p>
     * 原文:Sets the display block for this minecart.
     * Passing a null value will set the minecart to have no display block.
     *
     * @param blockData 设置为展示方块的物品
     */
    public void setDisplayBlockData(@Nullable BlockData blockData);

    /**
     * 获取展示在矿车中的方块的方块数据.
     * 如果矿车内无方块, 会返回AIR类型.
     * <p>
     * 原文:Gets the display block for this minecart.
     * This function will return the type AIR if none is set.
     *
     * @return 展示在矿车中的方块
     */
    @NotNull
    public BlockData getDisplayBlockData();

    /**
     * 设置展示在矿车中的方块的偏移像素值.
     * <p>
     * 原文:Sets the offset of the display block.
     *
     * @param offset 展示在矿车中的方块的偏移像素值
     */
    public void setDisplayBlockOffset(int offset);

    /**
     * 获取展示在矿车中的方块的偏移像素值.
     * <p>
     * 原文:Gets the offset of the display block.
     *
     * @return 展示在矿车中的方块的偏移像素值
     */
    public int getDisplayBlockOffset();

    /**
     * Sets the multiplier of the minecart's acceleration while on powered
     * rails.
     *
     * @param multiplier a value of 1.0 is the default acceleration
     */
    public void setPoweredRailAccelerationMultiplier(double multiplier);

    /**
     * Gets the multiplier of the minecart's acceleration while on powered
     * rails.
     *
     * @return acceleration multiplier
     */
    public double getPoweredRailAccelerationMultiplier();
}
