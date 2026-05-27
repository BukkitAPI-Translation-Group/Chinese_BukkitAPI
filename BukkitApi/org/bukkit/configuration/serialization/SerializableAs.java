package org.bukkit.configuration.serialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jetbrains.annotations.NotNull;

/**
 * 表示 {@link ConfigurationSerializable} 可以被存储的 "别名".
 * 如果 {@link ConfigurationSerializable} 类上没有此注解, 则使用该类的完全限定名.
 * <p>
 * 该值将存储在配置中, 以便配置反序列化能够确定其类型.
 * <p>
 * 在非 {@link ConfigurationSerializable} 类上使用此注解不会产生任何效果.
 *
 * @see ConfigurationSerialization#registerClass(Class, String)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SerializableAs {
    /**
     * 这是你的类将被存储和检索时使用的名称.
     * <p>
     * 此名称必须是唯一的. 我们建议使用如 "MyPluginThing" 这样的名称, 而不是 "Thing".
     * <p>
     * 原文：
     * This is the name your class will be stored and retrieved as.
     * <p>
     * This name MUST be unique. We recommend using names such as
     * "MyPluginThing" instead of "Thing".
     *
     * @return 序列化时使用的类名.
     */
    @NotNull
    public String value();
}
