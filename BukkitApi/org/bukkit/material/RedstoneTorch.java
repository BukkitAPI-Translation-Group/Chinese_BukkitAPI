package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表红石火把
 */
public class RedstoneTorch extends Torch implements Redstone {
    public RedstoneTorch() {
        super(Material.REDSTONE_TORCH_ON);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public RedstoneTorch(final int type) {
        super(type);
    }

    public RedstoneTorch(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public RedstoneTorch(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public RedstoneTorch(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取这个红石火把是否充能.
     * <p>
     * 原文：Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return 这个红石火把是否充能
     */
    public boolean isPowered() {
        return getItemType() == Material.REDSTONE_TORCH_ON;
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public RedstoneTorch clone() {
        return (RedstoneTorch) super.clone();
    }
}
