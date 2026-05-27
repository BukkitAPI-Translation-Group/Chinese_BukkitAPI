package org.bukkit;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * 表示来自幽匿感测体的振动。
 */
public class Vibration {

    private final Location origin;
    private final Destination destination;
    private final int arrivalTime;

    public Vibration(@NotNull Location origin, @NotNull Destination destination, int arrivalTime) {
        this.origin = origin;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
    }

    /**
     * 获取振动的起源位置。
     *
     * @return 起源位置
     * <p>
     * 原文：Get the origin of the vibration.
     */
    @NotNull
    public Location getOrigin() {
        return origin;
    }

    /**
     * 获取振动的目的地。
     *
     * @return 目的地
     * <p>
     * 原文：Get the vibration destination.
     */
    @NotNull
    public Destination getDestination() {
        return destination;
    }

    /**
     * 获取振动到达时间（以刻为单位）。
     *
     * @return 到达时间
     * <p>
     * 原文：Get the vibration arrival time in ticks.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    public interface Destination {

        public static class EntityDestination implements Destination {

            private final Entity entity;

            public EntityDestination(@NotNull Entity entity) {
                this.entity = entity;
            }

            @NotNull
            public Entity getEntity() {
                return entity;
            }
        }

        public static class BlockDestination implements Destination {

            private final Location block;

            public BlockDestination(@NotNull Location block) {
                this.block = block;
            }

            public BlockDestination(@NotNull Block block) {
                this(block.getLocation());
            }

            @NotNull
            public Location getLocation() {
                return block;
            }

            @NotNull
            public Block getBlock() {
                return block.getBlock();
            }
        }
    }
}
