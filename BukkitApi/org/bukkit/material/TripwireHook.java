package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表绊线钩
 */
public class TripwireHook extends SimpleAttachableMaterialData implements Redstone {

    public TripwireHook() {
        super(Material.TRIPWIRE_HOOK);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public TripwireHook(final int type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public TripwireHook(final int type, final byte data) {
        super(type, data);
    }

    public TripwireHook(BlockFace dir) {
        this();
        setFacingDirection(dir);
    }

    /**
     * 这个绊线钩是否处于连接状态.
     * <p>
     * 原文:Test if tripwire is connected
     *
     * @return 绊线钩是否处于连接状态
     */
    public boolean isConnected() {
        return (getData() & 0x4) != 0;
    }

    /**
     * 设置这个绊线钩的连接状态.
     * <p>
     * 原文:Set tripwire connection state
     *
     * @param connected 绊线钩是否处于连接状态
     */
    public void setConnected(boolean connected) {
        int dat = getData() & (0x8 | 0x3);
        if (connected) {
            dat |= 0x4;
        }
        setData((byte) dat);
    }

    /**
     * 这个绊线钩是否被激活.
     * <p>
     * 原文:Test if hook is currently activated
     *
     * @return 绊线钩是否被激活
     */
    public boolean isActivated() {
        return (getData() & 0x8) != 0;
    }

    /**
     * 设置这个绊线钩的激活状态.
     * <p>
     * 原文:Set hook activated state
     *
     * @param act 绊线钩是否被激活
     */
    public void setActivated(boolean act) {
        int dat = getData() & (0x4 | 0x3);
        if (act) {
            dat |= 0x8;
        }
        setData((byte) dat);
    }

    public void setFacingDirection(BlockFace face) {
        int dat = getData() & 0xC;
        switch (face) {
        case WEST:
            dat |= 0x1;
            break;
        case NORTH:
            dat |= 0x2;
            break;
        case EAST:
            dat |= 0x3;
            break;
        case SOUTH:
        default:
            break;
        }
        setData((byte) dat);
    }

    public BlockFace getAttachedFace() {
        switch (getData() & 0x3) {
        case 0:
            return BlockFace.NORTH;
        case 1:
            return BlockFace.EAST;
        case 2:
            return BlockFace.SOUTH;
        case 3:
            return BlockFace.WEST;
        }
        return null;
    }

    public boolean isPowered() {
        return isActivated();
    }

    @Override
    public TripwireHook clone() {
        return (TripwireHook) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + (isActivated() ? " Activated" : "") + (isConnected() ? " Connected" : "");
    }
}
