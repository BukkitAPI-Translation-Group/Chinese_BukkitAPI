package org.bukkit;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.registry.RegistryAware;
import org.bukkit.util.OldEnum;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a fluid type.
 */
public interface Fluid extends OldEnum<Fluid>, Keyed, RegistryAware {

    /**
     * No fluid.
     */
    Fluid EMPTY = getFluid("empty");
    /**
     * Stationary water.
     */
    Fluid WATER = getFluid("water");
    /**
     * Flowing water.
     */
    Fluid FLOWING_WATER = getFluid("flowing_water");
    /**
     * Stationary lava.
     */
    Fluid LAVA = getFluid("lava");
    /**
     * Flowing lava.
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
     * @deprecated A key might not always be present, use {@link #getKeyOrThrow()} instead.
     */
    @NotNull
    @Override
    @Deprecated(since = "1.21.4")
    NamespacedKey getKey();

    /**
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
     * @return an array of all known fluids.
     * @deprecated use {@link Registry#iterator()}.
     */
    @NotNull
    @Deprecated(since = "1.21.3")
    static Fluid[] values() {
        return Lists.newArrayList(Registry.FLUID).toArray(new Fluid[0]);
    }
}