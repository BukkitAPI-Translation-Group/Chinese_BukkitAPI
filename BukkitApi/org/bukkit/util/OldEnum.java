package org.bukkit.util;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 包含枚举中常见方法的类。
 *
 * @param <T> 旧枚举的类型
 * @deprecated 仅用于向后兼容
 */
@ApiStatus.Internal
@Deprecated(since = "1.21")
public interface OldEnum<T extends OldEnum<T>> extends Comparable<T> {

    /**
     * @param other 要比较的对象
     * @return 如果此旧枚举较低则返回负数，相等返回零，高于给定旧枚举返回正数
     * @deprecated 仅用于向后兼容，旧枚举无法比较
     */
    @Deprecated(since = "1.21")
    @Override
    int compareTo(@NotNull T other);

    /**
     * @return 旧枚举的名称
     * @deprecated 仅用于向后兼容
     */
    @NotNull
    @Deprecated(since = "1.21")
    String name();

    /**
     * @return 旧枚举的序数
     * @deprecated 仅用于向后兼容，不保证旧枚举始终具有相同的序数
     */
    @Deprecated(since = "1.21")
    int ordinal();
}
