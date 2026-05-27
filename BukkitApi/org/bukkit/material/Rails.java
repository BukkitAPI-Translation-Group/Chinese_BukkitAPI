package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表矿车铁轨。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Rails extends MaterialData {

    public Rails() {
        super(Material.LEGACY_RAILS);
    }

    public Rails(final Material type) {
        super(type);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public Rails(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * @return 该铁轨是否设置在斜坡上
     * <p>原文：the whether this track is set on a slope
     */
    public boolean isOnSlope() {
        byte d = getConvertedData();

        return (d == 0x2 || d == 0x3 || d == 0x4 || d == 0x5);
    }

    /**
     * @return 该铁轨是否设置为弯道
     * <p>原文：the whether this track is set as a curve
     */
    public boolean isCurve() {
        byte d = getConvertedData();

        return (d == 0x6 || d == 0x7 || d == 0x8 || d == 0x9);
    }

    /**
     * @return 这些铁轨设置的方向
     *     <p>
     *     注意铁轨是双向的，如果铁轨设置在斜坡上，返回的方向是上升方向。
     *     如果设置为弯道，则返回铁轨的拐角方向。
     * <p>原文：the direction these tracks are set
     *     <p>
     *     Note that tracks are bidirectional and that the direction returned
     *     is the ascending direction if the track is set on a slope. If it is
     *     set as a curve, the corner of the track is returned.
     */
    public BlockFace getDirection() {
        byte d = getConvertedData();

        switch (d) {
        case 0x0:
        default:
            return BlockFace.SOUTH;

        case 0x1:
            return BlockFace.EAST;

        case 0x2:
            return BlockFace.EAST;

        case 0x3:
            return BlockFace.WEST;

        case 0x4:
            return BlockFace.NORTH;

        case 0x5:
            return BlockFace.SOUTH;

        case 0x6:
            return BlockFace.NORTH_WEST;

        case 0x7:
            return BlockFace.NORTH_EAST;

        case 0x8:
            return BlockFace.SOUTH_EAST;

        case 0x9:
            return BlockFace.SOUTH_WEST;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getDirection() + (isCurve() ? " on a curve" : (isOnSlope() ? " on a slope" : ""));
    }

    /**
     * 返回不包含 {@link PoweredRail} 和 {@link DetectorRail} 使用的扩展属性的数据。
     * 在 {@link ExtendedRails} 中被重写。
     *
     * @return 不包含扩展部分的数据
     * @deprecated 魔法值
     * <p>原文：Return the data without the extended properties used by {@link
     * PoweredRail} and {@link DetectorRail}. Overridden in {@link
     * ExtendedRails}
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    protected byte getConvertedData() {
        return getData();
    }

    /**
     * 设置这些铁轨的方向。
     * <p>
     * 注意铁轨是双向的，如果铁轨设置在斜坡上，返回的方向是上升方向。
     * 如果设置为弯道，则应提供铁轨的拐角方向。
     *
     * @param face 铁轨应朝向的方向
     * @param isOnSlope 铁轨是否应设置在斜坡上
     * <p>原文：Set the direction of these tracks
     * <p>原文：Note that tracks are bidirectional and that the direction returned is
     * the ascending direction if the track is set on a slope. If it is set as
     * a curve, the corner of the track should be supplied.
     */
    public void setDirection(BlockFace face, boolean isOnSlope) {
        switch (face) {
        case EAST:
            setData((byte) (isOnSlope ? 0x2 : 0x1));
            break;

        case WEST:
            setData((byte) (isOnSlope ? 0x3 : 0x1));
            break;

        case NORTH:
            setData((byte) (isOnSlope ? 0x4 : 0x0));
            break;

        case SOUTH:
            setData((byte) (isOnSlope ? 0x5 : 0x0));
            break;

        case NORTH_WEST:
            setData((byte) 0x6);
            break;

        case NORTH_EAST:
            setData((byte) 0x7);
            break;

        case SOUTH_EAST:
            setData((byte) 0x8);
            break;

        case SOUTH_WEST:
            setData((byte) 0x9);
            break;
        }
    }

    @Override
    public Rails clone() {
        return (Rails) super.clone();
    }
}