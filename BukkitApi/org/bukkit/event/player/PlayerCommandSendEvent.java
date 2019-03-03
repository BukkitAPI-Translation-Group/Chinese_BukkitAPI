package org.bukkit.event.player;

import java.util.Collection;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * 当服务器可用命令列表发送给玩家时触发本事件.
 * <br>
 * 可以通过此事件来移除你不希望向玩家展示的某些命令,
 * 但无需通过实现删除所有命令痕迹(?).
 * 如果需要移除列表中的某些命令,可以给那些命令赋予一定的权限,
 * 如果某个玩家没有命令需要的权限
 * 那么他将无法通过Tab补全查到那个需要权限的命令.
 * <p>
 * 原文:
 * This event is called when the list of available server commands is sent to
 * the player.
 * <br>
 * Commands may be removed from display using this event, but implementations
 * are not required to securely remove all traces of the command. If secure
 * removal of commands is required, then the command should be assigned a
 * permission which is not granted to the player.
 * @since Bukkit 1.13
 */
public class PlayerCommandSendEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Collection<String> commands;

    public PlayerCommandSendEvent(final Player player, final Collection<String> commands) {
        super(player);
        this.commands = commands;
    }

    /**
     * 返回将发送给客户端的所有顶级命令的可变集合.
     * <br>
     * 向此集合添加条目是非法的, 你只能移除集合内的条目.
     * 向此集合添加条目的行为是未定义的, 建议不要尝试.
     * <p>
     * 原文:Returns a mutable collection of all top level commands to be sent.
     * <br>
     * It is not legal to add entries to this collection, only remove them.
     * Behaviour of adding entries is undefined.
     *
     * @return 所有命令的集合
     */
    public Collection<String> getCommands() {
        return commands;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
