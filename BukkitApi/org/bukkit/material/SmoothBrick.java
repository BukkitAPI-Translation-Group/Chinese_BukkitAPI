package org.bukkit.material;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;

/**
 * 代表不同类型的平滑砖。
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class SmoothBrick extends TexturedMaterial {

    private static final List<Material> textures = new ArrayList<Material>();
    static {
        textures.add(Material.LEGACY_STONE);
        textures.add(Material.LEGACY_MOSSY_COBBLESTONE);
        textures.add(Material.LEGACY_COBBLESTONE);
        textures.add(Material.LEGACY_SMOOTH_BRICK);
    }

    public SmoothBrick() {
        super(Material.LEGACY_SMOOTH_BRICK);
    }

    public SmoothBrick(final Material type) {
        super((textures.contains(type)) ? Material.LEGACY_SMOOTH_BRICK : type);
        if (textures.contains(type)) {
            setMaterial(type);
        }
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.6.2")
    public SmoothBrick(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public List<Material> getTextures() {
        return textures;
    }

    @Override
    public SmoothBrick clone() {
        return (SmoothBrick) super.clone();
    }
}