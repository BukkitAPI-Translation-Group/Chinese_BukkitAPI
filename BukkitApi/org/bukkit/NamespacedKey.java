package org.bukkit;

import com.google.common.base.Preconditions;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表基于字符串的 key, 由两部分组成: 命名空间名和键名.
 * <p>
 * 命名空间名只能包含小写字母和数字, 点(.), 下划线(_) 和连字符(-).
 * <p>
 * 键名只能包含小写字母和数字, 点(.), 下划线(_), 连字符(-) 和正斜杠(/).
 */
public final class NamespacedKey {

    /**
     * 代表所有内建 key 的命名空间.
     */
    public static final String MINECRAFT = "minecraft";
    /**
     * 代表所有由 Bukkit 生成的 key, 用于保障向后兼容性.
     */
    public static final String BUKKIT = "bukkit";
    //
    private static final Pattern VALID_NAMESPACE = Pattern.compile("[a-z0-9._-]+");
    private static final Pattern VALID_KEY = Pattern.compile("[a-z0-9/._-]+");
    //
    private final String namespace;
    private final String key;

    /**
     * 在指定的命名空间内创建一个 key.
     * <p>
     * 原文:Create a key in a specific namespace.
     *
     * @param namespace 命名空间
     * @param key key
     * @deprecated 插件应永不使用此构造器, 仅供内部使用!!
     */
    @Deprecated
    public NamespacedKey(@NotNull String namespace, @NotNull String key) {
        Preconditions.checkArgument(namespace != null && VALID_NAMESPACE.matcher(namespace).matches(), "Invalid namespace. Must be [a-z0-9._-]: %s", namespace);
        Preconditions.checkArgument(key != null && VALID_KEY.matcher(key).matches(), "Invalid key. Must be [a-z0-9/._-]: %s", key);

        this.namespace = namespace;
        this.key = key;

        String string = toString();
        Preconditions.checkArgument(string.length() < 256, "NamespacedKey must be less than 256 characters", string);
    }

    /**
     * 在插件的命名空间内创建一个 key.
     * <p>
     * 命名空间名只能包含小写字母和数字, 点(.), 下划线(_) 和连字符(-).
     * <p>
     * 键名只能包含小写字母和数字, 点(.), 下划线(_), 连字符(-) 和正斜杠(/).
     * <p>
     * 原文:Create a key in the plugin's namespace.
     * <p>
     * Namespaces may only contain lowercase alphanumeric characters, periods,
     * underscores, and hyphens.
     * <p>
     * Keys may only contain lowercase alphanumeric characters, periods,
     * underscores, hyphens, and forward slashes.
     *
     * @param plugin 用于命名空间的插件对象 (命名空间名为插件名的小写表示)
     * @param key 要创建的 key
     */
    public NamespacedKey(@NotNull Plugin plugin, @NotNull String key) {
        Preconditions.checkArgument(plugin != null, "Plugin cannot be null");
        Preconditions.checkArgument(key != null, "Key cannot be null");

        this.namespace = plugin.getName().toLowerCase(Locale.ROOT);
        this.key = key.toLowerCase(Locale.ROOT);

        // Check validity after normalization
        Preconditions.checkArgument(VALID_NAMESPACE.matcher(this.namespace).matches(), "Invalid namespace. Must be [a-z0-9._-]: %s", this.namespace);
        Preconditions.checkArgument(VALID_KEY.matcher(this.key).matches(), "Invalid key. Must be [a-z0-9/._-]: %s", this.key);

        String string = toString();
        Preconditions.checkArgument(string.length() < 256, "NamespacedKey must be less than 256 characters (%s)", string);
    }

    @NotNull
    public String getNamespace() {
        return namespace;
    }

    @NotNull
    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.namespace.hashCode();
        hash = 47 * hash + this.key.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NamespacedKey other = (NamespacedKey) obj;
        return this.namespace.equals(other.namespace) && this.key.equals(other.key);
    }

    @Override
    public String toString() {
        return this.namespace + ":" + this.key;
    }

    /**
     * 在 {@link #BUKKIT} 命名空间创建一个随机的 key 并返回.
     * <p>
     * 原文:Return a new random key in the {@link #BUKKIT} namespace.
     *
     * @return 新 key
     * @deprecated 插件应永不使用此方法, 仅供内部使用!!
     */
    @Deprecated
    @NotNull
    public static NamespacedKey randomKey() {
        return new NamespacedKey(BUKKIT, UUID.randomUUID().toString());
    }

    /**
     * 获取 Minecraft 命名空间内的一个 key.
     * <p>
     * 原文:Get a key in the Minecraft namespace.
     *
     * @param key 要使用的 key
     * @return Minecraft 命名空间内的新 key
     */
    @NotNull
    public static NamespacedKey minecraft(@NotNull String key) {
        return new NamespacedKey(MINECRAFT, key);
    }

    /**
     * 根据提供的字符串获取 NamespacedKey 对象, 若字符串未指定命名空间名, 将使用参数给定的默认命名空间.
     * 这是一个根据用户输入获取 NamespacedKey 对象的实用方法.
     * 请注意本方法大小写敏感, 且字符串内若存在任何大写字母将被视为无效输入 (建议先对字符串 toLowerCase). 关于输入内容的约定如下:
     * <pre>
     * fromString("foo", plugin) -{@literal >} "plugin:foo"
     * fromString("foo:bar", plugin) -{@literal >} "foo:bar"
     * fromString(":foo", null) -{@literal >} "minecraft:foo"
     * fromString("foo", null) -{@literal >} "minecraft:foo"
     * fromString("Foo", plugin) -{@literal >} null
     * fromString(":Foo", plugin) -{@literal >} null
     * fromString("foo:bar:bazz", plugin) -{@literal >} null
     * fromString("", plugin) -{@literal >} null
     * </pre>
     * <p>
     * 原文:Get a NamespacedKey from the supplied string with a default namespace if
     * a namespace is not defined. This is a utility method meant to fetch a
     * NamespacedKey from user input. Please note that casing does matter and
     * any instance of uppercase characters will be considered invalid. The
     * input contract is as follows:
     * <pre>
     * fromString("foo", plugin) -{@literal >} "plugin:foo"
     * fromString("foo:bar", plugin) -{@literal >} "foo:bar"
     * fromString(":foo", null) -{@literal >} "minecraft:foo"
     * fromString("foo", null) -{@literal >} "minecraft:foo"
     * fromString("Foo", plugin) -{@literal >} null
     * fromString(":Foo", plugin) -{@literal >} null
     * fromString("foo:bar:bazz", plugin) -{@literal >} null
     * fromString("", plugin) -{@literal >} null
     * </pre>
     *
     * @param string 需转换为 NamespacedKey 对象的字符串
     * @param defaultNamespace 未提供命名空间时使用的默认命名空间.
     * 若为 null, 将使用 {@code "minecraft"} 命名空间
     * ({@link #minecraft(String)})
     * @return 创建的 NamespacedKey 对象. 如果 key 无效, 则为 null
     * @see #fromString(String)
     */
    @Nullable
    public static NamespacedKey fromString(@NotNull String string, @Nullable Plugin defaultNamespace) {
        Preconditions.checkArgument(string != null && !string.isEmpty(), "Input string must not be empty or null");

        String[] components = string.split(":", 3);
        if (components.length > 2) {
            return null;
        }

        String key = (components.length == 2) ? components[1] : "";
        if (components.length == 1) {
            String value = components[0];
            if (value.isEmpty() || !VALID_KEY.matcher(value).matches()) {
                return null;
            }

            return (defaultNamespace != null) ? new NamespacedKey(defaultNamespace, value) : minecraft(value);
        } else if (components.length == 2 && !VALID_KEY.matcher(key).matches()) {
            return null;
        }

        String namespace = components[0];
        if (namespace.isEmpty()) {
            return (defaultNamespace != null) ? new NamespacedKey(defaultNamespace, key) : minecraft(key);
        }

        if (!VALID_KEY.matcher(namespace).matches()) {
            return null;
        }

        return new NamespacedKey(namespace, key);
    }

    /**
     * 根据提供的字符串获取 NamespacedKey 对象.
     * 默认命名空间为 "minecraft" ({@link #minecraft(String)}).
     * <p>
     * 原文:Get a NamespacedKey from the supplied string.
     *
     * The default namespace will be Minecraft's (i.e.
     * {@link #minecraft(String)}).
     *
     * @param key 需转换为 NamespacedKey 对象的 key
     * @return 创建的 NamespacedKey 对象. 如果 key 无效, 则为 null
     * @see #fromString(String, Plugin)
     */
    @Nullable
    public static NamespacedKey fromString(@NotNull String key) {
        return fromString(key, null);
    }
}
