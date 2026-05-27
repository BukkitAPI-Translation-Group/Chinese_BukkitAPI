package org.bukkit.registry;

import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示类的实例可以注册到服务器并具有关联的键。
 *
 * @see Registry
 */
public interface RegistryAware {

    /**
     * 获取此实例的键（如果已注册），否则抛出错误。
     * <br>
     * 这是一个便捷方法，插件在使用此方法之前应始终检查 {@link #isRegistered()}。
     * <p>
     * 原文：Gets the key of this instance if it is registered otherwise throws an error. This is a convenience method and plugins should always check {@link #isRegistered()} before using this method.
     *
     * @return the key with which this instance is registered.
     * @throws IllegalStateException if this instance is not registered.
     * @see #isRegistered()
     * @see #getKeyOrNull()
     * @see Registry
     */
    @NotNull
    NamespacedKey getKeyOrThrow();

    /**
     * 获取此实例的键（如果已注册），否则返回 {@code null}。
     * <p>
     * 原文：Gets the key of this instance if it is registered otherwise returns {@code null}.
     *
     * @return the key with which this instance is registered or {@code null} if not registered.
     * @see #getKeyOrThrow()
     * @see Registry
     */
    @Nullable
    NamespacedKey getKeyOrNull();

    /**
     * 返回此实例是否注册在注册表中，因此是否具有键。
     * <p>
     * 原文：Returns whether this instance is register in a registry and therefore has a key or not.
     *
     * @return true, if this instance is registered. Otherwise, false.
     * @see #getKeyOrThrow()
     * @see Registry
     */
    boolean isRegistered();
}
