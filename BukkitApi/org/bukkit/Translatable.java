package org.bukkit;

import org.jetbrains.annotations.NotNull;

/**
 * 代表一个具有可被Minecraft客户端翻译的文本表示的对象.
 */
public interface Translatable {

    /**
     * 获取翻译键, 适用于在翻译组件中使用.
     *
     * @return 翻译键
     */
    @NotNull
    String getTranslationKey();
}
