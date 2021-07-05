package org.bukkit.event.entity;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当一个人类实体的饥饿值发生变化时触发本事件
 */
public class FoodLevelChangeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private int level;
    private final ItemStack item;

    public FoodLevelChangeEvent(@NotNull final HumanEntity what, final int level) {
        this(what, level, null);
    }

    public FoodLevelChangeEvent(@NotNull final HumanEntity what, final int level, @Nullable final ItemStack item) {
        super(what);
        this.level = level;
        this.item = item;
    }

    @NotNull
    @Override
    public HumanEntity getEntity() {
        return (HumanEntity) entity;
    }

    /**
     * 若存在的话, 返回触发本事件的物品.
     * <p>
     * 原文:Gets the item that triggered this event, if any.
     *
     * @return 被吃的食物
     */
    @Nullable
    public ItemStack getItem() {
        return (item == null) ? null : item.clone();
    }

    /**
     * 获取本事件涉及的实体将被设置的饥饿值
     * <p>
     * 20为饱和状态，0为饥饿状态.
     * <p>
     * 原文:
     * Gets the resultant food level that the entity involved in this event
     * should be set to.
     * <p>
     * Where 20 is a full food bar and 0 is an empty one.
     *
     * @return 饥饿值
     */
    public int getFoodLevel() {
        return level;
    }

    /**
     * 设置实体将被设置的饥饿值
     * <p>
     * 原文:
     * Sets the resultant food level that the entity involved in this event
     * should be set to
     *
     * @param level 饥饿值
     */
    public void setFoodLevel(int level) {
        if (level < 0) level = 0;

        this.level = level;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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