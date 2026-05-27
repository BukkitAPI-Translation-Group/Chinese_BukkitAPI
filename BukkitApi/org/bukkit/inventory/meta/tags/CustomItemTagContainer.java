package org.bukkit.inventory.meta.tags;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 此接口表示一个类似映射的对象，能够在其中存储自定义标签.
 *
 * @deprecated 此 API 部分已被 {@link org.bukkit.persistence.PersistentDataHolder} API 取代。请使用 {@link org.bukkit.persistence.PersistentDataHolder} 代替.
 */
@Deprecated(since = "1.14")
public interface CustomItemTagContainer {

    /**
     * 在 {@link ItemMeta} 上存储一个自定义值.
     * <p>
     * 此 API 不能用于操作原版标签，因为值将使用你的命名空间存储。此方法将覆盖元数据中在提供的键下存储的任何现有值.
     * <p>
     * 原文：Stores a custom value on the {@link ItemMeta}. This API cannot be used to manipulate minecraft tags, as the values will be stored using your namespace. This method will override any existing value the meta may have stored under the provided key.
     *
     * @param key 存储此值的键
     * @param type 此物品标签使用的类型
     * @param value 存储在标签中的值
     * @param <T> 标签值的泛型 Java 类型
     * @param <Z> 要存储的对象的泛型类型
     * @throws NullPointerException 如果键为 null
     * @throws NullPointerException 如果类型为 null
     * @throws NullPointerException 如果值为 null。移除自定义标签应使用 {@link #removeCustomTag(org.bukkit.NamespacedKey)}
     * @throws IllegalArgumentException 如果找不到适合 {@link ItemTagType#getPrimitiveType()} 的适配器
     */
    <T, Z> void setCustomTag(@NotNull NamespacedKey key, @NotNull ItemTagType<T, Z> type, @NotNull Z value);

    /**
     * 返回物品元数据是否注册了与提供的参数匹配的自定义标签.
     * <p>
     * 此方法仅在找到的值与提供的键具有相同的原始数据类型时才返回.
     * <p>
     * 使用自定义 {@link ItemTagType} 实现存储值不会存储复杂数据类型。因此存储 UUID（通过存储 byte[]）将匹配 hasCustomTag("key", {@link ItemTagType#BYTE_ARRAY})。同样，存储的 byte[] 将始终匹配你的 UUID {@link ItemTagType}，即使它不是 16 字节长.
     * <p>
     * 此方法仅适用于自定义对象键。覆盖现有标签（如显示名称）将不起作用，因为值使用你的命名空间存储.
     * <p>
     * 原文：Returns if the item meta has a custom tag registered matching the provided parameters. This method will only return if the found value has the same primitive data type as the provided key. Storing a value using a custom {@link ItemTagType} implementation will not store the complex data type. Therefore storing a UUID (by storing a byte[]) will match hasCustomTag("key" , {@link ItemTagType#BYTE_ARRAY}). Likewise a stored byte[] will always match your UUID {@link ItemTagType} even if it is not 16 bytes long. This method is only usable for custom object keys. Overwriting existing tags, like the the display name, will not work as the values are stored using your namespace.
     *
     * @param key 存储值的键
     * @param type 原始存储类型必须匹配值的类型
     * @param <T> 存储的原始类型的泛型类型
     * @param <Z> 最终创建的复杂对象的泛型类型
     * @return 是否存在值
     * @throws NullPointerException 如果要查找的键为 null
     * @throws NullPointerException 如果要将找到的对象转换为的类型为 null
     */
    <T, Z> boolean hasCustomTag(@NotNull NamespacedKey key, @NotNull ItemTagType<T, Z> type);

    /**
     * 返回存储在物品上的自定义标签的值.
     * <p>
     * 原文：Returns the custom tag's value that is stored on the item.
     *
     * @param key 要在自定义标签映射中查找的键
     * @param type 值必须具有的类型，将被转换为该类型
     * @param <T> 存储的原始类型的泛型类型
     * @param <Z> 最终创建的复杂对象的泛型类型
     * @return 值，如果没有值映射到给定值下则返回 {@code null}
     * @throws NullPointerException 如果要查找的键为 null
     * @throws NullPointerException 如果要将找到的对象转换为的类型为 null
     * @throws IllegalArgumentException 如果值存在于给定键下，但无法使用给定类型访问
     * @throws IllegalArgumentException 如果找不到适合 {@link ItemTagType#getPrimitiveType()} 的适配器
     */
    @Nullable
    <T, Z> Z getCustomTag(@NotNull NamespacedKey key, @NotNull ItemTagType<T, Z> type);

    /**
     * 从物品元数据中移除自定义键.
     * <p>
     * 原文：Removes a custom key from the item meta.
     *
     * @param key 键
     * @throws NullPointerException 如果提供的键为 null
     */
    void removeCustomTag(@NotNull NamespacedKey key);

    /**
     * 返回容器实例是否为空，即其中没有条目.
     * <p>
     * 原文：Returns if the container instance is empty, therefore has no entries inside it.
     *
     * @return 布尔值
     */
    boolean isEmpty();

    /**
     * 返回此标签容器使用的适配器上下文.
     * <p>
     * 原文：Returns the adapter context this tag container uses.
     *
     * @return 标签上下文
     */
    @NotNull
    ItemTagAdapterContext getAdapterContext();
}