package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表一个活板门。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class TrapDoor extends SimpleAttachableMaterialData implements Openable {
    public TrapDoor() {
        super(Material.LEGACY_TRAP_DOOR);
    }

    public TrapDoor(final Material type) {
        super(type);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public TrapDoor(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public boolean isOpen() {
        return ((getData() & 0x4) == 0x4);
    }

    @Override
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
     * 测试活板门是否倒置。
     *
     * @return 如果倒置（上半部分）则返回 true，如果正常（下半部分）则返回 false
     * <p>原文：Test if trapdoor is inverted
     */
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }

    /**
     * 设置活板门的倒置状态。
     *
     * @param inv - 如果倒置（上半部分）则为 true，如果正常（下半部分）则为 false
     * <p>原文：Set trapdoor inverted state
     */
    public void setInverted(boolean inv) {
        int dat = getData() & 0x7;
        if (inv) {
            dat |= 0x8;
        }
        setData((byte) dat);
    }

    @Override
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

    @Override
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