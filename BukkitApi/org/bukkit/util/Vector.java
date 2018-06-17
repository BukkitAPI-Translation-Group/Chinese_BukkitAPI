package org.bukkit.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

/**
 * Vector代表一个可变向量.因为这个组件是可变的,如果之后的代码修改了这个Vector,长期存储这些Vector是危险的.
 * 如果你想要长期保存一个向量,最明智的方法是使用<code>clone()</code>来获得一个拷贝.
 * <p>
 * 原文:Represents a mutable vector. Because the components of Vectors are mutable,
 * storing Vectors long term may be dangerous if passing code modifies the
 * Vector later. If you want to keep around a Vector, it may be wise to call
 * <code>clone()</code> in order to get a copy.
 */
@SerializableAs("Vector")
public class Vector implements Cloneable, ConfigurationSerializable {
    private static final long serialVersionUID = -2657651106777219169L;

    private static Random random = new Random();

    /**
     * 近似相等的阈值,用于equals().
     * <p>
     * 原文:Threshold for fuzzy equals().
     */
    private static final double epsilon = 0.000001;

    protected double x;
    protected double y;
    protected double z;

    /**
     * 用坐标原点来构造一个向量.
     * <p>
     * 原文:Construct the vector with all components as 0.
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * 用给定整数坐标来构造一个向量.
     * <p>
     * 原文:Construct the vector with provided integer components.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     */
    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 用给定双精度浮点数坐标来构造一个向量.
     * <p>
     * 原文:Construct the vector with provided double components.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     */
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 用给定单精度浮点数坐标来构造一个向量.
     * <p>
     * 原文:Construct the vector with provided float components.
     *
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     */
    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 把一个向量添加到现在的向量里.
     * <p>
     * 原文:Adds a vector to this one
     *
     * @param vec 另一个向量
     * @return 返回自身作为结果向量
     */
    public Vector add(Vector vec) {
        x += vec.x;
        y += vec.y;
        z += vec.z;
        return this;
    }

    /**
     * 减去另一个向量.
     * <p>
     * 原文:Subtracts a vector from this one.
     *
     * @param vec 另一个向量
     * @return 返回自身作为结果向量
     */
    public Vector subtract(Vector vec) {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }

    /**
     * 向量的坐标相乘,注意,不是叉积也不是点积,只是单纯的相乘.
     * <p>
     * 原文:Multiplies the vector by another.
     *
     * @param vec 另一个向量
     * @return 返回自身作为结果向量
     */
    public Vector multiply(Vector vec) {
        x *= vec.x;
        y *= vec.y;
        z *= vec.z;
        return this;
    }

    /**
     * 向量的坐标相除.
	 * <p>
	 * 译注:向量不存在除法.
     * <p>
     * 原文:Divides the vector by another.
     *
     * @param vec 另一个向量
     * @return 返回自身作为结果向量
     */
    public Vector divide(Vector vec) {
        x /= vec.x;
        y /= vec.y;
        z /= vec.z;
        return this;
    }

    /**
     * 复制一个向量的坐标.
     * <p>
     * 原文:Copies another vector
     *
     * @param vec 另一个向量
     * @return 返回自身作为结果向量
     */
    public Vector copy(Vector vec) {
        x = vec.x;
        y = vec.y;
        z = vec.z;
        return this;
    }

    /**
     * 获取向量的模值,定义为sqrt(x^2+y^2+z^2).
     * 这个方法的返回值不进行缓存并且使用一个代价更高的平方以及开根函数,
     * 所以不要重复多次调用这个方法来获取向量的模值.
     * 如果开平方的函数出现溢出会返回不存在的数字(NaN),这会发生在向量的模过大的时候.
     * <p>
     * 原文:Gets the magnitude of the vector, defined as sqrt(x^2+y^2+z^2). The
     * value of this method is not cached and uses a costly square-root
     * function, so do not repeatedly call this method to get the vector's
     * magnitude. NaN will be returned if the inner result of the sqrt()
     * function overflows, which will be caused if the length is too long.
     *
     * @return 模
     */
    public double length() {
        return Math.sqrt(NumberConversions.square(x) + NumberConversions.square(y) + NumberConversions.square(z));
    }

    /**
     * 获取向量模的平方.
     * <p>
     * 原文:Gets the magnitude of the vector squared.
     *
     * @return 模的平方
     */
    public double lengthSquared() {
        return NumberConversions.square(x) + NumberConversions.square(y) + NumberConversions.square(z);
    }

    /**
     * 获取与给定向量间的距离.这个方法的返回值不进行缓存并且使用一个代价更高的平方以及开根函数,
     * 所以不要重复多次调用这个方法来获取向量的模值.
     * 如果开平方的函数出现溢出会返回NaN,这会发生在向量的模过大的时候.
     * <p>
     * 原文:Get the distance between this vector and another. The value of this
     * method is not cached and uses a costly square-root function, so do not
     * repeatedly call this method to get the vector's magnitude. NaN will be
     * returned if the inner result of the sqrt() function overflows, which
     * will be caused if the distance is too long.
     *
     * @param o 给定向量
     * @return 距离
     */
    public double distance(Vector o) {
        return Math.sqrt(NumberConversions.square(x - o.x) + NumberConversions.square(y - o.y) + NumberConversions.square(z - o.z));
    }

    /**
     * 获取与给定向量间的距离的平方.
     * <p>
     * 原文:Get the squared distance between this vector and another.
     *
     * @param o 给定向量
     * @return 距离的平方
     */
    public double distanceSquared(Vector o) {
        return NumberConversions.square(x - o.x) + NumberConversions.square(y - o.y) + NumberConversions.square(z - o.z);
    }

    /**
     * 获取与给定向量的夹角,以弧度表示.
     * <p>
     * 原文:Gets the angle between this vector and another in radians.
     *
     * @param other 给定向量
     * @return 弧度表示的夹角
     */
    public float angle(Vector other) {
        double dot = dot(other) / (length() * other.length());

        return (float) Math.acos(dot);
    }

    /**
     * 设置这个向量为两个向量连线的中点向量.
     * <p>
     * 原文:Sets this vector to the midpoint between this vector and another.
     *
     * @param other 给定向量
     * @return 返回自身作为结果向量(此时已经是中点向量)
     */
    public Vector midpoint(Vector other) {
        x = (x + other.x) / 2;
        y = (y + other.y) / 2;
        z = (z + other.z) / 2;
        return this;
    }

    /**
     * 获取一个新的两个向量连线的中点向量.
     * <p>
     * 原文:Gets a new midpoint vector between this vector and another.
     *
     * @param other 给定向量
     * @return 一个新的中点向量
     */
    public Vector getMidpoint(Vector other) {
        double x = (this.x + other.x) / 2;
        double y = (this.y + other.y) / 2;
        double z = (this.z + other.z) / 2;
        return new Vector(x, y, z);
    }

    /**
     * 向量的数乘,将向量在所有轴上扩展一个倍数,给定参数为整数.
     * <p>
     * 原文:Performs scalar multiplication, multiplying all components with a
     * scalar.
     *
     * @param m 因数,即数乘的倍数,整数
     * @return 返回自身作为结果向量
     */
    public Vector multiply(int m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    /**
     * 向量的数乘,将向量在所有轴上扩展一个倍数,给定参数为双精度浮点数.
     * <p>
     * 原文:Performs scalar multiplication, multiplying all components with a
     * scalar.
     *
     * @param m 因数,即数乘的倍数,双精度浮点数
     * @return 返回自身作为结果向量
     */
    public Vector multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    /**
     * 向量的数乘,将向量在所有轴上扩展一个倍数,给定参数为单精度浮点数.
     * <p>
     * 原文:Performs scalar multiplication, multiplying all components with a
     * scalar.
     *
     * @param m 因数,即数乘的倍数,单精度浮点数
     * @return 返回自身作为结果向量
     */
    public Vector multiply(float m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    /**
     * 计算与给定向量的点积.点积的定义为x1*x2+y1*y2+z1*z2.此函数返回值是个标量.
     * <p>
     * 原文:Calculates the dot product of this vector with another. The dot product
     * is defined as x1*x2+y1*y2+z1*z2. The returned value is a scalar.
     *
     * @param other 给定向量
     * @return 点积
     */
    public double dot(Vector other) {
        return x * other.x + y * other.y + z * other.z;
    }

    /**
     * 计算与给定向量的叉积,叉积的大小等同于向量积的模,方向使用右手定则判断,一般计算时使用矩阵行列式公式.
     * 其定义如下:
     * <ul>
     * <li>x = y1 * z2 - y2 * z1
     * <li>y = z1 * x2 - z2 * x1
     * <li>z = x1 * y2 - x2 * y1
     * </ul>
     * <p>
     * 原文:Calculates the cross product of this vector with another. The cross
     * product is defined as:
     * <ul>
     * <li>x = y1 * z2 - y2 * z1
     * <li>y = z1 * x2 - z2 * x1
     * <li>z = x1 * y2 - x2 * y1
     * </ul>
     *
     * @param o 给定向量
     * @return 返回自身作为结果向量
     */
    public Vector crossProduct(Vector o) {
        double newX = y * o.z - o.y * z;
        double newY = z * o.x - o.z * x;
        double newZ = x * o.y - o.x * y;返回自身作为结果向量

        x = newX;
        y = newY;
        z = newZ;
        return this;
    }

    /**
     * 计算与给定向量的叉积,叉积的大小等同于向量积的模,方向使用右手定则判断,一般计算时使用矩阵行列式公式.
     * 其定义如下:(这里返回一个新向量)
     * <ul>
     * <li>x = y1 * z2 - y2 * z1
     * <li>y = z1 * x2 - z2 * x1
     * <li>z = x1 * y2 - x2 * y1
     * </ul>
     * <p>
     * 原文:Calculates the cross product of this vector with another without mutating
     * the original. The cross product is defined as:
     * <ul>
     * <li>x = y1 * z2 - y2 * z1
     * <li>y = z1 * x2 - z2 * x1
     * <li>z = x1 * y2 - x2 * y1
     * </ul>
     *
     * @param o 给定向量
     * @return 新向量表示叉积的结果
     */
    public Vector getCrossProduct(Vector o) {
        double x = this.y * o.z - o.y * this.z;
        double y = this.z * o.x - o.z * this.x;
        double z = this.x * o.y - o.x * this.y;
        return new Vector(x, y, z);
    }

    /**
     * 将这个向量转化为单位向量(模为1的向量).一半算法为向量数乘自己的模分之一.
     * <p>
     * 原文:Converts this vector to a unit vector (a vector with length of 1).
     *
     * @return 返回自身作为结果向量
     */
    public Vector normalize() {
        double length = length();

        x /= length;
        y /= length;
        z /= length;

        return this;
    }

    /**
     * 设置自身为0向量.
     * <p>
     * 原文:Zero this vector's components.
     *
     * @return 返回自身作为结果向量
     */
    public Vector zero() {
        x = 0;
        y = 0;
        z = 0;
        return this;
    }

    /**
     * 返回此向量是否在一个AABB(axis-aligned bounding box)包围盒中.
     * <p>
     * 在游戏中,为了简化物体之间的碰撞检测运算,通常会对物体创建一个规则的几何外形将其包围.
     * 我们称这个包围的规则几何外形叫做AABB包围盒.
     * <p>
     * 三维空间中的AABB判断是通过长方体对角线的两个点来构造一个长方体.
     * 进而判断向量的xyz坐标是否处于最小和最大之间,从而判断是否位于AABB包围盒中.
     * <p>
     * 这个最小和最大的向量必须是真的最小的xyz坐标和最大的xyz坐标,也就是说必须是能构成长方体的对角点.
     * <p>
     * 原文:Returns whether this vector is in an axis-aligned bounding box.
     * <p>
     * The minimum and maximum vectors given must be truly the minimum and
     * maximum X, Y and Z components.
     *
     * @param min 最小向量
     * @param max 最大向量
     * @return 这个向量是否在这个AABB包围盒中
     */
    public boolean isInAABB(Vector min, Vector max) {
        return x >= min.x && x <= max.x && y >= min.y && y <= max.y && z >= min.z && z <= max.z;
    }

    /**
     * 返回此向量是否在一个球形空间中.一般通过向量和点的距离同半径比较获得.
     * <p>
     * 原文:Returns whether this vector is within a sphere.
     *
     * @param origin 球心
     * @param radius 半径
     * @return 此向量是否在球形空间中
     */
    public boolean isInSphere(Vector origin, double radius) {
        return (NumberConversions.square(origin.x - x) + NumberConversions.square(origin.y - y) + NumberConversions.square(origin.z - z)) <= NumberConversions.square(radius);
    }

    /**
     * 获取X坐标.
     * <p>
     * 原文:Gets the X component.
     *
     * @return X坐标
     */
    public double getX() {
        return x;
    }

    /**
     * 获取向下取整的X坐标,这等同于获取包含这个向量的方块的X坐标.
     * <p>
     * 原文:Gets the floored value of the X component, indicating the block that
     * this vector is contained with.
     *
     * @return 方块的X坐标
     */
    public int getBlockX() {
        return NumberConversions.floor(x);
    }

    /**
     * 获取Y坐标.
     * <p>
     * 原文:Gets the Y component.
     *
     * @return Y坐标
     */
    public double getY() {
        return y;
    }

    /**
     * 获取向下取整的Y坐标,这等同于获取包含这个向量的方块的Y坐标.
     * <p>
     * 原文:Gets the floored value of the Y component, indicating the block that
     * this vector is contained with.
     *
     * @return 方块的Y坐标
     */
    public int getBlockY() {
        return NumberConversions.floor(y);
    }

    /**
     * 获取Z坐标.
     * <p>
     * 原文:Gets the Z component.
     *
     * @return Z坐标
     */
    public double getZ() {
        return z;
    }

    /**
     * 获取向下取整的Z坐标,这等同于获取包含这个向量的方块的Z坐标.
     * <p>
     * 原文:Gets the floored value of the Z component, indicating the block that
     * this vector is contained with.
     *
     * @return 方块的Z坐标
     */
    public int getBlockZ() {
        return NumberConversions.floor(z);
    }

    /**
     * 设置X坐标,参数为整数.
     * <p>
     * 原文:Set the X component.
     *
     * @param x 新的X坐标
     * @return 自身向量
     */
    public Vector setX(int x) {
        this.x = x;
        return this;
    }

    /**
     * 设置X坐标,参数为双精度浮点数.
     * <p>
     * 原文:Set the X component.
     *
     * @param x 新的X坐标
     * @return 自身向量
     */
    public Vector setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * 设置X坐标,参数为单精度浮点数.
     * <p>
     * 原文:Set the X component.
     *
     * @param x 新的X坐标
     * @return 自身向量
     */
    public Vector setX(float x) {
        this.x = x;
        return this;
    }

    /**
     * 设置Y坐标,参数为整数.
     * <p>
     * 原文:Set the Y component.
     *
     * @param y 新的Y坐标
     * @return 自身向量
     */
    public Vector setY(int y) {
        this.y = y;
        return this;
    }

    /**
     * 设置Y坐标,参数为双精度浮点数.
     * <p>
     * 原文:Set the Y component.
     *
     * @param y 新的Y坐标
     * @return 自身向量
     */
    public Vector setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * 设置Y坐标,参数为单精度浮点数.
     * <p>
     * 原文:Set the Y component.
     *
     * @param y 新的Y坐标
     * @return 自身向量
     */
    public Vector setY(float y) {
        this.y = y;
        return this;
    }

    /**
     * 设置Z坐标,参数为整数.
     * <p>
     * 原文:Set the Z component.
     *
     * @param z 新的Z坐标
     * @return 自身向量
     */
    public Vector setZ(int z) {
        this.z = z;
        return this;
    }

    /**
     * 设置Z坐标,参数为双精度浮点数.
     * <p>
     * 原文:Set the Z component.
     *
     * @param z 新的Z坐标
     * @return 自身向量
     */
    public Vector setZ(double z) {
        this.z = z;
        return this;
    }

    /**
     * 设置Z坐标,参数为单精度浮点数.
     * <p>
     * 原文:Set the Z component.
     *
     * @param z 新的Z坐标
     * @return 自身向量
     */
    public Vector setZ(float z) {
        this.z = z;
        return this;
    }

    /**
     * 检查两个对象是否相同.
     * <p>
     * 只要两个向量坐标均相同则返回true.这个函数使用一种模糊匹配来回避浮点错误.
     * 这个误差量(epsilon)可以通过自身恢复,即不会影响向量本身.
     * <p>
     * 原文:Checks to see if two objects are equal.
     * <p>
     * Only two Vectors can ever return true. This method uses a fuzzy match
     * to account for floating point errors. The epsilon can be retrieved
     * with epsilon.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector)) {
            return false;
        }

        Vector other = (Vector) obj;

        return Math.abs(x - other.x) < epsilon && Math.abs(y - other.y) < epsilon && Math.abs(z - other.z) < epsilon && (this.getClass().equals(obj.getClass()));
    }

    /**
     * 返回这个向量的哈希码.
     * <p>
     * 原文:Returns a hash code for this vector
     *
     * @return 哈希码
     */
    @Override
    public int hashCode() {
        int hash = 7;

        hash = 79 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }

    /**
     * 获取一个此向量的克隆.
     * <p>
     * 原文:Get a new vector.
     *
     * @return 新向量
     */
    @Override
    public Vector clone() {
        try {
            return (Vector) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    /**
     * 返回这个向量的坐标表示(x,y,z).
     * <p>
     * Returns this vector's components as x,y,z.
     */
    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }

    /**
     * 获取一个可作为Location的向量,
     * 其自转角(也叫偏航角,Yaw)、旋进角(也叫进动角、俯仰角,Pitch)为0.
     * <p>
     * 原文:Gets a Location version of this vector with yaw and pitch being 0.
     *
     * @param world 连接这个Location的World.
     * @return 这个Location实例
     */
    public Location toLocation(World world) {
        return new Location(world, x, y, z);
    }

    /**
     * 获取一个可作为Location的向量.
     * <p>
     * 原文:Gets a Location version of this vector.
     *
     * @param world 连接这个Location的World.
     * @param yaw 期望的自转角(也叫偏航角,Yaw).
     * @param pitch 期望的旋进角(也叫进动角、俯仰角,Pitch).
     * @return 这个Location实例
     */
    public Location toLocation(World world, float yaw, float pitch) {
        return new Location(world, x, y, z, yaw, pitch);
    }

    /**
     * 获取这个向量所在的方块的向量.
     * <p>
     * 原文:Get the block vector of this vector.
     *
     * @return 一个方块向量.
     */
    public BlockVector toBlockVector() {
        return new BlockVector(x, y, z);
    }

    /**
     * 检查向量的坐标数值是否均合法.
     * <p>
     * 原文:Check if each component of this Vector is finite.
     *
     * @throws IllegalArgumentException 如果任何一维的坐标不合法则抛出
     */
    public void checkFinite() throws IllegalArgumentException {
        NumberConversions.checkFinite(x, "x not finite");
        NumberConversions.checkFinite(y, "y not finite");
        NumberConversions.checkFinite(z, "z not finite");
    }

    /**
     * 获取近似相等的阈值,用于equals().
     * <p>
     * 原文:Get the threshold used for equals().
     *
     * @return 误差量
     */
    public static double getEpsilon() {
        return epsilon;
    }

    /**
     * 获取两个向量坐标中更小坐标的向量,即逐个比对两个向量的坐标,均取最小的那个组成一个新的向量.
     * <p>
     * 原文:Gets the minimum components of two vectors.
     *
     * @param v1 第一个向量
     * @param v2 第二个向量
     * @return 最小向量
     */
    public static Vector getMinimum(Vector v1, Vector v2) {
        return new Vector(Math.min(v1.x, v2.x), Math.min(v1.y, v2.y), Math.min(v1.z, v2.z));
    }

    /**
     * 获取两个向量坐标中更大坐标的向量,即逐个比对两个向量的坐标,均取最大的那个组成一个新的向量.
     * <p>
     * 原文:Gets the maximum components of two vectors.
     *
     * @param v1 第一个向量
     * @param v2 第二个向量
     * @return 最大向量
     */
    public static Vector getMaximum(Vector v1, Vector v2) {
        return new Vector(Math.max(v1.x, v2.x), Math.max(v1.y, v2.y), Math.max(v1.z, v2.z));
    }

    /**
     * Gets a random vector with components having a random value between 0
     * and 1.
     *
     * @return A random vector.
     */
    public static Vector getRandom() {
        return new Vector(random.nextDouble(), random.nextDouble(), random.nextDouble());
    }

    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        result.put("x", getX());
        result.put("y", getY());
        result.put("z", getZ());

        return result;
    }

    public static Vector deserialize(Map<String, Object> args) {
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

        return new Vector(x, y, z);
    }
}
