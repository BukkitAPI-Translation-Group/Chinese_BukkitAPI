package org.bukkit.entity;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 代表猪.
 */
public interface Pig extends Steerable, Vehicle {

    /**
     * 获取此猪的变种。
     *
     * @return 猪的变种.
     * <p>
     * 原文: Get the variant of this pig.
     */
    @NotNull
    Variant getVariant();

    /**
     * 设置此猪的变种。
     *
     * @param variant 猪的变种.
     * <p>
     * 原文: Set the variant of this pig.
     */
    void setVariant(@NotNull Variant variant);

        /**
         * 代表猪的变种。
         */
    interface Variant extends Keyed, RegistryAware {

        Variant TEMPERATE = getType("temperate");
        Variant WARM = getType("warm");
        Variant COLD = getType("cold");

        /**
         * {@inheritDoc}
         *
         * @see #getKeyOrThrow()
         * @see #isRegistered()
         * @deprecated 键可能并不总是存在，请改用 {@link #getKeyOrThrow()}.
         * <p>
         * 原文: A key might not always be present, use {@link #getKeyOrThrow()} instead.
         */
        @NotNull
        @Override
        @Deprecated(since = "1.21.5")
        NamespacedKey getKey();

        @NotNull
        private static Variant getType(@NotNull String key) {
            return Registry.PIG_VARIANT.getOrThrow(NamespacedKey.minecraft(key));
        }
    }
}