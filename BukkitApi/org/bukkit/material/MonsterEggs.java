package org.bukkit.material;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;

/**
 * 代表不同类型的怪物蛋
 *
 * @deprecated 所有 MaterialData 的使用都已弃用并可能被移除。
 * 使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class MonsterEggs extends TexturedMaterial {

    private static final List<Material> textures = new ArrayList<Material>();
    static {
        textures.add(Material.LEGACY_STONE);
        textures.add(Material.LEGACY_COBBLESTONE);
        textures.add(Material.LEGACY_SMOOTH_BRICK);
    }

    public MonsterEggs() {
        super(Material.LEGACY_MONSTER_EGGS);
    }

    public MonsterEggs(final Material type) {
        super((textures.contains(type)) ? Material.LEGACY_MONSTER_EGGS : type);
        if (textures.contains(type)) {
            setMaterial(type);
        }
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 魔法值
     */
    @Deprecated(since = "1.6.2")
    public MonsterEggs(final Material type, final byte data) {
        super(type, data);
    }

    @Override
    public List<Material> getTextures() {
        return textures;
    }

    @Override
    public MonsterEggs clone() {
        return (MonsterEggs) super.clone();
    }
}