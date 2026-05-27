package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表一个拉杆
 *
 * @deprecated 所有 MaterialData 的使用都已弃用并可能被移除。
 * 使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Lever extends SimpleAttachableMaterialData implements Redstone {
    public Lever() {
        super(Material.LEGACY_LEVER);
    }

    public Lever(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public Lever(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取此材质的当前状态，指示其是否已通电
     *
     * @return 如果已通电则返回true，否则返回false
     * <p>
     * 原文：Gets the current state of this Material, indicating if it's powered or unpowered
     */
    @Override
    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置此拉杆是否通电。
     *
     * @param isPowered 拉杆是否应该通电
     * <p>
     * 原文：Set this lever to be powered or not.
     */
    public void setPowered(boolean isPowered) {
        setData((byte) (isPowered ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    /**
     * 获取此方块所附着的面
     *
     * @return 附着的BlockFace
     * <p>
     * 原文：Gets the face that this block is attached on
     */
    @Override
    public BlockFace getAttachedFace() {
        byte data = (byte) (getData() & 0x7);

        switch (data) {
        case 0x1:
            return BlockFace.WEST;

        case 0x2:
            return BlockFace.EAST;

        case 0x3:
            return BlockFace.NORTH;

        case 0x4:
            return BlockFace.SOUTH;

        case 0x5:
        case 0x6:
            return BlockFace.DOWN;

        case 0x0:
        case 0x7:
            return BlockFace.UP;

        }

        return null;
    }

    /**
     * 设置此拉杆指向的方向
     * <p>
     * 原文：Sets the direction this lever is pointing in
     */
    @Override
    public void setFacingDirection(BlockFace face) {
        byte data = (byte) (getData() & 0x8);
        BlockFace attach = getAttachedFace();

        if (attach == BlockFace.DOWN) {
            switch (face) {
            case SOUTH:
            case NORTH:
                data |= 0x5;
                break;

            case EAST:
            case WEST:
                data |= 0x6;
                break;
            }
        } else if (attach == BlockFace.UP) {
            switch (face) {
            case SOUTH:
            case NORTH:
                data |= 0x7;
                break;

            case EAST:
            case WEST:
                data |= 0x0;
                break;
            }
        } else {
            switch (face) {
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
            }
        }
        setData(data);
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public Lever clone() {
        return (Lever) super.clone();
    }
}