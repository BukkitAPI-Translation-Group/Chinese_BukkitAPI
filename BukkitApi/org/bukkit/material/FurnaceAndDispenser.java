package org.bukkit.material;

import org.bukkit.Material;

/**
 * 代表熔炉或发射器，两种定向容器.
 */
public class FurnaceAndDispenser extends DirectionalContainer {

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FurnaceAndDispenser(final int type) {
        super(type);
    }

    public FurnaceAndDispenser(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FurnaceAndDispenser(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FurnaceAndDispenser(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public FurnaceAndDispenser clone() {
        return (FurnaceAndDispenser) super.clone();
    }
}
