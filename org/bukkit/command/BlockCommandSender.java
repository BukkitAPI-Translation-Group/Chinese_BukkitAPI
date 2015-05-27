package org.bukkit.command;

import org.bukkit.block.Block;

public interface BlockCommandSender extends CommandSender {

    /**
     * 返回属于阻止的命令发送者.
     * <p>
     * 原文:
     * Returns the block this command sender belongs to
     *
     * @return 阻止的命令发送者
     */
    public Block getBlock();
}
