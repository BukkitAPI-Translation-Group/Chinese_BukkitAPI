package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表一个红石火把。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class RedstoneTorch extends Torch implements Redstone {
    public RedstoneTorch() {
        super(Material.LEGACY_REDSTONE_TORCH_ON);
    }

    public RedstoneTorch(final Material type) {
        super(type);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public RedstoneTorch(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取此材质的当前状态，指示其是否已通电。
     *
     * @return 如果已通电则返回 true，否则返回 false
     * <p>原文：Gets the current state of this Material, indicating if it's powered or
     * unpowered
     */
    @Override
    public boolean isPowered() {
        return getItemType() == Material.LEGACY_REDSTONE_TORCH_ON;
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public RedstoneTorch clone() {
        return (RedstoneTorch) super.clone();
    }
}