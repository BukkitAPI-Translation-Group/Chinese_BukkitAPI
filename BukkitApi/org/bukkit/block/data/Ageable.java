package org.bukkit.block.data;

/**
 * 'age'表示农作物的不同生长阶段.
 * <br>
 * '0'值意味着这个农作物刚刚种下去，同时如果'age'值与 {@link #getMaximumAge()}
 * 相等，则表明此农作物已成熟并可被收获.
 * 译注：mc中(测试版本1.13)农作物最大有八个生长阶段，数值范围从0到7。
 * 不过不同农作物可能有差异，比如小麦有8个阶段，而甜菜只有4个阶段.
 */
public interface Ageable extends BlockData {

    /**
     * 获取'age'属性值.
     * <p>
     * 原文:Gets the value of the 'age' property.
     *
     * @return 生长阶段值，以整数表示
     */
    int getAge();

    /**
     * 设置'age'属性值.
     * <p>
     * 原文:Sets the value of the 'age' property.
     *
     * @param age 生长阶段值，以整数表示
     */
    void setAge(int age);

    /**
     * 获取该农作物'age'的最大值.
     * <p>
     * 原文:Gets the maximum allowed value of the 'age' property.
     *
     * @return 生长阶段最大值
     */
    int getMaximumAge();
}
