package org.bukkit.event.entity;

import org.bukkit.Chunk;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.world.ChunkLoadEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 当一个生物体在世界中出生时触发该事件.
 * <p>
 * 如果该事件被取消了,那么这个生物将不会出生.
 */
public class CreatureSpawnEvent extends EntitySpawnEvent {
    private final SpawnReason spawnReason;

    public CreatureSpawnEvent(@NotNull final LivingEntity spawnee, @NotNull final SpawnReason spawnReason) {
        super(spawnee);
        this.spawnReason = spawnReason;
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * 返回生物出生的原因
     * <p>
     * 原文:
     * Gets the reason for why the creature is being spawned.
     *
     * @return 出生原因
     */
    @NotNull
    public SpawnReason getSpawnReason() {
        return spawnReason;
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
         *
         * @deprecated 不再调用, 区块与已经存在的实体一同生成.
         * 请考虑使用{@link ChunkLoadEvent#isNewChunk()} 和 {@link Chunk#getEntities()}
         * 以达到类似效果
         */
        @Deprecated
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
         * 由于苦力怕等发生爆炸产生效果云时/When eg an effect cloud is spawned as a result of a creeper exploding
         */
        EXPLOSION,
        /**
         * When an entity is spawned as part of a raid
         */
        RAID,
        /**
         * When an entity is spawned as part of a patrol
         */
        PATROL,
        /**
         * When a bee is released from a beehive/bee nest
         */
        BEEHIVE,
        /**
         * When a piglin is converted to a zombified piglib.
         */
        PIGLIN_ZOMBIFIED,
        /**
         * When an entity is shaking in Powder Snow and a new entity spawns.
         */
        FROZEN,
        /**
         * When a creature is spawned by the "/summon" command
         */
        COMMAND,
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