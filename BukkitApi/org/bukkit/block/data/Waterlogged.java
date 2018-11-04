package org.bukkit.block.data;

/**
 * 'waterlogged'表示方块是否处于流体之中.
 * <p>
 * 译注:值得注意的是，如果方块只是被水流穿过,则该值为false而非true.
 * 在该方块上放水或者在充满水的地方(比如小池、河流、海洋)放置方块，则该值为true.
 * 原文“fluid”翻译为流体，理论上如果我放置方块到地狱的岩浆海下，'waterlogged'的值也应为true,
 * 但mc客户端依然告诉我该值为false.不知是bug还是不适用于岩浆.
 * 欢迎前往github发issue讨论.
 */
public interface Waterlogged extends BlockData {

    /**
     * 获取'waterlogged'属性值.
     * <p>
     * 原文:Gets the value of the 'waterlogged' property.
     *
     * @return 方块是否处于流体之中
     */
    boolean isWaterlogged();

    /**
     * 设置'waterlogged'属性值.
     * <p>
     * 原文:Sets the value of the 'waterlogged' property.
     *
     * @param waterlogged 方块是否处于流体之中
     */
    void setWaterlogged(boolean waterlogged);
}
