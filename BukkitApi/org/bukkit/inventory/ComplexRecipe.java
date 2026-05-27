package org.bukkit.inventory;

import org.bukkit.Keyed;

/**
 * 代表一个具有服务端定义行为的复杂配方, 例如盔甲染色.
 * <p>
 * 注意：由于复杂配方具有动态输出, {@link #getResult()}有时会返回一个空物品堆.
 */
public interface ComplexRecipe extends Recipe, Keyed {}
