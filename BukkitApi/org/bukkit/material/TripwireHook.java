package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表绊线钩。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class TripwireHook extends SimpleAttachableMaterialData implements Redstone {

    public TripwireHook() {
        super(Material.LEGACY_TRIPWIRE_HOOK);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public TripwireHook(final Material type, final byte data) {
        super(type, data);
    }

    public TripwireHook(BlockFace dir) {
        this();
        setFacingDirection(dir);
    }

    /**
     * 测试绊线是否已连接。
     *
     * @return 如果已连接则返回 true，否则返回 false
     * <p>原文：Test if tripwire is connected
     */
    public boolean isConnected() {
        return (getData() & 0x4) != 0;
    }

    /**
     * 设置绊线的连接状态。
     *
     * @param connected - 如果已连接则为 true，否则为 false
     * <p>原文：Set tripwire connection state
     */
    public void setConnected(boolean connected) {
        int dat = getData() & (0x8 | 0x3);
        if (connected) {
            dat |= 0x4;
        }
        setData((byte) dat);
    }

    /**
     * 测试钩子当前是否被激活。
     *
     * @return 如果被激活则返回 true，否则返回 false
     * <p>原文：Test if hook is currently activated
     */
    public boolean isActivated() {
        return (getData() & 0x8) != 0;
    }

    /**
     * 设置钩子的激活状态。
     *
     * @param act - 如果被激活则为 true，否则为 false
     * <p>原文：Set hook activated state
     */
    public void setActivated(boolean act) {
        int dat = getData() & (0x4 | 0x3);
        if (act) {
            dat |= 0x8;
        }
        setData((byte) dat);
    }

    @Override
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

    @Override
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

    @Override
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