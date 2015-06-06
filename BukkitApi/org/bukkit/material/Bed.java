package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表一个床。
 */
public class Bed extends MaterialData implements Directional {

    /**
     * 床的默认构造器。
	 * 原文：Default constructor for a bed.
     */
    public Bed() {
        super(Material.BED_BLOCK);
    }

    /**
     * 使用特定的朝向以实例化一个床。
     * 原文：Instantiate a bed facing in a particular direction.
     * @param direction 床头的朝向/the direction the bed's head is facing
     */
    public Bed(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    /**
     *
     * @param type 原种类id/the raw type id
     * @deprecated Magic value
     */
    @Deprecated
    public Bed(final int type) {
        super(type);
    }

    public Bed(final Material type) {
        super(type);
    }

    /**
     * @param type 原种类id/the raw type id
     * @param data 原数据值/the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public Bed(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type 种类/the type
     * @param data 原数据值/the raw data value
     * @deprecated Magic value
     */
    @Deprecated
    public Bed(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 限定于此方块是否代表床头
	 * 原文：Determine if this block represents the head of the bed
     *
     * @return true 方块是床头, false 如果不是
     */
    public boolean isHeadOfBed() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置方块是床头还是床尾
     * 原文：Configure this to be either the head or the foot of the bed
     *
     * @param isHeadOfBed 想要弄成床头就设成true/True to make it the head.
     */
    public void setHeadOfBed(boolean isHeadOfBed) {
        setData((byte) (isHeadOfBed ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    /**
     * 设置床头的朝向.注意这只会影响到两个方块的床。
     * 
     * 原文：Set which direction the head of the bed is facing. Note that this will
     * only affect one of the two blocks the bed is made of.
     */
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
     * 获取床头的朝向。
     * 原文：Get the direction that this bed's head is facing toward
     *
     * @return 床头的朝向/the direction the head of the bed is facing
     */
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
