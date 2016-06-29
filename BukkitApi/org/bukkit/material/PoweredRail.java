package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表充能铁轨
 */
public class PoweredRail extends ExtendedRails implements Redstone {
    public PoweredRail() {
        super(Material.POWERED_RAIL);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public PoweredRail(final int type) {
        super(type);
    }

    public PoweredRail(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public PoweredRail(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public PoweredRail(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取这个充能铁轨是否充能.
     *
     * @return 这个充能铁轨是否充能
     */
    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置这个充能铁轨是否充能.
     * <p>
     * 原文：Set whether this PoweredRail should be powered or not.
     *
     * @param isPowered 这个充能铁轨是否充能
     */
    public void setPowered(boolean isPowered) {
        setData((byte) (isPowered ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    @Override
    public PoweredRail clone() {
        return (PoweredRail) super.clone();
    }
}
