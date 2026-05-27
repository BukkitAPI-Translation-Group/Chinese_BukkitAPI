package org.bukkit.event.player;

import com.google.gson.JsonElement;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当玩家从聊天事件或表单提交中运行自定义操作后触发.
 */
@ApiStatus.Experimental
public class PlayerCustomClickEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    @NotNull
    private final NamespacedKey id;
    @Nullable
    private final JsonElement data;

    public PlayerCustomClickEvent(@NotNull Player player, @NotNull NamespacedKey id, @Nullable JsonElement data) {
        super(player);
        this.id = id;
        this.data = data;
    }

    /**
     * 获取自定义操作的 ID.
     * <p>
     * 原文：
     * Gets the ID of the custom action.
     *
     * @return 自定义操作 ID
     */
    @NotNull
    public NamespacedKey getId() {
        return id;
    }

    /**
     * 获取自定义操作的数据作为 {@link JsonElement}，如果不可用则返回 null.
     * <p>
     * 原文：
     * Gets the data of the custom action as a {@link JsonElement}, or null if
     * not available.
     * <br>
     * If not a form submission, then may be null.
     *
     * @return 数据作为 JSON 或 null
     */
    @Nullable
    public JsonElement getData() {
        return data;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
