package org.bukkit.event.entity;

import org.bukkit.entity.Slime;
import org.jetbrains.annotations.NotNull;

/**
 * 当史莱姆死亡后分裂成小史莱姆时触发本事件
 */
@Deprecated(since = "26.2")
public class SlimeSplitEvent extends CubeMobSplitEvent {

    public SlimeSplitEvent(@NotNull final Slime slime, final int count) {
        super(slime, count);
    }

    @NotNull
    @Override
    public Slime getEntity() {
        return (Slime) super.getEntity();
    }
}
