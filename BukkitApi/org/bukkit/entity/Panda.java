package org.bukkit.entity;

import org.jetbrains.annotations.NotNull;

/**
 * 代表熊猫.
 */
public interface Panda extends Animals, Sittable {

    /**
     * 获得熊猫的显性基因.
     * <p>
     * Gets this Panda's main gene.
     *
     * @return 显性基因
     */
    @NotNull
    Gene getMainGene();

    /**
     * 设置熊猫的显性基因.
     * <p>
     * 原文:
     * Sets this Panda's main gene.
     *
     * @param gene 显性基因
     */
    void setMainGene(@NotNull Gene gene);

    /**
     * 获取隐性基因.
     * <p>
     * 原文:
     * Gets this Panda's hidden gene.
     *
     * @return hidden gene
     */
    @NotNull
    Gene getHiddenGene();

    /**
     * 设置隐性基因.
     * <p>
     * 原文:
     * Sets this Panda's hidden gene.
     *
     * @param gene 隐形基因
     */
    void setHiddenGene(@NotNull Gene gene);

    /**
     * Gets whether the Panda is rolling
     *
     * @return Whether the Panda is rolling
     */
    boolean isRolling();

    /**
     * Sets whether the Panda is rolling
     *
     * @param flag Whether the Panda is rolling
     */
    void setRolling(boolean flag);

    /**
     * Gets whether the Panda is sneezing
     *
     * @return Whether the Panda is sneezing
     */
    boolean isSneezing();

    /**
     * Sets whether the Panda is sneezing
     *
     * @param flag Whether the Panda is sneezing
     */
    void setSneezing(boolean flag);

    /**
     * Gets whether the Panda is on its back
     *
     * @return Whether the Panda is on its back
     */
    boolean isOnBack();

    /**
     * Sets whether the Panda is on its back
     *
     * @param flag Whether the Panda is on its back
     */
    void setOnBack(boolean flag);

    /**
     * Gets whether the Panda is eating
     *
     * @return Whether the Panda is eating
     */
    boolean isEating();

    /**
     * Sets the Panda's eating status. The panda must be holding food for this to work
     *
     * @param flag Whether the Panda is eating
     */
    void setEating(boolean flag);

    /**
     * Gets whether the Panda is scared
     *
     * @return Whether the Panda is scared
     */
    boolean isScared();

    /**
     * Gets how many ticks the panda will be unhappy for
     *
     * @return The number of ticks the panda will be unhappy for
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
         * 原文:
         * Gets whether this gene is recessive, i.e. required in both parents to
         * propagate to children.
         *
         * @return 隐性状态
         */
        public boolean isRecessive() {
            return recessive;
        }
    }
}
