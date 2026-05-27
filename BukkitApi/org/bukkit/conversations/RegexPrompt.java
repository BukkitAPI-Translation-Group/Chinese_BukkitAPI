package org.bukkit.conversations;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/**
 * RegexPrompt 是任何需要通过正则表达式验证输入的提示的基类。
 */
public abstract class RegexPrompt extends ValidatingPrompt {

    private Pattern pattern;

    public RegexPrompt(@NotNull String regex) {
        this(Pattern.compile(regex));
    }

    public RegexPrompt(@NotNull Pattern pattern) {
        super();
        this.pattern = pattern;
    }

    private RegexPrompt() {}

    @Override
    protected boolean isInputValid(@NotNull ConversationContext context, @NotNull String input) {
        return pattern.matcher(input).matches();
    }
}
