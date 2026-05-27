package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表一个动力铁轨
 *
 * @deprecated 所有 MaterialData 的使用都已弃用并可能被移除。
 * 使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class PoweredRail extends ExtendedRails implements Redstone {
    public PoweredRail() {
        super(Material.LEGACY_POWERED_RAIL);
    }

    public PoweredRail(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public PoweredRail(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * 设置此动力铁轨是否应该通电。
     *
     * @param isPowered 铁轨是否通电
     * <p>
     * 原文：Set whether this PoweredRail should be powered or not.
     */
    public void setPowered(boolean isPowered) {
        setData((byte) (isPowered ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    @Override
    public PoweredRail clone() {
        return (PoweredRail) super.clone();
    }
}