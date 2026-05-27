package org.bukkit.entity;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 代表鸡.
 */
public interface Chicken extends Animals {

    /**
     * 获取这只鸡的变种.
     * <p>
     * 原文: Get the variant of this chicken.
     *
     * @return 鸡的变种
     */
    @NotNull
    Variant getVariant();

    /**
     * 设置这只鸡的变种.
     * <p>
     * 原文: Set the variant of this chicken.
     *
     * @param variant 鸡的变种
     */
    void setVariant(@NotNull Variant variant);

    /**
     * 代表鸡的变种.
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
         * @deprecated key 可能不总是存在, 请使用 {@link #getKeyOrThrow()} 代替.
         */
        @NotNull
        @Override
        @Deprecated(since = "1.21.5")
        NamespacedKey getKey();

        @NotNull
        private static Variant getType(@NotNull String key) {
            return Registry.CHICKEN_VARIANT.getOrThrow(NamespacedKey.minecraft(key));
        }
    }
}