package org.bukkit.event.world;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * 当一个有机结构试图生长的时调用此事件(树苗 {@literal ->} 树, 蘑菇 {@literal ->} 巨型蘑菇, 自然生长的或使用骨粉生长的).
 */
public class StructureGrowEvent extends WorldEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;
    private final Location location;
    private final TreeType species;
    private final boolean bonemeal;
    private final Player player;
    private final List<BlockState> blocks;

    public StructureGrowEvent(final Location location, final TreeType species, final boolean bonemeal, final Player player, final List<BlockState> blocks) {
        super(location.getWorld());
        this.location = location;
        this.species = species;
        this.bonemeal = bonemeal;
        this.player = player;
        this.blocks = blocks;
    }

    /**
     * 获取这个结构的位置.
     * <p>
     * 原文:
     * Gets the location of the structure.
     *
     * @return 结构的位置
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 获取物种类型(白桦、橡树、云杉、红蘑菇和棕蘑菇).
     * <p>
     * 原文:
     * Gets the species type (birch, normal, pine, red mushroom, brown
     * mushroom)
     *
     * @return 结构类型
     */
    public TreeType getSpecies() {
        return species;
    }

    /**
     * 检测此结构的生长是否使用骨粉.
     * <p>
     * 原文:
     * Checks if structure was grown using bonemeal.
     *
     * @return 如果此结构是用骨粉催熟的则为true
     */
    public boolean isFromBonemeal() {
        return bonemeal;
    }

    /**
     * 获取“种”下这个结构的玩家.
     * <p>
     * 原文:
     * Gets the player that created the structure.
     *
     * @return “种”下这个结构的玩家，如果为null则这个不是手工创建的
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取与结构有关的所有方块的列表.
     * <p>
     * 原文:
     * Gets a list of all blocks associated with the structure.
     *
     * @return 与结构有关的所有方块的列表
     */
    public List<BlockState> getBlocks() {
        return blocks;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}