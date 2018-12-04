package org.bukkit.inventory.meta;

import org.bukkit.FireworkEffect;
import org.bukkit.Material;

/**
 * 代表可以存储单个FireworkEffect的meta.例如包含{@link Material#FIREWORK_STAR}.
 */
public interface FireworkEffectMeta extends ItemMeta {

    /**
     * 设置这个meta的烟花效果.
     * <p>
     * 原文:Sets the firework effect for this meta.
     *
     * @param effect 要设置的效果，或者设置成来清空效果
     */
    void setEffect(FireworkEffect effect);

    /**
     * 检测这个meta是否拥有烟花效果.
     * <p>
     * 原文：Checks if this meta has an effect.
     *
     * @return true表示这个meta拥有烟花效果,否则为false
     */
    boolean hasEffect();

    /**
     * 获取这个meta的烟花效果.
     * <p>
     * 原文:Gets the firework effect for this meta.
     *
     * @return 当前的效果,如果没有则为null
     */
    FireworkEffect getEffect();

    FireworkEffectMeta clone();
}
