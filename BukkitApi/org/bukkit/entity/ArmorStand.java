package org.bukkit.entity;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public interface ArmorStand extends LivingEntity {

    /**
     * 返回盔甲架当前握持的物品.
     * <p>
     * 原文:
     * Returns the item the armor stand is
     * currently holding
     *
     * @return 盔甲架当前握持的物品
     */
    ItemStack getItemInHand();

    /**
     * 设置盔甲架当前握持的物品.
     * <p>
     * 原文:
     * Sets the item the armor stand is currently
     * holding
     *
     * @param item 盔甲架当前握持的物品
     */
    void setItemInHand(ItemStack item);

    /**
     * 返回盔甲架当前穿在脚上的物品.
     * <p>
     * 原文:
     * Returns the item currently being worn
     * by the armor stand on its feet
     *
     * @return 穿戴的物品
     */
    ItemStack getBoots();

    /**
     * 设置盔甲架当前穿在脚上的物品.
     * <p>
     * 原文:
     * Sets the item currently being worn
     * by the armor stand on its feet
     *
     * @param item 穿戴的物品
     */
    void setBoots(ItemStack item);

    /**
     * 返回盔甲架当前穿在腿上的物品.
     * <p>
     * 原文:
     * Returns the item currently being worn
     * by the armor stand on its legs
     *
     * @return 穿戴的物品
     */
    ItemStack getLeggings();

    /**
     * 设置盔甲架当前穿在腿上的物品.
     * <p>
     * 原文:
     * Sets the item currently being worn
     * by the armor stand on its legs
     *
     * @param item 穿戴的物品
     */
    void setLeggings(ItemStack item);

    /**
     * 返回盔甲架当前穿在胸上的物品.
     * <p>
     * 原文:
     * Returns the item currently being worn
     * by the armor stand on its chest
     *
     * @return 穿戴的物品
     */
    ItemStack getChestplate();

    /**
     * 设置盔甲架当前穿在胸上的物品.
     * <p>
     * 原文:
     * Sets the item currently being worn
     * by the armor stand on its chest
     *
     * @param item 穿戴的物品
     */
    void setChestplate(ItemStack item);

    /**
     * 返回盔甲架当前戴在头上的物品.
     * <p>
     * 原文:
     * Returns the item currently being worn
     * by the armor stand on its head
     *
     * @return 穿戴的物品
     */
    ItemStack getHelmet();

    /**
     * 设置盔甲架当前戴在头上的物品.
     * <p>
     * 原文:
     * Sets the item currently being worn
     * by the armor stand on its head
     *
     * @param item 穿戴的物品
     */
    void setHelmet(ItemStack item);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架身体的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's body's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @return 当前姿势
     */
    EulerAngle getBodyPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架身体的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's body's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @param pose 当前姿势
     */
    void setBodyPose(EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架左臂的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's left arm's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @return 当前姿势
     */
    EulerAngle getLeftArmPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架左臂的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's left arm's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @param pose 当前姿势
     */
    void setLeftArmPose(EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架右臂的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's right arm's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @return 当前姿势
     */
    EulerAngle getRightArmPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架右臂的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's right arm's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @param pose 当前姿势
     */
    void setRightArmPose(EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架左腿的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's left leg's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @return 当前姿势
     */
    EulerAngle getLeftLegPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架身左腿的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's left leg's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @param pose 当前姿势
     */
    void setLeftLegPose(EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架右腿的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's right leg's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @return 当前姿势
     */
    EulerAngle getRightLegPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架右腿的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's right leg's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @param pose 当前姿势
     */
    void setRightLegPose(EulerAngle pose);

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式返回盔甲架头的姿势.
     * <p>
     * 原文:
     * Returns the armor stand's head's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @return 当前姿势
     */
    EulerAngle getHeadPose();

    /**
     * 以{@link org.bukkit.util.EulerAngle}的形式设置盔甲架头的姿势.
     * <p>
     * 原文:
     * Sets the armor stand's head's
     * current pose as a {@link org.bukkit.util.EulerAngle}
     *
     * @param pose 当前姿势
     */
    void setHeadPose(EulerAngle pose);

    /**
     * 返回盔甲架是否有底盘.
     * <p>
     * 原文:
     * Returns whether the armor stand has
     * a base plate
     *
     * @return 是否有底盘
     */
    boolean hasBasePlate();

    /**
     * 设置盔甲架是否有底盘.
     * <p>
     * 原文:
     * Sets whether the armor stand has a
     * base plate
     *
     * @param basePlate 是否有底盘
     */
    void setBasePlate(boolean basePlate);

    /**
     * 返回盔甲架是否可视.
     * <p>
     * 原文:
     * Returns whether the armor stand should be
     * visible or not
     *
     * @return 盔甲架是否可视
     */
    boolean isVisible();

    /**
     * 设置盔甲架是否可视.
     * <p>
     * 原文:
     * Sets whether the armor stand should be
     * visible or not
     *
     * @param visible 盔甲架是否可视
     */
    void setVisible(boolean visible);

    /**
     * 返回盔甲架是否有双臂.
     * <p>
     * 原文:
     * Returns whether this armor stand has arms
     *
     * @return 是否有双臂
     */
    boolean hasArms();

    /**
     * 设置盔甲架是否有双臂.
     * <p>
     * 原文:
     * Sets whether this armor stand has arms
     *
     * @param arms 是否有双臂
     */
    void setArms(boolean arms);

    /**
     * 返回盔甲架是否被缩小了.
     * <p>
     * 原文:
     * Returns whether this armor stand is scaled
     * down
     *
     * @return 是否被缩小
     */
    boolean isSmall();

    /**
     * 设置盔甲架是否被缩小.
     * <p>
     * 原文:
     * Sets whether this armor stand is scaled
     * down
     *
     * @param small 是否被缩小
     */
    void setSmall(boolean small);

    /**
     * 返回盔甲架的marker属性，即是否具有非常小的碰撞箱.
     * <p>
     * 原文:
     * Returns whether this armor stand is a marker,
     * meaning it has a very small collision box
     *
     * @return 盔甲架的marker属性
     */
    boolean isMarker();

    /**
     * 设置盔甲架的marker属性，即是否具有非常小的碰撞箱.
     * <p>
     * 原文:
     * Sets whether this armor stand is a marker,
     * meaning it has a very small collision box
     *
     * @param marker 盔甲架的marker属性
     */
    void setMarker(boolean marker);
}