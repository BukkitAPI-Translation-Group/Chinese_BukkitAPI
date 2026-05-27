package org.bukkit.permissions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 保存关于权限以及提供该权限的{@link PermissionAttachment}的信息
 */
public class PermissionAttachmentInfo {
    private final Permissible permissible;
    private final String permission;
    private final PermissionAttachment attachment;
    private final boolean value;

    public PermissionAttachmentInfo(@NotNull Permissible permissible, @NotNull String permission, @Nullable PermissionAttachment attachment, boolean value) {
        if (permissible == null) {
            throw new IllegalArgumentException("Permissible may not be null");
        } else if (permission == null) {
            throw new IllegalArgumentException("Permission may not be null");
        }

        this.permissible = permissible;
        this.permission = permission;
        this.attachment = attachment;
        this.value = value;
    }

    /**
     * 获取此权限附加到的可权限对象.
     * <p>
     * 原文：
     * Gets the permissible this is attached to
     *
     * @return 此权限所属的Permissible
     */
    @NotNull
    public Permissible getPermissible() {
        return permissible;
    }

    /**
     * 获取被设置的权限.
     * <p>
     * 原文：
     * Gets the permission being set
     *
     * @return 权限名称
     */
    @NotNull
    public String getPermission() {
        return permission;
    }

    /**
     * 获取提供此权限的附件. 对于默认权限(通常是父权限)可能为null.
     * <p>
     * 原文：
     * Gets the attachment providing this permission. This may be null for
     * default permissions (usually parent permissions).
     *
     * @return 附件
     */
    @Nullable
    public PermissionAttachment getAttachment() {
        return attachment;
    }

    /**
     * 获取此权限的值.
     * <p>
     * 原文：
     * Gets the value of this permission
     *
     * @return 权限的值
     */
    public boolean getValue() {
        return value;
    }
}
