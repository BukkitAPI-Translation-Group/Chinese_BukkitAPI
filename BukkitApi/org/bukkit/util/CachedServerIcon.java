package org.bukkit.util;

import org.bukkit.Server;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * 这表示一个缓存版的服务器图标。这只是内部表示，还未实现。
 * <p>
 * 原文：This is a cached version of a server-icon. It's internal representation
 * and implementation is undefined.
 *
 * @see Server#getServerIcon()
 * @see Server#loadServerIcon(java.awt.image.BufferedImage)
 * @see Server#loadServerIcon(java.io.File)
 * @see ServerListPingEvent#setServerIcon(CachedServerIcon)
 */
public interface CachedServerIcon {}