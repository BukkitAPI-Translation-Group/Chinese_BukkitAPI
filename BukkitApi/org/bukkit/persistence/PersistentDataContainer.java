package org.bukkit.persistence;

import java.util.Set;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 此接口表示一个类似映射的对象，能够在其中存储自定义标签。
 */
public interface PersistentDataContainer {

    /**
     * 在 {@link PersistentDataHolder} 实例上存储元数据值。
     * <p>
     * 此 API 不能用于操纵 Minecraft 数据，因为值将使用您的命名空间存储。此方法将覆盖 {@link PersistentDataHolder} 在提供的键下可能已存储的任何现有值。
     * <p>
     * 原文：
     * Stores a metadata value on the {@link PersistentDataHolder} instance.
     * <p>
     * This API cannot be used to manipulate minecraft data, as the values will
     * be stored using your namespace. This method will override any existing
     * value the {@link PersistentDataHolder} may have stored under the provided
     * key.
     *
     * @param key 此值将存储在的键
     * @param type 此标签使用的类型
     * @param value 要存储在标签中的值
     * @param <P> 标签值的通用 Java 类型
     * @param <C> 要存储的对象的通用类型
     *
     * @throws IllegalArgumentException 如果键为 null
     * @throws IllegalArgumentException 如果类型为 null
     * @throws IllegalArgumentException 如果值为 null。移除标签应使用 {@link #remove(NamespacedKey)}
     * @throws IllegalArgumentException 如果没有找到适用于 {@link PersistentDataType#getPrimitiveType()} 的适配器
     */
    <P, C> void set(@NotNull NamespacedKey key, @NotNull PersistentDataType<P, C> type, @NotNull C value);

    /**
     * 返回持久元数据提供者是否注册了匹配所提供参数的元数据。
     * <p>
     * 此方法仅在找到的值与提供的键具有相同原始数据类型时才返回 true。
     * <p>
     * 使用自定义 {@link PersistentDataType} 实现存储值不会存储复杂数据类型。因此，存储 UUID（通过存储 byte[]）将匹配 has("key", {@link PersistentDataType#BYTE_ARRAY})。同样，存储的 byte[] 将始终匹配您的 UUID {@link PersistentDataType}，即使它不是 16 字节长。
     * <p>
     * 此方法仅适用于自定义对象键。覆盖现有标签（如显示名称）将不起作用，因为值使用您的命名空间存储。
     * <p>
     * 原文：
     * Returns if the persistent metadata provider has metadata registered
     * matching the provided parameters.
     * <p>
     * This method will only return true if the found value has the same primitive
     * data type as the provided key.
     * <p>
     * Storing a value using a custom {@link PersistentDataType} implementation
     * will not store the complex data type. Therefore storing a UUID (by
     * storing a byte[]) will match has("key" ,
     * {@link PersistentDataType#BYTE_ARRAY}). Likewise a stored byte[] will
     * always match your UUID {@link PersistentDataType} even if it is not 16
     * bytes long.
     * <p>
     * This method is only usable for custom object keys. Overwriting existing
     * tags, like the display name, will not work as the values are stored
     * using your namespace.
     *
     * @param key 值存储在的键
     * @param type 原始存储值必须匹配的类型
     * @param <P> 存储的原始类型的通用类型
     * @param <C> 最终创建的复杂对象的通用类型
     *
     * @return 是否存在具有所提供键和类型的值
     *
     * @throws IllegalArgumentException 如果要查找的键为 null
     * @throws IllegalArgumentException 如果要转换找到的对象的类型为 null
     */
    <P, C> boolean has(@NotNull NamespacedKey key, @NotNull PersistentDataType<P, C> type);

    /**
     * 返回持久元数据提供者是否注册了匹配所提供参数的元数据。
     * <p>
     * 此方法将返回 true，只要具有给定键的值存在，无论其类型如何。
     * <p>
     * 此方法仅适用于自定义对象键。覆盖现有标签（如显示名称）将不起作用，因为值使用您的命名空间存储。
     * <p>
     * 原文：
     * Returns if the persistent metadata provider has metadata registered matching
     * the provided parameters.
     * <p>
     * This method will return true as long as a value with the given key exists,
     * regardless of its type.
     * <p>
     * This method is only usable for custom object keys. Overwriting existing tags,
     * like the display name, will not work as the values are stored using your
     * namespace.
     *
     * @param key 值存储在的键
     *
     * @return 是否存在具有所提供键的值
     *
     * @throws IllegalArgumentException 如果要查找的键为 null
     */
    boolean has(@NotNull NamespacedKey key);

    /**
     * 返回存储在 {@link PersistentDataHolder} 实例上的元数据值。
     * <p>
     * 原文：
     * Returns the metadata value that is stored on the
     * {@link PersistentDataHolder} instance.
     *
     * @param key 要在自定义标签映射中查找的键
     * @param type 值必须具有并将转换为的类型
     * @param <P> 存储的原始类型的通用类型
     * @param <C> 最终创建的复杂对象的通用类型
     *
     * @return 值，如果没有值映射到给定值下则返回 {@code null}
     *
     * @throws IllegalArgumentException 如果要查找的键为 null
     * @throws IllegalArgumentException 如果要转换找到的对象的类型为 null
     * @throws IllegalArgumentException 如果在给定键下存在值，但无法使用给定类型访问
     * @throws IllegalArgumentException 如果没有找到适用于 {@link PersistentDataType#getPrimitiveType()} 的适配器
     */
    @Nullable
    <P, C> C get(@NotNull NamespacedKey key, @NotNull PersistentDataType<P, C> type);

    /**
     * 返回存储在 {@link PersistentDataHolder} 实例上的元数据值。如果容器中不存在该值，则返回提供的默认值。
     * <p>
     * 原文：
     * Returns the metadata value that is stored on the
     * {@link PersistentDataHolder} instance. If the value does not exist in the
     * container, the default value provided is returned.
     *
     * @param key 要在自定义标签映射中查找的键
     * @param type 值必须具有并将转换为的类型
     * @param defaultValue 如果没有找到所提供键的值，则返回的默认值
     * @param <P> 存储的原始类型的通用类型
     * @param <C> 最终创建的复杂对象的通用类型
     *
     * @return 值，或者如果没有值映射到给定键下则返回默认值
     *
     * @throws IllegalArgumentException 如果要查找的键为 null
     * @throws IllegalArgumentException 如果要转换找到的对象的类型为 null
     * @throws IllegalArgumentException 如果在给定键下存在值，但无法使用给定类型访问
     * @throws IllegalArgumentException 如果没有找到适用于 {@link PersistentDataType#getPrimitiveType()} 的适配器
     */
    @NotNull
    <P, C> C getOrDefault(@NotNull NamespacedKey key, @NotNull PersistentDataType<P, C> type, @NotNull C defaultValue);

    /**
     * 获取此 {@link PersistentDataContainer} 实例上存在的键集。
     * <p>
     * 原文：
     * Get the set of keys present on this {@link PersistentDataContainer}
     * instance.
     *
     * Any changes made to the returned set will not be reflected on the
     * instance.
     *
     * @return 键集
     */
    @NotNull
    Set<NamespacedKey> getKeys();

    /**
     * 从 {@link PersistentDataHolder} 实例中移除自定义键。
     * <p>
     * 原文：
     * Removes a custom key from the {@link PersistentDataHolder} instance.
     *
     * @param key 要移除的键
     *
     * @throws IllegalArgumentException 如果提供的键为 null
     */
    void remove(@NotNull NamespacedKey key);

    /**
     * 返回容器实例是否为空，即其中没有条目。
     * <p>
     * 原文：
     * Returns if the container instance is empty, therefore has no entries
     * inside it.
     *
     * @return 布尔值
     */
    boolean isEmpty();

    /**
     * 将所有值从此 {@link PersistentDataContainer} 复制到提供的容器。
     * <p>
     * 此方法仅复制自定义对象键。现有标签（如显示名称）不会被复制，因为值使用您的命名空间存储。
     * <p>
     * 原文：
     * Copies all values from this {@link PersistentDataContainer} to the provided
     * container.
     * <p>
     * This method only copies custom object keys. Existing tags, like the display
     * name, will not be copied as the values are stored using your namespace.
     *
     * @param other   要复制到的容器
     * @param replace 是否替换目标容器中的任何匹配值
     *
     * @throws IllegalArgumentException 如果另一个容器为 null
     */
    void copyTo(@NotNull PersistentDataContainer other, boolean replace);

    /**
     * 返回此标签容器使用的适配器上下文。
     * <p>
     * 原文：
     * Returns the adapter context this tag container uses.
     *
     * @return 标签上下文
     */
    @NotNull
    PersistentDataAdapterContext getAdapterContext();
}
