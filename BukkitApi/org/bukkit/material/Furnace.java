package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表熔炉.
 */
public class Furnace extends FurnaceAndDispenser {

    public Furnace() {
        super(Material.FURNACE);
    }

    /**
     * 实例化一个特定朝向的熔炉.
     * <p>
     * 原文：Instantiate a furnace facing in a particular direction.
     *
     * @param direction 熔炉的朝向
     */
    public Furnace(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Furnace(final int type) {
        super(type);
    }

    public Furnace(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Furnace(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Furnace(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public Furnace clone() {
        return (Furnace) super.clone();
    }
}
