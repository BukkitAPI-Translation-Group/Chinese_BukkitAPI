package org.bukkit.material;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

/**
 * 代表不同种类的刷怪蛋
 */
public class MonsterEggs extends TexturedMaterial {

    private static final List<Material> textures = new ArrayList<Material>();
    static {
        textures.add(Material.STONE);
        textures.add(Material.COBBLESTONE);
        textures.add(Material.SMOOTH_BRICK);
    }

    public MonsterEggs() {
        super(Material.MONSTER_EGGS);
    }

    /**
     * @param type 原始类型id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MonsterEggs(final int type) {
        super(type);
    }

    public MonsterEggs(final Material type) {
        super((textures.contains(type)) ? Material.MONSTER_EGGS : type);
        if (textures.contains(type)) {
            setMaterial(type);
        }
    }

    /**
     * @param type 原始类型id
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public MonsterEggs(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type 类型
     * @param data 原始数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
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