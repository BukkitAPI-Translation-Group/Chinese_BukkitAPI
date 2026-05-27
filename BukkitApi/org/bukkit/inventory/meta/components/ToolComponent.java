package org.bukkit.inventory.meta.components;

import java.util.Collection;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 表示一个可以将任何物品转变为工具的组件。
 */
@ApiStatus.Experimental
public interface ToolComponent extends ConfigurationSerializable {

    /**
     * 获取此工具的默认挖掘速度。如果没有规则明确覆盖此值，则工具使用此值。1.0为标准挖掘速度。
     * <p>原文：Get the default mining speed of this tool. This value is used by the tool if no rule explicitly overrides it. 1.0 is standard mining speed.
     *
     * @return 默认挖掘速度
     * @see ToolRule#getSpeed()
     */
    float getDefaultMiningSpeed();

    /**
     * 设置此工具的默认挖掘速度。如果没有规则明确覆盖此值，则工具使用此值。1.0为标准挖掘速度。
     * <p>原文：Set the default mining speed of this tool. This value is used by the tool if no rule explicitly overrides it. 1.0 is standard mining speed.
     *
     * @param speed 要设置的速度
     */
    void setDefaultMiningSpeed(float speed);

    /**
     * 获取每次破坏方块时从工具中移除的耐久度。
     * <p>原文：Get the amount of durability to be removed from the tool each time a block is broken.
     *
     * @return 每个方块的伤害值
     */
    int getDamagePerBlock();

    /**
     * 设置每次破坏方块时从工具中移除的耐久度。
     * <p>原文：Set the amount of durability to be removed from the tool each time a block is broken.
     *
     * @param damage 要设置的伤害值。必须为0或正整数
     */
    void setDamagePerBlock(int damage);

    /**
     * 获取此工具是否可以在创造模式下破坏方块。
     * <p>原文：Get whether this tool can destroy blocks in creative.
     *
     * @return 是否可以破坏
     */
    boolean canDestroyBlocksInCreative();

    /**
     * 设置此工具是否可以在创造模式下破坏方块。
     * <p>原文：Set whether this tool can destroy blocks in creative.
     *
     * @param destroy 是否可以破坏
     */
    void setCanDestroyBlocksInCreative(boolean destroy);

    /**
     * 获取适用于此工具的 {@link ToolRule ToolRules} 列表。
     * <p>原文：Get the list of {@link ToolRule ToolRules} that apply to this tool.
     *
     * @return 所有工具规则。返回列表的可变性无法保证，但其内容是可变的，可以更改其值
     */
    @NotNull
    List<ToolRule> getRules();

    /**
     * 设置适用于此工具的 {@link ToolRule ToolRules} 列表。这将移除所有现有的工具规则。
     * <p>原文：Set the list of {@link ToolRule ToolRules} to apply to this tool. This will remove any existing tool rules.
     *
     * @param rules 要设置的规则
     */
    void setRules(@NotNull List<ToolRule> rules);

    /**
     * 向此工具组件添加新规则，提供关于特定方块类型的进一步信息。
     * <p>原文：Add a new rule to this tool component, which provides further information about a specific block type.
     *
     * @param block 规则适用的方块类型
     * @param speed 挖掘该方块时使用的挖掘速度，或null使用默认挖掘速度
     * @param correctForDrops 此工具在挖掘该方块时是否被视为该方块的最佳工具，并在破坏时掉落物品，或null使用Minecraft定义的默认工具检查行为
     * @return 添加到此工具的 {@link ToolRule} 实例
     */
    @NotNull
    ToolRule addRule(@NotNull Material block, @Nullable Float speed, @Nullable Boolean correctForDrops);

    /**
     * 向此工具组件添加新规则，提供关于一组方块类型的进一步信息。
     * <p>原文：Add a new rule to this tool component, which provides further information about a collection of block types.
     *
     * @param blocks 规则适用的方块类型
     * @param speed 挖掘其中一个方块时使用的挖掘速度，或null使用默认挖掘速度
     * @param correctForDrops 此工具在挖掘其中一个方块时是否被视为该方块的最佳工具，并在破坏时掉落物品，或null使用Minecraft定义的默认工具检查行为
     * @return 添加到此工具的 {@link ToolRule} 实例
     */
    @NotNull
    ToolRule addRule(@NotNull Collection<Material> blocks, @Nullable Float speed, @Nullable Boolean correctForDrops);

    /**
     * 向此工具组件添加新规则，提供关于由方块 {@link Tag} 表示的一组方块类型的进一步信息。
     * <p>原文：Add a new rule to this tool component, which provides further information about a collection of block types represented by a block {@link Tag}.
     *
     * @param tag 包含规则适用方块类型的方块标签
     * @param speed 挖掘其中一个方块时使用的挖掘速度，或null使用默认挖掘速度
     * @param correctForDrops 此工具在挖掘其中一个方块时是否被视为该方块的最佳工具，并在破坏时掉落物品，或null使用Minecraft定义的默认工具检查行为
     * @return 添加到此工具的 {@link ToolRule} 实例
     * @throws IllegalArgumentException 如果传入的 {@code tag} 不是方块标签
     */
    @NotNull
    ToolRule addRule(@NotNull Tag<Material> tag, @Nullable Float speed, @Nullable Boolean correctForDrops);

    /**
     * 从此工具中移除给定的 {@link ToolRule}。
     * <p>原文：Remove the given {@link ToolRule} from this tool.
     *
     * @param rule 要移除的规则
     * @return 如果规则被移除则返回true，如果此组件不包含匹配的规则则返回false
     */
    boolean removeRule(@NotNull ToolRule rule);

    /**
     * 管理此工具使用并覆盖每个方块属性的规则。
     */
    public interface ToolRule extends ConfigurationSerializable {

        /**
         * 获取此工具规则适用的方块类型集合。
         * <p>原文：Get a collection of the block types to which this tool rule applies.
         *
         * @return 方块集合
         */
        @NotNull
        Collection<Material> getBlocks();

        /**
         * 设置此规则适用的方块类型。
         * <p>原文：Set the block type to which this rule applies.
         *
         * @param block 方块类型
         */
        void setBlocks(@NotNull Material block);

        /**
         * 设置此规则适用的方块类型。
         * <p>原文：Set the block types to which this rule applies.
         *
         * @param blocks 方块类型
         */
        void setBlocks(@NotNull Collection<Material> blocks);

        /**
         * 设置此规则适用的方块类型（表示为方块 {@link Tag}）。
         * <p>原文：Set the block types (represented as a block {@link Tag}) to which this rule applies.
         *
         * @param tag 方块标签
         * @throws IllegalArgumentException 如果传入的 {@code tag} 不是方块标签
         */
        void setBlocks(@NotNull Tag<Material> tag);

        /**
         * 获取此规则的挖掘速度。如果非空，则使用此速度值代替工具的默认速度值。1.0为标准挖掘速度。
         * <p>原文：Get the mining speed of this rule. If non-null, this speed value is used in lieu of the default speed value of the tool. 1.0 is standard mining speed.
         *
         * @return 挖掘速度，如果使用默认速度则返回null
         */
        @Nullable
        Float getSpeed();

        /**
         * 设置此规则的挖掘速度。1.0为标准挖掘速度。
         * <p>原文：Set the mining speed of this rule. 1.0 is standard mining speed.
         *
         * @param speed 挖掘速度，或null使用默认速度
         */
        void setSpeed(@Nullable Float speed);

        /**
         * 获取此规则是否被视为此规则所列方块的最佳工具并会掉落物品。如果非空，则使用此值代替Minecraft定义的默认工具检查行为。
         * <p>原文：Get whether or not this rule is considered the optimal tool for the blocks listed by this rule and will drop items. If non-null, this value is used in lieu of the default tool checking behavior defined by Minecraft.
         *
         * @return 如果适合掉落则返回true，否则返回false，或null以回退到原版工具检查行为
         */
        @Nullable
        Boolean isCorrectForDrops();

        /**
         * 设置此规则是否被视为此规则所列方块的最佳工具并会掉落物品。
         * <p>原文：Set whether or not this rule is considered the optimal tool for the blocks listed by this rule and will drop items.
         *
         * @param correct 此规则是否适合掉落，或null以回退到原版工具检查行为
         */
        void setCorrectForDrops(@Nullable Boolean correct);
    }
}
