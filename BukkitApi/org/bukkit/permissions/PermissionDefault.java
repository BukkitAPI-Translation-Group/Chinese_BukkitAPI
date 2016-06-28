package org.bukkit.permissions;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示权限的默认值.
 */
public enum PermissionDefault {
    TRUE("true"),
    FALSE("false"),
    OP("op", "isop", "operator", "isoperator", "admin", "isadmin"),
    NOT_OP("!op", "notop", "!operator", "notoperator", "!admin", "notadmin");

    private final String[] names;
    private final static Map<String, PermissionDefault> lookup = new HashMap<String, PermissionDefault>();

    private PermissionDefault(String... names) {
        this.names = names;
    }

    /**
     * 计算此默认权限给予某op的值.
     * <p>
     * 原文:
     * Calculates the value of this PermissionDefault for the given operator
     * value
     *
     * @param op 如果此目标是op
     * @return 如果默认是true，返回true，如果不是true的返回false
     */
    public boolean getValue(boolean op) {
        switch (this) {
        case TRUE:
            return true;
        case FALSE:
            return false;
        case OP:
            return op;
        case NOT_OP:
            return !op;
        default:
            return false;
        }
    }

    /**
     * 查找一个默认权限的名称.
     * <p>
     * 原文:
     * Looks up a PermissionDefault by name
     *
     * @param name 默认名称
     * @return 指定的值，如果为null即未找到
     */
    public static PermissionDefault getByName(String name) {
        return lookup.get(name.toLowerCase(java.util.Locale.ENGLISH).replaceAll("[^a-z!]", ""));
    }

    @Override
    public String toString() {
        return names[0];
    }

    static {
        for (PermissionDefault value : values()) {
            for (String name : value.names) {
                lookup.put(name, value);
            }
        }
    }
}
