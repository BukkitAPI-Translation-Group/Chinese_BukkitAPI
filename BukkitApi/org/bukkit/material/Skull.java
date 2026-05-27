package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表一个头颅。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Skull extends MaterialData implements Directional {
    public Skull() {
        super(Material.LEGACY_SKULL);
    }

    /**
     * 实例化一个朝向特定方向的头颅。
     *
     * @param direction 头颅面部朝向的方向
     * <p>原文：Instantiate a skull facing in a particular direction.
     */
    public Skull(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    public Skull(final Material type) {
        super(type);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public Skull(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public void setFacingDirection(BlockFace face) {
        int data;

        switch (face) {
            case SELF:
            default:
                data = 0x1;
                break;

            case NORTH:
                data = 0x2;
                break;

            case WEST:
                data = 0x4;
                break;

            case SOUTH:
                data = 0x3;
                break;

            case EAST:
                data = 0x5;
        }

        setData((byte) data);
    }

    @Override
    public BlockFace getFacing() {
        int data = getData();

        switch (data) {
            case 0x1:
            default:
                return BlockFace.SELF;

            case 0x2:
                return BlockFace.NORTH;

            case 0x3:
                return BlockFace.SOUTH;

            case 0x4:
                return BlockFace.WEST;

            case 0x5:
                return BlockFace.EAST;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing();
    }

    @Override
    public Skull clone() {
        return (Skull) super.clone();
    }
}