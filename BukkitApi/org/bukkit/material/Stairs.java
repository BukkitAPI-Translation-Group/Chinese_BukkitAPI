package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表楼梯。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Stairs extends MaterialData implements Directional {

    public Stairs(final Material type) {
        super(type);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public Stairs(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * @return 楼梯上升朝向的方向
     * <p>原文：the direction the stairs ascend towards
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
     * @return 楼梯下降朝向的方向
     * <p>原文：the direction the stairs descend towards
     */
    public BlockFace getDescendingDirection() {
        return getAscendingDirection().getOppositeFace();
    }

    /**
     * 设置方块楼梯部分朝向的方向。
     * <p>原文：Set the direction the stair part of the block is facing
     */
    @Override
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
     * @return 方块楼梯部分朝向的方向
     * <p>原文：the direction the stair part of the block is facing
     */
    @Override
    public BlockFace getFacing() {
        return getDescendingDirection();
    }

    /**
     * 测试台阶是否倒置。
     *
     * @return 如果倒置（上半部分）则返回 true，如果正常（下半部分）则返回 false
     * <p>原文：Test if step is inverted
     */
    public boolean isInverted() {
        return ((getData() & 0x4) != 0);
    }

    /**
     * 设置台阶的倒置状态。
     *
     * @param inv - 如果台阶倒置（上半部分）则为 true，如果台阶正常（下半部分）则为 false
     * <p>原文：Set step inverted state
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