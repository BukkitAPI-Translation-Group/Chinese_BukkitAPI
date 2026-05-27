package org.bukkit.help;

import com.google.common.base.Joiner;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * 缺少替代方案时, 帮助系统将为服务器CommandMap中的每个命令创建GenericCommandHelpTopic实例.
 * 你可以将此类用作自定义帮助主题的基类, 或作为编写自己实现的示例.
 */
public class GenericCommandHelpTopic extends HelpTopic {

    protected Command command;

    public GenericCommandHelpTopic(@NotNull Command command) {
        this.command = command;

        if (command.getLabel().startsWith("/")) {
            name = command.getLabel();
        } else {
            name = "/" + command.getLabel();
        }

        // The short text is the first line of the description
        int i = command.getDescription().indexOf('\n');
        if (i > 1) {
            shortText = command.getDescription().substring(0, i - 1);
        } else {
            shortText = command.getDescription();
        }

        // Build full text
        StringBuilder sb = new StringBuilder();

        sb.append(ChatColor.GOLD);
        sb.append("Description: ");
        sb.append(ChatColor.WHITE);
        sb.append(command.getDescription());

        sb.append("\n");

        sb.append(ChatColor.GOLD);
        sb.append("Usage: ");
        sb.append(ChatColor.WHITE);
        sb.append(command.getUsage().replace("<command>", name.substring(1)));

        if (command.getAliases().size() > 0) {
            sb.append("\n");
            sb.append(ChatColor.GOLD);
            sb.append("Aliases: ");
            sb.append(ChatColor.WHITE);
            sb.append(Joiner.on(", ").join(command.getAliases()));
        }
        fullText = sb.toString();
    }

    @Override
    public boolean canSee(@NotNull CommandSender sender) {
        if (!command.isRegistered()) {
            // Unregistered commands should not show up in the help
            return false;
        }

        if (sender instanceof ConsoleCommandSender) {
            return true;
        }

        if (amendedPermission != null) {
            return sender.hasPermission(amendedPermission);
        } else {
            return command.testPermissionSilent(sender);
        }
    }
}
