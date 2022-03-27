package org.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当{@link org.bukkit.entity.Item 掉落物}存在时间超过5分钟后被移除时触发本事件
 * (注:掉落物存在时间因服务器配置和安装的插件而异).
 * <p>
 * 取消本事件将使掉落物可继续存留5分钟. 服务器不对这一表现(规律)作担保, 未来的版本或存变数.
 */
public class ItemDespawnEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final Location location;

    public ItemDespawnEvent(@NotNull final Item despawnee, @NotNull final Location loc) {
        super(despawnee);
        location = loc;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    @NotNull
    @Override
    public Item getEntity() {
        return (Item) entity;
    }

    /**
     * 获取即将消失的掉落物.
     * <p>
     * 原文:
     * Gets the location at which the item is despawning.
     *
     * @return 将消失的掉落物的位置
     */
    @NotNull
    public Location getLocation() {
        return location;
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
