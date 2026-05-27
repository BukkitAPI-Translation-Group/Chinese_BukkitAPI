package org.bukkit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.jetbrains.annotations.ApiStatus;

/**
 * 用于标注那些空值性未明确定义的类型，因此既不适用
 * {@link org.jetbrains.annotations.NotNull} 也不适用
 * {@link org.jetbrains.annotations.Nullable}。例如当接口定义了一个方法，
 * 其空值性取决于具体实现时。
 *
 * @deprecated 通常不应在任何新 API 代码中使用，因为这暗示了不良的 API 设计。
 */
@Retention(RetentionPolicy.CLASS)
@ApiStatus.Internal
@Deprecated(since = "1.13.2")
public @interface UndefinedNullability {

    /**
     * 人类可读的描述，说明该类型在何种情况下可为空。
     *
     * @return 描述信息
     * <p>
     * 原文：Human readable description of the circumstances, in which the type is
     * nullable.
     */
    String value() default "";
}