package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表一个按钮。
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Button extends SimpleAttachableMaterialData implements Redstone {
    public Button() {
        super(Material.LEGACY_STONE_BUTTON);
    }

    public Button(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public Button(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取此材质的当前状态，指示其是否被激活。
     *
     * @return 如果被激活则返回 true，否则返回 false
     * <p>
     * 原文：Gets the current state of this Material, indicating if it's powered or unpowered
     */
    @Override
    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置此按钮的当前状态。
     *
     * @param bool 按钮是否被激活
     * <p>
     * 原文：Sets the current state of this button
     */
    public void setPowered(boolean bool) {
        setData((byte) (bool ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    /**
     * 获取此方块所附着的面。
     *
     * @return 附着的 BlockFace
     * <p>
     * 原文：Gets the face that this block is attached on
     */
    @Override
    public BlockFace getAttachedFace() {
        byte data = (byte) (getData() & 0x7);

        switch (data) {
        case 0x0:
            return BlockFace.UP;

        case 0x1:
            return BlockFace.WEST;

        case 0x2:
            return BlockFace.EAST;

        case 0x3:
            return BlockFace.NORTH;

        case 0x4:
            return BlockFace.SOUTH;

        case 0x5:
            return BlockFace.DOWN;
        }

        return null;
    }

    /**
     * 设置此按钮指向的方向。
     * <p>
     * 原文：Sets the direction this button is pointing toward
     */
    @Override
    public void setFacingDirection(BlockFace face) {
        byte data = (byte) (getData() & 0x8);

        switch (face) {
        case DOWN:
            data |= 0x0;
            break;

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

        case UP:
            data |= 0x5;
            break;
        }

        setData(data);
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public Button clone() {
        return (Button) super.clone();
    }
}