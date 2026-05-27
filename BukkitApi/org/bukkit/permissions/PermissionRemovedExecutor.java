package org.bukkit.permissions;

import org.jetbrains.annotations.NotNull;

/**
 * 代表一个在{@link PermissionAttachment}从{@link Permissible}中移除时被通知的类.
 */
public interface PermissionRemovedExecutor {

    /**
     * 当{@link PermissionAttachment}从{@link Permissible}中移除时调用.
     *
     * @param attachment 被移除的附件
     */
    public void attachmentRemoved(@NotNull PermissionAttachment attachment);
}
