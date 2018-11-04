package org.bukkit.material;

import org.bukkit.Material;

public class Cake extends MaterialData {
    public Cake() {
        super(Material.LEGACY_CAKE_BLOCK);
    }

    public Cake(Material type) {
        super(type);
    }

    /**
     * @param type the type
     * @param data the raw data value
     * @deprecated 不安全的参数
     */
    @Deprecated
    public Cake(Material type, byte data) {
        super(type, data);
    }

    /**
     * 获取蛋糕被吃掉了多少片.
     * <p>
     * 原文:Gets the number of slices eaten from this cake
     *
     * @return 蛋糕被吃掉了多少片
     */
    public int getSlicesEaten() {
        return getData();
    }

    /**
     * 获取剩下多少片蛋糕没吃.
     * <p>
     * 原文:Gets the number of slices remaining on this cake
     *
     * @return 剩下多少片蛋糕没吃
     */
    public int getSlicesRemaining() {
        return 6 - getData();
    }

    /**
     * 设置蛋糕被吃掉了多少片.
     * <p>
     * 原文:Sets the number of slices eaten from this cake
     *
     * @param n 蛋糕被吃掉了多少片.
     */
    public void setSlicesEaten(int n) {
        if (n < 6) {
            setData((byte) n);
        } // TODO: else destroy the block? Probably not possible though
    }

    /**
     * 设置剩下多少片蛋糕没吃.
     * <p>
     * 原文:Sets the number of slices remaining on this cake
     *
     * @param n 剩下多少片蛋糕没吃
     */
    public void setSlicesRemaining(int n) {
        if (n > 6) {
            n = 6;
        }
        setData((byte) (6 - n));
    }

    @Override
    public String toString() {
        return super.toString() + " " + getSlicesEaten() + "/" + getSlicesRemaining() + " slices eaten/remaining";
    }

    @Override
    public Cake clone() {
        return (Cake) super.clone();
    }
}
