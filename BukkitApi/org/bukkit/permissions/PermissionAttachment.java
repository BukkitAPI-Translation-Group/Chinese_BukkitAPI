package org.bukkit.permissions;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 保存关于{@link Permissible}对象上权限附件的信息
 */
public class PermissionAttachment {
    private PermissionRemovedExecutor removed;
    private final Map<String, Boolean> permissions = new LinkedHashMap<String, Boolean>();
    private final Permissible permissible;
    private final Plugin plugin;

    public PermissionAttachment(@NotNull Plugin plugin, @NotNull Permissible permissible) {
        if (plugin == null) {
            throw new IllegalArgumentException("Plugin cannot be null");
        } else if (!plugin.isEnabled()) {
            throw new IllegalArgumentException("Plugin " + plugin.getDescription().getFullName() + " is disabled");
        }

        this.permissible = permissible;
        this.plugin = plugin;
    }

    /**
     * 获取负责此附件的插件.
     * <p>
     * 原文：
     * Gets the plugin responsible for this attachment
     *
     * @return 负责此权限附件的插件
     */
    @NotNull
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * 设置当此附件从{@link Permissible}移除时调用的对象. 可能为null.
     * <p>
     * 原文：
     * Sets an object to be called for when this attachment is removed from a
     * {@link Permissible}. May be null.
     *
     * @param ex 移除时调用的对象
     */
    public void setRemovalCallback(@Nullable PermissionRemovedExecutor ex) {
        removed = ex;
    }

    /**
     * 获取之前设置的当此附件从{@link Permissible}移除时调用的类. 可能为null.
     * <p>
     * 原文：
     * Gets the class that was previously set to be called when this
     * attachment was removed from a {@link Permissible}. May be null.
     *
     * @return 移除时调用的对象
     */
    @Nullable
    public PermissionRemovedExecutor getRemovalCallback() {
        return removed;
    }

    /**
     * 获取此附件附加到的Permissible.
     * <p>
     * 原文：
     * Gets the Permissible that this is attached to
     *
     * @return 包含此附件的Permissible
     */
    @NotNull
    public Permissible getPermissible() {
        return permissible;
    }

    /**
     * 获取此附件中包含的所有已设置权限和值的副本.
     * <p>
     * 此映射可以被修改但不会影响附件, 因为它是一个副本.
     * <p>
     * 原文：
     * Gets a copy of all set permissions and values contained within this
     * attachment.
     * <p>
     * This map may be modified but will not affect the attachment, as it is a
     * copy.
     *
     * @return 此附件表达的所有权限和值的副本
     */
    @NotNull
    public Map<String, Boolean> getPermissions() {
        return new LinkedHashMap<String, Boolean>(permissions);
    }

    /**
     * 通过完全限定名称设置权限为给定值.
     * <p>
     * 原文：
     * Sets a permission to the given value, by its fully qualified name
     *
     * @param name 权限名称
     * @param value 权限的新值
     */
    public void setPermission(@NotNull String name, boolean value) {
        permissions.put(name.toLowerCase(Locale.ROOT), value);
        permissible.recalculatePermissions();
    }

    /**
     * 设置权限为给定值.
     * <p>
     * 原文：
     * Sets a permission to the given value
     *
     * @param perm 要设置的权限
     * @param value 权限的新值
     */
    public void setPermission(@NotNull Permission perm, boolean value) {
        setPermission(perm.getName(), value);
    }

    /**
     * 从此附件中移除指定权限.
     * <p>
     * 如果此附件中不存在该权限, 什么也不会发生.
     * <p>
     * 原文：
     * Removes the specified permission from this attachment.
     * <p>
     * If the permission does not exist in this attachment, nothing will
     * happen.
     *
     * @param name 要移除的权限名称
     */
    public void unsetPermission(@NotNull String name) {
        permissions.remove(name.toLowerCase(Locale.ROOT));
        permissible.recalculatePermissions();
    }

    /**
     * 从此附件中移除指定权限.
     * <p>
     * 如果此附件中不存在该权限, 什么也不会发生.
     * <p>
     * 原文：
     * Removes the specified permission from this attachment.
     * <p>
     * If the permission does not exist in this attachment, nothing will
     * happen.
     *
     * @param perm 要移除的权限
     */
    public void unsetPermission(@NotNull Permission perm) {
        unsetPermission(perm.getName());
    }

    /**
     * 从此附件注册的{@link Permissible}中移除此附件.
     * <p>
     * 原文：
     * Removes this attachment from its registered {@link Permissible}
     *
     * @return 如果可权限对象被成功移除返回true, 如果不存在返回false
     */
    public boolean remove() {
        try {
            permissible.removeAttachment(this);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
