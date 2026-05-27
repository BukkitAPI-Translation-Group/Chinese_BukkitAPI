package org.bukkit.event.block;

import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 当钟被敲响后共鸣并高亮附近袭击者时触发.
 * 只有当袭击者在钟附近时钟才会共鸣.
 */
public class BellResonateEvent extends BlockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final List<LivingEntity> resonatedEntities;

    public BellResonateEvent(@NotNull Block theBlock, @NotNull List<LivingEntity> resonatedEntities) {
        super(theBlock);
        this.resonatedEntities = resonatedEntities;
    }

    /**
     * 获取一个可变列表，包含所有将被钟共鸣高亮的 {@link LivingEntity LivingEntities}.
     * 可以通过添加或移除实体来改变被高亮的实体列表，如果此事件没有共鸣任何实体，则可能为空.
     * <p>
     * 虽然被高亮的实体会改变，但共鸣实体上方显示的粒子及其颜色不会改变.
     * 这由客户端处理，服务器无法控制.
     *
     * 原文：
     * Get a mutable list of all {@link LivingEntity LivingEntities} to be
     * highlighted by the bell's resonating. This list can be added to or
     * removed from to change which entities are highlighted, and may be empty
     * if no entities were resonated as a result of this event.
     * <p>
     * While the highlighted entities will change, the particles that display
     * over a resonated entity and their colors will not. This is handled by the
     * client and cannot be controlled by the server.
     *
     * @return 共鸣的实体列表
     */
    @NotNull
    public List<LivingEntity> getResonatedEntities() {
        return resonatedEntities;
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
