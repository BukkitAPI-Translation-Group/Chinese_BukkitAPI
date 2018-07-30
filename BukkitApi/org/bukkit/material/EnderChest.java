package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表末影箱.
 */
public class EnderChest extends DirectionalContainer {

    public EnderChest() {
        super(Material.LEGACY_ENDER_CHEST);
    }

    /**
     * 实例化一个指定朝向的末影箱.
     * <p>
     * 原文:Instantiate an ender chest facing in a particular direction.
     *
     * @param direction 末影箱箱盖打开方向
     */
    public EnderChest(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    public EnderChest(final Material type) {
        super(type);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public EnderChest(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public EnderChest clone() {
        return (EnderChest) super.clone();
    }
}
