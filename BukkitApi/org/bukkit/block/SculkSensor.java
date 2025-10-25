package org.bukkit.block;

/**
 * 代表幽匿感测体的捕获状态.
 */
public interface SculkSensor extends TileState {

    /**
     * 获取此感测体的最后振动频率.
     * <p>
     * 感测体检测到的不同活动会产生不同的频率,
     * 并决定连接的比较器的输出.
     * <p>
     * 原文:Gets the last vibration frequency of this sensor.
     *
     * Different activities detected by the sensor will produce different
     * frequencies and dictate the output of connected comparators.
     *
     * @return 0-15之间的频率值
     */
    int getLastVibrationFrequency();

    /**
     * 设置此感测体的最后振动频率.
     * <p>
     * 感测体检测到的不同活动会产生不同的频率,
     * 并决定连接的比较器的输出.
     * <p>
     * 原文:Sets the last vibration frequency of this sensor.
     *
     * Different activities detected by the sensor will produce different
     * frequencies and dictate the output of connected comparators.
     *
     * @param lastVibrationFrequency 0-15之间的频率值
     */
    void setLastVibrationFrequency(int lastVibrationFrequency);
}
