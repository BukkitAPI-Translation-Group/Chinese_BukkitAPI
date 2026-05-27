package org.bukkit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jetbrains.annotations.ApiStatus;

/**
 * 表示被注解的元素（类、方法、字段等）属于
 * <a href="https://minecraft.wiki/w/Experimental_Gameplay">Minecraft 实验性功能</a>，
 * 并可能被 Mojang 更改。
 * <p>
 * <b>注意：</b>标记有此注解的元素需要在服务器上启用数据包或其他非标准功能才能生效。
 *
 * @see <a href="https://www.minecraft.net/en-us/article/testing-new-minecraft-features/feature-toggles-java-edition">Features Toggles - Minecraft Article</a>
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({
        ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE
})
@ApiStatus.Internal
public @interface MinecraftExperimental {

    /**
     * 获取被注解对象有效所需启用的功能。
     * <p>
     * 虽然此值在 Bukkit 中未被使用，但它是一个便利值，用于帮助定位相关的被注解元素，
     * 以便在 Minecraft 不再将其视为实验性功能时进行移除。有关在插件中的使用信息，请参阅 {@link Requires}。
     *
     * @return 所需的功能标志。
     *
     * 原文：
     * Get the feature that must be enabled for the annotated object to be valid.
     * <p>
     * While this value is not used anywhere in Bukkit, it is a convenience value to assist
     * in locating relevant annotated elements for removal once no longer deemed an experimental
     * feature by Minecraft. See {@link Requires} for information about use in plugins.
     *
     * @return the required feature flag
     */
    Requires value();

    /**
     * 一个枚举，标识 {@link MinecraftExperimental} 功能所需的功能标志。
     * <p>
     * 此枚举定义的常量 <strong>不是 API！</strong>常量可能会在没有警告的情况下被添加或移除，
     * 并且不一定与 FeatureFlag 中定义的常量完全一致。插件绝不应依赖此枚举。请改用 {@link FeatureFlag}。
     */
    @ApiStatus.Internal
    public enum Requires {

        MINECART_IMPROVEMENTS;
    }
}