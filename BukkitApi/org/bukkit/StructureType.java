package org.bukkit;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bukkit.map.MapCursor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 此类处理所有结构类型的创建和存储。结构类型是世界/区块生成期间可以生成的不同种类的结构。包括村庄、矿井、林地府邸等。
 * <br>
 * 新 {@link StructureType} 的注册区分大小写。
 *
 * @deprecated 此类不能很好地表示世界的结构。请改用
 * {@link org.bukkit.generator.structure.Structure} 或
 * {@link org.bukkit.generator.structure.StructureType}。
 */
// Order is retrieved from WorldGenFactory
@Deprecated(since = "1.19")
public final class StructureType implements Keyed {

    private static final Map<String, StructureType> structureTypeMap = new HashMap<>();

    /**
     * 矿井是地下结构，由带有木质支撑和损坏铁轨的分支采矿隧道组成。
     * <br>
     * 它们是洞穴蜘蛛刷怪笼和带有箱子的矿车自然生成的唯一地点。
     */
    public static final StructureType MINESHAFT = register(new StructureType("mineshaft", MapCursor.Type.RED_X));

    /**
     * 村庄是自然生成的地面结构。
     * <br>
     * 它们通常在沙漠、平原、针叶林和热带草原生物群系中生成，是村民生成的地点，玩家可以与村民进行交易。
     */
    public static final StructureType VILLAGE = register(new StructureType("village", MapCursor.Type.MANSION));

    /**
     * 下界堡垒是主要由下界砖组成的大型建筑群。
     * <br>
     * 它们包含烈焰人刷怪笼、下界疣农场和战利品箱子。它们只在下界维度中生成。
     */
    public static final StructureType NETHER_FORTRESS = register(new StructureType("fortress", MapCursor.Type.RED_X));

    /**
     * 要塞是地下结构，由许多房间、图书馆和末地传送门房间组成。
     * <br>
     * 可以使用 {@link Material#ENDER_EYE} 找到它们。
     */
    public static final StructureType STRONGHOLD = register(new StructureType("stronghold", MapCursor.Type.MANSION));

    /**
     * 丛林金字塔（也称为丛林神庙）在丛林中被发现。
     * <br>
     * 它们通常由圆石和苔石组成。它们由三层组成，底层包含宝箱。
     */
    public static final StructureType JUNGLE_PYRAMID = register(new StructureType("jungle_pyramid", MapCursor.Type.RED_X));

    /**
     * 海洋废墟是许多不同方块的簇，在海洋生物群系的水下（以及海滩表面）生成。
     * <br>
     * 它们有多种不同的变体。冷变体主要由石砖组成，暖变体由砂岩组成。
     */
    public static final StructureType OCEAN_RUIN = register(new StructureType("ocean_ruin", MapCursor.Type.MONUMENT));

    /**
     * 沙漠金字塔（也称为沙漠神庙）在沙漠中被发现。
     * <br>
     * 它们通常由砂岩和彩色陶瓦组成。
     */
    public static final StructureType DESERT_PYRAMID = register(new StructureType("desert_pyramid", MapCursor.Type.RED_X));

    /**
     * 冰屋是在寒冷生物群系中生成的结构。
     * <br>
     * 它们由房屋和地下室组成。
     */
    public static final StructureType IGLOO = register(new StructureType("igloo", MapCursor.Type.RED_X));

    /**
     * 沼泽小屋（也称为女巫小屋）在沼泽生物群系中生成，并且能够生成女巫。
     */
    public static final StructureType SWAMP_HUT = register(new StructureType("swamp_hut", MapCursor.Type.RED_X));

    /**
     * 海洋神殿是水下结构。
     * <br>
     * 它们通常由三种不同的海晶石类型和海光灯组成。它们是守卫者和远古守卫者自然生成的唯一地点。
     */
    public static final StructureType OCEAN_MONUMENT = register(new StructureType("monument", MapCursor.Type.MONUMENT));

    /**
     * 末地城是在末地维度的外岛生成的高大城堡状结构。
     * <br>
     * 它们主要由末地石砖、紫珀块和末地烛组成。它们是潜影贝被发现的唯一地点。
     */
    public static final StructureType END_CITY = register(new StructureType("end_city", MapCursor.Type.RED_X));

    /**
     * 林地府邸是在黑暗森林中生成的巨大房屋结构，包含各种各样的房间。
     * <br>
     * 它们是唤魔者、卫道士和恼鬼自然生成的唯一地点（但仅生成一次）。
     */
    public static final StructureType WOODLAND_MANSION = register(new StructureType("mansion", MapCursor.Type.MANSION));

    /**
     * 埋藏的宝藏由一个埋在沙滩或沙砾中的单个箱子组成，里面有随机战利品。
     */
    public static final StructureType BURIED_TREASURE = register(new StructureType("buried_treasure", MapCursor.Type.RED_X));

    /**
     * 沉船是在海洋底部或海滩上生成的结构。
     * <br>
     * 它们由木材制成，包含 1-3 个战利品箱子。它们可以侧向、倒置或直立生成。
     */
    public static final StructureType SHIPWRECK = register(new StructureType("shipwreck", MapCursor.Type.RED_X));

    /**
     * 掠夺者前哨站可能包含弩。
     */
    public static final StructureType PILLAGER_OUTPOST = register(new StructureType("pillager_outpost", MapCursor.Type.RED_X));

    /**
     * 下界化石。
     */
    public static final StructureType NETHER_FOSSIL = register(new StructureType("nether_fossil", MapCursor.Type.RED_X));

    /**
     * 废弃传送门。
     */
    public static final StructureType RUINED_PORTAL = register(new StructureType("ruined_portal", MapCursor.Type.RED_X));

    /**
     * 堡垒遗迹。
     */
    public static final StructureType BASTION_REMNANT = register(new StructureType("bastion_remnant", MapCursor.Type.RED_X));

    /* ****************
     *  STRUCTURE TYPES REGISTERED ABOVE THIS
     * ****************
     */
    private final NamespacedKey key;
    private final MapCursor.Type mapCursor;

    /**
     * 使用给定的名称和地图光标创建新的 StructureType。要指示此结构不应与探索地图兼容，请对 <i>mapIcon</i> 使用 null。
     *
     * @param name 结构的名称，区分大小写。
     * @param mapIcon 此结构类型在创建探索地图时应使用的 {@link org.bukkit.map.MapCursor.Type}。使用 null 表示此结构不应与探索地图兼容。
     */
    private StructureType(@NotNull String name, @Nullable MapCursor.Type mapIcon) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "Structure name cannot be empty");
        this.key = NamespacedKey.minecraft(name);
        this.mapCursor = mapIcon;
    }

    /**
     * 获取此结构的名称。在命令中使用时区分大小写。
     *
     * @return 此结构的名称。
     *
     * 原文：
     * Get the name of this structure. This is case-sensitive when used in
     * commands.
     *
     * @return the name of this structure
     */
    @NotNull
    public String getName() {
        return key.getKey();
    }

    /**
     * 获取此结构在地图上使用的 {@link org.bukkit.map.MapCursor.Type}。如果为 null，此结构将不会出现在探索地图上。
     *
     * @return {@link org.bukkit.map.MapCursor.Type} 或 null。
     *
     * 原文：
     * Get the {@link org.bukkit.map.MapCursor.Type} that this structure can use on maps. If
     * this is null, this structure will not appear on explorer maps.
     *
     * @return the {@link org.bukkit.map.MapCursor.Type} or null.
     */
    @Nullable
    public MapCursor.Type getMapIcon() {
        return mapCursor;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StructureType)) {
            return false;
        }
        StructureType that = (StructureType) other;
        return this.key.equals(that.key) && this.mapCursor == that.mapCursor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.key);
        hash = 71 * hash + Objects.hashCode(this.mapCursor);
        return hash;
    }

    @Override
    public String toString() {
        return "StructureType{key=" + this.key + ", cursor=" + this.mapCursor + "}";
    }

    @NotNull
    private static <T extends StructureType> T register(@NotNull T type) {
        Preconditions.checkNotNull(type, "Cannot register null StructureType.");
        Preconditions.checkArgument(!structureTypeMap.containsKey(type.getName()), "Cannot register same StructureType twice. %s", type.getName());
        StructureType.structureTypeMap.put(type.getName(), type);
        return type;
    }

    /**
     * 获取所有已注册的 {@link StructureType}。
     *
     * @return 已注册结构类型的不可变副本。
     *
     * 原文：
     * Get all registered {@link StructureType}s.
     *
     * @return an immutable copy of registered structure types.
     */
    @NotNull
    public static Map<String, StructureType> getStructureTypes() {
        return ImmutableMap.copyOf(structureTypeMap);
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }
}