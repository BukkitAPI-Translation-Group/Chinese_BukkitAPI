package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表绊线
 */
public class Tripwire extends MaterialData {

    public Tripwire() {
        super(Material.TRIPWIRE);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Tripwire(final int type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Tripwire(final int type, final byte data) {
        super(type, data);
    }

    /**
     * 测试绊线是否被激活.
     * <p>
     * 原文:Test if tripwire is currently activated
     *
     * @return 绊线是否被激活
     */
    public boolean isActivated() {
        return (getData() & 0x4) != 0;
    }

    /**
     * 设置绊线是否被激活.
     * <p>
     * 原文:Set tripwire activated state
     *
     * @param act 绊线是否被激活
     */
    public void setActivated(boolean act) {
        int dat = getData() & (0x8 | 0x3);
        if (act) {
            dat |= 0x4;
        }
        setData((byte) dat);
    }   

    /**
     * 测试绊线是否由物体直接触发.
     * <p>
     * 原文:Test if object triggering this tripwire directly
     *
     * @return 绊线是否由物体触发
     */
    public boolean isObjectTriggering() {
        return (getData() & 0x1) != 0;
    }

    /**
     * 设置绊线是否由物体触发.
     * <p>
     * 原文:Set object triggering state for this tripwire
     *
     * @param trig 绊线是否由物体触发
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
