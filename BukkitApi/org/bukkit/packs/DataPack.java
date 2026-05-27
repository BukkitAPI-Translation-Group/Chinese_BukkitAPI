package org.bukkit.packs;

import java.util.Set;
import org.bukkit.FeatureFlag;
import org.bukkit.Keyed;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一个数据包.
 *
 * @see <a href="https://minecraft.wiki/w/Data_pack">Minecraft wiki</a>
 */
public interface DataPack extends Keyed {

    /**
     * 获取数据包的标题.
     * <p>
     * 原文：
     * Gets the title of the data pack.
     *
     * @return 标题
     */
    @NotNull
    public String getTitle();

    /**
     * 获取数据包的描述.
     * <p>
     * 原文：
     * Gets the description of the data pack.
     *
     * @return 描述
     */
    @NotNull
    public String getDescription();

    /**
     * 获取包格式.
     * <br>
     * 包格式是非标准的, 与Minecraft版本无关.
     * 已知包版本列表请参见<a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     * <p>
     * 原文：
     * Gets the pack format.
     * <br>
     * Pack formats are non-standard and unrelated to the version of Minecraft. For
     * a list of known pack versions, see the
     * <a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     *
     * @return 包版本
     * @see #getMinSupportedPackFormat()
     * @see #getMaxSupportedPackFormat()
     * @deprecated 包有主/次和最大/最小格式
     */
    @Deprecated(since = "1.21.9")
    public int getPackFormat();

    /**
     * 获取支持的最小包格式. 如果数据包未指定最小支持格式, 则返回{@link #getPackFormat()}.
     * <br>
     * 包格式是非标准的, 与Minecraft版本无关.
     * 已知包版本列表请参见<a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     * <p>
     * 原文：
     * Gets the minimum supported pack format. If the data pack does not specify a
     * minimum supported format, {@link #getPackFormat()} is returned.
     * <br>
     * Pack formats are non-standard and unrelated to the version of Minecraft. For
     * a list of known pack versions, see the
     * <a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     *
     * @return 支持的最小包版本
     * @deprecated 包有主次格式, 请参见{@link #getMinSupportedFormat()}
     */
    @Deprecated(since = "1.21.9")
    public int getMinSupportedPackFormat();

    /**
     * 获取支持的最大包格式. 如果数据包未指定最大支持格式, 则返回{@link #getPackFormat()}.
     * <br>
     * 包格式是非标准的, 与Minecraft版本无关.
     * 已知包版本列表请参见<a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     * <p>
     * 原文：
     * Gets the maximum supported pack format. If the data pack does not specify a
     * maximum supported format, {@link #getPackFormat()} is returned.
     * <br>
     * Pack formats are non-standard and unrelated to the version of Minecraft. For
     * a list of known pack versions, see the
     * <a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     *
     * @return 支持的最大包版本
     * @deprecated 包有主次格式, 请参见{@link #getMaxSupportedFormat()}
     */
    @Deprecated(since = "1.21.9")
    public int getMaxSupportedPackFormat();

    /**
     * 获取支持的最小包格式.
     * <br>
     * 包格式是非标准的, 与Minecraft版本无关.
     * 已知包版本列表请参见<a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     * <p>
     * 原文：
     * Gets the minimum supported pack format.
     * <br>
     * Pack formats are non-standard and unrelated to the version of Minecraft. For
     * a list of known pack versions, see the
     * <a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     *
     * @return 支持的最小包版本
     */
    @NotNull
    public DataPackFormat getMinSupportedFormat();

    /**
     * 获取支持的最大包格式.
     * <br>
     * 包格式是非标准的, 与Minecraft版本无关.
     * 已知包版本列表请参见<a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     * <p>
     * 原文：
     * Gets the maximum supported pack format.
     * <br>
     * Pack formats are non-standard and unrelated to the version of Minecraft. For
     * a list of known pack versions, see the
     * <a href="https://minecraft.wiki/w/Data_pack#Pack_format">Minecraft Wiki</a>.
     *
     * @return 支持的最大包版本
     */
    @NotNull
    public DataPackFormat getMaxSupportedFormat();

    /**
     * 获取数据包是否在服务器上启用.
     * <p>
     * 原文：
     * Gets if the data pack is enabled on the server.
     *
     * @return 如果启用则为True
     */
    public boolean isEnabled();

    /**
     * 获取数据包是否在服务器上是必需的.
     * <p>
     * 原文：
     * Gets if the data pack is required on the server.
     *
     * @return 如果是必需的则为True
     */
    public boolean isRequired();

    /**
     * 获取此数据包与服务器的兼容性.
     * <p>
     * 原文：
     * Gets the compatibility of this data pack with the server.
     *
     * @return 一个枚举
     */
    @NotNull
    public Compatibility getCompatibility();

    /**
     * 获取此数据包请求的特性集合.
     * <p>
     * 原文：
     * Gets a set of features requested by this data pack.
     *
     * @return 特性集合
     */
    @NotNull
    public Set<FeatureFlag> getRequestedFeatures();

    /**
     * 获取此数据包的来源.
     * <p>
     * 原文：
     * Gets the source of this data pack.
     *
     * @return 来源
     */
    @NotNull
    public Source getSource();

    /**
     * 显示数据包与服务器的兼容性.
     */
    public enum Compatibility {

        /**
         * 比服务器包版本更新.
         */
        NEW,
        /**
         * 比服务器包版本更旧.
         */
        OLD,
        /**
         * 与服务器包版本兼容.
         */
        COMPATIBLE,
        /**
         * 是否与服务器包版本兼容未知.
         */
        UNKNOWN;
    }

    /**
     * 代表数据包的来源.
     */
    public enum Source {
        DEFAULT,
        BUILT_IN,
        FEATURE,
        WORLD,
        SERVER;
    }
}