package org.bukkit.inventory;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.view.AnvilView;
import org.bukkit.inventory.view.BeaconView;
import org.bukkit.inventory.view.BrewingStandView;
import org.bukkit.inventory.view.CrafterView;
import org.bukkit.inventory.view.EnchantmentView;
import org.bukkit.inventory.view.FurnaceView;
import org.bukkit.inventory.view.LecternView;
import org.bukkit.inventory.view.LoomView;
import org.bukkit.inventory.view.MerchantView;
import org.bukkit.inventory.view.StonecutterView;
import org.bukkit.inventory.view.builder.InventoryViewBuilder;
import org.bukkit.inventory.view.builder.LocationInventoryViewBuilder;
import org.bukkit.inventory.view.builder.MerchantInventoryViewBuilder;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 代表不同类型的视图 (也称为菜单), 可由玩家创建和查看.
 */
@ApiStatus.Experimental
public interface MenuType extends Keyed, RegistryAware {

    /**
     * 代表具有 1 行的箱子的菜单类型.
     */
    MenuType.Typed<InventoryView, InventoryViewBuilder<InventoryView>> GENERIC_9X1 = get("generic_9x1");
    /**
     * 代表具有 2 行的箱子的菜单类型.
     */
    MenuType.Typed<InventoryView, InventoryViewBuilder<InventoryView>> GENERIC_9X2 = get("generic_9x2");
    /**
     * 代表具有 3 行的箱子的菜单类型.
     */
    MenuType.Typed<InventoryView, LocationInventoryViewBuilder<InventoryView>> GENERIC_9X3 = get("generic_9x3");
    /**
     * 代表具有 4 行的箱子的菜单类型.
     */
    MenuType.Typed<InventoryView, InventoryViewBuilder<InventoryView>> GENERIC_9X4 = get("generic_9x4");
    /**
     * 代表具有 5 行的箱子的菜单类型.
     */
    MenuType.Typed<InventoryView, InventoryViewBuilder<InventoryView>> GENERIC_9X5 = get("generic_9x5");
    /**
     * 代表具有 6 行的箱子的菜单类型.
     */
    MenuType.Typed<InventoryView, InventoryViewBuilder<InventoryView>> GENERIC_9X6 = get("generic_9x6");
    /**
     * 代表具有 3 列 3 行的发射器/投掷器式菜单的菜单类型.
     */
    MenuType.Typed<InventoryView, LocationInventoryViewBuilder<InventoryView>> GENERIC_3X3 = get("generic_3x3");
    /**
     * 代表合成器的菜单类型.
     */
    MenuType.Typed<CrafterView, LocationInventoryViewBuilder<CrafterView>> CRAFTER_3X3 = get("crafter_3x3");
    /**
     * 代表铁砧的菜单类型.
     */
    MenuType.Typed<AnvilView, LocationInventoryViewBuilder<AnvilView>> ANVIL = get("anvil");
    /**
     * 代表信标的菜单类型.
     */
    MenuType.Typed<BeaconView, LocationInventoryViewBuilder<BeaconView>> BEACON = get("beacon");
    /**
     * 代表高炉的菜单类型.
     */
    MenuType.Typed<FurnaceView, LocationInventoryViewBuilder<FurnaceView>> BLAST_FURNACE = get("blast_furnace");
    /**
     * 代表酿造台的菜单类型.
     */
    MenuType.Typed<BrewingStandView, LocationInventoryViewBuilder<BrewingStandView>> BREWING_STAND = get("brewing_stand");
    /**
     * 代表工作台的菜单类型.
     */
    MenuType.Typed<InventoryView, LocationInventoryViewBuilder<InventoryView>> CRAFTING = get("crafting");
    /**
     * 代表附魔台的菜单类型.
     */
    MenuType.Typed<EnchantmentView, LocationInventoryViewBuilder<EnchantmentView>> ENCHANTMENT = get("enchantment");
    /**
     * 代表熔炉的菜单类型.
     */
    MenuType.Typed<FurnaceView, LocationInventoryViewBuilder<FurnaceView>> FURNACE = get("furnace");
    /**
     * 代表砂轮的菜单类型.
     */
    MenuType.Typed<InventoryView, LocationInventoryViewBuilder<InventoryView>> GRINDSTONE = get("grindstone");
    /**
     * 代表漏斗的菜单类型.
     */
    MenuType.Typed<InventoryView, LocationInventoryViewBuilder<InventoryView>> HOPPER = get("hopper");
    /**
     * 代表讲台 (类似书本的视图) 的菜单类型.
     */
    MenuType.Typed<LecternView, LocationInventoryViewBuilder<LecternView>> LECTERN = get("lectern");
    /**
     * 代表织布机的菜单类型.
     */
    MenuType.Typed<LoomView, LocationInventoryViewBuilder<LoomView>> LOOM = get("loom");
    /**
     * 代表村民商人交易界面的菜单类型.
     */
    MenuType.Typed<MerchantView, MerchantInventoryViewBuilder<MerchantView>> MERCHANT = get("merchant");
    /**
     * 代表潜影盒的菜单类型.
     */
    MenuType.Typed<InventoryView, LocationInventoryViewBuilder<InventoryView>> SHULKER_BOX = get("shulker_box");
    /**
     * 代表锻造台的菜单类型.
     */
    MenuType.Typed<InventoryView, LocationInventoryViewBuilder<InventoryView>> SMITHING = get("smithing");
    /**
     * 代表烟熏炉的菜单类型.
     */
    MenuType.Typed<FurnaceView, LocationInventoryViewBuilder<FurnaceView>> SMOKER = get("smoker");
    /**
     * 代表制图台的菜单类型.
     */
    MenuType.Typed<InventoryView, LocationInventoryViewBuilder<InventoryView>> CARTOGRAPHY_TABLE = get("cartography_table");
    /**
     * 代表切石机的菜单类型.
     */
    MenuType.Typed<StonecutterView, LocationInventoryViewBuilder<StonecutterView>> STONECUTTER = get("stonecutter");

    /**
     * Typed 代表 {@link MenuType} 的一个子类型, 在编译时具有已知的 {@link InventoryView} 类型.
     *
     * @param <V> 代表视图类型的 {@link InventoryView} 的泛型类型
     * @param <B> 代表视图构建器的 {@link InventoryViewBuilder} 的构建器类型
     */
    interface Typed<V extends InventoryView, B extends InventoryViewBuilder<V>> extends MenuType {

        /**
         * 创建指定菜单类型的视图.
         * <p>
         * 提供给此方法创建视图的玩家必须是该视图所打开的玩家. 详见 {@link HumanEntity#openInventory(InventoryView)}.
         * <p>
         * 原文：Creates a view of the specified menu type.
         * <p>
         * The player provided to create this view must be the player the view
         * is opened for. See {@link HumanEntity#openInventory(InventoryView)}
         * for more information.
         *
         * @param player 视图所属的玩家
         * @param title 视图的标题
         * @return 创建的 {@link InventoryView}
         */
        @NotNull
        V create(@NotNull HumanEntity player, @NotNull String title);

        /**
         * 创建此类型 InventoryView 的构建器.
         * <p>
         * 原文：Creates a builder for this type of InventoryView.
         *
         * @return 新的构建器
         */
        @NotNull
        B builder();
    }

    /**
     * 将此 MenuType 作为使用普通 {@link InventoryView} 表示的类型化版本返回.
     * <p>
     * 原文：Yields this MenuType as a typed version of itself with a plain
     * {@link InventoryView} representing it.
     *
     * @return 类型化的 MenuType
     */
    @NotNull
    MenuType.Typed<InventoryView, InventoryViewBuilder<InventoryView>> typed();

    /**
     * 将此 MenuType 作为使用特定 {@link InventoryView} 表示的类型化版本返回.
     * <p>
     * 原文：Yields this MenuType as a typed version of itself with a specific
     * {@link InventoryView} representing it.
     *
     * @param viewClass 用于类型化此 {@link InventoryView} 的 {@link InventoryView} 类类型
     * @param <V> 获取此 MenuType 时使用的 InventoryView 的泛型类型
     * @param <B> 获取此 MenuType 时使用的 InventoryViewBuilder 的泛型类型
     * @return 类型化的 MenuType
     * @throws IllegalArgumentException 如果提供的 viewClass 无法被类型化为此 MenuType
     */
    @NotNull
    <V extends InventoryView, B extends InventoryViewBuilder<V>> MenuType.Typed<V, B> typed(@NotNull final Class<V> viewClass) throws IllegalArgumentException;

    /**
     * 获取此 MenuType 的 {@link InventoryView} 类.
     * <p>
     * 原文：Gets the {@link InventoryView} class of this MenuType.
     *
     * @return 此 MenuType 的 {@link InventoryView} 类
     */
    @NotNull
    Class<? extends InventoryView> getInventoryViewClass();

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated 键可能并非始终存在, 请改用 {@link #getKeyOrThrow()}.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    NamespacedKey getKey();

    @NotNull
    private static <T extends MenuType> T get(@NotNull final String key) {
        return (T) Registry.MENU.getOrThrow(NamespacedKey.minecraft(key));
    }
}
