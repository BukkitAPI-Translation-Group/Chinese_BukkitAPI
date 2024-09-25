package org.bukkit.event.entity;

import java.util.List;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 当一个{@link Player 玩家}死亡时触发本事件
 */
public class PlayerDeathEvent extends EntityDeathEvent {
    private int newExp = 0;
    private String deathMessage = "";
    private int newLevel = 0;
    private int newTotalExp = 0;
    private boolean keepLevel = false;
    private boolean keepInventory = false;

    public PlayerDeathEvent(@NotNull final Player player, @NotNull DamageSource damageSource, @NotNull final List<ItemStack> drops, final int droppedExp, @Nullable final String deathMessage) {
        this(player, damageSource, drops, droppedExp, 0, deathMessage);
    }

    public PlayerDeathEvent(@NotNull final Player player, @NotNull DamageSource damageSource, @NotNull final List<ItemStack> drops, final int droppedExp, final int newExp, @Nullable final String deathMessage) {
        this(player, damageSource, drops, droppedExp, newExp, 0, 0, deathMessage);
    }

    public PlayerDeathEvent(@NotNull final Player player, @NotNull DamageSource damageSource, @NotNull final List<ItemStack> drops, final int droppedExp, final int newExp, final int newTotalExp, final int newLevel, @Nullable final String deathMessage) {
        super(player, damageSource, drops, droppedExp);
        this.newExp = newExp;
        this.newTotalExp = newTotalExp;
        this.newLevel = newLevel;
        this.deathMessage = deathMessage;
    }

    @NotNull
    @Override
    public Player getEntity() {
        return (Player) entity;
    }

    /**
     * 设置广播给所有人的死亡提示.
     * <p>
     * 原文:
     * Set the death message that will appear to everyone on the server.
     *
     * @param deathMessage 死亡提示
     */
    public void setDeathMessage(@Nullable String deathMessage) {
        this.deathMessage = deathMessage;
    }

    /**
     * 获取广播给所有人的死亡提示.
     * <p>
     * 原文:Get the death message that will appear to everyone on the server.
     *
     * @return 死亡提示
     */
    @Nullable
    public String getDeathMessage() {
        return deathMessage;
    }

    /**
     * 获取玩家重生时有多少经验.
     * <p>
     * 不包含多少经验会掉落，要做到这点请看{@link #getDroppedExp()}.
     * <p>
     * 原文:Gets how much EXP the Player should have at respawn.
     * <p>
     * This does not indicate how much EXP should be dropped, please see
     * {@link #getDroppedExp()} for that.
     *
     * @return 重生后的玩家有多少经验
     */
    public int getNewExp() {
        return newExp;
    }

    /**
     * 设置玩家在重生时应该拥有多少经验值。
     * <p>
     * 这并不表示应该掉落多少经验值，请参见 {@link #setDroppedExp(int)}。
     * <p>
     * 原文:
     * Sets how much EXP the Player should have at respawn.
     * <p>
     * This does not indicate how much EXP should be dropped, please see
     * {@link #setDroppedExp(int)} for that.
     *
     * @param exp 重生玩家的新经验值
     */
    public void setNewExp(int exp) {
        newExp = exp;
    }

    /**
     * 获取玩家在重生时应该拥有的等级。
     * <p>
     * 原文:
     * Gets the Level the Player should have at respawn.
     *
     * @return 重生玩家的新等级
     */
    public int getNewLevel() {
        return newLevel;
    }

    /**
     * 设置玩家在重生时应该拥有的等级。
     * <p>
     * 原文:
     * Sets the Level the Player should have at respawn.
     *
     * @param level 重生玩家的新等级
     */
    public void setNewLevel(int level) {
        newLevel = level;
    }

    /**
     * 获取玩家在重生时应该拥有的总经验值。
     * <p>
     * 原文:
     * Gets the Total EXP the Player should have at respawn.
     *
     * @return 重生玩家的新总经验值
     */
    public int getNewTotalExp() {
        return newTotalExp;
    }

    /**
     * 设置玩家在重生时应该拥有的总经验值。
     * <p>
     * 原文:
     * Sets the Total EXP the Player should have at respawn.
     *
     * @param totalExp 重生玩家的新总经验值
     */
    public void setNewTotalExp(int totalExp) {
        newTotalExp = totalExp;
    }

    /**
     * 获取玩家在重生时是否应该保留所有经验值。
     * <p>
     * 此标志会覆盖其他经验值设置。
     * <p>
     * 原文:
     * Gets if the Player should keep all EXP at respawn.
     * <p>
     * This flag overrides other EXP settings
     *
     * @return 如果玩家应该保留所有死亡前的经验值，则返回 true
     */
    public boolean getKeepLevel() {
        return keepLevel;
    }

    /**
     * 设置玩家在重生时是否应该保留所有经验值。
     * <p>
     * 这会覆盖所有其他经验值设置。
     * <p>
     * <b>这并不会阻止经验值掉落。应使用 {@link #setDroppedExp(int)} 来阻止经验值掉落。
     * <p>
     * 原文:
     * Sets if the Player should keep all EXP at respawn.
     * <p>
     * This overrides all other EXP settings
     * <p>
     * <b>This doesn't prevent the EXP from dropping.
     * {@link #setDroppedExp(int)} should be used stop the
     * EXP from dropping.</b>
     *
     * @param keepLevel 如果为 true，则保留所有当前经验值
     */
    public void setKeepLevel(boolean keepLevel) {
        this.keepLevel = keepLevel;
    }

    /**
     * 设置玩家在死亡时是否保留物品栏。
     * <p>
     * <b>这并不会阻止物品掉落。应使用 {@code getDrops().clear()}来阻止物品掉落。
     * <p>
     * 原文:
     * Sets if the Player keeps inventory on death.
     * <p>
     * <b>This doesn't prevent the items from dropping.
     * {@code getDrops().clear()} should be used stop the
     * items from dropping.</b>
     *
     * @param keepInventory 如果为 true，则保留物品栏
     */
    public void setKeepInventory(boolean keepInventory) {
        this.keepInventory = keepInventory;
    }

    /**
     * 获取玩家在死亡时是否保留物品栏。
     * <p>
     * 原文:
     * Gets if the Player keeps inventory on death.
     *
     * @return 如果玩家在死亡时保留物品栏，则返回 true
     */
    public boolean getKeepInventory() {
        return keepInventory;
    }
}