package org.bukkit.advancement;

import java.util.Collection;
import org.bukkit.Keyed;
import org.jetbrains.annotations.NotNull;

/**
 * 代表可以被授予给玩家的进度. 这个类不是指针安全的，因为底层的进度可能会被重载.
 */
public interface Advancement extends Keyed {

    /**
     * 获取此进度的所有标准. (即达成该进度所需的条件).
     * <p>
     * 原文:Get all the criteria present in this advancement.
     *
     * @return 一个不可编辑的所有条件的副本
     */
    @NotNull
    Collection<String> getCriteria();
}
