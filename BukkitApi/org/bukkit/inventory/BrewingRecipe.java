package org.bukkit.inventory;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a brewing recipe.
 */
@ApiStatus.Experimental
public class BrewingRecipe implements Recipe, Keyed {

    private final NamespacedKey key;
    private final ItemStack result;

    /**
     * Create a brewing recipe to produce the specified result ItemStack.
     *
     * @param key The unique recipe key
     * @param result The item you want the recipe to create.
     * @deprecated this is for internal use only and will not create a viable
     * recipe
     */
    @Deprecated(since = "26.3")
    public BrewingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result) {
        this.key = key;
        this.result = result;
    }

    @NotNull
    @Override
    public ItemStack getResult() {
        return result.clone();
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return this.key;
    }
}
