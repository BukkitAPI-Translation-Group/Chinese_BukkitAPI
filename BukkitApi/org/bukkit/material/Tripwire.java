package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表绊线。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Tripwire extends MaterialData {

    public Tripwire() {
        super(Material.LEGACY_TRIPWIRE);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public Tripwire(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 测试绊线当前是否被激活。
     *
     * @return 如果被激活则返回 true，否则返回 false
     * <p>原文：Test if tripwire is currently activated
     */
    public boolean isActivated() {
        return (getData() & 0x4) != 0;
    }

    /**
     * 设置绊线的激活状态。
     *
     * @param act - 如果被激活则为 true，否则为 false
     * <p>原文：Set tripwire activated state
     */
    public void setActivated(boolean act) {
        int dat = getData() & (0x8 | 0x3);
        if (act) {
            dat |= 0x4;
        }
        setData((byte) dat);
    }

    /**
     * 测试是否有物体直接触发此绊线。
     *
     * @return 如果有物体触发绊线则返回 true，否则返回 false
     * <p>原文：Test if object triggering this tripwire directly
     */
    public boolean isObjectTriggering() {
        return (getData() & 0x1) != 0;
    }

    /**
     * 设置此绊线的物体触发状态。
     *
     * @param trig - 如果有物体触发绊线则为 true，否则为 false
     * <p>原文：Set object triggering state for this tripwire
     */
    public void setObjectTriggering(boolean trig) {
        int dat = getData() & 0xE;
        if (trig) {
            dat |= 0x1;
        }
        setData((byte) dat);
    }

    @Override
    public Tripwire clone() {
        return (Tripwire) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + (isActivated() ? " Activated" : "") + (isObjectTriggering() ? " Triggered" : "");
    }
}