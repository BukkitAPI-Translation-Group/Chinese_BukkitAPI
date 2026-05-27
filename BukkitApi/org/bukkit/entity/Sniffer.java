package org.bukkit.entity;

import java.util.Collection;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表嗅探兽。
 */
public interface Sniffer extends Animals {

    /**
     * 获取嗅探兽已探索的位置。
     * <br>
     * <b>注意：</b>返回的位置使用嗅探兽当前的世界。
     * <p>
     * 原文：Gets the locations explored by the sniffer.
     * <br>
     * <b>Note:</b> the returned locations use sniffer's current world.
     *
     * @return 位置集合
     */
    @NotNull
    public Collection<Location> getExploredLocations();

    /**
     * 从已探索位置中移除一个位置。
     * <br>
     * <b>注意：</b>位置必须在嗅探兽当前世界中才能生效。
     * <p>
     * 原文：Remove a location of the explored locations.
     * <br>
     * <b>Note:</b> the location must be in the sniffer's current world for this
     * method to have any effect.
     *
     * @param location 要移除的位置
     * @see #getExploredLocations()
     */
    public void removeExploredLocation(@NotNull Location location);

    /**
     * 向已探索位置中添加一个位置。
     * <br>
     * <b>注意：</b>位置必须在嗅探兽当前世界中才能生效。
     * <p>
     * 原文：Add a location to the explored locations.
     * <br>
     * <b>Note:</b> the location must be in the sniffer's current world for this
     * method to have any effect.
     *
     * @param location 要添加的位置
     * @see #getExploredLocations()
     */
    public void addExploredLocation(@NotNull Location location);

    /**
     * 获取嗅探兽的当前状态。
     * <p>
     * 原文：Get the current state of the sniffer.
     *
     * @return 嗅探兽的状态
     */
    @NotNull
    public Sniffer.State getState();

    /**
     * 为嗅探兽设置新状态。
     * <br>
     * 这将使嗅探兽过渡到新状态。
     * <p>
     * 原文：Set a new state for the sniffer.
     * <br>
     * This will also make the sniffer make the transition to the new state.
     *
     * @param state 新状态
     */
    public void setState(@NotNull Sniffer.State state);

    /**
     * 尝试获取嗅探兽可能挖掘的位置。
     * <p>
     * 原文：Try to get a possible location where the sniffer can dig.
     *
     * @return 如果找到则返回 {@link Location}，否则返回null
     */
    @Nullable
    public Location findPossibleDigLocation();

    /**
     * 获取嗅探兽是否能在其头部下方的当前位置挖掘。
     * <p>
     * 原文：Gets whether the sniffer can dig in the current {@link Location} below
     * its head.
     *
     * @return 如果能挖掘则为 {@code true}，否则为 {@code false}
     */
    public boolean canDig();

    /**
     * 代表嗅探兽的当前状态。
     */
    public enum State {
        IDLING,
        FEELING_HAPPY,
        SCENTING,
        SNIFFING,
        SEARCHING,
        DIGGING,
        RISING;
    }
}
