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
     * 开关门声
     */
    DOOR_TOGGLE(1006, Type.SOUND),
    /**
     * Sound of a door opening.
     */
    IRON_DOOR_TOGGLE(1005, Type.SOUND),
    /**
     * Sound of a trapdoor opening.
     */
    TRAPDOOR_TOGGLE(1007, Type.SOUND),
    /**
     * Sound of a door opening.
     */
    IRON_TRAPDOOR_TOGGLE(1037, Type.SOUND),
    /**
     * Sound of a door opening.
     */
    FENCE_GATE_TOGGLE(1008, Type.SOUND),
    /**
     * Sound of a door closing.
     */
    DOOR_CLOSE(1012, Type.SOUND),
    /**
     * Sound of a door closing.
     */
    IRON_DOOR_CLOSE(1011, Type.SOUND),
    /**
     * Sound of a trapdoor closing.
     */
    TRAPDOOR_CLOSE(1013, Type.SOUND),
    /**
     * Sound of a door closing.
     */
    IRON_TRAPDOOR_CLOSE(1036, Type.SOUND),
    /**
     * Sound of a door closing.
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
     * The sound played by brewing stands when brewing
      */
    BREWING_STAND_BREW(1035, Type.SOUND),
    /**
     * The sound played when a chorus flower grows
     */
    CHORUS_FLOWER_GROW(1033, Type.SOUND),
    /**
     * The sound played when a chorus flower dies
     */
    CHORUS_FLOWER_DEATH(1034, Type.SOUND),
    /**
     * The sound played when traveling through a portal
     */
    PORTAL_TRAVEL(1032, Type.SOUND),
    /**
     * The sound played when launching an endereye
     */
    ENDEREYE_LAUNCH(1003, Type.SOUND),
    /**
     * The sound played when launching a firework
     */
    FIREWORK_SHOOT(1004, Type.SOUND),
    /**
     * Particles displayed when a villager grows a plant, data
     * is the number of particles
     */
    VILLAGER_PLANT_GROW(2005, Type.VISUAL, Integer.class),
    /**
     * The sound/particles used by the enderdragon's breath
     * attack.
     */
    DRAGON_BREATH(2006, Type.VISUAL),
    /**
     * The sound played when an anvil breaks
     */
    ANVIL_BREAK(1029, Type.SOUND),
    /**
     * The sound played when an anvil is used
     */
    ANVIL_USE(1030, Type.SOUND),
    /**
     * The sound played when an anvil lands after
     * falling
     */
    ANVIL_LAND(1031, Type.SOUND),
    /**
     * Sound of an enderdragon firing
     */
    ENDERDRAGON_SHOOT(1017, Type.SOUND),
    /**
     * The sound played when a wither breaks a block
     */
    WITHER_BREAK_BLOCK(1022, Type.SOUND),
    /**
     * Sound of a wither shooting
     */
    WITHER_SHOOT(1024, Type.SOUND),
    /**
     * The sound played when a zombie infects a target
     */
    ZOMBIE_INFECT(1026, Type.SOUND),
    /**
     * The sound played when a villager is converted by
     * a zombie
     */
    ZOMBIE_CONVERTED_VILLAGER(1027, Type.SOUND),
    /**
     * Sound played by a bat taking off
     */
    BAT_TAKEOFF(1025, Type.SOUND),
    /**
     * The sound/particles caused by a end gateway spawning
     */
    END_GATEWAY_SPAWN(3000, Type.VISUAL),
    /**
     * The sound of an enderdragon growling
     */
    ENDERDRAGON_GROWL(3001, Type.SOUND),
    ;

    private final int id;
    private final Type type;
    private final Class<?> data;
    private static final Map<Integer, Effect> BY_ID = Maps.newHashMap();

    Effect(int id, Type type) {
        this(id,type,null);
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