package org.bukkit.event.player;

import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 玩家丢出鸡蛋时触发，鸡蛋可能孵化。
 */
public class PlayerEggThrowEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Egg egg;
    private boolean hatching;
    private EntityType hatchType;
    private byte numHatches;

    public PlayerEggThrowEvent(final Player player, final Egg egg, final boolean hatching, final byte numHatches, final EntityType hatchingType) {
        super(player);
        this.egg = egg;
        this.hatching = hatching;
        this.numHatches = numHatches;
        this.hatchType = hatchingType;
    }

    /**
     * 获取事件中的鸡蛋
     * <p>
     * 原文:
     *
     * @return 事件中的鸡蛋
     */
    public Egg getEgg() {
        return egg;
    }

    /**
     * 检测鸡蛋是否将被孵化。服务器可能设置无互动。
     * <p>
     * 原文:
     *
     * @return 布尔值 鸡蛋是否将被孵化
     */
    public boolean isHatching() {
        return hatching;
    }

    /**
     * 设置鸡蛋是否将被孵化。
     * <p>
     * 原文：
     *
     * @param hatching 布尔值，你是否希望鸡蛋孵化。
     */
    public void setHatching(boolean hatching) {
        this.hatching = hatching;
    }

    /**
     * 获取将被孵化的生物类型 (默认为EntityType.CHICKEN )
     * <p>
     * 原文:
     *
     * @return 将被孵化的生物类型
     */
    public EntityType getHatchingType() {
        return hatchType;
    }

    /**
     * 修改将被孵化生物的类型
     * <p>
     * 原文:
     *
     * @param hatchType 将被孵化生物的类型
     */
    public void setHatchingType(EntityType hatchType) {
        if(!hatchType.isSpawnable()) throw new IllegalArgumentException("Can't spawn that entity type from an egg!");
        this.hatchType = hatchType;
    }

    /**
     * 检测将被孵化生物的数量。默认由服务器进行设置。
     * <ul>
     * <li>7/8 几率不生成
     * <li>31/256 ~= 1/8 的几率生成 1 只
     * <li>1/256 的几率生成 4 只
     * </ul>
     * <p>
     * 原文:
     *
     * @return 将被孵化生物的数量
     */
    public byte getNumHatches() {
        return numHatches;
    }

    /**
     * 改变将被孵化生物的数量
     * <p>
     * 布尔值hatching(你是否希望鸡蛋孵化)的值将覆盖该数值的作用。
     * 当 hatching=false ，该数值的设定不生效。
     * <p>
     * 原文:
     * 
     *
     * @param numHatches 将被孵化生物的数量
     */
    public void setNumHatches(byte numHatches) {
        this.numHatches = numHatches;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}