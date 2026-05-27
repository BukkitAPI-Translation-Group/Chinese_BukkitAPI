package org.bukkit.entity;

import org.bukkit.Location;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 悦灵生物.
 */
public interface Allay extends Creature, InventoryHolder {

    /**
     * 获取悦灵是否可以复制.
     * <br>
     * <b>注意:</b> 复制取决于 {@link #getDuplicationCooldown} 是否小于零.
     * <p>
     * 原文：Gets if the allay can duplicate.
     * <br>
     * <b>Note:</b> Duplication is based when the
     * {@link #getDuplicationCooldown} its lower than zero.
     *
     * @return 悦灵是否可以复制自身.
     */
    public boolean canDuplicate();

    /**
     * 设置悦灵是否可以复制.
     * <br>
     * <b>注意:</b> 此值可能会被 {@link #getDuplicationCooldown} 覆盖, 如果冷却时间小于零.
     * 你也可以使用 {@link #setDuplicationCooldown} 来允许悦灵复制.
     * <p>
     * 原文：Sets if the allay can duplicate.
     * <br>
     * <b>Note:</b> this value can be overridden later by
     * {@link #getDuplicationCooldown} if is lower than zero. You can also use
     * {@link #setDuplicationCooldown} to allow the allay to duplicate
     *
     * @param canDuplicate 悦灵是否可以复制自身
     */
    public void setCanDuplicate(boolean canDuplicate);

    /**
     * 获取悦灵复制的冷却时间.
     * <p>
     * 原文：Gets the cooldown for duplicating the allay.
     *
     * @return 悦灵可以复制的时间 (以 tick 为单位)
     */
    public long getDuplicationCooldown();

    /**
     * 设置悦灵再次复制前的冷却时间.
     * <p>
     * 原文：Sets the cooldown before the allay can duplicate again.
     *
     * @param cooldown 冷却时间, 使用负数来阻止悦灵再次复制.
     */
    public void setDuplicationCooldown(long cooldown);

    /**
     * 重置复制的冷却时间.
     *
     * 这会将冷却时间设置为与悦灵复制后相同的值.
     * <p>
     * 原文：Reset the cooldown for duplication.
     *
     * This will set the cooldown ticks to the same value as is set after an
     * Allay has duplicated.
     */
    public void resetDuplicationCooldown();

    /**
     * 获取悦灵是否正在跳舞.
     * <p>
     * 原文：Gets if the allay is dancing.
     *
     * @return {@code True} 如果正在跳舞, 否则为 false.
     */
    public boolean isDancing();

    /**
     * 使悦灵因指定的唱片机位置而开始跳舞.
     * <p>
     * 原文：Causes the allay to start dancing because of the provided jukebox
     * location.
     *
     * @param location 唱片机的位置
     *
     * @throws IllegalArgumentException 如果该位置的方块不是唱片机
     */
    public void startDancing(@NotNull Location location);

    /**
     * 强制设置悦灵的跳舞状态.
     * <br>
     * <b>注意:</b> 此方法强制悦灵跳舞, 忽略附近是否有唱片机.
     * <p>
     * 原文：Force sets the dancing status of the allay.
     * <br>
     * <b>Note:</b> This method forces the allay to dance, ignoring any nearby
     * jukebox being required.
     */
    public void startDancing();

    /**
     * 使悦灵停止跳舞.
     * <p>
     * 原文：Makes the allay stop dancing.
     */
    public void stopDancing();

    /**
     * 使当前悦灵复制自身, 无需跳舞或物品.
     * <b>注意:</b> 这将触发 {@link CreatureSpawnEvent}
     * <p>
     * 原文：This make the current allay duplicate itself without dance or item
     * necessary.
     * <b>Note:</b> this will fire a {@link CreatureSpawnEvent}
     *
     * @return 新的 {@link Allay} 实体, 如果生成被取消则返回 null
     */
    @Nullable
    public Allay duplicateAllay();

    /**
     * 获取悦灵正在跳舞的唱片机.
     * <p>
     * 原文：Gets the jukebox the allay is set to dance to.
     *
     * @return 唱片机的位置 (如果存在)
     */
    @Nullable
    public Location getJukebox();
}
