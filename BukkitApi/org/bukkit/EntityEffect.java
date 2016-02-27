package org.bukkit;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 实体能发生的效果列表。
 */
public enum EntityEffect {

    /**
     * 当怪物收到伤害。
     * <p>
     * 原文：
     * When mobs get hurt.
     */
    HURT(2),

    /**
     * 当怪物死亡。
     * <p>
     * 原文：
     * When a mob dies.
     */
    DEATH(3),

    /**
     * 驯服狼失败时的烟雾。
     * <p>
     * 如果这个实体不是狼并且未安装相关的MOD则会被忽略。
     * <p>
     * 原文：
     * The smoke when taming a wolf fails.
     * <p>
     * Without client-mods this will be ignored if the entity is not a wolf.
     */
    WOLF_SMOKE(6),

    /**
     * 驯服狼成功时的红心。
     * <p>
     * 如果这个实体不是狼并且未安装相关的MOD则会被忽略。
     * <p>
     * 原文：
     * The hearts when taming a wolf succeeds.
     * <p>
     * Without client-mods this will be ignored if the entity is not a wolf.
     */
    WOLF_HEARTS(7),

    /**
     * 狼在湿水后抖动身体。
     * <p>
     * 如果这个实体不是狼并且未安装相关的MOD则会被忽略。
     * <p>
     * 原文：
     * When a wolf shakes (after being wet).
     * <p>
     * Without client-mods this will be ignored if the entity is not a wolf.
     */
    WOLF_SHAKE(8),

    /**
     * 羊吃草方块。
     * <p>
     * 原文：
     * When a sheep eats a LONG_GRASS block.
     */
    SHEEP_EAT(10),

    /**
     * 铁傀儡给予玫瑰(译注：应为poppy，即罂粟)。
     * <p>
     * 实体不是铁傀儡则无此效果。
     * <p>
     * 原文：
     * When an Iron Golem gives a rose.
     * <p>
     * This will not play an effect if the entity is not an iron golem.
     */
    IRON_GOLEM_ROSE(11),

    /**
     * 村民的红心。
     * <p>
     * 若不是村民则无此效果。
     * <p>
     * 原文：
     * Hearts from a villager.
     * <p>
     * This will not play an effect if the entity is not a villager.
     */
    VILLAGER_HEART(12),

    /**
     * 村民生气时。
     * <p>
     * 若不是村民则无此效果。
     * <p>
     * 原文：
     * When a villager is angry.
     * <p>
     * This will not play an effect if the entity is not a villager.
     */
    VILLAGER_ANGRY(13),

    /**
     * 村民高兴时的粒子效果。
     * <p>
     * 若不是村民则无此效果。
     * <p>
     * 原文：
     * Happy particles from a villager.
     * <p>
     * This will not play an effect if the entity is not a villager.
     */
    VILLAGER_HAPPY(14),

    /**
     * 女巫的魔法粒子效果。
     * <p>
     * 若不是女巫则无此效果。
     * <p>
     * 原文：
     * Magic particles from a witch.
     * <p>
     * This will not play an effect if the entity is not a witch.
     */
    WITCH_MAGIC(15),

    /**
     * 僵尸被剧烈抖动转化为村民(译注：僵尸村民被喷溅虚弱药水并喂食金苹果转化为村民)。
     * <p>
     * 若不是僵尸则无此效果。
     * <p>
     * 原文：
     * When a zombie transforms into a villager by shaking violently.
     * <p>
     * This will not play an effect if the entity is not a zombie.
     */
    ZOMBIE_TRANSFORM(16),

    /**
     * 烟花爆炸时。
     * <p>
     * 若不是烟花则无此效果。
     * <p>
     * 原文：
     * When a firework explodes.
     * <p>
     * This will not play an effect if the entity is not a firework.
     */
    FIREWORK_EXPLODE(17);

    private final byte data;
    private final static Map<Byte, EntityEffect> BY_DATA = Maps.newHashMap();

    EntityEffect(final int data) {
        this.data = (byte) data;
    }

    /**
     * 获取实体效果的数据值。
     * <p>
     * 原文：
     * Gets the data value of this EntityEffect
     *
     * @return 实体效果的数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * 获取指定数据值的实体效果。
     * <p>
     * 原文：
     * Gets the EntityEffect with the given data value
     *
     * @param data 指定的数据值
     * @return 指定数据值表示的{@link EntityEffect}(实体效果)，若不存在则返回null
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static EntityEffect getByData(final byte data) {
        return BY_DATA.get(data);
    }


    static {
        for (EntityEffect entityEffect : values()) {
            BY_DATA.put(entityEffect.data, entityEffect);
        }
    }
}