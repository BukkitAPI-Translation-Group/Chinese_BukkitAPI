package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表可可植物。
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class CocoaPlant extends MaterialData implements Directional, Attachable {

    public enum CocoaPlantSize {
        SMALL,
        MEDIUM,
        LARGE
    }

    public CocoaPlant() {
        super(Material.LEGACY_COCOA);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public CocoaPlant(final Material type, final byte data) {
        super(type, data);
    }

    public CocoaPlant(CocoaPlantSize sz) {
        this();
        setSize(sz);
    }

    public CocoaPlant(CocoaPlantSize sz, BlockFace dir) {
        this();
        setSize(sz);
        setFacingDirection(dir);
    }

    /**
     * 获取植物的大小。
     *
     * @return 大小
     * <p>
     * 原文：Get size of plant
     */
    public CocoaPlantSize getSize() {
        switch (getData() & 0xC) {
            case 0:
                return CocoaPlantSize.SMALL;
            case 4:
                return CocoaPlantSize.MEDIUM;
            default:
                return CocoaPlantSize.LARGE;
        }
    }

    /**
     * 设置植物的大小。
     *
     * @param sz 植物的大小
     * <p>
     * 原文：Set size of plant
     */
    public void setSize(CocoaPlantSize sz) {
        int dat = getData() & 0x3;
        switch (sz) {
            case SMALL:
                break;
            case MEDIUM:
                dat |= 0x4;
                break;
            case LARGE:
                dat |= 0x8;
                break;
        }
        setData((byte) dat);
    }

    @Override
    public BlockFace getAttachedFace() {
        return getFacing().getOppositeFace();
    }

    @Override
    public void setFacingDirection(BlockFace face) {
        int dat = getData() & 0xC;
        switch (face) {
            default:
            case SOUTH:
                break;
            case WEST:
                dat |= 0x1;
                break;
            case NORTH:
                dat |= 0x2;
                break;
            case EAST:
                dat |= 0x3;
                break;
        }
        setData((byte) dat);
    }

    @Override
    public BlockFace getFacing() {
        switch (getData() & 0x3) {
            case 0:
                return BlockFace.SOUTH;
            case 1:
                return BlockFace.WEST;
            case 2:
                return BlockFace.NORTH;
            case 3:
                return BlockFace.EAST;
        }
        return null;
    }

    @Override
    public CocoaPlant clone() {
        return (CocoaPlant) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + " " + getSize();
    }
}