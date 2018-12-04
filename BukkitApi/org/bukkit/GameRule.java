package org.bukkit;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

/**
 * 游戏规则控制着Minecraft自身的某些行为.
 * <br>
 * 欲了解更多信息请访问
 * <a href="https://minecraft-zh.gamepedia.com/%E5%91%BD%E4%BB%A4#gamerule" target="_blank">Minecraft
 * Wiki</a>
 * <p>
 * 版权说明:以下常量翻译大部分引自 Minecraft Wiki.
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
     * 怪物能否捡起物品或修改方块.
     * <p>
     * 译注:其实这里的“怪物”(英文原文为mob)的范围非常广, 不仅指怪物, 还有村民动物等.
     * Mob包括的实体详见{@link org.bukkit.entity.Mob Mob接口文档}.
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

    // All GameRules instantiated above this for organizational purposes
    private final String name;
    private final Class<T> type;

    private GameRule(String name, Class<T> clazz) {
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
    public static GameRule<?> getByName(String rule) {
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
    public static GameRule<?>[] values() {
        return gameRules.values().toArray(new GameRule<?>[gameRules.size()]);
    }
}
