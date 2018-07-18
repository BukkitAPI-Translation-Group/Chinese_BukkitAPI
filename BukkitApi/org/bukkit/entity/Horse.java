package org.bukkit.entity;

import org.bukkit.inventory.HorseInventory;

/**
 * 代表一匹马.
 */
public interface Horse extends AbstractHorse {

    /**
     * @deprecated 不同的种类对应不同的类.
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
     * 表示马拥有的基本颜色. 
     */
    public enum Color {
        /**
         * 雪白色
         */
        WHITE,
        /**
         * 奶油色
         */
        CREAMY,
        /**
         * 栗色
         */
        CHESTNUT,
        /**
         * 褐色
         */
        BROWN,
        /**
         * 黑色
         */
        BLACK,
        /**
         * 灰色
         */
        GRAY,
        /**
         * 深褐色
         */
        DARK_BROWN,
        ;
    }

    /**
     * 代表马的花纹图案. 
     * <p>
     * 原文:Represents the style, or markings, that the horse has.
     */
    public enum Style {
        /**
         * 无花纹
         */
        NONE,
        /**
         * 白短袜或条纹
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
     * 该颜色只适用于马,而不适用于驴,骡子,骷髅马或僵尸马.
     * <p>
     * 原文:Gets the horse's color.</br>
     * Colors only apply to horses, not to donkeys, mules, skeleton horses
     * or undead horses.
     *
     * @return {@link Color} 马的颜色.
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
     * @param color 马的{@link Color 颜色}
     */
    public void setColor(Color color);

    /**
     * 得到马的外貌特征.
     * 这些特征决定马有什么样的图案.</br>
     * 这些特征只适用于马,而不适用于驴,骡子,骷髅马或僵尸马.
     * <p> 
     * 原文:Gets the horse's style.
     * Styles determine what kind of markings or patterns a horse has.</br>
     * Styles only apply to horses, not to donkeys, mules, skeleton horses
     * or undead horses.
     *
     * @return 马的{@link Style 花纹与图案}
     */
    public Style getStyle();

    /**
     * 设置马的外貌特征. 风格决定马有什么样的标记或图案.</br>
     * 试图为任何驴,骡子,骷髅马或僵尸马设定这些特征不会有任何变化. 
     * <p>
     * 原文:Sets the style of this horse.
     * Styles determine what kind of markings or patterns a horse has.</br>
     * Attempting to set a style for any donkey, mule, skeleton horse or
     * undead horse will not result in a change.
     *
     * @param style 马的{@link Style 花纹与图案}
     */
    public void setStyle(Style style);

    /**
     * @return 是否携带箱子
     * @deprecated 请参阅 {@link ChestedHorse}
     */
    @Deprecated
    public boolean isCarryingChest();

    /**
     * @param chest 是否携带箱子
     * @deprecated 请参阅 {@link ChestedHorse}
     */
    @Deprecated
    public void setCarryingChest(boolean chest);

    @Override
    public HorseInventory getInventory();
}
