package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.NetherWartsState;

/**
 * 代表地狱疣
 *
 * @deprecated 所有 MaterialData 的使用都已弃用并可能被移除。
 * 使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class NetherWarts extends MaterialData {
    public NetherWarts() {
        super(Material.LEGACY_NETHER_WARTS);
    }

    public NetherWarts(NetherWartsState state) {
        this();
        setState(state);
    }

    public NetherWarts(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public NetherWarts(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取此地狱疣的当前生长状态
     *
     * @return 此地狱疣的NetherWartsState
     * <p>
     * 原文：Gets the current growth state of this nether wart
     */
    public NetherWartsState getState() {
        switch (getData()) {
            case 0:
                return NetherWartsState.SEEDED;
            case 1:
                return NetherWartsState.STAGE_ONE;
            case 2:
                return NetherWartsState.STAGE_TWO;
            default:
                return NetherWartsState.RIPE;
        }
    }

    /**
     * 设置此地狱疣的生长状态
     *
     * @param state 此地狱疣的新生长状态
     * <p>
     * 原文：Sets the growth state of this nether wart
     */
    public void setState(NetherWartsState state) {
        switch (state) {
            case SEEDED:
                setData((byte) 0x0);
                return;
            case STAGE_ONE:
                setData((byte) 0x1);
                return;
            case STAGE_TWO:
                setData((byte) 0x2);
                return;
            case RIPE:
                setData((byte) 0x3);
                return;
        }
    }

    @Override
    public String toString() {
        return getState() + " " + super.toString();
    }

    @Override
    public NetherWarts clone() {
        return (NetherWarts) super.clone();
    }
}