package org.bukkit;

import java.util.Set;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

/**
 * 表示一个标签，可以由服务器或资源包定义，用于将相似的事物分组在一起。
 *
 * 注意，虽然此接口中定义的所有标签必须在实现中存在，但它们的存在不保证在未来的版本中延续。
 *
 * @param <T> 此标签分组的事物类型
 */
public interface Tag<T extends Keyed> extends Keyed {

    /**
     * 内置方块注册表的键。
     */
    String REGISTRY_BLOCKS = "blocks";
    /**
     * 原版方块标签，代表所有颜色的羊毛。
     */
    Tag<Material> WOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wool"), Material.class);
    /**
     * 原版方块标签，代表所有木板变体。
     */
    Tag<Material> PLANKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("planks"), Material.class);
    /**
     * 原版方块标签，代表所有普通/苔石/裂纹/錾制石砖。
     * bricks.
     */
    Tag<Material> STONE_BRICKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_bricks"), Material.class);
    /**
     * 原版方块标签，代表所有木质按钮。
     */
    Tag<Material> WOODEN_BUTTONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_buttons"), Material.class);
    /**
     * 原版方块标签，代表所有石质按钮。
     */
    Tag<Material> STONE_BUTTONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_buttons"), Material.class);
    /**
     * 原版方块标签，代表所有按钮（继承自
     * {@link #WOODEN_BUTTONS}.
     */
    Tag<Material> BUTTONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("buttons"), Material.class);
    /**
     * 原版方块标签，代表所有颜色的地毯。
     */
    Tag<Material> WOOL_CARPETS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wool_carpets"), Material.class);
    /**
     * @deprecated {@link #WOOL_CARPETS}.
     */
    @Deprecated(since = "1.19")
    Tag<Material> CARPETS = WOOL_CARPETS;
    /**
     * 原版方块标签，代表所有木质门。
     */
    Tag<Material> WOODEN_DOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_doors"), Material.class);
    /**
     * 原版方块标签，代表所有可被生物打开的门。
     */
    Tag<Material> MOB_INTERACTABLE_DOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mob_interactable_doors"), Material.class);
    /**
     * 原版方块标签，代表所有木质楼梯。
     */
    Tag<Material> WOODEN_STAIRS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_stairs"), Material.class);
    /**
     * 原版方块标签，代表所有木质台阶。
     */
    Tag<Material> WOODEN_SLABS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_slabs"), Material.class);
    /**
     * 原版方块标签，代表所有木质栅栏。
     */
    Tag<Material> WOODEN_FENCES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_fences"), Material.class);
    /**
     * 原版方块标签，代表所有压力板。
     */
    Tag<Material> PRESSURE_PLATES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("pressure_plates"), Material.class);
    /**
     * 原版方块标签，代表所有木质压力板。
     */
    Tag<Material> WOODEN_PRESSURE_PLATES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_pressure_plates"), Material.class);
    /**
     * 原版方块标签，代表所有木质架子。
     */
    Tag<Material> WOODEN_SHELVES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_shelves"), Material.class);
    /**
     * 原版方块标签，代表所有石质压力板。
     */
    Tag<Material> STONE_PRESSURE_PLATES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_pressure_plates"), Material.class);
    /**
     * 原版方块标签，代表所有木质活板门。
     */
    Tag<Material> WOODEN_TRAPDOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wooden_trapdoors"), Material.class);
    /**
     * 原版方块标签，代表所有门（继承自
     * {@link #WOODEN_DOORS}.
     */
    Tag<Material> DOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("doors"), Material.class);
    /**
     * 原版方块标签，代表所有树苗变体。
     */
    Tag<Material> SAPLINGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("saplings"), Material.class);
    /**
     * 原版方块标签，代表所有可燃烧的原木和树皮变体。
     */
    Tag<Material> LOGS_THAT_BURN = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("logs_that_burn"), Material.class);
    /**
     * 原版方块标签，代表所有原木和树皮变体。
     */
    Tag<Material> LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("logs"), Material.class);
    /**
     * 原版方块标签，代表所有深色橡木原木和树皮变体。
     */
    Tag<Material> DARK_OAK_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dark_oak_logs"), Material.class);
    /**
     * 原版方块标签，代表所有苍白橡木原木和树皮变体。
     */
    Tag<Material> PALE_OAK_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("pale_oak_logs"), Material.class);
    /**
     * 原版方块标签，代表所有橡木原木和树皮变体。
     */
    Tag<Material> OAK_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("oak_logs"), Material.class);
    /**
     * 原版方块标签，代表所有白桦原木和树皮变体。
     */
    Tag<Material> BIRCH_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("birch_logs"), Material.class);
    /**
     * 原版方块标签，代表所有金合欢原木和树皮变体。
     */
    Tag<Material> ACACIA_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("acacia_logs"), Material.class);
    /**
     * 原版方块标签，代表所有樱花原木和树皮变体。
     */
    Tag<Material> CHERRY_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cherry_logs"), Material.class);
    /**
     * 原版方块标签，代表所有丛林原木和树皮变体。
     */
    Tag<Material> JUNGLE_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("jungle_logs"), Material.class);
    /**
     * 原版方块标签，代表所有云杉原木和树皮变体。
     */
    Tag<Material> SPRUCE_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("spruce_logs"), Material.class);
    /**
     * 原版方块标签，代表所有红树原木和树皮变体。
     */
    Tag<Material> MANGROVE_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_logs"), Material.class);
    /**
     * 原版方块标签，代表所有在主世界自然生成的原木。
     */
    Tag<Material> OVERWORLD_NATURAL_LOGS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("overworld_natural_logs"), Material.class);
    /**
     * 原版方块标签，代表所有绯红菌柄。
     */
    Tag<Material> CRIMSON_STEMS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crimson_stems"), Material.class);
    /**
     * 原版方块标签，代表所有诡异菌柄。
     */
    Tag<Material> WARPED_STEMS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("warped_stems"), Material.class);
    /**
     * 原版方块标签，代表所有竹块。
     */
    Tag<Material> BAMBOO_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bamboo_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有旗帜方块。
     */
    Tag<Material> BANNERS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("banners"), Material.class);
    /**
     * 原版方块标签，代表所有沙子方块。
     */
    Tag<Material> SAND = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sand"), Material.class);
    /**
     * 原版方块标签，代表所有在熔炉中烧炼为玻璃的方块。
     */
    Tag<Material> SMELTS_TO_GLASS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("smelts_to_glass"), Material.class);
    /**
     * 原版方块标签，代表所有楼梯。
     */
    Tag<Material> STAIRS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stairs"), Material.class);
    /**
     * 原版方块标签，代表所有台阶。
     */
    Tag<Material> SLABS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("slabs"), Material.class);
    /**
     * 原版方块标签，代表所有墙。
     */
    Tag<Material> WALLS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("walls"), Material.class);
    /**
     * 原版方块标签，代表所有损坏和未损坏的铁砧。
     */
    Tag<Material> ANVIL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("anvil"), Material.class);
    /**
     * 原版方块标签，代表所有矿车铁轨。
     */
    Tag<Material> RAILS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("rails"), Material.class);
    /**
     * 原版方块标签，代表所有树叶。
     */
    Tag<Material> LEAVES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("leaves"), Material.class);
    /**
     * 原版方块标签，代表所有活板门（继承自
     * {@link #WOODEN_TRAPDOORS}.
     */
    Tag<Material> TRAPDOORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("trapdoors"), Material.class);
    /**
     * 原版方块标签，代表所有空和有花的花盆。
     */
    Tag<Material> FLOWER_POTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("flower_pots"), Material.class);
    /**
     * 原版方块标签，代表所有小型花卉。
     */
    Tag<Material> SMALL_FLOWERS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("small_flowers"), Material.class);
    /**
     * 原版方块标签，代表所有床。
     */
    Tag<Material> BEDS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beds"), Material.class);
    /**
     * 原版方块标签，代表所有栅栏。
     */
    Tag<Material> FENCES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fences"), Material.class);
    /**
     * 原版方块标签，代表所有花卉。
     */
    Tag<Material> FLOWERS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("flowers"), Material.class);
    /**
     * 原版方块标签，代表所有吸引蜜蜂的方块。
     */
    Tag<Material> BEE_ATTRACTIVE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bee_attractive"), Material.class);
    /**
     * 原版方块标签，代表所有猪灵驱避物。
     */
    Tag<Material> PIGLIN_REPELLENTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("piglin_repellents"), Material.class);
    /**
     * 原版方块标签，代表所有金矿石。
     */
    Tag<Material> GOLD_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("gold_ores"), Material.class);
    /**
     * 原版方块标签，代表所有铁矿石。
     */
    Tag<Material> IRON_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("iron_ores"), Material.class);
    /**
     * 原版方块标签，代表所有钻石矿石。
     */
    Tag<Material> DIAMOND_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("diamond_ores"), Material.class);
    /**
     * 原版方块标签，代表所有红石矿石。
     */
    Tag<Material> REDSTONE_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("redstone_ores"), Material.class);
    /**
     * 原版方块标签，代表所有青金石矿石。
     */
    Tag<Material> LAPIS_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lapis_ores"), Material.class);
    /**
     * 原版方块标签，代表所有煤矿石。
     */
    Tag<Material> COAL_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coal_ores"), Material.class);
    /**
     * 原版方块标签，代表所有绿宝石矿石。
     */
    Tag<Material> EMERALD_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("emerald_ores"), Material.class);
    /**
     * 原版方块标签，代表所有铜矿石。
     */
    Tag<Material> COPPER_ORES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("copper_ores"), Material.class);
    /**
     * 原版方块标签，代表所有蜡烛。
     */
    Tag<Material> CANDLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("candles"), Material.class);
    /**
     * 原版方块标签，代表所有泥土。
     */
    Tag<Material> DIRT = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dirt"), Material.class);
    /**
     * 原版方块标签，代表所有陶瓦。
     */
    Tag<Material> TERRACOTTA = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("terracotta"), Material.class);
    /**
     * 原版方块标签，代表所有恶地陶瓦。
     */
    Tag<Material> BADLANDS_TERRACOTTA = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("badlands_terracotta"), Material.class);
    /**
     * 原版方块标签，代表所有混凝土粉末。
     */
    Tag<Material> CONCRETE_POWDER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("concrete_powder"), Material.class);
    /**
     * 原版方块标签，代表所有可完成寻找树教程的方块。
     */
    Tag<Material> COMPLETES_FIND_TREE_TUTORIAL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("completes_find_tree_tutorial"), Material.class);
    /**
     * 原版方块标签，表示末影人可拾取和持有的方块。
     */
    Tag<Material> ENDERMAN_HOLDABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enderman_holdable"), Material.class);
    /**
     * 原版方块标签，表示冰方块。
     */
    Tag<Material> ICE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ice"), Material.class);
    /**
     * 原版方块标签，表示所有有效生物生成位置。
     */
    Tag<Material> VALID_SPAWN = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("valid_spawn"), Material.class);
    /**
     * 原版方块标签，表示不滴落流体的不可渗透方块。
     */
    Tag<Material> IMPERMEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("impermeable"), Material.class);
    /**
     * 原版方块标签，表示所有可使用骨粉的水下方块。
     */
    Tag<Material> UNDERWATER_BONEMEALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("underwater_bonemeals"), Material.class);
    /**
     * 原版方块标签，代表所有珊瑚方块。
     */
    Tag<Material> CORAL_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coral_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有墙壁珊瑚。
     */
    Tag<Material> WALL_CORALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_corals"), Material.class);
    /**
     * 原版方块标签，代表所有珊瑚植物。
     */
    Tag<Material> CORAL_PLANTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("coral_plants"), Material.class);
    /**
     * 原版方块标签，代表所有珊瑚。
     */
    Tag<Material> CORALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("corals"), Material.class);
    /**
     * 原版方块标签，表示所有可种植竹子的方块。
     */
    Tag<Material> BAMBOO_PLANTABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bamboo_plantable_on"), Material.class);
    /**
     * 原版方块标签，代表所有立式告示牌。
     */
    Tag<Material> STANDING_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("standing_signs"), Material.class);
    /**
     * 原版方块标签，代表所有墙壁告示牌。
     */
    Tag<Material> WALL_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_signs"), Material.class);
    /**
     * 原版方块标签，代表所有普通告示牌。
     */
    Tag<Material> SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("signs"), Material.class);
    /**
     * 原版方块标签，代表所有天花板告示牌。
     */
    Tag<Material> CEILING_HANGING_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ceiling_hanging_signs"), Material.class);
    /**
     * 原版方块标签，代表所有墙壁悬挂式告示牌。
     */
    Tag<Material> WALL_HANGING_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_hanging_signs"), Material.class);
    /**
     * 原版方块标签，代表所有悬挂式告示牌。
     */
    Tag<Material> ALL_HANGING_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("all_hanging_signs"), Material.class);
    /**
     * 原版方块标签，代表所有告示牌，不分类型。
     */
    Tag<Material> ALL_SIGNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("all_signs"), Material.class);
    /**
     * 原版方块标签，代表所有免疫龙的方块。
     */
    Tag<Material> DRAGON_IMMUNE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dragon_immune"), Material.class);
    /**
     * 原版方块标签，代表所有对末影龙透明的方块。
     */
    Tag<Material> DRAGON_TRANSPARENT = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dragon_transparent"), Material.class);
    /**
     * 原版方块标签，代表所有免疫凋灵的方块。
     */
    Tag<Material> WITHER_IMMUNE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wither_immune"), Material.class);
    /**
     * 原版方块标签，代表所有用于召唤凋灵的基座方块。
     */
    Tag<Material> WITHER_SUMMON_BASE_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wither_summon_base_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有蜂巢。
     */
    Tag<Material> BEEHIVES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beehives"), Material.class);
    /**
     * 原版方块标签，代表所有农作物。
     */
    Tag<Material> CROPS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crops"), Material.class);
    /**
     * 原版方块标签，代表所有蜜蜂可生长的方块。
     */
    Tag<Material> BEE_GROWABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bee_growables"), Material.class);
    /**
     * 原版方块标签，代表所有传送门。
     */
    Tag<Material> PORTALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("portals"), Material.class);
    /**
     * 原版方块标签，代表所有火方块。
     */
    Tag<Material> FIRE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fire"), Material.class);
    /**
     * 原版方块标签，代表所有菌岩方块。
     */
    Tag<Material> NYLIUM = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("nylium"), Material.class);
    /**
     * 原版方块标签，代表所有疣块。
     */
    Tag<Material> WART_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wart_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有信标基座方块。
     */
    Tag<Material> BEACON_BASE_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("beacon_base_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有受灵魂疾行附魔影响的方块。
     */
    Tag<Material> SOUL_SPEED_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("soul_speed_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有墙柱覆盖。
     */
    Tag<Material> WALL_POST_OVERRIDE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wall_post_override"), Material.class);
    /**
     * 原版方块标签，代表所有可攀爬的方块。
     */
    Tag<Material> CLIMBABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("climbable"), Material.class);
    /**
     * 原版方块标签，代表所有重置摔落伤害的方块。
     */
    Tag<Material> FALL_DAMAGE_RESETTING = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fall_damage_resetting"), Material.class);
    /**
     * 原版方块标签，代表所有潜影盒。
     */
    Tag<Material> SHULKER_BOXES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("shulker_boxes"), Material.class);
    /**
     * 原版方块标签，代表所有铜箱子。
     */
    Tag<Material> COPPER_CHESTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("copper_chests"), Material.class);
    /**
     * 原版方块标签，代表所有避雷针。
     */
    Tag<Material> LIGHTNING_RODS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lightning_rods"), Material.class);
    /**
     * 原版方块标签，代表所有铜。
     */
    Tag<Material> COPPER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("copper"), Material.class);
    /**
     * 原版方块标签，代表所有金属链。
     */
    Tag<Material> CHAINS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("chains"), Material.class);
    /**
     * 原版方块标签，代表所有铜傀儡雕像。
     */
    Tag<Material> COPPER_GOLEM_STATUES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("copper_golem_statues"), Material.class);
    /**
     * 原版方块标签，代表所有灯笼。
     */
    Tag<Material> LANTERNS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lanterns"), Material.class);
    /**
     * 原版方块标签，代表所有金属栏杆。
     */
    Tag<Material> BARS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bars"), Material.class);
    /**
     * 原版方块标签，代表所有疣猪兽驱避物。
     */
    Tag<Material> HOGLIN_REPELLENTS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("hoglin_repellents"), Material.class);
    /**
     * 原版方块标签，代表所有灵魂火基座方块。
     */
    Tag<Material> SOUL_FIRE_BASE_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("soul_fire_base_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有炽足兽温暖方块。
     */
    Tag<Material> STRIDER_WARM_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("strider_warm_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有营火。
     */
    Tag<Material> CAMPFIRES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("campfires"), Material.class);
    /**
     * 原版方块标签，代表所有被猪灵守护的方块。
     */
    Tag<Material> GUARDED_BY_PIGLINS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("guarded_by_piglins"), Material.class);
    /**
     * 原版方块标签，代表所有阻止内部生物生成的方块。
     */
    Tag<Material> PREVENT_MOB_SPAWNING_INSIDE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("prevent_mob_spawning_inside"), Material.class);
    /**
     * 原版方块标签，代表所有栅栏门。
     */
    Tag<Material> FENCE_GATES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("fence_gates"), Material.class);
    /**
     * 原版方块标签，代表所有不稳定底部中心方块。
     */
    Tag<Material> UNSTABLE_BOTTOM_CENTER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("unstable_bottom_center"), Material.class);
    /**
     * 原版方块标签，代表所有蘑菇可生长的方块。
     */
    Tag<Material> MUSHROOM_GROW_BLOCK = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mushroom_grow_block"), Material.class);
    /**
     * 原版方块标签，代表所有可被绵羊食用的方块。
     */
    Tag<Material> EDIBLE_FOR_SHEEP = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("edible_for_sheep"), Material.class);
    /**
     * 原版方块标签，代表所有玩家使用鞘翅滑翔时可通过的方块。
     */
    Tag<Material> CAN_GLIDE_THROUGH = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("can_glide_through"), Material.class);
    /**
     * 原版方块标签，代表所有在
     * overworld.
     */
    Tag<Material> INFINIBURN_OVERWORLD = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_overworld"), Material.class);
    /**
     * 原版方块标签，代表所有在
     * nether.
     */
    Tag<Material> INFINIBURN_NETHER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_nether"), Material.class);
    /**
     * 原版方块标签，代表所有在末地中永远燃烧的方块。
     */
    Tag<Material> INFINIBURN_END = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("infiniburn_end"), Material.class);
    /**
     * 原版方块标签，代表 the overworld base material.
     */
    Tag<Material> BASE_STONE_OVERWORLD = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("base_stone_overworld"), Material.class);
    /**
     * 原版方块标签，代表所有可被矿石替代的方块。
     */
    Tag<Material> STONE_ORE_REPLACEABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("stone_ore_replaceables"), Material.class);
    /**
     * 原版方块标签，代表所有可被深板岩矿石替代的方块。
     */
    Tag<Material> DEEPSLATE_ORE_REPLACEABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("deepslate_ore_replaceables"), Material.class);
    /**
     * 原版方块标签，代表 the nether base material.
     */
    Tag<Material> BASE_STONE_NETHER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("base_stone_nether"), Material.class);
    /**
     * 原版方块标签，代表所有可被主世界雕刻器替代的方块。
     */
    Tag<Material> OVERWORLD_CARVER_REPLACEABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("overworld_carver_replaceables"), Material.class);
    /**
     * 原版方块标签，代表所有可被下界雕刻器替代的方块。
     */
    Tag<Material> NETHER_CARVER_REPLACEABLES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("nether_carver_replaceables"), Material.class);
    /**
     * 原版方块标签，代表所有蜡烛蛋糕。
     */
    Tag<Material> CANDLE_CAKES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("candle_cakes"), Material.class);
    /**
     * 原版方块标签，代表所有炼药锅。
     */
    Tag<Material> CAULDRONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cauldrons"), Material.class);
    /**
     * 原版方块标签，代表所有产生水晶声音的方块。
     */
    Tag<Material> CRYSTAL_SOUND_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("crystal_sound_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有播放低沉脚步声的方块。
     */
    Tag<Material> INSIDE_STEP_SOUND_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("inside_step_sound_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有播放组合脚步声的方块。
     */
    Tag<Material> COMBINATION_STEP_SOUND_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("combination_step_sound_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有骆驼在沙子上行走时播放脚步声的方块。
     */
    Tag<Material> CAMEL_SAND_STEP_SOUND_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("camel_sand_step_sound_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有快乐恶魂避开的方块。
     */
    Tag<Material> HAPPY_GHAST_AVOIDS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("happy_ghast_avoids"), Material.class);
    /**
     * 原版方块标签，代表所有阻挡振动信号的方块。
     */
    Tag<Material> OCCLUDES_VIBRATION_SIGNALS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("occludes_vibration_signals"), Material.class);
    /**
     * 原版方块标签，代表所有抑制振动信号传播的方块。
     */
    Tag<Material> DAMPENS_VIBRATIONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dampens_vibrations"), Material.class);
    /**
     * 原版方块标签，代表所有可被滴水石替代的方块。
     */
    Tag<Material> DRIPSTONE_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dripstone_replaceable_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有洞穴藤蔓。
     */
    Tag<Material> CAVE_VINES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("cave_vines"), Material.class);
    /**
     * 原版方块标签，代表所有可被苔藓替代的方块。
     */
    Tag<Material> MOSS_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("moss_replaceable"), Material.class);
    /**
     * 原版方块标签，代表所有可被繁茂地面替代的方块。
     */
    Tag<Material> LUSH_GROUND_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lush_ground_replaceable"), Material.class);
    /**
     * 原版方块标签，代表所有可被杜鹃根替代的方块。
     */
    Tag<Material> AZALEA_ROOT_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("azalea_root_replaceable"), Material.class);
    /**
     * 原版方块标签，代表所有可放置小型垂叶的方块。
     */
    Tag<Material> SMALL_DRIPLEAF_PLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("small_dripleaf_placeable"), Material.class);
    /**
     * 原版方块标签，代表所有可放置大型垂叶的方块。
     */
    Tag<Material> BIG_DRIPLEAF_PLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("big_dripleaf_placeable"), Material.class);
    /**
     * 原版方块标签，代表所有雪方块。
     */
    Tag<Material> SNOW = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow"), Material.class);
    /**
     * 原版方块标签，代表所有可用斧开采的方块。
     */
    Tag<Material> MINEABLE_AXE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/axe"), Material.class);
    /**
     * 原版方块标签，代表所有可用锄开采的方块。
     */
    Tag<Material> MINEABLE_HOE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/hoe"), Material.class);
    /**
     * 原版方块标签，代表所有可用镐开采的方块。
     */
    Tag<Material> MINEABLE_PICKAXE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/pickaxe"), Material.class);
    /**
     * 原版方块标签，代表所有可用锹开采的方块。
     */
    Tag<Material> MINEABLE_SHOVEL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mineable/shovel"), Material.class);
    /**
     * 原版方块标签，代表所有可用剑高效开采的方块。
     */
    Tag<Material> SWORD_EFFICIENT = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sword_efficient"), Material.class);
    /**
     * 原版方块标签，代表所有可用剑瞬间开采的方块。
     */
    Tag<Material> SWORD_INSTANTLY_MINES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sword_instantly_mines"), Material.class);
    /**
     * 原版方块标签，代表所有需要钻石工具的方块。
     */
    Tag<Material> NEEDS_DIAMOND_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_diamond_tool"), Material.class);
    /**
     * 原版方块标签，代表所有需要铁工具的方块。
     */
    Tag<Material> NEEDS_IRON_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_iron_tool"), Material.class);
    /**
     * 原版方块标签，代表所有需要石质工具的方块。
     */
    Tag<Material> NEEDS_STONE_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("needs_stone_tool"), Material.class);
    /**
     * 原版方块标签，代表所有使用下界合金工具不掉落物品的方块。
     */
    Tag<Material> INCORRECT_FOR_NETHERITE_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("incorrect_for_netherite_tool"), Material.class);
    /**
     * 原版方块标签，代表所有使用钻石工具不掉落物品的方块。
     */
    Tag<Material> INCORRECT_FOR_DIAMOND_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("incorrect_for_diamond_tool"), Material.class);
    /**
     * 原版方块标签，代表所有使用铁工具不掉落物品的方块。
     */
    Tag<Material> INCORRECT_FOR_IRON_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("incorrect_for_iron_tool"), Material.class);
    /**
     * 原版方块标签，代表所有使用铜工具不掉落物品的方块。
     */
    Tag<Material> INCORRECT_FOR_COPPER_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("incorrect_for_copper_tool"), Material.class);
    /**
     * 原版方块标签，代表所有使用石质工具不掉落物品的方块。
     */
    Tag<Material> INCORRECT_FOR_STONE_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("incorrect_for_stone_tool"), Material.class);
    /**
     * 原版方块标签，代表所有使用金工具不掉落物品的方块。
     */
    Tag<Material> INCORRECT_FOR_GOLD_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("incorrect_for_gold_tool"), Material.class);
    /**
     * 原版方块标签，代表所有使用木质工具不掉落物品的方块。
     */
    Tag<Material> INCORRECT_FOR_WOODEN_TOOL = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("incorrect_for_wooden_tool"), Material.class);
    /**
     * 原版方块标签，代表所有不会被世界生成特性替代的方块。
     */
    Tag<Material> FEATURES_CANNOT_REPLACE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("features_cannot_replace"), Material.class);
    /**
     * 原版方块标签，代表所有岩浆池不会替代的方块。
     */
    Tag<Material> LAVA_POOL_STONE_CANNOT_REPLACE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("lava_pool_stone_cannot_replace"), Material.class);
    /**
     * 原版方块标签，代表所有晶洞不会生成的方块。
     */
    Tag<Material> GEODE_INVALID_BLOCKS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("geode_invalid_blocks"), Material.class);
    /**
     * 原版方块标签，代表所有青蛙偏好跳向的方块。
     */
    Tag<Material> FROG_PREFER_JUMP_TO = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("frog_prefer_jump_to"), Material.class);
    /**
     * 原版方块标签，代表所有可被幽匿替代的方块。
     */
    Tag<Material> SCULK_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sculk_replaceable"), Material.class);
    /**
     * 原版方块标签，代表所有在世界生成期间可被幽匿替代的方块。
     */
    Tag<Material> SCULK_REPLACEABLE_WORLD_GEN = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sculk_replaceable_world_gen"), Material.class);
    /**
     * 原版方块标签，代表所有可被远古城市替代的方块。
     */
    Tag<Material> ANCIENT_CITY_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("ancient_city_replaceable"), Material.class);
    /**
     * 原版方块标签，代表所有共振振动的方块。
     */
    Tag<Material> VIBRATION_RESONATORS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("vibration_resonators"), Material.class);
    /**
     * 原版方块标签，代表所有动物可生成的方块。
     */
    Tag<Material> ANIMALS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("animals_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有犰狳可生成的方块。
     */
    Tag<Material> ARMADILLO_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("armadillo_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有美西螈可生成的方块。
     */
    Tag<Material> AXOLOTLS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("axolotls_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有山羊可生成的方块。
     */
    Tag<Material> GOATS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("goats_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有哞菇可生成的方块。
     */
    Tag<Material> MOOSHROOMS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mooshrooms_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有鹦鹉可生成的方块。
     */
    Tag<Material> PARROTS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("parrots_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有北极熊可生成的方块。
     */
    Tag<Material> POLAR_BEARS_SPAWNABLE_ON_ALTERNATE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("polar_bears_spawnable_on_alternate"), Material.class);
    /**
     * 原版方块标签，代表所有兔子可生成的方块。
     */
    Tag<Material> RABBITS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("rabbits_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有狐狸可生成的方块。
     */
    Tag<Material> FOXES_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("foxes_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有狼可生成的方块。
     */
    Tag<Material> WOLVES_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("wolves_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有青蛙可生成的方块。
     */
    Tag<Material> FROGS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("frogs_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有蝙蝠可生成的方块。
     */
    Tag<Material> BATS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("bats_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有骆驼可生成的方块。
     */
    Tag<Material> CAMELS_SPAWNABLE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("camels_spawnable_on"), Material.class);
    /**
     * 原版方块标签，代表所有杜鹃花可生长的方块。
     */
    Tag<Material> AZALEA_GROWS_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("azalea_grows_on"), Material.class);
    /**
     * 原版方块标签，代表所有可转化为泥巴的方块。
     */
    Tag<Material> CONVERTABLE_TO_MUD = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("convertable_to_mud"), Material.class);
    /**
     * 原版方块标签，代表所有红树原木可穿透生长的方块。
     */
    Tag<Material> MANGROVE_LOGS_CAN_GROW_THROUGH = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_logs_can_grow_through"), Material.class);
    /**
     * 原版方块标签，代表所有红树根可穿透生长的方块。
     */
    Tag<Material> MANGROVE_ROOTS_CAN_GROW_THROUGH = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("mangrove_roots_can_grow_through"), Material.class);
    /**
     * 原版方块标签，代表所有可放置干燥植被的方块。
     */
    Tag<Material> DRY_VEGETATION_MAY_PLACE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("dry_vegetation_may_place_on"), Material.class);
    /**
     * 原版方块标签，代表所有可放置枯萎灌木的方块。
     *
     * @deprecated 使用 {@link #DRY_VEGETATION_MAY_PLACE_ON}
     */
    @Deprecated(since = "1.21.5")
    Tag<Material> DEAD_BUSH_MAY_PLACE_ON = DRY_VEGETATION_MAY_PLACE_ON;
    /**
     * 原版方块标签，代表所有可触发山羊角的方块。
     */
    Tag<Material> SNAPS_GOAT_HORN = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snaps_goat_horn"), Material.class);
    /**
     * 原版方块标签，代表所有可被生长的树木替代的方块。
     */
    Tag<Material> REPLACEABLE_BY_TREES = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("replaceable_by_trees"), Material.class);
    /**
     * 原版方块标签，代表所有可被生长的蘑菇替代的方块。
     */
    Tag<Material> REPLACEABLE_BY_MUSHROOMS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("replaceable_by_mushrooms"), Material.class);
    /**
     * 原版方块标签，代表 blocks which snow cannot survive on.
     */
    Tag<Material> SNOW_LAYER_CANNOT_SURVIVE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow_layer_cannot_survive_on"), Material.class);
    /**
     * 原版方块标签，代表 blocks which snow can survive on.
     */
    Tag<Material> SNOW_LAYER_CAN_SURVIVE_ON = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("snow_layer_can_survive_on"), Material.class);
    /**
     * 原版方块标签，代表 blocks which cannot be dismounted into.
     */
    Tag<Material> INVALID_SPAWN_INSIDE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("invalid_spawn_inside"), Material.class);
    /**
     * 原版方块标签，代表 blocks which can be dug by sniffers.
     */
    Tag<Material> SNIFFER_DIGGABLE_BLOCK = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sniffer_diggable_block"), Material.class);
    /**
     * 原版方块标签，代表所有加速嗅探兽蛋孵化的方块。
     */
    Tag<Material> SNIFFER_EGG_HATCH_BOOST = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("sniffer_egg_hatch_boost"), Material.class);
    /**
     * 原版方块标签，代表所有可被足迹废墟替代的方块。
     */
    Tag<Material> TRAIL_RUINS_REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("trail_ruins_replaceable"), Material.class);
    /**
     * 原版方块标签，代表所有可替代的方块。
     */
    Tag<Material> REPLACEABLE = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("replaceable"), Material.class);
    /**
     * 原版方块标签，代表所有提供附魔能量的方块。
     */
    Tag<Material> ENCHANTMENT_POWER_PROVIDER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enchantment_power_provider"), Material.class);
    /**
     * 原版方块标签，代表所有传导附魔能量的方块。
     */
    Tag<Material> ENCHANTMENT_POWER_TRANSMITTER = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("enchantment_power_transmitter"), Material.class);
    /**
     * 原版方块标签，代表所有放置时不会破坏耕地的方块。
     */
    Tag<Material> MAINTAINS_FARMLAND = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("maintains_farmland"), Material.class);
    /**
     * 原版方块标签，代表所有阻挡风弹爆炸的方块。
     */
    Tag<Material> BLOCKS_WIND_CHARGE_EXPLOSIONS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("blocks_wind_charge_explosions"), Material.class);
    /**
     * 原版方块标签，代表 solid blocks which do not block hopper operation.
     */
    Tag<Material> DOES_NOT_BLOCK_HOPPERS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("does_not_block_hoppers"), Material.class);
    /**
     * 原版方块标签，代表所有播放沙漠环境方块声音的方块。
     */
    Tag<Material> TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("triggers_ambient_desert_sand_block_sounds"), Material.class);
    /**
     * @deprecated 参见 {@link #TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS}
     */
    @Deprecated(since = "1.21.6")
    Tag<Material> PLAYS_AMBIENT_DESERT_BLOCK_SOUNDS = TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS;
    /**
     * 原版方块标签，代表所有播放沙漠干燥植被环境声音的方块。
     */
    Tag<Material> TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("triggers_ambient_desert_dry_vegetation_block_sounds"), Material.class);
    /**
     * 原版方块标签，代表所有当放置干燥恶魂方块时触发干燥恶魂环境声音的方块。
     */
    Tag<Material> RIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("triggers_ambient_dried_ghast_block_sounds"), Material.class);
    /**
     * 原版方块标签，代表所有类似空气的方块。
     */
    Tag<Material> AIR = Bukkit.getTag(REGISTRY_BLOCKS, NamespacedKey.minecraft("air"), Material.class);
    /**
     * 内置物品注册表的键。
     */
    String REGISTRY_ITEMS = "items";
    /**
     * 原版物品标签，代表所有猪灵喜爱的物品。
     */
    Tag<Material> ITEMS_PIGLIN_LOVED = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("piglin_loved"), Material.class);
    /**
     * 原版物品标签，代表所有小猪灵忽略的物品。
     */
    Tag<Material> IGNORED_BY_PIGLIN_BABIES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("ignored_by_piglin_babies"), Material.class);
    /**
     * 原版物品标签，代表所有可防止猪灵被激怒的物品。
     */
    Tag<Material> ITEMS_PIGLIN_SAFE_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("piglin_safe_armor"), Material.class);
    /**
     * 原版物品标签，代表所有在悦灵跳舞时可用于复制悦灵的物品。
     */
    Tag<Material> ITEMS_DUPLICATES_ALLAYS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("duplicates_allays"), Material.class);
    /**
     * 原版物品标签，代表所有酿造台燃料物品。
     */
    Tag<Material> ITEMS_BREWING_FUEL = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("brewing_fuel"), Material.class);
    /**
     * 原版物品标签，代表所有蛋。
     */
    Tag<Material> ITEMS_EGGS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("eggs"), Material.class);
    /**
     * 原版物品标签，代表所有肉类。
     */
    Tag<Material> ITEMS_MEAT = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("meat"), Material.class);
    /**
     * 原版物品标签，代表所有嗅探兽食物。
     */
    Tag<Material> ITEMS_SNIFFER_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("sniffer_food"), Material.class);
    /**
     * 原版物品标签，代表所有猪灵食物。
     */
    Tag<Material> ITEMS_PIGLIN_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("piglin_food"), Material.class);
    /**
     * 原版物品标签，代表所有猪灵食物。
     *
     * @deprecated 使用 {@link #ITEMS_PIGLIN_FOOD}
     */
    @Deprecated(since = "1.20.5")
    Tag<Material> PIGLIN_FOOD = ITEMS_PIGLIN_FOOD;
    /**
     * 原版物品标签，代表所有狐狸食物。
     */
    Tag<Material> ITEMS_FOX_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("fox_food"), Material.class);
    /**
     * 原版物品标签，代表所有狐狸食物。
     *
     * @deprecated 使用 {@link #ITEMS_FOX_FOOD}
     */
    @Deprecated(since = "1.20.5")
    Tag<Material> FOX_FOOD = ITEMS_FOX_FOOD;
    /**
     * 原版物品标签，代表所有牛食物。
     */
    Tag<Material> ITEMS_COW_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("cow_food"), Material.class);
    /**
     * 原版物品标签，代表所有山羊食物。
     */
    Tag<Material> ITEMS_GOAT_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("goat_food"), Material.class);
    /**
     * 原版物品标签，代表所有绵羊食物。
     */
    Tag<Material> ITEMS_SHEEP_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("sheep_food"), Material.class);
    /**
     * 原版物品标签，代表所有狼食物。
     */
    Tag<Material> ITEMS_WOLF_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("wolf_food"), Material.class);
    /**
     * 原版物品标签，代表所有猫食物。
     */
    Tag<Material> ITEMS_CAT_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("cat_food"), Material.class);
    /**
     * 原版物品标签，代表所有马食物。
     */
    Tag<Material> ITEMS_HORSE_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("horse_food"), Material.class);
    /**
     * 原版物品标签，代表所有僵尸马食物。
     */
    Tag<Material> ITEMS_ZOMBIE_HORSE_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("zombie_horse_food"), Material.class);
    /**
     * 原版物品标签，代表所有马引诱物品。
     */
    Tag<Material> ITEMS_HORSE_TEMPT_ITEMS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("horse_tempt_items"), Material.class);
    /**
     * 原版物品标签，代表所有鞍具。
     */
    Tag<Material> ITEMS_HARNESSES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("harnesses"), Material.class);
    /**
     * 原版物品标签，代表所有快乐恶魂食物物品。
     */
    Tag<Material> ITEMS_HAPPY_GHAST_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("happy_ghast_food"), Material.class);
    /**
     * 原版物品标签，代表所有快乐恶魂引诱物品。
     */
    Tag<Material> ITEMS_HAPPY_GHAST_TEMPT_ITEMS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("happy_ghast_tempt_items"), Material.class);
    /**
     * 原版物品标签，代表所有骆驼食物。
     */
    Tag<Material> ITEMS_CAMEL_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("camel_food"), Material.class);
    /**
     * 原版物品标签，代表所有骆驼外壳食物。
     */
    Tag<Material> ITEMS_CAMEL_HUSK_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("camel_husk_food"), Material.class);
    /**
     * 原版物品标签，代表所有犰狳食物。
     */
    Tag<Material> ITEMS_ARMADILLO_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("armadillo_food"), Material.class);
    /**
     * 原版物品标签，代表所有蜜蜂食物。
     */
    Tag<Material> ITEMS_BEE_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("bee_food"), Material.class);
    /**
     * 原版物品标签，代表所有鸡食物。
     */
    Tag<Material> ITEMS_CHICKEN_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("chicken_food"), Material.class);
    /**
     * 原版物品标签，代表所有青蛙食物。
     */
    Tag<Material> ITEMS_FROG_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("frog_food"), Material.class);
    /**
     * 原版物品标签，代表所有疣猪兽食物。
     */
    Tag<Material> ITEMS_HOGLIN_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("hoglin_food"), Material.class);
    /**
     * 原版物品标签，代表所有羊驼食物。
     */
    Tag<Material> ITEMS_LLAMA_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("llama_food"), Material.class);
    /**
     * 原版物品标签，代表所有羊驼引诱物品。
     */
    Tag<Material> ITEMS_LLAMA_TEMPT_ITEMS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("llama_tempt_items"), Material.class);
    /**
     * 原版物品标签，代表所有豹猫食物。
     */
    Tag<Material> ITEMS_OCELOT_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("ocelot_food"), Material.class);
    /**
     * 原版物品标签，代表所有熊猫食物。
     */
    Tag<Material> ITEMS_PANDA_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("panda_food"), Material.class);
    /**
     * 原版物品标签，代表所有熊猫会从地上捡起吃的物品。
     */
    Tag<Material> ITEMS_PANDA_EATS_FROM_GROUND = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("panda_eats_from_ground"), Material.class);
    /**
     * 原版物品标签，代表所有猪食物。
     */
    Tag<Material> ITEMS_PIG_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("pig_food"), Material.class);
    /**
     * 原版物品标签，代表所有兔子食物。
     */
    Tag<Material> ITEMS_RABBIT_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("rabbit_food"), Material.class);
    /**
     * 原版物品标签，代表所有炽足兽食物。
     */
    Tag<Material> ITEMS_STRIDER_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("strider_food"), Material.class);
    /**
     * 原版物品标签，代表所有炽足兽引诱物品。
     */
    Tag<Material> ITEMS_STRIDER_TEMPT_ITEMS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("strider_tempt_items"), Material.class);
    /**
     * 原版物品标签，代表所有海龟食物。
     */
    Tag<Material> ITEMS_TURTLE_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("turtle_food"), Material.class);
    /**
     * 原版物品标签，代表所有鹦鹉食物。
     */
    Tag<Material> ITEMS_PARROT_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("parrot_food"), Material.class);
    /**
     * 原版物品标签，代表所有鹦鹉有毒食物。
     */
    Tag<Material> ITEMS_PARROT_POISONOUS_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("parrot_poisonous_food"), Material.class);
    /**
     * 原版物品标签，代表所有美西螈食物。
     */
    Tag<Material> ITEMS_AXOLOTL_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("axolotl_food"), Material.class);
    /**
     * 原版物品标签，代表所有从桶中喂食的鹦鹉螺食物。
     */
    Tag<Material> ITEMS_NAUTILUS_BUCKET_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("nautilus_bucket_food"), Material.class);
    /**
     * 原版物品标签，代表所有鹦鹉螺食物。
     */
    Tag<Material> ITEMS_NAUTILUS_FOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("nautilus_food"), Material.class);
    /**
     * 原版物品标签，代表所有可用于驯服鹦鹉螺的物品。
     */
    Tag<Material> ITEMS_NAUTILUS_TAMING_ITEMS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("nautilus_taming_items"), Material.class);
    /**
     * 原版物品标签，代表所有旗帜物品。
     */
    Tag<Material> ITEMS_BANNERS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("banners"), Material.class);
    /**
     * 原版物品标签，代表所有不可燃木制物品。
     */
    Tag<Material> ITEMS_NON_FLAMMABLE_WOOD = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("non_flammable_wood"), Material.class);
    /**
     * 原版物品标签，代表所有船物品。
     */
    Tag<Material> ITEMS_BOATS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("boats"), Material.class);
    /**
     * 原版物品标签，代表所有运输船物品。
     */
    Tag<Material> ITEMS_CHEST_BOATS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("chest_boats"), Material.class);
    /**
     * 原版物品标签，代表所有鱼类物品。
     */
    Tag<Material> ITEMS_FISHES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("fishes"), Material.class);
    /**
     * 原版物品标签，代表所有苦力怕掉落的音乐唱片物品。
     */
    Tag<Material> ITEMS_CREEPER_DROP_MUSIC_DISCS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("creeper_drop_music_discs"), Material.class);
    /**
     * 原版物品标签，代表所有煤炭物品。
     */
    Tag<Material> ITEMS_COALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("coals"), Material.class);
    /**
     * 原版物品标签，代表所有箭矢物品。
     */
    Tag<Material> ITEMS_ARROWS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("arrows"), Material.class);
    /**
     * 原版物品标签，代表所有可放置在讲台上的书。
     */
    Tag<Material> ITEMS_LECTERN_BOOKS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("lectern_books"), Material.class);
    /**
     * 原版物品标签，代表所有可放置在书架上的书。
     */
    Tag<Material> ITEMS_BOOKSHELF_BOOKS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("bookshelf_books"), Material.class);
    /**
     * 原版物品标签，代表所有可放置在信标中的物品。
     */
    Tag<Material> ITEMS_BEACON_PAYMENT_ITEMS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("beacon_payment_items"), Material.class);
    /**
     * 原版物品标签，代表所有木质工具材料。
     */
    Tag<Material> ITEMS_WOODEN_TOOL_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("wooden_tool_materials"), Material.class);
    /**
     * 原版物品标签，代表所有石质工具材料。
     */
    Tag<Material> ITEMS_STONE_TOOL_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("stone_tool_materials"), Material.class);
    /**
     * 原版物品标签，代表所有铜质工具材料。
     */
    Tag<Material> ITEMS_COPPER_TOOL_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("copper_tool_materials"), Material.class);
    /**
     * 原版物品标签，代表所有铁质工具材料。
     */
    Tag<Material> ITEMS_IRON_TOOL_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("iron_tool_materials"), Material.class);
    /**
     * 原版物品标签，代表所有金质工具材料。
     */
    Tag<Material> ITEMS_GOLD_TOOL_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("gold_tool_materials"), Material.class);
    /**
     * 原版物品标签，代表所有钻石工具材料。
     */
    Tag<Material> ITEMS_DIAMOND_TOOL_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("diamond_tool_materials"), Material.class);
    /**
     * 原版物品标签，代表所有下界合金工具材料。
     */
    Tag<Material> ITEMS_NETHERITE_TOOL_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("netherite_tool_materials"), Material.class);
    /**
     * 原版物品标签，代表所有可修复皮革盔甲的物品。
     */
    Tag<Material> ITEMS_REPAIRS_LEATHER_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_leather_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可修复铜盔甲的物品。
     */
    Tag<Material> ITEMS_REPAIRS_COPPER_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_copper_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可修复锁链盔甲的物品。
     */
    Tag<Material> ITEMS_REPAIRS_CHAIN_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_chain_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可修复铁盔甲的物品。
     */
    Tag<Material> ITEMS_REPAIRS_IRON_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_iron_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可修复金盔甲的物品。
     */
    Tag<Material> ITEMS_REPAIRS_GOLD_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_gold_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可修复钻石盔甲的物品。
     */
    Tag<Material> ITEMS_REPAIRS_DIAMOND_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_diamond_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可修复下界合金盔甲的物品。
     */
    Tag<Material> ITEMS_REPAIRS_NETHERITE_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_netherite_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可修复海龟壳的物品。
     */
    Tag<Material> ITEMS_REPAIRS_TURTLE_HELMET = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_turtle_helmet"), Material.class);
    /**
     * 原版物品标签，代表所有可修复狼铠的物品。
     */
    Tag<Material> ITEMS_REPAIRS_WOLF_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("repairs_wolf_armor"), Material.class);
    /**
     * 原版物品标签，代表所有石头合成材料。
     */
    Tag<Material> ITEMS_STONE_CRAFTING_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("stone_crafting_materials"), Material.class);
    /**
     * 原版物品标签，代表所有指南针。
     */
    Tag<Material> ITEMS_COMPASSES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("compasses"), Material.class);
    /**
     * 原版物品标签，代表所有悬挂式告示牌。
     */
    Tag<Material> ITEMS_HANGING_SIGNS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("hanging_signs"), Material.class);
    /**
     * 原版物品标签，代表所有与苦力怕交互时会点燃苦力怕的物品。
     */
    Tag<Material> ITEMS_CREEPER_IGNITERS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("creeper_igniters"), Material.class);
    /**
     * 原版物品标签，代表所有放置在顶部时可修改音符盒声音的物品。
     */
    Tag<Material> ITEMS_NOTE_BLOCK_TOP_INSTRUMENTS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("noteblock_top_instruments"), Material.class);
    /**
     * 原版物品标签，代表所有脚部盔甲。
     */
    Tag<Material> ITEMS_FOOT_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("foot_armor"), Material.class);
    /**
     * 原版物品标签，代表所有腿部盔甲。
     */
    Tag<Material> ITEMS_LEG_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("leg_armor"), Material.class);
    /**
     * 原版物品标签，代表所有胸部盔甲。
     */
    Tag<Material> ITEMS_CHEST_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("chest_armor"), Material.class);
    /**
     * 原版物品标签，代表所有头部盔甲。
     */
    Tag<Material> ITEMS_HEAD_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("head_armor"), Material.class);
    /**
     * 原版物品标签，代表所有头颅。
     */
    Tag<Material> ITEMS_SKULLS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("skulls"), Material.class);
    /**
     * 原版物品标签，代表所有可修剪盔甲物品。
     */
    Tag<Material> ITEMS_TRIMMABLE_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("trimmable_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可用于修剪盔甲的材料。
     */
    Tag<Material> ITEMS_TRIM_MATERIALS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("trim_materials"), Material.class);
    /**
     * 原版物品标签，代表所有装饰罐碎片。
     */
    Tag<Material> ITEMS_DECORATED_POT_SHERDS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("decorated_pot_sherds"), Material.class);
    /**
     * 原版物品标签，代表所有装饰罐材料。
     */
    Tag<Material> ITEMS_DECORATED_POT_INGREDIENTS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("decorated_pot_ingredients"), Material.class);
    /**
     * 原版物品标签，代表所有剑。
     */
    Tag<Material> ITEMS_SWORDS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("swords"), Material.class);
    /**
     * 原版物品标签，代表所有斧。
     */
    Tag<Material> ITEMS_AXES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("axes"), Material.class);
    /**
     * 原版物品标签，代表所有锄。
     */
    Tag<Material> ITEMS_HOES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("hoes"), Material.class);
    /**
     * 原版物品标签，代表所有镐。
     */
    Tag<Material> ITEMS_PICKAXES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("pickaxes"), Material.class);
    /**
     * 原版物品标签，代表所有锹。
     */
    Tag<Material> ITEMS_SHOVELS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("shovels"), Material.class);
    /**
     * 原版物品标签，代表所有长矛。
     */
    Tag<Material> ITEMS_SPEARS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("spears"), Material.class);
    /**
     * 原版物品标签，代表所有可破坏装饰罐的物品。
     */
    Tag<Material> ITEMS_BREAKS_DECORATED_POTS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("breaks_decorated_pots"), Material.class);
    /**
     * 原版物品标签，代表所有工具。
     *
     * @deprecated 在 Minecraft 1.20.5 中已移除。请勿使用。将在之后的版本中彻底移除。在此之前，
     * 此常量现在作为 {@link #ITEMS_BREAKS_DECORATED_POTS} 的引用，该标签与旧的
     * "minecraft:tools" 标签内容基本相同。
     */
    @Deprecated(since = "1.20.6", forRemoval = true)
    Tag<Material> ITEMS_TOOLS = ITEMS_BREAKS_DECORATED_POTS;
    /**
     * 原版物品标签，代表所有村民可种植的种子。
     */
    Tag<Material> ITEMS_VILLAGER_PLANTABLE_SEEDS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("villager_plantable_seeds"), Material.class);
    /**
     * 原版物品标签，代表所有村民会捡起的物品。
     */
    Tag<Material> ITEMS_VILLAGER_PICKS_UP = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("villager_picks_up"), Material.class);
    /**
     * 原版物品标签，代表所有可染色物品。
     */
    Tag<Material> ITEMS_DYEABLE = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("dyeable"), Material.class);
    /**
     * 原版物品标签，代表所有动力矿车燃料。
     */
    Tag<Material> ITEMS_FURNACE_MINECART_FUEL = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("furnace_minecart_fuel"), Material.class);
    /**
     * 原版物品标签，代表所有收纳袋物品。
     */
    Tag<Material> ITEMS_BUNDLES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("bundles"), Material.class);
    /**
     * 原版物品标签，代表所有书本克隆目标物品。
     */
    Tag<Material> ITEMS_BOOK_CLONING_TARGET = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("book_cloning_target"), Material.class);
    /**
     * 原版物品标签，代表所有骷髅偏好武器。
     */
    Tag<Material> ITEMS_SKELETON_PREFERRED_WEAPONS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("skeleton_preferred_weapons"), Material.class);
    /**
     * 原版物品标签，代表所有溺尸偏好武器。
     */
    Tag<Material> ITEMS_DROWNED_PREFERRED_WEAPONS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("drowned_preferred_weapons"), Material.class);
    /**
     * 原版物品标签，代表所有猪灵偏好武器。
     */
    Tag<Material> ITEMS_PIGLIN_PREFERRED_WEAPONS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("piglin_preferred_weapons"), Material.class);
    /**
     * 原版物品标签，代表所有掠夺者偏好武器。
     */
    Tag<Material> ITEMS_PILLAGER_PREFERRED_WEAPONS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("pillager_preferred_weapons"), Material.class);
    /**
     * 原版物品标签，代表所有凋灵骷髅不喜欢的武器。
     */
    Tag<Material> ITEMS_WITHER_SKELETON_DISLIKED_WEAPONS = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("wither_skeleton_disliked_weapons"), Material.class);
    /**
     * 原版物品标签，代表所有可从铜傀儡身上剪下的物品。
     */
    Tag<Material> ITEMS_SHEARABLE_FROM_COPPER_GOLEM = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("shearable_from_copper_golem"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔脚部盔甲。
     */
    Tag<Material> ITEMS_ENCHANTABLE_FOOT_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/foot_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔腿部盔甲。
     */
    Tag<Material> ITEMS_ENCHANTABLE_LEG_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/leg_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔胸部盔甲。
     */
    Tag<Material> ITEMS_ENCHANTABLE_CHEST_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/chest_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔头部盔甲。
     */
    Tag<Material> ITEMS_ENCHANTABLE_HEAD_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/head_armor"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔盔甲。
     */
    Tag<Material> ITEMS_ENCHANTABLE_ARMOR = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/armor"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔近战武器。
     */
    Tag<Material> ITEMS_ENCHANTABLE_MELEE_WEAPON = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/melee_weapon"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔横扫之刃的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_SWEEPING = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/sweeping"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔剑。
     *
     * @deprecated 使用 {@link #ITEMS_ENCHANTABLE_SWEEPING} 或
     * {@link #ITEMS_ENCHANTABLE_MELEE_WEAPON}
     */
    @Deprecated(since = "1.21.11")
    Tag<Material> ITEMS_ENCHANTABLE_SWORD = ITEMS_ENCHANTABLE_SWEEPING;
    /**
     * 原版物品标签，代表所有可附魔火焰附加的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_FIRE_ASPECT = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/fire_aspect"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔锋利的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_SHARP_WEAPON = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/sharp_weapon"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔武器。
     */
    Tag<Material> ITEMS_ENCHANTABLE_WEAPON = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/weapon"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔挖掘工具。
     */
    Tag<Material> ITEMS_ENCHANTABLE_MINING = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/mining"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔时运的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_MINING_LOOT = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/mining_loot"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔钓鱼的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_FISHING = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/fishing"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔三叉戟的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_TRIDENT = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/trident"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔突刺的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_LUNGE = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/lunge"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔耐久的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_DURABILITY = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/durability"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔弓的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_BOW = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/bow"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔绑定诅咒的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_EQUIPPABLE = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/equippable"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔弩的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_CROSSBOW = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/crossbow"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔消失诅咒的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_VANISHING = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/vanishing"), Material.class);
    /**
     * 原版物品标签，代表所有可附魔锤的物品。
     */
    Tag<Material> ITEMS_ENCHANTABLE_MACE = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("enchantable/mace"), Material.class);
        /**
     * 原版物品标签，代表所有装备后会将实体从地图上隐藏的物品。
     */
    Tag<Material> ITEMS_MAP_INVISIBILITY_EQUIPMENT = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("map_invisibility_equipment"), Material.class);
        /**
     * 原版物品标签，代表所有可伪装穿戴者视线不被其他实体发现的物品。
     */
    Tag<Material> ITEMS_GAZE_DISGUISE_EQUIPMENT = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("gaze_disguise_equipment"), Material.class);
    /**
     * 原版物品标签，代表所有赋予穿戴者冰冻免疫的物品。
     */
    Tag<Material> FREEZE_IMMUNE_WEARABLES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("freeze_immune_wearables"), Material.class);
    /**
     * 原版物品标签，代表所有可引诱美西螈的物品。
     *
     * @deprecated 使用 {@link #ITEMS_AXOLOTL_FOOD}
     */
    @Deprecated(since = "1.20.5")
    Tag<Material> AXOLOTL_TEMPT_ITEMS = ITEMS_AXOLOTL_FOOD;
    /**
     * 原版物品标签，代表所有优先用于收获簇的物品（未使用）。
     */
    Tag<Material> CLUSTER_MAX_HARVESTABLES = Bukkit.getTag(REGISTRY_ITEMS, NamespacedKey.minecraft("cluster_max_harvestables"), Material.class);
    /**
     * 内置流体注册表的键。
     */
    String REGISTRY_FLUIDS = "fluids";
    /**
     * 原版流体标签，代表 lava and flowing lava.
     */
    Tag<Fluid> FLUIDS_LAVA = Bukkit.getTag(REGISTRY_FLUIDS, NamespacedKey.minecraft("lava"), Fluid.class);
    /**
     * 原版流体标签，代表 water and flowing water.
     */
    Tag<Fluid> FLUIDS_WATER = Bukkit.getTag(REGISTRY_FLUIDS, NamespacedKey.minecraft("water"), Fluid.class);
    /**
     * 内置实体注册表的键。
     */
    String REGISTRY_ENTITY_TYPES = "entity_types";
    /**
     * 原版标签，代表 skeletons.
     */
    Tag<EntityType> ENTITY_TYPES_SKELETONS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("skeletons"), EntityType.class);
    /**
     * 原版标签，代表 zombies.
     */
    Tag<EntityType> ENTITY_TYPES_ZOMBIES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("zombies"), EntityType.class);
    /**
     * 原版标签，代表 raiders.
     */
    Tag<EntityType> ENTITY_TYPES_RAIDERS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("raiders"), EntityType.class);
    /**
     * 原版标签，代表 the undead.
     */
    Tag<EntityType> ENTITY_TYPES_UNDEAD = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("undead"), EntityType.class);
    /**
     * 原版标签，代表 entities which burn in daylight.
     */
    Tag<EntityType> ENTITY_TYPES_BURN_IN_DAYLIGHT = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("burn_in_daylight"), EntityType.class);
    /**
     * 原版标签，代表 entities which can live in beehives.
     */
    Tag<EntityType> ENTITY_TYPES_BEEHIVE_INHABITORS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("beehive_inhabitors"), EntityType.class);
    /**
     * 原版标签，代表 arrows.
     */
    Tag<EntityType> ENTITY_TYPES_ARROWS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("arrows"), EntityType.class);
    /**
     * 原版标签，代表 projectiles.
     */
    Tag<EntityType> ENTITY_TYPES_IMPACT_PROJECTILES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("impact_projectiles"), EntityType.class);
    /**
     * 原版标签，代表 mobs which can walk on powder snow.
     */
    Tag<EntityType> ENTITY_TYPES_POWDER_SNOW_WALKABLE_MOBS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("powder_snow_walkable_mobs"), EntityType.class);
    /**
     * 原版标签，代表 which entities axolotls are always hostile to.
     */
    Tag<EntityType> ENTITY_TYPES_AXOLOTL_ALWAYS_HOSTILES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("axolotl_always_hostiles"), EntityType.class);
    /**
     * 原版标签，代表 axolotl targets.
     */
    Tag<EntityType> ENTITY_TYPES_AXOLOTL_HUNT_TARGETS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("axolotl_hunt_targets"), EntityType.class);
    /**
     * 原版标签，代表 entities immune from freezing.
     */
    Tag<EntityType> ENTITY_TYPES_FREEZE_IMMUNE_ENTITY_TYPES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("freeze_immune_entity_types"), EntityType.class);
    /**
     * 原版标签，代表 entities extra susceptible to freezing.
     */
    Tag<EntityType> ENTITY_TYPES_FREEZE_HURTS_EXTRA_TYPES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("freeze_hurts_extra_types"), EntityType.class);
    /**
     * 原版标签，代表 entities which can breathe under water.
     */
    Tag<EntityType> ENTITY_TYPES_CAN_BREATHE_UNDER_WATER = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("can_breathe_under_water"), EntityType.class);
    /**
     * 原版标签，代表 entities which can be eaten by frogs.
     */
    Tag<EntityType> ENTITY_TYPES_FROG_FOOD = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("frog_food"), EntityType.class);
    /**
     * 原版标签，代表 entities which are immune from fall damage.
     */
    Tag<EntityType> ENTITY_TYPES_FALL_DAMAGE_IMMUNE = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("fall_damage_immune"), EntityType.class);
    /**
     * 原版标签，代表 entities which are dismounted when underwater.
     */
    Tag<EntityType> ENTITY_TYPES_DISMOUNTS_UNDERWATER = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("dismounts_underwater"), EntityType.class);
    /**
     * 原版标签，代表 entities which are not controlled by their mount.
     */
    Tag<EntityType> ENTITY_TYPES_NON_CONTROLLING_RIDER = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("non_controlling_rider"), EntityType.class);
    /**
     * 原版标签，代表 entities which deflect projectiles.
     */
    Tag<EntityType> ENTITY_TYPES_DEFLECTS_PROJECTILES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("deflects_projectiles"), EntityType.class);
    /**
     * 原版标签，代表 entities which deflect arrows.
     * @deprecated 使用 {@link #ENTITY_TYPES_DEFLECTS_PROJECTILES}
     */
    @Deprecated(since = "1.20.5")
    Tag<EntityType> ENTITY_TYPES_DEFLECTS_ARROWS = ENTITY_TYPES_DEFLECTS_PROJECTILES;
    /**
     * 原版标签，代表 entities which can turn in boats.
     */
    Tag<EntityType> ENTITY_TYPES_CAN_TURN_IN_BOATS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("can_turn_in_boats"), EntityType.class);
    /**
     * 原版标签，代表所有对灾厄附魔敏感的实体。
     */
    Tag<EntityType> ENTITY_TYPES_ILLAGER = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("illager"), EntityType.class);
    /**
     * 原版标签，代表所有对水生附魔敏感的实体。
     */
    Tag<EntityType> ENTITY_TYPES_AQUATIC = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("aquatic"), EntityType.class);
    /**
     * 原版标签，代表所有对节肢附魔敏感的实体。
     */
    Tag<EntityType> ENTITY_TYPES_ARTHROPOD = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("arthropod"), EntityType.class);
    /**
     * 原版标签，代表所有忽略中毒和再生效果的实体。
     */
    Tag<EntityType> ENTITY_TYPES_IGNORES_POISON_AND_REGEN = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("ignores_poison_and_regen"), EntityType.class);
    /**
     * 原版标签，代表所有对反转治疗和伤害药水效果敏感的实体。
     */
    Tag<EntityType> ENTITY_TYPES_INVERTED_HEALING_AND_HARM = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("inverted_healing_and_harm"), EntityType.class);
    /**
     * 原版标签，代表所有与凋灵友好的实体。
     */
    Tag<EntityType> ENTITY_TYPES_WITHER_FRIENDS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("wither_friends"), EntityType.class);
    /**
     * 原版标签，代表所有与灾厄村民友好的实体。
     */
    Tag<EntityType> ENTITY_TYPES_ILLAGER_FRIENDS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("illager_friends"), EntityType.class);
    /**
     * 原版标签，代表所有对河豚不可怕的实体。
     */
    Tag<EntityType> ENTITY_TYPES_NOT_SCARY_FOR_PUFFERFISH = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("not_scary_for_pufferfish"), EntityType.class);
    /**
     * 原版标签，代表所有对穿刺敏感的实体。
     */
    Tag<EntityType> ENTITY_TYPES_SENSITIVE_TO_IMPALING = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("sensitive_to_impaling"), EntityType.class);
    /**
     * 原版标签，代表所有对节肢杀手附魔敏感的实体。
     */
    Tag<EntityType> ENTITY_TYPES_SENSITIVE_TO_BANE_OF_ARTHROPODS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("sensitive_to_bane_of_arthropods"), EntityType.class);
    /**
     * 原版标签，代表所有对亡灵杀手附魔敏感的实体。
     */
    Tag<EntityType> ENTITY_TYPES_SENSITIVE_TO_SMITE = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("sensitive_to_smite"), EntityType.class);
    /**
     * 原版标签，代表所有不会因风弹而愤怒的实体。
     */
    Tag<EntityType> ENTITY_TYPES_NO_ANGER_FROM_WIND_CHARGE = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("no_anger_from_wind_charge"), EntityType.class);
    /**
     * 原版标签，代表所有免疫渗出效果的实体。
     */
    Tag<EntityType> ENTITY_TYPES_IMMUNE_TO_OOZING = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("immune_to_oozing"), EntityType.class);
    /**
     * 原版标签，代表所有免疫虫蚀效果的实体。
     */
    Tag<EntityType> ENTITY_TYPES_IMMUNE_TO_INFESTED = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("immune_to_infested"), EntityType.class);
    /**
     * 原版标签，代表所有可被击退的弹射物。
     */
    Tag<EntityType> ENTITY_TYPES_REDIRECTABLE_PROJECTILE = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("redirectable_projectile"), EntityType.class);
    /**
     * 原版标签，代表所有船。
     */
    Tag<EntityType> ENTITY_TYPES_BOAT = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("boat"), EntityType.class);
    /**
     * 原版标签，代表所有可装备鞍的实体。
     */
    Tag<EntityType> ENTITY_TYPES_CAN_EQUIP_SADDLE = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("can_equip_saddle"), EntityType.class);
    /**
     * 原版标签，代表所有可装备鞍具的实体。
     */
    Tag<EntityType> ENTITY_TYPES_CAN_EQUIP_HARNESS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("can_equip_harness"), EntityType.class);
    /**
     * 原版标签，代表所有可穿戴马铠的实体。
     */
    Tag<EntityType> ENTITY_TYPES_CAN_WEAR_HORSE_ARMOR = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("can_wear_horse_armor"), EntityType.class);
    /**
     * 原版标签，代表所有可穿戴鹦鹉螺盔甲的实体。
     */
    Tag<EntityType> ENTITY_TYPES_CAN_WEAR_NAUTILUS_ARMOR = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("can_wear_nautilus_armor"), EntityType.class);
    /**
     * 原版标签，代表所有可被友好生物跟随的实体。
     */
    Tag<EntityType> ENTITY_TYPES_FOLLOWABLE_FRIENDLY_MOBS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("followable_friendly_mobs"), EntityType.class);
    /**
     * 原版标签，代表所有不可被推上船的实体。
     */
    Tag<EntityType> ENTITY_TYPES_CANNOT_BE_PUSHED_ONTO_BOATS = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("cannot_be_pushed_onto_boats"), EntityType.class);
    /**
     * 原版标签，代表所有可接收铁傀儡礼物的实体。
     */
    Tag<EntityType> ENTITY_TYPES_ACCEPTS_IRON_GOLEM_GIFT = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("accepts_iron_golem_gift"), EntityType.class);
    /**
     * 原版标签，代表所有铁傀儡可能赠送物品的实体。
     */
    Tag<EntityType> ENTITY_TYPES_CANDIDATE_FOR_IRON_GOLEM_GIFT = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("candidate_for_iron_golem_gift"), EntityType.class);
    /**
     * 原版标签，代表所有鹦鹉螺敌对的实体。
     */
    Tag<EntityType> ENTITY_TYPES_NAUTILUS_HOSTILES = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("nautilus_hostiles"), EntityType.class);
    /**
     * 原版标签，代表所有骑乘时可在水中漂浮的实体。
     */
    Tag<EntityType> ENTITY_TYPES_CAN_FLOAT_WHILE_RIDDEN = Bukkit.getTag(REGISTRY_ENTITY_TYPES, NamespacedKey.minecraft("can_float_while_ridden"), EntityType.class);

    /**
     * 返回此标签是否包含指定项目的条目。
     *
     * @param item 要检查的项目
     * @return 是否被标记
     * <p>
     * 原文：Returns whether or not this tag has an entry for the specified item.
     */

    /**
     * 获取所有已标记项目的不可变集合。
     *
     * @return 已标记项目的集合
     * <p>
     * 原文：Gets an immutable set of all tagged items.
     */
    boolean isTagged(@NotNull T item);

    /**
     * Gets an immutable set of all tagged items.
     *
     * @return set of tagged items
     */
    @NotNull
    Set<T> getValues();

}