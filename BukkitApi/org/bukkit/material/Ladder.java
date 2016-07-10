package org.bukkit.material;

import org.bukkit.block.BlockFace;
import org.bukkit.Material;

/**
 * 代表梯子
 */
public class Ladder extends SimpleAttachableMaterialData {
    public Ladder() {
        super(Material.LADDER);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Ladder(final int type) {
        super(type);
    }

    public Ladder(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Ladder(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Ladder(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取这个方块附着的方向.
     * <p>
     * 原文:Gets the face that this block is attached on
     *
     * @return 附着的方向
     */
    public BlockFace getAttachedFace() {
        byte data = getData();

        switch (data) {
        case 0x2:
            return BlockFace.SOUTH;

        case 0x3:
            return BlockFace.NORTH;

        case 0x4:
            return BlockFace.EAST;

        case 0x5:
            return BlockFace.WEST;
        }

        return null;
    }

    /**
     * 设置这个梯子的朝向.
     * <p>
     * 原文:Sets the direction this ladder is facing
     */
    public void setFacingDirection(BlockFace face) {
        byte data = (byte) 0x0;

        switch (face) {
        case SOUTH:
            data = 0x2;
            break;

        case NORTH:
            data = 0x3;
            break;

        case EAST:
            data = 0x4;
            break;

        case WEST:
            data = 0x5;
            break;
        }

        setData(data);

    }

    @Override
    public Ladder clone() {
        return (Ladder) super.clone();
    }
}
