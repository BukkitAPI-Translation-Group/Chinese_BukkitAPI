
package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表豹猫.
 */
public interface Ocelot extends Animals {

    /**
     * Checks if this ocelot trusts players.
     *
     * @return true if it trusts players
     */
    public boolean isTrusting();

    /**
     * Sets if this ocelot trusts players.
     *
     * @param trust true if it trusts players
     */
    public void setTrusting(boolean trust);

    /**
     * 获取这只猫的种类.
     * <p>
     * 原文:Gets the current type of this cat.
     *
     * @return 猫的种类
     * @deprecated 猫现在是单独的实体
     */
    @NotNull
    @Deprecated(since = "1.19.4")
    public Type getCatType();

    /**
     * 设置这只猫的种类.
     * <p>
     * 原文：Sets the current type of this cat.
     *
     * @param type 这只猫的新种类
     * @deprecated 猫现在是单独的实体
     */
    @Deprecated(since = "1.19.4")
    public void setCatType(@NotNull Type type);

    /**
     * 代表不同的猫的种类.
     * <p>
     * 译注：具体有哪些种类及特征可以查阅MineCraft Wiki.
     * @deprecated 不同猫种现在属于不同的生物/Cats are now a separate entity.
     */
    @Deprecated(since = "1.14")
    public enum Type {
        WILD_OCELOT(0),
        BLACK_CAT(1),
        RED_CAT(2),
        SIAMESE_CAT(3);

        private static final Type[] types = new Type[Type.values().length];
        private final int id;

        static {
            for (Type type : values()) {
                types[type.getId()] = type;
            }
        }

        private Type(int id) {
            this.id = id;
        }

        /**
         * 获取这个猫的种类的id.
         * <p>
         * 原文：Gets the ID of this cat type.
         *
         * @return 种类id
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
        public int getId() {
            return id;
        }

        /**
         * 用id获取猫的种类.
         * <p>
         * 原文：Gets a cat type by its ID.
         *
         * @param id 要获取这个种类的id
         * @return 种类,如果是null的话就是没找到
         * @deprecated 不安全的参数
         */
        @Deprecated(since = "1.6.2")
        @Nullable
        public static Type getType(int id) {
            return (id >= types.length) ? null : types[id];
        }
    }
}