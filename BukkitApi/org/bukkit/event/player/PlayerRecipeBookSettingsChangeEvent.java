package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当玩家更改配方书设置时触发.
 */
public class PlayerRecipeBookSettingsChangeEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final RecipeBookType recipeBookType;
    private final boolean open;
    private final boolean filtering;

    public PlayerRecipeBookSettingsChangeEvent(@NotNull final Player player, @NotNull final RecipeBookType recipeBookType, final boolean open, final boolean filtering) {
        super(player);
        this.recipeBookType = recipeBookType;
        this.open = open;
        this.filtering = filtering;
    }

    /**
     * 获取玩家正在更改设置的配方书类型.
     * <p>
     * 原文：
     * Gets the type of recipe book the player is changing the settings for.
     *
     * @return 配方书类型
     */
    @NotNull
    public RecipeBookType getRecipeBookType() {
        return recipeBookType;
    }

    /**
     * 检查配方书是正在被打开还是关闭.
     * <p>
     * 原文：
     * Checks if the recipe book is being opened or closed.
     *
     * @return 如果正在打开则为 true
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * 检查配方书过滤器是正在被启用还是禁用.
     * <p>
     * 原文：
     * Checks if the recipe book filter is being enabled or disabled.
     *
     * @return 如果正在启用则为 true
     */
    public boolean isFiltering() {
        return filtering;
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

    /**
     * 表示各种配方书类型的枚举.
     * <br>
     * 不同类型的配方书在不同的 GUI 中显示.
     */
    public enum RecipeBookType {

        /**
         * 在工作台和玩家背包中看到的配方书.
         */
        CRAFTING,
        /**
         * 在熔炉中看到的配方书.
         */
        FURNACE,
        /**
         * 在高炉中看到的配方书.
         */
        BLAST_FURNACE,
        /**
         * 在烟熏炉中看到的配方书.
         */
        SMOKER;
    }
}
