package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表熔炉或发射器
 */
public class DirectionalContainer extends MaterialData implements Directional {
    /**
     * @param type 原始类型id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public DirectionalContainer(final int type) {
        super(type);
    }

    public DirectionalContainer(final Material type) {
        super(type);
    }

    /**
     * @param type 原始类型id
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public DirectionalContainer(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public DirectionalContainer(final Material type, final byte data) {
        super(type, data);
    }

    public void setFacingDirection(BlockFace face) {
        byte data;

        switch (face) {
        case NORTH:
            data = 0x2;
            break;

        case SOUTH:
            data = 0x3;
            break;

        case WEST:
            data = 0x4;
            break;

        case EAST:
        default:
            data = 0x5;
        }

        setData(data);
    }

    public BlockFace getFacing() {
        byte data = getData();

        switch (data) {
        case 0x2:
            return BlockFace.NORTH;

        case 0x3:
            return BlockFace.SOUTH;

        case 0x4:
            return BlockFace.WEST;

        case 0x5:
        default:
            return BlockFace.EAST;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing();
    }

    @Override
    public DirectionalContainer clone() {
        return (DirectionalContainer) super.clone();
    }
}