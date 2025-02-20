package org.bukkit;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 游戏规则控制着Minecraft自身的某些行为.
 * <br>
 * 欲了解更多信息请访问
 * <a href="https://zh.minecraft.wiki/w/%E5%91%BD%E4%BB%A4/gamerule" target="_blank">Minecraft
 * Wiki</a>
 * <p>
 * 版权说明:以下常量翻译大部分引自 Minecraft Wiki.
 * @param <T> 游戏规则数值类型 (布尔值或整数)
 */
public final class GameRule<T> {

    private static Map<String, GameRule<?>> gameRules = new HashMap<>();
    // Boolean rules
    /**
     * 是否在聊天框中公告玩家进度的达成.
     */
    public static final GameRule<Boolean> ANNOUNCE_ADVANCEMENTS = new GameRule<>("announceAdvancements", Boolean.class);

    /**
     * 命令方块执行命令时是否在聊天框中向管理员显示.
     */
    public static final GameRule<Boolean> COMMAND_BLOCK_OUTPUT = new GameRule<>("commandBlockOutput", Boolean.class);

    /**
     * 是否让服务器停止检查使用鞘翅玩家的移动速度.
     * 有助于减轻因服务器延迟而导致的飞行卡顿, 但有可能导致生存模式下玩家飞行过快 (作弊).
     */
    public static final GameRule<Boolean> DISABLE_ELYTRA_MOVEMENT_CHECK = new GameRule<>("disableElytraMovementCheck", Boolean.class);

    /**
     * 是否进行日夜交替和月相变化.
     */
    public static final GameRule<Boolean> DO_DAYLIGHT_CYCLE = new GameRule<>("doDaylightCycle", Boolean.class);

    /**
     * 非生物实体是否掉落物品.
     */
    public static final GameRule<Boolean> DO_ENTITY_DROPS = new GameRule<>("doEntityDrops", Boolean.class);

    /**
     * 火是否蔓延及自然熄灭.
     */
    public static final GameRule<Boolean> DO_FIRE_TICK = new GameRule<>("doFireTick", Boolean.class);

    /**
     * 玩家的合成配方是否需要解锁才能使用.
     */
    public static final GameRule<Boolean> DO_LIMITED_CRAFTING = new GameRule<>("doLimitedCrafting", Boolean.class);

    /**
     * 生物在死亡是否掉落物品 (战利品).
     */
    public static final GameRule<Boolean> DO_MOB_LOOT = new GameRule<>("doMobLoot", Boolean.class);

    /**
     * Whether projectiles can break blocks.
     */
    public static final GameRule<Boolean> PROJECTILES_CAN_BREAK_BLOCKS = new GameRule<>("projectilesCanBreakBlocks", Boolean.class);

    /**
     * 生物是否自然生成. 不影响刷怪箱.
     */
    public static final GameRule<Boolean> DO_MOB_SPAWNING = new GameRule<>("doMobSpawning", Boolean.class);

    /**
     * 方块被破坏时是否掉落物品.
     */
    public static final GameRule<Boolean> DO_TILE_DROPS = new GameRule<>("doTileDrops", Boolean.class);

    /**
     * 天气是否变化.
     */
    public static final GameRule<Boolean> DO_WEATHER_CYCLE = new GameRule<>("doWeatherCycle", Boolean.class);

    /**
     * 玩家死亡后是否保留物品栏物品 (死亡时物品不掉落).
     */
    public static final GameRule<Boolean> KEEP_INVENTORY = new GameRule<>("keepInventory", Boolean.class);

    /**
     * 是否在服务器日志中记录管理员使用过的命令.
     */
    public static final GameRule<Boolean> LOG_ADMIN_COMMANDS = new GameRule<>("logAdminCommands", Boolean.class);

    /**
     * 生物能否捡起物品, 修改以及破坏方块.
     * <p>
     * 译注:Mob包括的实体详见{@link org.bukkit.entity.Mob Mob接口文档}.
     */
    public static final GameRule<Boolean> MOB_GRIEFING = new GameRule<>("mobGriefing", Boolean.class);

    /**
     * 玩家是否能在饥饿值足够时自然恢复生命值
     * (不影响外部治疗效果, 如金苹果、生命恢复状态效果等).
     */
    public static final GameRule<Boolean> NATURAL_REGENERATION = new GameRule<>("naturalRegeneration", Boolean.class);

    /**
     * 调式屏幕是否显示简化的信息而非详细信息.
     */
    public static final GameRule<Boolean> REDUCED_DEBUG_INFO = new GameRule<>("reducedDebugInfo", Boolean.class);

    /**
     * 玩家执行命令的返回信息是否在聊天框中显示.
     * 同时影响命令方块是否保存命令输出文本.
     */
    public static final GameRule<Boolean> SEND_COMMAND_FEEDBACK = new GameRule<>("sendCommandFeedback", Boolean.class);

    /**
     * 是否在聊天框中显示玩家以及驯养宠物的死亡信息.
     */
    public static final GameRule<Boolean> SHOW_DEATH_MESSAGES = new GameRule<>("showDeathMessages", Boolean.class);

    /**
     * 是否允许旁观模式的玩家生成区块.
     */
    public static final GameRule<Boolean> SPECTATORS_GENERATE_CHUNKS = new GameRule<>("spectatorsGenerateChunks", Boolean.class);

    /**
     * 是否禁用<a href="https://zh.minecraft.wiki/w/%E8%A2%AD%E5%87%BB" target="_blank">袭击</a>.
     */
    public static final GameRule<Boolean> DISABLE_RAIDS = new GameRule<>("disableRaids", Boolean.class);

    /**
     * <a href="https://zh.minecraft.wiki/w/%E5%B9%BB%E7%BF%BC" target="_blank">幻翼</a>是否在夜晚生成.
     */
    public static final GameRule<Boolean> DO_INSOMNIA = new GameRule<>("doInsomnia", Boolean.class);

    /**
     * 玩家死亡时是否不显示死亡界面直接重生.
     */
    public static final GameRule<Boolean> DO_IMMEDIATE_RESPAWN = new GameRule<>("doImmediateRespawn", Boolean.class);

    /**
     * 玩家是否承受窒息伤害.
     */
    public static final GameRule<Boolean> DROWNING_DAMAGE = new GameRule<>("drowningDamage", Boolean.class);

    /**
     * 玩家是否承受跌落伤害.
     */
    public static final GameRule<Boolean> FALL_DAMAGE = new GameRule<>("fallDamage", Boolean.class);

    /**
     * 玩家是否承受火焰伤害.
     */
    public static final GameRule<Boolean> FIRE_DAMAGE = new GameRule<>("fireDamage", Boolean.class);

    /**
     * 玩家是否承受冰冻伤害.
     */
    public static final GameRule<Boolean> FREEZE_DAMAGE = new GameRule<>("freezeDamage", Boolean.class);

    /**
     * <a href="https://zh.minecraft.wiki/w/%E7%81%BE%E5%8E%84%E5%B7%A1%E9%80%BB%E9%98%9F" target="_blank">灾厄巡逻队</a>是否自然生成.
     */
    public static final GameRule<Boolean> DO_PATROL_SPAWNING = new GameRule<>("doPatrolSpawning", Boolean.class);

    /**
     * <a href="https://zh.minecraft.wiki/w/%E6%B5%81%E6%B5%AA%E5%95%86%E4%BA%BA" target="_blank">流浪商人</a>是否自然生成.
     */
    public static final GameRule<Boolean> DO_TRADER_SPAWNING = new GameRule<>("doTraderSpawning", Boolean.class);

    /**
     * Whether wardens should naturally spawn.
     */
    public static final GameRule<Boolean> DO_WARDEN_SPAWNING = new GameRule<>("doWardenSpawning", Boolean.class);

    /**
     * 当被激怒的中立生物的目标玩家死亡时, 此生物是否恢复中立状态.
     */
    public static final GameRule<Boolean> FORGIVE_DEAD_PLAYERS = new GameRule<>("forgiveDeadPlayers", Boolean.class);

    /**
     * 当中立生物被激怒时, 是否攻击附近所有玩家 (而不仅仅是激怒此生物的玩家).
     */
    public static final GameRule<Boolean> UNIVERSAL_ANGER = new GameRule<>("universalAnger", Boolean.class);

    /**
     * Whether block explosions will destroy dropped items.
     */
    public static final GameRule<Boolean> BLOCK_EXPLOSION_DROP_DECAY = new GameRule<>("blockExplosionDropDecay", Boolean.class);
    /**
     * * Whether mob explosions will destroy dropped items.
     */
    public static final GameRule<Boolean> MOB_EXPLOSION_DROP_DECAY = new GameRule<>("mobExplosionDropDecay", Boolean.class);
    /**
     * Whether tnt explosions will destroy dropped items.
     */
    public static final GameRule<Boolean> TNT_EXPLOSION_DROP_DECAY = new GameRule<>("tntExplosionDropDecay", Boolean.class);
    /**
     * Whether water blocks can convert into water source blocks.
     */
    public static final GameRule<Boolean> WATER_SOURCE_CONVERSION = new GameRule<>("waterSourceConversion", Boolean.class);
    /**
     * Whether lava blocks can convert into lava source blocks.
     */
    public static final GameRule<Boolean> LAVA_SOURCE_CONVERSION = new GameRule<>("lavaSourceConversion", Boolean.class);
    /**
     * Whether global level events such as ender dragon, wither, and completed
     * end portal effects will propagate across the entire server.
     */
    public static final GameRule<Boolean> GLOBAL_SOUND_EVENTS = new GameRule<>("globalSoundEvents", Boolean.class);
    /**
     * Whether vines will spread.
     */
    public static final GameRule<Boolean> DO_VINES_SPREAD = new GameRule<>("doVinesSpread", Boolean.class);
    /**
     * Whether ender pearls will vanish on player death.
     */
    public static final GameRule<Boolean> ENDER_PEARLS_VANISH_ON_DEATH = new GameRule<>("enderPearlsVanishOnDeath", Boolean.class);

    // Numerical rules
    /**
     * 每游戏刻每区块中随机的方块刻发生的频率 (例如植物生长，树叶腐烂等).
     * 为0时禁用随机刻, 较高的数字将增大随机刻频率.
     */
    public static final GameRule<Integer> RANDOM_TICK_SPEED = new GameRule<>("randomTickSpeed", Integer.class);

    /**
     * 首次进入服务器的玩家和没有重生点的死亡玩家在重生时与世界重生点坐标的距离.
     */
    public static final GameRule<Integer> SPAWN_RADIUS = new GameRule<>("spawnRadius", Integer.class);

    /**
     * 玩家或生物能同时推动其它可推动实体的数量, 超过此数量时将承受窒息伤害.
     * <br>
     * 设置成0可以停用这个规则.
     */
    public static final GameRule<Integer> MAX_ENTITY_CRAMMING = new GameRule<>("maxEntityCramming", Integer.class);

    /**
     * 指定工作在连锁模式的命令方块的总数量.
     * <br>
     * 该值是在同一连锁同一tick时可激活的最大命令方块数量.
     */
    public static final GameRule<Integer> MAX_COMMAND_CHAIN_LENGTH = new GameRule<>("maxCommandChainLength", Integer.class);

    /**
     * Determines the number of different commands/functions which execute
     * commands can fork into.
     */
    public static final GameRule<Integer> MAX_COMMAND_FORK_COUNT = new GameRule<>("maxCommandForkCount", Integer.class);

    /**
     * Determines the maximum number of blocks which a command can modify.
     */
    public static final GameRule<Integer> COMMAND_MODIFICATION_BLOCK_LIMIT = new GameRule<>("commandModificationBlockLimit", Integer.class);

    /**
     * 服务器跳过夜晚所需的入睡玩家的占比.
     */
    public static final GameRule<Integer> PLAYERS_SLEEPING_PERCENTAGE = new GameRule<>("playersSleepingPercentage", Integer.class);
	public static final GameRule<Integer> SNOW_ACCUMULATION_HEIGHT = new GameRule<>("snowAccumulationHeight", Integer.class);

    /**
     * The amount of time a player must stand in a nether portal before the
     * portal activates.
     */
    public static final GameRule<Integer> PLAYERS_NETHER_PORTAL_DEFAULT_DELAY = new GameRule<>("playersNetherPortalDefaultDelay", Integer.class);

    /**
     * The amount of time a player in creative mode must stand in a nether
     * portal before the portal activates.
     */
    public static final GameRule<Integer> PLAYERS_NETHER_PORTAL_CREATIVE_DELAY = new GameRule<>("playersNetherPortalCreativeDelay", Integer.class);

    /**
     * The number of chunks around spawn which will be kept loaded at all times.
     */
    public static final GameRule<Integer> SPAWN_CHUNK_RADIUS = new GameRule<>("spawnChunkRadius", Integer.class);

    // All GameRules instantiated above this for organizational purposes
    private final String name;
    private final Class<T> type;

    private GameRule(@NotNull String name, @NotNull Class<T> clazz) {
        Preconditions.checkNotNull(name, "GameRule name cannot be null");
        Preconditions.checkNotNull(clazz, "GameRule type cannot be null");
        Preconditions.checkArgument(clazz == Boolean.class || clazz == Integer.class, "Must be of type Boolean or Integer. Found %s ", clazz.getName());
        this.name = name;
        this.type = clazz;
        gameRules.put(name, this);
    }

    /**
     * 获取此游戏规则的名称.
     * <p>
     * 原文:Get the name of this GameRule.
     *
     * @return 游戏规则名
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * 获取此游戏规则的数据类型.
     * <p>
     * 原文:Get the type of this rule.
     *
     * @return 游戏规则的数据类型;Integer 或 Boolean
     */
    @NotNull
    public Class<T> getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameRule)) {
            return false;
        }
        GameRule<?> other = (GameRule<?>) obj;
        return this.getName().equals(other.getName()) && this.getType() == other.getType();
    }

    @Override
    public String toString() {
        return "GameRule{" + "key=" + name + ", type=" + type + '}';
    }

    /**
     * 按名称获取{@link GameRule 游戏规则}.
     * <p>
     * 原文:Get a {@link GameRule} by its name.
     *
     * @param rule 游戏规则名
     * @return {@link GameRule 游戏规则}, 若没有与给定名称相匹配的GameRule返回null
     */
    @Nullable
    public static GameRule<?> getByName(@NotNull String rule) {
        Preconditions.checkNotNull(rule, "Rule cannot be null");
        return gameRules.get(rule);
    }

    /**
     * 获取一个不可变的{@link GameRule 游戏规则}集合.
     * <p>
     * 原文:Get an immutable collection of {@link GameRule}s.
     *
     * @return 包含所有已注册游戏规则的不可变集合
     */
    @NotNull
    public static GameRule<?>[] values() {
        return gameRules.values().toArray(new GameRule<?>[gameRules.size()]);
    }
}
