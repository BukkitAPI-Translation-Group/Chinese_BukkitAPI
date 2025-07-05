package org.bukkit.advancement;

import java.util.Collection;
import org.bukkit.Keyed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表可以被授予给玩家的进度. 这个类不是指针安全的, 因为底层的进度可能会被重载.
 */
public interface Advancement extends Keyed {

    /**
     * 获取此进度的所有标准. (即达成该进度所需的条件).
     * <p>
     * 原文:
     * Get all the criteria present in this advancement.
     *
     * @return 一个不可编辑的所有条件的副本
     */
    @NotNull
    Collection<String> getCriteria();

    /**
     * Returns the requirements for this advancement.
     *
     * @return an AdvancementRequirements object.
     */
    @NotNull
    AdvancementRequirements getRequirements();

    /**
     * 返回此进度的展示信息.
     *
     * 展示信息包括进度的名称、描述和可见性标签.
     * <p>
     * 原文:
     * Returns the display information for this advancement.
     *
     * This includes it's name, description and other visible tags.
     *
     * @return 一个 AdvancementDisplay 对象, 如果没有设置则为 null
     */
    @Nullable
    AdvancementDisplay getDisplay();
}
