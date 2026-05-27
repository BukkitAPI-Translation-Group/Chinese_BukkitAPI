package org.bukkit.scoreboard;

import com.google.common.base.Preconditions;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.Statistic.Type;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

/**
 * 表示记分板条件，可以是自定义的或 Minecraft 服务器内置的，用于跟踪和手动或自动更改记分板上的分数。
 * <p>
 * 虽然此类概述了标准条件的常量，请参阅 {@link #statistic(Statistic)}（及其重载）以创建基于统计数据的条件实例。
 */
public interface Criteria {

    /**
     * 虚拟条件。不会被服务器更改。
     */
    public static final Criteria DUMMY = Bukkit.getScoreboardCriteria("dummy");
    /**
     * 触发条件。当玩家对目标运行 /trigger 命令时更改。
     */
    public static final Criteria TRIGGER = Bukkit.getScoreboardCriteria("trigger");
    /**
     * 当玩家死亡时自动递增。
     */
    public static final Criteria DEATH_COUNT = Bukkit.getScoreboardCriteria("deathCount");
    /**
     * 当玩家杀死另一个玩家时自动递增。
     */
    public static final Criteria PLAYER_KILL_COUNT = Bukkit.getScoreboardCriteria("playerKillCount");
    /**
     * 当玩家杀死另一个生物实体时自动递增。
     */
    public static final Criteria TOTAL_KILL_COUNT = Bukkit.getScoreboardCriteria("totalKillCount");
    /**
     * 反映玩家的生命值（0 为无生命，20 为默认最大生命值）。
     */
    public static final Criteria HEALTH = Bukkit.getScoreboardCriteria("health");
    /**
     * 反映玩家的饥饿值（0 为无饥饿，20 为最大饥饿值）。
     */
    public static final Criteria FOOD = Bukkit.getScoreboardCriteria("food");
    /**
     * 反映玩家的氧气供应（0 为无氧气，300 为最大氧气）。
     */
    public static final Criteria AIR = Bukkit.getScoreboardCriteria("air");
    /**
     * 反映玩家的护甲值（0 为无护甲，20 为最大护甲）。
     */
    public static final Criteria ARMOR = Bukkit.getScoreboardCriteria("armor");
    /**
     * 反映玩家的经验值。
     */
    public static final Criteria XP = Bukkit.getScoreboardCriteria("xp");
    /**
     * 反映玩家的经验等级。
     */
    public static final Criteria LEVEL = Bukkit.getScoreboardCriteria("level");

    /**
     * 当玩家杀死黑色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_BLACK = Bukkit.getScoreboardCriteria("teamkill.black");
    /**
     * 当玩家杀死深蓝色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_DARK_BLUE = Bukkit.getScoreboardCriteria("teamkill.dark_blue");
    /**
     * 当玩家杀死深绿色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_DARK_GREEN = Bukkit.getScoreboardCriteria("teamkill.dark_green");
    /**
     * 当玩家杀死青色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_DARK_AQUA = Bukkit.getScoreboardCriteria("teamkill.dark_aqua");
    /**
     * 当玩家杀死深红色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_DARK_RED = Bukkit.getScoreboardCriteria("teamkill.dark_red");
    /**
     * 当玩家杀死深紫色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_DARK_PURPLE = Bukkit.getScoreboardCriteria("teamkill.dark_purple");
    /**
     * 当玩家杀死金色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_GOLD = Bukkit.getScoreboardCriteria("teamkill.gold");
    /**
     * 当玩家杀死灰色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_GRAY = Bukkit.getScoreboardCriteria("teamkill.gray");
    /**
     * 当玩家杀死深灰色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_DARK_GRAY = Bukkit.getScoreboardCriteria("teamkill.dark_gray");
    /**
     * 当玩家杀死蓝色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_BLUE = Bukkit.getScoreboardCriteria("teamkill.blue");
    /**
     * 当玩家杀死绿色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_GREEN = Bukkit.getScoreboardCriteria("teamkill.green");
    /**
     * 当玩家杀死青色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_AQUA = Bukkit.getScoreboardCriteria("teamkill.aqua");
    /**
     * 当玩家杀死红色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_RED = Bukkit.getScoreboardCriteria("teamkill.red");
    /**
     * 当玩家杀死浅紫色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_LIGHT_PURPLE = Bukkit.getScoreboardCriteria("teamkill.light_purple");
    /**
     * 当玩家杀死黄色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_YELLOW = Bukkit.getScoreboardCriteria("teamkill.yellow");
    /**
     * 当玩家杀死白色队伍的另一个玩家时自动递增。
     */
    public static final Criteria TEAM_KILL_WHITE = Bukkit.getScoreboardCriteria("teamkill.white");

    /**
     * 当玩家被黑色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_BLACK = Bukkit.getScoreboardCriteria("killedByTeam.black");
    /**
     * 当玩家被深蓝色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_DARK_BLUE = Bukkit.getScoreboardCriteria("killedByTeam.dark_blue");
    /**
     * 当玩家被深绿色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_DARK_GREEN = Bukkit.getScoreboardCriteria("killedByTeam.dark_green");
    /**
     * 当玩家被青色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_DARK_AQUA = Bukkit.getScoreboardCriteria("killedByTeam.dark_aqua");
    /**
     * 当玩家被深红色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_DARK_RED = Bukkit.getScoreboardCriteria("killedByTeam.dark_red");
    /**
     * 当玩家被深紫色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_DARK_PURPLE = Bukkit.getScoreboardCriteria("killedByTeam.dark_purple");
    /**
     * 当玩家被金色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_GOLD = Bukkit.getScoreboardCriteria("killedByTeam.gold");
    /**
     * 当玩家被灰色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_GRAY = Bukkit.getScoreboardCriteria("killedByTeam.gray");
    /**
     * 当玩家被深灰色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_DARK_GRAY = Bukkit.getScoreboardCriteria("killedByTeam.dark_gray");
    /**
     * 当玩家被蓝色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_BLUE = Bukkit.getScoreboardCriteria("killedByTeam.blue");
    /**
     * 当玩家被绿色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_GREEN = Bukkit.getScoreboardCriteria("killedByTeam.green");
    /**
     * 当玩家被青色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_AQUA = Bukkit.getScoreboardCriteria("killedByTeam.aqua");
    /**
     * 当玩家被红色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_RED = Bukkit.getScoreboardCriteria("killedByTeam.red");
    /**
     * 当玩家被浅紫色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_LIGHT_PURPLE = Bukkit.getScoreboardCriteria("killedByTeam.light_purple");
    /**
     * 当玩家被黄色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_YELLOW = Bukkit.getScoreboardCriteria("killedByTeam.yellow");
    /**
     * 当玩家被白色队伍的另一个玩家杀死时自动递增。
     */
    public static final Criteria KILLED_BY_TEAM_WHITE = Bukkit.getScoreboardCriteria("killedByTeam.white");

    /**
     * 获取此条件的名称（其唯一标识符）。
     * <p>
     * 原文：Get the name of this criteria (its unique id).
     *
     * @return 名称
     */
    @NotNull
    public String getName();

    /**
     * 获取此条件是否为只读。如果为只读，则使用此条件的记分板无法更改其分数。
     * <p>
     * 原文：Get whether or not this criteria is read only. If read only, scoreboards with this criteria cannot have their scores changed.
     *
     * @return 如果为只读则返回 true，否则返回 false
     */
    public boolean isReadOnly();

    /**
     * 获取此条件默认使用的 {@link RenderType}。
     * <p>
     * 原文：Get the {@link RenderType} used by default for this criteria.
     *
     * @return 默认渲染类型
     */
    @NotNull
    public RenderType getDefaultRenderType();

    /**
     * 获取与方块或物品相关的指定统计信息的 {@link Criteria}。
     * <p>
     * 此方法期望一个 {@link Type#BLOCK} 或 {@link Type#ITEM} 的 {@link Statistic} 以及与该类型匹配的 {@link Material}（例如，BLOCK 统计需要 {@link Material#isBlock()} 为 true 的材料）。这是一个便捷方法，用于创建更复杂的复合条件，例如在方块破坏或物品使用时递增的条件。一个例子是 {@code Criteria.statistic(Statistic.CRAFT_ITEM, Material.STICK)}，返回表示 "minecraft.crafted:minecraft.stick" 的条件，当玩家制作棍子时会递增。
     * <p>
     * 如果提供的统计信息不需要额外数据，则会调用并返回 {@link #statistic(Statistic)}。
     * <p>
     * 此方法不保证任何给定条件存在于原版服务器上。
     * <p>
     * 原文：Get a {@link Criteria} for the specified statistic pertaining to blocks or items. This method expects a {@link Statistic} of {@link Type#BLOCK} or {@link Type#ITEM} and the {@link Material} matching said type (e.g. BLOCK statistics require materials where {@link Material#isBlock()} is true). This acts as a convenience to create more complex compound criteria such as those that increment on block breaks, or item uses. An example would be {@code Criteria.statistic(Statistic.CRAFT_ITEM, Material.STICK)}, returning a Criteria representing "minecraft.crafted:minecraft.stick" which will increment when the player crafts a stick. If the provided statistic does not require additional data, {@link #statistic(Statistic)} is called and returned instead. This method provides no guarantee that any given criteria exists on the vanilla server.
     *
     * @param statistic 要获取条件的统计信息
     * @param material 相关材料
     * @return 条件
     * @throws IllegalArgumentException 如果 {@link Statistic#getType()} 不是 {@link Type#BLOCK} 或 {@link Type#ITEM}
     * @throws IllegalArgumentException 如果 {@link Statistic#getType()} 是 {@link Type#BLOCK}，但 {@link Material#isBlock()} 为 false
     * @throws IllegalArgumentException 如果 {@link Statistic#getType()} 是 {@link Type#ITEM}，但 {@link Material#isItem()} 为 false
     */
    @NotNull
    public static Criteria statistic(@NotNull Statistic statistic, @NotNull Material material) {
        Preconditions.checkArgument(statistic != null, "statistic must not be null");
        Preconditions.checkArgument(material != null, "material must not be null");

        Type type = statistic.getType();
        Preconditions.checkArgument(type == Type.BLOCK || type == Type.ITEM, "statistic type must be either BLOCK or ITEM, given %s", type);
        Preconditions.checkArgument(type != Type.BLOCK || material.isBlock(), "statistic type is BLOCK but got non-block Material, %s", material);
        Preconditions.checkArgument(type != Type.ITEM || material.isItem(), "statistic type is ITEM but got non-item Material, %s", material);

        // Good use case for a switch expression
        if (type == Type.BLOCK) {
            switch (statistic) {
                case MINE_BLOCK:
                    return Bukkit.getScoreboardCriteria("minecraft.mined:minecraft." + material.getKey().getKey());
                default:
                    break;
            }
        } else if (type == Type.ITEM) {
            switch (statistic) {
                case BREAK_ITEM:
                    return Bukkit.getScoreboardCriteria("minecraft.broken:minecraft." + material.getKey().getKey());
                case CRAFT_ITEM:
                    return Bukkit.getScoreboardCriteria("minecraft.crafted:minecraft." + material.getKey().getKey());
                case USE_ITEM:
                    return Bukkit.getScoreboardCriteria("minecraft.used:minecraft." + material.getKey().getKey());
                case PICKUP:
                    return Bukkit.getScoreboardCriteria("minecraft.picked_up:minecraft." + material.getKey().getKey());
                case DROP:
                    return Bukkit.getScoreboardCriteria("minecraft.dropped:minecraft." + material.getKey().getKey());
                default:
                    break;
            }
        }

        return statistic(statistic); // Fallback to a regular statistic
    }

    /**
     * 获取与实体类型相关的指定统计信息的 {@link Criteria}。
     * <p>
     * 此方法期望一个 {@link Type#ENTITY} 的 {@link Statistic}。这是一个便捷方法，用于创建更复杂的复合条件，例如被特定实体类型杀死的条件。一个例子是 {@code Criteria.statistic(Statistic.KILL_ENTITY, EntityType.CREEPER)}，返回表示 "minecraft.killed:minecraft.creeper" 的条件，当玩家杀死苦力怕时会递增。
     * <p>
     * 如果提供的统计信息不需要额外数据，则会调用并返回 {@link #statistic(Statistic)}。
     * <p>
     * 此方法不保证任何给定条件存在于原版服务器上。
     * <p>
     * 原文：Get a {@link Criteria} for the specified statistic pertaining to an entity type. This method expects a {@link Statistic} of {@link Type#ENTITY}. This acts as a convenience to create more complex compound criteria such as being killed by a specific entity type. An example would be {@code Criteria.statistic(Statistic.KILL_ENTITY, EntityType.CREEPER)}, returning a Criteria representing "minecraft.killed:minecraft.creeper" which will increment when the player kills a creepers. If the provided statistic does not require additional data, {@link #statistic(Statistic)} is called and returned instead. This method provides no guarantee that any given criteria exists on the vanilla server.
     *
     * @param statistic 要获取条件的统计信息
     * @param entityType 相关实体类型
     * @return 条件
     * @throws IllegalArgumentException 如果 {@link Statistic#getType()} 不是 {@link Type#ENTITY}
     */
    @NotNull
    public static Criteria statistic(@NotNull Statistic statistic, @NotNull EntityType entityType) {
        Preconditions.checkArgument(statistic != null, "statistic must not be null");
        Preconditions.checkArgument(entityType != null, "entityType must not be null");
        Preconditions.checkArgument(statistic.getType() == Type.ENTITY, "statistic type must be ENTITY, given %s", statistic.getType());

        switch (statistic) {
            case KILL_ENTITY:
                return Bukkit.getScoreboardCriteria("minecraft.killed:minecraft." + entityType.getKey().getKey());
            case ENTITY_KILLED_BY:
                return Bukkit.getScoreboardCriteria("minecraft.killed_by:minecraft." + entityType.getKey().getKey());
            default:
                break;
        }

        return statistic(statistic); // Fallback to a regular statistic
    }

    /**
     * 获取指定统计信息的 {@link Criteria}。
     * <p>
     * 一个例子是 {@code Criteria.statistic(Statistic.FLY_ONE_CM)}，返回表示 "minecraft.custom:minecraft.aviate_one_cm" 的条件，当玩家使用鞘翅飞行时会递增。
     * <p>
     * 此方法不保证任何给定条件存在于原版服务器上。所有统计信息都被接受，但如果需要额外数据，某些可能无法按预期运行。对于方块/物品相关的统计信息，请参阅 {@link #statistic(Statistic, Material)}；对于实体相关的统计信息，请参阅 {@link #statistic(Statistic, EntityType)}。
     * <p>
     * 原文：Get a {@link Criteria} for the specified statistic. An example would be {@code Criteria.statistic(Statistic.FLY_ONE_CM)}, returning a Criteria representing "minecraft.custom:minecraft.aviate_one_cm" which will increment when the player flies with an elytra. This method provides no guarantee that any given criteria exists on the vanilla server. All statistics are accepted, however some may not operate as expected if additional data is required. For block/item-related statistics, see {@link #statistic(Statistic, Material)}, and for entity-related statistics, see {@link #statistic(Statistic, EntityType)}
     *
     * @param statistic 要获取条件的统计信息
     * @return 条件
     */
    @NotNull
    public static Criteria statistic(@NotNull Statistic statistic) {
        Preconditions.checkArgument(statistic != null, "statistic must not be null");
        return Bukkit.getScoreboardCriteria("minecraft.custom:minecraft." + statistic.getKey().getKey());
    }

    /**
     * 通过名称获取（或创建）一个新的 {@link Criteria}。
     * <p>
     * 原文：Get (or create) a new {@link Criteria} by its name.
     *
     * @param name 条件名称
     * @return 创建的条件
     */
    @NotNull
    public static Criteria create(@NotNull String name) {
        return Bukkit.getScoreboardCriteria(name);
    }

}
