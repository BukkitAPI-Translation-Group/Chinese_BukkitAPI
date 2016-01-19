package org.bukkit.metadata;

import org.bukkit.plugin.Plugin;

import java.util.List;

public interface MetadataStore<T> {
    /**
     * 向对象添加元数据值。
     * 原文：Adds a metadata value to an object.
     *
     * @param subject 接收元数据的对象.
     * @param metadataKey 确定这个元数据的唯一关键值。
     * @param newMetadataValue 应用元数据。
     * @throws IllegalArgumentException 如果值为空，或该插件是空的，抛出此异常。
     */
    public void setMetadata(T subject, String metadataKey, MetadataValue newMetadataValue);

    /**
     * 返回连接到对象的所有元数据值。如果多个插件附加元数据，每一个都将被包括在内。
     * 原文：Returns all metadata values attached to an object. If multiple plugins
     * have attached metadata, each will value will be included.
     *
     * @param subject 被访问的对象。
     * @param metadataKey 正在访问这个元数据的唯一关键值。
     * @return 一个为每个插件设置请求的值的列表。
     */
    public List<MetadataValue> getMetadata(T subject, String metadataKey);

    /**
     * 测试是否已将元数据的属性设置为对象。
     * 原文：Tests to see if a metadata attribute has been set on an object.
     *
     * @param subject 进行元数据测试的对象。
     * @param metadataKey 正在访问这个元数据的唯一关键值。
     * @return the existence of the metadataKey within subject.在主体内metadataKey是否存在。
     */
    public boolean hasMetadata(T subject, String metadataKey);

    /**
     * 删除由一个主体所拥有的一个插件所拥有的元数据项。
     * 原文：Removes a metadata item owned by a plugin from a subject.
     *
     * @param subject 删除元数据的对象。
     * @param metadataKey 识别元数据的唯一关键值并删除。
     * @param owningPlugin 从插件内试图删除元数据项。
     * @throws IllegalArgumentException 如果插件不存在，抛出该异常。
     */
    public void removeMetadata(T subject, String metadataKey, Plugin owningPlugin);

    /**
     * 无效的元数据会存储于特定插件的所有元数据。这样做会使得当下次访问它时，每一个无效的元数据将重新计算。
     * 原文：Invalidates all metadata in the metadata store that originates from the
     * given plugin. Doing this will force each invalidated metadata item to
     * be recalculated the next time it is accessed.
     *
     * @param owningPlugin 访问无效的插件。
     * @throws IllegalArgumentException 如果插件不存在，抛出该异常。
     */
    public void invalidateAll(Plugin owningPlugin);
}