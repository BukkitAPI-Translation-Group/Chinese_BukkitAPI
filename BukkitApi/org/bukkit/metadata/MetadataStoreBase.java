package org.bukkit.metadata;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public abstract class MetadataStoreBase<T> {
    private Map<String, Map<Plugin, MetadataValue>> metadataMap = new HashMap<String, Map<Plugin, MetadataValue>>();

    /**
     * 向对象添加元数据值. 每个元数据值由特定{@link Plugin}拥有.
     * 如果插件已经向对象添加了元数据值, 该值将被{@code newMetadataValue}的值替换.
     * 多个插件可以为相同的{@code metadataKey}设置独立的值而不会冲突.
     * <p>
     * 实现说明：我考虑使用{@link java.util.concurrent.locks.ReadWriteLock}来控制对{@code metadataMap}的访问,
     * 但认为增加的开销不值得更细粒度的访问控制.
     * <p>
     * Bukkit几乎完全是单线程的, 所以锁定开销应该不会造成问题.
     * <p>
     * 原文：
     * Adds a metadata value to an object. Each metadata value is owned by a
     * specific {@link Plugin}. If a plugin has already added a metadata value
     * to an object, that value will be replaced with the value of {@code
     * newMetadataValue}. Multiple plugins can set independent values for the
     * same {@code metadataKey} without conflict.
     * <p>
     * Implementation note: I considered using a {@link
     * java.util.concurrent.locks.ReadWriteLock} for controlling access to
     * {@code metadataMap}, but decided that the added overhead wasn't worth
     * the finer grained access control.
     * <p>
     * Bukkit is almost entirely single threaded so locking overhead shouldn't
     * pose a problem.
     *
     * @param subject 接收元数据的对象.
     * @param metadataKey 用于标识此元数据的唯一键.
     * @param newMetadataValue 要应用的元数据值.
     * @throws IllegalArgumentException 如果值为null, 或拥有插件为null
     * @see MetadataStore#setMetadata(Object, String, MetadataValue)
     */
    public synchronized void setMetadata(@NotNull T subject, @NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {
        Preconditions.checkArgument(newMetadataValue != null, "Value cannot be null");
        Plugin owningPlugin = newMetadataValue.getOwningPlugin();
        Preconditions.checkArgument(owningPlugin != null, "Plugin cannot be null");
        String key = disambiguate(subject, metadataKey);
        Map<Plugin, MetadataValue> entry = metadataMap.get(key);
        if (entry == null) {
            entry = new WeakHashMap<Plugin, MetadataValue>(1);
            metadataMap.put(key, entry);
        }
        entry.put(owningPlugin, newMetadataValue);
    }

    /**
     * 返回附加到对象的所有元数据值. 如果多个插件附加了元数据, 每个值都将被包含.
     * <p>
     * 原文：
     * Returns all metadata values attached to an object. If multiple
     * have attached metadata, each will value will be included.
     *
     * @param subject 正在查询的对象.
     * @param metadataKey 正在查找的唯一元数据键.
     * @return 值列表, 每个设置了请求值的插件一个.
     * @see MetadataStore#getMetadata(Object, String)
     */
    @NotNull
    public synchronized List<MetadataValue> getMetadata(@NotNull T subject, @NotNull String metadataKey) {
        String key = disambiguate(subject, metadataKey);
        if (metadataMap.containsKey(key)) {
            Collection<MetadataValue> values = metadataMap.get(key).values();
            return Collections.unmodifiableList(new ArrayList<MetadataValue>(values));
        } else {
            return Collections.emptyList();
        }
    }

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
    public synchronized boolean hasMetadata(@NotNull T subject, @NotNull String metadataKey) {
        String key = disambiguate(subject, metadataKey);
        return metadataMap.containsKey(key);
    }

    /**
     * Removes a metadata item owned by a plugin from a subject.
     *
     * @param subject the object to remove the metadata from.
     * @param metadataKey the unique metadata key identifying the metadata to
     *     remove.
     * @param owningPlugin the plugin attempting to remove a metadata item.
     * @throws IllegalArgumentException If plugin is null
     * @see MetadataStore#removeMetadata(Object, String,
     *     org.bukkit.plugin.Plugin)
     */
    public synchronized void removeMetadata(@NotNull T subject, @NotNull String metadataKey, @NotNull Plugin owningPlugin) {
        Preconditions.checkArgument(owningPlugin != null, "Plugin cannot be null");
        String key = disambiguate(subject, metadataKey);
        Map<Plugin, MetadataValue> entry = metadataMap.get(key);
        if (entry == null) {
            return;
        }

        entry.remove(owningPlugin);
        if (entry.isEmpty()) {
            metadataMap.remove(key);
        }
    }

    /**
     * Invalidates all metadata in the metadata store that originates from the
     * given plugin. Doing this will force each invalidated metadata item to
     * be recalculated the next time it is accessed.
     *
     * @param owningPlugin the plugin requesting the invalidation.
     * @throws IllegalArgumentException If plugin is null
     * @see MetadataStore#invalidateAll(org.bukkit.plugin.Plugin)
     */
    public synchronized void invalidateAll(@NotNull Plugin owningPlugin) {
        Preconditions.checkArgument(owningPlugin != null, "Plugin cannot be null");
        for (Map<Plugin, MetadataValue> values : metadataMap.values()) {
            if (values.containsKey(owningPlugin)) {
                values.get(owningPlugin).invalidate();
            }
        }
    }

    /**
     * Creates a unique name for the object receiving metadata by combining
     * unique data from the subject with a metadataKey.
     * <p>
     * The name created must be globally unique for the given object and any
     * two equivalent objects must generate the same unique name. For example,
     * two Player objects must generate the same string if they represent the
     * same player, even if the objects would fail a reference equality test.
     *
     * @param subject The object for which this key is being generated.
     * @param metadataKey The name identifying the metadata value.
     * @return a unique metadata key for the given subject.
     */
    @NotNull
    protected abstract String disambiguate(@NotNull T subject, @NotNull String metadataKey);
}
