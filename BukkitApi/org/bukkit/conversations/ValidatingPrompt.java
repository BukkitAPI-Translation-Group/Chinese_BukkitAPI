package org.bukkit.conversations;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * ValidatingPrompt 是任何需要验证的提示的基类。ValidatingPrompt 将不断重放提示文本，直到用户输入有效的响应。
 */
public abstract class ValidatingPrompt implements Prompt {
    public ValidatingPrompt() {
        super();
    }

    /**
     * 接受并处理来自用户的输入并进行验证。如果验证失败，返回此提示以重新执行，否则返回提示图中的下一个 Prompt。
     * <p>
     * 原文：
     * Accepts and processes input from the user and validates it. If
     * validation fails, this prompt is returned for re-execution, otherwise
     * the next Prompt in the prompt graph is returned.
     *
     * @param context 关于对话的上下文信息。
     * @param input 来自用户的输入文本。
     * @return 此提示或提示图中的下一个 Prompt。
     */
    @Override
    @Nullable
    public Prompt acceptInput(@NotNull ConversationContext context, @Nullable String input) {
        if (isInputValid(context, input)) {
            return acceptValidatedInput(context, input);
        } else {
            String failPrompt = getFailedValidationText(context, input);
            if (failPrompt != null) {
                context.getForWhom().sendRawMessage(ChatColor.RED + failPrompt);
            }
            // Redisplay this prompt to the user to re-collect input
            return this;
        }
    }

    /**
     * 确保提示等待用户提供输入。
     * <p>
     * 原文：
     * Ensures that the prompt waits for the user to provide input.
     *
     * @param context 关于对话的上下文信息。
     * @return True。
     */
    @Override
    public boolean blocksForInput(@NotNull ConversationContext context) {
        return true;
    }

    /**
     * 覆盖此方法以检查玩家输入的有效性。
     * <p>
     * 原文：
     * Override this method to check the validity of the player's input.
     *
     * @param context 关于对话的上下文信息。
     * @param input 玩家的原始控制台输入。
     * @return 根据输入的有效性返回 true 或 false。
     */
    protected abstract boolean isInputValid(@NotNull ConversationContext context, @NotNull String input);

    /**
     * 覆盖此方法以接受并处理来自用户的验证输入。使用输入，应返回提示图中的下一个 Prompt。
     * <p>
     * 原文：
     * Override this method to accept and processes the validated input from
     * the user. Using the input, the next Prompt in the prompt graph should
     * be returned.
     *
     * @param context 关于对话的上下文信息。
     * @param input 来自用户的验证输入文本。
     * @return 提示图中的下一个 Prompt。
     */
    @Nullable
    protected abstract Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull String input);

    /**
     * 可选择覆盖此方法以在用户输入无效输入时显示额外消息。
     * <p>
     * 原文：
     * Optionally override this method to display an additional message if the
     * user enters an invalid input.
     *
     * @param context 关于对话的上下文信息。
     * @param invalidInput 用户提供的无效输入。
     * @return 解释如何纠正输入的消息。
     */
    @Nullable
    protected String getFailedValidationText(@NotNull ConversationContext context, @NotNull String invalidInput) {
        return null;
    }
}
