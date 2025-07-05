package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表熔炉.
 * @deprecated all usage of MaterialData is deprecated and subject to removal.
 * Use {@link org.bukkit.block.data.BlockData}.
 */
@Deprecated(since = "1.14.1")
public class Furnace extends FurnaceAndDispenser {

    public Furnace() {
        super(Material.LEGACY_FURNACE);
    }

    /**
     * 以指定朝向实例化一个熔炉.
     * <p>
     * 原文:Instantiate a furnace facing in a particular direction.
     *
     * @param direction 熔炉正面的朝向
     */
    public Furnace(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    public Furnace(final Material type) {
        super(type);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated(since = "1.6.2")
    public Furnace(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public Furnace clone() {
        return (Furnace) super.clone();
    }
}
