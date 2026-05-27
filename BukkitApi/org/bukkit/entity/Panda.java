package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 代表熊猫.
 */
public interface Panda extends Animals, Sittable {

    /**
     * 获得熊猫的显性基因.
     * <p>
     * 原文：Gets this Panda's main gene.
     *
     * @return 显性基因
     */
    @NotNull
    Gene getMainGene();

    /**
     * 设置熊猫的显性基因.
     * <p>
     * 原文：Sets this Panda's main gene.
     *
     * @param gene 显性基因
     */
    void setMainGene(@NotNull Gene gene);

    /**
     * 获取隐性基因.
     * <p>
     * 原文：Gets this Panda's hidden gene.
     *
     * @return 隐性基因
     */
    @NotNull
    Gene getHiddenGene();

    /**
     * 设置隐性基因.
     * <p>
     * 原文：Sets this Panda's hidden gene.
     *
     * @param gene 隐性基因
     */
    void setHiddenGene(@NotNull Gene gene);

    /**
     * 获取熊猫是否正在翻滚。
     * <p>
     * 原文：Gets whether the Panda is rolling.
     *
     * @return 是否正在翻滚
     */
    boolean isRolling();

    /**
     * 设置熊猫是否正在翻滚。
     * <p>
     * 原文：Sets whether the Panda is rolling.
     *
     * @param flag 是否正在翻滚
     */
    void setRolling(boolean flag);

    /**
     * 获取熊猫是否正在打喷嚏。
     * <p>
     * 原文：Gets whether the Panda is sneezing.
     *
     * @return 是否正在打喷嚏
     */
    boolean isSneezing();

    /**
     * 设置熊猫是否正在打喷嚏。
     * <p>
     * 原文：Sets whether the Panda is sneezing.
     *
     * @param flag 是否正在打喷嚏
     */
    void setSneezing(boolean flag);

    /**
     * 获取熊猫是否正在翻倒（背朝下）。
     * <p>
     * 原文：Gets whether the Panda is on its back.
     *
     * @return 是否正在翻倒（背朝下）
     */
    boolean isOnBack();

    /**
     * 设置熊猫是否正在翻倒（背朝下）。
     * <p>
     * 原文：Sets whether the Panda is on its back.
     *
     * @param flag 是否正在翻倒（背朝下）
     */
    void setOnBack(boolean flag);

    /**
     * 获取熊猫是否正在进食。
     * <p>
     * 原文：Gets whether the Panda is eating.
     *
     * @return 是否正在进食
     */
    boolean isEating();

    /**
     * 设置熊猫的进食状态。熊猫必须持有食物才能生效。
     * <p>
     * 原文：Sets the Panda's eating status. The panda must be holding food for this to work.
     *
     * @param flag 是否正在进食
     */
    void setEating(boolean flag);

    /**
     * 获取熊猫是否害怕。
     * <p>
     * 原文：Gets whether the Panda is scared.
     *
     * @return 是否害怕
     */
    boolean isScared();

    /**
     * 获取熊猫将不开心持续多少tick。
     * <p>
     * 原文：Gets how many ticks the panda will be unhappy for.
     *
     * @return 熊猫将不开心持续的tick数
     */
    int getUnhappyTicks();

    public enum Gene {

        NORMAL(false),
        LAZY(false),
        WORRIED(false),
        PLAYFUL(false),
        BROWN(true),
        WEAK(true),
        AGGRESSIVE(false);

        private final boolean recessive;

        private Gene(boolean recessive) {
            this.recessive = recessive;
        }

        /**
         * 获得此基因是否为隐性基因, 也就是说要求父母需要遗传给孩子.
         * <p>
         * 原文：Gets whether this gene is recessive, i.e. required in both parents to propagate to children.
         *
         * @return 隐性状态
         */
        public boolean isRecessive() {
            return recessive;
        }
    }
}
