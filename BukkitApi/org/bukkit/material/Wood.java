package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * 代表不同树种的木头方块。
 *
 * @see Material#LEGACY_WOOD
 * @see Material#LEGACY_SAPLING
 * @see Material#LEGACY_WOOD_DOUBLE_STEP
 *
 * @deprecated 所有 MaterialData 的用法都已弃用并可能被移除。
 * 请使用 {@link org.bukkit.block.data.BlockData}。
 */
@Deprecated(since = "1.14.1")
public class Wood extends MaterialData {
    protected static final Material DEFAULT_TYPE = Material.LEGACY_WOOD;
    protected static final TreeSpecies DEFAULT_SPECIES = TreeSpecies.GENERIC;

    /**
     * 构造一个木头方块。
     * <p>原文：Constructs a wood block.
     */
    public Wood() {
        this(DEFAULT_TYPE, DEFAULT_SPECIES);
    }

    /**
     * 构造一个给定树种的木头方块。
     *
     * @param species 木头方块的树种
     * <p>原文：Constructs a wood block of the given tree species.
     */
    public Wood(TreeSpecies species) {
        this(DEFAULT_TYPE, species);
    }

    /**
     * 构造一个给定类型的木头方块。
     *
     * @param type 木头方块的类型
     * <p>原文：Constructs a wood block of the given type.
     */
    public Wood(final Material type) {
        this(type, DEFAULT_SPECIES);
    }

    /**
     * 构造一个给定类型和树种的木头方块。
     *
     * @param type 木头方块的类型
     * @param species 木头方块的树种
     * <p>原文：Constructs a wood block of the given type and tree species.
     */
    public Wood(final Material type, final TreeSpecies species) {
        // Ensure only valid species-type combinations
        super(getSpeciesType(type, species));
        setSpecies(species);
    }

    /**
     * @param type 物品类型
     * @param data 原始数据值
     * @deprecated 魔法值
     * <p>原文：Magic value
     */
    @Deprecated(since = "1.9")
    public Wood(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取此木头方块的当前树种。
     *
     * @return 此木头方块的 TreeSpecies
     * <p>原文：Gets the current species of this wood block
     */
    public TreeSpecies getSpecies() {
        switch (getItemType()) {
            case LEGACY_WOOD:
            case LEGACY_WOOD_DOUBLE_STEP:
                return TreeSpecies.getByData((byte) getData());
            case LEGACY_LOG:
            case LEGACY_LEAVES:
                return TreeSpecies.getByData((byte) (getData() & 0x3));
            case LEGACY_LOG_2:
            case LEGACY_LEAVES_2:
                return TreeSpecies.getByData((byte) ((getData() & 0x3) | 0x4));
            case LEGACY_SAPLING:
            case LEGACY_WOOD_STEP:
                return TreeSpecies.getByData((byte) (getData() & 0x7));
            default:
                throw new IllegalArgumentException("Invalid block type for tree species");
        }
    }

    /**
     * 纠正某些树种-类型组合的方块类型。
     *
     * @param type 期望的类型
     * @param species 所需的树种
     * @return 给定期望类型下该树种的实际类型
     * <p>原文：Correct the block type for certain species-type combinations.
     */
    private static Material getSpeciesType(Material type, TreeSpecies species) {
        switch (species) {
            case GENERIC:
            case REDWOOD:
            case BIRCH:
            case JUNGLE:
                switch (type) {
                    case LEGACY_LOG_2:
                        return Material.LEGACY_LOG;
                    case LEGACY_LEAVES_2:
                        return Material.LEGACY_LEAVES;
                    default:
                }
                break;
            case ACACIA:
            case DARK_OAK:
                switch (type) {
                    case LEGACY_LOG:
                        return Material.LEGACY_LOG_2;
                    case LEGACY_LEAVES:
                        return Material.LEGACY_LEAVES_2;
                    default:
                }
                break;
        }
        return type;
    }

    /**
     * 设置此木头方块的树种。
     *
     * @param species 此木头方块的新树种
     * <p>原文：Sets the species of this wood block
     */
    public void setSpecies(final TreeSpecies species) {
        boolean firstType = false;
        switch (getItemType()) {
            case LEGACY_WOOD:
            case LEGACY_WOOD_DOUBLE_STEP:
                setData(species.getData());
                break;
            case LEGACY_LOG:
            case LEGACY_LEAVES:
                firstType = true;
            // fall through to next switch statement below
            case LEGACY_LOG_2:
            case LEGACY_LEAVES_2:
                switch (species) {
                    case GENERIC:
                    case REDWOOD:
                    case BIRCH:
                    case JUNGLE:
                        if (!firstType) {
                            throw new IllegalArgumentException("Invalid tree species for block type, use block type 2 instead");
                        }
                        break;
                    case ACACIA:
                    case DARK_OAK:
                        if (firstType) {
                            throw new IllegalArgumentException("Invalid tree species for block type 2, use block type instead");
                        }
                        break;
                }
                setData((byte) ((getData() & 0xC) | (species.getData() & 0x3)));
                break;
            case LEGACY_SAPLING:
            case LEGACY_WOOD_STEP:
                setData((byte) ((getData() & 0x8) | species.getData()));
                break;
            default:
                throw new IllegalArgumentException("Invalid block type for tree species");
        }
    }

    @Override
    public String toString() {
        return getSpecies() + " " + super.toString();
    }

    @Override
    public Wood clone() {
        return (Wood) super.clone();
    }
}