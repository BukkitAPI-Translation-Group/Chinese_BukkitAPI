package org.bukkit.material;

import org.bukkit.GrassSpecies;
import org.bukkit.Material;

/**
 * 代表不同类型的高草。
 *
 * @deprecated 所有 MaterialData 的使用都已弃用并可能被移除。
 * 使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class LongGrass extends MaterialData {
    public LongGrass() {
        super(Material.LEGACY_LONG_GRASS);
    }

    public LongGrass(GrassSpecies species) {
        this();
        setSpecies(species);
    }

    public LongGrass(final Material type) {
        super(type);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public LongGrass(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取此草的当前种类
     *
     * @return 此草的GrassSpecies
     * <p>
     * 原文：Gets the current species of this grass
     */
    public GrassSpecies getSpecies() {
        return GrassSpecies.getByData(getData());
    }

    /**
     * 设置此草的种类
     *
     * @param species 此草的新种类
     * <p>
     * 原文：Sets the species of this grass
     */
    public void setSpecies(GrassSpecies species) {
        setData(species.getData());
    }

    @Override
    public String toString() {
        return getSpecies() + " " + super.toString();
    }

    @Override
    public LongGrass clone() {
        return (LongGrass) super.clone();
    }
}