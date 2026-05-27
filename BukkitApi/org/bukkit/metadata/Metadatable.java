package org.bukkit.metadata;

import java.util.List;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 此接口由所有可以提供关于自身元数据的对象实现.
 */
public interface Metadatable {
    /**
     * 在实现对象的元数据存储中设置元数据值.
     * <p>
     * 原文：
     * Sets a metadata value in the implementing object's metadata store.
     *
     * @param metadataKey 用于标识此元数据的唯一键.
     * @param newMetadataValue 要应用的元数据值.
     * @throws IllegalArgumentException 如果值为null, 或拥有插件为null
     */
    public void setMetadata(@NotNull String metadataKey, @NotNull MetadataValue newMetadataValue);

    /**
     * 从实现对象的元数据存储中返回先前设置的元数据值列表.
     * <p>
     * 原文：
     * Returns a list of previously set metadata values from the implementing
     * object's metadata store.
     *
     * @param metadataKey 正在查找的唯一元数据键.
     * @return 值列表, 每个设置了请求值的插件一个.
     */
    @NotNull
    public List<MetadataValue> getMetadata(@NotNull String metadataKey);

    /**
     * 测试实现对象的元数据存储中是否包含给定的元数据值.
     * <p>
     * 原文：
     * Tests to see whether the implementing object contains the given
     * metadata value in its metadata store.
     *
     * @param metadataKey 正在查询的唯一元数据键.
     * @return metadataKey在主体中的存在性.
     */
    public boolean hasMetadata(@NotNull String metadataKey);

    /**
     * 从实现对象的元数据存储中移除给定的元数据值.
     * <p>
     * 原文：
     * Removes the given metadata value from the implementing object's
     * metadata store.
     *
     * @param metadataKey 标识要移除元数据的唯一元数据键.
     * @param owningPlugin 此插件的元数据值将被移除. 所有其他值将保持不变.
     * @throws IllegalArgumentException 如果插件为null
     */
    public void removeMetadata(@NotNull String metadataKey, @NotNull Plugin owningPlugin);
}
