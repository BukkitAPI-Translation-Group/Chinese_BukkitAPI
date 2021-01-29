package org.bukkit.block.data;

/**
 * 'level' 值代表该方块中液体的高度, 其液体要么单独存在要么在炼药锅内.
 * <br>
 * 对于水和熔岩方块而言, 'level' 有着特殊的含义:
 * 'level' 为 0 时相当于源方块, 1-7 是常规的液体高度, 8-15 适用于流下的液体.
 * 所有流下的液体都有着相同的行为, 但 'level' 值与其上方的方块相对应,
 * 上方的液体方块的 'level' 等于 <code>this.level - 8</code>.
 * <b>Note that counterintuitively, an adjusted level of 1 is the highest level,
 * whilst 7 is the lowest.</b>
 * <br>
 * 值不可大于 {@link #getMaximumLevel()}.
 * <p>
 * 原文:
 * 'level' represents the amount of fluid contained within this block, either by
 * itself or inside a cauldron.
 * <br>
 * In the case of water and lava blocks the levels have special meanings: a
 * level of 0 corresponds to a source block, 1-7 regular fluid heights, and 8-15
 * to "falling" fluids. All falling fluids have the same behaviour, but the
 * level corresponds to that of the block above them, equal to
 * <code>this.level - 8</code>
 * <b>Note that counterintuitively, an adjusted level of 1 is the highest level,
 * whilst 7 is the lowest.</b>
 * <br>
 * May not be higher than {@link #getMaximumLevel()}.
 */
public interface Levelled extends BlockData {

    /**
     * 获取 'level' 属性的值.
     * <p>
     * 原文:
     * Gets the value of the 'level' property.
     *
     * @return 属性 'level' 的值
     */
    int getLevel();

    /**
     * 设置 'level' 属性的值.
     * <p>
     * 原文:
     * Sets the value of the 'level' property.
     *
     * @param level 新的 'level' 属性值
     */
    void setLevel(int level);

    /**
     * 获取 'level' 属性所能允许的最大值.
     * <p>
     * 原文:
     * Gets the maximum allowed value of the 'level' property.
     *
     * @return 'level' 属性的最大值
     */
    int getMaximumLevel();
}
