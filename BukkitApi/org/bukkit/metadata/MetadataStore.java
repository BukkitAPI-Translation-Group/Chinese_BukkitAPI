package org.bukkit.metadata;

import java.util.List;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface MetadataStore<T> {
    /**
     * 向对象添加元数据值.
     * <p>
     * 原文：
     * Adds a metadata value to an object.
     *
     * @param subject 接收元数据的对象.
     * @param metadataKey 用于标识此元数据的唯一键.
     * @param newMetadataValue 要应用的元数据值.
     * @throws IllegalArgumentException 如果值为null, 或拥有插件为null
     */
    public void setMetadata(@NotNull T subject, @NotNull String metadataKey, @NotNull MetadataValue newMetadataValue);

    /**
     * 返回附加到对象的所有元数据值. 如果多个插件附加了元数据, 每个值都将被包含.
     * <p>
     * 原文：
     * Returns all metadata values attached to an object. If multiple plugins
     * have attached metadata, each will value will be included.
     *
     * @param subject 正在查询的对象.
     * @param metadataKey 正在查找的唯一元数据键.
     * @return 值列表, 每个设置了请求值的插件一个.
     */
    @NotNull
    public List<MetadataValue> getMetadata(@NotNull T subject, @NotNull String metadataKey);

    /**
     * 测试对象上是否设置了元数据属性.
     * <p>
     * 原文：
     * Tests to see if a metadata attribute has been set on an object.
     *
     * @param subject 执行has-metadata测试的对象.
     * @param metadataKey 正在查询的唯一元数据键.
     * @return metadataKey在主体中的存在性.
     */
    public boolean hasMetadata(@NotNull T subject, @NotNull String metadataKey);

    /**
     * 从主体中移除插件拥有的元数据项.
     * <p>
     * 原文：
     * Removes a metadata item owned by a plugin from a subject.
     *
     * @param subject 要从中移除元数据的对象.
     * @param metadataKey 标识要移除元数据的唯一元数据键.
     * @param owningPlugin 尝试移除元数据项的插件.
     * @throws IllegalArgumentException 如果插件为null
     */
    public void removeMetadata(@NotNull T subject, @NotNull String metadataKey, @NotNull Plugin owningPlugin);

    /**
     * 使元数据存储中来自给定插件的所有元数据无效. 这将强制每个无效的元数据项在下次访问时重新计算.
     * <p>
     * 原文：
     * Invalidates all metadata in the metadata store that originates from the
     * given plugin. Doing this will force each invalidated metadata item to
     * be recalculated the next time it is accessed.
     *
     * @param owningPlugin 请求无效化的插件.
     * @throws IllegalArgumentException 如果插件为null
     */
    public void invalidateAll(@NotNull Plugin owningPlugin);
}
