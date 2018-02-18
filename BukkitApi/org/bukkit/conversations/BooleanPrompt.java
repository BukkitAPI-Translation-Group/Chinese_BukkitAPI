package org.bukkit.conversations;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.BooleanUtils;

/**
 * BooleanPrompt是那些需要用户判断操作是与否的提示的基类.
 */
public abstract class BooleanPrompt extends ValidatingPrompt {

    public BooleanPrompt() {
        super();
    }

    @Override
    protected boolean isInputValid(ConversationContext context, String input) {
        String[] accepted = {"true", "false", "on", "off", "yes", "no"};
        return ArrayUtils.contains(accepted, input.toLowerCase());
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext context, String input) {
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
    protected abstract Prompt acceptValidatedInput(ConversationContext context, boolean input);
}
