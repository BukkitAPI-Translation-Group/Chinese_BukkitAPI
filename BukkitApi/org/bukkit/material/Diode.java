package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 这是红石中继器
 */
public class Diode extends MaterialData implements Directional {
    public Diode() {
        super(Material.DIODE_BLOCK_ON);
    }

    /**
     * @param type 原始类型id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Diode(int type) {
        super(type);
    }

    public Diode(Material type) {
        super(type);
    }

    /**
     * @param type 原始类型id
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Diode(int type, byte data) {
        super(type, data);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Diode(Material type, byte data) {
        super(type, data);
    }

    /**
     * 设置这个红石中继器的延迟/时钟(以刻为单位)
     * <p>
     * 原文：Sets the delay of the repeater
     *
     * @param delay 新的延迟(1-4)
     */
    public void setDelay(int delay) {
        if (delay > 4) {
            delay = 4;
        }
        if (delay < 1) {
            delay = 1;
        }
        byte newData = (byte) (getData() & 0x3);

        setData((byte) (newData | ((delay - 1) << 2)));
    }

    /**
     * 获取这个红石中继器的延迟
     * <p>
     * 原文：Gets the delay of the repeater in ticks
     *
     * @return 延迟(1-4)
     */
    public int getDelay() {
        return (getData() >> 2) + 1;
    }

    public void setFacingDirection(BlockFace face) {
        int delay = getDelay();
        byte data;

        switch (face) {
        case EAST:
            data = 0x1;
            break;

        case SOUTH:
            data = 0x2;
            break;

        case WEST:
            data = 0x3;
            break;

        case NORTH:
        default:
            data = 0x0;
        }

        setData(data);
        setDelay(delay);
    }

    public BlockFace getFacing() {
        byte data = (byte) (getData() & 0x3);

        switch (data) {
        case 0x0:
        default:
            return BlockFace.NORTH;

        case 0x1:
            return BlockFace.EAST;

        case 0x2:
            return BlockFace.SOUTH;

        case 0x3:
            return BlockFace.WEST;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + " with " + getDelay() + " ticks delay";
    }

    @Override
    public Diode clone() {
        return (Diode) super.clone();
    }
}