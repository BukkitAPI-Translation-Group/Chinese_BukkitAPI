package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 活塞延伸方块的材质数据
 *
 * @deprecated 所有 MaterialData 的使用都已弃用并可能被移除。
 * 使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class PistonExtensionMaterial extends MaterialData implements Attachable {

    public PistonExtensionMaterial(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public PistonExtensionMaterial(final Material type, final byte data) {
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

    /**
     * 检查此活塞延伸是否为粘性活塞，如果是则返回true
     *
     * @return 如果此活塞是"粘性"的则返回true，否则返回false
     * <p>
     * 原文：Checks if this piston extension is sticky, and returns true if so
     */
    public boolean isSticky() {
        return (getData() & 8) == 8;
    }

    /**
     * 设置此延伸是否为粘性
     *
     * @param sticky 如果是粘性则为true，否则为false
     * <p>
     * 原文：Sets whether or not this extension is sticky
     */
    public void setSticky(boolean sticky) {
        setData((byte) (sticky ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    @Override
    public BlockFace getAttachedFace() {
        return getFacing().getOppositeFace();
    }

    @Override
    public PistonExtensionMaterial clone() {
        return (PistonExtensionMaterial) super.clone();
    }
}