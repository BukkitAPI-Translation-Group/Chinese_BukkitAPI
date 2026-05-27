package org.bukkit.entity;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 代表牛.
 */
public interface Cow extends AbstractCow {

    /**
     * 获取此牛的变种.
     * <p>
     * 原文:
     * Get the variant of this cow.
     *
     * @return 牛的变种
     */
    @NotNull
    Variant getVariant();

    /**
     * 设置此牛的变种.
     * <p>
     * 原文:
     * Set the variant of this cow.
     *
     * @param variant 牛的变种
     */
    void setVariant(@NotNull Variant variant);

    /**
     * 代表牛的变种.
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
         * @deprecated 键可能并不总是存在, 请改用 {@link #getKeyOrThrow()}.
         */
        @NotNull
        @Override
        @Deprecated(since = "1.21.5")
        NamespacedKey getKey();

        @NotNull
        private static Variant getType(@NotNull String key) {
            return Registry.COW_VARIANT.getOrThrow(NamespacedKey.minecraft(key));
        }
    }
}