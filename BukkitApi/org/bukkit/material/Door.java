package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;

/**
 * 代表门.
 * <p>
 * 这个类曾被弃用，但已被重构以适用于现今的门.
 * 由于Minecraft的门的内部表示，依赖于isTopHalf()的一些方法未被定义.
 * <p>
 * 关于朝向：这个朝向一般是玩家放置门时他面对的方向.
 * 比如我朝西方放置一个门，它的朝向(技术上讲它的"facing"数据值就是west)是朝西，那么关门时门轴是朝东方向转.
 *
 * @see Material#LEGACY_WOODEN_DOOR
 * @see Material#LEGACY_IRON_DOOR_BLOCK
 * @see Material#LEGACY_SPRUCE_DOOR
 * @see Material#LEGACY_BIRCH_DOOR
 * @see Material#LEGACY_JUNGLE_DOOR
 * @see Material#LEGACY_ACACIA_DOOR
 * @see Material#LEGACY_DARK_OAK_DOOR
 */
public class Door extends MaterialData implements Directional, Openable {

    // This class breaks API contracts on Directional and Openable because
    // of the way doors are currently implemented. Beware!

    /**
     * @deprecated 遗留的旧API，相当于new <code>Door(Material.LEGACY_WOODEN_DOOR);</code>
     */
    @Deprecated
    public Door() {
        super(Material.LEGACY_WOODEN_DOOR);
    }

    public Door(final Material type) {
        super(type);
    }

    /**
     * 以指定材质和朝向构造门的下半部分(关着的门).
     * <p>
     * 原文:Constructs the bottom half of a door of the given material type, facing the specified direction and set to closed
     *
     * @param type 这个门是用什么材料做成的.必须和这个门的上半部分相同.
     * @param face 门的朝向.
     *
     * @see Material#LEGACY_WOODEN_DOOR
     * @see Material#LEGACY_IRON_DOOR_BLOCK
     * @see Material#LEGACY_SPRUCE_DOOR
     * @see Material#LEGACY_BIRCH_DOOR
     * @see Material#LEGACY_JUNGLE_DOOR
     * @see Material#LEGACY_ACACIA_DOOR
     * @see Material#LEGACY_DARK_OAK_DOOR
     *
     * @see BlockFace#WEST
     * @see BlockFace#NORTH
     * @see BlockFace#EAST
     * @see BlockFace#SOUTH
     */
    public Door(final Material type, BlockFace face) {
        this(type, face, false);
    }

    /**
     * 以指定材质和朝向构造门的下半部分，并设置这个门关着还是开着.
     * <p>
     * 原文:Constructs the bottom half of a door of the given material type, facing the specified direction and set to open
     * or closed
     *
     * @param type 这个门是用什么材料做成的.必须和这个门的上半部分相同.
     * @param face 门的朝向
     * @param isOpen 这个门是否开着
     *
     * @see Material#LEGACY_WOODEN_DOOR
     * @see Material#LEGACY_IRON_DOOR_BLOCK
     * @see Material#LEGACY_SPRUCE_DOOR
     * @see Material#LEGACY_BIRCH_DOOR
     * @see Material#LEGACY_JUNGLE_DOOR
     * @see Material#LEGACY_ACACIA_DOOR
     * @see Material#LEGACY_DARK_OAK_DOOR
     *
     * @see BlockFace#WEST
     * @see BlockFace#NORTH
     * @see BlockFace#EAST
     * @see BlockFace#SOUTH
     */
    public Door(final Material type, BlockFace face, boolean isOpen) {
        super(type);
        setTopHalf(false);
        setFacingDirection(face);
        setOpen(isOpen);
    }

    /**
     * 以指定材质和门轴的左右侧构造门的上半部分.
     * <p>
     * 原文:Constructs the top half of door of the given material type and with the hinge on the left or right
     *
     * @param type 这个门是用什么材料做成的.必须和这个门的下半部分相同.
     * @param isHingeRight 门轴在右侧为true,在左侧为false
     *
     * @see Material#LEGACY_WOODEN_DOOR
     * @see Material#LEGACY_IRON_DOOR_BLOCK
     * @see Material#LEGACY_SPRUCE_DOOR
     * @see Material#LEGACY_BIRCH_DOOR
     * @see Material#LEGACY_JUNGLE_DOOR
     * @see Material#LEGACY_ACACIA_DOOR
     * @see Material#LEGACY_DARK_OAK_DOOR
     */
    public Door(final Material type, boolean isHingeRight) {
        super(type);
        setTopHalf(true);
        setHinge(isHingeRight);
    }

    /**
     * 以指定树种和朝向构造一个木门的下半部分(关着的门).
     * <p>
     * 原文:Constructs the bottom half of a wooden door of the given species, facing the specified direction and set to
     * closed
     *
     * @param species 这个木门是用什么树种做成的.必须和这个门的上半部分相同.
     * @param face 门的朝向
     *
     * @see TreeSpecies
     *
     * @see BlockFace#WEST
     * @see BlockFace#NORTH
     * @see BlockFace#EAST
     * @see BlockFace#SOUTH
     */
    public Door(final TreeSpecies species, BlockFace face) {
        this(getWoodDoorOfSpecies(species), face, false);
    }

    /**
     * 以指定树种和朝向构造门的下半部分，并设置这个门关着还是开着.
     * <p>
     * 原文:Constructs the bottom half of a wooden door of the given species, facing the specified direction and set to open
     * or closed
     *
     * @param species 这个木门是用什么树种做成的.必须和这个门的上半部分相同.
     * @param face 门的朝向
     * @param isOpen 门是否开着
     *
     * @see TreeSpecies
     *
     * @see BlockFace#WEST
     * @see BlockFace#NORTH
     * @see BlockFace#EAST
     * @see BlockFace#SOUTH
     */
    public Door(final TreeSpecies species, BlockFace face, boolean isOpen) {
        this(getWoodDoorOfSpecies(species), face, isOpen);
    }

    /**
     * 以指定树种和朝向构造门的上半部分，并指定门轴在左侧还是右侧.
     * <p>
     * 原文:Constructs the top half of a wooden door of the given species and with the hinge on the left or right
     *
     * @param species 这个木门是用什么树种做成的.必须和这个门的下半部分相同.
     * @param isHingeRight 门轴在右侧为true,在左侧为false
     *
     * @see TreeSpecies
     */
    public Door(final TreeSpecies species, boolean isHingeRight) {
        this(getWoodDoorOfSpecies(species), isHingeRight);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Door(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * 返回用你给定的树种做成的木门的物品.
     * <p>
     * 原文:Returns the item type of a wooden door for the given tree species.
     *
     * @param species 树的物种
     * @return 用这种树做成的木门
     *
     * @see Material#LEGACY_WOODEN_DOOR
     * @see Material#LEGACY_SPRUCE_DOOR
     * @see Material#LEGACY_BIRCH_DOOR
     * @see Material#LEGACY_JUNGLE_DOOR
     * @see Material#LEGACY_ACACIA_DOOR
     * @see Material#LEGACY_DARK_OAK_DOOR
     */
    public static Material getWoodDoorOfSpecies(TreeSpecies species) {
        switch (species) {
            default:
            case GENERIC:
                return Material.LEGACY_WOODEN_DOOR;
            case BIRCH:
                return Material.LEGACY_BIRCH_DOOR;
            case REDWOOD:
                return Material.LEGACY_SPRUCE_DOOR;
            case JUNGLE:
                return Material.LEGACY_JUNGLE_DOOR;
            case ACACIA:
                return Material.LEGACY_ACACIA_DOOR;
            case DARK_OAK:
                return Material.LEGACY_DARK_OAK_DOOR;
        }
    }

    /**
     * 若<code>isTopHalf()</code>为true，则得不到结果(个人猜测总得返回false).
     * <p>
     * 原文:Result is undefined if <code>isTopHalf()</code> is true.
     */
    public boolean isOpen() {
        return ((getData() & 0x4) == 0x4);
    }

    /**
     * 设置门是否开着.若<code>isTopHalf()</code>为true则此方法没有效果.
     * <p>
     * 原文:Set whether the door is open. Undefined if <code>isTopHalf()</code> is true.
     */
    public void setOpen(boolean isOpen) {
        setData((byte) (isOpen ? (getData() | 0x4) : (getData() & ~0x4)));
    }

    /**
     * @return 这个门是否属于上半部分
     */
    public boolean isTopHalf() {
        return ((getData() & 0x8) == 0x8);
    }

    /**
     * 设置这个门是上半部分的还是下半部分的.
     * <p>
     * 原文:Configure this part of the door to be either the top or the bottom half
     *
     * @param isTopHalf true将设此门为上半部分的
     */
    public void setTopHalf(boolean isTopHalf) {
        setData((byte) (isTopHalf ? (getData() | 0x8) : (getData() & ~0x8)));
    }

    /**
     * @return BlockFace.SELF
     * @deprecated 不应使用此方法;请使用hinge/facing对应的getter
     */
    @Deprecated
    public BlockFace getHingeCorner() {
        return BlockFace.SELF;
    }

    @Override
    public String toString() {
        return (isTopHalf() ? "TOP" : "BOTTOM") + " half of " + super.toString();
    }

    /**
     * 设置门的朝向.
     * 若<code>isTopHalf()</code>为true，则没有效果.
     * <p>
     * 原文:Set the direction that this door should is facing.
     *
     * Undefined if <code>isTopHalf()</code> is true.
     *
     * @param face 朝向
     */
    public void setFacingDirection(BlockFace face) {
        byte data = (byte) (getData() & 0xC);
        switch (face) {
            case WEST:
                data |= 0x0;
                break;
            case NORTH:
                data |= 0x1;
                break;
            case EAST:
                data |= 0x2;
                break;
            case SOUTH:
                data |= 0x3;
                break;
        }
        setData(data);
    }

    /**
     * 获取门的朝向.
     * 若<code>isTopHalf()</code>为true，则没有效果.
     * <p>
     * 原文:Get the direction that this door is facing.
     *
     * Undefined if <code>isTopHalf()</code> is true.
     *
     * @return 朝向
     */
    public BlockFace getFacing() {
        byte data = (byte) (getData() & 0x3);
        switch (data) {
            case 0:
                return BlockFace.WEST;
            case 1:
                return BlockFace.NORTH;
            case 2:
                return BlockFace.EAST;
            case 3:
                return BlockFace.SOUTH;
            default:
                throw new IllegalStateException("Unknown door facing (data: " + data + ")");
        }
    }

    /**
     * 返回门轴在哪一侧.
     * 若<code>isTopHalf()</code>为false，则没有效果.
     * <p>
     * 原文:Returns the side of the door the hinge is on.
     *
     * Undefined if <code>isTopHalf()</code> is false.
     *
     * @return 门轴在右侧为true,在左侧为false
     */
    public boolean getHinge() {
        return (getData() & 0x1) == 1;
    }

    /**
     * 设置门轴在左侧还是右侧.左侧为false,右侧为true.
     * 若<code>isTopHalf()</code>为false，则没有效果.
     * <p>
     * 原文:Set whether the hinge is on the left or right side. Left is false, right is true.
     *
     * Undefined if <code>isTopHalf()</code> is false.
     *
     * @param isHingeRight 门轴在右侧为true,在左侧为false
     */
    public void setHinge(boolean isHingeRight) {
        setData((byte) (isHingeRight ? (getData() | 0x1) : (getData() & ~0x1)));
    }

    @Override
    public Door clone() {
        return (Door) super.clone();
    }
}
