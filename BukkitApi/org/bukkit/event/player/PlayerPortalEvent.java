package org.bukkit.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// TODO:何为“退出传送门”
/**
 * 玩家将要被传送门传送的事件, 传送过程中会生成一个退出传送门.
 * <p>
 * 其他实体被传送门传送的事件请见{@link org.bukkit.event.entity.EntityPortalEvent}
 */
public class PlayerPortalEvent extends PlayerTeleportEvent {
    private static final HandlerList handlers = new HandlerList();
    private int getSearchRadius = 128;
    private boolean canCreatePortal = true;
    private int creationRadius = 16;

    public PlayerPortalEvent(@NotNull final Player player, @NotNull final Location from, @Nullable final Location to) {
        super(player, from, to);
    }

    public PlayerPortalEvent(@NotNull Player player, @NotNull Location from, @Nullable Location to, @NotNull TeleportCause cause) {
        super(player, from, to, cause);
    }

    public PlayerPortalEvent(@NotNull Player player, @NotNull Location from, @Nullable Location to, @NotNull TeleportCause cause, int getSearchRadius, boolean canCreatePortal, int creationRadius) {
        super(player, from, to, cause);
        this.getSearchRadius = getSearchRadius;
        this.canCreatePortal = canCreatePortal;
        this.creationRadius = creationRadius;
    }

    /**
     * 设置搜索可用传送门的方块半径.
     *
     * @param searchRadius 从当前位置搜索传送门的半径
     * <p>
     * 原文：Set the Block radius to search in for available portals.
     */
    public void setSearchRadius(int searchRadius) {
        this.getSearchRadius = searchRadius;
    }

    /**
     * 获取搜索可用传送门的半径.
     *
     * @return 当前设置的搜索半径
     * <p>
     * 原文：Gets the search radius value for finding an available portal.
     */
    public int getSearchRadius() {
        return getSearchRadius;
    }

    /**
     * 返回服务器是否将尝试创建目标传送门.
     *
     * @return 是否应创建目标传送门
     * <p>
     * 原文：Returns whether the server will attempt to create a destination portal or not.
     */
    public boolean getCanCreatePortal() {
        return canCreatePortal;
    }

    /**
     * 设置服务器是否应尝试创建目标传送门.
     *
     * @param canCreatePortal 是否应创建目标传送门
     * <p>
     * 原文：Sets whether the server should attempt to create a destination portal or not.
     */
    public void setCanCreatePortal(boolean canCreatePortal) {
        this.canCreatePortal = canCreatePortal;
    }

    /**
     * 设置从给定位置搜索空闲空间的最大世界半径.
     * <p>
     * 如果找到足够的空闲空间，则传送门将创建在该处；否则将在目标位置强制以空气空间创建.
     * <p>
     * 不适用于末地传送门目标平台，该平台将始终出现在目标位置.
     *
     * @param creationRadius 从当前位置创建传送门的半径
     * <p>
     * 原文：Sets the maximum radius the world is searched for a free space from the given location.
     */
    public void setCreationRadius(int creationRadius) {
        this.creationRadius = creationRadius;
    }

    /**
     * 获取从给定位置搜索空闲空间的最大世界半径.
     * <p>
     * 如果找到足够的空闲空间，则传送门将创建在该处；否则将在目标位置强制以空气空间创建.
     * <p>
     * 不适用于末地传送门目标平台，该平台将始终出现在目标位置.
     *
     * @return 当前设置的创建半径
     * <p>
     * 原文：Gets the maximum radius the world is searched for a free space from the given location.
     */
    public int getCreationRadius() {
        return creationRadius;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}