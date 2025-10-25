package org.bukkit.ban;

import java.net.InetAddress;
import org.bukkit.BanList;

/**
 * 针对 IP 封禁的 {@link BanList}.
 * <p>
 * 原文:
 * A {@link BanList} targeting IP bans.
 */
public interface IpBanList extends BanList<InetAddress> {

}
