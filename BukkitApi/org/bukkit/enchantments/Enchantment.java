package org.bukkit.enchantments;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

/**
 * 附魔类.
 */
public abstract class Enchantment implements Keyed {
    /**
     * 附魔：保护
     * <p>
     * 原文：
     * Provides protection against environmental damage
     */
    public static final Enchantment PROTECTION_ENVIRONMENTAL = new EnchantmentWrapper("protection");

    /**
     * 附魔：火焰保护
     * <p>
     * 原文：
     * Provides protection against fire damage
     */
    public static final Enchantment PROTECTION_FIRE = new EnchantmentWrapper("fire_protection");

    /**
     * 附魔：摔落保护
     * <p>
     * 原文：
     * Provides protection against fall damage
     */
    public static final Enchantment PROTECTION_FALL = new EnchantmentWrapper("feather_falling");

    /**
     * 附魔：爆炸保护
     * <p>
     * 原文：
     * Provides protection against explosive damage
     */
    public static final Enchantment PROTECTION_EXPLOSIONS = new EnchantmentWrapper("blast_protection");

    /**
     * 附魔：抛射物保护
     * <p>
     * 原文：
     * Provides protection against projectile damage
     */
    public static final Enchantment PROTECTION_PROJECTILE = new EnchantmentWrapper("projectile_protection");

    /**
     * 附魔：水肺
     * <p>
     * 原文：
     * Decreases the rate of air loss whilst underwater
     */
    public static final Enchantment OXYGEN = new EnchantmentWrapper("respiration");

    /**
     * 附魔：水下速掘
     * <p>
     * 原文：
     * Increases the speed at which a player may mine underwater
     */
    public static final Enchantment WATER_WORKER = new EnchantmentWrapper("aqua_affinity");

    /**
     * 附魔：荆棘
     * <p>
     * 原文：
     * Damages the attacker
     */
    public static final Enchantment THORNS = new EnchantmentWrapper("thorns");

    /**
     * 附魔：海底漫步
     * <p>
     * 原文：
     * Increases walking speed while in water
     */
    public static final Enchantment DEPTH_STRIDER = new EnchantmentWrapper("depth_strider");

    /**
     * 附魔：冰霜行者
     * <p>
     * 原文:Freezes any still water adjacent to ice / frost which player is walking on
     */
    public static final Enchantment FROST_WALKER = new EnchantmentWrapper("frost_walker");

    /**
     * Item cannot be removed
     */
    public static final Enchantment BINDING_CURSE = new EnchantmentWrapper("binding_curse");

    /**
     * 附魔：锋利
     * <p>
     * 原文：
     * Increases damage against all targets
     */
    public static final Enchantment DAMAGE_ALL = new EnchantmentWrapper("sharpness");

    /**
     * 附魔：亡灵杀手
     * <p>
     * 原文：
     * Increases damage against undead targets
     */
    public static final Enchantment DAMAGE_UNDEAD = new EnchantmentWrapper("smite");

    /**
     * 附魔：节肢杀手
     * <p>
     * 原文:
     * Increases damage against arthropod targets
     */
    public static final Enchantment DAMAGE_ARTHROPODS = new EnchantmentWrapper("bane_of_arthropods");

    /**
     * 附魔：击退
     * <p>
     * 原文：
     * All damage to other targets will knock them back when hit
     */
    public static final Enchantment KNOCKBACK = new EnchantmentWrapper("knockback");

    /**
     * 附魔：火焰附加
     * <p>
     * 原文：
     * When attacking a target, has a chance to set them on fire
     */
    public static final Enchantment FIRE_ASPECT = new EnchantmentWrapper("fire_aspect");

    /**
     * 附魔：抢夺
     * <p>
     * 原文：
     * Provides a chance of gaining extra loot when killing monsters
     */
    public static final Enchantment LOOT_BONUS_MOBS = new EnchantmentWrapper("looting");

    /**
     * Increases damage against targets when using a sweep attack
     */
    public static final Enchantment SWEEPING_EDGE = new EnchantmentWrapper("sweeping");

    /**
     * 附魔：效率
     * <p>
     * 原文：
     * Increases the rate at which you mine/dig
     */
    public static final Enchantment DIG_SPEED = new EnchantmentWrapper("efficiency");

    /**
     * 附魔：精准采集
     * <p>
     * 原文：
     * Allows blocks to drop themselves instead of fragments (for example,
     * stone instead of cobblestone)
     */
    public static final Enchantment SILK_TOUCH = new EnchantmentWrapper("silk_touch");

    /**
     * 附魔：耐久
     * <p>
     * 原文：
     * Decreases the rate at which a tool looses durability
     */
    public static final Enchantment DURABILITY = new EnchantmentWrapper("unbreaking");

    /**
     * 附魔：时运
     * <p>
     * 原文：
     * Provides a chance of gaining extra loot when destroying blocks
     */
    public static final Enchantment LOOT_BONUS_BLOCKS = new EnchantmentWrapper("fortune");

    /**
     * 附魔：力量 (弓)
     * <p>
     * 原文：
     * Provides extra damage when shooting arrows from bows
     */
    public static final Enchantment ARROW_DAMAGE = new EnchantmentWrapper("power");

    /**
     * 附魔：击退 (弓)
     * <p>
     * 原文:
     * Provides a knockback when an entity is hit by an arrow from a bow
     */
    public static final Enchantment ARROW_KNOCKBACK = new EnchantmentWrapper("punch");

    /**
     * 附魔：火焰附加 (弓)
     * <p>
     * 原文:
     * Sets entities on fire when hit by arrows shot from a bow
     */
    public static final Enchantment ARROW_FIRE = new EnchantmentWrapper("flame");

    /**
     * 附魔：无限 (弓)
     * <p>
     * 原文:
     * Provides infinite arrows when shooting a bow
     */
    public static final Enchantment ARROW_INFINITE = new EnchantmentWrapper("infinity");

    /**
     * 附魔：海之眷顾 (钓鱼杆)
     * <p>
     * 原文:
     * Decreases odds of catching worthless junk
     */
    public static final Enchantment LUCK = new EnchantmentWrapper("luck_of_the_sea");

    /**
     * 附魔：诱饵  (钓鱼杆)
     * <p>
     * 原文:
     * Increases rate of fish biting your hook
     */
    public static final Enchantment LURE = new EnchantmentWrapper("lure");

    /**
     * Causes a thrown trident to return to the player who threw it
     */
    public static final Enchantment LOYALTY = new EnchantmentWrapper("loyalty");

    /**
     * Deals more damage to mobs that live in the ocean
     */
    public static final Enchantment IMPALING = new EnchantmentWrapper("impaling");

    /**
     * When it is rainy, launches the player in the direction their trident is thrown
     */
    public static final Enchantment RIPTIDE = new EnchantmentWrapper("riptide");

    /**
     * Strikes lightning when a mob is hit with a trident if conditions are
     * stormy
     */
    public static final Enchantment CHANNELING = new EnchantmentWrapper("channeling");

    /**
     * 附魔：经验修补
     * <p>
     * 原文:Allows mending the item using experience orbs
     */
    public static final Enchantment MENDING = new EnchantmentWrapper("mending");

    /**
     * Item disappears instead of dropping
     */
    public static final Enchantment VANISHING_CURSE = new EnchantmentWrapper("vanishing_curse");

    private static final Map<NamespacedKey, Enchantment> byKey = new HashMap<NamespacedKey, Enchantment>();
    private static final Map<String, Enchantment> byName = new HashMap<String, Enchantment>();
    private static boolean acceptingNew = true;
    private final NamespacedKey key;

    public Enchantment(NamespacedKey key) {
        this.key = key;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    /**
     * 得到这个附魔的名称. 
     * <p>
     * 原文：
     * Gets the unique name of this enchantment
     *
     * @return 独一无二的名称
     * @deprecated 这些附魔的命名简直糟透了，建议使用 {@link #getKey()}.
     */
    @Deprecated
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
     */
    public abstract EnchantmentTarget getItemTarget();

    /**
     * Checks if this enchantment is a treasure enchantment.
     * <br>
     * Treasure enchantments can only be received via looting, trading, or
     * fishing.
     *
     * @return true if the enchantment is a treasure enchantment
     */
    public abstract boolean isTreasure();

    /**
     * Checks if this enchantment is a cursed enchantment
     * <br>
     * Cursed enchantments are found the same way treasure enchantments are
     *
     * @return true if the enchantment is cursed
     * @deprecated cursed enchantments are no longer special. Will return true
     * only for {@link Enchantment#BINDING_CURSE} and
     * {@link Enchantment#VANISHING_CURSE}.
     */
    @Deprecated
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
    public abstract boolean conflictsWith(Enchantment other);

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
     * @return True 如果该附魔适用该物品,则返回true。
     */
    public abstract boolean canEnchantItem(ItemStack item);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Enchantment)) {
            return false;
        }
        final Enchantment other = (Enchantment) obj;
        if (!this.key.equals(other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "Enchantment[" + key + ", " + getName() + "]";
    }

    /**
     * 注册一个附魔的ID和对象.
     * <p>
     * 一般不在插件中使用.
     * <p>
     * 原文：
     * Registers an enchantment with the given ID and object.
     * <p>
     * Generally not to be used from within a plugin.
     *
     * @param enchantment 用于注册的附魔
     */
    public static void registerEnchantment(Enchantment enchantment) {
        if (byKey.containsKey(enchantment.key) || byName.containsKey(enchantment.getName())) {
            throw new IllegalArgumentException("Cannot set already-set enchantment");
        } else if (!isAcceptingRegistrations()) {
            throw new IllegalStateException("No longer accepting new enchantments (can only be done by the server implementation)");
        }

        byKey.put(enchantment.key, enchantment);
        byName.put(enchantment.getName(), enchantment);
    }

    /**
     * 检查是否接受附魔注册 .
     * <p>
     * 原文：
     * Checks if this is accepting Enchantment registrations.
     *
     * @return 如果服务器可能实现添加附魔则返回True
     */
    public static boolean isAcceptingRegistrations() {
        return acceptingNew;
    }

    /**
     * 停止接受任何附魔注册. 
     * <p>
     * 原文：
     * Stops accepting any enchantment registrations
     */
    public static void stopAcceptingRegistrations() {
        acceptingNew = false;
    }

    /**
     * 通过指定键值获取附魔.
     * <p>
     * 原文：
     * Gets the Enchantment at the specified key
     *
     * @param key 附魔键值key
     * @return 返回该key所对应的附魔,要是没有所对应的的附魔则返回null.
     */
    public static Enchantment getByKey(NamespacedKey key) {
        return byKey.get(key);
    }

    /**
     * 获取附魔的指定名称.
     * <p>
     * 原文：
     * Gets the Enchantment at the specified name
     *
     * @param name 名称
     * @return 返回该名称所对应的附魔,要是没有所对应的的附魔则返回null.
     * @deprecated 这些附魔的命名简直糟透了，建议使用 {@link #getByKey(org.bukkit.NamespacedKey)}.
     */
    @Deprecated
    public static Enchantment getByName(String name) {
        return byName.get(name);
    }

    /**
     * 得到所有已经注册了的附魔( {@link Enchantment}s).
     * <p>
     * 原文：
     * Gets an array of all the registered {@link Enchantment}s
     *
     * @return 一个数组
     */
    public static Enchantment[] values() {
        return byName.values().toArray(new Enchantment[byName.size()]);
    }
}