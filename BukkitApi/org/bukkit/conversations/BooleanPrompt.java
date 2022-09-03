package org.bukkit.conversations;

import com.google.common.collect.ImmutableSet;
import java.util.Locale;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * BooleanPrompt是那些需要用户判断操作是与否的提示的基类.
 */
public abstract class BooleanPrompt extends ValidatingPrompt {

    private static final Set<String> TRUE_INPUTS = ImmutableSet.of("true", "on", "yes", "y", "1", "right", "correct", "valid");
    private static final Set<String> FALSE_INPUTS = ImmutableSet.of("false", "off", "no", "n", "0", "wrong", "incorrect", "invalid");
    private static final Set<String> VALID_INPUTS = ImmutableSet.<String>builder().addAll(TRUE_INPUTS).addAll(FALSE_INPUTS).build();

    public BooleanPrompt() {
        super();
    }

    @Override
    protected boolean isInputValid(@NotNull ConversationContext context, @NotNull String input) {
        return VALID_INPUTS.contains(input.toLowerCase(Locale.ROOT));
    }

    @Nullable
    @Override
    protected Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull String input) {
        return acceptValidatedInput(context, TRUE_INPUTS.contains(input.toLowerCase(Locale.ROOT)));
    }

    /**
     * 您可以重写这个方法，根据用户对提示的响应来执行对应的操作.
     * <p>
     * 原文:Override this method to perform some action with the user's boolean
     * response.
     *
     * @param context 关于这个会话的Context 信息
     * @param input 用户响应的布尔值(true/false)
     * @return 对话流程中的下一个 {@link Prompt}
     */
    @Nullable
    protected abstract Prompt acceptValidatedInput(@NotNull ConversationContext context, boolean input);
}
