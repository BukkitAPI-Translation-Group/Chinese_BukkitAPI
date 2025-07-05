package org.bukkit.entity;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.DyeColor;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.bukkit.util.OldEnum;
import org.jetbrains.annotations.NotNull;

/**
 * 喵.
 */
public interface Cat extends Tameable, Sittable {

    /**
     * 获取这只猫的品种.
     * <p>
     * 原文：
     * Gets the current type of this cat.
     *
     * @return 猫的品种
     */
    @NotNull
    public Type getCatType();

    /**
     * 设置这只猫的品种.
     * <p>
     * 原文：
     * Sets the current type of this cat.
     *
     * @param type 为这只猫设置的新品种
     */
    public void setCatType(@NotNull Type type);

    /**
     * 获取这只猫的项圈颜色.
     * <p>
     * 原文:
     * Get the collar color of this cat
     *
     * @return 项圈的颜色
     */
    @NotNull
    public DyeColor getCollarColor();

    /**
     * 设置这只猫的项圈颜色.
     * <p>
     * 原文:
     * Set the collar color of this cat
     *
     * @param color 要设置的颜色
     */
    public void setCollarColor(@NotNull DyeColor color);

    /**
     * 代表了各种猫的品种.
     * <p>
     * Represents the various different cat types there are.
     */
    interface Type extends OldEnum<Type>, Keyed, RegistryAware {

        Type TABBY = getType("tabby");
        Type BLACK = getType("black");
        Type RED = getType("red");
        Type SIAMESE = getType("siamese");
        Type BRITISH_SHORTHAIR = getType("british_shorthair");
        Type CALICO = getType("calico");
        Type PERSIAN = getType("persian");
        Type RAGDOLL = getType("ragdoll");
        Type WHITE = getType("white");
        Type JELLIE = getType("jellie");
        Type ALL_BLACK = getType("all_black");

        @NotNull
        private static Type getType(@NotNull String key) {
            return Registry.CAT_VARIANT.getOrThrow(NamespacedKey.minecraft(key));
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
         * @param name of the cat type.
         * @return the cat type with the given name.
         * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Type valueOf(@NotNull String name) {
            Type type = Registry.CAT_VARIANT.get(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
            Preconditions.checkArgument(type != null, "No cat type found with the name %s", name);
            return type;
        }

        /**
         * @return an array of all known cat types.
         * @deprecated use {@link Registry#iterator()}.
         */
        @NotNull
        @Deprecated(since = "1.21")
        static Type[] values() {
            return Lists.newArrayList(Registry.CAT_VARIANT).toArray(new Type[0]);
        }
    }
}
