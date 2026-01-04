package org.bukkit.enchantments;

import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 附魔类.
 */
public abstract class Enchantment implements Keyed, Translatable, RegistryAware {
    /**
     * 附魔：保护
     */
    public static final Enchantment PROTECTION = getEnchantment("protection");

    /**
     * 附魔：火焰保护
     */
    public static final Enchantment FIRE_PROTECTION = getEnchantment("fire_protection");

    /**
     * 附魔：摔落保护
     */
    public static final Enchantment FEATHER_FALLING = getEnchantment("feather_falling");

    /**
     * 附魔：爆炸保护
     */
    public static final Enchantment BLAST_PROTECTION = getEnchantment("blast_protection");

    /**
     * 附魔：弹射物保护
     */
    public static final Enchantment PROJECTILE_PROTECTION = getEnchantment("projectile_protection");

    /**
     * 附魔：水下呼吸
     */
    public static final Enchantment RESPIRATION = getEnchantment("respiration");

    /**
     * 附魔：水下速掘
     */
    public static final Enchantment AQUA_AFFINITY = getEnchantment("aqua_affinity");

    /**
     * 附魔：荆棘
     */
    public static final Enchantment THORNS = getEnchantment("thorns");

    /**
     * 附魔：深海探索者
     */
    public static final Enchantment DEPTH_STRIDER = getEnchantment("depth_strider");

    /**
     * 附魔：冰霜行者
     */
    public static final Enchantment FROST_WALKER = getEnchantment("frost_walker");

    /**
     * 附魔：绑定诅咒
     */
    public static final Enchantment BINDING_CURSE = getEnchantment("binding_curse");

    /**
     * 附魔：锋利
     */
    public static final Enchantment SHARPNESS = getEnchantment("sharpness");

    /**
     * 附魔：亡灵杀手
     */
    public static final Enchantment SMITE = getEnchantment("smite");

    /**
     * 附魔：节肢杀手
     */
    public static final Enchantment BANE_OF_ARTHROPODS = getEnchantment("bane_of_arthropods");

    /**
     * 附魔：击退
     */
    public static final Enchantment KNOCKBACK = getEnchantment("knockback");

    /**
     * 附魔：火焰附加
     */
    public static final Enchantment FIRE_ASPECT = getEnchantment("fire_aspect");

    /**
     * 附魔：抢夺
     */
    public static final Enchantment LOOTING = getEnchantment("looting");

    /**
     * 附魔：横扫之刃
     */
    public static final Enchantment SWEEPING_EDGE = getEnchantment("sweeping_edge");

    /**
     * 附魔：效率
     */
    public static final Enchantment EFFICIENCY = getEnchantment("efficiency");

    /**
     * 附魔：精准采集
     */
    public static final Enchantment SILK_TOUCH = getEnchantment("silk_touch");

    /**
     * 附魔：耐久
     */
    public static final Enchantment UNBREAKING = getEnchantment("unbreaking");

    /**
     * 附魔：时运
     */
    public static final Enchantment FORTUNE = getEnchantment("fortune");

    /**
     * 附魔：力量 (弓)
     */
    public static final Enchantment POWER = getEnchantment("power");

    /**
     * 附魔：冲击 (弓)
     */
    public static final Enchantment PUNCH = getEnchantment("punch");

    /**
     * 附魔：火矢 (弓)
     */
    public static final Enchantment FLAME = getEnchantment("flame");

    /**
     * 附魔：无限 (弓)
     */
    public static final Enchantment INFINITY = getEnchantment("infinity");

    /**
     * 附魔：海之眷顾 (钓鱼杆)
     */
    public static final Enchantment LUCK_OF_THE_SEA = getEnchantment("luck_of_the_sea");

    /**
     * 附魔：饵钓 (钓鱼杆)
     */
    public static final Enchantment LURE = getEnchantment("lure");

    /**
     * 附魔：忠诚 (三叉戟)
     */
    public static final Enchantment LOYALTY = getEnchantment("loyalty");

    /**
     * 附魔：穿刺 (三叉戟)
     */
    public static final Enchantment IMPALING = getEnchantment("impaling");

    /**
     * 附魔：激流 (三叉戟)
     */
    public static final Enchantment RIPTIDE = getEnchantment("riptide");

    /**
     * 附魔：引雷 (三叉戟)
     */
    public static final Enchantment CHANNELING = getEnchantment("channeling");

    /**
     * 附魔：多重射击 (弩)
     */
    public static final Enchantment MULTISHOT = getEnchantment("multishot");

    /**
     * 附魔：快速装填 (弩)
     */
    public static final Enchantment QUICK_CHARGE = getEnchantment("quick_charge");

    /**
     * 附魔：穿透 (弩)
     */
    public static final Enchantment PIERCING = getEnchantment("piercing");

    /**
     * 附魔：致密 (重锤)
     */
    public static final Enchantment DENSITY = getEnchantment("density");

    /**
     * 附魔：破甲 (重锤)
     */
    public static final Enchantment BREACH = getEnchantment("breach");

    /**
     * 附魔：风爆 (重锤)
     */
    public static final Enchantment WIND_BURST = getEnchantment("wind_burst");

    /**
     * 附魔：突进 (矛)
     */
    public static final Enchantment LUNGE = getEnchantment("lunge");

    /**
     * 附魔：经验修补
     */
    public static final Enchantment MENDING = getEnchantment("mending");

    /**
     * 附魔：消失诅咒
     */
    public static final Enchantment VANISHING_CURSE = getEnchantment("vanishing_curse");

    /**
     * 附魔：灵魂疾行
     */
    public static final Enchantment SOUL_SPEED = getEnchantment("soul_speed");

    /**
     * 附魔：迅捷潜行
     */
    public static final Enchantment SWIFT_SNEAK = getEnchantment("swift_sneak");

    @NotNull
    private static Enchantment getEnchantment(@NotNull String key) {
        return Registry.ENCHANTMENT.getOrThrow(NamespacedKey.minecraft(key));
    }

    /**
     * 得到这个附魔的名称. 
     * <p>
     * 原文：
     * Gets the unique name of this enchantment
     *
     * @return 独一无二的名称
     * @deprecated 这些附魔的命名简直糟透了, 建议使用 {@link #getKey()}.
     */
    @NotNull
    @Deprecated(since = "1.13")
    public abstract String getName();

    /**
     * 得到这个附魔所支持的最大等级.
     * <p>
     * 原文：
     * Gets the maximum level that this Enchantment may become.
     *
     * @return 这个附魔的最大等级
     */
    public abstract int getMaxLevel();

    /**
     * 得到这个附魔的最小等级. 
     * <p>
     * 原文：
     * Gets the level that this Enchantment should start at
     *
     * @return 这个附魔最小等级
     */
    public abstract int getStartLevel();

    /**
     * 得到这个附魔所支持的 物品 {@link ItemStack}. 
     * <p>
     * 原文：
     * Gets the type of {@link ItemStack} that may fit this Enchantment.
     *
     * @return 这个附魔的目标物品.
     * @deprecated 附魔分组现由标签管理, 而非分类
     */
    @NotNull
    @Deprecated(since = "1.20.5")
    public abstract EnchantmentTarget getItemTarget();

    /**
     * 检查该附魔是否为宝藏附魔.
     * <br>
     * 宝藏附魔只能通过掠夺、交易或垂钓获得.
     * <p>
     * 原文:Checks if this enchantment is a treasure enchantment.
     * <br>
     * Treasure enchantments can only be received via looting, trading, or
     * fishing.
     *
     * @return 是否为宝藏附魔
     * @deprecated 附魔类型现由标签管理
     */
    @Deprecated(since = "1.21")
    public abstract boolean isTreasure();

    /**
     * 检查该附魔是否为诅咒附魔.
     * <br>
     * 诅咒附魔的获取途径与宝藏附魔一致.
     * <p>
     * 原文:Checks if this enchantment is a cursed enchantment
     * <br>
     * Cursed enchantments are found the same way treasure enchantments are
     *
     * @return 是否为诅咒附魔
     * @deprecated 诅咒附魔不再是特殊的.
     * 当且仅当附魔为{@link Enchantment#BINDING_CURSE} 或 {@link Enchantment#VANISHING_CURSE} 时才会返回true
     */
    @Deprecated(since = "1.13")
    public abstract boolean isCursed();

    /**
     * 检查这个附魔是否与另外的附魔冲突. 
     * <p>
     * 原文：
     * Check if this enchantment conflicts with another enchantment.
     *
     * @param other 另外一个附魔
     * @return 如果这两个附魔是冲突的则返回true
     */
    public abstract boolean conflictsWith(@NotNull Enchantment other);

    /**
     * 检查该附魔支不支持某物品. 
     * <p>
     * 这并不检查任何物品上与它冲突的附魔。 
     * <p>
     * 原文：Checks if this Enchantment may be applied to the given {@link
     * ItemStack}.
     * <p>
     * This does not check if it conflicts with any enchantments already
     * applied to the item.
     *
     * @param item 物品
     * @return 如果该附魔适用该物品,则返回true。
     */
    public abstract boolean canEnchantItem(@NotNull ItemStack item);

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    public abstract NamespacedKey getKey();

    /**
     * 通过指定键值获取附魔.
     * <p>
     * 原文：
     * Gets the Enchantment at the specified key
     *
     * @param key 附魔键值key
     * @return 返回该key所对应的附魔,要是没有所对应的的附魔则返回null.
     * @deprecated 仅为保障作向后兼容性, 请使用 {@link Registry#get(NamespacedKey)} instead
     */
    @Contract("null -> null")
    @Nullable
    @Deprecated(since = "1.20.3")
    public static Enchantment getByKey(@Nullable NamespacedKey key) {
        if (key == null) {
            return null;
        }
        return Registry.ENCHANTMENT.get(key);
    }

    /**
     * 以指定名称获取附魔.
     * <p>
     * 原文：
     * Gets the Enchantment at the specified name
     *
     * @param name 名称
     * @return 返回该名称所对应的附魔,要是没有所对应的的附魔则返回null.
     * @deprecated 这些附魔的命名简直糟透了，建议使用 {@link #getByKey(org.bukkit.NamespacedKey)}.
     */
    @Deprecated(since = "1.13")
    @Contract("null -> null")
    @Nullable
    public static Enchantment getByName(@Nullable String name) {
        if (name == null) {
            return null;
        }

        return getByKey(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
    }

    /**
     * 得到所有已经注册了的附魔({@link Enchantment}).
     * <p>
     * 原文：
     * Gets an array of all the registered {@link Enchantment}s
     *
     * @return 一个包含所有已注册附魔的数组
     * @deprecated 请使用 {@link Registry#iterator() Registry.ENCHANTMENT.iterator()}
     */
    @NotNull
    @Deprecated(since = "1.20.3")
    public static Enchantment[] values() {
        return Lists.newArrayList(Registry.ENCHANTMENT).toArray(new Enchantment[0]);
    }
}