package org.bukkit.event.world;

import java.util.List;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当传送门被创建时调用.
 */
public class PortalCreateEvent extends WorldEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final List<BlockState> blocks;
    private final Entity entity;
    private final CreateReason reason;

    @Deprecated
    public PortalCreateEvent(@NotNull final List<BlockState> blocks, @NotNull final World world, @NotNull CreateReason reason) {
        this(blocks, world, null, reason);
    }

    public PortalCreateEvent(@NotNull final List<BlockState> blocks, @NotNull final World world, @Nullable Entity entity, @NotNull CreateReason reason) {
        super(world);

        this.blocks = blocks;
        this.entity = entity;
        this.reason = reason;
    }

    /**
     * 获取与创建的传送门相关联的所有组成方块的数组列表.
     * <p>
     * 原文:
     * Gets an array list of all the blocks associated with the created portal
     *
     * @return 与创建的门相关联的所有方块的数组列表
     */
    @NotNull
    public List<BlockState> getBlocks() {
        return this.blocks;
    }

    /**
     * 返回导致此传送门创建的实体 (若存在).
     * <p>
     * 原文:
     * Returns the Entity that triggered this portal creation (if available)
     *
     * @return 与此事件有关的实体
     */
    @Nullable
    public Entity getEntity() {
        return entity;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 获取这个传送门的创建理由.
     * <p>
     * 原文:
     * Gets the reason for the portal's creation
     *
     * @return 传送门创建的CreateReason对象
     */
    @NotNull
    public CreateReason getReason() {
        return reason;
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

    /**
     * 指定传送门创建的各种原因的一个枚举
     */
    public enum CreateReason {
        /**
         * 传送门被火点燃时.
         */
        FIRE,
        /**
         * 在地狱创建通往主世界的地狱出口传送门时.
         */
        NETHER_PAIR,
        /**
         * 玩家进入末地传送门, 生成落脚平台时.
         */
        END_PLATFORM
    }
}
