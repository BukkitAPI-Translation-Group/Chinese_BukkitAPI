package org.bukkit.material;

import org.bukkit.block.BlockFace;
import org.bukkit.Material;

/**
 * 代表按钮
 */
public class Button extends SimpleAttachableMaterialData implements Redstone {
    public Button() {
        super(Material.STONE_BUTTON);
    }

    /**
     * @param type the type
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Button(final int type) {
        super(type);
    }

    public Button(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Button(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Button(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取这个按钮的充能状态.
     * <p>
     * 原文:Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return 按钮的充能状态
     */
    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置这个按钮的充能状态.
     * <p>
     * 原文:Sets the current state of this button
     *
     * @param bool 按钮的充能状态
     */
    public void setPowered(boolean bool) {
        setData((byte) (bool ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    /**
     * 获取这个方块附着的方向.
     * <p>
     * 原文:Gets the face that this block is attached on
     *
     * @return 附着的BlockFace
     */
    public BlockFace getAttachedFace() {
        byte data = (byte) (getData() & 0x7);

        switch (data) {
        case 0x0:
            return BlockFace.UP;

        case 0x1:
            return BlockFace.WEST;

        case 0x2:
            return BlockFace.EAST;

        case 0x3:
            return BlockFace.NORTH;

        case 0x4:
            return BlockFace.SOUTH;

        case 0x5:
            return BlockFace.DOWN;
        }

        return null;
    }

    /**
     * 设置这个按钮所指的方向.
     * <p>
     * 原文:Sets the direction this button is pointing toward
     */
    public void setFacingDirection(BlockFace face) {
        byte data = (byte) (getData() & 0x8);

        switch (face) {
        case DOWN:
            data |= 0x0;
            break;

        case EAST:
            data |= 0x1;
            break;

        case WEST:
            data |= 0x2;
            break;

        case SOUTH:
            data |= 0x3;
            break;

        case NORTH:
            data |= 0x4;
            break;

        case UP:
            data |= 0x5;
            break;
        }

        setData(data);
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public Button clone() {
        return (Button) super.clone();
    }
}
