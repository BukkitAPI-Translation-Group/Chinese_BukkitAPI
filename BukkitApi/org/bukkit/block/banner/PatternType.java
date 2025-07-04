package org.bukkit.block.banner;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Locale;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.registry.RegistryAware;
import org.bukkit.util.OldEnum;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PatternType extends OldEnum<PatternType>, Keyed, RegistryAware {
    PatternType BASE = getType("base");
    PatternType SQUARE_BOTTOM_LEFT = getType("square_bottom_left");
    PatternType SQUARE_BOTTOM_RIGHT = getType("square_bottom_right");
    PatternType SQUARE_TOP_LEFT = getType("square_top_left");
    PatternType SQUARE_TOP_RIGHT = getType("square_top_right");
    PatternType STRIPE_BOTTOM = getType("stripe_bottom");
    PatternType STRIPE_TOP = getType("stripe_top");
    PatternType STRIPE_LEFT = getType("stripe_left");
    PatternType STRIPE_RIGHT = getType("stripe_right");
    PatternType STRIPE_CENTER = getType("stripe_center");
    PatternType STRIPE_MIDDLE = getType("stripe_middle");
    PatternType STRIPE_DOWNRIGHT = getType("stripe_downright");
    PatternType STRIPE_DOWNLEFT = getType("stripe_downleft");
    PatternType SMALL_STRIPES = getType("small_stripes");
    PatternType CROSS = getType("cross");
    PatternType STRAIGHT_CROSS = getType("straight_cross");
    PatternType TRIANGLE_BOTTOM = getType("triangle_bottom");
    PatternType TRIANGLE_TOP = getType("triangle_top");
    PatternType TRIANGLES_BOTTOM = getType("triangles_bottom");
    PatternType TRIANGLES_TOP = getType("triangles_top");
    PatternType DIAGONAL_LEFT = getType("diagonal_left");
    PatternType DIAGONAL_UP_RIGHT = getType("diagonal_up_right");
    PatternType DIAGONAL_UP_LEFT = getType("diagonal_up_left");
    PatternType DIAGONAL_RIGHT = getType("diagonal_right");
    PatternType CIRCLE = getType("circle");
    PatternType RHOMBUS = getType("rhombus");
    PatternType HALF_VERTICAL = getType("half_vertical");
    PatternType HALF_HORIZONTAL = getType("half_horizontal");
    PatternType HALF_VERTICAL_RIGHT = getType("half_vertical_right");
    PatternType HALF_HORIZONTAL_BOTTOM = getType("half_horizontal_bottom");
    PatternType BORDER = getType("border");
    PatternType CURLY_BORDER = getType("curly_border");
    PatternType CREEPER = getType("creeper");
    PatternType GRADIENT = getType("gradient");
    PatternType GRADIENT_UP = getType("gradient_up");
    PatternType BRICKS = getType("bricks");
    PatternType SKULL = getType("skull");
    PatternType FLOWER = getType("flower");
    PatternType MOJANG = getType("mojang");
    PatternType GLOBE = getType("globe");
    PatternType PIGLIN = getType("piglin");
    PatternType FLOW = getType("flow");
    PatternType GUSTER = getType("guster");

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
     * 返回用于表示这种图案类型的标识符.
     * <p>
     * 原文:
     * Returns the identifier used to represent
     * this pattern type
     *
     * @return 图案的标识符
     * @see #getKey
     * @deprecated 魔法值
     */
    @NotNull
    @Deprecated(since = "1.20.4", forRemoval = true)
    public String getIdentifier();

    /**
     * 返回与标识符匹配的图案, 如果找不到匹配的图案类型, 将返回 null.
     * <p>
     * 原文:
     * Returns the pattern type which matches the passed
     * identifier or null if no matches are found
     *
     * @param identifier 标识符
     * @return 匹配的图案类型或 null
     * @see Registry#BANNER_PATTERN
     * @deprecated魔法值, 请使用 {@link Registry#get(NamespacedKey)}
     */
    @Contract("null -> null")
    @Nullable
    @Deprecated(since = "1.20.4", forRemoval = true)
    public static PatternType getByIdentifier(@Nullable String identifier) {
        if (identifier == null) {
            return null;
        }

        for (PatternType type : Registry.BANNER_PATTERN) {
            if (identifier.equals(type.getIdentifier())) {
                return type;
            }
        }

        return null;
    }

    @NotNull
    private static PatternType getType(@NotNull String key) {
        return Registry.BANNER_PATTERN.getOrThrow(NamespacedKey.minecraft(key));
    }

    /**
     * @param name of the pattern type.
     * @return the pattern type with the given name.
     * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead.
     */
    @NotNull
    @Deprecated(since = "1.21")
    static PatternType valueOf(@NotNull String name) {
        PatternType type = Registry.BANNER_PATTERN.get(NamespacedKey.fromString(name.toLowerCase(Locale.ROOT)));
        Preconditions.checkArgument(type != null, "No pattern type found with the name %s", name);
        return type;
    }

    /**
     * @return an array of all known pattern types.
     * @deprecated use {@link Registry#iterator()}.
     */
    @NotNull
    @Deprecated(since = "1.21")
    static PatternType[] values() {
        return Lists.newArrayList(Registry.BANNER_PATTERN).toArray(new PatternType[0]);
    }
}