package org.bukkit.block;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

/**
 * 代表末地折跃门.
 */
public interface EndGateway extends TileState {

    /**
     * 获取当实体进入折跃门时被传送到的位置.
     * <p>
     * 如果本方块尚未放置, 位置对象中的 'world' 将为 null.
     * <p>
     * 原文:Gets the location that entities are teleported to when
     * entering the gateway portal.
     * <p>
     * If this block state is not placed the location's world will be null.
     *
     * @return 折跃门传送目的地
     */
    @Nullable
    Location getExitLocation();

    /**
     * 设置进入折跃门时传送的位置.
     * <p>
     * 如果本方块尚未放置, 位置对象中的 'world' 必须为 null.
     * <p>
     * 原文:Sets the exit location that entities are teleported to when
     * they enter the gateway portal.
     * <p>
     * If this block state is not placed the location's world has to be null.
     *
     * @param location 新传送地点
     * @throws IllegalArgumentException 方块所在世界与设置的世界不同
     */
    void setExitLocation(@Nullable Location location);

    /**
     * 获取折跃门是否精确传送实体至指定位置, 而不是传送到目标位置附近.
     * <p>
     * 原文:Gets whether this gateway will teleport entities directly to
     * the exit location instead of finding a nearby location.
     *
     * @return 是否精确传送
     */
    boolean isExactTeleport();

    /**
     * 设置折跃门是否精确传送实体至指定位置, 而不是传送到目标位置附近.
     * <p>
     * 原文:Sets whether this gateway will teleport entities directly to
     * the exit location instead of finding a nearby location.
     *
     * @param exact 是否精确传送
     */
    void setExactTeleport(boolean exact);

    /**
     * 获取末地折跃门方块的年龄 (以 tick 为单位).
     * <br>
     * 如果年龄小于200 tick, 折跃门会发出一束品红色光束.
     * 同时折跃门每隔2400 tick(约2分钟)发出一束紫色光束.
     * <p>
     * 原文:Gets the age in ticks of the gateway.
     * <br>
     * If the age is less than 200 ticks a magenta beam will be emitted, whilst
     * if it is a multiple of 2400 ticks a purple beam will be emitted.
     *
     * @return 年龄
     */
    long getAge();

    /**
     * 设置末地折跃门方块的年龄 (以 tick 为单位).
     * <br>
     * 如果年龄小于200 tick, 折跃门会发出一束品红色光束.
     * 同时折跃门每隔2400 tick(约2分钟)发出一束紫色光束.
     * <p>
     * 原文:Sets the age in ticks of the gateway.
     * <br>
     * If the age is less than 200 ticks a magenta beam will be emitted, whilst
     * if it is a multiple of 2400 ticks a purple beam will be emitted.
     *
     * @param age 年龄
     */
    void setAge(long age);
}
