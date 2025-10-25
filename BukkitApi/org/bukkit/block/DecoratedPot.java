package org.bukkit.block;

import java.util.List;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.DecoratedPotInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个捕获的饰纹陶罐状态.
 * <p>
 * 原文:Represents a captured state of a decorated pot.
 */
public interface DecoratedPot extends TileState, BlockInventoryHolder {

    /**
     * 在指定的侧面上设置陶片.
     * <p>
     * 原文:Set the sherd on the provided side.
     *
     * @param side 要设置的侧面
     * @param sherd 陶片, 或null来设置空白侧面
     * @throws IllegalArgumentException 如果陶片既没有被{@link Tag#ITEMS_DECORATED_POT_SHERDS}标记,
     * 也不是{@link Material#BRICK}, 也不是{@code null}
     */
    public void setSherd(@NotNull Side side, @Nullable Material sherd);

    /**
     * 获取指定侧面上的陶片.
     * <p>
     * 原文:Get the sherd on the provided side.
     *
     * @param side 要获取的侧面
     * @return 侧面上的陶片, 如果是空白则返回{@link Material#BRICK}
     */
    @NotNull
    public Material getSherd(@NotNull Side side);

    /**
     * 获取此饰纹陶罐所有侧面及其上陶片的Map.
     * 如果某个侧面没有特定的陶片, 则使用{@link Material#BRICK}作为该侧面的值.
     * <p>
     * 原文:Gets a Map of all sides on this decorated pot and the sherds on them.
     * If a side does not have a specific sherd on it, {@link Material#BRICK}
     * will be the value of that side.
     *
     * @return 陶片
     */
    @NotNull
    public Map<Side, Material> getSherds();

    /**
     * 获取此饰纹陶罐上的陶片. 对于没有特定陶片的面,
     * 使用{@link Material#BRICK}代替.
     * <p>
     * 原文:Gets the sherds on this decorated pot. For faces without a specific sherd,
     * {@link Material#BRICK} is used in its place.
     *
     * @return 陶片
     * @deprecated 请使用{@link #getSherds()}
     */
    @Deprecated(since = "1.20.1")
    @NotNull
    public List<Material> getShards();

    /**
     * @return 物品栏
     * @see Container#getInventory()
     */
    @NotNull
    @Override
    public DecoratedPotInventory getInventory();

    /**
     * @return 快照物品栏
     * @see Container#getSnapshotInventory()
     */
    @NotNull
    public DecoratedPotInventory getSnapshotInventory();

    /**
     * 饰纹陶罐的一个侧面. 侧面相对于{@link org.bukkit.block.data.type.DecoratedPot}的朝向状态.
     * <p>
     * 原文:A side on a decorated pot. Sides are relative to the facing state of a
     * {@link org.bukkit.block.data.type.DecoratedPot}.
     */
    public static enum Side {
        BACK,
        LEFT,
        RIGHT,
        FRONT
    }
}
