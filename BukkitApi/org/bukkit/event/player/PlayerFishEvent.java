package org.bukkit.event.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家钓鱼时触发本事件.
 */
public class PlayerFishEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Entity entity;
    private boolean cancel = false;
    private int exp;
    private final State state;
    private final FishHook hookEntity;
    private final EquipmentSlot hand;

    public PlayerFishEvent(@NotNull final Player player, @Nullable final Entity entity, @NotNull final FishHook hookEntity, @Nullable EquipmentSlot hand, @NotNull final State state) {
        super(player);
        this.entity = entity;
        this.hookEntity = hookEntity;
        this.hand = hand;
        this.state = state;
    }

    public PlayerFishEvent(@NotNull final Player player, @Nullable final Entity entity, @NotNull final FishHook hookEntity, @NotNull final State state) {
        this(player, entity, hookEntity, null, state);
    }

    /**
     * 获取玩家钓到的实体.
     * <p>
     * 原文：Gets the entity caught by the player.
     * <p>
     * 如果玩家钓鱼成功, 结果可以转换为 {@link org.bukkit.entity.Item}.
     *
     * @return 玩家钓到的实体, 钓鱼时为实体, 如果鱼钩卡在地面上或什么都没钓到则为 null
     */
    @Nullable
    public Entity getCaught() {
        return entity;
    }

    /**
     * 获取钓鱼钩.
     * <p>
     * 原文：Gets the fishing hook.
     *
     * @return 代表钓鱼钩/浮标的实体
     */
    @NotNull
    public FishHook getHook() {
        return hookEntity;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获取钓鱼时获得的经验值.
     * <p>
     * 原文：Gets the amount of experience received when fishing.
     * <p>
     * 注意: 除非事件状态为 {@link State#CAUGHT_FISH}, 否则此值没有默认效果.
     *
     * @return 掉落的经验值数量
     */
    public int getExpToDrop() {
        return exp;
    }

    /**
     * 设置钓鱼时获得的经验值.
     * <p>
     * 原文：Sets the amount of experience received when fishing.
     * <p>
     * 注意: 除非事件状态为 {@link State#CAUGHT_FISH}, 否则此值没有默认效果.
     *
     * @param amount 掉落的经验值数量
     */
    public void setExpToDrop(int amount) {
        exp = amount;
    }

    /**
     * 获取此事件中使用的手.
     * <p>
     * 原文：Get the hand that was used in this event.
     * <p>
     * 使用的手仅在事件状态为 {@link State#FISHING} 时存在.
     * 在所有其他状态下, 手为 null.
     *
     * @return 使用的手
     */
    @Nullable
    public EquipmentSlot getHand() {
        return hand;
    }

    /**
     * 获取钓鱼的状态.
     * <p>
     * 原文：Gets the state of the fishing.
     *
     * @return 描述钓鱼状态的枚举值
     */
    @NotNull
    public State getState() {
        return state;
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
     * 用于指定钓鱼状态的枚举
     */
    public enum State {

        /**
         * 当玩家正在钓鱼时, 即抛出鱼线.
         */
        FISHING,
        /**
         * 当玩家成功钓到鱼并正在收线时.
         * 在这种情况下, "鱼" 是指通过钓鱼从水中获取的任何物品,
         * 即一个物品, 但不一定是鱼.
         */
        CAUGHT_FISH,
        /**
         * 当玩家成功钓到一个实体时.
         * 这指的是世界上任何已经被鱼钩直接钩住的已生成实体.
         */
        CAUGHT_ENTITY,
        /**
         * 当鱼钩卡在地面上时.
         */
        IN_GROUND,
        /**
         * 当玩家在钓鱼时未能咬钩, 通常是由于时机不对.
         */
        FAILED_ATTEMPT,
        /**
         * 当玩家收线但没有鱼上钩时.
         */
        REEL_IN,
        /**
         * 当鱼钩上有鱼咬钩并准备收线时调用.
         */
        BITE
    }
}
