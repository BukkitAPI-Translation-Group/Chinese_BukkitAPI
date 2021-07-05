package org.bukkit.inventory;

import com.google.common.collect.ImmutableMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表物品堆.
 * <p>
 * <b>重要: <i>物品</i>堆只被设计用于容纳物品.
 * 请不要使用本类来简要描述某种不可获得的物品 
 * (可以用{@link Material#isItem()}检测, 不要用 ItemStack存储此方法返回false的物品).</b>
 */
public class ItemStack implements Cloneable, ConfigurationSerializable {
    private Material type = Material.AIR;
    private int amount = 0;
    private MaterialData data = null;
    private ItemMeta meta;

    @Utility
    protected ItemStack() {}

    /**
     * 构造一个堆叠数为1, 无附加数据的物品堆.
     * <p>
     * <b>重要: <i>物品</i>堆只被设计用于容纳物品.
     * 请不要使用本类来简要描述某种不可获得的物品 
     * (可以用{@link Material#isItem()}检测, 不要用 ItemStack存储此方法返回false的物品). </b>
     *
     * 原文:Defaults stack size to 1, with no extra data.
     * <p>
     * <b>IMPORTANT: An <i>Item</i>Stack is only designed to contain
     * <i>items</i>. Do not use this class to encapsulate Materials for which
     * {@link Material#isItem()} returns false.</b>
     *
     * @param type 物品种类
     */
    public ItemStack(@NotNull final Material type) {
        this(type, 1);
    }

    /**
     * 构造指定堆叠数, 无附加数据的物品堆.
     * <p>
     * <b>重要: <i>物品</i>堆只被设计用于容纳物品.
     * 请不要使用本类来简要描述某种不可获得的物品 
     * (可以用{@link Material#isItem()}检测, 不要用 ItemStack存储此方法返回false的物品).</b>
     * <p>
     * 原文:An item stack with no extra data.
     * <p>
     * <b>IMPORTANT: An <i>Item</i>Stack is only designed to contain
     * <i>items</i>. Do not use this class to encapsulate Materials for which
     * {@link Material#isItem()} returns false.</b>
     *
     * @param type 物品种类
     * @param amount 堆叠数
     */
    public ItemStack(@NotNull final Material type, final int amount) {
        this(type, amount, (short) 0);
    }

    /**
     * 构造一个具有指定损耗值(耐久度)的物品堆.
     * <p>
     * 原文:An item stack with the specified damage / durability
     *
     * @param type 物品种类
     * @param amount 堆叠数
     * @param damage 损耗值
     * @deprecated 另请参阅 {@link #setDurability(short)}
     */
    public ItemStack(@NotNull final Material type, final int amount, final short damage) {
        this(type, amount, damage, null);
    }

    /**
     * @param type 物品种类
     * @param amount 堆叠数
     * @param damage 损耗值
     * @param data 数据值或null
     * @deprecated 该方法使用了意义不明确的data byte对象
     */
    @Deprecated
    public ItemStack(@NotNull final Material type, final int amount, final short damage, @Nullable final Byte data) {
        Validate.notNull(type, "Material cannot be null");
        this.type = type;
        this.amount = amount;
        if (damage != 0) {
            setDurability(damage);
        }
        if (data != null) {
            createData(data);
        }
    }

    /**
     * 构造一个指定物品堆的副本.
     * <p>
     * 原文:Creates a new item stack derived from the specified stack
     *
     * @param stack 要复制的物品堆
     * @throws IllegalArgumentException 如果指定的 stack 为null或返回的
     * 物品元数据不是通过ItemFactory创建的
     */
    public ItemStack(@NotNull final ItemStack stack) throws IllegalArgumentException {
        Validate.notNull(stack, "Cannot copy null stack");
        this.type = stack.getType();
        this.amount = stack.getAmount();
        if (this.type.isLegacy()) {
            this.data = stack.getData();
        }
        if (stack.hasItemMeta()) {
            setItemMeta0(stack.getItemMeta(), type);
        }
    }

    /**
     * 获取该物品的种类.
     * <p>
     * 原文:Gets the type of this item
     *
     * @return 该物品的种类
     */
    @Utility
    @NotNull
    public Material getType() {
        return type;
    }

    /**
     * 设置该物品的种类.
     * <p>
     * 注:在做这件事的同时你将清除该物品堆上的MaterialData数据.
     * <p>
     * <b>重要: <i>物品</i>堆只被设计用于容纳物品.
     * 请不要使用本类来简要描述某种不可获得的物品 
     * (可以用{@link Material#isItem()}检测, 不要用 ItemStack存储此方法返回false的物品).</b>
     * <p>
     * 原文:Sets the type of this item
     * <p>
     * Note that in doing so you will reset the MaterialData for this stack.
     * <p>
     * <b>IMPORTANT: An <i>Item</i>Stack is only designed to contain
     * <i>items</i>. Do not use this class to encapsulate Materials for which
     * {@link Material#isItem()} returns false.</b>
     *
     * @param type 该物品的种类
     */
    @Utility
    public void setType(@NotNull Material type) {
        Validate.notNull(type, "Material cannot be null");
        this.type = type;
        if (this.meta != null) {
            this.meta = Bukkit.getItemFactory().asMetaFor(meta, type);
        }
        if (type.isLegacy()) {
            createData((byte) 0);
        } else {
            this.data = null;
        }
    }

    /**
     * 获取该物品堆的物品堆叠数量.
     * <p>
     * 原文:Gets the amount of items in this stack
     *
     * @return 物品堆叠数量
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 设置该物品堆的物品堆叠数量.
     * <p>
     * 原文:Sets the amount of items in this stack
     *
     * @param amount 物品堆叠数量
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * 获取该物品堆的 MateralData 数据.
     * <p>
     * 原文:Gets the MaterialData for this stack of items
     *
     * @return 物品堆的MaterialData数据
     */
    @Nullable
    public MaterialData getData() {
        Material mat = Bukkit.getUnsafe().toLegacy(getType());
        if (data == null && mat != null && mat.getData() != null) {
            data = mat.getNewData((byte) this.getDurability());
        }

        return data;
    }

    /**
     * 设置该物品堆的 MateralData 数据.
     * <p>
     * 原文:Sets the MaterialData for this stack of items
     *
     * @param data 物品堆的MaterialData数据
     */
    public void setData(@Nullable MaterialData data) {
        if (data == null) {
            this.data = data;
        } else {
            Material mat = Bukkit.getUnsafe().toLegacy(getType());

            if ((data.getClass() == mat.getData()) || (data.getClass() == MaterialData.class)) {
                this.data = data;
            } else {
                throw new IllegalArgumentException("Provided data is not of type " + mat.getData().getName() + ", found " + data.getClass().getName());
            }
        }
    }

    /**
     * 设置该物品的耐久度.
     * <p>
     * 原文:Sets the durability of this item
     *
     * @param durability 物品耐久度
     * @deprecated 耐久度现在是 ItemMeta 的一部分. 为避免疑虑和误用, 请使用
     * {@link #getItemMeta()}, {@link #setItemMeta(ItemMeta)} 和
     * {@link Damageable#setDamage(int)}. 这是因为在调用此方法之前创建的 ItemMeta
     * 的后续变动将覆盖调用此方法设置的物品元数据.
     */
    @Deprecated
    public void setDurability(final short durability) {
        ItemMeta meta = getItemMeta();
        if (meta != null) {
            ((Damageable) meta).setDamage(durability);
            setItemMeta(meta);
        }
    }

    /**
     * 获取该物品的耐久度.
     * <p>
     * 原文:Gets the durability of this item
     *
     * @return 物品耐久度
     * @deprecated 另请参阅 {@link #setDurability(short)}
     */
    @Deprecated
    public short getDurability() {
        ItemMeta meta = getItemMeta();
        return (meta == null) ? 0 : (short) ((Damageable) meta).getDamage();
    }

    /**
     * 获取该物品的最大堆叠数 (若物品未知返回-1).
     * <p>
     * 原文:Get the maximum stacksize for the material hold in this ItemStack.
     * (Returns -1 if it has no idea)
     *
     * @return 该物品的最大堆叠数
     */
    @Utility
    public int getMaxStackSize() {
        Material material = getType();
        if (material != null) {
            return material.getMaxStackSize();
        }
        return -1;
    }

    private void createData(final byte data) {
        this.data = type.getNewData(data);
    }

    @Override
    @Utility
    public String toString() {
        StringBuilder toString = new StringBuilder("ItemStack{").append(getType().name()).append(" x ").append(getAmount());
        if (hasItemMeta()) {
            toString.append(", ").append(getItemMeta());
        }
        return toString.append('}').toString();
    }

    @Override
    @Utility
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemStack)) {
            return false;
        }

        ItemStack stack = (ItemStack) obj;
        return getAmount() == stack.getAmount() && isSimilar(stack);
    }

    /**
     * 该方法与equals方法相同, 但不考虑堆叠数量.
     * <p>
     * 原文:This method is the same as equals, but does not consider stack size
     * (amount).
     *
     * @param stack 与哪个物品堆作比较
     * @return 若两者相同返回true (忽略其堆叠数)
     */
    @Utility
    public boolean isSimilar(@Nullable ItemStack stack) {
        if (stack == null) {
            return false;
        }
        if (stack == this) {
            return true;
        }
        Material comparisonType = (this.type.isLegacy()) ? Bukkit.getUnsafe().fromLegacy(this.getData(), true) : this.type; // This may be called from legacy item stacks, try to get the right material
        return comparisonType == stack.getType() && getDurability() == stack.getDurability() && hasItemMeta() == stack.hasItemMeta() && (hasItemMeta() ? Bukkit.getItemFactory().equals(getItemMeta(), stack.getItemMeta()) : true);
    }

    @NotNull
    @Override
    public ItemStack clone() {
        try {
            ItemStack itemStack = (ItemStack) super.clone();

            if (this.meta != null) {
                itemStack.meta = this.meta.clone();
            }

            if (this.data != null) {
                itemStack.data = this.data.clone();
            }

            return itemStack;
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    @Override
    @Utility
    public int hashCode() {
        int hash = 1;

        hash = hash * 31 + getType().hashCode();
        hash = hash * 31 + getAmount();
        hash = hash * 31 + (getDurability() & 0xffff);
        hash = hash * 31 + (hasItemMeta() ? (meta == null ? getItemMeta().hashCode() : meta.hashCode()) : 0);

        return hash;
    }

    /**
     * 检测该物品堆是否包含指定{@link Enchantment 附魔}.
     * <p>
     * 原文:Checks if this ItemStack contains the given {@link Enchantment}
     *
     * @param ench 附魔
     * @return 若该物品含有此附魔返回true
     */
    public boolean containsEnchantment(@NotNull Enchantment ench) {
        return meta == null ? false : meta.hasEnchant(ench);
    }

    /**
     * 获取该物品指定附魔的附魔等级.
     * <p>
     * 原文:Gets the level of the specified enchantment on this item stack
     *
     * @param ench 附魔
     * @return 指定附魔的附魔等级, 若附魔不存在/没有附魔则为0
     */
    public int getEnchantmentLevel(@NotNull Enchantment ench) {
        return meta == null ? 0 : meta.getEnchantLevel(ench);
    }

    /**
     * 获取该物品的所有附魔以及对应的附魔等级, 用map表示.
     * <p>
     * 原文:Gets a map containing all enchantments and their levels on this item.
     *
     * @return 附魔魔咒
     */
    @NotNull
    public Map<Enchantment, Integer> getEnchantments() {
        return meta == null ? ImmutableMap.<Enchantment, Integer>of() : meta.getEnchants();
    }

    /**
     * 向物品堆添加附魔.
     * <p>
     * 该方法实质就是遍历你所给的map, 逐一调用{@link
     * #addEnchantment(org.bukkit.enchantments.Enchantment, int)}.
     * <p>
     * 原文:Adds the specified enchantments to this item stack.
     * <p>
     * This method is the same as calling {@link
     * #addEnchantment(org.bukkit.enchantments.Enchantment, int)} for each
     * element of the map.
     *
     * @param enchantments 要添加的附魔
     * @throws IllegalArgumentException 若参数enchantments为null
     * @throws IllegalArgumentException 若任何指定的附魔或等级为null.
     * <b>警告</b>: 某些附魔可能会在此异常抛出前添加到此物品上
     */
    @Utility
    public void addEnchantments(@NotNull Map<Enchantment, Integer> enchantments) {
        Validate.notNull(enchantments, "Enchantments cannot be null");
        for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
            addEnchantment(entry.getKey(), entry.getValue());
        }
    }

    /**
     * 向物品堆添加{@link Enchantment 附魔}.
     * <p>
     * 若此物品堆已经含有给定的附魔(无论它们的附魔等级是什么), 将替换已有的附魔.
     * <p>
     * 原文:Adds the specified {@link Enchantment} to this item stack.
     * <p>
     * If this item stack already contained the given enchantment (at any
     * level), it will be replaced.
     *
     * @param ench 附魔
     * @param level 附魔等级
     * @throws IllegalArgumentException 若enchantment为null, 或该附魔不可应用于此物品上
     */
    @Utility
    public void addEnchantment(@NotNull Enchantment ench, int level) {
        Validate.notNull(ench, "Enchantment cannot be null");
        if ((level < ench.getStartLevel()) || (level > ench.getMaxLevel())) {
            throw new IllegalArgumentException("Enchantment level is either too low or too high (given " + level + ", bounds are " + ench.getStartLevel() + " to " + ench.getMaxLevel() + ")");
        } else if (!ench.canEnchantItem(this)) {
            throw new IllegalArgumentException("Specified enchantment cannot be applied to this itemstack");
        }

        addUnsafeEnchantment(ench, level);
    }

    /**
     * 以不安全的方式向物品堆添加附魔.
     * <p>
     * 该方法实质就是遍历你所给的map, 逐一调用{@link
     * #addUnsafeEnchantment(org.bukkit.enchantments.Enchantment, int)}.
     * <p>
     * 原文:Adds the specified enchantments to this item stack in an unsafe manner.
     * <p>
     * This method is the same as calling {@link
     * #addUnsafeEnchantment(org.bukkit.enchantments.Enchantment, int)} for
     * each element of the map.
     *
     * @param enchantments 附魔
     */
    @Utility
    public void addUnsafeEnchantments(@NotNull Map<Enchantment, Integer> enchantments) {
        for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
            addUnsafeEnchantment(entry.getKey(), entry.getValue());
        }
    }

    /**
     * 向物品堆添加{@link Enchantment 附魔}.
     * <p>
     * 若此物品堆已经含有给定的附魔(无论它们的附魔等级是什么), 将替换已有的附魔.
     * <p>
     * 该方法是个不安全操作, 忽略附魔的等级限制以及对此物品的可用性.
     * 请慎重使用.
     * <p>
     * 原文:Adds the specified {@link Enchantment} to this item stack.
     * <p>
     * If this item stack already contained the given enchantment (at any
     * level), it will be replaced.
     * <p>
     * This method is unsafe and will ignore level restrictions or item type.
     * Use at your own discretion.
     *
     * @param ench 附魔
     * @param level 附魔等级
     */
    public void addUnsafeEnchantment(@NotNull Enchantment ench, int level) {
        ItemMeta itemMeta = (meta == null ? meta = Bukkit.getItemFactory().getItemMeta(type) : meta);
        if (itemMeta != null) {
            itemMeta.addEnchant(ench, level, true);
        }
    }

    /**
     * 移除指定的{@link Enchantment 附魔}.
     * <p>
     * 原文:Removes the specified {@link Enchantment} if it exists on this
     * ItemStack
     *
     * @param ench 要移除的附魔
     * @return 附魔先前的等级, 若附魔不存在为0
     */
    public int removeEnchantment(@NotNull Enchantment ench) {
        int level = getEnchantmentLevel(ench);
        if (level == 0 || meta == null) {
            return level;
        }
        meta.removeEnchant(ench);
        return level;
    }

    @Override
    @NotNull
    @Utility
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        result.put("v", Bukkit.getUnsafe().getDataVersion()); // Include version to indicate we are using modern material names (or LEGACY prefix)
        result.put("type", getType().name());

        if (getAmount() != 1) {
            result.put("amount", getAmount());
        }

        ItemMeta meta = getItemMeta();
        if (!Bukkit.getItemFactory().equals(meta, null)) {
            result.put("meta", meta);
        }

        return result;
    }

    /**
     * 实现配置序列化与反序列化需要的方法.
     * <p>
     * 原文:Required method for configuration serialization
     *
     * @param args 需要反序列化的map
     * @return 反序列化后的物品堆
     * @see ConfigurationSerializable
     */
    @NotNull
    public static ItemStack deserialize(@NotNull Map<String, Object> args) {
        int version = (args.containsKey("v")) ? ((Number) args.get("v")).intValue() : -1;
        short damage = 0;
        int amount = 1;

        if (args.containsKey("damage")) {
            damage = ((Number) args.get("damage")).shortValue();
        }

        Material type;
        if (version < 0) {
            type = Material.getMaterial(Material.LEGACY_PREFIX + (String) args.get("type"));

            byte dataVal = (type != null && type.getMaxDurability() == 0) ? (byte) damage : 0; // Actually durable items get a 0 passed into conversion
            type = Bukkit.getUnsafe().fromLegacy(new MaterialData(type, dataVal), true);

            // We've converted now so the data val isn't a thing and can be reset
            if (dataVal != 0) {
                damage = 0;
            }
        } else {
            type = Bukkit.getUnsafe().getMaterial((String) args.get("type"), version);
        }

        if (args.containsKey("amount")) {
            amount = ((Number) args.get("amount")).intValue();
        }

        ItemStack result = new ItemStack(type, amount, damage);

        if (args.containsKey("enchantments")) { // Backward compatiblity, @deprecated
            Object raw = args.get("enchantments");

            if (raw instanceof Map) {
                Map<?, ?> map = (Map<?, ?>) raw;

                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    Enchantment enchantment = Enchantment.getByName(entry.getKey().toString());

                    if ((enchantment != null) && (entry.getValue() instanceof Integer)) {
                        result.addUnsafeEnchantment(enchantment, (Integer) entry.getValue());
                    }
                }
            }
        } else if (args.containsKey("meta")) { // We cannot and will not have meta when enchantments (pre-ItemMeta) exist
            Object raw = args.get("meta");
            if (raw instanceof ItemMeta) {
                ((ItemMeta) raw).setVersion(version);
                result.setItemMeta((ItemMeta) raw);
            }
        }

        if (version < 0) {
            // Set damage again incase meta overwrote it
            if (args.containsKey("damage")) {
                result.setDurability(damage);
            }
        }

        return result;
    }

    /**
     * 获取此物品堆的{@link ItemMeta}的副本.
     * <p>
     * 原文:Get a copy of this ItemStack's {@link ItemMeta}.
     *
     * @return 物品堆元数据副本
     */
    @Nullable
    public ItemMeta getItemMeta() {
        return this.meta == null ? Bukkit.getItemFactory().getItemMeta(this.type) : this.meta.clone();
    }

    /**
     * 检测该物品堆是否含有任何物品元数据.
     * <p>
     * 原文:Checks to see if any meta data has been defined.
     *
     * @return 返回该物品是否被设置了任何附加元数据值
     */
    public boolean hasItemMeta() {
        return !Bukkit.getItemFactory().equals(meta, null);
    }

    /**
     * 向物品堆设置元数据.
     * <p>
     * 原文:Set the ItemMeta of this ItemStack.
     *
     * @param itemMeta 新物品元数据,或用null来清除此物品上的元数据
     * @return 若成功应用物品元数据返回true, 另请参见 {@link
     *     ItemFactory#isApplicable(ItemMeta, ItemStack)}
     * @throws IllegalArgumentException 物品元数据不是通过{@link ItemFactory}创建的
     */
    public boolean setItemMeta(@Nullable ItemMeta itemMeta) {
        return setItemMeta0(itemMeta, type);
    }

    /*
     * Cannot be overridden, so it's safe for constructor call
     */
    private boolean setItemMeta0(@Nullable ItemMeta itemMeta, @NotNull Material material) {
        if (itemMeta == null) {
            this.meta = null;
            return true;
        }
        if (!Bukkit.getItemFactory().isApplicable(itemMeta, material)) {
            return false;
        }
        this.meta = Bukkit.getItemFactory().asMetaFor(itemMeta, material);

        Material newType = Bukkit.getItemFactory().updateMaterial(meta, material);
        if (this.type != newType) {
            this.type = newType;
        }

        if (this.meta == itemMeta) {
            this.meta = itemMeta.clone();
        }

        return true;
    }
}
