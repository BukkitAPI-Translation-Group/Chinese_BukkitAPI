package org.bukkit.block.banner;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum PatternType {
    BASE("b"),
    SQUARE_BOTTOM_LEFT("bl"),
    SQUARE_BOTTOM_RIGHT("br"),
    SQUARE_TOP_LEFT("tl"),
    SQUARE_TOP_RIGHT("tr"),
    STRIPE_BOTTOM("bs"),
    STRIPE_TOP("ts"),
    STRIPE_LEFT("ls"),
    STRIPE_RIGHT("rs"),
    STRIPE_CENTER("cs"),
    STRIPE_MIDDLE("ms"),
    STRIPE_DOWNRIGHT("drs"),
    STRIPE_DOWNLEFT("dls"),
    STRIPE_SMALL("ss"),
    CROSS("cr"),
    STRAIGHT_CROSS("sc"),
    TRIANGLE_BOTTOM("bt"),
    TRIANGLE_TOP("tt"),
    TRIANGLES_BOTTOM("bts"),
    TRIANGLES_TOP("tts"),
    DIAGONAL_LEFT("ld"),
    DIAGONAL_RIGHT("rd"),
    DIAGONAL_LEFT_MIRROR("lud"),
    DIAGONAL_RIGHT_MIRROR("rud"),
    CIRCLE_MIDDLE("mc"),
    RHOMBUS_MIDDLE("mr"),
    HALF_VERTICAL("vh"),
    HALF_HORIZONTAL("hh"),
    HALF_VERTICAL_MIRROR("vhr"),
    HALF_HORIZONTAL_MIRROR("hhb"),
    BORDER("bo"),
    CURLY_BORDER("cbo"),
    CREEPER("cre"),
    GRADIENT("gra"),
    GRADIENT_UP("gru"),
    BRICKS("bri"),
    SKULL("sku"),
    FLOWER("flo"),
    MOJANG("moj"),
    GLOBE("glb"),
    PIGLIN("pig");

    private final String identifier;
    private static final Map<String, PatternType> byString = new HashMap<String, PatternType>();

    static {
        for (PatternType p : values()) {
            byString.put(p.identifier, p);
        }
    }

    private PatternType(/*@NotNull*/ String key) {
        this.identifier = key;
    }

    /**
     * 返回用于表示这种图案类型的标识符.
     * <p>
     * 原文:
     * Returns the identifier used to represent
     * this pattern type
     *
     * @return 图案的标识符
     */
    @NotNull
    public String getIdentifier() {
        return identifier;
    }

    /**
     * 返回与标识符匹配的图案, 如果找不到匹配的图案类型, 将返回 null.
     * <p>
     * 原文:
     * Returns the pattern type which matches the passed
     * identifier or null if no matches are found
     *
     * @param identifier 标识符
     * @return 匹配的图案类型或 null
     */
    @Contract("null -> null")
    @Nullable
    public static PatternType getByIdentifier(@Nullable String identifier) {
        return byString.get(identifier);
    }
}