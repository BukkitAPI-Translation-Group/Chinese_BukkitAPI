package org.bukkit.conversations;

import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * FixedSetPrompt 是任何需要用户从固定集合中响应的提示的基类。
 */
public abstract class FixedSetPrompt extends ValidatingPrompt {

    protected List<String> fixedSet;

    /**
     * 从一组字符串创建一个 FixedSetPrompt。
     * <p>
     * foo = new FixedSetPrompt("bar", "cheese", "panda");
     * <p>
     * 原文：
     * Creates a FixedSetPrompt from a set of strings.
     * <p>
     * foo = new FixedSetPrompt("bar", "cheese", "panda");
     *
     * @param fixedSet 一组固定的字符串，用户必须输入其中之一。
     */
    public FixedSetPrompt(@NotNull String... fixedSet) {
        super();
        this.fixedSet = Arrays.asList(fixedSet);
    }

    private FixedSetPrompt() {}

    @Override
    protected boolean isInputValid(@NotNull ConversationContext context, @NotNull String input) {
        return fixedSet.contains(input);
    }

    /**
     * 创建一个包含构造函数中声明的所有选项的格式化字符串的实用函数。
     * <p>
     * 原文：
     * Utility function to create a formatted string containing all the
     * options declared in the constructor.
     *
     * @return 格式化的选项，如 "[bar, cheese, panda]"（如果 bar、cheese 和 panda 是使用的选项）。
     */
    @NotNull
    protected String formatFixedSet() {
        return "[" + Joiner.on(", ").join(fixedSet) + "]";
    }
}
