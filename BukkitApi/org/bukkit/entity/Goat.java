package org.bukkit.entity;

/**
 * 山羊.
 */
public interface Goat extends Animals {

    /**
     * 获取此山羊是否有左角.
     * <p>
     * 原文：Gets if this goat has its left horn.
     *
     * @return 左角状态
     */
    boolean hasLeftHorn();

    /**
     * 设置此山羊是否有左角.
     * <p>
     * 原文：Sets if this goat has its left horn.
     *
     * @param hasHorn 左角状态
     */
    void setLeftHorn(boolean hasHorn);

    /**
     * 获取此山羊是否有右角.
     * <p>
     * 原文：Gets if this goat has its right horn.
     *
     * @return 右角状态
     */
    boolean hasRightHorn();

    /**
     * 设置此山羊是否有右角.
     * <p>
     * 原文：Sets if this goat has its right horn.
     *
     * @param hasHorn 右角状态
     */
    void setRightHorn(boolean hasHorn);

    /**
     * 获取此山羊是否为尖叫山羊.
     *
     * 尖叫山羊会发出尖叫声音并更频繁地冲撞. 它们不提供房屋贷款.
     * <p>
     * 原文：Gets if this is a screaming goat.
     *
     * A screaming goat makes screaming sounds and rams more often. They do not
     * offer home loans.
     *
     * @return 尖叫状态
     */
    boolean isScreaming();

    /**
     * 设置此山羊是否为尖叫山羊.
     *
     * 尖叫山羊会发出尖叫声音并更频繁地冲撞. 它们不提供房屋贷款.
     * <p>
     * 原文：Sets if this is a screaming goat.
     *
     * A screaming goat makes screaming sounds and rams more often. They do not
     * offer home loans.
     *
     * @param screaming 尖叫状态
     */
    void setScreaming(boolean screaming);
}
