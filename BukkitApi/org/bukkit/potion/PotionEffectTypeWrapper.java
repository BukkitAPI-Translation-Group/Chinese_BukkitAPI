package org.bukkit.potion;

public class PotionEffectTypeWrapper extends PotionEffectType {
    protected PotionEffectTypeWrapper(int id) {
        super(id);
    }

    @Override
    public double getDurationModifier() {
        return getType().getDurationModifier();
    }

    @Override
    public String getName() {
        return getType().getName();
    }

    /**
     * 获取包装类绑定的药水类型。
     * <p>
     * 原文：Get the potion type bound to this wrapper.
     *
     * @return 药水效果类型
     */
    public PotionEffectType getType() {
        return PotionEffectType.getById(getId());
    }

    @Override
    public boolean isInstant() {
        return getType().isInstant();
    }
}