package org.bukkit.material;

import org.bukkit.CropState;
import org.bukkit.Material;

/**
 * 代表不同种类处于不同生长阶段的农作物
 *
 * @see Material#CROPS
 * @see Material#CARROT
 * @see Material#POTATO
 * @see Material#BEETROOT_BLOCK
 * @see Material#NETHER_WARTS
 */
public class Crops extends MaterialData {
    protected static final Material DEFAULT_TYPE = Material.CROPS;
    protected static final CropState DEFAULT_STATE = CropState.SEEDED;

    /**
     * 构造一个处于播种阶段的小麦作物方块.
     * <p>
     * 原文:Constructs a wheat crop block in the seeded state.
     */
    public Crops() {
        this(DEFAULT_TYPE, DEFAULT_STATE);
    }

    /**
     * 构造一个处于给定生长阶段的小麦作物方块.
     * <p>
     * 原文:Constructs a wheat crop block in the given growth state
     *
     * @param state 农作物的生长阶段
     */
    public Crops(CropState state) {
        this(DEFAULT_TYPE, state);
        setState(state);
    }

    /**
     * 构造一个处于给定生长阶段的给定类型的农作物方块.
     * <p>
     * 原文:Constructs a crop block of the given type and in the given growth state
     *
     * @param type 农作物类型
     * @param state 农作物的生长阶段
     */
    public Crops(final Material type, final CropState state) {
        super(type);
        setState(state);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Crops(final int type) {
        super(type);
    }

    /**
     * 构造一个处于播种阶段的给定类型的农作物.
     * <p>
     * 原文:Constructs a crop block of the given type and in the seeded state
     *
     * @param type 农作物类型
     */
    public Crops(final Material type) {
        this(type, DEFAULT_STATE);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Crops(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Crops(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取这个农作物的生长阶段.
     * <p>
     * 对于像是甜菜根这样只有四个生长阶段的农作物，只会返回这四个值：SEEDED、SMALL、TALL、RIPE.
     * <p>
     * 原文:Gets the current growth state of this crop
     *
     * For crops with only four growth states such as beetroot, only the values SEEDED, SMALL, TALL and RIPE will be
     * returned.
     *
     * @return 农作物的CropState
     */
    public CropState getState() {
        switch (getItemType()) {
            case CROPS:
            case CARROT:
            case POTATO:
                // Mask the data just in case top bit set
                return CropState.getByData((byte) (getData() & 0x7));
            case BEETROOT_BLOCK:
            case NETHER_WARTS:
                // Mask the data just in case top bits are set
                // Will return SEEDED, SMALL, TALL, RIPE for the three growth data values
                return CropState.getByData((byte) (((getData() & 0x3) * 7 + 2) / 3));
            default:
                throw new IllegalArgumentException("Block type is not a crop");
        }
    }

    /**
     * 设置这个农作物的生长阶段.
     * <p>
     * 对于像是甜菜根这样只有四个生长阶段的农作物，这8个生长阶段分别映射为这四个阶段:
     *
     * SEEDED, SMALL, TALL 和 RIPE
     *
     * GERMINATED 会改为 SEEDED
     * VERY_SMALL 会改为 SMALL
     * MEDIUM 会改为 TALL
     * VERY_TALL 会改为 RIPE
     * <p>
     * 原文:Sets the growth state of this crop
     *
     * For crops with only four growth states such as beetroot, the 8 CropStates are mapped into four states:
     *
     * SEEDED, SMALL, TALL and RIPE
     *
     * GERMINATED will change to SEEDED
     * VERY_SMALL will change to SMALL
     * MEDIUM will change to TALL
     * VERY_TALL will change to RIPE
     *
     * @param state 农作物的生长阶段
     */
    public void setState(CropState state) {
        switch (getItemType()) {
            case CROPS:
            case CARROT:
            case POTATO:
                // Preserve the top bit in case it is set
                setData((byte) ((getData() & 0x8) | state.getData()));
                break;
            case NETHER_WARTS:
            case BEETROOT_BLOCK:
                // Preserve the top bits in case they are set
                setData((byte) ((getData() & 0xC) | (state.getData() >> 1)));
                break;
            default:
                throw new IllegalArgumentException("Block type is not a crop");
        }
    }

    @Override
    public String toString() {
        return getState() + " " + super.toString();
    }

    @Override
    public Crops clone() {
        return (Crops) super.clone();
    }
}
