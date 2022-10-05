package org.bukkit.profile;

import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 提供对存储于 {@link PlayerProfile} 中的纹理信息的访问.
 * <p>
 * 修改纹理信息将立即作废并清除任何先前存在的, 游戏官方特有的属性,
 * 比如{@link #getTimestamp() 时间戳}和{@link #isSigned() 签名}.
 */
public interface PlayerTextures {

    /**
     * 不同的 Minecraft 皮肤模型.
     */
    enum SkinModel {
        /**
         * 经典皮肤模型 (Steve).
         */
        CLASSIC,
        /**
         * 瘦模型, 相比于经典模型拥有更苗条的手臂 (Alex).
         */
        SLIM;
    }

    /**
     * 检查此资料是否没有存储纹理信息.
     * <p>
     * 原文:Checks if the profile stores no textures.
     *
     * @return 如果没有存储纹理信息则为 <code>true</code>
     */
    boolean isEmpty();

    /**
     * 清除纹理信息.
     * <p>
     * 原文:Clears the textures.
     */
    void clear();

    /**
     * 获取指向玩家皮肤的 URL.
     * <p>
     * 原文:Gets the URL that points to the player's skin.
     *
     * @return 指向玩家皮肤的 URL, 如未设置则为 <code>null</code>
     */
    @Nullable
    URL getSkin();

    /**
     * 设置玩家的皮肤为指定的 URL, 并将模型设为 {@link SkinModel#CLASSIC}.
     * <p>
     * URL <b>必须</b>指向 Minecraft 纹理服务器. 例如:
     * <pre>
     * http://textures.minecraft.net/texture/b3fbd454b599df593f57101bfca34e67d292a8861213d2202bb575da7fd091ac
     * </pre>
     * <p>
     * 原文:Sets the player's skin to the specified URL, and the skin model to
     * {@link SkinModel#CLASSIC}.
     * <p>
     * The URL <b>must</b> point to the Minecraft texture server. Example URL:
     * <pre>
     * http://textures.minecraft.net/texture/b3fbd454b599df593f57101bfca34e67d292a8861213d2202bb575da7fd091ac
     * </pre>
     *
     * @param skinUrl 玩家皮肤的 URL, 设为 <code>null</code> 以清除它
     */
    void setSkin(@Nullable URL skinUrl);

    /**
     * 设置玩家的皮肤及其{@link SkinModel 模型}.
     * <p>
     * URL <b>必须</b>指向 Minecraft 纹理服务器. 例如:
     * <pre>
     * http://textures.minecraft.net/texture/b3fbd454b599df593f57101bfca34e67d292a8861213d2202bb575da7fd091ac
     * </pre>
     * <p>
     * 如果参数 skinModel 为 null, 将默认使用{@link SkinModel#CLASSIC 经典模型}.
     * <p>
     * 原文:Sets the player's skin and {@link SkinModel}.
     * <p>
     * The URL <b>must</b> point to the Minecraft texture server. Example URL:
     * <pre>
     * http://textures.minecraft.net/texture/b3fbd454b599df593f57101bfca34e67d292a8861213d2202bb575da7fd091ac
     * </pre>
     * <p>
     * A skin model of <code>null</code> results in {@link SkinModel#CLASSIC} to
     * be used.
     *
     * @param skinUrl 玩家皮肤的 URL, 设为 <code>null</code> 以清除它
     * @param skinModel 皮肤模型, 如果皮肤URL为 <code>null</code> 将忽略此值
     */
    void setSkin(@Nullable URL skinUrl, @Nullable SkinModel skinModel);

    /**
     * 获取玩家皮肤所套用的模型.
     * <p>
     * 如果尚未设置皮肤, 将返回{@link SkinModel#CLASSIC}.
     * <p>
     * 原文:Gets the model of the player's skin.
     * <p>
     * This returns {@link SkinModel#CLASSIC} if no skin is set.
     *
     * @return 皮肤模型
     */
    @NotNull
    SkinModel getSkinModel();

    /**
     * 获取指向玩家披风的 URL.
     * <p>
     * 原文:Gets the URL that points to the player's cape.
     *
     * @return 指向玩家披风的 URL, 如未设置则为 <code>null</code>
     */
    @Nullable
    URL getCape();

    /**
     * 设置玩家的披风为指定的 URL.
     * <p>
     * URL <b>必须</b>指向 Minecraft 纹理服务器. 例如:
     * <pre>
     * http://textures.minecraft.net/texture/2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933
     * </pre>
     * <p>
     * 原文:Sets the URL that points to the player's cape.
     * <p>
     * The URL <b>must</b> point to the Minecraft texture server. Example URL:
     * <pre>
     * http://textures.minecraft.net/texture/2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933
     * </pre>
     *
     * @param capeUrl 玩家披风的 URL, 设为 <code>null</code> 以清除它
     */
    void setCape(@Nullable URL capeUrl);

    /**
     * 获取资料最后更新时间的时间戳.
     * <p>
     * 原文:Gets the timestamp at which the profile was last updated.
     *
     * @return 更新时间戳, 如果未知则为<code>0</code>
     */
    long getTimestamp();

    /**
     * 检查此纹理是否已签名, 且签名有效.
     * <p>
     * 原文:Checks if the textures are signed and the signature is valid.
     *
     * @return 如果纹理已签名且签名有效则为 <code>true</code>
     */
    boolean isSigned();
}
