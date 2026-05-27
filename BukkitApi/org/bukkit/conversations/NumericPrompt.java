package org.bukkit.conversations;

import org.apache.commons.lang3.math.NumberUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * NumericPrompt 是任何需要用户 {@link Number} 响应的提示的基类。
 */
public abstract class NumericPrompt extends ValidatingPrompt {
    public NumericPrompt() {
        super();
    }

    @Override
    protected boolean isInputValid(@NotNull ConversationContext context, @NotNull String input) {
        return NumberUtils.isNumber(input) && isNumberValid(context, NumberUtils.createNumber(input));
    }

    /**
     * 覆盖此方法以在输入被确定为数字后对数字玩家输入进行进一步验证。
     * <p>
     * 原文：
     * Override this method to do further validation on the numeric player
     * input after the input has been determined to actually be a number.
     *
     * @param context 关于对话的上下文信息。
     * @param input 玩家提供的数字。
     * @return 玩家输入的有效性。
     */
    protected boolean isNumberValid(@NotNull ConversationContext context, @NotNull Number input) {
        return true;
    }

    @Nullable
    @Override
    protected Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull String input) {
        try {
            return acceptValidatedInput(context, NumberUtils.createNumber(input));
        } catch (NumberFormatException e) {
            return acceptValidatedInput(context, NumberUtils.INTEGER_ZERO);
        }
    }

    /**
     * 覆盖此方法以对用户的整数响应执行某些操作。
     * <p>
     * 原文：
     * Override this method to perform some action with the user's integer
     * response.
     *
     * @param context 关于对话的上下文信息。
     * @param input 用户的响应作为 {@link Number}。
     * @return 提示图中的下一个 {@link Prompt}。
     */
    @Nullable
    protected abstract Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull Number input);

    @Nullable
    @Override
    protected String getFailedValidationText(@NotNull ConversationContext context, @NotNull String invalidInput) {
        if (NumberUtils.isNumber(invalidInput)) {
            return getFailedValidationText(context, NumberUtils.createNumber(invalidInput));
        } else {
            return getInputNotNumericText(context, invalidInput);
        }
    }

    /**
     * 可选择覆盖此方法以在用户输入无效数字时显示额外消息。
     * <p>
     * 原文：
     * Optionally override this method to display an additional message if the
     * user enters an invalid number.
     *
     * @param context 关于对话的上下文信息。
     * @param invalidInput 用户提供的无效输入。
     * @return 解释如何纠正输入的消息。
     */
    @Nullable
    protected String getInputNotNumericText(@NotNull ConversationContext context, @NotNull String invalidInput) {
        return null;
    }

    /**
     * 可选择覆盖此方法以在用户输入无效数字输入时显示额外消息。
     * <p>
     * 原文：
     * Optionally override this method to display an additional message if the
     * user enters an invalid numeric input.
     *
     * @param context 关于对话的上下文信息。
     * @param invalidInput 用户提供的无效输入。
     * @return 解释如何纠正输入的消息。
     */
    @Nullable
    protected String getFailedValidationText(@NotNull ConversationContext context, @NotNull Number invalidInput) {
        return null;
    }
}
