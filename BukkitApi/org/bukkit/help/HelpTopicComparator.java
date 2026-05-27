package org.bukkit.help;

import java.util.Comparator;
import org.jetbrains.annotations.NotNull;

/**
 * 用于对帮助主题施加自定义全序排列.
 * <p>
 * 所有主题按字母顺序排列, 但以斜杠开头的主题排在不以斜杠开头的主题之后.
 */
public final class HelpTopicComparator implements Comparator<HelpTopic> {

    // Singleton implementations
    private static final TopicNameComparator tnc = new TopicNameComparator();
    @NotNull
    public static TopicNameComparator topicNameComparatorInstance() {
        return tnc;
    }

    private static final HelpTopicComparator htc = new HelpTopicComparator();
    @NotNull
    public static HelpTopicComparator helpTopicComparatorInstance() {
        return htc;
    }

    private HelpTopicComparator() {}

    @Override
    public int compare(@NotNull HelpTopic lhs, @NotNull HelpTopic rhs) {
        return tnc.compare(lhs.getName(), rhs.getName());
    }

    public static final class TopicNameComparator implements Comparator<String> {
        private TopicNameComparator() {}

        @Override
        public int compare(@NotNull String lhs, @NotNull String rhs) {
            boolean lhsStartSlash = lhs.startsWith("/");
            boolean rhsStartSlash = rhs.startsWith("/");

            if (lhsStartSlash && !rhsStartSlash) {
                return 1;
            } else if (!lhsStartSlash && rhsStartSlash) {
                return -1;
            } else {
                return lhs.compareToIgnoreCase(rhs);
            }
        }
    }
}
