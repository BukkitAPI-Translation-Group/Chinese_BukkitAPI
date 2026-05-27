package org.bukkit.entity;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.bukkit.util.OldEnum;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 青蛙.
 */
public interface Frog extends Animals {

    /**
     * 获取此青蛙的舌头目标.
     * <p>
     * 原文：Gets the tongue target of this frog.
     *
     * @return 舌头目标, 如果未设置则为 null
     */
    @Nullable
    Entity getTongueTarget();

    /**
     * 设置此青蛙的舌头目标.
     * <p>
     * 原文：Sets the tongue target of this frog.
     *
     * @param target 舌头目标, 或 null 以清除
     */
    void setTongueTarget(@Nullable Entity target);

    /**
     * 获取此青蛙的变种.
     * <p>
     * 原文：Get the variant of this frog.
     *
     * @return 青蛙变种
     */
    @NotNull
    Variant getVariant();

    /**
     * 设置此青蛙的变种.
     * <p>
     * 原文：Set the variant of this frog.
     *
     * @param variant 青蛙变种
     */
    void setVariant(@NotNull Variant variant);

    /**
     * 青蛙的变种 - 即其颜色.
     */
    interface Variant extends OldEnum<Variant>, Keyed, RegistryAware {

        /**
         * 温带 (棕橙色) 青蛙.
         */
        Variant TEMPERATE = getVariant("temperate");
        /**
         * 温暖 (灰色) 青蛙.
         */
        Variant WARM = getVariant("warm");
        /**
         * 寒冷 (绿色) 青蛙.
         */
        Variant COLD = getVariant("cold");

        @NotNull
        private static Variant getVariant(@NotNull String key) {
            return Registry.FROG_VARIANT.getOrThrow(NamespacedKey.minecraft(key));
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
         * @param name of the frog variant.
         * @return the frog variant with the given name.
         * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Variant valueOf(@NotNull String name) {
            Variant variant = Registry.FROG_VARIANT.get(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
            Preconditions.checkArgument(variant != null, "No frog variant found with the name %s", name);
            return variant;
        }

        /**
         * @return an array of all known frog variants.
         * @deprecated use {@link Registry#iterator()}.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Variant[] values() {
            return Lists.newArrayList(Registry.FROG_VARIANT).toArray(new Variant[0]);
        }
    }
}
