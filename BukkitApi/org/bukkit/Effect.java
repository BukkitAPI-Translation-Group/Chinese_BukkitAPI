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
    DOOR_TOGGLE(1003, Type.SOUND),
    /**
     * 火焰熄灭的声音
     */
    EXTINGUISH(1004, Type.SOUND),
    /**
     * 播放唱片歌曲的声音
     */
    RECORD_PLAY(1010, Type.SOUND, Material.class),
    /**
     * 恶魂的尖叫声
     */
    GHAST_SHRIEK(1007, Type.SOUND),
    /**
     * 恶魂投射火球的声音
     */
    GHAST_SHOOT(1008, Type.SOUND),
    /**
     * 烈焰人投射火球的声音
     */
    BLAZE_SHOOT(1009, Type.SOUND),
    /**
     * 僵尸敲木门的声音
     */
    ZOMBIE_CHEW_WOODEN_DOOR(1012, Type.SOUND),
    /**
     * 僵尸敲铁门的声音
     */
    ZOMBIE_CHEW_IRON_DOOR(1011, Type.SOUND),
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
    MOBSPAWNER_FLAMES(2004, Type.VISUAL);

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