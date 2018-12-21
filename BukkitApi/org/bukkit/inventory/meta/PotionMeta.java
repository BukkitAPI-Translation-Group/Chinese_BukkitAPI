package org.bukkit.inventory.meta;

import org.bukkit.Color;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionData;

import java.util.List;

/**
 * 代表药水和有自定义药水效果的物品.
 */
public interface PotionMeta extends ItemMeta {

    /**
     * 设置基础药水数据.
     * <p>
     * 原文:Sets the underlying potion data
     *
     * @param data PotionData设置基础药水状态的PotionData
     */
    void setBasePotionData(PotionData data);

    /**
     * 返回关于这个基础药水的药水数据.
     * <p>
     * 原文:Returns the potion data about the base potion
     *
     * @return PotionData对象
     */
    PotionData getBasePotionData();

    /**
     * 检测这个药水是否存在药水效果.
     * <p>
     * 原文：Checks for the presence of custom potion effects.
     *
     * @return 这个药水是否存在药水效果
     */
    boolean hasCustomEffects();

    /**
     * 获取包含了这个药水存在的所有药水效果的一个不可变的列表.
     * <p>
     * 插件应该在调用这个方法之前检查hasCustomEffects()是否返回true.
     * <p>
     * 原文：Gets an immutable list containing all custom potion effects applied to
     * this potion.
     * <p>
     * Plugins should check that hasCustomEffects() returns true before
     * calling this method.
     *
     * @return 所有药水效果的不可变列表
     */
    List<PotionEffect> getCustomEffects();

    /**
     * 添加一个自定义药水效果到这个药水上.
     * <p>
     * 原文：Adds a custom potion effect to this potion.
     *
     * @param effect 要添加的药水效果
     * @param overwrite 如果有相同类型的效果存在想要覆盖就设为true
     * @return 如果药水的属性改变了则为true
     */
    boolean addCustomEffect(PotionEffect effect, boolean overwrite);

    /**
     * 移除这个药水的一个自定义效果.
     * <p>
     * 原文：Removes a custom potion effect from this potion.
     *
     * @param type 要移除的药水效果类型
     * @return 如果药水的属性改变了则为true
     */
    boolean removeCustomEffect(PotionEffectType type);

    /**
     * Checks for a specific custom potion effect type on this potion.
     * 
     * @param type the potion effect type to check for
     * @return true if the potion has this effect
     */
    boolean hasCustomEffect(PotionEffectType type);

    /**
     * 移动一个药水效果至这个药水效果列表的顶端.
     * <p>
     * 这将会使客户端上的药水名称显示成设置的药水效果.
     * <p>
     * 译注：第一句不好理解？比如有三个效果，有个效果在最后面是最主要的效果，我们就可以把这个效果移动到最顶上，这样玩家第一眼看到的就是这个效果啦.
     * <p>
     * 原文：Moves a potion effect to the top of the potion effect list.
     * <p>
     * This causes the client to display the potion effect in the potion's
     * name.
     *
     * @param type 要移动的药水效果
     * @return 如果药水的属性改变了则为true
     * @deprecated 请使用 {@link org.bukkit.potion.PotionType#PotionType}
     */
    @Deprecated
    boolean setMainEffect(PotionEffectType type);

    /**
     * 移除这个药水的全部自定义药水效果.
     * <p>
     * 原文：Removes all custom potion effects from this potion.
     *
     * @return 如果药水的属性改变了则为true
     */
    boolean clearCustomEffects();


    /**
     * Checks for existence of a potion color.
     *
     * @return true if this has a custom potion color
     */
    boolean hasColor();

    /**
     * Gets the potion color that is set. A custom potion color will alter the
     * display of the potion in an inventory slot.
     * <p>
     * Plugins should check that hasColor() returns <code>true</code> before
     * calling this method.
     *
     * @return the potion color that is set
     */
    Color getColor();

    /**
     * Sets the potion color. A custom potion color will alter the display of
     * the potion in an inventory slot.
     *
     * @param color the color to set
     */
    void setColor(Color color);

    @Override
    PotionMeta clone();
}