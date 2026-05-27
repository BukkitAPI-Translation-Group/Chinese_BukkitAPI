package org.bukkit.event.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当生物选定目标或取消选定另一个实体时调用。
 */
public class EntityTargetEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private Entity target;
    private final TargetReason reason;

    public EntityTargetEvent(@NotNull final Entity entity, @Nullable final Entity target, @NotNull final TargetReason reason) {
        super(entity);
        this.target = target;
        this.reason = reason;
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
     * 返回选定目标的原因。
     * <p>
     * 原文：
     * Returns the reason for the targeting
     *
     * @return 原因
     */
    @NotNull
    public TargetReason getReason() {
        return reason;
    }

    /**
     * 获取此实体正在 targeting 的实体。
     * <p>
     * 在事件因生物忘记其目标而被调用时，此值将为 null。
     * <p>
     * 原文：
     * Get the entity that this is targeting.
     * <p>
     * This will be null in the case that the event is called when the mob
     * forgets its target.
     *
     * @return 实体
     */
    @Nullable
    public Entity getTarget() {
        return target;
    }

    /**
     * 设置你希望生物 targeting 的实体。
     * <p>
     * 可以设置为 null，null 会导致实体没有目标。
     * <p>
     * 这与取消事件不同。取消事件会导致实体保留原始目标，而设置为 null 会导致实体被重置。
     * <p>
     * 原文：
     * Set the entity that you want the mob to target instead.
     * <p>
     * It is possible to be null, null will cause the entity to be
     * target-less.
     * <p>
     * This is different from cancelling the event. Cancelling the event will
     * cause the entity to keep an original target, while setting to be null
     * will cause the entity to be reset.
     *
     * @param target 要 targeting 的实体
     */
    public void setTarget(@Nullable Entity target) {
        this.target = target;
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
     * 指定选定目标原因的枚举。
     */
    public enum TargetReason {

        /**
         * 当实体的目标已死亡，因此不再 targeting 它时。
         */
        TARGET_DIED,
        /**
         * 当实体没有目标时，它会攻击最近的玩家。
         */
        CLOSEST_PLAYER,
        /**
         * 当目标攻击实体时，实体会 targeting 它。
         */
        TARGET_ATTACKED_ENTITY,
        /**
         * 当目标攻击一个猪灵僵尸同伴时，整个群体都会以此原因 targeting 他。
         *
         * @deprecated 已被 {@link #TARGET_ATTACKED_NEARBY_ENTITY} 取代。
         */
        @Deprecated(since = "1.13")
        PIG_ZOMBIE_TARGET,
        /**
         * 当目标因任何原因被忘记时。
         */
        FORGOT_TARGET,
        /**
         * 当目标攻击实体的主人时，实体会 targeting 它。
         */
        TARGET_ATTACKED_OWNER,
        /**
         * 当实体的主人攻击目标时，实体会 targeting 它。
         */
        OWNER_ATTACKED_TARGET,
        /**
         * 当实体没有目标时，实体会随机选择一个。
         */
        RANDOM_TARGET,
        /**
         * 当实体在保卫村庄时选择目标。
         */
        DEFEND_VILLAGE,
        /**
         * 当目标攻击附近同类型的实体时，实体会 targeting 它。
         */
        TARGET_ATTACKED_NEARBY_ENTITY,
        /**
         * 当僵尸 targeting 一个实体时召唤援军，援军会 targeting 同一个实体。
         */
        REINFORCEMENT_TARGET,
        /**
         * 当实体与另一个实体碰撞后 targeting 它。
         */
        COLLISION,
        /**
         * 用于自定义调用事件。
         */
        CUSTOM,
        /**
         * 当实体没有目标时，它会攻击最近的实体。
         */
        CLOSEST_ENTITY,
        /**
         * 当袭击实体选择与其同伴相同的目标时。
         */
        FOLLOW_LEADER,
        /**
         * 当另一个实体通过手持所需物品（如小麦）来引诱此实体时。
         */
        TEMPT,
        /**
         * 实体改变目标的当前未知原因。
         */
        UNKNOWN;
    }
}