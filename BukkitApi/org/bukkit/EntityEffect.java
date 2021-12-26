package org.bukkit;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Dolphin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Fox;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.TippedArrow;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.ZombieVillager;
import org.jetbrains.annotations.NotNull;

/**
 * 实体能发生的效果列表。
 */
public enum EntityEffect {

    /**
     * 箭矢上的彩色粒子.
     */
    ARROW_PARTICLES(0, TippedArrow.class),
    /**
     * 兔子跳跃.
     */
    RABBIT_JUMP(1, Rabbit.class),
    /**
     * 当怪物收到伤害.
     * <p>
     * 原文：
     * When mobs get hurt.
     */
    HURT(2, LivingEntity.class),
    /**
     * 当怪物死亡.
     * <p>
     * 原文：
     * When a mob dies.
     * 
     * @deprecated 虽然该效果可能在没有生命的实体上触发其他事件,
     * 但该效果唯一支持的用途是在活体上
     */
    @Deprecated
    DEATH(3, Entity.class),
    // PAIL - SPIGOT-3641 duplicate
    // GOLEM_ATTACK(4, IronGolem.class),
    // 5 - unused
    /**
     * 驯服狼失败时的烟雾.
     * <p>
     * 原文：
     * The smoke when taming a wolf fails.
     */
    WOLF_SMOKE(6, Tameable.class),
    /**
     * 驯服狼成功时的红心.
     * <p>
     * 原文：
     * The hearts when taming a wolf succeeds.
     */
    WOLF_HEARTS(7, Wolf.class),
    /**
     * 狼在湿水后抖动身体.
     * <p>
     * 原文：
     * When a wolf shakes (after being wet).
     */
    WOLF_SHAKE(8, Wolf.class),
    // 9 - unused
    /**
     * 羊吃草方块.
     * <p>
     * 原文：
     * When a sheep eats a LONG_GRASS block.
     * 
     * @deprecated 虽然该效果可能在没有生命的实体上触发其他事件,
     * 但该效果唯一支持的用途是在活体上
     */
    @Deprecated
    SHEEP_EAT(10, Entity.class),
    /**
     * 铁傀儡给予玫瑰(译注：应为poppy，即罂粟).
     * <p>
     * 原文：
     * When an Iron Golem gives a rose.
     */
    IRON_GOLEM_ROSE(11, IronGolem.class),
    /**
     * 村民的红心.
     * <p>
     * 原文：
     * Hearts from a villager.
     */
    VILLAGER_HEART(12, Villager.class),

    /**
     * 村民生气时.
     * <p>
     * 原文：
     * When a villager is angry.
     */
    VILLAGER_ANGRY(13, Villager.class),
    /**
     * 村民高兴时的粒子效果。
     * <p>
     * 原文：
     * Happy particles from a villager.
     */
    VILLAGER_HAPPY(14, Villager.class),
    /**
     * 女巫的魔法粒子效果.
     * <p>
     * 原文：
     * Magic particles from a witch.
     */
    WITCH_MAGIC(15, Witch.class),
    /**
     * 僵尸被剧烈抖动转化为村民(译注：僵尸村民被喷溅虚弱药水并喂食金苹果转化为村民)。
     * <p>
     * 原文：
     * When a zombie transforms into a villager by shaking violently.
     */
    ZOMBIE_TRANSFORM(16, ZombieVillager.class),
    /**
     * 烟花爆炸.
     * <p>
     * 原文：
     * When a firework explodes.
     */
    FIREWORK_EXPLODE(17, Firework.class),
    /**
     * 繁殖实体时的爱心.
     */
    LOVE_HEARTS(18, Ageable.class),
    /**
     * Resets squid rotation.
     */
    SQUID_ROTATE(19, Squid.class),
    /**
     * 蠹虫进入石头, 刷怪笼刷怪.
     */
    ENTITY_POOF(20, LivingEntity.class),
    /**
     * Guardian plays the attack sound effect.
     */
    GUARDIAN_TARGET(21, Guardian.class),
    // 22-28 player internal flags
    /**
     * 盾牌阻挡攻击.
     */
    SHIELD_BLOCK(29, LivingEntity.class),
    /**
     * 护盾损坏.
     */
    SHIELD_BREAK(30, LivingEntity.class),
    // 31 - unused
    /**
     * 盔甲架被击中.
     */
    ARMOR_STAND_HIT(32, ArmorStand.class),
    /**
     * Entity hurt by thorns attack.
     */
    THORNS_HURT(33, LivingEntity.class),
    /**
     * Iron golem puts away rose.
     */
    IRON_GOLEM_SHEATH(34, IronGolem.class),
    /**
     * Totem prevents entity death.
     */
    TOTEM_RESURRECT(35, LivingEntity.class),
    /**
     * Entity hurt due to drowning damage.
     */
    HURT_DROWN(36, LivingEntity.class),
    /**
     * Entity hurt due to explosion damage.
     */
    HURT_EXPLOSION(37, LivingEntity.class),
    /**
     * Dolphin has been fed and is locating a structure.
     */
    DOLPHIN_FED(38, Dolphin.class),
    /**
     * Ravager has been stunned for 40 ticks.
     */
    RAVAGER_STUNNED(39, Ravager.class),
    /**
     * Cat taming failed.
     */
    CAT_TAME_FAIL(40, Cat.class),
    /**
     * Cat taming succeeded.
     */
    CAT_TAME_SUCCESS(41, Cat.class),
    /**
     * Villager splashes particles during a raid.
     */
    VILLAGER_SPLASH(42, Villager.class),
    /**
     * Player's bad omen effect removed to start or increase raid difficult.
     */
    PLAYER_BAD_OMEN_RAID(43, Player.class),
    /**
     * Entity hurt due to berry bush. Prickly!
     */
    HURT_BERRY_BUSH(44, LivingEntity.class),
    /**
     * Fox chews the food in its mouth
     */
    FOX_CHEW(45, Fox.class),
    /**
     * Entity teleported as a result of chorus fruit or as an enderman
     */
    TELEPORT_ENDER(46, LivingEntity.class),
    /**
     * Entity breaks item in main hand
     */
    BREAK_EQUIPMENT_MAIN_HAND(47, LivingEntity.class),
    /**
     * Entity breaks item in off hand
     */
    BREAK_EQUIPMENT_OFF_HAND(48, LivingEntity.class),
    /**
     * Entity breaks item in helmet slot
     */
    BREAK_EQUIPMENT_HELMET(49, LivingEntity.class),
    /**
     * Entity breaks item in chestplate slot
     */
    BREAK_EQUIPMENT_CHESTPLATE(50, LivingEntity.class),
    /**
     * Entity breaks item in legging slot
     */
    BREAK_EQUIPMENT_LEGGINGS(51, LivingEntity.class),
    /**
     * Entity breaks item in boot slot
     */
    BREAK_EQUIPMENT_BOOTS(52, LivingEntity.class);

    private final byte data;
    private final Class<? extends Entity> applicable;

    EntityEffect(final int data, /*@NotNull*/ Class<? extends Entity> clazz) {
        this.data = (byte) data;
        this.applicable = clazz;
    }

    /**
     * 获取实体效果的数据值.
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
     * 获取该效果能应用到的实体超类.
     * <p>
     * 原文:Gets entity superclass which this affect is applicable to.
     *
     * @return applicable class
     */
    @NotNull
    public Class<? extends Entity> getApplicable() {
        return applicable;
    }
}