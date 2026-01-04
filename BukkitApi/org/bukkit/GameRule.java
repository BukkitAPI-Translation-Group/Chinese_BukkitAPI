package org.bukkit;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.ApiStatus;
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
public interface GameRule<T> extends Keyed, RegistryAware {

    // Boolean rules
    /**
     * 是否在聊天框中公告玩家进度的达成.
     */
    public static final GameRule<Boolean> SHOW_ADVANCEMENT_MESSAGES = getRule("show_advancement_messages");

    /**
     * 命令方块执行命令时是否在聊天框中向管理员显示.
     */
    public static final GameRule<Boolean> COMMAND_BLOCK_OUTPUT = getRule("command_block_output");

    /**
     * Whether the server should skip checking player speed.
     */
    public static final GameRule<Boolean> PLAYER_MOVEMENT_CHECK = getRule("player_movement_check");

    /**
     * 是否让服务器停止检查使用鞘翅玩家的移动速度.
     * 有助于减轻因服务器延迟而导致的飞行卡顿, 但有可能导致生存模式下玩家飞行过快 (作弊).
     */
    public static final GameRule<Boolean> ELYTRA_MOVEMENT_CHECK = getRule("elytra_movement_check");

    /**
     * 是否进行日夜交替和月相变化.
     */
    public static final GameRule<Boolean> ADVANCE_TIME = getRule("advance_time");

    /**
     * 非生物实体是否掉落物品.
     */
    public static final GameRule<Boolean> ENTITY_DROPS = getRule("entity_drops");

    /**
     * 玩家的合成配方是否需要解锁才能使用.
     */
    public static final GameRule<Boolean> LIMITED_CRAFTING = getRule("limited_crafting");

    /**
     * 生物在死亡是否掉落物品 (战利品).
     */
    public static final GameRule<Boolean> MOB_DROPS = getRule("mob_drops");

    /**
     * Whether projectiles can break blocks.
     */
    public static final GameRule<Boolean> PROJECTILES_CAN_BREAK_BLOCKS = getRule("projectiles_can_break_blocks");

    /**
     * 生物是否自然生成. 不影响刷怪箱.
     */
    public static final GameRule<Boolean> SPAWN_MOBS = getRule("spawn_mobs");

    /**
     * 方块被破坏时是否掉落物品.
     */
    public static final GameRule<Boolean> BLOCK_DROPS = getRule("block_drops");

    /**
     * 天气是否变化.
     */
    public static final GameRule<Boolean> ADVANCE_WEATHER = getRule("advance_weather");

    /**
     * 玩家死亡后是否保留物品栏物品 (死亡时物品不掉落).
     */
    public static final GameRule<Boolean> KEEP_INVENTORY = getRule("keep_inventory");

    /**
     * 是否在服务器日志中记录管理员使用过的命令.
     */
    public static final GameRule<Boolean> LOG_ADMIN_COMMANDS = getRule("log_admin_commands");

    /**
     * 生物能否捡起物品, 修改以及破坏方块.
     * <p>
     * 译注:Mob包括的实体详见{@link org.bukkit.entity.Mob Mob接口文档}.
     */
    public static final GameRule<Boolean> MOB_GRIEFING = getRule("mob_griefing");

    /**
     * 玩家是否能在饥饿值足够时自然恢复生命值
     * (不影响外部治疗效果, 如金苹果、生命恢复状态效果等).
     */
    public static final GameRule<Boolean> NATURAL_HEALTH_REGENERATION = getRule("natural_health_regeneration");

    /**
     * 调式屏幕是否显示简化的信息而非详细信息.
     */
    public static final GameRule<Boolean> REDUCED_DEBUG_INFO = getRule("reduced_debug_info");

    /**
     * 玩家执行命令的返回信息是否在聊天框中显示.
     * 同时影响命令方块是否保存命令输出文本.
     */
    public static final GameRule<Boolean> SEND_COMMAND_FEEDBACK = getRule("send_command_feedback");

    /**
     * 是否在聊天框中显示玩家以及驯养宠物的死亡信息.
     */
    public static final GameRule<Boolean> SHOW_DEATH_MESSAGES = getRule("show_death_messages");

    /**
     * 是否允许旁观模式的玩家生成区块.
     */
    public static final GameRule<Boolean> SPECTATORS_GENERATE_CHUNKS = getRule("spectators_generate_chunks");

    /**
     * 是否禁用<a href="https://zh.minecraft.wiki/w/%E8%A2%AD%E5%87%BB" target="_blank">袭击</a>.
     */
    public static final GameRule<Boolean> RAIDS = getRule("raids");

    /**
     * <a href="https://zh.minecraft.wiki/w/%E5%B9%BB%E7%BF%BC" target="_blank">幻翼</a>是否在夜晚生成.
     */
    public static final GameRule<Boolean> SPAWN_PHANTOMS = getRule("spawn_phantoms");

    /**
     * 玩家死亡时是否不显示死亡界面直接重生.
     */
    public static final GameRule<Boolean> IMMEDIATE_RESPAWN = getRule("immediate_respawn");

    /**
     * 玩家是否承受窒息伤害.
     */
    public static final GameRule<Boolean> DROWNING_DAMAGE = getRule("drowning_damage");

    /**
     * 玩家是否承受跌落伤害.
     */
    public static final GameRule<Boolean> FALL_DAMAGE = getRule("fall_damage");

    /**
     * 玩家是否承受火焰伤害.
     */
    public static final GameRule<Boolean> FIRE_DAMAGE = getRule("fire_damage");

    /**
     * 玩家是否承受冰冻伤害.
     */
    public static final GameRule<Boolean> FREEZE_DAMAGE = getRule("freeze_damage");

    /**
     * <a href="https://zh.minecraft.wiki/w/%E7%81%BE%E5%8E%84%E5%B7%A1%E9%80%BB%E9%98%9F" target="_blank">灾厄巡逻队</a>是否自然生成.
     */
    public static final GameRule<Boolean> SPAWN_PATROLS = getRule("spawn_patrols");

    /**
     * <a href="https://zh.minecraft.wiki/w/%E6%B5%81%E6%B5%AA%E5%95%86%E4%BA%BA" target="_blank">流浪商人</a>是否自然生成.
     */
    public static final GameRule<Boolean> SPAWN_WANDERING_TRADERS = getRule("spawn_wandering_traders");

    /**
     * Whether wardens should naturally spawn.
     */
    public static final GameRule<Boolean> SPAWN_WARDENS = getRule("spawn_wardens");

    /**
     * 当被激怒的中立生物的目标玩家死亡时, 此生物是否恢复中立状态.
     */
    public static final GameRule<Boolean> FORGIVE_DEAD_PLAYERS = getRule("forgive_dead_players");

    /**
     * 当中立生物被激怒时, 是否攻击附近所有玩家 (而不仅仅是激怒此生物的玩家).
     */
    public static final GameRule<Boolean> UNIVERSAL_ANGER = getRule("universal_anger");

    /**
     * Whether block explosions will destroy dropped items.
     */
    public static final GameRule<Boolean> BLOCK_EXPLOSION_DROP_DECAY = getRule("block_explosion_drop_decay");
    /**
     * * Whether mob explosions will destroy dropped items.
     */
    public static final GameRule<Boolean> MOB_EXPLOSION_DROP_DECAY = getRule("mob_explosion_drop_decay");
    /**
     * Whether tnt explosions will destroy dropped items.
     */
    public static final GameRule<Boolean> TNT_EXPLOSION_DROP_DECAY = getRule("tnt_explosion_drop_decay");
    /**
     * Whether water blocks can convert into water source blocks.
     */
    public static final GameRule<Boolean> WATER_SOURCE_CONVERSION = getRule("water_source_conversion");
    /**
     * Whether lava blocks can convert into lava source blocks.
     */
    public static final GameRule<Boolean> LAVA_SOURCE_CONVERSION = getRule("lava_source_conversion");
    /**
     * Whether global level events such as ender dragon, wither, and completed
     * end portal effects will propagate across the entire server.
     */
    public static final GameRule<Boolean> GLOBAL_SOUND_EVENTS = getRule("global_sound_events");
    /**
     * Whether vines will spread.
     */
    public static final GameRule<Boolean> SPREAD_VINES = getRule("spread_vines");
    /**
     * Whether ender pearls will vanish on player death.
     */
    public static final GameRule<Boolean> ENDER_PEARLS_VANISH_ON_DEATH = getRule("ender_pearls_vanish_on_death");
    /**
     * Whether TNT explodes.
     */
    public static final GameRule<Boolean> TNT_EXPLODES = getRule("tnt_explodes");
    /**
     * Whether the locator bar is enabled.
     */
    public static final GameRule<Boolean> LOCATOR_BAR = getRule("locator_bar");
    /**
     * Whether PvP is enabled.
     */
    public static final GameRule<Boolean> PVP = getRule("pvp");
    /**
     * Whether nether portals can be used to enter the nether.
     */
    public static final GameRule<Boolean> ALLOW_ENTERING_NETHER_USING_PORTALS = getRule("allow_entering_nether_using_portals");
    /**
     * Whether monsters will spawn.
     */
    public static final GameRule<Boolean> SPAWN_MONSTERS = getRule("spawn_monsters");
    /**
     * Whether command blocks are enabled.
     */
    public static final GameRule<Boolean> COMMAND_BLOCKS_WORK = getRule("command_blocks_work");
    /**
     * Whether spawner blocks are enabled.
     */
    public static final GameRule<Boolean> SPAWNER_BLOCKS_WORK = getRule("spawner_blocks_work");

    // Numerical rules
    /**
     * 每游戏刻每区块中随机的方块刻发生的频率 (例如植物生长，树叶腐烂等).
     * 为0时禁用随机刻, 较高的数字将增大随机刻频率.
     */
    public static final GameRule<Integer> RANDOM_TICK_SPEED = getRule("random_tick_speed");

    /**
     * 首次进入服务器的玩家和没有重生点的死亡玩家在重生时与世界重生点坐标的距离.
     */
    public static final GameRule<Integer> RESPAWN_RADIUS = getRule("respawn_radius");

    /**
     * 玩家或生物能同时推动其它可推动实体的数量, 超过此数量时将承受窒息伤害.
     * <br>
     * 设置成0可以停用这个规则.
     */
    public static final GameRule<Integer> MAX_ENTITY_CRAMMING = getRule("max_entity_cramming");

    /**
     * 指定工作在连锁模式的命令方块的总数量.
     * <br>
     * 该值是在同一连锁同一tick时可激活的最大命令方块数量.
     */
    public static final GameRule<Integer> MAX_COMMAND_SEQUENCE_LENGTH = getRule("max_command_sequence_length");

    /**
     * Determines the number of different commands/functions which execute
     * commands can fork into.
     */
    public static final GameRule<Integer> MAX_COMMAND_FORKS = getRule("max_command_forks");

    /**
     * Determines the maximum number of blocks which a command can modify.
     */
    public static final GameRule<Integer> MAX_BLOCK_MODIFICATIONS = getRule("max_block_modifications");

    /**
     * 服务器跳过夜晚所需的入睡玩家的占比.
     */
    public static final GameRule<Integer> PLAYERS_SLEEPING_PERCENTAGE = getRule("players_sleeping_percentage");
    public static final GameRule<Integer> MAX_SNOW_ACCUMULATION_HEIGHT = getRule("max_snow_accumulation_height");

    /**
     * The amount of time a player must stand in a nether portal before the
     * portal activates.
     */
    public static final GameRule<Integer> PLAYERS_NETHER_PORTAL_DEFAULT_DELAY = getRule("players_nether_portal_default_delay");

    /**
     * The amount of time a player in creative mode must stand in a nether
     * portal before the portal activates.
     */
    public static final GameRule<Integer> PLAYERS_NETHER_PORTAL_CREATIVE_DELAY = getRule("players_nether_portal_creative_delay");

    /**
     * The maximum speed of minecarts (when the new movement algorithm is
     * enabled).
     */
    @ApiStatus.Experimental
    @MinecraftExperimental(MinecraftExperimental.Requires.MINECART_IMPROVEMENTS)
    public static final GameRule<Integer> MAX_MINECART_SPEED = getRule("max_minecart_speed");

    /**
     * The radius in blocks that fire can spread around a player (0 to disable spread, -1 to allow spread without players).
     */
    public static final GameRule<Integer> FIRE_SPREAD_RADIUS_AROUND_PLAYER = getRule("fire_spread_radius_around_player");

    @NotNull
    private static <T> GameRule<T> getRule(@NotNull String key) {
        return Registry.GAME_RULE.getOrThrow(NamespacedKey.minecraft(key));
    }

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.11")
    NamespacedKey getKey();

    /**
     * 获取此游戏规则的名称.
     * <p>
     * 原文:Get the name of this GameRule.
     *
     * @return 游戏规则名
     * @deprecated 请使用 {@link #getKey()}
     */
    @NotNull
    @Deprecated(since = "1.21.11")
    public String getName();

    /**
     * 获取此游戏规则的数据类型.
     * <p>
     * 原文:Get the type of this rule.
     *
     * @return 游戏规则的数据类型;Integer 或 Boolean
     */
    @NotNull
    public Class<T> getType();

    /**
     * 按名称获取{@link GameRule 游戏规则}.
     * <p>
     * 原文:Get a {@link GameRule} by its name.
     *
     * @param rule 游戏规则名
     * @return {@link GameRule 游戏规则}, 若没有与给定名称相匹配的GameRule返回null
     * @deprecated 仅作向下兼容, 请使用 {@link Registry#get(NamespacedKey)} instead.
     */
    @Nullable
    @Deprecated(since = "1.21.11")
    public static GameRule<?> getByName(@NotNull String rule) {
        Preconditions.checkNotNull(rule, "Rule cannot be null");
        return (!rule.isEmpty()) ? Bukkit.getUnsafe().get(Registry.GAME_RULE, NamespacedKey.fromString(rule.toLowerCase(Locale.ROOT))) : null;
    }

    /**
     * 获取 {@link GameRule} 数组.
     * <p>
     * 原文:Get an array of {@link GameRule}s.
     *
     * @return 包含所有已注册游戏规则的不可变集合
     * @deprecated 请使用 {@link Registry#iterator()}.
     */
    @NotNull
    @Deprecated(since = "1.21.11")
    public static GameRule<?>[] values() {
        return Lists.newArrayList(Registry.GAME_RULE).toArray(new GameRule<?>[0]);
    }
}
