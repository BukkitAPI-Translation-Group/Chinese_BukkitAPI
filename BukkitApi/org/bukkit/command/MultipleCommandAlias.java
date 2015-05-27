package org.bukkit.command;

/**
 * 代表一个或多个命令
 */
public class MultipleCommandAlias extends Command {
    private Command[] commands;

    public MultipleCommandAlias(String name, Command[] commands) {
        super(name);
        this.commands = commands;
    }

    /**
     * 获取与多命令别名相关的命令.
     * <p>
     * 原文:
     * Gets the commands associated with the multi-command alias.
     *
     * @return 相关的别名命令
     */
    public Command[] getCommands() {
        return commands;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        boolean result = false;

        for (Command command : commands) {
            result |= command.execute(sender, commandLabel, args);
        }

        return result;
    }
}
