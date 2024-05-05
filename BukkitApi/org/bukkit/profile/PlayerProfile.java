package org.bukkit.profile;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.bukkit.Server;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一份玩家资料.
 * <p>
 * 一份玩家资料中始终包含一个玩家唯一 id、一个非空名字，或两者都有.
 * 资料中的唯一 id 和名字是不可变的, 但其它属性(比如皮肤)是可以更改的.
 * <p>
 * 可以通过 {@link Server#createPlayerProfile(UUID, String)} 创建新玩家资料.
 */
public interface PlayerProfile extends Cloneable, ConfigurationSerializable {

    /**
     * 获取玩家的唯一 id.
     * <p>
     * 原文:Gets the player's unique id.
     *
     * @return 玩家唯一 id, 如果不存在/未设置则为 null
     */
    @Nullable
    UUID getUniqueId();

    /**
     * 获取玩家名.
     * <p>
     * 原文:Gets the player name.
     *
     * @return 玩家名, 如果不存在/未设置则为 null
     */
    @Nullable
    String getName();

    /**
     * 获取{@link PlayerTextures 玩家纹理}信息 (玩家的皮肤+披风).
     * <p>
     * 原文:Gets the {@link PlayerTextures} of this profile.
     *
     * @return {@link PlayerTextures 玩家纹理}信息, 不为 null
     */
    @NotNull
    PlayerTextures getTextures();

    /**
     * 复制指定纹理并覆盖此资料中的纹理.
     * <p>
     * 原文:Copies the given textures.
     *
     * @param textures 要复制的纹理, 指定 null 以清除纹理
     */
    void setTextures(@Nullable PlayerTextures textures);

    /**
     * 检测此资料是否完整.
     * <p>
     * 玩家名、唯一 id、纹理齐聚一堂即可认为此资料是完整的.
     * <p>
     * 原文:Checks whether this profile is complete.
     * <p>
     * A profile is currently considered complete if it has a name, a unique id,
     * and textures.
     *
     * @return 如果资料完整则为 <code>true</code>
     */
    boolean isComplete();

    /**
     * 基于此资料生成一份更新的玩家资料.
     * <p>
     * 本方法将通过补全资料中缺失的信息 (玩家名、唯一 id、纹理等) 来尝试生成一份完整的游戏资料,
     * 并同时更新已有属性 (玩家名、纹理等)为官方的最新值.
     * 此操作不会修改本资料, 但生成一份全新已更新的{@link PlayerProfile 玩家资料}.
     * <p>
     * 如果唯一 id 或名字所对应的玩家不存在, 此操作将生成与当前资料等同的资料 (注:不同实例),
     * 此时生成的资料可能不完整.
     * <p>
     * 此操作是异步的: 更新资料的操作将在另一个线程发起一个对外连接, 以拉取官方最新资料属性.
     * 一旦资料更新完成并可用, 本方法返回的 {@link CompletableFuture} 将完成.
     * 为了不阻塞服务器的主线程, 您不应在主线程等待 CompletableFuture 返回结果.
     * 相反, 如果您想在资料更新完成时利用更新的资料做些事情, 您可以使用这样的代码:
     * <pre>
     * profile.update().thenAcceptAsync(updatedProfile -> {
     *     // Do something with the updated profile:
     *     // ...
     * }, runnable -> Bukkit.getScheduler().runTask(plugin, runnable));
     * </pre>
     * <p>
     * 原文:Produces an updated player profile based on this profile.
     * <p>
     * This tries to produce a completed profile by filling in missing
     * properties (name, unique id, textures, etc.), and updates existing
     * properties (e.g. name, textures, etc.) to their official and up-to-date
     * values. This operation does not alter the current profile, but produces a
     * new updated {@link PlayerProfile}.
     * <p>
     * If no player exists for the unique id or name of this profile, this
     * operation yields a profile that is equal to the current profile, which
     * might not be complete.
     * <p>
     * This is an asynchronous operation: Updating the profile can result in an
     * outgoing connection in another thread in order to fetch the latest
     * profile properties. The returned {@link CompletableFuture} will be
     * completed once the updated profile is available. In order to not block
     * the server's main thread, you should not wait for the result of the
     * returned CompletableFuture on the server's main thread. Instead, if you
     * want to do something with the updated player profile on the server's main
     * thread once it is available, you could do something like this:
     * <pre>
     * profile.update().thenAcceptAsync(updatedProfile -> {
     *     // Do something with the updated profile:
     *     // ...
     * }, runnable -> Bukkit.getScheduler().runTask(plugin, runnable));
     * </pre>
     *
     * @return 一个 CompletableFuture, 当资料更新完成时此 Future 将完成
     */
    @NotNull
    CompletableFuture<PlayerProfile> update();

    @NotNull
    PlayerProfile clone();
}
