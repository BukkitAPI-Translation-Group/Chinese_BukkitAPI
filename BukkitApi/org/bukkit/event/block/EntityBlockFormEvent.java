package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

/**
 * 方块构成实体时调用本事件.
 * <p>
 * 举个例子:
 * <ul>
 * <li>雪构成 {@link org.bukkit.entity.Snowman}.
 * </ul>
 */
public class EntityBlockFormEvent extends BlockFormEvent {
    private final Entity entity;

    public EntityBlockFormEvent(final Entity entity, final Block block, final BlockState blockstate) {
        super(block, blockstate);

        this.entity = entity;
    }

    /**
     * 获取被构成的实体
     *
     * @return 被构成的实体
     */
    public Entity getEntity() {
        return entity;
    }
}