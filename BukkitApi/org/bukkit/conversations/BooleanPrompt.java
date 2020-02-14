package org.bukkit.conversations;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.BooleanUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * BooleanPrompt是那些需要用户判断操作是与否的提示的基类.
 */
public abstract class BooleanPrompt extends ValidatingPrompt {

    public BooleanPrompt() {
        super();
    }

    @Override
    protected boolean isInputValid(@NotNull ConversationContext context, @NotNull String input) {
        String[] accepted = {/* Apache values: */"true", "false", "on", "off", "yes", "no",/* Additional values: */ "y", "n", "1", "0", "right", "wrong", "correct", "incorrect", "valid", "invalid"};
        return ArrayUtils.contains(accepted, input.toLowerCase());
    }

    @Nullable
    @Override
    protected Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull String input) {
        if (input.equalsIgnoreCase("y") || input.equals("1") || input.equalsIgnoreCase("right") || input.equalsIgnoreCase("correct") || input.equalsIgnoreCase("valid")) input = "true";
        return acceptValidatedInput(context, BooleanUtils.toBoolean(input));
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
