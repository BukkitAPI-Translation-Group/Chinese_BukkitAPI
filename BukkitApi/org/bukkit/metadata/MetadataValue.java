package org.bukkit.metadata;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MetadataValue {

    /**
     * 获取此元数据项的值.
     * <p>
     * 原文：
     * Fetches the value of this metadata item.
     *
     * @return 元数据值.
     */
    @Nullable
    public Object value();

    /**
     * 尝试将此元数据项的值转换为int.
     * <p>
     * 原文：
     * Attempts to convert the value of this metadata item into an int.
     *
     * @return int类型的值.
     */
    public int asInt();

    /**
     * 尝试将此元数据项的值转换为float.
     * <p>
     * 原文：
     * Attempts to convert the value of this metadata item into a float.
     *
     * @return float类型的值.
     */
    public float asFloat();

    /**
     * 尝试将此元数据项的值转换为double.
     * <p>
     * 原文：
     * Attempts to convert the value of this metadata item into a double.
     *
     * @return double类型的值.
     */
    public double asDouble();

    /**
     * 尝试将此元数据项的值转换为long.
     * <p>
     * 原文：
     * Attempts to convert the value of this metadata item into a long.
     *
     * @return long类型的值.
     */
    public long asLong();

    /**
     * 尝试将此元数据项的值转换为short.
     * <p>
     * 原文：
     * Attempts to convert the value of this metadata item into a short.
     *
     * @return short类型的值.
     */
    public short asShort();

    /**
     * 尝试将此元数据项的值转换为byte.
     * <p>
     * 原文：
     * Attempts to convert the value of this metadata item into a byte.
     *
     * @return byte类型的值.
     */
    public byte asByte();

    /**
     * 尝试将此元数据项的值转换为boolean.
     * <p>
     * 原文：
     * Attempts to convert the value of this metadata item into a boolean.
     *
     * @return boolean类型的值.
     */
    public boolean asBoolean();

    /**
     * 尝试将此元数据项的值转换为字符串.
     * <p>
     * 原文：
     * Attempts to convert the value of this metadata item into a string.
     *
     * @return 字符串类型的值.
     */
    @NotNull
    public String asString();

    /**
     * 返回创建此元数据项的{@link Plugin}.
     * <p>
     * 原文：
     * Returns the {@link Plugin} that created this metadata item.
     *
     * @return 拥有此元数据值的插件. 如果插件已被卸载则可能为null.
     */
    @Nullable
    public Plugin getOwningPlugin();

    /**
     * 使此元数据项无效, 强制其在下次访问时重新计算.
     * <p>
     * 原文：
     * Invalidates this metadata item, forcing it to recompute when next
     * accessed.
     */
    public void invalidate();
}
