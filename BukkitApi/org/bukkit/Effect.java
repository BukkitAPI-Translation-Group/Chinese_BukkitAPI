package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

import org.bukkit.block.BlockFace;
import org.bukkit.potion.Potion;

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
     */
    DOOR_TOGGLE(1006, Type.SOUND),
    /**
     * 开门声（铁门）
     */
    IRON_DOOR_TOGGLE(1005, Type.SOUND),
    /**
     * 开门声（木活板门）
     */
    TRAPDOOR_TOGGLE(1007, Type.SOUND),
    /**
     * 开门声（铁活板门）
     */
    IRON_TRAPDOOR_TOGGLE(1037, Type.SOUND),
    /**
     * 开门声（栅栏门）
     */
    FENCE_GATE_TOGGLE(1008, Type.SOUND),
    /**
     * 关门声（木门）
     */
    DOOR_CLOSE(1012, Type.SOUND),
    /**
     * 关门声（铁门）
     */
    IRON_DOOR_CLOSE(1011, Type.SOUND),
    /**
     * 关门声（木活板门）
     */
    TRAPDOOR_CLOSE(1013, Type.SOUND),
    /**
     * 关门声（铁活板门）
     */
    IRON_TRAPDOOR_CLOSE(1036, Type.SOUND),
    /**
     * 关门声（栅栏门）
     */
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
    POTION_BREAK(2002, Type.VISUAL, Potion.class),
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
    ;

    private final int id;
    private final Type type;
    private final Class<?> data;
    private static final Map<Integer, Effect> BY_ID = Maps.newHashMap();

    Effect(int id, Type type) {
        this(id, type, null);
    }

    Effect(int id, Type type, Class<?> data) {
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
    @Deprecated
    public int getId() {
        return this.id;
    }

    /**
     * @return 效果的类型
     */
    public Type getType() {
        return this.type;
    }

    /**
     * @return 代表这个效果的类，不存在为null
     */
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
    @Deprecated
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
    public enum Type {SOUND, VISUAL}
}
