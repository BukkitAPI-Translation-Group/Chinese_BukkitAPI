package org.bukkit.potion;

import java.util.Collection;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.jetbrains.annotations.NotNull;

/**
 * 用于1.9版本之前的数据值的药水适配器.
 * 1.9+版本见{@link PotionMeta}.
 */
@Deprecated
public class Potion {
    private boolean extended = false;
    private boolean splash = false;
    private int level = 1;
    private PotionType type;

    /**
     * 根据指定药水种类创建新药水.
     * 除非此药水种类为药水瓶, 级别将被设置为 1, 无持续时间的延长.
     * 除了药水瓶, 不要使用此构造器创建无效果的药水.
     * <p>
     * 原文:Construct a new potion of the given type. Unless the type is {@link
     * PotionType#WATER}, it will be level one, without extended duration.
     * Don't use this constructor to create a no-effect potion other than
     * water bottle.
     *
     * @param type The potion type
     */
    public Potion(@NotNull PotionType type) {
        Validate.notNull(type, "Null PotionType");
        this.type = type;
    }

    /**
     * 根据指定药水种类和级别创建新药水.
     * <p>
     * 原文:Create a new potion of the given type and level.
     *
     * @param type 药水种类
     * @param level 药水级别
     */
    public Potion(@NotNull PotionType type, int level) {
        this(type);
        Validate.notNull(type, "Type cannot be null");
        Validate.isTrue(level > 0 && level < 3, "Level must be 1 or 2");
        this.level = level;
    }

    /**
     * 根据指定药水种类和级别创建新药水.
     * <p>
     * 原文:Create a new potion of the given type and level.
     *
     * @param type 药水种类
     * @param level 药水级别
     * @param splash 是否为喷溅型药水
     * @deprecated 赞成使用 {@link #Potion(PotionType)} 并调用 {@link
     *     #splash()}.
     */
    @Deprecated
    public Potion(@NotNull PotionType type, int level, boolean splash) {
        this(type, level);
        this.splash = splash;
    }

    /**
     * 根据指定药水种类和级别创建新药水.
     * <p>
     * 原文:Create a new potion of the given type and level.
     *
     * @param type 药水种类
     * @param level 药水级别
     * @param splash 是否为喷溅型药水
     * @param extended 是否为延长版药水
     * @deprecated 赞成使用 {@link #Potion(PotionType)} 并调用 {@link
     *     #extend()} 或 {@link #splash()} (若需要).
     */
    @Deprecated
    public Potion(@NotNull PotionType type, int level, boolean splash, boolean extended) {
        this(type, level, splash);
        this.extended = extended;
    }

    /**
     * 将药水改为喷溅型, 并返回自身用于链式调用.
     * <p>
     * 原文:Chain this to the constructor to make the potion a splash potion.
     *
     * @return 药水对象
     */
    @NotNull
    public Potion splash() {
        setSplash(true);
        return this;
    }

    /**
     * 延长药水持续时间, 并返回自身用于链式调用.
     * <p>
     * 原文:Chain this to the constructor to extend the potion's duration.
     *
     * @return 药水对象
     */
    @NotNull
    public Potion extend() {
        setHasExtendedDuration(true);
        return this;
    }

    /**
     * 将此药水的状态效果应用于指定物品堆. 此物品堆必须为药水.
     * <p>
     * 原文:Applies the effects of this potion to the given {@link ItemStack}. The
     * ItemStack must be a potion.
     *
     * @param to 物品堆
     */
    public void apply(@NotNull ItemStack to) {
        Validate.notNull(to, "itemstack cannot be null");
        Validate.isTrue(to.hasItemMeta(), "given itemstack is not a potion");
        Validate.isTrue(to.getItemMeta() instanceof PotionMeta, "given itemstack is not a potion");
        PotionMeta meta = (PotionMeta) to.getItemMeta();
        meta.setBasePotionData(new PotionData(type, extended, level == 2));
        to.setItemMeta(meta);
    }

    /**
     * 将此药水的状态效果应用于指定实体.
     * <p>
     * 原文:Applies the effects that would be applied by this potion to the given
     * {@link LivingEntity}.
     *
     * @param to 应用于哪个实体
     * @see LivingEntity#addPotionEffects(Collection)
     */
    public void apply(@NotNull LivingEntity to) {
        Validate.notNull(to, "entity cannot be null");
        to.addPotionEffects(getEffects());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Potion other = (Potion) obj;
        return extended == other.extended && splash == other.splash && level == other.level && type == other.type;
    }

    /**
     * 返回此药水应用于实体后的效果的列表.
     * <p>
     * 原文:Returns a collection of {@link PotionEffect}s that this {@link Potion}
     * would confer upon a {@link LivingEntity}.
     *
     * @return 此药水应用后的效果
     * @see PotionBrewer#getEffectsFromDamage(int)
     * @see Potion#toDamageValue()
     */
    @NotNull
    public Collection<PotionEffect> getEffects() {
        return getBrewer().getEffects(type, level == 2, extended);
    }

    /**
     * 返回此药水的级别.
     * <p>
     * 原文:Returns the level of this potion.
     *
     * @return 药水级别
     */
    public int getLevel() {
        return level;
    }

    /**
     * 返回此药水的种类.
     * <p>
     * 原文:Returns the {@link PotionType} of this potion.
     *
     * @return 药水的种类
     */
    @NotNull
    public PotionType getType() {
        return type;
    }

    /**
     * 返回此药水的时长是否可延长.
     * <p>
     * 原文:Returns whether this potion has an extended duration.
     *
     * @return 是否有延长版本的药水
     */
    public boolean hasExtendedDuration() {
        return extended;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + level;
        result = prime * result + (extended ? 1231 : 1237);
        result = prime * result + (splash ? 1231 : 1237);
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /**
     * 返回是否为喷溅型药水.
     * <p>
     * 原文:Returns whether this potion is a splash potion.
     *
     * @return 是否为喷溅型药水
     */
    public boolean isSplash() {
        return splash;
    }

    /**
     * 设置此药水是否延长持续时间. 这将导致此药水相比常规版本有约3/8倍的持续时间.
     * <p>
     * 原文:Set whether this potion has extended duration. This will cause the
     * potion to have roughly 8/3 more duration than a regular potion.
     *
     * @param isExtended 是否延长持续时间
     */
    public void setHasExtendedDuration(boolean isExtended) {
        Validate.isTrue(type == null || !type.isInstant(), "Instant potions cannot be extended");
        extended = isExtended;
    }

    /**
     * 设置此药水是否为喷溅型药水. 喷溅型药水可作用于一定的范围.
     * <p>
     * 原文:Sets whether this potion is a splash potion. Splash potions can be
     * thrown for a radius effect.
     *
     * @param isSplash 是否为喷溅型药水
     */
    public void setSplash(boolean isSplash) {
        splash = isSplash;
    }

    /**
     * 设置药水的种类.
     * <p>
     * 原文:Sets the {@link PotionType} of this potion.
     *
     * @param type 药水的种类
     */
    public void setType(@NotNull PotionType type) {
        this.type = type;
    }

    /**
     * 设置药水的级别.
     * <p>
     * 原文:Sets the level of this potion.
     *
     * @param level 药水级别
     */
    public void setLevel(int level) {
        Validate.notNull(this.type, "No-effect potions don't have a level.");
        Validate.isTrue(level > 0 && level <= 2, "Level must be between 1 and 2 for this potion");
        this.level = level;
    }

    /**
     * 将此药水转化为合适的 damage 值, 对药水物品堆有用.
     * <p>
     * 原文:Converts this potion to a valid potion damage short, usable for potion
     * item stacks.
     *
     * @return 药水的 damage 值
     * @deprecated 无任何作用
     */
    @Deprecated
    public short toDamageValue() {
        return 0;
    }

    /**
     * 将此药水转为一个指定堆叠数的物品堆.
     * <p>
     * 原文:Converts this potion to an {@link ItemStack} with the specified amount
     * and a correct damage value.
     *
     * @param amount 物品堆叠数
     * @return 物品堆
     */
    @NotNull
    public ItemStack toItemStack(int amount) {
        Material material;
        if (isSplash()) {
            material = Material.SPLASH_POTION;
        } else {
            material = Material.POTION;
        }
        ItemStack itemStack = new ItemStack(material, amount);
        PotionMeta meta = (PotionMeta) itemStack.getItemMeta();
        meta.setBasePotionData(new PotionData(type, level == 2, extended));
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    private static PotionBrewer brewer;

    private static final int EXTENDED_BIT = 0x40;
    private static final int POTION_BIT = 0xF;
    private static final int SPLASH_BIT = 0x4000;
    private static final int TIER_BIT = 0x20;
    private static final int TIER_SHIFT = 5;

    /**
     * 根据 damage 值获取药水.
     * <p>
     * 原文:Gets the potion from its damage value.
     *
     * @param damage damage 值
     * @return 创建的药水
     */
    @NotNull
    public static Potion fromDamage(int damage) {
        PotionType type;
        switch (damage & POTION_BIT) {
            case 0:
                type = PotionType.WATER;
                break;
            case 1:
                type = PotionType.REGEN;
                break;
            case 2:
                type = PotionType.SPEED;
                break;
            case 3:
                type = PotionType.FIRE_RESISTANCE;
                break;
            case 4:
                type = PotionType.POISON;
                break;
            case 5:
                type = PotionType.INSTANT_HEAL;
                break;
            case 6:
                type = PotionType.NIGHT_VISION;
                break;
            case 8:
                type = PotionType.WEAKNESS;
                break;
            case 9:
                type = PotionType.STRENGTH;
                break;
            case 10:
                type = PotionType.SLOWNESS;
                break;
            case 11:
                type = PotionType.JUMP;
                break;
            case 12:
                type = PotionType.INSTANT_DAMAGE;
                break;
            case 13:
                type = PotionType.WATER_BREATHING;
                break;
            case 14:
                type = PotionType.INVISIBILITY;
                break;
            default:
                type = PotionType.WATER;
        }
        Potion potion;
        if (type == null || type == PotionType.WATER) {
            potion = new Potion(PotionType.WATER);
        } else {
            int level = (damage & TIER_BIT) >> TIER_SHIFT;
            level++;
            potion = new Potion(type, level);
        }
        if ((damage & SPLASH_BIT) != 0) {
            potion = potion.splash();
        }
        if ((damage & EXTENDED_BIT) != 0) {
            potion = potion.extend();
        }
        return potion;
    }

    @NotNull
    public static Potion fromItemStack(@NotNull ItemStack item) {
        Validate.notNull(item, "item cannot be null");
        if (item.getType() != Material.POTION)
            throw new IllegalArgumentException("item is not a potion");
        return fromDamage(item.getDurability());
    }

    /**
     * 返回一个{@link PotionBrewer}实例.
     * <p>
     * 原文:Returns an instance of {@link PotionBrewer}.
     *
     * @return 一个{@link PotionBrewer}实例
     */
    @NotNull
    public static PotionBrewer getBrewer() {
        return brewer;
    }

    /**
     * 设置当前的 {@link PotionBrewer} 实例. 通常不由插件使用.
     * <p>
     * 原文:Sets the current instance of {@link PotionBrewer}. Generally not to be
     * used from within a plugin.
     *
     * @param other 新 {@link PotionBrewer} 实例
     */
    public static void setPotionBrewer(@NotNull PotionBrewer other) {
        if (brewer != null)
            throw new IllegalArgumentException("brewer can only be set internally");
        brewer = other;
    }

    /**
     * 根据 name id 获取药水对象.
     * <p>
     * 原文:Gets the potion from its name id.
     *
     * @return the name id
     * @deprecated 无任何作用
     */
    @Deprecated
    public int getNameId() {
        return 0;
    }
}
