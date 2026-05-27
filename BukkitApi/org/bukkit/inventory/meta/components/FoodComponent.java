package org.bukkit.inventory.meta.components;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.meta.components.consumable.ConsumableComponent;
import org.jetbrains.annotations.ApiStatus;

/**
 * 表示一个可以处理任何物品食物属性的组件。
 * <br>
 * <b>注意：</b>除非物品可以被消耗，否则具有食物属性的物品无效，参见 {@link ConsumableComponent}。
 */
@ApiStatus.Experimental
public interface FoodComponent extends ConfigurationSerializable {

    /**
     * 获取食用此物品时恢复的食物值。
     * <p>原文：Gets the food restored by this item when eaten.
     *
     * @return 营养值
     */
    int getNutrition();

    /**
     * 设置食用此物品时恢复的食物值。
     * <p>原文：Sets the food restored by this item when eaten.
     *
     * @param nutrition 新的营养值，必须为非负数
     */
    void setNutrition(int nutrition);

    /**
     * 获取食用此物品时恢复的饱和度。
     * <p>原文：Gets the saturation restored by this item when eaten.
     *
     * @return 饱和度值
     */
    float getSaturation();

    /**
     * 设置食用此物品时恢复的饱和度。
     * <p>原文：Sets the saturation restored by this item when eaten.
     *
     * @param saturation 新的饱和度值
     */
    void setSaturation(float saturation);

    /**
     * 获取此物品是否可以在不饥饿时食用。
     * <p>原文：Gets if this item can be eaten even when not hungry.
     *
     * @return 如果总是可食用则返回true
     */
    boolean canAlwaysEat();

    /**
     * 设置此物品是否可以在不饥饿时食用。
     * <p>原文：Sets if this item can be eaten even when not hungry.
     *
     * @param canAlwaysEat 是否总是可食用
     */
    void setCanAlwaysEat(boolean canAlwaysEat);
}
