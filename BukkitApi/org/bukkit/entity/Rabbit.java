package org.bukkit.entity;

public interface Rabbit extends Animals {

    /**
     * @return 兔子的种类.
     */
    public Type getRabbitType();

    /**
     * @param type 设置兔子的种类.
     */
    public void setRabbitType(Type type);

    /**
     * 代表不同种类的兔子.
     */
    public enum Type {

        /**
         * 棕色的兔子.
         */
        BROWN,
        /**
         * 白色的兔子.
         */
        WHITE,
        /**
         * 黑色的兔子.
         */
        BLACK,
        /**
         * 黑白相间的兔子.
         */
        BLACK_AND_WHITE,
        /**
         * 金色的兔子.
         */
        GOLD,
        /**
         * 胡椒盐色的兔子.
         */
        SALT_AND_PEPPER,
        /**
         * 杀手兔.
         */
        THE_KILLER_BUNNY
    }
}
