package org.bukkit.block;

import org.bukkit.Location;
import org.bukkit.entity.Bee;
import org.jetbrains.annotations.Nullable;

/**
 * 代表蜂巢.
 */
public interface Beehive extends EntityBlockStorage<Bee> {

    /**
     * 获取花的位置.
     * <p>
     * 原文:Get the hive's flower location.
     *
     * @return 花的位置或null
     */
    @Nullable
    Location getFlower();

    /**
     * 设置花的位置.
     * <p>
     * 原文:Set the hive's flower location.
     *
     * @param location 花的位置或null
     */
    void setFlower(@Nullable Location location);

    /**
     * 检测蜂巢底下是否有点燃的营火, 使得玩家采蜜时蜜蜂不会攻击玩家.
     * <p>
     * 原文:Check if the hive is sedated due to smoke from a nearby campfire.
     *
     * @return 蜂巢是否安然待之
     */
    boolean isSedated();
}
