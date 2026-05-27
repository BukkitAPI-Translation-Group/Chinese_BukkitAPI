package org.bukkit.event.entity;

import org.bukkit.block.TrialSpawner;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 当实体通过试炼刷怪笼生成到世界中时调用。
 * <p>
 * 如果试炼刷怪笼生成事件被取消，实体将不会生成。
 */
@ApiStatus.Experimental
public class TrialSpawnerSpawnEvent extends EntitySpawnEvent {
    private final TrialSpawner spawner;

    public TrialSpawnerSpawnEvent(@NotNull final Entity spawnee, @NotNull final TrialSpawner spawner) {
        super(spawnee);
        this.spawner = spawner;
    }

    @NotNull
    public TrialSpawner getTrialSpawner() {
        return spawner;
    }
}
