package org.bukkit.material;

import org.bukkit.GrassSpecies;
import org.bukkit.Material;

/**
 * 代表两种不同的草丛.
 */
public class LongGrass extends MaterialData {
    public LongGrass() {
        super(Material.LONG_GRASS);
    }

    public LongGrass(GrassSpecies species) {
        this();
        setSpecies(species);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public LongGrass(final int type) {
        super(type);
    }

    public LongGrass(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public LongGrass(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public LongGrass(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取草丛的种类.
     * <p>
     * 原文:Gets the current species of this grass
     *
     * @return 草丛的 GrassSpecies
     */
    public GrassSpecies getSpecies() {
        return GrassSpecies.getByData(getData());
    }

    /**
     * 设置草丛的种类.
     * <p>
     * 原文:Sets the species of this grass
     *
     * @param species 草丛的新种类
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
