package org.bukkit;

import com.google.common.collect.Maps;
import java.util.Map;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 效果列表
 */
public enum Effect {
    /**
     * 另一种点击声
     */
    CLICK2(1000, Type.SOUND),
    /**
     * 点击声
     */
    CLICK1(1001, Type.SOUND),
    /**
     * 弓的射击声
     */
    BOW_FIRE(1002, Type.SOUND),
    /**
     * 开门声（木门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_WOODEN_DOOR_OPEN
     */
    @Deprecated(since = "1.19.3")
    DOOR_TOGGLE(1006, Type.SOUND),
    /**
     * 开门声（铁门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_IRON_DOOR_OPEN
     */
    @Deprecated(since = "1.19.3")
    IRON_DOOR_TOGGLE(1005, Type.SOUND),
    /**
     * 开门声（木活板门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_IRON_TRAPDOOR_OPEN
     */
    @Deprecated(since = "1.19.3")
    TRAPDOOR_TOGGLE(1007, Type.SOUND),
    /**
     * 开门声（铁活板门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_IRON_TRAPDOOR_OPEN
     */
    @Deprecated(since = "1.19.3")
    IRON_TRAPDOOR_TOGGLE(1037, Type.SOUND),
    /**
     * 开门声（栅栏门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_FENCE_GATE_OPEN
     */
    @Deprecated(since = "1.19.3")
    FENCE_GATE_TOGGLE(1008, Type.SOUND),
    /**
     * 关门声（木门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_WOODEN_DOOR_CLOSE
     */
    @Deprecated(since = "1.19.3")
    DOOR_CLOSE(1012, Type.SOUND),
    /**
     * 关门声（铁门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_IRON_DOOR_CLOSE
     */
    @Deprecated(since = "1.19.3")
    IRON_DOOR_CLOSE(1011, Type.SOUND),
    /**
     * 关门声（木活板门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_WOODEN_TRAPDOOR_CLOSE
     */
    @Deprecated(since = "1.19.3")
    TRAPDOOR_CLOSE(1013, Type.SOUND),
    /**
     * 关门声（铁活板门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_IRON_TRAPDOOR_CLOSE
     */
    @Deprecated(since = "1.19.3")
    IRON_TRAPDOOR_CLOSE(1036, Type.SOUND),
    /**
     * 关门声（栅栏门）
     * @deprecated 不复存在
     * @see Sound#BLOCK_FENCE_GATE_CLOSE
     */
    @Deprecated(since = "1.19.3")
    FENCE_GATE_CLOSE(1014, Type.SOUND),
    /**
     * 火焰熄灭的声音
     */
    EXTINGUISH(1009, Type.SOUND),
    /**
     * 播放唱片歌曲的声音
     */
    RECORD_PLAY(1010, Type.SOUND, Material.class),
    /**
     * 恶魂的尖叫声
     */
    GHAST_SHRIEK(1015, Type.SOUND),
    /**
     * 恶魂投射火球的声音
     */
    GHAST_SHOOT(1016, Type.SOUND),
    /**
     * 烈焰人投射火球的声音
     */
    BLAZE_SHOOT(1018, Type.SOUND),
    /**
     * 僵尸敲木门的声音
     */
    ZOMBIE_CHEW_WOODEN_DOOR(1019, Type.SOUND),
    /**
     * 僵尸敲铁门的声音
     */
    ZOMBIE_CHEW_IRON_DOOR(1020, Type.SOUND),
    /**
     * 僵尸摧毁门的声音
     */
    ZOMBIE_DESTROY_DOOR(1021, Type.SOUND),
    /**
     * 烟雾效果
     */
    SMOKE(2000, Type.VISUAL, BlockFace.class),
    /**
     * 方块被破坏的声音
     */
    STEP_SOUND(2001, Type.SOUND, Material.class),
    /**
     * 药水的视觉效果
     */
    POTION_BREAK(2002, Type.VISUAL, Color.class),
    /**
     * 瞬间喷溅药水破碎时的视觉效果。需要颜色数据值作为附加信息.
     * <p>
     * 原文：Visual effect of an instant splash potion breaking. Needs color data value as additional info.
     */
    INSTANT_POTION_BREAK(2007, Type.VISUAL, Color.class),
    /**
     * 末影颗粒视觉效果
     */
    ENDER_SIGNAL(2003, Type.VISUAL),
    /**
     * 火焰颗粒视觉效果
     */
    MOBSPAWNER_FLAMES(2004, Type.VISUAL),
    /**
     * 酿造台酿造的声音
     */
    BREWING_STAND_BREW(1035, Type.SOUND),
    /**
     * 紫颂果生长的声音
     */
    CHORUS_FLOWER_GROW(1033, Type.SOUND),
    /**
     * 紫颂果凋谢的声音
     */
    CHORUS_FLOWER_DEATH(1034, Type.SOUND),
    /**
     * 通过传送门的声音
     */
    PORTAL_TRAVEL(1032, Type.SOUND),
    /**
     * 安置末影之眼的声音
     */
    ENDEREYE_LAUNCH(1003, Type.SOUND),
    /**
     * 发射烟花的声音
     */
    FIREWORK_SHOOT(1004, Type.SOUND),
    /**
     * 村民种植植物的声音
     * 数据是颗粒的数量
     */
    VILLAGER_PLANT_GROW(2005, Type.VISUAL, Integer.class),
    /**
     * 末影龙攻击和呼吸的声音
     */
    DRAGON_BREATH(2006, Type.VISUAL),
    /**
     * 铁砧破坏的声音
     */
    ANVIL_BREAK(1029, Type.SOUND),
    /**
     * 使用铁砧的声音
     */
    ANVIL_USE(1030, Type.SOUND),
    /**
     * 铁砧落地声音（坠落）
     */
    ANVIL_LAND(1031, Type.SOUND),
    /**
     * 末影龙喷火的声音
     */
    ENDERDRAGON_SHOOT(1017, Type.SOUND),
    /**
     * 凋零破坏方块的声音
     */
    WITHER_BREAK_BLOCK(1022, Type.SOUND),
    /**
     * 凋零射击的声音
     */
    WITHER_SHOOT(1024, Type.SOUND),
    /**
     * 僵尸感染目标（村民）的声音
     */
    ZOMBIE_INFECT(1026, Type.SOUND),
    /**
     * 僵尸被转化成村民的声音
     */
    ZOMBIE_CONVERTED_VILLAGER(1027, Type.SOUND),
    /**
     * 蝙蝠起飞的声音
     */
    BAT_TAKEOFF(1025, Type.SOUND),
    /**
     * 末地传送门生成的声音和粒子效果
     */
    END_GATEWAY_SPAWN(3000, Type.VISUAL),
    /**
     * 末影龙咆哮的声音
     */
    ENDERDRAGON_GROWL(3001, Type.SOUND),
    /**
     * 幻翼咬人时播放的声音.
     * <p>
     * 原文：The sound played when phantom bites.
     */
    PHANTOM_BITE(1039, Type.SOUND),
    /**
     * 僵尸转化为溺尸时播放的声音.
     * <p>
     * 原文：The sound played when a zombie converts to a drowned.
     */
    ZOMBIE_CONVERTED_TO_DROWNED(1040, Type.SOUND),
    /**
     * 尸壳转化为僵尸时播放的声音.
     * <p>
     * 原文：The sound played when a husk converts to a zombie.
     */
    HUSK_CONVERTED_TO_ZOMBIE(1041, Type.SOUND),
    /**
     * 使用砂轮时播放的声音.
     * <p>
     * 原文：The sound played when a grindstone is being used.
     */
    GRINDSTONE_USE(1042, Type.SOUND),
    /**
     * 翻书页时播放的声音.
     * <p>
     * 原文：The sound played when a book page is being turned.
     */
    BOOK_PAGE_TURN(1043, Type.SOUND),
    /**
     * 使用锻造台时播放的声音.
     * <p>
     * 原文：The sound played when a smithing table is being used.
     */
    SMITHING_TABLE_USE(1044, Type.SOUND),
    /**
     * 尖锐滴水石落在表面时播放的声音.
     * <p>
     * 原文：The sound played when a pointed dripstone hits the surface.
     */
    POINTED_DRIPSTONE_LAND(1045, Type.SOUND),
    /**
     * 尖锐滴水石将岩浆滴入炼药锅时播放的声音.
     * <p>
     * 原文：The sound played when a pointed dripstone drips lava into a cauldron.
     */
    POINTED_DRIPSTONE_DRIP_LAVA_INTO_CAULDRON(1046, Type.SOUND),
    /**
     * 尖锐滴水石将水滴入炼药锅时播放的声音.
     * <p>
     * 原文：The sound played when a pointed dripstone drips water into a cauldron.
     */
    POINTED_DRIPSTONE_DRIP_WATER_INTO_CAULDRON(1047, Type.SOUND),
    /**
     * 骷髅转化为流浪者时播放的声音.
     * <p>
     * 原文：The sound played when a skeleton converts to a stray.
     */
    SKELETON_CONVERTED_TO_STRAY(1048, Type.SOUND),
    /**
     * 尝试填充堆肥桶时播放的声音/显示的粒子.
     * <p>
     * 成功时为 true，失败时为 false.
     * <p>
     * 原文：The sound played / particles shown when a composter is being attempted to fill.
     *
     * True for a successful attempt false for an unsuccessful attempt.
     */
    COMPOSTER_FILL_ATTEMPT(1500, Type.VISUAL, Boolean.class),
    /**
     * 岩浆与世界交互时播放的声音/显示的粒子.
     * <p>
     * 例如形成石头、黑曜石、玄武岩，或破坏方块（如火把）.
     * <p>
     * 原文：The sound played / particles shown when lava interacts with the world.
     *
     * For example by forming stone, obsidian, basalt or destroying blocks such as torches.
     */
    LAVA_INTERACT(1501, Type.VISUAL),
    /**
     * 红石火把烧毁时播放的声音/显示的粒子.
     * <p>
     * 原文：The sound played / particles shown when a redstone torch burns out.
     */
    REDSTONE_TORCH_BURNOUT(1502, Type.VISUAL),
    /**
     * 将末影之眼放入末地传送门框架时播放的声音/显示的粒子.
     * <p>
     * 原文：The sound played / particles shown when an eye of ender is placed into an ender portal frame.
     */
    END_PORTAL_FRAME_FILL(1503, Type.VISUAL),
    /**
     * 滴水石滴落岩浆或水时显示的粒子.
     * <p>
     * 此效果需要在该位置有滴水石，并且滴水石根部有岩浆或水.
     * <p>
     * 原文：The particles shown when a dripstone drips lava or water.
     *
     * This effect requires a dripstone at the location as well as lava or water at the root of the dripstone.
     */
    DRIPPING_DRIPSTONE(1504, Type.VISUAL),
    /**
     * 使用骨粉催熟植物时播放的声音/显示的粒子.
     * <p>
     * 数据为粒子数量.
     * <p>
     * 原文：The sound played / particles shown when bone meal is used to grow a plant.
     *
     * Data is the number of particles.
     */
    BONE_MEAL_USE(1505, Type.VISUAL, Integer.class),
    /**
     * 末影龙破坏方块时显示的粒子.
     * <p>
     * 原文：The particles shown when an ender dragon destroys blocks.
     */
    ENDER_DRAGON_DESTROY_BLOCK(2008, Type.VISUAL),
    /**
     * 海绵在超温暖世界（下界）中干燥时显示的粒子.
     * <p>
     * 原文：The particles shown when a sponge dries in an ultra warm world (nether).
     */
    SPONGE_DRY(2009, Type.VISUAL),
    /**
     * 闪电击中避雷针或氧化铜时显示的粒子.
     * <p>
     * 数据为粒子显示的轴。如果未提供数据，将在方块面显示粒子.
     * <p>
     * 原文：The particles shown when a lightning hits a lightning rod or oxidized copper.
     *
     * Data is the axis at which the particle should be shown. If no data is provided it will show the particles at the block faces.
     */
    ELECTRIC_SPARK(3002, Type.VISUAL, Axis.class),
    /**
     * 对铜方块涂蜡时播放的声音/显示的粒子.
     * <p>
     * 原文：The sound played / particles shown when wax is applied to a copper block.
     */
    COPPER_WAX_ON(3003, Type.VISUAL),
    /**
     * 从铜方块上除蜡时显示的粒子.
     * <p>
     * 原文：The particles shown when wax is removed from a copper block.
     */
    COPPER_WAX_OFF(3004, Type.VISUAL),
    /**
     * 从氧化铜方块上刮除氧化层时显示的粒子.
     * <p>
     * 原文：The particles shown when oxidation is scraped of an oxidized copper block.
     */
    OXIDISED_COPPER_SCRAPE(3005, Type.VISUAL),
    ;

    private final int id;
    private final Type type;
    private final Class<?> data;
    private static final Map<Integer, Effect> BY_ID = Maps.newHashMap();

    Effect(int id, /*@NotNull*/ Type type) {
        this(id, type, null);
    }

    Effect(int id, /*@NotNull*/ Type type, /*@Nullable*/ Class<?> data) {
        this.id = id;
        this.type = type;
        this.data = data;
    }

    /**
     * 获取这个效果的id.
     * <p>
     * 原文：Gets the ID for this effect.
     *
     * @return 效果id
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    public int getId() {
        return this.id;
    }

    /**
     * @return 效果的类型
     */
    @NotNull
    public Type getType() {
        return this.type;
    }

    /**
     * @return 代表这个效果的类，不存在为null
     */
    @Nullable
    public Class<?> getData() {
        return this.data;
    }

    /**
     * 获取给定id相关联的效果.
     * <p>
     * 原文：Gets the Effect associated with the given ID.
     *
     * @param id 效果id
     * @return 给定id相关联效果
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    @Nullable
    public static Effect getById(int id) {
        return BY_ID.get(id);
    }

    static {
        for (Effect effect : values()) {
            BY_ID.put(effect.id, effect);
        }
    }

    /**
     * 代表效果的类型
     */
    public enum Type { SOUND, VISUAL }
}
