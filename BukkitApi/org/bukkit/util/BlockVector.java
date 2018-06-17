package org.bukkit.util;

import java.util.Map;
import org.bukkit.configuration.serialization.SerializableAs;

/**
 * 这是一个带有可以向下取整XYZ坐标函数的向量类,就像WorldEdit中的BlockVector.
 * BlockVector可以用于HashSet和HashMap.注意BlockVector是可变的,
 * 但重要的是请确保BlockVector被扔到一个HashSet或HashMap后就不要修改它了.
 * <p>
 * 原文:A vector with a hash function that floors the X, Y, Z components, a la
 * BlockVector in WorldEdit. BlockVectors can be used in hash sets and
 * hash maps. Be aware that BlockVectors are mutable, but it is important
 * that BlockVectors are never changed once put into a hash set or hash map.
 */
@SerializableAs("BlockVector")
public class BlockVector extends Vector {

    /**
     * 使用原点坐标来创建向量.
     * <p>
     * 原文:Construct the vector with all components as 0.
     */
    public BlockVector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * 使用另一个向量来创建向量.
     * <p>
     * 原文:Construct the vector with another vector.
     *
     * @param vec 另一个向量。
     */
    public BlockVector(Vector vec) {
        this.x = vec.getX();
        this.y = vec.getY();
        this.z = vec.getZ();
    }

    /**
     * 使用给定整数坐标来创建向量.
     * <p>
     * 原文:Construct the vector with provided integer components.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     */
    public BlockVector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 使用给定双精度浮点数坐标来创建向量.
     * <p>
     * 原文:Construct the vector with provided double components.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     */
    public BlockVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 使用给定单精度浮点数坐标来创建向量.
     * <p>
     * 原文:Construct the vector with provided float components.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     */
    public BlockVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 检查是否同另一个对象相等.
     * <p>
     * 原文:Checks if another object is equivalent.
     *
     * @param obj 另一个对象
     * @return 是否同另一个对象相等
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BlockVector)) {
            return false;
        }
        BlockVector other = (BlockVector) obj;

        return (int) other.getX() == (int) this.x && (int) other.getY() == (int) this.y && (int) other.getZ() == (int) this.z;

    }

    /**
     * 返回这个向量的哈希码.
     * <p>
     * 原文:Returns a hash code for this vector.
     *
     * @return 哈希码
     */
    @Override
    public int hashCode() {
        return (Integer.valueOf((int) x).hashCode() >> 13) ^ (Integer.valueOf((int) y).hashCode() >> 7) ^ Integer.valueOf((int) z).hashCode();
    }

    /**
     * 克隆生成新的方块向量.
     * <p>
     * 原文:Get a new block vector.
     *
     * @return 向量
     */
    @Override
    public BlockVector clone() {
        return (BlockVector) super.clone();
    }

    public static BlockVector deserialize(Map<String, Object> args) {
        double x = 0;
        double y = 0;
        double z = 0;

        if (args.containsKey("x")) {
            x = (Double) args.get("x");
        }
        if (args.containsKey("y")) {
            y = (Double) args.get("y");
        }
        if (args.containsKey("z")) {
            z = (Double) args.get("z");
        }

        return new BlockVector(x, y, z);
    }
}
