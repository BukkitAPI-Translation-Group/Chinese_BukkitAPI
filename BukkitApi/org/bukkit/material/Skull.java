package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表头颅.
 */
public class Skull extends MaterialData implements Directional {
    public Skull() {
        super(Material.SKULL);
    }

    /**
     * 实例化一个特定朝向的头颅.
     * <p>
     * 原文:Instantiate a skull facing in a particular direction.
     *
     * @param direction 头颅的朝向
     */
    public Skull(BlockFace direction) {
        this();
        setFacingDirection(direction);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Skull(final int type) {
        super(type);
    }

    public Skull(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Skull(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Skull(final Material type, final byte data) {
        super(type, data);
    }

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