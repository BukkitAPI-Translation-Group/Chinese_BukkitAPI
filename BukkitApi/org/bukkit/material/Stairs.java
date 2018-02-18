package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表楼梯
 */
public class Stairs extends MaterialData implements Directional {

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Stairs(final int type) {
        super(type);
    }

    public Stairs(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Stairs(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Stairs(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * @return 楼梯上升的方向
     */
    public BlockFace getAscendingDirection() {
        byte data = getData();

        switch (data & 0x3) {
        case 0x0:
        default:
            return BlockFace.EAST;

        case 0x1:
            return BlockFace.WEST;

        case 0x2:
            return BlockFace.SOUTH;

        case 0x3:
            return BlockFace.NORTH;
        }
    }

    /**
     * @return 楼梯下降的方向
     */
    public BlockFace getDescendingDirection() {
        return getAscendingDirection().getOppositeFace();
    }

    /**
     * 设置楼梯部分的朝向.
     * <p>
     * 原文:Set the direction the stair part of the block is facing
     */
    public void setFacingDirection(BlockFace face) {
        byte data;

        switch (face) {
        case NORTH:
            data = 0x3;
            break;

        case SOUTH:
            data = 0x2;
            break;

        case EAST:
        default:
            data = 0x0;
            break;

        case WEST:
            data = 0x1;
            break;
        }

        setData((byte) ((getData() & 0xC) | data));
    }

    /**
     * @return 楼梯的朝向
     */
    public BlockFace getFacing() {
        return getDescendingDirection();
    }

    /**
     * 测试这个台阶是否被反转.
     * <p>
     * 原文:Test if step is inverted
     *
     * @return true为台阶被反转(上半)，false为一般状态(下半)
     */
    public boolean isInverted() {
        return ((getData() & 0x4) != 0);
    }

    /**
     * 设置台阶的反转状态.
     * <p>
     * 原文:Set step inverted state
     *
     * @param inv - true为台阶被反转(上半)，false为一般状态(下半)
     */
    public void setInverted(boolean inv) {
        int dat = getData() & 0x3;
        if (inv) {
            dat |= 0x4;
        }
        setData((byte) dat);
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + (isInverted() ? " inverted" : "");
    }

    @Override
    public Stairs clone() {
        return (Stairs) super.clone();
    }
}
