package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.meta.SpawnEggMeta;

/**
 * 代表刷怪蛋.
 * @deprecated 请使用 {@link SpawnEggMeta}
 */
@Deprecated
public class SpawnEgg extends MaterialData {

    public SpawnEgg() {
        super(Material.LEGACY_MONSTER_EGG);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public SpawnEgg(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public SpawnEgg(byte data) {
        super(Material.LEGACY_MONSTER_EGG, data);
    }

    public SpawnEgg(EntityType type) {
        this();
        setSpawnedType(type);
    }

    /**
     * 获取这个刷怪蛋刷出实体的种类.
     * <p>
     * 原文:Get the type of entity this egg will spawn.
     *
     * @return 实体种类
     * @deprecated 现存储在 {@link SpawnEggMeta}.
     */
    @Deprecated
    public EntityType getSpawnedType() {
        return EntityType.fromId(getData());
    }

    /**
     * 设置这个刷怪蛋刷出实体的种类.
     * <p>
     * 原文:Set the type of entity this egg will spawn.
     *
     * @param type 实体种类
     * @deprecated 现存储在 {@link SpawnEggMeta}.
     */
    @Deprecated
    public void setSpawnedType(EntityType type) {
        setData((byte) type.getTypeId());
    }

    @Override
    public String toString() {
        return "SPAWN EGG{" + getSpawnedType() + "}";
    }

    @Override
    public SpawnEgg clone() {
        return (SpawnEgg) super.clone();
    }
}
