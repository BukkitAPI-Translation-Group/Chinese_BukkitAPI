package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表熔炉或发射器，两种类型的定向容器。
 *
 * @deprecated 所有 MaterialData 的用法均已弃用并可能被移除。请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class FurnaceAndDispenser extends DirectionalContainer {

    public FurnaceAndDispenser(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public FurnaceAndDispenser(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public FurnaceAndDispenser clone() {
        return (FurnaceAndDispenser) super.clone();
    }
}