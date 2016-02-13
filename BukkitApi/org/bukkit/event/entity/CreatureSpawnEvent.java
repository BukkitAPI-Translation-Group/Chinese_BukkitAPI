package org.bukkit.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个生物体在世界中出生时触发该事件.
 * <p>
 * 如果该事件被取消了,那么这个生物将不会出生.
 * 原文:
 * Called when a creature is spawned into a world.
 * <p>
 * If a Creature Spawn event is cancelled, the creature will not spawn.
 */
public class CreatureSpawnEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean canceled;
    private final SpawnReason spawnReason;

    public CreatureSpawnEvent(final LivingEntity spawnee, final SpawnReason spawnReason) {
        super(spawnee);
        this.spawnReason = spawnReason;
    }

    @Deprecated
    public CreatureSpawnEvent(Entity spawnee, CreatureType type, Location loc, SpawnReason reason) {
        super(spawnee);
        spawnReason = reason;
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
     * 返回生物出生的位置 (Location)类
     * 
     * @return 生物出生的位置 (Location)类
     * 原文:
     * Gets the location at which the creature is spawning.
     *
     * @return The location at which the creature is spawning
     */
    public Location getLocation() {
        return getEntity().getLocation();
    }

    /**
     * 返回将要生成的生物类型 (CreatureType).
     * 
     * @return 将要生成的生物类型 (CreatureType)
     * @deprecated  支持 {@link #getEntityType()}.
     * 原文:
     * Gets the type of creature being spawned.
     *
     * @return A CreatureType value detailing the type of creature being
     *     spawned
     * @deprecated In favour of {@link #getEntityType()}.
     */
    @Deprecated
    public CreatureType getCreatureType() {
        return CreatureType.fromEntityType(getEntityType());
    }

    /**
     * 返回生物出生的理由 (SpawnReason)
     * 
     * @return 一个生成理由的详细说明.
     * 原文:
     * Gets the reason for why the creature is being spawned.
     *
     * @return A SpawnReason value detailing the reason for the creature being
     *     spawned
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
     * 原文:
     * An enum to specify the type of spawning
     */
    public enum SpawnReason {

        /**
         * 当某些东西自然生成时
         * 原文:
         * When something spawns from natural means
         */
        NATURAL,
        /**
         * 当一个实体因为乘骑而被生成时 (大多是蜘蛛骑士)
         * 原文:
         * When an entity spawns as a jockey of another entity (mostly spider
         * jockeys)
         */
        JOCKEY,
        /**
         * 由于区块产生时生成的生物
         * 原文:
         * When a creature spawns due to chunk generation
         */
        CHUNK_GEN,
        /**
         * 当生物由于刷怪笼?生成时
         * 原文:
         * When a creature spawns from a spawner
         */
        SPAWNER,
        /**
         * 当生物由于蛋生成时 (不是刷怪蛋,是普通的鸡蛋)
         * 原文:
         * When a creature spawns from an egg
         */
        EGG,
        /**
         * 当生物由于刷怪蛋蛋生成时
         * 原文:
         * When a creature spawns from a Spawner Egg
         */
        SPAWNER_EGG,
        /**
         * 当生物由于闪电而生成时
         * 原文:
         * When a creature spawns because of a lightning strike
         */
        LIGHTNING,
        /**
         * 当生物由于玩家睡觉而生成时
         * 
         * @deprecated 已不再使用
         * 原文:
         * When a creature is spawned by a player that is sleeping
         *
         * @deprecated No longer used
         */
        @Deprecated
        BED,
        /**
         * 当一个雪人被建造时
         * 原文:
         * When a snowman is spawned by being built
         */
        BUILD_SNOWMAN,
        /**
         * 当一个铁傀儡被建造时
         * 原文:
         * When an iron golem is spawned by being built
         */
        BUILD_IRONGOLEM,
        /**
         * 当一个凋零被建造时
         * 原文:
         * When a wither boss is spawned by being built
         */
        BUILD_WITHER,
        /**
         * 当村庄生成保卫的铁傀儡时
         * 原文:
         * When an iron golem is spawned to defend a village
         */
        VILLAGE_DEFENSE,
        /**
         * 当一个僵尸进攻村庄而生成时.
         * 原文:
         * When a zombie is spawned to invade a village
         */
        VILLAGE_INVASION,
        /**
         * 当一个动物由于交配而生成时
         * 原文:
         * When an animal breeds to create a child
         */
        BREEDING,
        /**
         * 当史莱姆分类时
         * 原文:
         * When a slime splits
         */
        SLIME_SPLIT,
        /**
         * 当一个实体请求支援时
         * 原文:
         * When an entity calls for reinforcements
         */
        REINFORCEMENTS,
        /**
         * 当生物由于地狱传送门而生成时
         * 原文:
         * When a creature is spawned by nether portal
         */
        NETHER_PORTAL,
        /**
         * 当生物由于投掷器丢出鸡蛋而生成时
         * 原文:
         * When a creature is spawned by a dispenser dispensing an egg
         */
        DISPENSE_EGG,
        /**
         * 当一个僵尸感染一个村民时
         * 原文:
         * When a zombie infects a villager
         */
        INFECTION,
        /**
         * 当村民从僵尸状态痊愈时
         * 原文:
         * When a villager is cured from infection
         */
        CURED,
        /**
         * 当豹猫为了照顾自己的孩子而出生时
         * 原文:
         * When an ocelot has a baby spawned along with them
         */
        OCELOT_BABY,
        /**
         * 当一条蠹虫从方块中生成时
         * 原文:
         * When a silverfish spawns from a block
         */
        SILVERFISH_BLOCK,
        /**
         * 当一个实体成为其他实体坐骑时 (大多数时是鸡骑士)
         * 原文:
         * When an entity spawns as a mount of another entity (mostly chicken
         * jockeys)
         */
        MOUNT,
        /**
         * 当一个生物被插件生成时
         * 原文:
         * When a creature is spawned by plugins
         */
        CUSTOM,
        /**
         * 当一个实体无原因生成时
         * 原文
         * When an entity is missing a SpawnReason
         */
        DEFAULT
    }
}
