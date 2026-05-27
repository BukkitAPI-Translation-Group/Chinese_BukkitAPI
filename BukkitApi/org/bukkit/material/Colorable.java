package org.bukkit.material;

import org.bukkit.DyeColor;
import org.bukkit.UndefinedNullability;
import org.jetbrains.annotations.Nullable;

/**
 * 可以被着色的对象。
 */
public interface Colorable {

    /**
     * 获取此对象的颜色。
     * <br>
     * 如果对象有特殊的默认颜色（例如潜影贝），则返回 null 表示对象的默认颜色。
     *
     * @return 此对象的 DyeColor。
     * <p>
     * 原文：Gets the color of this object.
     */
    @Nullable
    public DyeColor getColor();

    /**
     * 将此对象的颜色设置为指定的 DyeColor。
     * <br>
     * 如果对象有特殊的默认颜色（例如潜影贝），则可以传入 null 表示对象的默认颜色。
     *
     * @param color 对象的颜色，以 DyeColor 表示。
     * @throws NullPointerException 如果参数为 null 且此实现不支持 null
     * <p>
     * 原文：Sets the color of this object to the specified DyeColor.
     */
    public void setColor(@UndefinedNullability("defined by subclass") DyeColor color);

}
