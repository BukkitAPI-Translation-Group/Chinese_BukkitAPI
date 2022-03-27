package org.bukkit.event.world;

import java.util.Collection;
import java.util.List;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当生成给予{@link InventoryHolder}的{@link LootTable 战利品}时调用.
 *
 * 目前本事件不会在实体的战利品表已经创建时调用 (使用 {@link EntityDeathEvent#getDrops()} 方法),
 * 但将会因插件使用 {@link LootTable#fillInventory(org.bukkit.inventory.Inventory, java.util.Random, LootContext)}
 * 方法而调用.
 * <p>
 * 原文:Called when a {@link LootTable} is generated in the world for an
 * {@link InventoryHolder}.
 *
 * This event is NOT currently called when an entity's loot table has been
 * generated (use {@link EntityDeathEvent#getDrops()}, but WILL be called by
 * plugins invoking
 * {@link LootTable#fillInventory(org.bukkit.inventory.Inventory, java.util.Random, LootContext)}.
 */
public class LootGenerateEvent extends WorldEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Entity entity;
    private final InventoryHolder inventoryHolder;
    private final LootTable lootTable;
    private final LootContext lootContext;
    private final List<ItemStack> loot;
    private final boolean plugin;

    public LootGenerateEvent(@NotNull World world, @Nullable Entity entity, @Nullable InventoryHolder inventoryHolder, @NotNull LootTable lootTable, @NotNull LootContext lootContext, @NotNull List<ItemStack> items, boolean plugin) {
        super(world);
        this.entity = entity;
        this.inventoryHolder = inventoryHolder;
        this.lootTable = lootTable;
        this.lootContext = lootContext;
        this.loot = items;
        this.plugin = plugin;
    }

    /**
     * 获取生成战利品所用的实体 (若适用).
     *
     * 对于不需要使用实体生成战利品的物品栏, 比如漏斗, 将返回 null.
     *
     * 本方法是 {@code getLootContext().getLootedEntity()} 的便利用法.
     * <p>
     * 原文:
     * Get the entity used as context for loot generation (if applicable).
     *
     * For inventories where entities are not required to generate loot, such as
     * hoppers, null will be returned.
     *
     * This is a convenience method for
     * {@code getLootContext().getLootedEntity()}.
     *
     * @return 实体
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

    /**
     * 获取产生的战利品所在的物品栏持有者.
     *
     * 如果战利品因破坏方块而生成, 此物品栏持有者将为 null,
     * 因为此事件在方块破坏后发生.
     * <p>
     * 原文:
     * Get the inventory holder in which the loot was generated.
     *
     * If the loot was generated as a result of the block being broken, the
     * inventory holder will be null as this event is called post block break.
     *
     * @return 物品栏持有者
     */
    @Nullable
    public InventoryHolder getInventoryHolder() {
        return inventoryHolder;
    }

    /**
     * 获取所使用的战利品表.
     * <p>
     * 原文:
     * Get the loot table used to generate loot.
     *
     * @return 战利品表
     */
    @NotNull
    public LootTable getLootTable() {
        return lootTable;
    }

    /**
     * 获取战利品表上下文, 用于为战利品生成提供上下文信息.
     * <p>
     * 原文:
     * Get the loot context used to provide context to the loot table's loot
     * generation.
     *
     * @return 战利品表上下文
     */
    @NotNull
    public LootContext getLootContext() {
        return lootContext;
    }

    /**
     * 设置将要生成的战利品. Null 物品堆将被当作空气.
     *
     * 注意: 您设置的集合与{@link #getLoot()}方法返回的集合不是同一个对象.
     * (译注:此方法会将自身的战利品集合清空后, 调用addAll方法添加设置的集合.
     * 所以您不能使用{@link #getLoot()}返回的集合作为本方法的参数).
     * <p>
     * 原文:
     * Set the loot to be generated. Null items will be treated as air.
     *
     * Note: the set collection is not the one which will be returned by
     * {@link #getLoot()}.
     *
     * @param loot 生成的战利品, 设为 null 以清空所有战利品
     */
    public void setLoot(@Nullable Collection<ItemStack> loot) {
        this.loot.clear();
        if (loot != null) {
            this.loot.addAll(loot);
        }
    }

    /**
     * 获取生成的战利品的可变列表.
     *
     * 在此列表添加或移除的任何物品将影响到战利品的生成结果.
     * Null 物品堆将被当作空气.
     * <p>
     * 原文:
     * Get a mutable list of all loot to be generated.
     *
     * Any items added or removed from the returned list will be reflected in
     * the loot generation. Null items will be treated as air.
     *
     * @return 生成的战利品
     */
    @NotNull
    public List<ItemStack> getLoot() {
        return loot;
    }

    /**
     * 检测此事件是否因插件调用
     * {@link LootTable#fillInventory(org.bukkit.inventory.Inventory, java.util.Random, LootContext)}
     * 方法触发.
     * <p>
     * 原文:
     * Check whether or not this event was called as a result of a plugin
     * invoking
     * {@link LootTable#fillInventory(org.bukkit.inventory.Inventory, java.util.Random, LootContext)}.
     *
     * @return 若为插件触发则为 true
     */
    public boolean isPlugin() {
        return plugin;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
