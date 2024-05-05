package org.bukkit.potion;

import org.jetbrains.annotations.NotNull;

/**
 * @deprecated 仅为保障向后兼容性, PotionEffectTypeWrapper 已不再使用.
 */
@Deprecated
public abstract class PotionEffectTypeWrapper extends PotionEffectType {
    protected PotionEffectTypeWrapper() {
    }

    /**
     * 获取绑定到此包装类的药水效果类型.
     * <p>
     * 原文:Get the potion type bound to this wrapper.
     *
     * @return 药水效果类型
     */
    @NotNull
    public PotionEffectType getType() {
        return this;
    }
}
