package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 活塞底座方块的材质数据
 *
 * @deprecated 所有 MaterialData 的使用都已弃用并可能被移除。
 * 使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class PistonBaseMaterial extends MaterialData implements Directional, Redstone {

    public PistonBaseMaterial(final Material type) {
        super(type);
    }

    /**
     * 构造一个PistonBaseMaterial。
     *
     * @param type 要使用的材质类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public PistonBaseMaterial(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public void setFacingDirection(BlockFace face) {
        byte data = (byte) (getData() & 0x8);

        switch (face) {
        case UP:
            data |= 1;
            break;
        case NORTH:
            data |= 2;
            break;
        case SOUTH:
            data |= 3;
            break;
        case WEST:
            data |= 4;
            break;
        case EAST:
            data |= 5;
            break;
        }
        setData(data);
    }

    @Override
    public BlockFace getFacing() {
        byte dir = (byte) (getData() & 7);

        switch (dir) {
        case 0:
            return BlockFace.DOWN;
        case 1:
            return BlockFace.UP;
        case 2:
            return BlockFace.NORTH;
        case 3:
            return BlockFace.SOUTH;
        case 4:
            return BlockFace.WEST;
        case 5:
            return BlockFace.EAST;
        default:
            return BlockFace.SELF;
        }
    }

    @Override
    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置此活塞的当前状态
     *
     * @param powered 如果活塞已伸出并通电则为true，否则为false
     * <p>
     * 原文：Sets the current state of this piston
     */
    public void setPowered(boolean powered) {
        setData((byte) (powered ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    /**
     * 检查此活塞底座是否为粘性活塞，如果是则返回true
     *
     * @return 如果此活塞是"粘性"的则返回true，否则返回false
     * <p>
     * 原文：Checks if this piston base is sticky, and returns true if so
     */
    public boolean isSticky() {
        return this.getItemType() == Material.LEGACY_PISTON_STICKY_BASE;
    }

    @Override
    public PistonBaseMaterial clone() {
        return (PistonBaseMaterial) super.clone();
    }
}