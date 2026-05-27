package org.bukkit.metadata;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * FixedMetadataValue是一种特殊情况的元数据项, 在初始化后永远包含相同的值.
 * 使FixedMetadataValue无效没有任何效果.
 * <p>
 * 此类出于历史原因继承LazyMetadataValue, 即使它覆盖了所有实现方法.
 * 未来继承层次结构可能会改变.
 */
public class FixedMetadataValue extends LazyMetadataValue {

    /**
     * 存储由此固定值表示的内部值.
     */
    private final Object internalValue;

    /**
     * 使用Object初始化FixedMetadataValue.
     * <p>
     * 原文：
     * Initializes a FixedMetadataValue with an Object
     *
     * @param owningPlugin 创建此元数据值的{@link Plugin}
     * @param value 分配给此元数据值的值
     */
    public FixedMetadataValue(@NotNull Plugin owningPlugin, @Nullable final Object value) {
        super(owningPlugin);
        this.internalValue = value;
    }

    @Override
    public void invalidate() {

    }

    @Nullable
    @Override
    public Object value() {
        return internalValue;
    }
}
