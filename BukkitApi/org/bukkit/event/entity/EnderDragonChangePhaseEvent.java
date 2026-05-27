package org.bukkit.event.entity;

import com.google.common.base.Preconditions;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当末影龙切换控制器阶段时调用。
 */
public class EnderDragonChangePhaseEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final EnderDragon.Phase currentPhase;
    private EnderDragon.Phase newPhase;

    public EnderDragonChangePhaseEvent(@NotNull EnderDragon enderDragon, @Nullable EnderDragon.Phase currentPhase, @NotNull EnderDragon.Phase newPhase) {
        super(enderDragon);
        this.currentPhase = currentPhase;
        this.setNewPhase(newPhase);
    }

    @NotNull
    @Override
    public EnderDragon getEntity() {
        return (EnderDragon) entity;
    }

    /**
     * 获取龙当前所处的阶段。当龙首次生成且尚未分配阶段时，此方法将返回 null。
     * <p>
     * 原文：
     * Gets the current phase that the dragon is in. This method will return null
     * when a dragon is first spawned and hasn't yet been assigned a phase.
     *
     * @return 当前龙阶段
     */
    @Nullable
    public EnderDragon.Phase getCurrentPhase() {
        return currentPhase;
    }

    /**
     * 获取龙将要切换到的新阶段。
     * <p>
     * 原文：
     * Gets the new phase that the dragon will switch to.
     *
     * @return 新龙阶段
     */
    @NotNull
    public EnderDragon.Phase getNewPhase() {
        return newPhase;
    }

    /**
     * 设置末影龙的新阶段。
     * <p>
     * 原文：
     * Sets the new phase for the ender dragon.
     *
     * @param newPhase 新龙阶段
     */
    public void setNewPhase(@NotNull EnderDragon.Phase newPhase) {
        Preconditions.checkArgument(newPhase != null, "New dragon phase cannot be null");
        this.newPhase = newPhase;
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
