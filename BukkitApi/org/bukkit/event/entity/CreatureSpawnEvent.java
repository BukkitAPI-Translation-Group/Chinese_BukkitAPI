package org.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个生物体在世界中出生时触发该事件.
 * <p>
 * 如果该事件被取消了,那么这个生物将不会出生.
 */
public class CreatureSpawnEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final SpawnReason spawnReason;

    public CreatureSpawnEvent(final LivingEntity spawnee, final SpawnReason spawnReason) {
        super(spawnee);
        this.spawnReason = spawnReason;
    }

    public boolean isCancelled() {
        return canceled;
    }

    public void setCancelled(boolean cancel) {
        canceled = cancel;
    }

    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * 返回生物出生的位置
     * <p>
     * 原文:
     * Gets the location at which the creature is spawning.
     *
     * @return The location at which the creature is spawning生物出生的位置
     */
    public Location getLocation() {
        return getEntity().getLocation();
    }

    /**
     * 返回生物出生的原因
     * <p>
     * 原文:
     * Gets the reason for why the creature is being spawned.
     *
     * @return 出生原因
     */
    public SpawnReason getSpawnReason() {
        return spawnReason;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * 生成原因的枚举类.
     */
    public enum SpawnReason {

        /**
         * 自然生成
         */
        NATURAL,
        /**
         * 当实体因为乘骑而被生成时 (大多是蜘蛛骑士)
         */
        JOCKEY,
        /**
         * 当区块产生而生成生物时
         */
        CHUNK_GEN,
        /**
         * 当生物由于刷怪箱生成时
         */
        SPAWNER,
        /**
         * 当生物由于蛋生成时 (不是刷怪蛋,是普通的鸡蛋)
         */
        EGG,
        /**
         * 当生物由于刷怪蛋生成时
         */
        SPAWNER_EGG,
        /**
         * 当生物由于闪电而生成时
         */
        LIGHTNING,
        /**
         * 当雪人被建造时
         */
        BUILD_SNOWMAN,
        /**
         * 当一个铁傀儡被建造时
         */
        BUILD_IRONGOLEM,
        /**
         * 当一个凋零被建造时
         */
        BUILD_WITHER,
        /**
         * 当村庄生成保卫的铁傀儡时
         */
        VILLAGE_DEFENSE,
        /**
         * 当一个僵尸进攻村庄而生成时.
         */
        VILLAGE_INVASION,
        /**
         * 当一个动物由于交配而生成时
         */
        BREEDING,
        /**
         * 当史莱姆分裂时
         */
        SLIME_SPLIT,
        /**
         * 当一个实体请求支援时
         */
        REINFORCEMENTS,
        /**
         * 当生物由于地狱传送门而生成时
         */
        NETHER_PORTAL,
        /**
         * 当生物由于投掷器丢出鸡蛋而生成时
         */
        DISPENSE_EGG,
        /**
         * 当一个僵尸感染一个村民时
         */
        INFECTION,
        /**
         * 当村民从僵尸状态痊愈时
         */
        CURED,
        /**
         * 当豹猫为了照顾自己的孩子而出生时
         */
        OCELOT_BABY,
        /**
         * 当一条蠹虫从方块中生成时
         */
        SILVERFISH_BLOCK,
        /**
         * 当一个实体成为其他实体坐骑时 (大多数时是鸡骑士)
         */
        MOUNT,
        /**
         * 当实体作为陷阱陷害玩家时
         */
        TRAP,
        /**
         * 由于末影珍珠的使用而生成.
         */
        ENDER_PEARL,
        /**
         * When an entity is spawned as a result of the entity it is being
         * perched on jumping or being damaged
         */
        SHOULDER_ENTITY,
        /**
         * 当一个实体溺亡而生成时
         */
        DROWNED,
        /**
         * When an cow is spawned by shearing a mushroom cow
         */
        SHEARED,
        /**
         * 当生物被插件生成时
         */
        CUSTOM,
        /**
         * 实体由于其他原因而生成
         */
        DEFAULT
    }
}