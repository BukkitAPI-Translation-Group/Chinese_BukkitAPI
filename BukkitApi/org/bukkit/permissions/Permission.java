package org.bukkit.permissions;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一个可以附加到{@link Permissible}的唯一权限
 */
public class Permission {
    public static final PermissionDefault DEFAULT_PERMISSION = PermissionDefault.OP;

    private final String name;
    private final Map<String, Boolean> children = new LinkedHashMap<String, Boolean>();
    private PermissionDefault defaultValue = DEFAULT_PERMISSION;
    private String description;

    public Permission(@NotNull String name) {
        this(name, null, null, null);
    }

    public Permission(@NotNull String name, @Nullable String description) {
        this(name, description, null, null);
    }

    public Permission(@NotNull String name, @Nullable PermissionDefault defaultValue) {
        this(name, null, defaultValue, null);
    }

    public Permission(@NotNull String name, @Nullable String description, @Nullable PermissionDefault defaultValue) {
        this(name, description, defaultValue, null);
    }

    public Permission(@NotNull String name, @Nullable Map<String, Boolean> children) {
        this(name, null, null, children);
    }

    public Permission(@NotNull String name, @Nullable String description, @Nullable Map<String, Boolean> children) {
        this(name, description, null, children);
    }

    public Permission(@NotNull String name, @Nullable PermissionDefault defaultValue, @Nullable Map<String, Boolean> children) {
        this(name, null, defaultValue, children);
    }

    public Permission(@NotNull String name, @Nullable String description, @Nullable PermissionDefault defaultValue, @Nullable Map<String, Boolean> children) {
        Preconditions.checkArgument(name != null, "Name cannot be null");
        this.name = name;
        this.description = (description == null) ? "" : description;

        if (defaultValue != null) {
            this.defaultValue = defaultValue;
        }

        if (children != null) {
            this.children.putAll(children);
        }
    }

    /**
     * 返回此权限的唯一完全限定名称.
     * <p>
     * 原文：
     * Returns the unique fully qualified name of this Permission
     *
     * @return 完全限定名称
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * 获取此权限的子权限.
     * <p>
     * 如果你以任何形式更改此映射, 必须调用{@link #recalculatePermissibles()}来重新计算所有{@link Permissible}
     * <p>
     * 原文：
     * Gets the children of this permission.
     * <p>
     * If you change this map in any form, you must call {@link
     * #recalculatePermissibles()} to recalculate all {@link Permissible}s
     *
     * @return 权限子项
     */
    @NotNull
    public Map<String, Boolean> getChildren() {
        return children;
    }

    /**
     * 获取此权限的默认值.
     * <p>
     * 原文：
     * Gets the default value of this permission.
     *
     * @return 此权限的默认值.
     */
    @NotNull
    public PermissionDefault getDefault() {
        return defaultValue;
    }

    /**
     * 设置此权限的默认值.
     * <p>
     * 这不会保存到磁盘, 是服务器重新加载权限之前的临时操作.
     * 更改此默认值将导致所有包含此权限的{@link Permissible}重新计算其权限.
     * <p>
     * 原文：
     * Sets the default value of this permission.
     * <p>
     * This will not be saved to disk, and is a temporary operation until the
     * server reloads permissions. Changing this default will cause all {@link
     * Permissible}s that contain this permission to recalculate their
     * permissions
     *
     * @param value 要设置的新默认值
     */
    public void setDefault(@NotNull PermissionDefault value) {
        if (defaultValue == null) {
            throw new IllegalArgumentException("Default value cannot be null");
        }

        defaultValue = value;
        recalculatePermissibles();
    }

    /**
     * 获取此权限的简要描述, 可能为空.
     * <p>
     * 原文：
     * Gets a brief description of this permission, may be empty
     *
     * @return 此权限的简要描述
     */
    @NotNull
    public String getDescription() {
        return description;
    }

    /**
     * 设置此权限的描述.
     * <p>
     * 这不会保存到磁盘, 是服务器重新加载权限之前的临时操作.
     * <p>
     * 原文：
     * Sets the description of this permission.
     * <p>
     * This will not be saved to disk, and is a temporary operation until the
     * server reloads permissions.
     *
     * @param value 要设置的新描述
     */
    public void setDescription(@Nullable String value) {
        if (value == null) {
            description = "";
        } else {
            description = value;
        }
    }

    /**
     * 获取包含此权限的每个{@link Permissible}的集合.
     * <p>
     * 此集合不能被修改.
     * <p>
     * 原文：
     * Gets a set containing every {@link Permissible} that has this
     * permission.
     * <p>
     * This set cannot be modified.
     *
     * @return 包含拥有此权限的可权限对象的集合
     */
    @NotNull
    public Set<Permissible> getPermissibles() {
        return Bukkit.getServer().getPluginManager().getPermissionSubscriptions(name);
    }

    /**
     * 重新计算所有包含此权限的{@link Permissible}.
     * <p>
     * 在修改子项后应调用此方法, 在修改默认值后会自动调用.
     * <p>
     * 原文：
     * Recalculates all {@link Permissible}s that contain this permission.
     * <p>
     * This should be called after modifying the children, and is
     * automatically called after modifying the default value
     */
    public void recalculatePermissibles() {
        Set<Permissible> perms = getPermissibles();

        Bukkit.getServer().getPluginManager().recalculatePermissionDefaults(this);

        for (Permissible p : perms) {
            p.recalculatePermissions();
        }
    }

    /**
     * 将此权限添加到指定的父权限.
     * <p>
     * 如果父权限不存在, 将被创建并注册.
     * <p>
     * 原文：
     * Adds this permission to the specified parent permission.
     * <p>
     * If the parent permission does not exist, it will be created and
     * registered.
     *
     * @param name 父权限名称
     * @param value 设置此权限的值
     * @return 创建或加载的父权限
     */
    @NotNull
    public Permission addParent(@NotNull String name, boolean value) {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        String lname = name.toLowerCase(Locale.ROOT);

        Permission perm = pm.getPermission(lname);

        if (perm == null) {
            perm = new Permission(lname);
            pm.addPermission(perm);
        }

        addParent(perm, value);

        return perm;
    }

    /**
     * 将此权限添加到指定的父权限.
     * <p>
     * 原文：
     * Adds this permission to the specified parent permission.
     *
     * @param perm 要注册的父权限
     * @param value 设置此权限的值
     */
    public void addParent(@NotNull Permission perm, boolean value) {
        perm.getChildren().put(getName(), value);
        perm.recalculatePermissibles();
    }

    /**
     * 从数据映射加载权限列表, 通常用于从yaml文件中检索.
     * <p>
     * 数据可能包含name:data列表, 其中data包含以下键：
     * <ul>
     * <li>default: Boolean true或false. 如果未指定则为false.
     * <li>children: 子权限的{@code Map<String, Boolean>}. 如果未指定则为空列表.
     * <li>description: 包含此描述的简短字符串. 如果未指定则为空字符串.
     * </ul>
     * <p>
     * 原文：
     * Loads a list of Permissions from a map of data, usually used from
     * retrieval from a yaml file.
     * <p>
     * The data may contain a list of name:data, where the data contains the
     * following keys:
     * <ul>
     * <li>default: Boolean true or false. If not specified, false.
     * <li>children: {@code Map<String, Boolean>} of child permissions. If not
     *     specified, empty list.
     * <li>description: Short string containing a very small description of
     *     this description. If not specified, empty string.
     * </ul>
     *
     * @param data 权限映射
     * @param error 如果权限无效时显示的错误消息. 可能包含"%s"格式标签, 将被替换为无效权限的名称.
     * @param def 如果缺失则使用的默认权限值
     * @return Permission对象
     */
    @NotNull
    public static List<Permission> loadPermissions(@NotNull Map<?, ?> data, @NotNull String error, @Nullable PermissionDefault def) {
        List<Permission> result = new ArrayList<Permission>();

        for (Map.Entry<?, ?> entry : data.entrySet()) {
            try {
                result.add(Permission.loadPermission(entry.getKey().toString(), (Map<?, ?>) entry.getValue(), def, result));
            } catch (Throwable ex) {
                Bukkit.getServer().getLogger().log(Level.SEVERE, String.format(error, entry.getKey()), ex);
            }
        }

        return result;
    }

    /**
     * 从数据映射加载一个权限, 通常用于从 yaml 文件中检索.
     * <p>
     * 数据可能包含以下键：
     * <ul>
     * <li>default: Boolean true 或 false. 如果未指定则为 false.
     * <li>children: 子权限的 {@code Map<String, Boolean>}. 如果未指定则为空列表.
     * <li>description: 包含此权限简要描述的短字符串. 如果未指定则为空字符串.
     * </ul>
     * <p>
     * 原文：Loads a Permission from a map of data, usually used from retrieval from
     * a yaml file.
     * <p>
     * The data may contain the following keys:
     * <ul>
     * <li>default: Boolean true or false. If not specified, false.
     * <li>children: {@code Map<String, Boolean>} of child permissions. If not
     *     specified, empty list.
     * <li>description: Short string containing a very small description of
     *     this description. If not specified, empty string.
     * </ul>
     *
     * @param name 权限名称
     * @param data 键映射
     * @return Permission 对象
     */
    @NotNull
    public static Permission loadPermission(@NotNull String name, @NotNull Map<String, Object> data) {
        return loadPermission(name, data, DEFAULT_PERMISSION, null);
    }

    /**
     * 从数据映射加载一个权限, 通常用于从 yaml 文件中检索.
     * <p>
     * 数据可能包含以下键：
     * <ul>
     * <li>default: Boolean true 或 false. 如果未指定则为 false.
     * <li>children: 子权限的 {@code Map<String, Boolean>}. 如果未指定则为空列表.
     * <li>description: 包含此权限简要描述的短字符串. 如果未指定则为空字符串.
     * </ul>
     * <p>
     * 原文：Loads a Permission from a map of data, usually used from retrieval from
     * a yaml file.
     * <p>
     * The data may contain the following keys:
     * <ul>
     * <li>default: Boolean true or false. If not specified, false.
     * <li>children: {@code Map<String, Boolean>} of child permissions. If not
     *     specified, empty list.
     * <li>description: Short string containing a very small description of
     *     this description. If not specified, empty string.
     * </ul>
     *
     * @param name 权限名称
     * @param data 键映射
     * @param def 如果未设置则使用的默认权限值
     * @param output 用于追加创建的子权限的列表, 可以为 null
     * @return Permission 对象
     */
    @NotNull
    public static Permission loadPermission(@NotNull String name, @NotNull Map<?, ?> data, @Nullable PermissionDefault def, @Nullable List<Permission> output) {
        Preconditions.checkArgument(name != null, "Name cannot be null");
        Preconditions.checkArgument(data != null, "Data cannot be null");

        String desc = null;
        Map<String, Boolean> children = null;

        if (data.get("default") != null) {
            PermissionDefault value = PermissionDefault.getByName(data.get("default").toString());
            if (value != null) {
                def = value;
            } else {
                throw new IllegalArgumentException("'default' key contained unknown value");
            }
        }

        if (data.get("children") != null) {
            Object childrenNode = data.get("children");
            if (childrenNode instanceof Iterable) {
                children = new LinkedHashMap<String, Boolean>();
                for (Object child : (Iterable<?>) childrenNode) {
                    if (child != null) {
                        children.put(child.toString(), Boolean.TRUE);
                    }
                }
            } else if (childrenNode instanceof Map) {
                children = extractChildren((Map<?, ?>) childrenNode, name, def, output);
            } else {
                throw new IllegalArgumentException("'children' key is of wrong type");
            }
        }

        if (data.get("description") != null) {
            desc = data.get("description").toString();
        }

        return new Permission(name, desc, def, children);
    }

    @NotNull
    private static Map<String, Boolean> extractChildren(@NotNull Map<?, ?> input, @NotNull String name, @Nullable PermissionDefault def, @Nullable List<Permission> output) {
        Map<String, Boolean> children = new LinkedHashMap<String, Boolean>();

        for (Map.Entry<?, ?> entry : input.entrySet()) {
            if ((entry.getValue() instanceof Boolean)) {
                children.put(entry.getKey().toString(), (Boolean) entry.getValue());
            } else if ((entry.getValue() instanceof Map)) {
                try {
                    Permission perm = loadPermission(entry.getKey().toString(), (Map<?, ?>) entry.getValue(), def, output);
                    children.put(perm.getName(), Boolean.TRUE);

                    if (output != null) {
                        output.add(perm);
                    }
                } catch (Throwable ex) {
                    throw new IllegalArgumentException("Permission node '" + entry.getKey().toString() + "' in child of " + name + " is invalid", ex);
                }
            } else {
                throw new IllegalArgumentException("Child '" + entry.getKey().toString() + "' contains invalid value");
            }
        }

        return children;
    }
}
