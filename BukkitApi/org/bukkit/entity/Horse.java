package org.bukkit.entity;

import org.bukkit.inventory.HorseInventory;

/**
 * 代表一匹马.
 * <p>
 * 原文:Represents a Horse.
 */
public interface Horse extends AbstractHorse {

    /**
     * @deprecated 不同的种类是不同的类.
     */
    @Deprecated
    public enum Variant {
        /**
         * 普通马.
         */
        HORSE,
        /**
         * 驴. 
         */
        DONKEY,
        /**
         * 骡子. 
         */
        MULE,
        /**
         * 不死马(僵尸马). 
         */
        UNDEAD_HORSE,
        /**
         * 骷髅马. 
         */
        SKELETON_HORSE,
        /**
         * 不是真的马:(
         */
        LLAMA
        ;
    }

    /**
     * 标示马拥有的基本颜色. 
     * <p>
     * 原文:Represents the base color that the horse has.
     */
    public enum Color {
        /**
         * 雪白色
         */
        WHITE,
        /**
         * 非常浅棕色
         */
        CREAMY,
        /**
         * 栗色
         */
        CHESTNUT,
        /**
         * 浅棕色
         */
        BROWN,
        /**
         * 漆黑色
         */
        BLACK,
        /**
         * 灰色
         */
        GRAY,
        /**
         * 深棕色
         */
        DARK_BROWN,
        ;
    }

    /**
     * 代表马的风格或标记. 
     * <p>
     * 原文:Represents the style, or markings, that the horse has.
     */
    public enum Style {
        /**
         * 无标记
         */
        NONE,
        /**
         * 白短袜或条♂纹
         */
        WHITE,
        /**
         * 乳白色斑点
         */
        WHITEFIELD,
        /**
         * 圆白点
         */
        WHITE_DOTS,
        /**
         * 小黑点
         */
        BLACK_DOTS,
        ;
    }

    /**
     * 获取马的颜色. </br>
     * 颜色只适用于马,而不是驴,骡子,骷髅马或僵尸马.
     * <p>
     * 原文:Gets the horse's color.</br>
     * Colors only apply to horses, not to donkeys, mules, skeleton horses
     * or undead horses.
     *
     * @return {@link Color} 代表马的颜色.
     */
    public Color getColor();

    /**
     * 设置马的颜色. </br>
     * 试图为任何驴,骡子,骷髅马或僵尸马设定颜色不会有任何变化. 
     * <p>
     * 原文:
     * Sets the horse's color.</br>
     * Attempting to set a color for any donkey, mule, skeleton horse or
     * undead horse will not result in a change.
     *
     * @param color 一个{@link Color}为这匹马
     */
    public void setColor(Color color);

    /**
     * 得到马的风格. 风格决定马有什么样的标记或图案.</br>
     * 风格只适用于马,而不是驴,骡子,骷髅马或僵尸马.
     * <p> 
     * 原文:Gets the horse's style.
     * Styles determine what kind of markings or patterns a horse has.</br>
     * Styles only apply to horses, not to donkeys, mules, skeleton horses
     * or undead horses.
     *
     * @return 一个 {@link Style} 代表马的风格
     */
    public Style getStyle();

    /**
     * 设置马的风格. 风格决定马有什么样的标记或图案.</br>
     * 试图为任何驴,骡子,骷髅马或僵尸马设定风格不会有任何变化. 
     * <p>
     * 原文:Sets the style of this horse.
     * Styles determine what kind of markings or patterns a horse has.</br>
     * Attempting to set a style for any donkey, mule, skeleton horse or
     * undead horse will not result in a change.
     *
     * @param style 一个 {@link Style} 为这匹马
     */
    public void setStyle(Style style);

    /**
     * @return 是否携带箱子
     * @deprecated 看 {@link ChestedHorse}
     */
    @Deprecated
    public boolean isCarryingChest();

    /**
     * @param chest
     * @deprecated 看 {@link ChestedHorse}
     */
    @Deprecated
    public void setCarryingChest(boolean chest);

    @Override
    public HorseInventory getInventory();
}
