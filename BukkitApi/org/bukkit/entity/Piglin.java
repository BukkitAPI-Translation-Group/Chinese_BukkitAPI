package org.bukkit.entity;

import java.util.Set;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一只猪灵。
 */
public interface Piglin extends PiglinAbstract, InventoryHolder {

    /**
     * 获取猪灵是否能猎杀疣猪兽。
     * <p>原文：Get whether the piglin is able to hunt hoglins.
     *
     * @return Whether the piglin is able to hunt hoglins
     */
    public boolean isAbleToHunt();

    /**
     * 设置猪灵是否能猎杀疣猪兽。
     * <p>原文：Sets whether the piglin is able to hunt hoglins.
     *
     * @param flag Whether the piglin is able to hunt hoglins.
     */
    public void setIsAbleToHunt(boolean flag);

    /**
     * 添加一个材料到允许以物易物的材料列表中。
     * <p>原文：Adds a material to the allowed list of materials to barter with.
     *
     * @param material The material to add
     *
     * @return true if the item has been added successfully, false otherwise
     */
    public boolean addBarterMaterial(@NotNull Material material);

    /**
     * 从允许以物易物的材料列表中移除一个材料。
     * <p>原文：Removes a material from the allowed list of materials to barter with.
     *
     * <strong>Note:</strong> It's not possible to override the default
     * bartering item gold_ingots as payment. To block gold_ingots see
     * {@link org.bukkit.event.entity.PiglinBarterEvent}.
     *
     * @param material The material to remove
     *
     * @return true if the item has been removed successfully, false otherwise
     */
    public boolean removeBarterMaterial(@NotNull Material material);

    /**
     * 添加一个猪灵会拾取并存储在其物品栏中的材料。
     * <p>原文：Adds a material the piglin will pickup and store in his inventory.
     *
     * @param material The material you want the piglin to be interested in
     *
     * @return true if the item has been added successfully, false otherwise
     */
    public boolean addMaterialOfInterest(@NotNull Material material);

    /**
     * 从猪灵会拾取的材料列表中移除一个材料。
     * <p>原文：Removes a material from the list of materials the piglin will pickup.
     *
     * <strong>Note:</strong> It's not possible to override the default list of
     * item the piglin will pickup. To cancel pickup see
     * {@link org.bukkit.event.entity.EntityPickupItemEvent}.
     *
     * @param material The material you want removed from the interest list
     * @return true if the item has been removed successfully, false otherwise
     */
    public boolean removeMaterialOfInterest(@NotNull Material material);

    /**
     * 返回猪灵会拾取的材料的不可变集合。
     * <p>原文：Returns a immutable set of materials the piglins will pickup.
     * <br>
     * <strong>Note:</strong> This set will not include the items that are set
     * by default. To interact with those items see
     * {@link org.bukkit.event.entity.EntityPickupItemEvent}.
     *
     * @return An immutable materials set
     */
    @NotNull
    public Set<Material> getInterestList();

    /**
     * 返回猪灵会以物易物的材料的不可变集合。
     * <p>原文：Returns a immutable set of materials the piglins will barter with.
     *
     * <strong>Note:</strong> This set will not include the items that are set
     * by default. To interact with those items see
     * {@link org.bukkit.event.entity.PiglinBarterEvent}.
     *
     * @return An immutable materials set
     */
    @NotNull
    public Set<Material> getBarterList();
}
