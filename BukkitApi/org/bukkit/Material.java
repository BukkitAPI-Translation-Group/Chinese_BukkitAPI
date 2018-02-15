package org.bukkit;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.bukkit.map.MapView;
import org.bukkit.material.Bed;
import org.bukkit.material.Button;
import org.bukkit.material.Cake;
import org.bukkit.material.Cauldron;
import org.bukkit.material.Chest;
import org.bukkit.material.Coal;
import org.bukkit.material.CocoaPlant;
import org.bukkit.material.Command;
import org.bukkit.material.Comparator;
import org.bukkit.material.Crops;
import org.bukkit.material.DetectorRail;
import org.bukkit.material.Diode;
import org.bukkit.material.Dispenser;
import org.bukkit.material.Door;
import org.bukkit.material.Dye;
import org.bukkit.material.EnderChest;
import org.bukkit.material.FlowerPot;
import org.bukkit.material.Furnace;
import org.bukkit.material.Gate;
import org.bukkit.material.Hopper;
import org.bukkit.material.Ladder;
import org.bukkit.material.Leaves;
import org.bukkit.material.Lever;
import org.bukkit.material.LongGrass;
import org.bukkit.material.MaterialData;
import org.bukkit.material.MonsterEggs;
import org.bukkit.material.Mushroom;
import org.bukkit.material.NetherWarts;
import org.bukkit.material.PistonBaseMaterial;
import org.bukkit.material.PistonExtensionMaterial;
import org.bukkit.material.PoweredRail;
import org.bukkit.material.PressurePlate;
import org.bukkit.material.Pumpkin;
import org.bukkit.material.Rails;
import org.bukkit.material.RedstoneTorch;
import org.bukkit.material.RedstoneWire;
import org.bukkit.material.Sandstone;
import org.bukkit.material.Sapling;
import org.bukkit.material.Sign;
import org.bukkit.material.Skull;
import org.bukkit.material.SmoothBrick;
import org.bukkit.material.SpawnEgg;
import org.bukkit.material.Stairs;
import org.bukkit.material.Step;
import org.bukkit.material.Torch;
import org.bukkit.material.TrapDoor;
import org.bukkit.material.Tree;
import org.bukkit.material.Tripwire;
import org.bukkit.material.TripwireHook;
import org.bukkit.material.Vine;
import org.bukkit.material.Wood;
import org.bukkit.material.WoodenStep;
import org.bukkit.material.Wool;

import com.google.common.collect.Maps;

import org.bukkit.material.Banner;
import org.bukkit.material.Observer;

/**
 * 所有物品的枚举.
 */
public enum Material {
    /**
     * 空气
     */
    AIR(0, 0),
    /**
     * 石头
     */
    STONE(1),
    /**
     * 草方块
     */
    GRASS(2),
    /**
     * 泥土
     */
    DIRT(3),
    /**
     * 圆石
     */
    COBBLESTONE(4),
    /**
     * 木板
     */
    WOOD(5, Wood.class),
    /**
     * 树苗
     */
    SAPLING(6, Sapling.class),
    /**
     * 基岩
     */
    BEDROCK(7),
    /**
     * 水
     */
    WATER(8, MaterialData.class),
    /**
     * 静态水
     */
    STATIONARY_WATER(9, MaterialData.class),
    /**
     * 熔岩
     */
    LAVA(10, MaterialData.class),
    /**
     * 静态熔岩
     */
    STATIONARY_LAVA(11, MaterialData.class),
    /**
     * 沙子
     */
    SAND(12),
    /**
     * 砂砾
     */
    GRAVEL(13),
    /**
     * 金矿石
     */
    GOLD_ORE(14),
    /**
     * 铁矿石
     */
    IRON_ORE(15),
    /**
     * 煤矿石
     */
    COAL_ORE(16),
    /**
     * 木头(原木)
     */
    LOG(17, Tree.class),
    /**
     * 树叶
     */
    LEAVES(18, Leaves.class),
    /**
     * 海绵
     */
    SPONGE(19),
    /**
     * 玻璃
     */
    GLASS(20),
    /**
     * 青金石矿石
     */
    LAPIS_ORE(21),
    /**
     * 青金石块
     */
    LAPIS_BLOCK(22),
    /**
     * 发射器
     */
    DISPENSER(23, Dispenser.class),
    /**
     * 砂岩
     */
    SANDSTONE(24, Sandstone.class),
    /**
     * 音符盒
     */
    NOTE_BLOCK(25),
    /**
     * 床
     */
    BED_BLOCK(26, Bed.class),
    /**
     * 充能铁轨
     */
    POWERED_RAIL(27, PoweredRail.class),
    /**
     * 探测铁轨
     */
    DETECTOR_RAIL(28, DetectorRail.class),
    /**
     * 粘性活塞
     */
    PISTON_STICKY_BASE(29, PistonBaseMaterial.class),
    /**
     * 蜘蛛网(蛛网/网)
     */
    WEB(30),
    /**
     * 草丛(高草丛/草本体方块)
     */
    LONG_GRASS(31, LongGrass.class),
    /**
     * 枯死的灌木
     */
    DEAD_BUSH(32),
    /**
     * 活塞
     */
    PISTON_BASE(33, PistonBaseMaterial.class),
    /**
     * 活塞臂
     */
    PISTON_EXTENSION(34, PistonExtensionMaterial.class),
    /**
     * 羊毛
     */
    WOOL(35, Wool.class),
    /**
     * 移动的活塞臂
     */
    PISTON_MOVING_PIECE(36),
    /**
     * 蒲公英(小黄花/菊花)
     */
    YELLOW_FLOWER(37),
    /**
     * 虞美人(小红花/罂粟/玫瑰)
     */
    RED_ROSE(38),
    /**
     * 棕色蘑菇(棕蘑菇)
     */
    BROWN_MUSHROOM(39),
    /**
     * 红色蘑菇(红蘑菇)
     */
    RED_MUSHROOM(40),
    /**
     * 金块
     */
    GOLD_BLOCK(41),
    /**
     * 银块
     */
    IRON_BLOCK(42),
    /**
     * 双石台阶
     */
    DOUBLE_STEP(43, Step.class),
    /**
     * 石台阶
     */
    STEP(44, Step.class),
    /**
     * 砖块
     */
    BRICK(45),
    /**
     * TNT(炸药方块)
     */
    TNT(46),
    /**
     * 书架
     */
    BOOKSHELF(47),
    /**
     * 苔石(布有苔藓的石头)
     */
    MOSSY_COBBLESTONE(48),
    /**
     * 黑曜石
     */
    OBSIDIAN(49),
    /**
     * 火把
     */
    TORCH(50, Torch.class),
    /**
     * 火(火本体方块)
     */
    FIRE(51),
    /**
     * 刷怪箱(刷怪器/刷怪笼/怪物笼/怪物盒)
     */
    MOB_SPAWNER(52),
    /**
     * 木质楼梯(项目楼梯)
     */
    WOOD_STAIRS(53, Stairs.class),
    /**
     * 箱子
     */
    CHEST(54, Chest.class),
    /**
     * 红石线
     */
    REDSTONE_WIRE(55, RedstoneWire.class),
    /**
     * 钻石矿石
     */
    DIAMOND_ORE(56),
    /**
     * 钻石块
     */
    DIAMOND_BLOCK(57),
    /**
     * 工作台(工具台/合成台)
     */
    WORKBENCH(58),
    /**
     * 小麦(小麦本体方块)
     */
    CROPS(59, Crops.class),
    /**
     * 耕地(耕过的泥土/肥沃的泥土/农田泥土)
     */
    SOIL(60, MaterialData.class),
    /**
     * 熔炉
     */
    FURNACE(61, Furnace.class),
    /**
     * 燃烧的熔炉(燃烧着的熔炉/工作着的熔炉)
     */
    BURNING_FURNACE(62, Furnace.class),
    /**
     * 告示牌
     */
    SIGN_POST(63, 64, Sign.class),
    /**
     * 木门
     */
    WOODEN_DOOR(64, Door.class),
    /**
     * 梯子
     */
    LADDER(65, Ladder.class),
    /**
     * 铁轨
     */
    RAILS(66, Rails.class),
    /**
     * 圆石楼梯
     */
    COBBLESTONE_STAIRS(67, Stairs.class),
    /**
     * 墙上的告示牌
     */
    WALL_SIGN(68, 64, Sign.class),
    /**
     * 拉杆
     */
    LEVER(69, Lever.class),
    /**
     * 石质压力板
     */
    STONE_PLATE(70, PressurePlate.class),
    /**
     * 铁门
     */
    IRON_DOOR_BLOCK(71, Door.class),
    /**
     * 木质压力板
     */
    WOOD_PLATE(72, PressurePlate.class),
    /**
     * 红石矿石
     */
    REDSTONE_ORE(73),
    /**
     * 发光的红石矿石
     */
    GLOWING_REDSTONE_ORE(74),
    /**
     * 红石火把(关闭状态)
     */
    REDSTONE_TORCH_OFF(75, RedstoneTorch.class),
    /**
     * 红石火把(点亮/开启/充能状态)
     */
    REDSTONE_TORCH_ON(76, RedstoneTorch.class),
    /**
     * 石质按钮
     */
    STONE_BUTTON(77, Button.class),
    /**
     * 雪(雪块)
     */
    SNOW(78),
    /**
     * 冰(冰块)
     */
    ICE(79),
    /**
     * 雪块
     */
    SNOW_BLOCK(80),
    /**
     * 仙人掌
     */
    CACTUS(81, MaterialData.class),
    /**
     * 黏土
     */
    CLAY(82),
    /**
     * 甘蔗
     */
    SUGAR_CANE_BLOCK(83, MaterialData.class),
    /**
     * 唱片机
     */
    JUKEBOX(84),
    /**
     * 项目栅栏
     */
    FENCE(85),
    /**
     * 南瓜
     */
    PUMPKIN(86, Pumpkin.class),
    /**
     * 地狱岩
     */
    NETHERRACK(87),
    /**
     * 灵魂沙
     */
    SOUL_SAND(88),
    /**
     * 萤石
     */
    GLOWSTONE(89),
    /**
     * 下届传送门(下届传送门内容物本体方块)
     */
    PORTAL(90),
    /**
     * 南瓜灯
     */
    JACK_O_LANTERN(91, Pumpkin.class),
    /**
     * 蛋糕(蛋糕本体方块)
     */
    CAKE_BLOCK(92, 64, Cake.class),
    /**
     * 红石中继器(关闭状态)
     */
    DIODE_BLOCK_OFF(93, Diode.class),
    /**
     * 红石中继器(工作/开启/充能状态)
     */
    DIODE_BLOCK_ON(94, Diode.class),
    /**
     * 染色玻璃
     */
    STAINED_GLASS(95),
    /**
     * 活板门(横置门)
     */
    TRAP_DOOR(96, TrapDoor.class),
    /**
     * 怪物蛋(刷怪蛋/怪物生成蛋)
     */
    MONSTER_EGGS(97, MonsterEggs.class),
    /**
     * 石砖
     */
    SMOOTH_BRICK(98, SmoothBrick.class),
    /**
     * 棕色巨型蘑菇
     */
    HUGE_MUSHROOM_1(99, Mushroom.class),
    /**
     * 红色巨型蘑菇
     */
    HUGE_MUSHROOM_2(100, Mushroom.class),
    /**
     * 铁栏杆(铁栅栏)
     */
    IRON_FENCE(101),
    /**
     * 玻璃板
     */
    THIN_GLASS(102),
    /**
     * 西瓜
     */
    MELON_BLOCK(103),
    /**
     * 南瓜梗(南瓜梗本体方块)
     */
    PUMPKIN_STEM(104, MaterialData.class),
    /**
     * 西瓜梗(西瓜梗本体方块)
     */
    MELON_STEM(105, MaterialData.class),
    /**
     * 藤蔓(爬墙虎)
     */
    VINE(106, Vine.class),
    /**
     * 栅栏门
     */
    FENCE_GATE(107, Gate.class),
    /**
     * 砖块楼梯
     */
    BRICK_STAIRS(108, Stairs.class),
    /**
     * 石砖楼梯
     */
    SMOOTH_STAIRS(109, Stairs.class),
    /**
     * 菌丝
     */
    MYCEL(110),
    /**
     * 睡莲
     */
    WATER_LILY(111),
    /**
     * 地狱砖块(地狱砖)
     */
    NETHER_BRICK(112),
    /**
     * 地狱砖栏杆(地狱砖栅栏)
     */
    NETHER_FENCE(113),
    /**
     * 地狱砖楼梯
     */
    NETHER_BRICK_STAIRS(114, Stairs.class),
    /**
     * 地狱疣
     */
    NETHER_WARTS(115, NetherWarts.class),
    /**
     * 附魔台
     */
    ENCHANTMENT_TABLE(116),
    /**
     * 酿造台
     */
    BREWING_STAND(117, MaterialData.class),
    /**
     * 炼药锅
     */
    CAULDRON(118, Cauldron.class),
    /**
     * 末地传送门方块(末地传送门内容物本体方块)
     */
    ENDER_PORTAL(119),
    /**
     * 末地传送门(末地传送门框架)
     */
    ENDER_PORTAL_FRAME(120),
    /**
     * 末地石
     */
    ENDER_STONE(121),
    /**
     * 龙蛋
     */
    DRAGON_EGG(122),
    /**
     * 红石灯(关闭状态)
     */
    REDSTONE_LAMP_OFF(123),
    /**
     * 红石灯(开启/充能状态)
     */
    REDSTONE_LAMP_ON(124),
    /**
     * 双木台阶
     */
    WOOD_DOUBLE_STEP(125, Wood.class),
    /**
     * 木台阶
     */
    WOOD_STEP(126, WoodenStep.class),
    /**
     * 可可果(可可果本体方块)
     */
    COCOA(127, CocoaPlant.class),
    /**
     * 沙石楼梯
     */
    SANDSTONE_STAIRS(128, Stairs.class),
    /**
     * 绿宝石矿石
     */
    EMERALD_ORE(129),
    /**
     * 末影箱(末影盒)
     */
    ENDER_CHEST(130, EnderChest.class),
    /**
     * 拌线钩
     */
    TRIPWIRE_HOOK(131, TripwireHook.class),
    /**
     * 拌线(线本体方块)
     */
    TRIPWIRE(132, Tripwire.class),
    /**
     * 绿宝石块
     */
    EMERALD_BLOCK(133),
    /**
     * 云杉木楼梯(云杉楼梯)
     */
    SPRUCE_WOOD_STAIRS(134, Stairs.class),
    /**
     * 桦木楼梯
     */
    BIRCH_WOOD_STAIRS(135, Stairs.class),
    /**
     * 丛林木楼梯(丛林楼梯)
     */
    JUNGLE_WOOD_STAIRS(136, Stairs.class),
    /**
     * 命令方块
     */
    COMMAND(137, Command.class),
    /**
     * 信标
     */
    BEACON(138),
    /**
     * 圆石墙
     */
    COBBLE_WALL(139),
    /**
     * 花盆
     */
    FLOWER_POT(140, FlowerPot.class),
    /**
     * 胡萝卜
     */
    CARROT(141, Crops.class),
    /**
     * 马铃薯
     */
    POTATO(142, Crops.class),
    /**
     * 木质按钮
     */
    WOOD_BUTTON(143, Button.class),
    /**
     * 头颅(生物头颅)
     */
    SKULL(144, Skull.class),
    /**
     * 铁砧
     */
    ANVIL(145),
    /**
     * 陷阱箱
     */
    TRAPPED_CHEST(146, Chest.class),
    /**
     * 测重压力板(轻质/金质)
     */
    GOLD_PLATE(147),
    /**
     * 测重压力板(重质/铁质)
     */
    IRON_PLATE(148),
    /**
     * 红石比较器
     */
    REDSTONE_COMPARATOR_OFF(149, Comparator.class),
    /**
     * 红石比较器
     */
    REDSTONE_COMPARATOR_ON(150, Comparator.class),
    /**
     * 阳光传感器(日光板)
     */
    DAYLIGHT_DETECTOR(151),
    /**
     * 红石块
     */
    REDSTONE_BLOCK(152),
    /**
     * 下届石英矿石
     */
    QUARTZ_ORE(153),
    /**
     * 漏斗
     */
    HOPPER(154, Hopper.class),
    /**
     * 石英块
     */
    QUARTZ_BLOCK(155),
    /**
     * 石英楼梯
     */
    QUARTZ_STAIRS(156, Stairs.class),
    /**
     * 激活铁轨
     */
    ACTIVATOR_RAIL(157, PoweredRail.class),
    /**
     * 投掷器
     */
    DROPPER(158, Dispenser.class),
    /**
     * 黏土块(染色陶瓦)
     */
    STAINED_CLAY(159),
    /**
     * 染色玻璃板
     */
    STAINED_GLASS_PANE(160),
    /**
     * 树叶(金合欢/深色橡木)
     */
    LEAVES_2(161, Leaves.class),
    /**
     * 木头(金合欢/深色橡木)
     */
    LOG_2(162, Tree.class),
    /**
     * 金合欢楼梯
     */
    ACACIA_STAIRS(163, Stairs.class),
    /**
     * 深色橡木楼梯
     */
    DARK_OAK_STAIRS(164, Stairs.class),
    /**
     * 粘液块(史莱姆块)
     */
    SLIME_BLOCK(165),
    /**
     * 屏障
     */
    BARRIER(166),
    /**
     * 海晶石
     */
    IRON_TRAPDOOR(167, TrapDoor.class),
    /**
     * 海晶灯
     */
    PRISMARINE(168),
    /**
     * 干草块
     */
    SEA_LANTERN(169),
    /**
     * 地毯
     */
    HAY_BLOCK(170),
    /**
     * 地毯
     */
    CARPET(171),
    /**
     * 陶瓦
     */
    HARD_CLAY(172),
    /**
     * 煤炭块
     */
    COAL_BLOCK(173),
    /**
     * 浮冰
     */
    PACKED_ICE(174),
    /**
     * 大型花
     */
    DOUBLE_PLANT(175),
    /**
     * 站立的旗帜
     */
    STANDING_BANNER(176, Banner.class),
    /**
     * 墙上的旗帜
     */
    WALL_BANNER(177, Banner.class),
    /**
     * 反向阳光传感器
     */
    DAYLIGHT_DETECTOR_INVERTED(178),
    /**
     * 红砂岩
     */
    RED_SANDSTONE(179),
    /**
     * 红砂岩楼梯
     */
    RED_SANDSTONE_STAIRS(180, Stairs.class),
    /**
     * 双红砂岩台阶
     */
    DOUBLE_STONE_SLAB2(181),
    /**
     * 红砂岩台阶
     */
    STONE_SLAB2(182),
    /**
     * 云杉木栅栏门
     */
    SPRUCE_FENCE_GATE(183, Gate.class),
    /**
     * 白桦木栅栏门
     */
    BIRCH_FENCE_GATE(184, Gate.class),
    /**
     * 丛林木栅栏门
     */
    JUNGLE_FENCE_GATE(185, Gate.class),
    /**
     * 深色橡木栅栏门
     */
    DARK_OAK_FENCE_GATE(186, Gate.class),
    /**
     * 金合欢栅栏门
     */
    ACACIA_FENCE_GATE(187, Gate.class),
    /**
     * 云杉木栅栏
     */
    SPRUCE_FENCE(188),
    /**
     * 白桦木栅栏
     */
    BIRCH_FENCE(189),
    /**
     * 丛林木栅栏
     */
    JUNGLE_FENCE(190),
    /**
     * 深色橡木栅栏
     */
    DARK_OAK_FENCE(191),
    /**
     * 金合欢栅栏
     */
    ACACIA_FENCE(192),
    /**
     * 云杉木门
     */
    SPRUCE_DOOR(193, Door.class),
    /**
     * 白桦木门
     */
    BIRCH_DOOR(194, Door.class),
    /**
     * 丛林木门
     */
    JUNGLE_DOOR(195, Door.class),
    /**
     * 金合欢木门
     */
    ACACIA_DOOR(196, Door.class),
    /**
     * 深色橡木门
     */
    DARK_OAK_DOOR(197, Door.class),
    /**
     * 末地烛
     */
    END_ROD(198),
    /**
     * 紫颂植物
     */
    CHORUS_PLANT(199),
    /**
     * 紫颂花
     */
    CHORUS_FLOWER(200),
    /**
     * 紫珀块
     */
    PURPUR_BLOCK(201),
    /**
     * 竖纹紫珀块
     */
    PURPUR_PILLAR(202),
    /**
     * 紫珀块楼梯
     */
    PURPUR_STAIRS(203, Stairs.class),
    /**
     * 双紫珀台阶
     */
    PURPUR_DOUBLE_SLAB(204),
    /**
     * 紫珀块台阶
     */
    PURPUR_SLAB(205),
    /**
     * 末地石砖
     */
    END_BRICKS(206),
    /**
     * 甜菜种子
     */
    BEETROOT_BLOCK(207, Crops.class),
    /**
     * 草径
     */
    GRASS_PATH(208),
    /**
     * 末地折跃门方块
     */
    END_GATEWAY(209),
    /**
     * 循环性命令方块
     */
    COMMAND_REPEATING(210, Command.class),
    /**
     * 连锁性命令方块
     */
    COMMAND_CHAIN(211, Command.class),
    /**
     * 霜冰
     */
    FROSTED_ICE(212),
    /**
     * 岩浆块(熔岩块)
     */
    MAGMA(213),
    /**
     * 地狱疣块
     */
    NETHER_WART_BLOCK(214),
    /**
     * 红色地狱砖
     */
    RED_NETHER_BRICK(215),
    /**
     * 骨块
     */
    BONE_BLOCK(216),
    /**
     * 结构空位
     */
    STRUCTURE_VOID(217),
    /**
     * 侦测器
     */
    OBSERVER(218, Observer.class),
    /**
     * 白色潜影盒
     */
    WHITE_SHULKER_BOX(219, 1),
    /**
     * 橙色潜影盒
     */
    ORANGE_SHULKER_BOX(220, 1),
    /**
     * 品红色潜影盒
     */
    MAGENTA_SHULKER_BOX(221, 1),
    /**
     * 淡蓝色潜影盒
     */
    LIGHT_BLUE_SHULKER_BOX(222, 1),
    /**
     * 黄色潜影盒
     */
    YELLOW_SHULKER_BOX(223, 1),
    /**
     * 黄绿色潜影盒
     */
    LIME_SHULKER_BOX(224, 1),
    /**
     * 粉红色潜影盒
     */
    PINK_SHULKER_BOX(225, 1),
    /**
     * 灰色潜影盒
     */
    GRAY_SHULKER_BOX(226, 1),
    /**
     * 淡灰色潜影盒
     */
    SILVER_SHULKER_BOX(227, 1),
    /**
     * 青色潜影盒
     */
    CYAN_SHULKER_BOX(228, 1),
    /**
     * 紫色潜影盒
     */
    PURPLE_SHULKER_BOX(229, 1),
    /**
     * 蓝色潜影盒
     */
    BLUE_SHULKER_BOX(230, 1),
    /**
     * 棕色潜影盒
     */
    BROWN_SHULKER_BOX(231, 1),
    /**
     * 绿色潜影盒
     */
    GREEN_SHULKER_BOX(232, 1),
    /**
     * 红色潜影盒
     */
    RED_SHULKER_BOX(233, 1),
    /**
     * 黑色潜影盒
     */
    BLACK_SHULKER_BOX(234, 1),
    /**
     * 白色带釉陶瓦
     */
    WHITE_GLAZED_TERRACOTTA(235),
    /**
     * 橘色带釉陶瓦(橙色带釉陶瓦)
     */
    ORANGE_GLAZED_TERRACOTTA(236),
    /**
     * 品红色带釉陶瓦
     */
    MAGENTA_GLAZED_TERRACOTTA(237),
    /**
     * 淡蓝色带釉陶瓦
     */
    LIGHT_BLUE_GLAZED_TERRACOTTA(238),
    /**
     * 黄色带釉陶瓦
     */
    YELLOW_GLAZED_TERRACOTTA(239),
    /**
     * 黄绿色带釉陶瓦
     */
    LIME_GLAZED_TERRACOTTA(240),
    /**
     * 粉红色带釉陶瓦
     */
    PINK_GLAZED_TERRACOTTA(241),
    /**
     * 灰色带釉陶瓦
     */
    GRAY_GLAZED_TERRACOTTA(242),
    /**
     * 浅灰色带釉陶瓦(银色带釉陶瓦)
     */
    SILVER_GLAZED_TERRACOTTA(243),
    /**
     * 青色带釉陶瓦
     */
    CYAN_GLAZED_TERRACOTTA(244),
    /**
     * 紫色带釉陶瓦
     */
    PURPLE_GLAZED_TERRACOTTA(245),
    /**
     * 蓝色带釉陶瓦
     */
    BLUE_GLAZED_TERRACOTTA(246),
    /**
     * 棕色带釉陶瓦
     */
    BROWN_GLAZED_TERRACOTTA(247),
    /**
     * 绿色带釉陶瓦
     */
    GREEN_GLAZED_TERRACOTTA(248),
    /**
     * 红色带釉陶瓦
     */
    RED_GLAZED_TERRACOTTA(249),
    /**
     * 黑色带釉陶瓦
     */
    BLACK_GLAZED_TERRACOTTA(250),
    /**
     * 混凝土
     */
    CONCRETE(251),
    /**
     * 混凝土粉末
     */
    CONCRETE_POWDER(252),
    /**
     * 结构方块
     */
    STRUCTURE_BLOCK(255),
    // ----- Item Separator -----
    /**
     * 铁锹
     */
    IRON_SPADE(256, 1, 250),
    /**
     * 铁镐
     */
    IRON_PICKAXE(257, 1, 250),
    /**
     * 铁斧
     */
    IRON_AXE(258, 1, 250),
    /**
     * 打火石
     */
    FLINT_AND_STEEL(259, 1, 64),
    /**
     * 苹果
     */
    APPLE(260),
    /**
     * 弓
     */
    BOW(261, 1, 384),
    /**
     * 箭
     */
    ARROW(262),
    /**
     * 煤炭
     */
    COAL(263, Coal.class),
    /**
     * 钻石
     */
    DIAMOND(264),
    /**
     * 铁锭
     */
    IRON_INGOT(265),
    /**
     * 金锭
     */
    GOLD_INGOT(266),
    /**
     * 铁剑
     */
    IRON_SWORD(267, 1, 250),
    /**
     * 木剑
     */
    WOOD_SWORD(268, 1, 59),
    /**
     * 木锹
     */
    WOOD_SPADE(269, 1, 59),
    /**
     * 木镐
     */
    WOOD_PICKAXE(270, 1, 59),
    /**
     * 木斧
     */
    WOOD_AXE(271, 1, 59),
    /**
     * 石剑
     */
    STONE_SWORD(272, 1, 131),
    /**
     * 石锹
     */
    STONE_SPADE(273, 1, 131),
    /**
     * 石镐
     */
    STONE_PICKAXE(274, 1, 131),
    /**
     * 石斧
     */
    STONE_AXE(275, 1, 131),
    /**
     * 钻石剑
     */
    DIAMOND_SWORD(276, 1, 1561),
    /**
     * 钻石锹
     */
    DIAMOND_SPADE(277, 1, 1561),
    /**
     * 钻石镐
     */
    DIAMOND_PICKAXE(278, 1, 1561),
    /**
     * 钻石斧
     */
    DIAMOND_AXE(279, 1, 1561),
    /**
     * 木棍(棍/棍子)
     */
    STICK(280),
    /**
     * 碗(木碗)
     */
    BOWL(281),
    /**
     * 蘑菇煲
     */
    MUSHROOM_SOUP(282, 1),
    /**
     * 金剑
     */
    GOLD_SWORD(283, 1, 32),
    /**
     * 金锹
     */
    GOLD_SPADE(284, 1, 32),
    /**
     * 金镐
     */
    GOLD_PICKAXE(285, 1, 32),
    /**
     * 金斧
     */
    GOLD_AXE(286, 1, 32),
    /**
     * 线
     */
    STRING(287),
    /**
     * 羽毛
     */
    FEATHER(288),
    /**
     * 火药
     */
    SULPHUR(289),
    /**
     * 木锄
     */
    WOOD_HOE(290, 1, 59),
    /**
     * 石锄
     */
    STONE_HOE(291, 1, 131),
    /**
     * 铁锄
     */
    IRON_HOE(292, 1, 250),
    /**
     * 钻石锄
     */
    DIAMOND_HOE(293, 1, 1561),
    /**
     * 金锄
     */
    GOLD_HOE(294, 1, 32),
    /**
     * 小麦种子
     */
    SEEDS(295),
    /**
     * 小麦
     */
    WHEAT(296),
    /**
     * 面包
     */
    BREAD(297),
    /**
     * 皮革帽子
     */
    LEATHER_HELMET(298, 1, 55),
    /**
     * 皮革外套
     */
    LEATHER_CHESTPLATE(299, 1, 80),
    /**
     * 皮革裤子
     */
    LEATHER_LEGGINGS(300, 1, 75),
    /**
     * 皮革靴子
     */
    LEATHER_BOOTS(301, 1, 65),
    /**
     * 锁链帽子
     */
    CHAINMAIL_HELMET(302, 1, 165),
    /**
     * 锁链头盔
     */
    CHAINMAIL_CHESTPLATE(303, 1, 240),
    /**
     * 锁链护腿
     */
    CHAINMAIL_LEGGINGS(304, 1, 225),
    /**
     * 锁链靴子
     */
    CHAINMAIL_BOOTS(305, 1, 195),
    /**
     * 铁头盔
     */
    IRON_HELMET(306, 1, 165),
    /**
     * 铁胸甲
     */
    IRON_CHESTPLATE(307, 1, 240),
    /**
     * 铁护腿
     */
    IRON_LEGGINGS(308, 1, 225),
    /**
     * 铁头盔
     */
    IRON_BOOTS(309, 1, 195),
    /**
     * 钻石头盔
     */
    DIAMOND_HELMET(310, 1, 363),
    /**
     * 钻石胸甲
     */
    DIAMOND_CHESTPLATE(311, 1, 528),
    /**
     * 钻石护腿
     */
    DIAMOND_LEGGINGS(312, 1, 495),
    /**
     * 钻石靴子
     */
    DIAMOND_BOOTS(313, 1, 429),
    /**
     * 金头盔
     */
    GOLD_HELMET(314, 1, 77),
    /**
     * 金胸甲
     */
    GOLD_CHESTPLATE(315, 1, 112),
    /**
     * 金护腿
     */
    GOLD_LEGGINGS(316, 1, 105),
    /**
     * 金靴子
     */
    GOLD_BOOTS(317, 1, 91),
    /**
     * 燧石
     */
    FLINT(318),
    /**
     * 生猪排
     */
    PORK(319),
    /**
     * 熟猪排
     */
    GRILLED_PORK(320),
    /**
     * 画
     */
    PAINTING(321),
    /**
     * 金苹果
     */
    GOLDEN_APPLE(322),
    /**
     * 告示牌
     */
    SIGN(323, 16),
    /**
     * 橡木门
     */
    WOOD_DOOR(324, 64),
    /**
     * 桶(空桶)
     */
    BUCKET(325, 16),
    /**
     * 水桶
     */
    WATER_BUCKET(326, 1),
    /**
     * 岩浆桶(熔岩桶)
     */
    LAVA_BUCKET(327, 1),
    /**
     * 矿车
     */
    MINECART(328, 1),
    /**
     * 鞍
     */
    SADDLE(329, 1),
    /**
     * 铁门
     */
    IRON_DOOR(330, 64),
    /**
     * 红石粉
     */
    REDSTONE(331),
    /**
     * 雪球
     */
    SNOW_BALL(332, 16),
    /**
     * 船
     */
    BOAT(333, 1),
    /**
     * 皮革
     */
    LEATHER(334),
    /**
     * 牛奶(盛有牛奶的水桶)
     */
    MILK_BUCKET(335, 1),
    /**
     * 红砖
     */
    CLAY_BRICK(336),
    /**
     * 黏土(粘土)
     */
    CLAY_BALL(337),
    /**
     * 甘蔗
     */
    SUGAR_CANE(338),
    /**
     * 纸(纸张/原纸)
     */
    PAPER(339),
    /**
     * 书
     */
    BOOK(340),
    /**
     * 粘液球
     */
    SLIME_BALL(341),
    /**
     * 运输矿车
     */
    STORAGE_MINECART(342, 1),
    /**
     * 动力矿车
     */
    POWERED_MINECART(343, 1),
    /**
     * 鸡蛋(蛋)
     */
    EGG(344, 16),
    /**
     * 指南针
     */
    COMPASS(345),
    /**
     * 钓鱼竿
     */
    FISHING_ROD(346, 1, 64),
    /**
     * 钟(表/钟表)
     */
    WATCH(347),
    /**
     * 荧石粉(萤石粉)
     */
    GLOWSTONE_DUST(348),
    /**
     * 鱼(生鱼)
     */
    RAW_FISH(349),
    /**
     * 鱼(熟鱼)
     */
    COOKED_FISH(350),
    /**
     * 染料(墨带/章鱼墨囊)
     */
    INK_SACK(351, Dye.class),
    /**
     * 骨头
     */
    BONE(352),
    /**
     * 糖(糖粉)
     */
    SUGAR(353),
    /**
     * 蛋糕
     */
    CAKE(354, 1),
    /**
     * 床
     */
    BED(355, 1),
    /**
     * 红石中继器
     */
    DIODE(356),
    /**
     * 曲奇
     */
    COOKIE(357),
    /**
     * 地图
     * @see MapView
     */
    MAP(358, MaterialData.class),
    /**
     * 剪刀
     */
    SHEARS(359, 1, 238),
    /**
     * 西瓜片
     */
    MELON(360),
    /**
     * 南瓜种子
     */
    PUMPKIN_SEEDS(361),
    /**
     * 西瓜种子
     */
    MELON_SEEDS(362),
    /**
     * 生牛肉
     */
    RAW_BEEF(363),
    /**
     * 牛排
     */
    COOKED_BEEF(364),
    /**
     * 生鸡肉
     */
    RAW_CHICKEN(365),
    /**
     * 熟鸡肉
     */
    COOKED_CHICKEN(366),
    /**
     * 腐肉
     */
    ROTTEN_FLESH(367),
    /**
     * 末影珍珠
     */
    ENDER_PEARL(368, 16),
    /**
     * 烈焰棒
     */
    BLAZE_ROD(369),
    /**
     * 恶魂之泪
     */
    GHAST_TEAR(370),
    /**
     * 金粒
     */
    GOLD_NUGGET(371),
    /**
     * 地狱疣(地狱疣种子)
     */
    NETHER_STALK(372),
    /**
     * 药水
     */
    POTION(373, 1, MaterialData.class),
    /**
     * 玻璃瓶
     */
    GLASS_BOTTLE(374),
    /**
     * 蜘蛛眼
     */
    SPIDER_EYE(375),
    /**
     * 发酵蜘蛛眼(发酵的蜘蛛眼/发酵蛛眼)
     */
    FERMENTED_SPIDER_EYE(376),
    /**
     * 烈焰粉
     */
    BLAZE_POWDER(377),
    /**
     * 岩浆膏
     */
    MAGMA_CREAM(378),
    /**
     * 酿造台
     */
    BREWING_STAND_ITEM(379),
    /**
     * 炼药锅
     */
    CAULDRON_ITEM(380),
    /**
     * 末影之眼
     */
    EYE_OF_ENDER(381),
    /**
     * 闪烁的西瓜
     */
    SPECKLED_MELON(382),
    /**
     * 刷怪蛋
     */
    MONSTER_EGG(383, 64, SpawnEgg.class),
    /**
     * 经验瓶(附魔之瓶)
     */
    EXP_BOTTLE(384, 64),
    /**
     * 火焰弹(火焰球/霹雳球)
     */
    FIREBALL(385, 64),
    /**
     * 书与笔(可写的书)
     */
    BOOK_AND_QUILL(386, 1),
    /**
     * 成书
     */
    WRITTEN_BOOK(387, 16),
    /**
     * 绿宝石
     */
    EMERALD(388, 64),
    /**
     * 物品展示框
     */
    ITEM_FRAME(389),
    /**
     * 花盆
     */
    FLOWER_POT_ITEM(390),
    /**
     * 胡萝卜
     */
    CARROT_ITEM(391),
    /**
     * 马铃薯
     */
    POTATO_ITEM(392),
    /**
     * 烤马铃薯
     */
    BAKED_POTATO(393),
    /**
     * 毒马铃薯
     */
    POISONOUS_POTATO(394),
    /**
     * 空地图
     */
    EMPTY_MAP(395),
    /**
     * 金胡萝卜
     */
    GOLDEN_CARROT(396),
    /**
     * 生物头颅
     */
    SKULL_ITEM(397),
    /**
     * 胡萝卜钓竿
     */
    CARROT_STICK(398, 1, 25),
    /**
     * 下界之星
     */
    NETHER_STAR(399),
    /**
     * 南瓜派
     */
    PUMPKIN_PIE(400),
    /**
     * 烟花之箭(烟火/爆竹/烟花)
     */
    FIREWORK(401),
    /**
     * 烟火之星
     */
    FIREWORK_CHARGE(402),
    /**
     * 附魔书
     */
    ENCHANTED_BOOK(403, 1),
    /**
     * 红石比较器
     */
    REDSTONE_COMPARATOR(404),
    /**
     * 地狱砖块
     */
    NETHER_BRICK_ITEM(405),
    /**
     * 下界石英
     */
    QUARTZ(406),
    /**
     * TNT矿车(爆破车)
     */
    EXPLOSIVE_MINECART(407, 1),
    /**
     * 漏斗矿车
     */
    HOPPER_MINECART(408, 1),
    /**
     * 海晶碎片
     */
    PRISMARINE_SHARD(409),
    /**
     * 海晶砂砾
     */
    PRISMARINE_CRYSTALS(410),
    /**
     * 生兔肉
     */
    RABBIT(411),
    /**
     * 熟兔肉
     */
    COOKED_RABBIT(412),
    /**
     * 兔子煲
     */
    RABBIT_STEW(413, 1),
    /**
     * 兔子脚
     */
    RABBIT_FOOT(414),
    /**
     * 兔子皮
     */
    RABBIT_HIDE(415),
    /**
     * 盔甲架
     */
    ARMOR_STAND(416, 16),
    /**
     * 铁马铠
     */
    IRON_BARDING(417, 1),
    /**
     * 金马铠
     */
    GOLD_BARDING(418, 1),
    /**
     * 钻石马鞍
     */
    DIAMOND_BARDING(419, 1),
    /**
     * 栓绳
     */
    LEASH(420),
    /**
     * 命名牌
     */
    NAME_TAG(421),
    /**
     * 命令方块矿车
     */
    COMMAND_MINECART(422, 1),
    /**
     * 生羊肉
     */
    MUTTON(423),
    /**
     * 熟羊肉
     */
    COOKED_MUTTON(424),
    /**
     * 旗帜
     */
    BANNER(425, 16),
    /**
     * 末影水晶
     */
    END_CRYSTAL(426),
    /**
     * 云杉木门
     */
    SPRUCE_DOOR_ITEM(427),
    /**
     * 白桦木门
     */
    BIRCH_DOOR_ITEM(428),
    /**
     * 丛林木门
     */
    JUNGLE_DOOR_ITEM(429),
    /**
     * 金合欢木门
     */
    ACACIA_DOOR_ITEM(430),
    /**
     * 深色橡木门
     */
    DARK_OAK_DOOR_ITEM(431),
    /**
     * 紫颂果
     */
    CHORUS_FRUIT(432),
    /**
     * 爆裂紫颂果
     */
    CHORUS_FRUIT_POPPED(433),
    /**
     * 甜菜根
     */
    BEETROOT(434),
    /**
     * 甜菜种子
     */
    BEETROOT_SEEDS(435),
    /**
     * 甜菜汤
     */
    BEETROOT_SOUP(436, 1),
    /**
     * 龙息
     */
    DRAGONS_BREATH(437),
    /**
     * 喷溅药水
     */
    SPLASH_POTION(438, 1),
    /**
     * 光灵箭
     */
    SPECTRAL_ARROW(439),
    /**
     * 药箭
     */
    TIPPED_ARROW(440),
    /**
     * 滞留药水
     */
    LINGERING_POTION(441, 1),
    /**
     * 盾牌
     */
    SHIELD(442, 1, 336),
    /**
     * 鞘翅
     */
    ELYTRA(443, 1, 431),
    /**
     * 云杉木船
     */
    BOAT_SPRUCE(444, 1),
    /**
     * 白桦木船
     */
    BOAT_BIRCH(445, 1),
    /**
     * 丛林木船
     */
    BOAT_JUNGLE(446, 1),
    /**
     * 金合欢木船
     */
    BOAT_ACACIA(447, 1),
    /**
     * 深色橡木船
     */
    BOAT_DARK_OAK(448, 1),
    /**
     * 不死图腾
     */
    TOTEM(449, 1),
    /**
     * 潜影壳
     */
    SHULKER_SHELL(450),
    /**
     * 铁粒
     */
    IRON_NUGGET(452),
    KNOWLEDGE_BOOK(453, 1),
    /**
     * 唱片(13)
     */
    GOLD_RECORD(2256, 1),
    /**
     * 唱片(CAT)
     */
    GREEN_RECORD(2257, 1),
    /**
     * 唱片(BLOCKS)
     */
    RECORD_3(2258, 1),
    /**
     * 唱片(CHIRP)
     */
    RECORD_4(2259, 1),
    /**
     * 唱片(FAR)
     */
    RECORD_5(2260, 1),
    /**
     * 唱片(mall)
     */
    RECORD_6(2261, 1),
    /**
     * 唱片(MELLOHI)
     */
    RECORD_7(2262, 1),
    /**
     * 唱片(STAL)
     */
    RECORD_8(2263, 1),
    /**
     * 唱片(STRAD)
     */
    RECORD_9(2264, 1),
    /**
     * 唱片(WARD)
     */
    RECORD_10(2265, 1),
    /**
     * 唱片(11)
     */
    RECORD_11(2266, 1),
    /**
     * 唱片(WAIT)
     */
    RECORD_12(2267, 1),
    ;

    private final int id;
    private final Constructor<? extends MaterialData> ctor;
    private static Material[] byId = new Material[383];
    private final static Map<String, Material> BY_NAME = Maps.newHashMap();
    private final int maxStack;
    private final short durability;

    private Material(final int id) {
        this(id, 64);
    }

    private Material(final int id, final int stack) {
        this(id, stack, MaterialData.class);
    }

    private Material(final int id, final int stack, final int durability) {
        this(id, stack, durability, MaterialData.class);
    }

    private Material(final int id, final Class<? extends MaterialData> data) {
        this(id, 64, data);
    }

    private Material(final int id, final int stack, final Class<? extends MaterialData> data) {
        this(id, stack, 0, data);
    }

    private Material(final int id, final int stack, final int durability, final Class<? extends MaterialData> data) {
        this.id = id;
        this.durability = (short) durability;
        this.maxStack = stack;
        // try to cache the constructor for this material
        try {
            this.ctor = data.getConstructor(int.class, byte.class);
        } catch (NoSuchMethodException ex) {
            throw new AssertionError(ex);
        } catch (SecurityException ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * 获取这个物品的id.
     * <p>
     * 原文:Gets the item ID or block ID of this Material
     *
     * @return 物品id
     * @deprecated 魔法值
     */
    @Deprecated
    public int getId() {
        return id;
    }

    /**
     * 获取这个物品的最大堆叠数量.
     * <p>
     * 原文:Gets the maximum amount of this material that can be held in a stack
     *
     * @return 物品的最大堆叠数量
     */
    public int getMaxStackSize() {
        return maxStack;
    }

    /**
     * 获取这个物品的最大耐久度.
     * <p>
     * 原文:Gets the maximum durability of this material
     *
     * @return 物品的最大耐久度
     */
    public short getMaxDurability() {
        return durability;
    }

    /**
     * 获取这个物品相关的MaterialData类.
     * <p>
     * 原文:Gets the MaterialData class associated with this Material
     *
     * @return 物品相关的MaterialData类
     */
    public Class<? extends MaterialData> getData() {
        return ctor.getDeclaringClass();
    }

    /**
     * 用给定的初始数据构造一个新的与这个物品有关的MaterialData对象.
     * <p>
     * 原文:Constructs a new MaterialData relevant for this Material, with the
     * given initial data
     *
     * @param raw 用来构造MaterialData的初始数据
     * @return 给定值的MaterialData对象
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MaterialData getNewData(final byte raw) {
        try {
            return ctor.newInstance(id, raw);
        } catch (InstantiationException ex) {
            final Throwable t = ex.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            }
            if (t instanceof Error) {
                throw (Error) t;
            }
            throw new AssertionError(t);
        } catch (Throwable t) {
            throw new AssertionError(t);
        }
    }

    /**
     * 检测这个物品能否放置(是否为方块).
     * <p>
     * 原文:Checks if this Material is a placable block
     *
     * @return 物品是否为方块
     */
    public boolean isBlock() {
        return id < 256;
    }

    /**
     * 检测这个物品能否食用.
     * <p>
     * 原文:Checks if this Material is edible.
     *
     * @return 如果物品能食用
     */
    public boolean isEdible() {
        switch (this) {
            case BREAD:
            case CARROT_ITEM:
            case BAKED_POTATO:
            case POTATO_ITEM:
            case POISONOUS_POTATO:
            case GOLDEN_CARROT:
            case PUMPKIN_PIE:
            case COOKIE:
            case MELON:
            case MUSHROOM_SOUP:
            case RAW_CHICKEN:
            case COOKED_CHICKEN:
            case RAW_BEEF:
            case COOKED_BEEF:
            case RAW_FISH:
            case COOKED_FISH:
            case PORK:
            case GRILLED_PORK:
            case APPLE:
            case GOLDEN_APPLE:
            case ROTTEN_FLESH:
            case SPIDER_EYE:
            case RABBIT:
            case COOKED_RABBIT:
            case RABBIT_STEW:
            case MUTTON:
            case COOKED_MUTTON:
            case BEETROOT:
            case CHORUS_FRUIT:
            case BEETROOT_SOUP:
                return true;
            default:
                return false;
        }
    }

    /**
     * 尝试用给定id获取Material对象.
     * <p>
     * 原文:Attempts to get the Material with the given ID
     *
     * @param id 用来获取Material对象的id
     * @return 如果找不到返回null,否则返回Material对象
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static Material getMaterial(final int id) {
        if (byId.length > id && id >= 0) {
            return byId[id];
        } else {
            return null;
        }
    }

    /**
     * 尝试用给定名称获取Material对象.
     * <p>
     * 这是一个标准的查找,名称必须是枚举中给出的准确名称.
     * <p>
     * 原文:Attempts to get the Material with the given name.
     * <p>
     * This is a normal lookup, names must be the precise name they are given
     * in the enum.
     *
     * @param name 用来获取Material对象的名称
     * @return 如果找不到返回null,否则返回Material对象
     */
    public static Material getMaterial(final String name) {
        return BY_NAME.get(name);
    }

    /**
     * 尝试用给定名称匹配Material对象.
     * <p>
     * 这是一个匹配查找;名称将转换为大写,然后格式化字符.
     * <p>
     * 用ID匹配已过时.
     * <p>
     * 原文:Attempts to match the Material with the given name.
     * <p>
     * This is a match lookup; names will be converted to uppercase, then
     * stripped of special characters in an attempt to format it like the
     * enum.
     * <p>
     * Using this for match by ID is deprecated.
     *
     * @param name 用来获取Material对象的名称
     * @return 如果找不到返回null,否则返回Material对象
     */
    public static Material matchMaterial(final String name) {
        Validate.notNull(name, "Name cannot be null");

        Material result = null;

        try {
            result = getMaterial(Integer.parseInt(name));
        } catch (NumberFormatException ex) {}

        if (result == null) {
            String filtered = name.toUpperCase(java.util.Locale.ENGLISH);

            filtered = filtered.replaceAll("\\s+", "_").replaceAll("\\W", "");
            result = BY_NAME.get(filtered);
        }

        return result;
    }

    static {
        for (Material material : values()) {
            if (byId.length > material.id) {
                byId[material.id] = material;
            } else {
                byId = Arrays.copyOfRange(byId, 0, material.id + 2);
                byId[material.id] = material;
            }
            BY_NAME.put(material.name(), material);
        }
    }

    /**
     * @return 如果这个物品代表音乐唱片则为true.
     */
    public boolean isRecord() {
        return id >= GOLD_RECORD.id && id <= RECORD_12.id;
    }

    /**
     * 检测物品是否为固体方块(可被放置).
     * <p>
     * 原文:Check if the material is a block and solid (cannot be passed through by
     * a player)
     *
     * @return 物品是否为固体方块
     */
    public boolean isSolid() {
        if (!isBlock() || id == 0) {
            return false;
        }
        switch (this) {
            case STONE:
            case GRASS:
            case DIRT:
            case COBBLESTONE:
            case WOOD:
            case BEDROCK:
            case SAND:
            case GRAVEL:
            case GOLD_ORE:
            case IRON_ORE:
            case COAL_ORE:
            case LOG:
            case LEAVES:
            case SPONGE:
            case GLASS:
            case LAPIS_ORE:
            case LAPIS_BLOCK:
            case DISPENSER:
            case SANDSTONE:
            case NOTE_BLOCK:
            case BED_BLOCK:
            case PISTON_STICKY_BASE:
            case PISTON_BASE:
            case PISTON_EXTENSION:
            case WOOL:
            case PISTON_MOVING_PIECE:
            case GOLD_BLOCK:
            case IRON_BLOCK:
            case DOUBLE_STEP:
            case STEP:
            case BRICK:
            case TNT:
            case BOOKSHELF:
            case MOSSY_COBBLESTONE:
            case OBSIDIAN:
            case MOB_SPAWNER:
            case WOOD_STAIRS:
            case CHEST:
            case DIAMOND_ORE:
            case DIAMOND_BLOCK:
            case WORKBENCH:
            case SOIL:
            case FURNACE:
            case BURNING_FURNACE:
            case SIGN_POST:
            case WOODEN_DOOR:
            case COBBLESTONE_STAIRS:
            case WALL_SIGN:
            case STONE_PLATE:
            case IRON_DOOR_BLOCK:
            case WOOD_PLATE:
            case REDSTONE_ORE:
            case GLOWING_REDSTONE_ORE:
            case ICE:
            case SNOW_BLOCK:
            case CACTUS:
            case CLAY:
            case JUKEBOX:
            case FENCE:
            case PUMPKIN:
            case NETHERRACK:
            case SOUL_SAND:
            case GLOWSTONE:
            case JACK_O_LANTERN:
            case CAKE_BLOCK:
            case STAINED_GLASS:
            case TRAP_DOOR:
            case MONSTER_EGGS:
            case SMOOTH_BRICK:
            case HUGE_MUSHROOM_1:
            case HUGE_MUSHROOM_2:
            case IRON_FENCE:
            case THIN_GLASS:
            case MELON_BLOCK:
            case FENCE_GATE:
            case BRICK_STAIRS:
            case SMOOTH_STAIRS:
            case MYCEL:
            case NETHER_BRICK:
            case NETHER_FENCE:
            case NETHER_BRICK_STAIRS:
            case ENCHANTMENT_TABLE:
            case BREWING_STAND:
            case CAULDRON:
            case ENDER_PORTAL_FRAME:
            case ENDER_STONE:
            case DRAGON_EGG:
            case REDSTONE_LAMP_OFF:
            case REDSTONE_LAMP_ON:
            case WOOD_DOUBLE_STEP:
            case WOOD_STEP:
            case SANDSTONE_STAIRS:
            case EMERALD_ORE:
            case ENDER_CHEST:
            case EMERALD_BLOCK:
            case SPRUCE_WOOD_STAIRS:
            case BIRCH_WOOD_STAIRS:
            case JUNGLE_WOOD_STAIRS:
            case COMMAND:
            case BEACON:
            case COBBLE_WALL:
            case ANVIL:
            case TRAPPED_CHEST:
            case GOLD_PLATE:
            case IRON_PLATE:
            case DAYLIGHT_DETECTOR:
            case REDSTONE_BLOCK:
            case QUARTZ_ORE:
            case HOPPER:
            case QUARTZ_BLOCK:
            case QUARTZ_STAIRS:
            case DROPPER:
            case STAINED_CLAY:
            case HAY_BLOCK:
            case HARD_CLAY:
            case COAL_BLOCK:
            case STAINED_GLASS_PANE:
            case LEAVES_2:
            case LOG_2:
            case ACACIA_STAIRS:
            case DARK_OAK_STAIRS:
            case PACKED_ICE:
            case RED_SANDSTONE:
            case SLIME_BLOCK:
            case BARRIER:
            case IRON_TRAPDOOR:
            case PRISMARINE:
            case SEA_LANTERN:
            case DOUBLE_STONE_SLAB2:
            case RED_SANDSTONE_STAIRS:
            case STONE_SLAB2:
            case SPRUCE_FENCE_GATE:
            case BIRCH_FENCE_GATE:
            case JUNGLE_FENCE_GATE:
            case DARK_OAK_FENCE_GATE:
            case ACACIA_FENCE_GATE:
            case SPRUCE_FENCE:
            case BIRCH_FENCE:
            case JUNGLE_FENCE:
            case DARK_OAK_FENCE:
            case ACACIA_FENCE:
            case STANDING_BANNER:
            case WALL_BANNER:
            case DAYLIGHT_DETECTOR_INVERTED:
            case SPRUCE_DOOR:
            case BIRCH_DOOR:
            case JUNGLE_DOOR:
            case ACACIA_DOOR:
            case DARK_OAK_DOOR:
            case PURPUR_BLOCK:
            case PURPUR_PILLAR:
            case PURPUR_STAIRS:
            case PURPUR_DOUBLE_SLAB:
            case PURPUR_SLAB:
            case END_BRICKS:
            case GRASS_PATH:
            case STRUCTURE_BLOCK:
            case COMMAND_REPEATING:
            case COMMAND_CHAIN:
            case FROSTED_ICE:
            case MAGMA:
            case NETHER_WART_BLOCK:
            case RED_NETHER_BRICK:
            case BONE_BLOCK:
            case OBSERVER:
            case WHITE_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case SILVER_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case BLACK_SHULKER_BOX:
            case WHITE_GLAZED_TERRACOTTA:
            case ORANGE_GLAZED_TERRACOTTA:
            case MAGENTA_GLAZED_TERRACOTTA:
            case LIGHT_BLUE_GLAZED_TERRACOTTA:
            case YELLOW_GLAZED_TERRACOTTA:
            case LIME_GLAZED_TERRACOTTA:
            case PINK_GLAZED_TERRACOTTA:
            case GRAY_GLAZED_TERRACOTTA:
            case SILVER_GLAZED_TERRACOTTA:
            case CYAN_GLAZED_TERRACOTTA:
            case PURPLE_GLAZED_TERRACOTTA:
            case BLUE_GLAZED_TERRACOTTA:
            case BROWN_GLAZED_TERRACOTTA:
            case GREEN_GLAZED_TERRACOTTA:
            case RED_GLAZED_TERRACOTTA:
            case BLACK_GLAZED_TERRACOTTA:
            case CONCRETE:
            case CONCRETE_POWDER:
                return true;
            default:
                return false;
        }
    }

    /**
     * 检测这个物品是否为透明的方块.
     * <p>
     * 原文:Check if the material is a block and does not block any light
     *
     * @return 这个物品是否为透明的方块
     */
    public boolean isTransparent() {
        if (!isBlock()) {
            return false;
        }
        switch (this) {
            case AIR:
            case SAPLING:
            case POWERED_RAIL:
            case DETECTOR_RAIL:
            case LONG_GRASS:
            case DEAD_BUSH:
            case YELLOW_FLOWER:
            case RED_ROSE:
            case BROWN_MUSHROOM:
            case RED_MUSHROOM:
            case TORCH:
            case FIRE:
            case REDSTONE_WIRE:
            case CROPS:
            case LADDER:
            case RAILS:
            case LEVER:
            case REDSTONE_TORCH_OFF:
            case REDSTONE_TORCH_ON:
            case STONE_BUTTON:
            case SNOW:
            case SUGAR_CANE_BLOCK:
            case PORTAL:
            case DIODE_BLOCK_OFF:
            case DIODE_BLOCK_ON:
            case PUMPKIN_STEM:
            case MELON_STEM:
            case VINE:
            case WATER_LILY:
            case NETHER_WARTS:
            case ENDER_PORTAL:
            case COCOA:
            case TRIPWIRE_HOOK:
            case TRIPWIRE:
            case FLOWER_POT:
            case CARROT:
            case POTATO:
            case WOOD_BUTTON:
            case SKULL:
            case REDSTONE_COMPARATOR_OFF:
            case REDSTONE_COMPARATOR_ON:
            case ACTIVATOR_RAIL:
            case CARPET:
            case DOUBLE_PLANT:
            case END_ROD:
            case CHORUS_PLANT:
            case CHORUS_FLOWER:
            case BEETROOT_BLOCK:
            case END_GATEWAY:
            case STRUCTURE_VOID:
                return true;
            default:
                return false;
        }
    }

    /**
     * 检测这个方块是否为可燃的.
     * <p>
     * 原文:Check if the material is a block and can catch fire
     *
     * @return 这个方块是否为可燃的
     */
    public boolean isFlammable() {
        if (!isBlock()) {
            return false;
        }
        switch (this) {
            case WOOD:
            case LOG:
            case LEAVES:
            case NOTE_BLOCK:
            case BED_BLOCK:
            case LONG_GRASS:
            case DEAD_BUSH:
            case WOOL:
            case TNT:
            case BOOKSHELF:
            case WOOD_STAIRS:
            case CHEST:
            case WORKBENCH:
            case SIGN_POST:
            case WOODEN_DOOR:
            case WALL_SIGN:
            case WOOD_PLATE:
            case JUKEBOX:
            case FENCE:
            case TRAP_DOOR:
            case HUGE_MUSHROOM_1:
            case HUGE_MUSHROOM_2:
            case VINE:
            case FENCE_GATE:
            case WOOD_DOUBLE_STEP:
            case WOOD_STEP:
            case SPRUCE_WOOD_STAIRS:
            case BIRCH_WOOD_STAIRS:
            case JUNGLE_WOOD_STAIRS:
            case TRAPPED_CHEST:
            case DAYLIGHT_DETECTOR:
            case CARPET:
            case LEAVES_2:
            case LOG_2:
            case ACACIA_STAIRS:
            case DARK_OAK_STAIRS:
            case DOUBLE_PLANT:
            case SPRUCE_FENCE_GATE:
            case BIRCH_FENCE_GATE:
            case JUNGLE_FENCE_GATE:
            case DARK_OAK_FENCE_GATE:
            case ACACIA_FENCE_GATE:
            case SPRUCE_FENCE:
            case BIRCH_FENCE:
            case JUNGLE_FENCE:
            case DARK_OAK_FENCE:
            case ACACIA_FENCE:
            case STANDING_BANNER:
            case WALL_BANNER:
            case DAYLIGHT_DETECTOR_INVERTED:
            case SPRUCE_DOOR:
            case BIRCH_DOOR:
            case JUNGLE_DOOR:
            case ACACIA_DOOR:
            case DARK_OAK_DOOR:
                return true;
            default:
                return false;
        }
    }

    /**
     * 检测这个方块能否被火烧掉.
     * <p>
     * 原文:Check if the material is a block and can burn away
     *
     * @return 这个方块能否被火烧掉
     */
    public boolean isBurnable() {
        if (!isBlock()) {
            return false;
        }
        switch (this) {
            case WOOD:
            case LOG:
            case LEAVES:
            case LONG_GRASS:
            case WOOL:
            case YELLOW_FLOWER:
            case RED_ROSE:
            case TNT:
            case BOOKSHELF:
            case WOOD_STAIRS:
            case FENCE:
            case VINE:
            case WOOD_DOUBLE_STEP:
            case WOOD_STEP:
            case SPRUCE_WOOD_STAIRS:
            case BIRCH_WOOD_STAIRS:
            case JUNGLE_WOOD_STAIRS:
            case HAY_BLOCK:
            case COAL_BLOCK:
            case LEAVES_2:
            case LOG_2:
            case CARPET:
            case DOUBLE_PLANT:
            case DEAD_BUSH:
            case FENCE_GATE:
            case SPRUCE_FENCE_GATE:
            case BIRCH_FENCE_GATE:
            case JUNGLE_FENCE_GATE:
            case DARK_OAK_FENCE_GATE:
            case ACACIA_FENCE_GATE:
            case SPRUCE_FENCE:
            case BIRCH_FENCE:
            case JUNGLE_FENCE:
            case DARK_OAK_FENCE:
            case ACACIA_FENCE:
            case ACACIA_STAIRS:
            case DARK_OAK_STAIRS:
                return true;
            default:
                return false;
        }
    }

    /**
     * 检查这个物品是否可作为燃料使用.
     * <p>
     * 原文:Checks if this Material can be used as fuel in a Furnace
     *
     * @return 这个物品是否可作为燃料使用
     */
    public boolean isFuel() {
        switch (this) {
            case LAVA_BUCKET:
            case COAL_BLOCK:
            case BLAZE_ROD:
            case COAL:
            case BOAT:
            case BOAT_ACACIA:
            case BOAT_BIRCH:
            case BOAT_DARK_OAK:
            case BOAT_JUNGLE:
            case BOAT_SPRUCE:
            case LOG:
            case LOG_2:
            case WOOD:
            case WOOD_PLATE:
            case FENCE:
            case ACACIA_FENCE:
            case BIRCH_FENCE:
            case DARK_OAK_FENCE:
            case JUNGLE_FENCE:
            case SPRUCE_FENCE:
            case FENCE_GATE:
            case ACACIA_FENCE_GATE:
            case BIRCH_FENCE_GATE:
            case DARK_OAK_FENCE_GATE:
            case JUNGLE_FENCE_GATE:
            case SPRUCE_FENCE_GATE:
            case WOOD_STAIRS:
            case ACACIA_STAIRS:
            case BIRCH_WOOD_STAIRS:
            case DARK_OAK_STAIRS:
            case JUNGLE_WOOD_STAIRS:
            case SPRUCE_WOOD_STAIRS:
            case TRAP_DOOR:
            case WORKBENCH:
            case BOOKSHELF:
            case CHEST:
            case TRAPPED_CHEST:
            case DAYLIGHT_DETECTOR:
            case JUKEBOX:
            case NOTE_BLOCK:
            case HUGE_MUSHROOM_1:
            case HUGE_MUSHROOM_2:
            case BANNER:
            case FISHING_ROD:
            case LADDER:
            case WOOD_SWORD:
            case WOOD_PICKAXE:
            case WOOD_AXE:
            case WOOD_SPADE:
            case WOOD_HOE:
            case BOW:
            case SIGN:
            case WOOD_DOOR:
            case ACACIA_DOOR_ITEM:
            case BIRCH_DOOR_ITEM:
            case DARK_OAK_DOOR_ITEM:
            case JUNGLE_DOOR_ITEM:
            case SPRUCE_DOOR_ITEM:
            case WOOD_STEP:
            case SAPLING:
            case BOWL:
            case STICK:
            case WOOD_BUTTON:
            case WOOL:
            case CARPET:
                return true;
            default:
                return false;
        }
    }

    /**
     * 检测这个物品是否为阻挡目光的方块.
     * <p>
     * 原文:Check if the material is a block and completely blocks vision
     *
     * @return True if this material is a block and completely blocks vision
     */
    public boolean isOccluding() {
        if (!isBlock()) {
            return false;
        }
        switch (this) {
            case STONE:
            case GRASS:
            case DIRT:
            case COBBLESTONE:
            case WOOD:
            case BEDROCK:
            case SAND:
            case GRAVEL:
            case GOLD_ORE:
            case IRON_ORE:
            case COAL_ORE:
            case LOG:
            case SPONGE:
            case LAPIS_ORE:
            case LAPIS_BLOCK:
            case DISPENSER:
            case SANDSTONE:
            case NOTE_BLOCK:
            case WOOL:
            case GOLD_BLOCK:
            case IRON_BLOCK:
            case DOUBLE_STEP:
            case BRICK:
            case BOOKSHELF:
            case MOSSY_COBBLESTONE:
            case OBSIDIAN:
            case MOB_SPAWNER:
            case DIAMOND_ORE:
            case DIAMOND_BLOCK:
            case WORKBENCH:
            case FURNACE:
            case BURNING_FURNACE:
            case REDSTONE_ORE:
            case GLOWING_REDSTONE_ORE:
            case SNOW_BLOCK:
            case CLAY:
            case JUKEBOX:
            case PUMPKIN:
            case NETHERRACK:
            case SOUL_SAND:
            case JACK_O_LANTERN:
            case MONSTER_EGGS:
            case SMOOTH_BRICK:
            case HUGE_MUSHROOM_1:
            case HUGE_MUSHROOM_2:
            case MELON_BLOCK:
            case MYCEL:
            case NETHER_BRICK:
            case ENDER_STONE:
            case REDSTONE_LAMP_OFF:
            case REDSTONE_LAMP_ON:
            case WOOD_DOUBLE_STEP:
            case EMERALD_ORE:
            case EMERALD_BLOCK:
            case COMMAND:
            case QUARTZ_ORE:
            case QUARTZ_BLOCK:
            case DROPPER:
            case STAINED_CLAY:
            case HAY_BLOCK:
            case HARD_CLAY:
            case COAL_BLOCK:
            case LOG_2:
            case PACKED_ICE:
            case SLIME_BLOCK:
            case BARRIER:
            case PRISMARINE:
            case RED_SANDSTONE:
            case DOUBLE_STONE_SLAB2:
            case PURPUR_BLOCK:
            case PURPUR_PILLAR:
            case PURPUR_DOUBLE_SLAB:
            case END_BRICKS:
            case STRUCTURE_BLOCK:
            case COMMAND_REPEATING:
            case COMMAND_CHAIN:
            case MAGMA:
            case NETHER_WART_BLOCK:
            case RED_NETHER_BRICK:
            case BONE_BLOCK:
            case WHITE_GLAZED_TERRACOTTA:
            case ORANGE_GLAZED_TERRACOTTA:
            case MAGENTA_GLAZED_TERRACOTTA:
            case LIGHT_BLUE_GLAZED_TERRACOTTA:
            case YELLOW_GLAZED_TERRACOTTA:
            case LIME_GLAZED_TERRACOTTA:
            case PINK_GLAZED_TERRACOTTA:
            case GRAY_GLAZED_TERRACOTTA:
            case SILVER_GLAZED_TERRACOTTA:
            case CYAN_GLAZED_TERRACOTTA:
            case PURPLE_GLAZED_TERRACOTTA:
            case BLUE_GLAZED_TERRACOTTA:
            case BROWN_GLAZED_TERRACOTTA:
            case GREEN_GLAZED_TERRACOTTA:
            case RED_GLAZED_TERRACOTTA:
            case BLACK_GLAZED_TERRACOTTA:
            case CONCRETE:
            case CONCRETE_POWDER:
                return true;
            default:
                return false;
        }
    }

    /**
     * @return 如果这个物品（仅方块）受重力影响则为true.
     */
    public boolean hasGravity() {
        if (!isBlock()) {
            return false;
        }
        switch (this) {
            case SAND:
            case GRAVEL:
            case ANVIL:
                return true;
            default:
                return false;
        }
    }
}
