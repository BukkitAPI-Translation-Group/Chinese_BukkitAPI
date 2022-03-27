package org.bukkit.event.entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当实体上的药水效果发生改变时触发本事件.
 * <p>
 * 如果此事件被取消, 将不会对实体做出改变.
 */
public class EntityPotionEffectEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final PotionEffect oldEffect;
    private final PotionEffect newEffect;
    private final Cause cause;
    private final Action action;
    private boolean override;

    @Contract("_, null, null, _, _, _ -> fail")
    public EntityPotionEffectEvent(@NotNull LivingEntity livingEntity, @Nullable PotionEffect oldEffect, @Nullable PotionEffect newEffect, @NotNull Cause cause, @NotNull Action action, boolean override) {
        super(livingEntity);
        this.oldEffect = oldEffect;
        this.newEffect = newEffect;
        this.cause = cause;
        this.action = action;
        this.override = override;
    }

    /**
     * 获取将被移除的旧药水效果.
     * <p>
     * 原文:
     * Gets the old potion effect of the changed type, which will be removed.
     *
     * @return 旧药水效果, 如果效果类型没变则为 null (也就是新增的效果)
     */
    @Nullable
    public PotionEffect getOldEffect() {
        return oldEffect;
    }

    /**
     * 获取将被应用的新药水效果.
     * <p>
     * 原文:
     * Gets new potion effect of the changed type to be applied.
     *
     * @return 新药水效果, 如果药水效果将被移除则为 null
     */
    @Nullable
    public PotionEffect getNewEffect() {
        return newEffect;
    }

    /**
     * 获取药水效果改变的原因.
     * <p>
     * 原文:
     * Gets the cause why the effect has changed.
     *
     * @return 药水效果改变的原因
     */
    @NotNull
    public Cause getCause() {
        return cause;
    }

    /**
     * 获取对此药水效果采取的动作.
     * <p>
     * 原文:
     * Gets the action which will be performed on the potion effect type.
     *
     * @return 对此药水效果采取的动作
     */
    @NotNull
    public Action getAction() {
        return action;
    }

    /**
     * 获取发生调整的药水效果类型.
     * <p>
     * 原文:
     * Gets the modified potion effect type.
     *
     * @return 发生调整的药水效果类型
     */
    @NotNull
    public PotionEffectType getModifiedType() {
        return (oldEffect == null) ? ((newEffect == null) ? null : newEffect.getType()) : oldEffect.getType();
    }

    /**
     * 返回新效果是否将覆盖旧效果 (仅适用于 CHANGED 动作).
     * <p>
     * 原文:
     * Returns if the new potion effect will override the old potion effect
     * (Only applicable for the CHANGED Action).
     *
     * @return 新效果是否将覆盖旧效果
     */
    public boolean isOverride() {
        return override;
    }

    /**
     * 设置新效果是否将覆盖旧效果 (仅适用于 CHANGED 动作).
     * <p>
     * 原文:
     * Sets if the new potion effect will override the old potion effect (Only
     * applicable for the CHANGED action).
     *
     * @param override 新效果是否将覆盖旧效果
     */
    public void setOverride(boolean override) {
        this.override = override;
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

    /**
     * 指定对药水效果采取的动作的枚举.
     */
    public enum Action {

        /**
         * 因实体尚无对应类型的药水效果时而添加药水效果.
         */
        ADDED,
        /**
         * 实体已有对应类型的药水效果, 但效果属性发生改变.
         */
        CHANGED,
        /**
         * 效果因所有状态效果被清除时而被移除.
         */
        CLEARED,
        /**
         * 对应类型的药水效果被完全移除.
         */
        REMOVED
    }

    /**
     * 指定药水效果改变原因的枚举.
     */
    public enum Cause {

        /**
         * 当实体站在区域效果云里面时.
         */
        AREA_EFFECT_CLOUD,
        /**
         * 当实体被光灵箭或药箭击中时.
         */
        ARROW,
        /**
         * 当实体由于其它实体的攻击(例如:洞穴蜘蛛或潜影贝导弹)而遭受药水效果的影响时.
         */
        ATTACK,
        /**
         * 当实体获得美西螈给予的效果时.
         */
        AXOLOTL,
        /**
         * 当信标的增益效果应用到附近的实体时.
         */
        BEACON,
        /**
         * 当使用 /effect 命令改变药水效果时.
         */
        COMMAND,
        /**
         * 当实体获得潮涌核心赋予的效果时.
         */
        CONDUIT,
        /**
         * 当僵尸村民到村民的转化开始或完成时.
         */
        CONVERSION,
        /**
         * 当所有效果因死亡而被移除时 (注:重生时调用此事件, 因此这种情况仅针对于玩家!).
         */
        DEATH,
        /**
         * 当实体受到海豚给予的效果时.
         */
        DOLPHIN,
        /**
         * 当效果因过期而被移除时.
         */
        EXPIRATION,
        /**
         * 当实体因食用食物而受到药水效果影响时
         * (例如:当玩家吃下部分食物或将曲奇喂给鹦鹉时).
         */
        FOOD,
        /**
         * 当幻术师使自己隐身时.
         */
        ILLUSION,
        /**
         * 当所有效果因喝下一桶牛奶而被清除时.
         */
        MILK,
        /**
         * 当玩家击杀灾厄巡逻队队长, 获得不详之兆效果时.
         */
        PATROL_CAPTAIN,
        /**
         * 当药水效果被插件修改时.
         */
        PLUGIN,
        /**
         * 当实体喝下药水时.
         */
        POTION_DRINK,
        /**
         * 当实体因喷溅药水受到药水效果影响时.
         */
        POTION_SPLASH,
        /**
         * 当蜘蛛在困难模式下生成时获得效果时.
         */
        SPIDER_SPAWN,
        /**
         * 当实体被不死图腾挽救, 获得增益效果时.
         */
        TOTEM,
        /**
         * 当实体戴上海龟壳下水, 获得水下呼吸效果时.
         */
        TURTLE_HELMET,
        /**
         * 当原因缺失时.
         */
        UNKNOWN,
        /**
         * 当村民交易后, 恢复生命值时.
         */
        VILLAGER_TRADE,
        /**
         * 当实体触碰凋零玫瑰时.
         */
        WITHER_ROSE
    }
}
