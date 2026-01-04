package org.bukkit.inventory.meta.components;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个用于添加自定义模型数据的组件.
 * <p>
 * 译注：该组件用于为物品指定更复杂的客户端模型替换规则，替代旧版简单的整数型 customModelData。
 * 它可以定义基于范围(range_dispatch)、条件(condition)、选择(select)等不同模型类型的参数。
 * <p>
 * 更多有关“自定义模型数据”的细节，请阅 <a href="https://zh.minecraft.wiki/w/%E6%95%B0%E6%8D%AE%E7%BB%84%E4%BB%B6#custom_model_data" target="_blank">Minecraft
 * Wiki - 数据组件</a>。
 * <p>
 * 原文:
 * Represents a component which adds custom model data.
 */
@ApiStatus.Experimental
public interface CustomModelDataComponent extends ConfigurationSerializable {

    /**
     * 获取用于范围分发模型类型的浮点数列表.
     * <p>
     * 译注：范围分发(range_dispatch)模型类型允许客户端根据浮点数值选择不同的模型，常用于如耐久度百分比等连续值。
 * <p>
     * 原文:
     * Gets a list of the floats for the range_dispatch model type.
     *
     * @return 不可修改的列表
     */
    @NotNull
    List<Float> getFloats();

    /**
     * 设置用于范围分发模型类型的浮点数列表.
     * <p>
     * 原文:
     * Sets a list of the floats for the range_dispatch model type.
     *
     * @param floats 新的浮点数列表
     */
    void setFloats(@NotNull List<Float> floats);

    /**
     * 获取用于条件模型类型的布尔值列表.
     * <p>
     * 译注：条件(condition)模型类型根据布尔值(true/false)来选择模型，例如物品是否被附魔、是否有特定NBT标签等。
 * <p>
     * 原文:
     * Gets a list of the booleans for the condition model type.
     *
     * @return 不可修改的列表
     */
    @NotNull
    List<Boolean> getFlags();

    /**
     * 设置用于条件模型类型的布尔值列表.
     * <p>
     * 原文:
     * Sets a list of the booleans for the condition model type.
     *
     * @param flags 新的布尔值列表
     */
    void setFlags(@NotNull List<Boolean> flags);

    /**
     * 获取用于选择模型类型的字符串列表.
     * <p>
     * 译注：选择(select)模型类型根据字符串键从一组预定义模型中选择，常用于如不同变体（颜色、材质）的物品。
 * <p>
     * 原文:
     * Gets a list of strings for the select model type.
     *
     * @return 不可修改的列表
     */
    @NotNull
    List<String> getStrings();

    /**
     * 设置用于选择模型类型的字符串列表.
     * <p>
     * 原文:
     * Sets a list of strings for the select model type.
     *
     * @param strings 新的字符串列表
     */
    void setStrings(@NotNull List<String> strings);

    /**
     * 获取用于模型类型色调的颜色列表.
     * <p>
     * 译注：此颜色列表用于对模型应用色调覆盖，例如为同一模型的不同实例染上不同颜色。
 * <p>
     * 原文:
     * Gets a list of colors for the model type's tints.
     *
     * @return 不可修改的列表
     */
    @NotNull
    List<Color> getColors();

    /**
     * 设置用于模型类型色调的颜色列表.
     * <p>
     * 原文:
     * Sets a list of colors for the model type's tints.
     *
     * @param colors 新的颜色列表
     */
    void setColors(@NotNull List<Color> colors);
}
