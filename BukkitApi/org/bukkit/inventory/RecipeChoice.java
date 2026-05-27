package org.bukkit.inventory;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;

/**
 * 代表配方中的一个潜在物品匹配项。配方中的所有选择条件都必须满足才能进行合成。选择不能为空或空气。
 *
 * <b>此类不允许插件实现！</b>
 */
public interface RecipeChoice extends Predicate<ItemStack>, Cloneable {

/**
 * 获取此物品栈选择的单个代表性物品栈。
 *
 * @return 单个代表性物品。
 * @deprecated 仅为兼容性保留。
 * <p>原文：Gets a single item stack representative of this stack choice.
 */
    @Deprecated(since = "1.13.1")
    @NotNull
    ItemStack getItemStack();

    @NotNull
    RecipeChoice clone();

    @Override
    boolean test(@NotNull ItemStack itemStack);

/**
 * 代表多个匹配材料的选择。
 */
    public static class MaterialChoice implements RecipeChoice {

        private List<Material> choices;

        public MaterialChoice(@NotNull Material choice) {
            this(Arrays.asList(choice));
        }

        public MaterialChoice(@NotNull Material... choices) {
            this(Arrays.asList(choices));
        }

/**
 * 使用指定标签的当前值构造一个 MaterialChoice。
 *
 * @param choices 标签。
 * <p>原文：Constructs a MaterialChoice with the current values of the specified tag.
 */
        public MaterialChoice(@NotNull Tag<Material> choices) {
            Preconditions.checkArgument(choices != null, "choices");
            this.choices = new ArrayList<>(choices.getValues());
        }

        public MaterialChoice(@NotNull List<Material> choices) {
            Preconditions.checkArgument(choices != null, "choices");
            Preconditions.checkArgument(!choices.isEmpty(), "Must have at least one choice");

            this.choices = new ArrayList<>(choices.size());

            for (Material choice : choices) {
                Preconditions.checkArgument(choice != null, "Cannot have null choice");

                if (choice.isLegacy()) {
                    choice = Bukkit.getUnsafe().fromLegacy(new MaterialData(choice, (byte) 0), true);
                }

                Preconditions.checkArgument(!choice.isAir(), "Cannot have empty/air choice");
                this.choices.add(choice);
            }
        }

        @Override
        public boolean test(@NotNull ItemStack t) {
            for (Material match : choices) {
                if (t.getType() == match) {
                    return true;
                }
            }

            return false;
        }

        @NotNull
        @Override
        public ItemStack getItemStack() {
            ItemStack stack = new ItemStack(choices.get(0));

            // For compat
            if (choices.size() > 1) {
                stack.setDurability(Short.MAX_VALUE);
            }

            return stack;
        }

        @NotNull
        public List<Material> getChoices() {
            return Collections.unmodifiableList(choices);
        }

        @NotNull
        @Override
        public MaterialChoice clone() {
            try {
                MaterialChoice clone = (MaterialChoice) super.clone();
                clone.choices = new ArrayList<>(choices);
                return clone;
            } catch (CloneNotSupportedException ex) {
                throw new AssertionError(ex);
            }
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 37 * hash + Objects.hashCode(this.choices);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final MaterialChoice other = (MaterialChoice) obj;
            if (!Objects.equals(this.choices, other.choices)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "MaterialChoice{" + "choices=" + choices + '}';
        }
    }

/**
 * 代表一种选择，仅当其中一个物品栈完全匹配（除了栈大小）时才有效。
 * <br>
 * <b>仅对有序配方有效</b>
 */
    public static class ExactChoice implements RecipeChoice {

        private List<ItemStack> choices;

        public ExactChoice(@NotNull ItemStack stack) {
            this(Arrays.asList(stack));
        }

        public ExactChoice(@NotNull ItemStack... stacks) {
            this(Arrays.asList(stacks));
        }

        public ExactChoice(@NotNull List<ItemStack> choices) {
            Preconditions.checkArgument(choices != null, "choices");
            Preconditions.checkArgument(!choices.isEmpty(), "Must have at least one choice");
            for (ItemStack choice : choices) {
                Preconditions.checkArgument(choice != null, "Cannot have null choice");
                Preconditions.checkArgument(!choice.getType().isAir(), "Cannot have empty/air choice");
            }

            this.choices = new ArrayList<>(choices);
        }

        @NotNull
        @Override
        public ItemStack getItemStack() {
            return choices.get(0).clone();
        }

        @NotNull
        public List<ItemStack> getChoices() {
            return Collections.unmodifiableList(choices);
        }

        @NotNull
        @Override
        public ExactChoice clone() {
            try {
                ExactChoice clone = (ExactChoice) super.clone();
                clone.choices = new ArrayList<>(choices);
                return clone;
            } catch (CloneNotSupportedException ex) {
                throw new AssertionError(ex);
            }
        }

        @Override
        public boolean test(@NotNull ItemStack t) {
            for (ItemStack match : choices) {
                if (t.isSimilar(match)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 41 * hash + Objects.hashCode(this.choices);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ExactChoice other = (ExactChoice) obj;
            if (!Objects.equals(this.choices, other.choices)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "ExactChoice{" + "choices=" + choices + '}';
        }
    }
}