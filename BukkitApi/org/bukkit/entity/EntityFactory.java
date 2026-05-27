package org.bukkit.entity;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Experimental
public interface EntityFactory {

    /**
     * 使用提供的输入创建一个新的EntitySnapshot.
     * <p>
     * 接受{@link EntitySnapshot#getAsString()}输出格式的字符串.
     * <p>
     * 原文：
     * Create a new EntitySnapshot with the supplied input.<br>
     * Accepts strings in the format output by {@link EntitySnapshot#getAsString()}.
     *
     * @param input 输入字符串
     * @return 创建的EntitySnapshot
     * @throws IllegalArgumentException 如果输入字符串的格式无效或不支持
     */
    @NotNull
    EntitySnapshot createEntitySnapshot(@NotNull String input) throws IllegalArgumentException;
}
