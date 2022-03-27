package org.bukkit.event.entity;

import org.bukkit.entity.Animals;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当实体进入求爱模式时触发本事件.
 * <br>
 * 本事件可被取消, 但喂给实体的食物仍会被消耗.
 */
public class EntityEnterLoveModeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final HumanEntity humanEntity;
    private int ticksInLove;

    public EntityEnterLoveModeEvent(@NotNull Animals animalInLove, @Nullable HumanEntity humanEntity, int ticksInLove) {
        super(animalInLove);
        this.humanEntity = humanEntity;
        this.ticksInLove = ticksInLove;
    }

    /**
     * 获取正进入求爱模式的动物.
     * <p>
     * 原文:
     * Gets the animal that is entering love mode.
     *
     * @return 正进入求爱模式的动物
     */
    @NotNull
    @Override
    public Animals getEntity() {
        return (Animals) entity;
    }

    /**
     * 获取导致动物进入求爱模式的人类实体.
     * <p>
     * 原文:
     * Gets the Human Entity that caused the animal to enter love mode.
     *
     * @return 人类实体, 如果不因人类而发情则为 null
     */
    @Nullable
    public HumanEntity getHumanEntity() {
        return humanEntity;
    }

    /**
     * 获取动物爱意的持续时长 (单位为tick).
     * <p>
     * 原文:
     * Gets the amount of ticks that the animal will fall in love for.
     *
     * @return 动物爱意的持续时长 (单位为tick)
     */
    public int getTicksInLove() {
        return ticksInLove;
    }

    /**
     * 设置动物爱意的持续时长 (单位为tick).
     * <p>
     * 原文:
     * Sets the amount of ticks that the animal will fall in love for.
     *
     * @param ticksInLove 动物爱意的持续时长 (单位为tick)
     */
    public void setTicksInLove(int ticksInLove) {
        this.ticksInLove = ticksInLove;
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
