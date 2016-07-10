package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 * 代表开启或关闭状态的红石中继器.
 *
 * @see Material#DIODE_BLOCK_OFF
 * @see Material#DIODE_BLOCK_ON
 */
public class Diode extends MaterialData implements Directional, Redstone {

    protected static final BlockFace DEFAULT_DIRECTION = BlockFace.NORTH;
    protected static final int DEFAULT_DELAY = 1;
    protected static final boolean DEFAULT_STATE = false;

    /**
     * 构造一个开启状态的、1延迟、默认朝向（北）的红石中继器.
     *
     * 默认情况下这个构造器创建的是开启状态的红石中继器，为了兼容之前的实现.
     * <p>
     * 原文:Constructs a diode switched on, with a delay of 1 and facing the default
     * direction (north).
     *
     * By default this constructor creates a diode that is switched on for
     * backwards compatibility with past implementations.
     */
    public Diode() {
        this(DEFAULT_DIRECTION, DEFAULT_DELAY, true);
    }

    /**
     * 构造一个关闭状态的、1延迟、指定朝向的红石中继器.
     * <p>
     * 原文:Constructs a diode switched off, with a delay of 1 and facing the
     * specified direction.
     *
     * @param facingDirection 朝向
     *
     * @see BlockFace
     */
    public Diode(BlockFace facingDirection) {
        this(facingDirection, DEFAULT_DELAY, DEFAULT_STATE);
    }

    /**
     * 构造一个关闭状态的、指定延迟、指定朝向的红石中继器.
     * <p>
     * 原文:Constructs a diode switched off, with the specified delay and facing the
     * specified direction.
     *
     * @param facingDirection 朝向
     * @param delay 红石刻 (1-4)
     *
     * @see BlockFace
     */
    public Diode(BlockFace facingDirection, int delay) {
        this(facingDirection, delay, DEFAULT_STATE);
    }

    /**
     * 构造一个开启或关闭状态的、指定延迟、指定朝向的红石中继器.
     * <p>
     * 原文:Constructs a diode switched on or off, with the specified delay and
     * facing the specified direction.
     *
     * @param facingDirection 朝向
     * @param delay 刻 (1-4)
     * @param state 激活状态
     *
     * @see BlockFace
     */
    public Diode(BlockFace facingDirection, int delay, boolean state) {
        super(state ? Material.DIODE_BLOCK_ON : Material.DIODE_BLOCK_OFF);
        setFacingDirection(facingDirection);
        setDelay(delay);
    }

    /**
     * @param type the raw type id
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
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Diode(int type, byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Diode(Material type, byte data) {
        super(type, data);
    }

    /**
     * 设置这个红石中继器的延迟.
     * <p>
     * 原文:Sets the delay of the repeater.
     *
     * @param delay 延迟 (1-4)
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
     * 获取这个红石中继器的延迟 (以刻为单位).
     * <p>
     * 原文:Gets the delay of the repeater in ticks.
     *
     * @return 延迟 (1-4)
     */
    public int getDelay() {
        return (getData() >> 2) + 1;
    }

    /**
     * 设置这个红石中继器的朝向.
     * <p>
     * 原文:Sets the direction this diode is facing.
     *
     * @param face 朝向
     *
     * @see BlockFace
     */
    @Override
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

    /**
     * 获取这个红石中继器的朝向.
     * <p>
     * 原文:Gets the direction this diode is facing
     *
     * @return 这个红石中继器的朝向
     *
     * @see BlockFace
     */
    @Override
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

    /**
     * 检测这个红石中继器是否充能.
     * <p>
     * 原文：Checks if the diode is powered.
     *
     * @return 这个红石中继器是否充能
     */
    @Override
    public boolean isPowered() {
        return getItemType() == Material.DIODE_BLOCK_ON;
    }
}
