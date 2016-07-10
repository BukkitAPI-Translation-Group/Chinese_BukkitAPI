package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表活板门
 */
public class TrapDoor extends SimpleAttachableMaterialData implements Openable {
    public TrapDoor() {
        super(Material.TRAP_DOOR);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public TrapDoor(final int type) {
        super(type);
    }

    public TrapDoor(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public TrapDoor(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public TrapDoor(final Material type, final byte data) {
        super(type, data);
    }

    public boolean isOpen() {
        return ((getData() & 0x4) == 0x4);
    }

    public void setOpen(boolean isOpen) {
        byte data = getData();

        if (isOpen) {
            data |= 0x4;
        } else {
            data &= ~0x4;
        }

        setData(data);
    }

    /**
     * 这个活板门是否被反转.
     * <p>
     * 原文:Test if trapdoor is inverted
     *
     * @return true为反转的(上半), false为正常形态(下半)
     */
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }

    /**
     * 设置这个台阶是否被反转。
     * <p>
     * 原文:Set trapdoor inverted state
     *
     * @param inv true为反转的(上半), false为正常形态(下半)
     */
    public void setInverted(boolean inv) {
        int dat = getData() & 0x7;
        if (inv) {
            dat |= 0x8;
        }
        setData((byte) dat);
    }

    public BlockFace getAttachedFace() {
        byte data = (byte) (getData() & 0x3);

        switch (data) {
            case 0x0:
                return BlockFace.SOUTH;

            case 0x1:
                return BlockFace.NORTH;

            case 0x2:
                return BlockFace.EAST;

            case 0x3:
                return BlockFace.WEST;
        }

        return null;

    }

    public void setFacingDirection(BlockFace face) {
        byte data = (byte) (getData() & 0xC);

        switch (face) {
            case SOUTH:
                data |= 0x1;
                break;
            case WEST:
                data |= 0x2;
                break;
            case EAST:
                data |= 0x3;
                break;
        }

        setData(data);
    }

    @Override
    public String toString() {
        return (isOpen() ? "OPEN " : "CLOSED ") + super.toString() + " with hinges set " + getAttachedFace() + (isInverted() ? " inverted" : "");
    }

    @Override
    public TrapDoor clone() {
        return (TrapDoor) super.clone();
    }
}
