package org.bukkit.persistence;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * 列表持久数据表示一种数据类型，能够在 {@link PersistentDataContainer} 中存储其他数据类型的列表。
 *
 * @param <P> 列表元素的原始类型。
 * @param <C> 列表元素的复杂类型。
 */
public interface ListPersistentDataType<P, C> extends PersistentDataType<List<P>, List<C>> {

    /**
     * 提供列表中元素的持久数据类型。
     * <p>
     * 原文：
     * Provides the persistent data type of the elements found in the list.
     *
     * @return 持久数据类型。
     */
    @NotNull
    PersistentDataType<P, C> elementType();
}
