package org.bukkit.event.entity;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * 当刷怪笼刷出实体时触发本事件.
 * <p>
 * 如果本事件被取消, 那么实体将不会被刷出.
 */
public class SpawnerSpawnEvent extends EntitySpawnEvent {
    private final CreatureSpawner spawner;

    public SpawnerSpawnEvent(@NotNull final Entity spawnee, @NotNull final CreatureSpawner spawner) {
        super(spawnee);
        this.spawner = spawner;
    }

    @NotNull
    public CreatureSpawner getSpawner() {
        return spawner;
    }
}
