package org.bukkit.tag;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.damage.DamageType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * 原版 {@link DamageType} {@link Tag 标签}。
 */
@ApiStatus.Experimental
public final class DamageTypeTags {

    /**
     * 表示会损坏头盔的伤害类型的原版标签。
     */
    public static final Tag<DamageType> DAMAGES_HELMET = getTag("damages_helmet");
    /**
     * 表示绕过护甲的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BYPASSES_ARMOR = getTag("bypasses_armor");
    /**
     * 表示绕过盾牌的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BYPASSES_SHIELD = getTag("bypasses_shield");
    /**
     * 表示绕过无敌状态的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BYPASSES_INVULNERABILITY = getTag("bypasses_invulnerability");
    /**
     * 表示绕过冷却时间的伤害类型的原版标签。
     * <br>
     * <b>注意：</b>除非数据包为此标签添加值，否则此标签可能为 null，因为原版没有为此标签定义任何值。
     */
    @Nullable
    public static final Tag<DamageType> BYPASSES_COOLDOWN = getTag("bypasses_cooldown");
    /**
     * 表示绕过效果的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BYPASSES_EFFECTS = getTag("bypasses_effects");
    /**
     * 表示绕过抗性的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BYPASSES_RESISTANCE = getTag("bypasses_resistance");
    /**
     * 表示绕过附魔的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BYPASSES_ENCHANTMENTS = getTag("bypasses_enchantments");
    /**
     * 表示所有火焰伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_FIRE = getTag("is_fire");
    /**
     * 表示源自投射物的伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_PROJECTILE = getTag("is_projectile");
    /**
     * 表示女巫对其有抗性的伤害类型的原版标签。
     */
    public static final Tag<DamageType> WITCH_RESISTANT_TO = getTag("witch_resistant_to");
    /**
     * 表示所有爆炸伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_EXPLOSION = getTag("is_explosion");
    /**
     * 表示所有坠落伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_FALL = getTag("is_fall");
    /**
     * 表示所有溺水伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_DROWNING = getTag("is_drowning");
    /**
     * 表示所有冰冻伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_FREEZING = getTag("is_freezing");
    /**
     * 表示所有闪电伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_LIGHTNING = getTag("is_lightning");
    /**
     * 表示不会使实体愤怒的伤害类型的原版标签。
     */
    public static final Tag<DamageType> NO_ANGER = getTag("no_anger");
    /**
     * 表示不会造成冲击的伤害类型的原版标签。
     */
    public static final Tag<DamageType> NO_IMPACT = getTag("no_impact");
    /**
     * 表示造成最大坠落伤害的伤害类型的原版标签。
     */
    public static final Tag<DamageType> ALWAYS_MOST_SIGNIFICANT_FALL = getTag("always_most_significant_fall");
    /**
     * 表示凋灵对其免疫的伤害类型的原版标签。
     */
    public static final Tag<DamageType> WITHER_IMMUNE_TO = getTag("wither_immune_to");
    /**
     * 表示点燃盔甲架的伤害类型的原版标签。
     */
    public static final Tag<DamageType> IGNITES_ARMOR_STANDS = getTag("ignites_armor_stands");
    /**
     * 表示烧毁盔甲架的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BURNS_ARMOR_STANDS = getTag("burns_armor_stands");
    /**
     * 表示避开守卫者荆棘伤害的伤害类型的原版标签。
     */
    public static final Tag<DamageType> AVOIDS_GUARDIAN_THORNS = getTag("avoids_guardian_thorns");
    /**
     * 表示总是触发蠹虫的伤害类型的原版标签。
     */
    public static final Tag<DamageType> ALWAYS_TRIGGERS_SILVERFISH = getTag("always_triggers_silverfish");
    /**
     * 表示总是伤害末影龙的伤害类型的原版标签。
     */
    public static final Tag<DamageType> ALWAYS_HURTS_ENDER_DRAGONS = getTag("always_hurts_ender_dragons");
    /**
     * 表示不会造成击退的伤害类型的原版标签。
     */
    public static final Tag<DamageType> NO_KNOCKBACK = getTag("no_knockback");
    /**
     * 表示总是摧毁盔甲架的伤害类型的原版标签。
     */
    public static final Tag<DamageType> ALWAYS_KILLS_ARMOR_STANDS = getTag("always_kills_armor_stands");
    /**
     * 表示可以破坏盔甲架的伤害类型的原版标签。
     */
    public static final Tag<DamageType> CAN_BREAK_ARMOR_STAND = getTag("can_break_armor_stand");
    /**
     * 表示绕过狼铠的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BYPASSES_WOLF_ARMOR = getTag("bypasses_wolf_armor");
    /**
     * 表示来自玩家攻击的伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_PLAYER_ATTACK = getTag("is_player_attack");
    /**
     * 表示源自高温方块的伤害类型的原版标签。
     */
    public static final Tag<DamageType> BURN_FROM_STEPPING = getTag("burn_from_stepping");
    /**
     * 表示使实体恐慌的伤害类型的原版标签。
     */
    public static final Tag<DamageType> PANIC_CAUSES = getTag("panic_causes");
    /**
     * 表示使实体恐慌的环境伤害类型的原版标签。
     */
    public static final Tag<DamageType> PANIC_ENVIRONMENTAL_CAUSES = getTag("panic_environmental_causes");
    /**
     * 表示源自锤击的伤害类型的原版标签。
     */
    public static final Tag<DamageType> IS_MACE_SMASH = getTag("mace_smash");
    /**
     * 仅供内部使用。
     */
    @ApiStatus.Internal
    public static final String REGISTRY_DAMAGE_TYPES = "damage_types";

    @Nullable
    private static Tag<DamageType> getTag(String key) {
        return Bukkit.getTag(REGISTRY_DAMAGE_TYPES, NamespacedKey.minecraft(key), DamageType.class);
    }

    private DamageTypeTags() {
    }
}
