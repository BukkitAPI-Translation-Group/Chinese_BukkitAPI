package org.bukkit.material;

import org.bukkit.GrassSpecies;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * 代表花盆
 *
 * @deprecated 花盆现在是Tile Entity(http://minecraft-zh.gamepedia.com/%E6%96%B9%E5%9D%97%E5%AE%9E%E4%BD%93%E5%80%BC), 使用
 * {@link org.bukkit.block.FlowerPot}.
 */
@Deprecated
public class FlowerPot extends MaterialData {

    /**
     * 该类的默认构造器.
     * <p>
     * 原文:Default constructor for a flower pot.
     */
    public FlowerPot() {
        super(Material.FLOWER_POT);
    }

    /**
     * @param type the raw type id
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FlowerPot(final int type) {
        super(type);
    }

    public FlowerPot(final Material type) {
        super(type);
    }

    /**
     * @param type the raw type id
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FlowerPot(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public FlowerPot(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 获取在花盆里的植物的方块.
     * <p>
     * 原文:Get the material in the flower pot
     *
     * @return material 方块的MaterialData，null为空
     */
    public MaterialData getContents() {
        switch (getData()) {
            case 1:
                return new MaterialData(Material.RED_ROSE);
            case 2:
                return new MaterialData(Material.YELLOW_FLOWER);
            case 3:
                return new Tree(TreeSpecies.GENERIC);
            case 4:
                return new Tree(TreeSpecies.REDWOOD);
            case 5:
                return new Tree(TreeSpecies.BIRCH);
            case 6:
                return new Tree(TreeSpecies.JUNGLE);
            case 7:
                return new MaterialData(Material.RED_MUSHROOM);
            case 8:
                return new MaterialData(Material.BROWN_MUSHROOM);
            case 9:
                return new MaterialData(Material.CACTUS);
            case 10:
                return new MaterialData(Material.DEAD_BUSH);
            case 11:
                return new LongGrass(GrassSpecies.FERN_LIKE);
            default:
                return null;
        }
    }

    /**
     * 设置在花盆里的植物的方块.
     * <p>
     * 原文:Set the contents of the flower pot
     *
     * @param materialData 方块的MaterialData
     */
    public void setContents(MaterialData materialData) {
        Material mat = materialData.getItemType();

        if (mat == Material.RED_ROSE) {
            setData((byte) 1);
        } else if (mat == Material.YELLOW_FLOWER) {
            setData((byte) 2);
        } else if (mat == Material.RED_MUSHROOM) {
            setData((byte) 7);
        } else if (mat == Material.BROWN_MUSHROOM) {
            setData((byte) 8);
        } else if (mat == Material.CACTUS) {
            setData((byte) 9);
        } else if (mat == Material.DEAD_BUSH) {
            setData((byte) 10);
        } else if (mat == Material.SAPLING) {
            TreeSpecies species = ((Tree) materialData).getSpecies();

            if (species == TreeSpecies.GENERIC) {
                setData((byte) 3);
            } else if (species == TreeSpecies.REDWOOD) {
                setData((byte) 4);
            } else if (species == TreeSpecies.BIRCH) {
                setData((byte) 5);
            } else {
                setData((byte) 6);
            }
        } else if (mat == Material.LONG_GRASS) {
            GrassSpecies species = ((LongGrass) materialData).getSpecies();

            if (species == GrassSpecies.FERN_LIKE) {
                setData((byte) 11);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " containing " + getContents();
    }

    @Override
    public FlowerPot clone() {
        return (FlowerPot) super.clone();
    }
}
