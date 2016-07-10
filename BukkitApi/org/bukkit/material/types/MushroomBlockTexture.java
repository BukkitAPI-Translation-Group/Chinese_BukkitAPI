package org.bukkit.material.types;

import java.util.Map;

import org.bukkit.block.BlockFace;

import com.google.common.collect.Maps;

/**
 * 代表蘑菇方块的不同材质.
 */
public enum MushroomBlockTexture {

    /**
     * 各个面都是气孔材质
     */
    ALL_PORES(0, null),
    /**
     * 上面、西面和北面是蘑菇盖材质
     */
    CAP_NORTH_WEST(1, BlockFace.NORTH_WEST),
    /**
     * 上面和北面是蘑菇盖材质
     */
    CAP_NORTH(2, BlockFace.NORTH),
    /**
     * 上面、北面和东面是蘑菇盖材质
     */
    CAP_NORTH_EAST(3, BlockFace.NORTH_EAST),
    /**
     * 上面和西面是蘑菇盖材质
     */
    CAP_WEST(4, BlockFace.WEST),
    /**
     * 上面是蘑菇盖材质
     */
    CAP_TOP(5, BlockFace.UP),
    /**
     * 上面和东面是蘑菇盖材质
     */
    CAP_EAST(6, BlockFace.EAST),
    /**
     * 上面、南面和西面是蘑菇盖材质
     */
    CAP_SOUTH_WEST(7, BlockFace.SOUTH_WEST),
    /**
     * 上面和南面是蘑菇盖材质
     */
    CAP_SOUTH(8, BlockFace.SOUTH),
    /**
     * 上面、东面和南面是蘑菇盖材质
     */
    CAP_SOUTH_EAST(9, BlockFace.SOUTH_EAST),
    /**
     * 4个侧面都是蘑菇茎材质，上面和下面是气孔材质
     */
    STEM_SIDES(10, null),
    /**
     * 6个面都是蘑菇盖材质
     */
    ALL_CAP(14, BlockFace.SELF),
    /**
     * 6个面都是蘑菇茎材质
     */
    ALL_STEM(15, null);
    private final static Map<Byte, MushroomBlockTexture> BY_DATA = Maps.newHashMap();
    private final static Map<BlockFace, MushroomBlockTexture> BY_BLOCKFACE = Maps.newHashMap();

    private final Byte data;
    private final BlockFace capFace;

    private MushroomBlockTexture(final int data, final BlockFace capFace) {
        this.data = (byte) data;
        this.capFace = capFace;
    }

    /**
     * 获取代表这个蘑菇方块朝向的相关数据值.
     * <p>
     * 原文:Gets the associated data value representing this mushroom block face.
     *
     * @return 包含这个蘑菇方块朝向的数据值
     * @deprecated 不安全的参数
     */
    @Deprecated
    public byte getData() {
        return data;
    }

    /**
     * 获取这个材质所对的朝向.
     * <p>
     * 原文:Gets the face that has cap texture.
     *
     * @return 材质的朝向
     */
    public BlockFace getCapFace() {
        return capFace;
    }

    /**
     * 以给定的数据值获取 MushroomBlockType.
     * <p>
     * 原文:Gets the MushroomBlockType with the given data value.
     *
     * @param data 数据值
     * @return 代表这个数据值的 {@link MushroomBlockTexture}，如果相关数据值不存在为null
     * @deprecated 不安全的参数
     */
    @Deprecated
    public static MushroomBlockTexture getByData(final byte data) {
        return BY_DATA.get(data);
    }

    /**
     * 获取关于指定方块朝向的蘑菇盖的 MushroomBlockType.
     * <p>
     * 原文:Gets the MushroomBlockType with cap texture on the given block face.
     *
     * @param face 方块朝向
     * @return 代表这个朝向的 {@link MushroomBlockTexture}，如果相关数据值不存在为null
     *
     * @see BlockFace
     */
    public static MushroomBlockTexture getCapByFace(final BlockFace face) {
        return BY_BLOCKFACE.get(face);
    }

    static {
        for (MushroomBlockTexture type : values()) {
            BY_DATA.put(type.data, type);
            BY_BLOCKFACE.put(type.capFace, type);
        }
    }
}
