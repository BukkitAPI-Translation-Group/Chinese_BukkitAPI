package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表一张床。
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Bed extends MaterialData implements Directional {

    /**
     * 床的默认构造方法。
     * <p>
     * 原文：Default constructor for a bed.
     */
    public Bed() {
        super(Material.LEGACY_BED_BLOCK);
    }

    /**
     * 实例化一个朝向特定方向的床。
     *
     * @param direction 床头朝向的方向
     * <p>
     * 原文：Instantiate a bed facing in a particular direction.
     */
    public Bed(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    public Bed(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public Bed(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 判断此方块是否代表床头。
     *
     * @return 如果是床头则返回 true，如果是床尾则返回 false
     * <p>
     * 原文：Determine if this block represents the head of the bed
     */
    public boolean isHeadOfBed() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置此方块为床头或床尾。
     *
     * @param isHeadOfBed 设为 true 则使其成为床头。
     * <p>
     * 原文：Configure this to be either the head or the foot of the bed
     */
    public void setHeadOfBed(boolean isHeadOfBed) {
        setData((byte) (isHeadOfBed ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    /**
     * 设置床头的朝向。注意这只会
     * 影响组成床的两个方块中的一个。
     * <p>
     * 原文：Set which direction the head of the bed is facing. Note that this will only affect one of the two blocks the bed is made of.
     */
    @Override
    public void setFacingDirection(BlockFace face) {
        byte data;

        switch (face) {
        case SOUTH:
            data = 0x0;
            break;

        case WEST:
            data = 0x1;
            break;

        case NORTH:
            data = 0x2;
            break;

        case EAST:
        default:
            data = 0x3;
        }

        if (isHeadOfBed()) {
            data |= 0x8;
        }

        setData(data);
    }

    /**
     * 获取此床头的朝向方向。
     *
     * @return 床头朝向的方向
     * <p>
     * 原文：Get the direction that this bed's head is facing toward
     */
    @Override
    public BlockFace getFacing() {
        byte data = (byte) (getData() & 0x7);

        switch (data) {
        case 0x0:
            return BlockFace.SOUTH;

        case 0x1:
            return BlockFace.WEST;

        case 0x2:
            return BlockFace.NORTH;

        case 0x3:
        default:
            return BlockFace.EAST;
        }
    }

    @Override
    public String toString() {
        return (isHeadOfBed() ? "HEAD" : "FOOT") + " of " + super.toString() + " facing " + getFacing();
    }

    @Override
    public Bed clone() {
        return (Bed) super.clone();
    }
}