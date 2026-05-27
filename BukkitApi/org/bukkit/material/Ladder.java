package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表梯子数据。
 *
 * @deprecated 所有 MaterialData 的用法均已弃用且将被移除.
 * 请使用 {@link org.bukkit.block.data.BlockData}.
 */
@Deprecated(since = "1.14.1")
public class Ladder extends SimpleAttachableMaterialData {
    public Ladder() {
        super(Material.LEGACY_LADDER);
    }

    public Ladder(final Material type) {
        super(type);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public Ladder(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取此方块所附着的面。
     * <p>原文：Gets the face that this block is attached on
     *
     * @return BlockFace attached to
     */
    @Override
    public BlockFace getAttachedFace() {
        byte data = getData();

        switch (data) {
        case 0x2:
            return BlockFace.SOUTH;

        case 0x3:
            return BlockFace.NORTH;

        case 0x4:
            return BlockFace.EAST;

        case 0x5:
            return BlockFace.WEST;
        }

        return null;
    }

    /**
     * 设置此梯子面向的方向。
     * <p>原文：Sets the direction this ladder is facing
     */
    @Override
    public void setFacingDirection(BlockFace face) {
        byte data = (byte) 0x0;

        switch (face) {
        case SOUTH:
            data = 0x2;
            break;

        case NORTH:
            data = 0x3;
            break;

        case EAST:
            data = 0x4;
            break;

        case WEST:
            data = 0x5;
            break;
        }

        setData(data);

    }

    @Override
    public Ladder clone() {
        return (Ladder) super.clone();
    }
}