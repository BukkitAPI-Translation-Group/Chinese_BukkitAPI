package org.bukkit.inventory.meta;

import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 本类型代表物品附属数据的存储机制.
 * <p>
 * 接口的实现会处理 ItemMeta 的创建和应用.
 * 本类不应由实时环境中的插件实现.
 */
public interface ItemMeta extends Cloneable, ConfigurationSerializable, PersistentDataHolder {

    /**
     * 检查物品是否有展示名.
     * <p>
     * 原文:
     * Checks for existence of a display name.
     *
     * @return 物品是否有展示名
     */
    boolean hasDisplayName();

    /**
     * 获取物品的展示名.
     * <p>
     * 插件应该在调用这个方法之前检查 hasDisplayName() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the display name that is set.
     * <p>
     * Plugins should check that hasDisplayName() returns <code>true</code>
     * before calling this method.
     *
     * @return 物品的展示名
     */
    @NotNull
    String getDisplayName();

    /**
     * 设置物品的展示名.
     * <p>
     * 原文:
     * Sets the display name.
     *
     * @param name 要设置的物品名
     */
    void setDisplayName(@Nullable String name);

    /**
     * 检查物品是否有本地化名称.
     * <p>
     * 原文:
     * Checks for existence of a localized name.
     *
     * @return 物品是否有本地化名称
     */
    boolean hasLocalizedName();

    /**
     * 获取为物品设置的本地化展示名.
     * <p>
     * 插件应该在调用这个方法之前检查 hasLocalizedName() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the localized display name that is set.
     * <p>
     * Plugins should check that hasLocalizedName() returns <code>true</code>
     * before calling this method.
     *
     * @return 物品的本地化名称
     */
    @NotNull
    String getLocalizedName();

    /**
     * 设置物品的本地化名称.
     * <p>
     * 原文:
     * Sets the localized name.
     *
     * @param name 要设置的物品名
     */
    void setLocalizedName(@Nullable String name);

    /**
     * 检查物品是否存在 lore.
     * <p>
     * 原文:
     * Checks for existence of lore.
     *
     * @return 物品是否存在 lore
     */
    boolean hasLore();

    /**
     * 获取物品的 lore.
     * <p>
     * 插件应该在调用这个方法之前检查 hasLore() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the lore that is set.
     * <p>
     * Plugins should check if hasLore() returns <code>true</code> before
     * calling this method.
     *
     * @return 物品的 lore 列表
     */
    @Nullable
    List<String> getLore();

    /**
     * 为物品设置 lore.
     * 当传参为 null 时移除物品的 lore.
     * <p>
     * 原文:
     * Sets the lore for this item.
     * Removes lore when given null.
     *
     * @param lore 要设置的 lore
     */
    void setLore(@Nullable List<String> lore);

    /**
     * 检查物品是否存在自定义模型数据.
     * <p>
     * CustomModelData 是一个整数, 可以将客户端与自定义的物品模型相关联.
     * <p>
     * 原文:
     * Checks for existence of custom model data.
     * <p>
     * CustomModelData is an integer that may be associated client side with a
     * custom item model.
     *
     * @return 物品是否存在自定义模型数据
     */
    boolean hasCustomModelData();

    /**
     * 获取物品的自定义模型数据.
     * <p>
     * CustomModelData 是一个整数, 可以将客户端与自定义的物品模型相关联.
     * <p>
     * 插件应该在调用这个方法之前检查 hasCustomModelData() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the custom model data that is set.
     * <p>
     * CustomModelData is an integer that may be associated client side with a
     * custom item model.
     * <p>
     * Plugins should check that hasCustomModelData() returns <code>true</code>
     * before calling this method.
     *
     * @return 物品的自定义模型数据
     */
    int getCustomModelData();

    /**
     * 设置物品的自定义模型数据.
     * <p>
     * CustomModelData 是一个整数, 可以将客户端与自定义的物品模型相关联.
     * <p>
     * 原文:
     * Sets the custom model data.
     * <p>
     * CustomModelData is an integer that may be associated client side with a
     * custom item model.
     *
     * @param data 要设置的数据, 传递 null 以清除数据
     */
    void setCustomModelData(@Nullable Integer data);

    /**
     * 检查物品是否含有附魔.
     * <p>
     * 原文:
     * Checks for the existence of any enchantments.
     *
     * @return 物品是否含有附魔
     */
    boolean hasEnchants();

    /**
     * 检查物品是否存在指定的附魔.
     * <p>
     * 原文:
     * Checks for existence of the specified enchantment.
     *
     * @param ench 要检查的附魔
     * @return 如果此附魔存在于此物品上则返回 true
     */
    boolean hasEnchant(@NotNull Enchantment ench);

    /**
     * 获取物品上指定附魔的等级.
     * <p>
     * 原文:
     * Checks for the level of the specified enchantment.
     *
     * @param ench 要检查的附魔
     * @return 附魔等级, 0 代表不存在此附魔
     */
    int getEnchantLevel(@NotNull Enchantment ench);

    /**
     * 返回此物品上的附魔的 map 副本.<br>
     * 如果物品没有附魔则返回空 map.
     * <p>
     * 原文:
     * Returns a copy the enchantments in this ItemMeta. <br>
     * Returns an empty map if none.
     *
     * @return 物品所有附魔的不可变副本
     */
    @NotNull
    Map<Enchantment, Integer> getEnchants();

    /**
     * 为物品添加一个附魔.
     * <p>
     * 原文:
     * Adds the specified enchantment to this item meta.
     *
     * @param ench 要添加的附魔
     * @param level 附魔等级
     * @param ignoreLevelRestriction 是否忽略附魔的等级限制
     * @return 如果物品的 meta 因调用此方法而改变 (就是附魔添加成功的意思) 返回 true, false 反之
     */
    boolean addEnchant(@NotNull Enchantment ench, int level, boolean ignoreLevelRestriction);

    /**
     * 移除物品上指定的附魔.
     * <p>
     * 原文:
     * Removes the specified enchantment from this item meta.
     *
     * @param ench 要移除的附魔
     * @return 移除附魔成功返回 true, false反之
     */
    boolean removeEnchant(@NotNull Enchantment ench);

    /**
     * 检查指定的附魔是否与任何 ItemMeta 里的附魔冲突.
     * <p>
     * 原文:
     * Checks if the specified enchantment conflicts with any enchantments in
     * this ItemMeta.
     *
     * @param ench 要测试的附魔
     * @return 有冲突的附魔返回 true, false 反之
     */
    boolean hasConflictingEnchant(@NotNull Enchantment ench);

    /**
     * 设置物品的 flag, 用来指定客户端渲染物品堆信息时隐藏哪些属性.
     * 本方法会静默忽略双重设置的 itemFlags.
     * <p>
     * 原文:
     * Set itemflags which should be ignored when rendering a ItemStack in the Client. This Method does silently ignore double set itemFlags.
     *
     * @param itemFlags 希望哪些属性不显示出来
     */
    void addItemFlags(@NotNull ItemFlag... itemFlags);

    /**
     * 移除指定的一系列 itemFlags. 这将告诉客户端应再次显示被隐藏的属性.
     * 本方法会静默忽略双重设置的 itemFlags.
     * <p>
     * 原文:
     * Remove specific set of itemFlags. This tells the Client it should render it again. This Method does silently ignore double removed itemFlags.
     *
     * @param itemFlags 要移除的属性隐藏标志
     */
    void removeItemFlags(@NotNull ItemFlag... itemFlags);

    /**
     * 获取当前设置的 itemFlags. 返回的集合是不可变的.
     * <p>
     * 原文:
     * Get current set itemFlags. The collection returned is unmodifiable.
     *
     * @return 当前设置的 itemFlags 的集合
     */
    @NotNull
    Set<ItemFlag> getItemFlags();

    /**
     * 检查物品是否存在指定的 flag.
     * <p>
     * 原文:
     * Check if the specified flag is present on this item.
     *
     * @param flag 要检查的 flag
     * @return 是否存在指定的 flag
     */
    boolean hasItemFlag(@NotNull ItemFlag flag);

    /**
     * 返回物品的 unbreakable 标签是否为 true.
     * 一个牢不可破的物品不会丧失耐久度.
     * <p>
     * 原文:
     * Return if the unbreakable tag is true. An unbreakable item will not lose
     * durability.
     *
     * @return 物品的 unbreakable 标签是否为 true
     */
    boolean isUnbreakable();

    /**
     * 设置物品的 unbreakable 标签是否为 true.
     * 一个牢不可破的物品不会丧失耐久度.
     * <p>
     * 原文:
     * Sets the unbreakable tag. An unbreakable item will not lose durability.
     *
     * @param unbreakable 要使物品牢不可破则设为 true
     */
    void setUnbreakable(boolean unbreakable);

    /**
     * 检查物品是否存在任何属性修饰符.
     * <p>
     * 原文:
     * Checks for the existence of any AttributeModifiers.
     *
     * @return 物品存在属性修饰符则返回 true
     */
    boolean hasAttributeModifiers();

    /**
     * 返回所有属性及其修饰符的不可变副本.<br>
     * 如果不存在则返回 null.
     * <p>
     * 原文:
     * Return an immutable copy of all Attributes and
     * their modifiers in this ItemMeta.<br>
     * Returns null if none exist.
     *
     * @return 所有属性及其修饰符的不可变 {@link Multimap}, null 代表不存在修饰符
     */
    @Nullable
    Multimap<Attribute, AttributeModifier> getAttributeModifiers();

    /**
     * 返回指定 {@link EquipmentSlot} 的所有属性及其修饰符的不可变列表.
     * 设置了给定 {@link EquipmentSlot} 的任何 {@link AttributeModifier} 都将会返回.
     * 这是因为未指定槽位的修饰符可在任意槽位中生效.<br>
     * 如果未给指定槽位设置任何属性, 将返回一个空 map.
     * <p>
     * 原文:
     * Return an immutable copy of all {@link Attribute}s and their
     * {@link AttributeModifier}s for a given {@link EquipmentSlot}.<br>
     * Any {@link AttributeModifier} that does have have a given
     * {@link EquipmentSlot} will be returned. This is because
     * AttributeModifiers without a slot are active in any slot.<br>
     * If there are no attributes set for the given slot, an empty map
     * will be returned.
     *
     * @param slot 要检查的 {@link EquipmentSlot}
     * @return the immutable {@link Multimap} with the
     *         respective Attributes and modifiers, or an empty map
     *         if no attributes are set.
     */
    @NotNull
    Multimap<Attribute, AttributeModifier> getAttributeModifiers(@NotNull EquipmentSlot slot);

    /**
     * 返回指定{@link Attribute 属性}的所有{@link AttributeModifier 修饰符}的不可变列表.
     * <p>
     * 原文:
     * Return an immutable copy of all {@link AttributeModifier}s
     * for a given {@link Attribute}
     *
     * @param attribute {@link Attribute 属性}
     * @return 包含所有{@link AttributeModifier 修饰符}的不可变集合,
     * 如果指定属性不存在修饰符则返回 null
     * @throws NullPointerException 若 Attribute 为 null
     */
    @Nullable
    Collection<AttributeModifier> getAttributeModifiers(@NotNull Attribute attribute);

    /**
     * 添加一个属性和它的修饰符.
     * 属性修饰符现支持设置 {@link EquipmentSlot}.
     * 如果没有设置, 则{@link AttributeModifier 属性修饰符}将在所有槽位中生效.
     * <br>
     * 拥有相同 {@link java.util.UUID} 的两个 {@link AttributeModifier}
     * 不可同时存在于同一个属性上.
     * <p>
     * 原文:
     * Add an Attribute and it's Modifier.
     * AttributeModifiers can now support {@link EquipmentSlot}s.
     * If not set, the {@link AttributeModifier} will be active in ALL slots.
     * <br>
     * Two {@link AttributeModifier}s that have the same {@link java.util.UUID}
     * cannot exist on the same Attribute.
     *
     * @param attribute 要修改的{@link Attribute 属性}
     * @param modifier 属性的{@link AttributeModifier 修饰符}
     * @return 如果属性及其修饰符成功添加返回 true
     * @throws NullPointerException 若 Attribute 为 null
     * @throws NullPointerException 若 AttributeModifier 为 null
     * @throws IllegalArgumentException 若 AttributeModifier 已存在于已设置的某一属性上
     */
    boolean addAttributeModifier(@NotNull Attribute attribute, @NotNull AttributeModifier modifier);

    /**
     * 设置所有{@link Attribute 属性}和它们的{@link AttributeModifier 属性修饰符}.
     * 要移除所有已设置的属性和属性修饰符, 可以指定参数为 null 或空的 Multimap.
     * 若参数既不为 null 也不为空 map, 本方法将筛选出非空的键值对并添加给物品堆.
     * <p>
     * 译注: 本方法会清空原有的属性, 添加请用 add 开头的相关方法.
     * <p>
     * 原文:
     * Set all {@link Attribute}s and their {@link AttributeModifier}s.
     * To clear all currently set Attributes and AttributeModifiers use
     * null or an empty Multimap.
     * If not null nor empty, this will filter all entries that are not-null
     * and add them to the ItemStack.
     *
     * @param attributeModifiers 包含属性和它们的属性修饰符的新 Multimap
     */
    void setAttributeModifiers(@Nullable Multimap<Attribute, AttributeModifier> attributeModifiers);

    /**
     * 移除与给定{@link Attribute 属性}有关的所有 {@link AttributeModifier 属性修饰符}.
     * 如果没有移除任何东西将会返回 false.
     * <p>
     * 原文:
     * Remove all {@link AttributeModifier}s associated with the given
     * {@link Attribute}.
     * This will return false if nothing was removed.
     *
     * @param attribute 要移除的属性
     * @return 与此属性有关的所有修饰符均被移除则返回 true, 没有移除任何修饰符则返回 false
     * @throws NullPointerException 如果 Attribute 为 null
     */
    boolean removeAttributeModifier(@NotNull Attribute attribute);

    /**
     * 为指定的 {@link EquipmentSlot} 移除其所有的{@link Attribute 属性}和{@link AttributeModifier 属性修饰符}.<br>
     * 如果给定的 {@link EquipmentSlot} 为 null, 这将移除所有没有设置 {@link EquipmentSlot} 的 {@link AttributeModifier}.
     * <p>
     * 原文:
     * Remove all {@link Attribute}s and {@link AttributeModifier}s for a
     * given {@link EquipmentSlot}.<br>
     * If the given {@link EquipmentSlot} is null, this will remove all
     * {@link AttributeModifier}s that do not have an EquipmentSlot set.
     *
     * @param slot 要操作的 {@link EquipmentSlot}
     * @return 如果与给定 EquipmentSlot 匹配的所有修饰符被移除则返回true.
     */
    boolean removeAttributeModifier(@NotNull EquipmentSlot slot);

    /**
     * 移除一个指定的 {@link Attribute 属性} 和 {@link AttributeModifier 属性修饰符}.
     * 将根据它们的 {@link java.util.UUID} 匹配属性修饰符.
     * <p>
     * 原文:
     * Remove a specific {@link Attribute} and {@link AttributeModifier}.
     * AttributeModifiers are matched according to their {@link java.util.UUID}.
     *
     * @param attribute 要移除的{@link Attribute 属性}
     * @param modifier 要移除的{@link AttributeModifier 属性修饰符}
     * @return 如果删除了任何属性修饰符
     *
     * @throws NullPointerException 若 Attribute 为 null
     * @throws NullPointerException 若 AttributeModifier 为 null
     *
     * @see AttributeModifier#getUniqueId()
     */
    boolean removeAttributeModifier(@NotNull Attribute attribute, @NotNull AttributeModifier modifier);

    /**
     * 返回一个公共的自定义标签容器, 其能够在物品上存储标签.
     *
     * 那些标签及其所有内容都会被发送到客户端, 因此客户端能够读取它们.
     * 这将导致玩家可以看到物品上有 NBT 标签的提醒.
     *
     * 一旦客户端处于创造模式, 这些标签也可被客户端修改.
     * <p>
     * 原文:
     * Returns a public custom tag container capable of storing tags on the
     * item.
     *
     * Those tags will be sent to the client with all of their content, so the
     * client is capable of reading them. This will result in the player seeing
     * a NBT Tag notification on the item.
     *
     * These tags can also be modified by the client once in creative mode
     *
     * @return 自定义的标签容器
     * @deprecated 该 API 已被 {@link PersistentDataHolder} API 取代.
     * 请使用 {@link PersistentDataHolder#getPersistentDataContainer()}.
     */
    @NotNull
    @Deprecated
    CustomItemTagContainer getCustomTagContainer();

    /**
     * 仅供内部使用! (插件)请勿在任何情况下使用!
     * <p>
     * 原文:
     * Internal use only! Do not use under any circumstances!
     *
     * @param version meta的版本
     * @deprecated 仅供内部使用
     */
    @Deprecated
    void setVersion(int version);

    @SuppressWarnings("javadoc")
    @NotNull
    ItemMeta clone();
}
