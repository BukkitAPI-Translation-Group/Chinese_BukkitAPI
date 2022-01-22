package org.bukkit.potion;

import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.NotNull;

public final class PotionData {

    private final PotionType type;
    private final boolean extended;
    private final boolean upgraded;

    /**
     * 实例化一个不可变的PotionData对象.
     * <p>
     * 原文:Instantiates a final PotionData object to contain information about a
     * Potion
     *
     * @param type 药水种类
     * @param extended 药水是否为延长版 (PotionType#isExtendable() 必须为 true)
     * @param upgraded 药水是否为升级版 (PotionType#isUpgradable() 必须为 true)
     */
    public PotionData(@NotNull PotionType type, boolean extended, boolean upgraded) {
        Validate.notNull(type, "Potion Type must not be null");
        Validate.isTrue(!upgraded || type.isUpgradeable(), "Potion Type is not upgradable");
        Validate.isTrue(!extended || type.isExtendable(), "Potion Type is not extendable");
        Validate.isTrue(!upgraded || !extended, "Potion cannot be both extended and upgraded");
        this.type = type;
        this.extended = extended;
        this.upgraded = upgraded;
    }

    public PotionData(@NotNull PotionType type) {
        this(type, false, false);
    }

    /**
     * 获取此药水的种类, 对应每种可合成药水.
     * <p>
     * 原文:Gets the type of the potion, Type matches up with each kind of craftable
     * potion
     *
     * @return 药水种类
     */
    @NotNull
    public PotionType getType() {
        return type;
    }

    /**
     * 检测此药水是否可升级.
     * 意思是药水是否有二阶增强版本, 比如再生药水 II.
     * <p>
     * 原文:Checks if the potion is in an upgraded state. This refers to whether or
     * not the potion is Tier 2, such as Potion of Fire Resistance II.
     *
     * @return 此类药水是否可升级
     */
    public boolean isUpgraded() {
        return upgraded;
    }

    /**
     * 检测此药水是否有时长延长状态 (指时长延长版药水).
     * <p>
     * 原文:Checks if the potion is in an extended state. This refers to the extended
     * duration potions
     *
     * @return 是否有时长延长版
     */
    public boolean isExtended() {
        return extended;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 23 * hash + (this.extended ? 1 : 0);
        hash = 23 * hash + (this.upgraded ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PotionData other = (PotionData) obj;
        return (this.upgraded == other.upgraded) && (this.extended == other.extended) && (this.type == other.type);
    }
}
