package org.bukkit.material;

import java.util.List;
import org.bukkit.Material;

/**
 * 代表带有纹理的材质，如台阶和平滑砖。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public abstract class TexturedMaterial extends MaterialData {

    public TexturedMaterial(Material m) {
        super(m);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public TexturedMaterial(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 检索可用纹理的列表。列表的第一个元素将用作默认值。
     *
     * @return 此方块可用纹理的列表
     * <p>原文：Retrieve a list of possible textures. The first element of the list
     * will be used as a default.
     */
    public abstract List<Material> getTextures();

    /**
     * 获取此方块当前构成的材质。
     *
     * @return 此方块的 Material
     * <p>原文：Gets the current Material this block is made of
     */
    public Material getMaterial() {
        int n = getTextureIndex();
        if (n > getTextures().size() - 1) {
            n = 0;
        }

        return getTextures().get(n);
    }

    /**
     * 设置此方块构成的材质。
     *
     * @param material
     *            此方块的新材质
     * <p>原文：Sets the material this block is made of
     */
    public void setMaterial(Material material) {
        if (getTextures().contains(material)) {
            setTextureIndex(getTextures().indexOf(material));
        } else {
            setTextureIndex(0x0);
        }
    }

    /**
     * 从数据中获取材质索引。
     *
     * @return 数据在纹理列表中的索引
     * @deprecated 魔法值
     * <p>原文：Get material index from data
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    protected int getTextureIndex() {
        return getData(); // Default to using all bits - override for other mappings
    }

    /**
     * 设置材质索引。
     *
     * @param idx - 数据在纹理列表中的索引
     * @deprecated 魔法值
     * <p>原文：Set material index
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    protected void setTextureIndex(int idx) {
        setData((byte) idx); // Default to using all bits - override for other mappings
    }

    @Override
    public String toString() {
        return getMaterial() + " " + super.toString();
    }

    @Override
    public TexturedMaterial clone() {
        return (TexturedMaterial) super.clone();
    }
}