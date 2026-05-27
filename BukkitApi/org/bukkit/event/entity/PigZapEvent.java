package org.bukkit.event.entity;

import java.util.Collections;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 储存猪被闪电击中的数据。
 */
public class PigZapEvent extends EntityTransformEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final PigZombie pigzombie;
    private final LightningStrike bolt;

    public PigZapEvent(@NotNull final Pig pig, @NotNull final LightningStrike bolt, @NotNull final PigZombie pigzombie) {
        super(pig, Collections.singletonList((Entity) pigzombie), TransformReason.LIGHTNING);
        this.bolt = bolt;
        this.pigzombie = pigzombie;
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
    public Pig getEntity() {
        return (Pig) entity;
    }

    /**
     * 获取击中猪的闪电。
     * <p>
     * 原文：
     * Gets the bolt which is striking the pig.
     *
     * @return 闪电实体
     */
    @NotNull
    public LightningStrike getLightning() {
        return bolt;
    }

    /**
     * 获取将替换猪的僵尸猪灵，前提是事件未被取消。
     * <p>
     * 原文：
     * Gets the zombie pig that will replace the pig, provided the event is
     * not cancelled first.
     *
     * @return 生成的实体
     * @deprecated 使用 {@link EntityTransformEvent#getTransformedEntity()}
     */
    @NotNull
    @Deprecated(since = "1.13.2")
    public PigZombie getPigZombie() {
        return pigzombie;
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