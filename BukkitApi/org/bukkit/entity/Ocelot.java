
package org.bukkit.entity;

/**
 * 代表豹猫.
 */
public interface Ocelot extends Animals, Tameable, Sittable {

    /**
     * 获取这只猫当前的种类.
     * <p>
     * 原文：Gets the current type of this cat.
     *
     * @return 这只猫的种类
     */
    public Type getCatType();

    /**
     * 设置这只猫的种类.
     * <p>
     * 原文：Sets the current type of this cat.
     *
     * @param type 这只猫的新种类
     */
    public void setCatType(Type type);

    /**
     * 代表不同的猫的种类.
     * <p>
     * 译注：具体有哪些种类及特征可以查阅MineCraft Wiki.
     */
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
        @Deprecated
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
        @Deprecated
        public static Type getType(int id) {
            return (id >= types.length) ? null : types[id];
        }
    }
}