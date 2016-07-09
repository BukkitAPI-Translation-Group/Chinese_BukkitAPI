package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表红石线.
 */
public class RedstoneWire extends MaterialData implements Redstone {
    public RedstoneWire() {
        super(Material.REDSTONE_WIRE);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public RedstoneWire(final int type) {
        super(type);
    }

    public RedstoneWire(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public RedstoneWire(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public RedstoneWire(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 这个物品有没有充能.
     * <p>
     * 原文:Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return true代表充能
     */
    public boolean isPowered() {
        return getData() > 0;
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public RedstoneWire clone() {
        return (RedstoneWire) super.clone();
    }
}
