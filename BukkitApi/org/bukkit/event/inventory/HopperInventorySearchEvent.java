package org.bukkit.event.inventory;

import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 每次漏斗尝试查找其源/附加容器时调用的事件。
 */
public class HopperInventorySearchEvent extends BlockEvent {

    private static final HandlerList handlers = new HandlerList();
    private Inventory inventory;
    private final ContainerType containerType;
    private final Block searchBlock;

    public enum ContainerType {

        /**
         * 漏斗正在寻找的源容器。
         *
         * 这是漏斗上方的物品栏，漏斗从中提取物品。
         */
        SOURCE,
        /**
         * 漏斗所附加的容器。
         *
         * 这是漏斗将物品推入的物品栏。
         */
        DESTINATION;
    }

    public HopperInventorySearchEvent(@NotNull Inventory inventory, @NotNull ContainerType containerType, @NotNull Block hopper, @NotNull Block searchBlock) {
        super(hopper);
        this.inventory = inventory;
        this.containerType = containerType;
        this.searchBlock = searchBlock;
    }

    /**
     * 设置漏斗将用于其源/附加容器的 {@link Inventory}。
     *
     * @param inventory 要使用的物品栏
     * <p>原文：Set the {@link Inventory} that the Hopper will use for its
     * source/attached Container.
     */
    public void setInventory(@Nullable Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * 获取漏斗将用于其源/附加容器的 {@link Inventory}。
     *
     * @return 将被使用的物品栏
     * <p>原文：Gets the {@link Inventory} that the Hopper will use for its
     * source/attached Container.
     */
    @Nullable
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * 获取漏斗正在搜索的容器类型。
     *
     * @return 正在搜索的容器类型
     * <p>原文：Gets the Container type the Hopper is searching for.
     */
    @NotNull
    public ContainerType getContainerType() {
        return containerType;
    }

    /**
     * 获取正在被搜索物品栏的方块。
     *
     * @return 正在被搜索物品栏的方块
     * <p>原文：Gets the Block that is being searched for an inventory.
     */
    @NotNull
    public Block getSearchBlock() {
        return searchBlock;
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
