package org.bukkit;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.registry.RegistryAware;
import org.bukkit.util.OldEnum;
import org.jetbrains.annotations.NotNull;

/**
 * 表示流体类型。
 */
public interface Fluid extends OldEnum<Fluid>, Keyed, RegistryAware {

    /**
     * 无流体。
     */
    Fluid EMPTY = getFluid("empty");
    /**
     * 静止的水。
     */
    Fluid WATER = getFluid("water");
    /**
     * 流动的水。
     */
    Fluid FLOWING_WATER = getFluid("flowing_water");
    /**
     * 静止的岩浆。
     */
    Fluid LAVA = getFluid("lava");
    /**
     * 流动的岩浆。
     */
    Fluid FLOWING_LAVA = getFluid("flowing_lava");

    @NotNull
    private static Fluid getFluid(@NotNull String key) {
        return Registry.FLUID.getOrThrow(NamespacedKey.minecraft(key));
    }

    /**
     * {@inheritDoc}
     *
     * @see #getKeyOrThrow()
     * @see #isRegistered()
     * @deprecated 键可能并不总是存在，请改用 {@link #getKeyOrThrow()}。
     *
     * 原文：
     * A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    NamespacedKey getKey();

    /**
     * @param name 流体的名称。
     * @return 具有给定名称的流体。
     * @deprecated 仅用于向后兼容，请改用 {@link Registry#get(NamespacedKey)}。
     *
     * 原文：
     * @param name of the fluid.
     * @return the fluid with the given name.
     * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
     */
    @NotNull
    @Deprecated(since = "1.21.3")
    static Fluid valueOf(@NotNull String name) {
        Fluid fluid = Bukkit.getUnsafe().get(Registry.FLUID, NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
        Preconditions.checkArgument(fluid != null, "No fluid found with the name %s", name);
        return fluid;
    }

    /**
     * @return 所有已知流体的数组。
     * @deprecated 请使用 {@link Registry#iterator()}。
     *
     * 原文：
     * @return an array of all known fluids.
     * @deprecated use {@link Registry#iterator()}.
     */
    @NotNull
    @Deprecated(since = "1.21.3")
    static Fluid[] values() {
        return Lists.newArrayList(Registry.FLUID).toArray(new Fluid[0]);
    }
}