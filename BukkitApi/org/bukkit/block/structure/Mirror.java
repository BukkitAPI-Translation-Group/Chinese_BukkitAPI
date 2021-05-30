package org.bukkit.block.structure;

/**
 * 代表{@link org.bukkit.block.Structure 结构方块}加载时如何产生镜像.
 */
public enum Mirror {

    /**
     * 无镜像.
     * <br>
     * X轴正半轴到Z轴正半轴.
     */
    NONE,
    /**
     * 结构左右镜像翻转.
     * <br>
     * 与在镜子中看东西类似. X轴正半轴到Z轴负半轴.
     */
    LEFT_RIGHT,
    /**
     * 结构前后镜像翻转.
     * <br>
     * Z轴正半轴到X轴负半轴.
     */
    FRONT_BACK;
}
