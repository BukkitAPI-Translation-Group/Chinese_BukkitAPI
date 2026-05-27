package org.bukkit.entity;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.jetbrains.annotations.NotNull;

/**
 * 表示僵尸鹦鹉螺。
 */
public interface ZombieNautilus extends AbstractNautilus {

    /**
     * 获取此僵尸鹦鹉螺的变体。
     *
     * @return 僵尸鹦鹉螺变体
     * <p>
     * 原文：Get the variant of this zombie nautilus.
     *
     * @return zombie nautilus variant
     */
    @NotNull
    Variant getVariant();

    /**
     * 设置此僵尸鹦鹉螺的变体。
     *
     * @param variant 僵尸鹦鹉螺变体
     * <p>
     * 原文：Set the variant of this zombie nautilus.
     *
     * @param variant zombie nautilus variant
     */
    void setVariant(@NotNull Variant variant);

    /**
     * 表示僵尸鹦鹉螺的变体。
     */
    interface Variant extends Keyed, RegistryAware {

        Variant TEMPERATE = getType("temperate");
        Variant WARM = getType("warm");

        /**
         * {@inheritDoc}
         *
         * @see #getKeyOrThrow()
         * @see #isRegistered()
         * @deprecated 密钥可能并不总是存在，请使用
         * {@link #getKeyOrThrow()}代替。
         * <p>
         * 原文：{@inheritDoc}
         *
         * @see #getKeyOrThrow()
         * @see #isRegistered()
         * @deprecated A key might not always be present, use
         * {@link #getKeyOrThrow()} instead.
         */
        @NotNull
        @Override
        @Deprecated(since = "1.21.5")
        NamespacedKey getKey();

        @NotNull
        private static Variant getType(@NotNull String key) {
            return Registry.ZOMBIE_NAUTILUS_VARIANT.getOrThrow(NamespacedKey.minecraft(key));
        }
    }
}
