package org.bukkit;

import com.google.common.base.Preconditions;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Dolphin;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EvokerFangs;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Fox;
import org.bukkit.entity.Goat;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Sniffer;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.TippedArrow;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Warden;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zoglin;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.entity.minecart.SpawnerMinecart;
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
     * 将刷怪笼矿车的延迟重置为 200. 不影响实际刷怪延迟, 仅影响刷怪笼中实体旋转的速度.
     * <p>
     * 原文：
     * Resets a spawner minecart's delay to 200. Does not effect actual spawning
     * delay, only the speed at which the entity in the spawner spins
     */
    RESET_SPAWNER_MINECART_DELAY(1, SpawnerMinecart.class),
    /**
     * 当怪物收到伤害.
     * <p>
     * 原文：
     * When mobs get hurt.
     *
     * @deprecated 请使用 {@link LivingEntity#playHurtAnimation(float)}
     */
    @Deprecated(since = "1.20.1")
    HURT(2, LivingEntity.class),
    /**
     * 当怪物死亡.
     * <p>
     * 原文：
     * When a mob dies.
     * 
     * @deprecated 已分为单独的效果
     * @see #EGG_BREAK
     * @see #SNOWBALL_BREAK
     * @see #ENTITY_DEATH
     */
    @Deprecated(since = "1.12.2")
    DEATH(3, Entity.class),
    /**
     * 生成鸡蛋破碎粒子.
     * <p>
     * 原文：
     * Spawns the egg breaking particles
     */
    EGG_BREAK(3, Egg.class),
    /**
     * 生成雪球破碎粒子.
     * <p>
     * 原文：
     * Spawns the snowball breaking particles
     */
    SNOWBALL_BREAK(3, Snowball.class),
    /**
     * 播放实体死亡音效和动画.
     * <p>
     * <b>这会导致客户端故障!</b>
     * <p>
     * 原文：
     * Plays the entity death sound and animation
     * <p>
     * <b>This will cause client-glitches!</b>
     */
    ENTITY_DEATH(3, LivingEntity.class),
    /**
     * 播放尖牙攻击动画.
     * <p>
     * 原文：
     * Plays the fang attack animation
     */
    FANG_ATTACK(4, EvokerFangs.class),
    /**
     * 播放疣猪兽攻击动画.
     * <p>
     * 原文：
     * Plays the hoglin attack animation
     */
    HOGLIN_ATTACK(4, Hoglin.class),
    /**
     * 播放铁傀儡攻击动画.
     * <p>
     * 原文：
     * Plays the iron golem attack animation
     */
    IRON_GOLEN_ATTACK(4, IronGolem.class),
    /**
     * 播放劫掠兽攻击动画.
     * <p>
     * 原文：
     * Plays the ravager attack animation
     */
    RAVAGER_ATTACK(4, Ravager.class),
    /**
     * 播放监守者攻击动画.
     * <p>
     * 原文：
     * Plays the warden attack animation
     */
    WARDEN_ATTACK(4, Warden.class),
    /**
     * 播放僵尸疣猪兽攻击动画.
     * <p>
     * 原文：
     * Plays the zoglin attack animation
     */
    ZOGLIN_ATTACK(4, Zoglin.class),
    // GOLEM_ATTACK(4, IronGolem.class),
    // 5 - unused
    /**
     * 驯服实体失败时的烟雾.
     * <p>
     * 原文：
     * The smoke when taming a entity fails.
     */
    WOLF_SMOKE(6, Tameable.class),
    /**
     * 驯服实体成功时的红心.
     * <p>
     * 原文：
     * The hearts when taming a woentitylf succeeds.
     */
    WOLF_HEARTS(7, Tameable.class),
    /**
     * 狼在湿水后抖动身体.
     * <p>
     * 原文：
     * When a wolf shakes (after being wet).
     *
     * @see EntityEffect#WOLF_SHAKE_STOP
     */
    WOLF_SHAKE(8, Wolf.class),
    // 9 - unused
    /**
     * 羊吃草方块.
     * <p>
     * 原文：
     * When a sheep eats a LONG_GRASS block.
     * 
     * @deprecated 已分为单独的效果
     * @see #SHEEP_EAT_GRASS
     * @see #TNT_MINECART_IGNITE
     */
    @Deprecated(since = "1.12.2")
    SHEEP_EAT(10, Entity.class),
    /**
     * 播放绵羊吃草动画.
     * <p>
     * 原文：
     * Plays the sheep eating grass animation
     */
    SHEEP_EAT_GRASS(10, Sheep.class),
    /**
     * 使TNT矿车点燃, 不播放点燃音效.
     * <p>
     * <b>这会导致客户端故障!</b>
     * <p>
     * 原文：
     * Causes the TNT minecart to ignite, does not play the ignition sound
     * <p>
     * <b>This will cause client-glitches!</b>
     */
    TNT_MINECART_IGNITE(10, ExplosiveMinecart.class),
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
     * 重置鱿鱼旋转.
     * <p>
     * 原文：
     * Resets squid rotation.
     */
    SQUID_ROTATE(19, Squid.class),
    /**
     * 蠹虫进入石头, 刷怪笼刷怪.
     */
    ENTITY_POOF(20, LivingEntity.class),
    /**
     * 守卫者播放攻击音效.
     * <p>
     * 原文：
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
     * 实体受到荆棘攻击伤害.
     * <p>
     * 原文：
     * Entity hurt by thorns attack.
     */
    THORNS_HURT(33, LivingEntity.class),
    /**
     * 铁傀儡收起玫瑰.
     * <p>
     * 原文：
     * Iron golem puts away rose.
     */
    IRON_GOLEM_SHEATH(34, IronGolem.class),
    /**
     * 图腾阻止实体死亡.
     * <p>
     * 原文：
     * Totem prevents entity death.
     */
    TOTEM_RESURRECT(35, LivingEntity.class),
    /**
     * 实体因溺水伤害而受伤.
     * <p>
     * 原文：
     * Entity hurt due to drowning damage.
     */
    HURT_DROWN(36, LivingEntity.class),
    /**
     * 实体因爆炸伤害而受伤.
     * <p>
     * 原文：
     * Entity hurt due to explosion damage.
     */
    HURT_EXPLOSION(37, LivingEntity.class),
    /**
     * 海豚被喂食后正在定位结构.
     * <p>
     * 原文：
     * Dolphin has been fed and is locating a structure.
     */
    DOLPHIN_FED(38, Dolphin.class),
    /**
     * 劫掠兽被击晕 40 tick.
     * <p>
     * 原文：
     * Ravager has been stunned for 40 ticks.
     */
    RAVAGER_STUNNED(39, Ravager.class),
    /**
     * 猫驯服失败.
     * <p>
     * 原文：
     * Cat taming failed.
     */
    CAT_TAME_FAIL(40, Cat.class),
    /**
     * 猫驯服成功.
     * <p>
     * 原文：
     * Cat taming succeeded.
     */
    CAT_TAME_SUCCESS(41, Cat.class),
    /**
     * 村民在袭击中溅出粒子.
     * <p>
     * 原文：
     * Villager splashes particles during a raid.
     */
    VILLAGER_SPLASH(42, Villager.class),
    /**
     * 玩家的不祥之兆效果被移除, 以开始或增加袭击难度.
     * <p>
     * 原文：
     * Player's bad omen effect removed to start or increase raid difficult.
     */
    PLAYER_BAD_OMEN_RAID(43, Player.class),
    /**
     * 实体因浆果丛受伤. 好痛!
     * <p>
     * 原文：
     * Entity hurt due to berry bush. Prickly!
     */
    HURT_BERRY_BUSH(44, LivingEntity.class),
    /**
     * 狐狸咀嚼嘴里的食物.
     * <p>
     * 原文：
     * Fox chews the food in its mouth
     */
    FOX_CHEW(45, Fox.class),
    /**
     * 实体因紫颂果或作为末影人而传送.
     * <p>
     * 原文：
     * Entity teleported as a result of chorus fruit or as an enderman
     */
    TELEPORT_ENDER(46, LivingEntity.class),
    /**
     * 实体损坏主手物品.
     * <p>
     * 原文：
     * Entity breaks item in main hand
     */
    BREAK_EQUIPMENT_MAIN_HAND(47, LivingEntity.class),
    /**
     * 实体损坏副手物品.
     * <p>
     * 原文：
     * Entity breaks item in off hand
     */
    BREAK_EQUIPMENT_OFF_HAND(48, LivingEntity.class),
    /**
     * 实体损坏头盔槽物品.
     * <p>
     * 原文：
     * Entity breaks item in helmet slot
     */
    BREAK_EQUIPMENT_HELMET(49, LivingEntity.class),
    /**
     * 实体损坏胸甲槽物品.
     * <p>
     * 原文：
     * Entity breaks item in chestplate slot
     */
    BREAK_EQUIPMENT_CHESTPLATE(50, LivingEntity.class),
    /**
     * 实体损坏护腿槽物品.
     * <p>
     * 原文：
     * Entity breaks item in legging slot
     */
    BREAK_EQUIPMENT_LEGGINGS(51, LivingEntity.class),
    /**
     * 实体损坏靴子槽物品.
     * <p>
     * 原文：
     * Entity breaks item in boot slot
     */
    BREAK_EQUIPMENT_BOOTS(52, LivingEntity.class),
    /**
     * 在实体脚部生成蜂蜜块滑动粒子.
     * <p>
     * 原文：
     * Spawns honey block slide particles at the entity's feet
     */
    HONEY_BLOCK_SLIDE_PARTICLES(53, Entity.class),
    /**
     * 在实体脚部生成蜂蜜块坠落粒子.
     * <p>
     * 原文：
     * Spawns honey block fall particles at the entity's feet
     */
    HONEY_BLOCK_FALL_PARTICLES(54, LivingEntity.class),
    /**
     * 实体交换主手和副手物品.
     * <p>
     * 原文：
     * Entity swaps the items in their hand and offhand
     */
    SWAP_HAND_ITEMS(55, LivingEntity.class),
    /**
     * 停止正在抖动的狼.
     *
     * @see EntityEffect#WOLF_SHAKE
     * <p>
     * 原文：
     * Stops a wolf that is currently shaking
     */
    WOLF_SHAKE_STOP(56, Wolf.class),
    // 57 - unused
    /**
     * 山羊低头准备冲撞.
     *
     * @see #GOAT_RAISE_HEAD
     * <p>
     * 原文：
     * Goat lowers its head for ramming
     */
    GOAT_LOWER_HEAD(58, Goat.class),
    /**
     * 山羊抬头.
     *
     * @see #GOAT_LOWER_HEAD
     * <p>
     * 原文：
     * Goat raises its head
     */
    GOAT_RAISE_HEAD(59, Goat.class),
    /**
     * 生成死亡烟雾粒子.
     * <p>
     * 原文：
     * Spawns death smoke particles
     */
    SPAWN_DEATH_SMOKE(60, LivingEntity.class),
    /**
     * 监守者抖动触须.
     * <p>
     * 原文：
     * Warden shakes its tendrils
     */
    WARDEN_TENDRIL_SHAKE(61, Warden.class),
    /**
     * 监守者执行音波攻击动画.
     * <p>
     * 不播放音效或发射光束.
     * <p>
     * 原文：
     * Warden performs sonic attack animation <br>
     * Does not play the sound or fire the beam
     */
    WARDEN_SONIC_ATTACK(62, Warden.class),
    /**
     * 播放嗅探兽挖掘音效.
     * <p>
     * 嗅探兽必须有目标且处于 {@link Sniffer.State#SEARCHING} 或
     * {@link Sniffer.State#DIGGING} 状态.
     * <p>
     * 原文：
     * Plays sniffer digging sound <br>
     * Sniffer must have a target and be in {@link Sniffer.State#SEARCHING} or
     * {@link Sniffer.State#DIGGING}
     */
    SNIFFER_DIG(63, Sniffer.class);

    private final byte data;
    private final Class<? extends Entity> applicable;

    EntityEffect(final int data, /*@NotNull*/ Class<? extends Entity> clazz) {
        this.data = (byte) data;
        this.applicable = clazz;
    }

    /**
     * 获取实体效果的数据值, 可能不是唯一的.
     * <p>
     * 原文：
     * Gets the data value of this EntityEffect, may not be unique.
     *
     * @return 实体效果的数据值
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
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

    /**
     * 检查此效果是否适用于给定实体.
     * <p>
     * 原文：
     * Checks if this effect is applicable to the given entity.
     *
     * @param entity 要检查的实体
     * @return 如果适用则为 true
     */
    public boolean isApplicableTo(@NotNull Entity entity) {
        Preconditions.checkArgument(entity != null, "Entity cannot be null");

        return isApplicableTo(entity.getClass());
    }

    /**
     * 检查此效果是否适用于给定的实体类.
     * <p>
     * 原文：
     * Checks if this effect is applicable to the given entity class.
     *
     * @param clazz 要检查的实体类
     * @return 如果适用则为 true
     */
    public boolean isApplicableTo(@NotNull Class<? extends Entity> clazz) {
        Preconditions.checkArgument(clazz != null, "Class cannot be null");

        return applicable.isAssignableFrom(clazz);
    }
}