package org.bukkit.inventory.meta.components;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;

/**
 * 表示一个决定使用此物品时属性的组件。
 */
@ApiStatus.Experimental
public interface UseEffectsComponent extends ConfigurationSerializable {

    /**
     * 获取玩家在使用此物品时是否可以冲刺。
     * <p>原文：Gets whether the player can sprint while using this item.
     *
     * @return 玩家是否可以冲刺
     */
    boolean canSprint();

    /**
     * 设置玩家在使用此物品时是否可以冲刺。
     * <p>原文：Sets whether the player can sprint while using this item.
     *
     * @param sprint 玩家是否可以冲刺
     */
    void setCanSprint(boolean sprint);

    /**
     * 获取使用此物品是否会触发振动。
     * <p>原文：Gets whether using this item will trigger vibrations.
     *
     * @return 使用是否会触发振动
     */
    boolean isInteractVibrations();

    /**
     * 设置使用此物品是否会触发振动。
     * <p>原文：Sets whether using this item will trigger vibrations.
     *
     * @param interactVibrations 使用是否会触发振动
     */
    void setInteractVibrations(boolean interactVibrations);

    /**
     * 获取使用此物品时应用于玩家的速度倍率。
     * <p>原文：Gets the speed multiplier applied to the player while using this item.
     *
     * @return 速度倍率
     */
    float getSpeedMultiplier();

    /**
     * 设置使用此物品时应用于玩家的速度倍率。
     * <p>原文：Sets the speed multiplier applied to the player while using this item.
     *
     * @param multiplier 新的倍率
     */
    void setSpeedMultiplier(float multiplier);
}
