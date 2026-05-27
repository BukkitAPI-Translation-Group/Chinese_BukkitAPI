package org.bukkit.entity;

import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ArmorStand extends LivingEntity {

    /**
     * 返回盔甲架当前握持的物品.
     * <p>
     * 原文:
     * Returns the item the armor stand is currently holding
     *
     * @return 盔甲架当前握持的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#getItemInHand()}
     */
    @NotNull
    @Deprecated(since = "1.15.2")
    ItemStack getItemInHand();

    /**
     * 设置盔甲架当前握持的物品.
     * <p>
     * 原文:
     * Sets the item the armor stand is currently holding
     *
     * @param item 盔甲架当前握持的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#setItemInHand(org.bukkit.inventory.ItemStack)}
     */
    @Deprecated(since = "1.15.2")
    void setItemInHand(@Nullable ItemStack item);

    /**
     * 返回盔甲架当前穿在脚上的物品.
     * <p>
     * 原文:
     * Returns the item currently being worn by the armor stand on its feet
     *
     * @return 穿戴的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#getBoots()}
     */
    @NotNull
    @Deprecated(since = "1.15.2")
    ItemStack getBoots();

    /**
     * 设置盔甲架当前穿在脚上的物品.
     * <p>
     * 原文:
     * Sets the item currently being worn by the armor stand on its feet
     *
     * @param item 穿戴的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#setBoots(org.bukkit.inventory.ItemStack)}
     */
    @Deprecated(since = "1.15.2")
    void setBoots(@Nullable ItemStack item);

    /**
     * 返回盔甲架当前穿在腿上的物品.
     * <p>
     * 原文:
     * Returns the item currently being worn by the armor stand on its legs
     *
     * @return 穿戴的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#getLeggings()}
     */
    @NotNull
    @Deprecated(since = "1.15.2")
    ItemStack getLeggings();

    /**
     * 设置盔甲架当前穿在腿上的物品.
     * <p>
     * 原文:
     * Sets the item currently being worn
     * by the armor stand on its legs
     *
     * @param item 穿戴的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#setLeggings(org.bukkit.inventory.ItemStack)}
     */
    @Deprecated(since = "1.15.2")
    void setLeggings(@Nullable ItemStack item);

    /**
     * 返回盔甲架当前穿在胸上的物品.
     * <p>
     * 原文:
     * Returns the item currently being worn by the armor stand on its chest
     *
     * @return 穿戴的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#getChestplate()}
     */
    @NotNull
    @Deprecated(since = "1.15.2")
    ItemStack getChestplate();

    /**
     * 设置盔甲架当前穿在胸上的物品.
     * <p>
     * 原文:
     * Sets the item currently being worn by the armor stand on its chest
     *
     * @param item 穿戴的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#setChestplate(org.bukkit.inventory.ItemStack)}
     */
    @Deprecated(since = "1.15.2")
    void setChestplate(@Nullable ItemStack item);

    /**
     * 返回盔甲架当前戴在头上的物品.
     * <p>
     * 原文:
     * Returns the item currently being worn by the armor stand on its head
     *
     * @return 穿戴的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#getHelmet()}
     */
    @NotNull
    @Deprecated(since = "1.15.2")
    ItemStack getHelmet();

    /**
     * 设置盔甲架当前戴在头上的物品.
     * <p>
     * 原文:
     * Sets the item currently being worn by the armor stand on its head
     *
     * @param item 穿戴的物品
     * @see #getEquipment()
     * @deprecated(since = "1.15.2") 建议使用 {@link EntityEquipment#setHelmet(org.bukkit.inventory.ItemStack)}
     */
    @Deprecated(since = "1.15.2")
    void setHelmet(@Nullable ItemStack item);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架身体的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's body's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @return 当前姿势
     */
    @NotNull
    EulerAngle getBodyPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架身体的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's body's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @param pose 当前姿势
     */
    void setBodyPose(@NotNull EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架左臂的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's left arm's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @return 当前姿势
     */
    @NotNull
    EulerAngle getLeftArmPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架左臂的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's left arm's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @param pose 当前姿势
     */
    void setLeftArmPose(@NotNull EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架右臂的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's right arm's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @return 当前姿势
     */
    @NotNull
    EulerAngle getRightArmPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架右臂的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's right arm's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @param pose 当前姿势
     */
    void setRightArmPose(@NotNull EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架左腿的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's left leg's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @return 当前姿势
     */
    @NotNull
    EulerAngle getLeftLegPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架身左腿的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's left leg's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @param pose 当前姿势
     */
    void setLeftLegPose(@NotNull EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架右腿的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's right leg's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @return 当前姿势
     */
    @NotNull
    EulerAngle getRightLegPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架右腿的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's right leg's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @param pose 当前姿势
     */
    void setRightLegPose(@NotNull EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架头的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's head's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @return 当前姿势
     */
    @NotNull
    EulerAngle getHeadPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架头的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's head's current pose as a
     * {@link org.bukkit.util.EulerAngle}.
     *
     * @param pose 当前姿势
     */
    void setHeadPose(@NotNull EulerAngle pose);

    /**
     * 返回盔甲架是否有底盘.
     * <p>
     * 原文:
     * Returns whether the armor stand has a base plate
     *
     * @return 是否有底盘
     */
    boolean hasBasePlate();

    /**
     * 设置盔甲架是否有底盘.
     * <p>
     * 原文:
     * Sets whether the armor stand has a base plate
     *
     * @param basePlate 是否有底盘
     */
    void setBasePlate(boolean basePlate);

    /**
     * 返回盔甲架是否可视.
     * <p>
     * 原文:
     * Returns whether the armor stand should be visible or not
     *
     * @return 盔甲架是否可视
     */
    boolean isVisible();

    /**
     * 设置盔甲架是否可视.
     * <p>
     * 原文:
     * Sets whether the armor stand should be visible or not
     *
     * @param visible 盔甲架是否可视
     */
    void setVisible(boolean visible);

    /**
     * 返回盔甲架是否有双臂.
     * <p>
     * 原文:
     * Returns whether this armor stand has arms.
     *
     * @return 是否有双臂
     */
    boolean hasArms();

    /**
     * 设置盔甲架是否有双臂.
     * <p>
     * 原文:
     * Sets whether this armor stand has arms.
     *
     * @param arms 是否有双臂
     */
    void setArms(boolean arms);

    /**
     * 返回盔甲架是否被缩小了.
     * <p>
     * 原文:
     * Returns whether this armor stand is scaled down.
     *
     * @return 是否被缩小
     */
    boolean isSmall();

    /**
     * 设置盔甲架是否被缩小.
     * <p>
     * 原文:
     * Sets whether this armor stand is scaled down.
     *
     * @param small 是否被缩小
     */
    void setSmall(boolean small);

    /**
     * 返回盔甲架的marker属性，即是否具有非常小的碰撞箱.
     * <p>
     * 原文:
     * Returns whether this armor stand is a marker, meaning it has a very small
     * collision box.
     *
     * @return 盔甲架的marker属性
     */
    boolean isMarker();

    /**
     * 设置盔甲架的marker属性，即是否具有非常小的碰撞箱.
     * <p>
     * 原文:
     * Sets whether this armor stand is a marker, meaning it has a very small
     * collision box.
     *
     * @param marker 盔甲架的marker属性
     */
    void setMarker(boolean marker);

    /**
     * 使用指定的 {@link LockType 锁定机制} 锁定装备槽位.
     * <p>
     * 原文:
     * Locks the equipment slot with the specified
     * {@link LockType locking mechanism}.
     *
     * @param slot 要锁定的装备槽位
     * @param lockType 用于锁定装备槽位的 LockType
     */
    void addEquipmentLock(@NotNull EquipmentSlot slot, @NotNull LockType lockType);

    /**
     * 移除 {@link LockType 锁定机制}.
     * <p>
     * 原文:
     * Remove a {@link LockType locking mechanism}.
     *
     * @param slot 要更改的装备槽位
     * @param lockType 要移除的 LockType
     */
    void removeEquipmentLock(@NotNull EquipmentSlot slot, @NotNull LockType lockType);

    /**
     * 返回此盔甲架是否具有指定的 {@link LockType 锁定机制}.
     * <p>
     * 原文:
     * Returns if the ArmorStand has the specified
     * {@link LockType locking mechanism}.
     *
     * @param slot 要检测的装备槽位
     * @param lockType 要检测的 LockType
     * @return 此盔甲架是否已被指定参数锁定
     */
    boolean hasEquipmentLock(@NotNull EquipmentSlot slot, @NotNull LockType lockType);

    /**
     * 代表盔甲架装备的锁定机制类型.
     */
    public enum LockType {

        /**
         * 阻止添加或更改相应装备 - 玩家无法用新物品替换空槽位,
         * 也无法在自身与盔甲架之间交换物品.
         */
        ADDING_OR_CHANGING,
        /**
         * 阻止移除或更改相应装备 - 玩家无法从槽位取出物品,
         * 也无法在自身与盔甲架之间交换物品.
         */
        REMOVING_OR_CHANGING,
        /**
         * 阻止添加相应装备 - 玩家无法用新物品替换空槽位,
         * 但可以在自身与盔甲架之间交换物品.
         */
        ADDING;
    }
}