package org.bukkit;

import java.util.List;

import org.bukkit.inventory.ItemStack;

/**
 * 这个接口提供可能在特定运行时间内或含有任意意义的数值的转换（即不安全的参数）。
 * <p>
 * 这些值的存在形式和行为不能保证在未来的版本可用。可能会非法命名，抛出异常，有误导参数或其他错误。
 * <p>
 * 这个接口只支持内部使用。
 *
 * @deprecated 不受支持{@literal &}只供内部使用
 */
@Deprecated
public interface UnsafeValues {

    Material getMaterialFromInternalName(String name);

    List<String> tabCompleteInternalMaterialName(String token, List<String> completions);

    ItemStack modifyItemStack(ItemStack stack, String arguments);

    Statistic getStatisticFromInternalName(String name);

    Achievement getAchievementFromInternalName(String name);

    List<String> tabCompleteInternalStatisticOrAchievementName(String token, List<String> completions);
}