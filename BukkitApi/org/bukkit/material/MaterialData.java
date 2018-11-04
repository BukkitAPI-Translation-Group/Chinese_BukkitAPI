package org.bukkit.material;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

/**
 * 为某些物品或方块处理特定的元数据.
 *
 * @deprecated 所有关于MaterialData的用法已过时，并且将来会被移除.
 * 请使用 {@link BlockData}.
 */
@Deprecated
public class MaterialData implements Cloneable {
    private final Material type;
    private byte data = 0;

    public MaterialData(final Material type) {
        this(type, (byte) 0);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MaterialData(final Material type, final byte data) {
        this.type = type;
        this.data = data;
    }

    /**
     * 获取此物品的原始数据值.
     * <p>
     * 原文:Gets the raw data in this material
     *
     * @return 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * 设置此物品的原始数据值.
     * <p>
     * 原文:Sets the raw data of this material
     *
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void setData(byte data) {
        this.data = data;
    }

    /**
     * 获取此MaterialData代表的Material.
     * <p>
     * 原文:Gets the Material that this MaterialData represents
     *
     * @return 此MaterialData代表的Material物品
     */
    public Material getItemType() {
        return type;
    }

    /**
     * 基于此MaterialData创建一个新的物品堆实例.
     * <p>
     * 原文:Creates a new ItemStack based on this MaterialData
     *
     * @return 包含此MaterialData所含数据的ItemStack实例
     * @deprecated 该方法创建了一个堆叠数为0的物品堆，一般没什么用.
     * 请考虑 {@link #toItemStack(int)}.
     */
    @Deprecated
    public ItemStack toItemStack() {
        return new ItemStack(type, 0, data);
    }

    /**
     * 基于此MaterialData创建一个新的物品堆实例.
     * <p>
     * 原文:Creates a new ItemStack based on this MaterialData
     *
     * @param amount 物品堆叠数量
     * @return 包含此MaterialData所含数据的ItemStack实例
     */
    public ItemStack toItemStack(int amount) {
        return new ItemStack(type, amount, data);
    }

    @Override
    public String toString() {
        return getItemType() + "(" + getData() + ")";
    }

    @Override
    public int hashCode() {
        return ((getItemType().hashCode() << 8) ^ getData());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MaterialData) {
            MaterialData md = (MaterialData) obj;

            return (md.getItemType() == getItemType() && md.getData() == getData());
        } else {
            return false;
        }
    }

    @Override
    public MaterialData clone() {
        try {
            return (MaterialData) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}
