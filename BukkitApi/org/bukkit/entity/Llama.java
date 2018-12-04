package org.bukkit.entity;

import org.bukkit.inventory.LlamaInventory;

/**
 * 表示一只羊驼.
 */
public interface Llama extends ChestedHorse {

    /**
	 * 代表羊驼的颜色.
     */
    public enum Color {

        /**
		 * 奶油色的羊驼.
         */
        CREAMY,
        /**
         * 白色的羊驼.
         */
        WHITE,
        /**
         * 棕色的羊驼.
         */
        BROWN,
        /**
         * 灰色的羊驼.
         */
        GRAY;
    }

    /**
	 * 获取羊驼的颜色. 
	 * <p>
     * 原文:Gets the llama's color.
     *
     * @return 返回羊驼的{@linkplain Color 颜色}
     */
    Color getColor();

    /**
	 * 设置羊驼的颜色. 
	 * <p>
     * 原文:Sets the llama's color.
     *
     * @param color 给定的羊驼的{@linkplain Color 颜色}
     */
    void setColor(Color color);

    /**
	 * 获取羊驼的强度, 强度大的羊驼的背包将有更大的容量, 并对其他实体更具威胁性. 
	 * <p>
	 * 译注:此处的强度采用的是 中文Wiki 中的翻译, 但个人认为翻译为力气会好些
	 * <p>
     * 原文:Gets the llama's strength. A higher strength llama will have more
     * inventory slots and be more threatening to entities. 
     *
     * @return 羊驼的强度, 范围会在 [1-5] 之间
     */
    int getStrength();

    /**
	 * 设置羊驼的强度, 强度大的羊驼的背包将有更大的容量, 并对其他实体更具威胁性. 
	 * 羊驼的背包容量的计算公式: 强度值 * 3. 
	 * <p>
	 * 译注:此处的强度采用的是 中文Wiki 中的翻译, 但个人认为翻译为力气会好些. <p>
	 * 当给定的强度值不在 [1-5] 该范围内时,将会抛出异常 IllegalArgumentException.
	 * <p>
     * 原文:Sets the llama's strength. A higher strength llama will have more
     * inventory slots and be more threatening to entities. Inventory slots are
     * equal to strength * 3.
     *
     * @param strength 给定的强度值, 强度须在 [1-5] 之间
     */
    void setStrength(int strength);

    @Override
    LlamaInventory getInventory();
}
