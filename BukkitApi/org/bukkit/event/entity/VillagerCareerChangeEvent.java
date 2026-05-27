package org.bukkit.event.entity;

import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class VillagerCareerChangeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private Profession profession;
    private final ChangeReason reason;

    public VillagerCareerChangeEvent(@NotNull Villager what, @NotNull Profession profession, @NotNull ChangeReason reason) {
        super(what);
        this.profession = profession;
        this.reason = reason;
    }

    @NotNull
    @Override
    public Villager getEntity() {
        return (Villager) super.getEntity();
    }

    /**
     * 获取村民的未来职业。
     * <p>
     * 原文：
     * Gets the future profession of the villager.
     *
     * @return 村民将要改变的职业
     */
    @NotNull
    public Profession getProfession() {
        return profession;
    }

    /**
     * 设置村民将要成为的职业。
     * <p>
     * 原文：
     * Sets the profession the villager will become from this event.
     *
     * @param profession 新职业
     */
    public void setProfession(@NotNull Profession profession) {
        this.profession = profession;
    }

    /**
     * 获取村民职业改变的原因。
     * <p>
     * 原文：
     * Gets the reason for why the villager's career is changing.
     *
     * @return 村民职业改变的原因
     */
    @NotNull
    public ChangeReason getReason() {
        return reason;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
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

    /**
     * 村民职业改变的原因。
     */
    public enum ChangeReason {

        /**
         * 村民因经验太少而失业。
         */
        LOSING_JOB,
        /**
         * 村民就业。
         */
        EMPLOYED;
    }
}
