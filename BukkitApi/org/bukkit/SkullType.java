package org.bukkit;

/**
 * 代表不同种类的头颅.
 * @deprecated 现在(Bukkit 1.13版本及以上)不同种类的头颅都有他们自己的常量了.
 */
@Deprecated(since = "1.13")
public enum SkullType {
    SKELETON,
    WITHER,
    ZOMBIE,
    PLAYER,
    CREEPER,
    DRAGON,
    PIGLIN;
}