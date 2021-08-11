package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表药水和有自定义药水效果的物品.
 */
public interface PotionMeta extends ItemMeta {

    /**
     * 设置基础药水(主药水)的数据.
     * <p>
     * 原文:
     * Sets the underlying potion data
     *
     * @param data 基础药水数据
     */
    void setBasePotionData(@NotNull PotionData data);

    /**
     * 返回关于这个基础药水(主药水)的药水数据.
     * <p>
     * 原文:
     * Returns the potion data about the base potion
     *
     * @return PotionData 对象
     */
    @NotNull
    PotionData getBasePotionData();

    /**
     * 检测这个药水是否存在药水效果.
     * <p>
     * 原文:
     * Checks for the presence of custom potion effects.
     *
     * @return 这个药水是否存在药水效果
     */
    boolean hasCustomEffects();

    /**
     * 获取这个药水的全部自定义效果.
     * <p>
     * 插件应该在调用这个方法之前检查 hasCustomEffects() 是否返回 true.
     * <p>
     * 原文:
     * Gets an immutable list containing all custom potion effects applied to
     * this potion.
     * <p>
     * Plugins should check that hasCustomEffects() returns true before
     * calling this method.
     *
     * @return 自定义效果列表 (不可变)
     */
    @NotNull
    List<PotionEffect> getCustomEffects();

    /**
     * 向此药水添加一个自定义药水效果.
     * <p>
     * 原文:
     * Adds a custom potion effect to this potion.
     *
     * @param effect 要添加的药水效果
     * @param overwrite 如要覆盖已有的同类药水效果就设为 true
     * @return 如果药水的属性改变了则为 true
     */
    boolean addCustomEffect(@NotNull PotionEffect effect, boolean overwrite);

    /**
     * 移除这个药水的一个自定义效果.
     * <p>
     * 原文:
     * Removes a custom potion effect from this potion.
     *
     * @param type 要移除的药水效果类型
     * @return 如果药水的属性改变了则为 true
     */
    boolean removeCustomEffect(@NotNull PotionEffectType type);

    /**
     * 检查这个药水是否有指定的药水效果.
     * <p>
     * 原文:
     * Checks for a specific custom potion effect type on this potion.
     * 
     * @param type 要检查的药水效果
     * @return 存在此药水效果则返回 true
     */
    boolean hasCustomEffect(@NotNull PotionEffectType type);

    /**
     * 移动一个药水效果至这个药水效果列表的顶端.
     * <p>
     * 这将会使客户端上的药水名称显示成设置的药水效果.
     * <p>
     * 译注: 第一句不好理解? 比如有三个效果, 有个效果在最后面是最主要的效果, 我们就可以把这个效果移动到最顶上, 这样玩家第一眼看到的就是这个效果啦.
     * <p>
     * 原文:
     * Moves a potion effect to the top of the potion effect list.
     * <p>
     * This causes the client to display the potion effect in the potion's
     * name.
     *
     * @param type 要移动的药水效果
     * @return 如果药水的属性改变了则为 true
     * @deprecated 请使用 {@link #setBasePotionData(org.bukkit.potion.PotionData)}
     */
    @Deprecated
    boolean setMainEffect(@NotNull PotionEffectType type);

    /**
     * 移除这个药水的全部自定义药水效果.
     * <p>
     * 原文:
     * Removes all custom potion effects from this potion.
     *
     * @return 如果药水的属性改变了则为 true
     */
    boolean clearCustomEffects();


    /**
     * 检查药水是否设置了自定义颜色.
     * <p>
     * 原文:
     * Checks for existence of a potion color.
     *
     * @return 是否设置了自定义颜色
     */
    boolean hasColor();

    /**
     * 获取为这瓶药水设置的颜色. 此颜色可在物品栏中药水物品的格子内观察到.
     * <p>
     * 插件应该在调用这个方法之前检查 hasColor() 是否返回 <code>true</code>.
     * <p>
     * 原文:
     * Gets the potion color that is set. A custom potion color will alter the
     * display of the potion in an inventory slot.
     * <p>
     * Plugins should check that hasColor() returns <code>true</code> before
     * calling this method.
     *
     * @return 药水颜色
     */
    @Nullable
    Color getColor();

    /**
     * 设置药水的颜色. 此颜色可在物品栏中药水物品的格子内观察到.
     * <p>
     * 原文:
     * Sets the potion color. A custom potion color will alter the display of
     * the potion in an inventory slot.
     *
     * @param color 颜色
     */
    void setColor(@Nullable Color color);

    @Override
    PotionMeta clone();
}