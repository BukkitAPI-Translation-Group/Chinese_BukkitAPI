package org.bukkit.help;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * HelpTopic实现在用户使用/help命令时显示给用户.
 * <p>
 * 此类的自定义实现可以在两个层面上工作.
 * 简单实现只需要在构造函数中设置{@code name}、{@code shortText}和{@code fullText}的值. 此基类将处理其余部分.
 * <p>
 * 复杂实现可以通过覆盖此类中所有方法的行为来创建.
 */
public abstract class HelpTopic {
    protected String name = "";
    protected String shortText = "";
    protected String fullText = "";
    protected String amendedPermission = null;

    /**
     * 确定{@link Player}是否被允许查看此帮助主题.
     * <p>
     * HelpTopic实现在确定主题可见性时应考虑服务器管理员通过{@link HelpTopic#amendCanSee(String)}函数设置的意愿.
     * <p>
     * 原文：
     * Determines if a {@link Player} is allowed to see this help topic.
     * <p>
     * HelpTopic implementations should take server administrator wishes into
     * account as set by the {@link HelpTopic#amendCanSee(String)} function.
     *
     * @param player 相关的Player.
     * @return 如果Player可以看到此帮助主题则为True, 否则为false.
     */
    public abstract boolean canSee(@NotNull CommandSender player);

    /**
     * 允许服务器管理员覆盖查看帮助主题所需的权限.
     * <p>
     * HelpTopic实现在{@link HelpTopic#canSee(org.bukkit.command.CommandSender)}函数中确定主题可见性时应考虑这一点.
     * <p>
     * 原文：
     * Allows the server administrator to override the permission required to
     * see a help topic.
     * <p>
     * HelpTopic implementations should take this into account when
     * determining topic visibility on the {@link
     * HelpTopic#canSee(org.bukkit.command.CommandSender)} function.
     *
     * @param amendedPermission 服务器管理员希望应用于此主题的权限节点.
     */
    public void amendCanSee(@Nullable String amendedPermission) {
        this.amendedPermission = amendedPermission;
    }

    /**
     * 返回此帮助主题的名称.
     * <p>
     * 原文：
     * Returns the name of this help topic.
     *
     * @return 主题名称.
     */
    @NotNull
    public String getName() {
        return name;
    }

    /**
     * 返回将在主题索引中显示的简要描述.
     * <p>
     * 原文：
     * Returns a brief description that will be displayed in the topic index.
     *
     * @return 简要的主题描述.
     */
    @NotNull
    public String getShortText() {
        return shortText;
    }

    /**
     * 返回当用户请求此主题详情时显示的完整帮助主题描述.
     * <p>
     * 结果将被分页以适当适应用户的客户端.
     * <p>
     * 原文：
     * Returns the full description of this help topic that is displayed when
     * the user requests this topic's details.
     * <p>
     * The result will be paginated to properly fit the user's client.
     *
     * @param forWho 请求完整文本的玩家或控制台. 对于在自定义实现中基于子权限进一步安全裁剪命令完整文本很有用.
     *
     * @return 完整的主题描述.
     */
    @NotNull
    public String getFullText(@NotNull CommandSender forWho) {
        return fullText;
    }

    /**
     * 允许服务器管理员(或另一个插件)添加或替换帮助主题的内容.
     * <p>
     * 任一参数为null将保留该部分主题不变. 在任一修改参数中, 字符串{@literal <text>}将被替换为帮助主题中的现有内容.
     * 使用此方法可以将额外内容追加或预置到自动生成的帮助主题中.
     * <p>
     * 原文：
     * Allows the server admin (or another plugin) to add or replace the
     * contents of a help topic.
     * <p>
     * A null in either parameter will leave that part of the topic unchanged.
     * In either amending parameter, the string {@literal <text>} is replaced
     * with the existing contents in the help topic. Use this to append or
     * prepend additional content into an automatically generated help topic.
     *
     * @param amendedShortText 要使用的新主题短文本, 或null保持不变.
     * @param amendedFullText 要使用的新主题完整文本, 或null保持不变.
     */
    public void amendTopic(@Nullable String amendedShortText, @Nullable String amendedFullText) {
        shortText = applyAmendment(shortText, amendedShortText);
        fullText = applyAmendment(fullText, amendedFullText);
    }

    /**
     * 实现自定义HelpTopic的开发者可以使用此工具方法来确保其实现符合{@link HelpTopic#amendTopic(String, String)}方法的预期行为.
     * <p>
     * 原文：
     * Developers implementing their own custom HelpTopic implementations can
     * use this utility method to ensure their implementations comply with the
     * expected behavior of the {@link HelpTopic#amendTopic(String, String)}
     * method.
     *
     * @param baseText 帮助主题的现有文本.
     * @param amendment 来自amendTopic()方法的修改文本.
     * @return 根据amendTopic()的预期规则将修改文本应用于现有文本的结果.
     */
    @NotNull
    protected String applyAmendment(@NotNull String baseText, @Nullable String amendment) {
        if (amendment == null) {
            return baseText;
        } else {
            return amendment.replaceAll("<text>", baseText);
        }
    }
}
