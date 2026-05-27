package org.bukkit.inventory.meta.components;

import java.util.Collection;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示一个可以将任何物品转变为可装备护甲的组件。
 */
@ApiStatus.Experimental
public interface EquippableComponent extends ConfigurationSerializable {

    /**
     * 获取物品可以装备到的槽位。
     * <p>原文：Gets the slot the item can be equipped to.
     *
     * @return 槽位
     */
    @NotNull
    EquipmentSlot getSlot();

    /**
     * 设置物品可以装备到的槽位。
     * <p>原文：Sets the slot the item can be equipped to.
     *
     * @param slot 新的槽位
     */
    void setSlot(@NotNull EquipmentSlot slot);

    /**
     * 获取装备物品时播放的音效。
     * <p>原文：Gets the sound to play when the item is equipped.
     *
     * @return 音效
     */
    @Nullable
    Sound getEquipSound();

    /**
     * 设置装备物品时播放的音效。
     * <p>原文：Sets the sound to play when the item is equipped.
     *
     * @param sound 音效或null表示使用当前默认值
     */
    void setEquipSound(@Nullable Sound sound);

    /**
     * 获取装备时使用的模型键。
     * <p>原文：Gets the key of the model to use when equipped.
     *
     * @return 模型键
     */
    @Nullable
    NamespacedKey getModel();

    /**
     * 设置装备时使用的模型键。
     * <p>原文：Sets the key of the model to use when equipped.
     *
     * @param key 模型键
     */
    void setModel(@Nullable NamespacedKey key);

    /**
     * 获取装备时使用的相机覆盖层键。
     * <p>原文：Gets the key of the camera overlay to use when equipped.
     *
     * @return 相机覆盖层键
     */
    @Nullable
    NamespacedKey getCameraOverlay();

    /**
     * 设置装备时使用的相机覆盖层键。
     * <p>原文：Sets the key of the camera overlay to use when equipped.
     *
     * @param key 相机覆盖层键
     */
    void setCameraOverlay(@Nullable NamespacedKey key);

    /**
     * 获取可以装备此物品的实体。
     * <p>原文：Gets the entities which can equip this item.
     *
     * @return 实体集合
     */
    @Nullable
    Collection<EntityType> getAllowedEntities();

    /**
     * 设置可以装备此物品的实体。
     * <p>原文：Sets the entities which can equip this item.
     *
     * @param entities 实体类型
     */
    void setAllowedEntities(@Nullable EntityType entities);

    /**
     * 设置可以装备此物品的实体。
     * <p>原文：Sets the entities which can equip this item.
     *
     * @param entities 实体类型
     */
    void setAllowedEntities(@Nullable Collection<EntityType> entities);

    /**
     * 设置可以装备此物品的实体类型（表示为实体 {@link Tag}）。
     * <p>原文：Set the entity types (represented as an entity {@link Tag}) which can equip this item.
     *
     * @param tag 实体标签
     * @throws IllegalArgumentException 如果传入的 {@code tag} 不是实体标签
     */
    void setAllowedEntities(@Nullable Tag<EntityType> tag);

    /**
     * 获取物品是否可以被发射器装备。
     * <p>原文：Gets whether the item can be equipped by a dispenser.
     *
     * @return 可装备状态
     */
    boolean isDispensable();

    /**
     * 设置物品是否可以被发射器装备。
     * <p>原文：Sets whether the item can be equipped by a dispenser.
     *
     * @param dispensable 新的可装备状态
     */
    void setDispensable(boolean dispensable);

    /**
     * 获取物品是否可以通过右键交换。
     * <p>原文：Gets if the item is swappable by right clicking.
     *
     * @return 可交换状态
     */
    boolean isSwappable();

    /**
     * 设置物品是否可以通过右键交换。
     * <p>原文：Sets if the item is swappable by right clicking.
     *
     * @param swappable 新的状态
     */
    void setSwappable(boolean swappable);

    /**
     * 获取当穿戴实体受到伤害时物品是否会受损。
     * <p>原文：Gets if the item will be damaged when the wearing entity is damaged.
     *
     * @return 物品是否会受损
     */
    boolean isDamageOnHurt();

    /**
     * 设置当穿戴实体受到伤害时物品是否会受损。
     * <p>原文：Sets if the item will be damaged when the wearing entity is damaged.
     *
     * @param damage 物品是否会受损
     */
    void setDamageOnHurt(boolean damage);

    /**
     * 获取物品是否会在交互时装备。
     * <p>原文：Gets if the item will be equipped on interact.
     *
     * @return 物品是否会被装备
     */
    boolean isEquipOnInteract();

    /**
     * 设置物品是否会在交互时装备。
     * <p>原文：Sets if the item will be equipped on interact.
     *
     * @param equip 物品是否会被装备
     */
    void setEquipOnInteract(boolean equip);

    /**
     * 获取物品是否会被剪刀剪掉。
     * <p>原文：Gets if the item will be sheared off by shears.
     *
     * @return 物品是否可以被剪掉
     */
    boolean isCanBeSheared();

    /**
     * 设置物品是否会被剪刀剪掉。
     * <p>原文：Sets if the item will be sheared off by shears.
     *
     * @param sheared 物品是否可以被剪掉
     */
    void setCanBeSheared(boolean sheared);

    /**
     * 获取物品被剪时播放的音效。
     * <p>原文：Gets the sound to play when the item is sheared.
     *
     * @return 音效
     */
    @Nullable
    Sound getShearingSound();

    /**
     * 设置物品被剪时播放的音效。
     * <p>原文：Sets the sound to play when the item is sheared.
     *
     * @param sound 音效或null表示使用当前默认值
     */
    void setShearingSound(@Nullable Sound sound);
}
