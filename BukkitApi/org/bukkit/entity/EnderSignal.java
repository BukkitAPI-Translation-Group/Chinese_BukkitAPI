package org.bukkit.entity;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

/**
 * 代表抛出的末影之眼.
 */
public interface EnderSignal extends Entity {

    /**
     * 获取末影之眼移向的位置.
     * <p>
     * 原文:Get the location this EnderSignal is moving towards.
     *
     * @return 末影之眼移向的{@link Location 位置}
     */
    @NotNull
    public Location getTargetLocation();

    /**
     * 设置末影之眼移向的位置.
     * <br>
     * 当设置了新的目标地点时, {@link #getDropItem()}将被重置为一个随机值
     * , 其消失时间将重置为0.
     * <p>
     * 原文:Set the {@link Location} this EnderSignal is moving towards.
     * <br>
     * When setting a new target location, the {@link #getDropItem()} resets to
     * a random value and the despawn timer gets set back to 0.
     *
     * @param location 新目标位置
     */
    public void setTargetLocation(@NotNull Location location);

    /**
     * 获取末影之眼最终是否会掉落为物品.<br>
     * 如果为true, 将为掉落为物品, 反之它会破碎并湮灭.
     * <p>
     * 原文:Gets if the EnderSignal should drop an item on death.<br>
     * If {@code true}, it will drop an item. If {@code false}, it will shatter.
     *
     * @return 末影之眼最终是否会掉落为物品
     */
    public boolean getDropItem();

    /**
     * 设置末影之眼最终是否会掉落为物品, 亦或是湮灭于空气中.
     * <p>
     * 原文:Sets if the EnderSignal should drop an item on death; or if it should
     * shatter.
     *
     * @param drop 末影之眼最终是否会掉落为物品
     */
    public void setDropItem(boolean drop);

    /**
     * 获取末影之眼已在空气漂浮的时间 (单位为tick).
     * <br>
     * 当此值大于80时, 此实体会在下一tick消失, 是否掉落为物品取决于getDropItem().
     * <p>
     * 原文:Gets the amount of time this entity has been alive (in ticks).
     * <br>
     * When this number is greater than 80, it will despawn on the next tick.
     *
     * @return 此末影之眼实体已存活时间
     */
    public int getDespawnTimer();

    /**
     * 设置末影之眼已在空气漂浮的时间 (单位为tick).
     * <br>
     * 当此值大于80时, 此实体会在下一tick消失, 是否掉落为物品取决于getDropItem().
     * <p>
     * 原文:Set how long this entity has been alive (in ticks).
     * <br>
     * When this number is greater than 80, it will despawn on the next tick.
     *
     * @param timer 此末影之眼实体已存活时间
     */
    public void setDespawnTimer(int timer);
}
