package org.bukkit;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * 管理服务器内的刻。
 * <p>
 * 要了解更多关于此接口相关功能的信息。
 *
 * @see <a href="https://minecraft.wiki/w/Commands/tick">Tick Command</a>
 */
public interface ServerTickManager {

    /**
     * 检查服务器是否正常运行。
     * <p>
     * 当服务器正常运行时，表示服务器当前未冻结。
     *
     * @return 如果服务器正常运行则返回 true，否则返回 false。
     *
     * 原文：
     * Checks if the server is running normally.
     * <p>
     * When the server is running normally it indicates that the server is not
     * currently frozen.
     *
     * @return true if the server is running normally, otherwise false
     */
    boolean isRunningNormally();

    /**
     * 检查服务器当前是否正在步进。
     *
     * @return 如果正在步进则返回 true，否则返回 false。
     *
     * 原文：
     * Checks if the server is currently stepping.
     *
     * @return true if stepping, otherwise false
     */
    boolean isStepping();

    /**
     * 检查服务器当前是否正在疾速运行。
     *
     * @return 如果正在疾速运行则返回 true，否则返回 false。
     *
     * 原文：
     * Checks if the server is currently sprinting.
     *
     * @return true if sprinting, otherwise false
     */
    boolean isSprinting();

    /**
     * 检查服务器当前是否已冻结。
     *
     * @return 如果服务器已冻结则返回 true，否则返回 false。
     *
     * 原文：
     * Checks if the server is currently frozen.
     *
     * @return true if the server is frozen, otherwise false
     */
    boolean isFrozen();

    /**
     * 获取服务器当前的刻速率。
     *
     * @return 服务器当前的刻速率。
     *
     * 原文：
     * Gets the current tick rate of the server.
     *
     * @return the current tick rate of the server
     */
    float getTickRate();

    /**
     * 设置服务器的刻速率。
     * <p>
     * 服务器的正常刻速率为 20。不能对服务器应用低于 1.0F 或高于 10,000 的刻速率。
     *
     * @param tick 要设置的服务器刻速率。
     * @throws IllegalArgumentException 如果刻速率太低或太高，服务器无法处理。
     *
     * 原文：
     * Sets the tick rate of the server.
     * <p>
     * The normal tick rate of the server is 20. No tick rate below 1.0F or
     * above 10,000 can be applied to the server.
     *
     * @param tick the tick rate to set the server to
     * @throws IllegalArgumentException if tick rate is too low or too high for
     * the server to handle
     */
    void setTickRate(float tick);

    /**
     * 将服务器设置为冻结状态，不处理大多数事物。
     *
     * @param frozen true 为冻结服务器，否则为 false。
     *
     * 原文：
     * Sets the server to a frozen state that does not tick most things.
     *
     * @param frozen true to freeze the server, otherwise false
     */
    void setFrozen(boolean frozen);

    * 如果服务器当前已冻结，则步进游戏指定数量的刻。
     * <p>
     * 步进在服务器处于冻结状态时发生，可以通过使用游戏内的 /tick freeze 命令或 {@link #setFrozen(boolean)} 方法来启动。
     *
     * @param ticks 要步进游戏的刻数。
     * @return 如果游戏现在正在步进则返回 true。如果游戏未冻结，则返回 false，请求无法完成。
     *
     * 原文：
     * Steps the game a certain amount of ticks if the server is currently
     * frozen.
     * <p>
     * Steps occur when the server is in a frozen state which can be started by
     * either using the in game /tick freeze command or the
     * {@link #setFrozen(boolean)} method.
     *
     * @param ticks the amount of ticks to step the game for
     * @return true if the game is now stepping. False if the game is not frozen
     * so the request could not be fulfilled.
     */
    boolean stepGameIfFrozen(int ticks);

    /**
     * 如果正在步进，则停止当前步进。
     *
     * @return 如果游戏不再步进则返回 true。如果服务器未步进或已完成步进则返回 false。
     *
     * 原文：
     * Stops the current stepping if stepping is occurring.
     *
     * @return true if the game is no-longer stepping. False if the server was
     * not stepping or was already done stepping.
     */
    boolean stopStepping();

    /**
     * 尝试启动疾速运行，以比正常速度更快的速率执行所有服务器刻。
     *
     * @param ticks 要疾速运行的刻数。
     * @return 如果疾速运行已被启动并被停止则返回 true，否则返回 false。
     *
     * 原文：
     * Attempts to initiate a sprint, which executes all server ticks at a
     * faster rate then normal.
     *
     * @param ticks the amount of ticks to sprint for
     * @return true if a sprint was already initiated and was stopped, otherwise
     * false
     */
    boolean requestGameToSprint(int ticks);

    /**
     * 如果当前正在疾速运行，则停止当前疾速运行。
     *
     * @return 如果游戏不再疾速运行则返回 true，如果服务器未疾速运行或已完成疾速运行则返回 false。
     *
     * 原文：
     * Stops the current sprint if one is currently happening.
     *
     * @return true if the game is no-longer sprinting, false if the server was
     * not sprinting or was already done sprinting
     */
    boolean stopSprinting();

    /**
     * 检查给定的实体是否已冻结。
     *
     * @param entity 要检查是否冻结的实体。
     * @return 如果实体当前已冻结则返回 true，否则返回 false。
     *
     * 原文：
     * Checks if a given entity is frozen.
     *
     * @param entity the entity to check if frozen.
     * @return true if the entity is currently frozen otherwise false.
     */
    boolean isFrozen(@NotNull Entity entity);

    /**
     * 获取剩余要运行的冻结刻数。
     *
     * @return 剩余要运行的冻结刻数。
     *
     * 原文：
     * Gets the amount of frozen ticks left to run.
     *
     * @return the amount of frozen ticks left to run
     */
    int getFrozenTicksToRun();
}
