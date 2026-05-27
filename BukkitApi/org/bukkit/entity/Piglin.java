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
     * @return 猪灵是否能猎杀疣猪兽
     */
    public boolean isAbleToHunt();

    /**
     * 设置猪灵是否能猎杀疣猪兽。
     * <p>原文：Sets whether the piglin is able to hunt hoglins.
     *
     * @param flag 猪灵是否能猎杀疣猪兽
     */
    public void setIsAbleToHunt(boolean flag);

    /**
     * 添加一个材料到允许以物易物的材料列表中。
     * <p>原文：Adds a material to the allowed list of materials to barter with.
     *
     * @param material 要添加的材料
     *
     * @return 如果物品已成功添加则为 true，否则为 false
     */
    public boolean addBarterMaterial(@NotNull Material material);

    /**
     * 从允许以物易物的材料列表中移除一个材料。
     * <p>原文：Removes a material from the allowed list of materials to barter with.
     *
     * <strong>注意：</strong>无法覆盖默认的以物易物物品金锭作为支付物。要屏蔽金锭请参见
     * {@link org.bukkit.event.entity.PiglinBarterEvent}。
     *
     * @param material 要移除的材料
     *
     * @return 如果物品已成功移除则为 true，否则为 false
     */
    public boolean removeBarterMaterial(@NotNull Material material);

    /**
     * 添加一个猪灵会拾取并存储在其物品栏中的材料。
     * <p>原文：Adds a material the piglin will pickup and store in his inventory.
     *
     * @param material 你希望猪灵感兴趣的材料
     *
     * @return 如果物品已成功添加则为 true，否则为 false
     */
    public boolean addMaterialOfInterest(@NotNull Material material);

    /**
     * 从猪灵会拾取的材料列表中移除一个材料。
     * <p>原文：Removes a material from the list of materials the piglin will pickup.
     *
     * <strong>注意：</strong>无法覆盖猪灵默认拾取的物品列表。要取消拾取请参见
     * {@link org.bukkit.event.entity.EntityPickupItemEvent}。
     *
     * @param material 你希望从兴趣列表中移除的材料
     * @return 如果物品已成功移除则为 true，否则为 false
     */
    public boolean removeMaterialOfInterest(@NotNull Material material);

    /**
     * 返回猪灵会拾取的材料的不可变集合。
     * <p>原文：Returns a immutable set of materials the piglins will pickup.
     * <br>
     * <strong>注意：</strong>此集合不包含默认设置的物品。要操作那些物品请参见
     * {@link org.bukkit.event.entity.EntityPickupItemEvent}。
     *
     * @return 一个不可变的材料集合
     */
    @NotNull
    public Set<Material> getInterestList();

    /**
     * 返回猪灵会以物易物的材料的不可变集合。
     * <p>原文：Returns a immutable set of materials the piglins will barter with.
     *
     * <strong>注意：</strong>此集合不包含默认设置的物品。要操作那些物品请参见
     * {@link org.bukkit.event.entity.PiglinBarterEvent}。
     *
     * @return 一个不可变的材料集合
     */
    @NotNull
    public Set<Material> getBarterList();
}
