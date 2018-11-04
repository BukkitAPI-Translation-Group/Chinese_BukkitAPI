package org.bukkit;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;

/**
 * 世界中的三维位置,包含x,y,z.
 * <br>
 * 除了角度制只能是以度数为单位的限制外, 不对任何角度值施加任何约束.
 * 这意味着负的角度值或大于360°的角度值也是有效的, 但可以将它们转化为其它任何等效的表示.
 * <br>
 * 译注:yaw和pitch分别代表自转角(又称偏航角)、旋进角(又称进动角、俯仰角).
 * 两个值一起表示位置的朝向(与向量的概念重合, 本类有很多方法就是与{@link org.bukkit.util.Vector}重合的).
 * 这里的翻译分别取偏航角、俯仰角.另请参见util包下的Vector(向量)、EulerAngle(欧拉角), 阅读本文档及其相关文档
 * 建议您具备高中数学必修4相关知识.
 */
public class Location implements Cloneable, ConfigurationSerializable {
    private World world;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;

    /**
     * 以给定的坐标构造一个Location对象.
     * <p>
     * 原文:Constructs a new Location with the given coordinates
     *
     * @param world 位置所在世界
     * @param x 位置x轴坐标
     * @param y 位置y轴坐标
     * @param z 位置z轴坐标
     */
    public Location(final World world, final double x, final double y, final double z) {
        this(world, x, y, z, 0, 0);
    }

    /**
     * 以给定的坐标和朝向构造一个Location对象.
     * <p>
     * 原文:Constructs a new Location with the given coordinates and direction
     *
     * @param world 位置所在世界
     * @param x 位置x轴坐标
     * @param y 位置y轴坐标
     * @param z 位置z轴坐标
     * @param yaw x轴平面上的绝对的旋转角度, 以度为单位
     * @param pitch y轴平面上的绝对的旋转角度, 以度为单位
     */
    public Location(final World world, final double x, final double y, final double z, final float yaw, final float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    /**
     * 设置本位置所在的世界.
     * <p>
     * 原文:Sets the world that this location resides in
     *
     * @param world 位置所在的新世界
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * 获取本位置所在的世界.
     * <p>
     * 原文:Gets the world that this location resides in
     *
     * @return 世界
     */
    public World getWorld() {
        return world;
    }

    /**
     * 获取此位置位于哪一区块.
     * <p>
     * 原文:Gets the chunk at the represented location
     *
     * @return 本位置所在区块
     */
    public Chunk getChunk() {
        return world.getChunkAt(this);
    }

    /**
     * 获取本位置对应的方块.
     * <p>
     * 原文:Gets the block at the represented location
     *
     * @return 所在位置对应的方块
     */
    public Block getBlock() {
        return world.getBlockAt(this);
    }

    /**
     * 设置本位置的x轴坐标.
     * <p>
     * 原文:Sets the x-coordinate of this location
     *
     * @param x x轴坐标
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * 获取本位置的x轴坐标.
     * <p>
     * 原文:Gets the x-coordinate of this location
     *
     * @return x轴坐标
     */
    public double getX() {
        return x;
    }

    /**
     * 获取向下取整的x轴坐标, 表示本位置包含的方块.
     * <p>
     * 原文:Gets the floored value of the X component, indicating the block that
     * this location is contained with.
     *
     * @return 方块x轴坐标
     */
    public int getBlockX() {
        return locToBlock(x);
    }

    /**
     * 设置本位置的y轴坐标.
     * <p>
     * 原文:Sets the y-coordinate of this location
     *
     * @param y y轴坐标
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * 获取本位置的y轴坐标.
     * <p>
     * 原文:Gets the y-coordinate of this location
     *
     * @return y轴坐标
     */
    public double getY() {
        return y;
    }

    /**
     * 获取向下取整的y轴坐标, 表示本位置包含的方块.
     * <p>
     * 原文:Gets the floored value of the Y component, indicating the block that
     * this location is contained with.
     *
     * @return 方块y轴坐标
     */
    public int getBlockY() {
        return locToBlock(y);
    }

    /**
     * 设置本位置的z坐标轴.
     * <p>
     * 原文:Sets the z-coordinate of this location
     *
     * @param z z坐标轴
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * 获取本位置的z坐标轴.
     * <p>
     * 原文:Gets the z-coordinate of this location
     *
     * @return z坐标轴
     */
    public double getZ() {
        return z;
    }

    /**
     * 获取向下取整的z轴坐标, 表示本位置包含的方块.
     * <p>
     * 原文:Gets the floored value of the Z component, indicating the block that
     * this location is contained with.
     *
     * @return 方块z轴坐标
     */
    public int getBlockZ() {
        return locToBlock(z);
    }

    /**
     * 设置本位置的偏航角(yaw), 以度为单位.
     * <ul>
     * <li>偏航角为0或360°时表示z轴正方向.
     * <li>偏航角为180°时表示z轴负方向.
     * <li>偏航角为90°时表示x轴负方向.
     * <li>偏航角为270°时表示x轴正方向.
     * </ul>
     * 增加偏航角值相当于使你转向右侧,
     * 增加偏向下一个坐标轴的比例并减少偏向前一个轴的比例.
     * <p>
     * 原文:Sets the yaw of this location, measured in degrees.
     * <ul>
     * <li>A yaw of 0 or 360 represents the positive z direction.
     * <li>A yaw of 180 represents the negative z direction.
     * <li>A yaw of 90 represents the negative x direction.
     * <li>A yaw of 270 represents the positive x direction.
     * </ul>
     * Increasing yaw values are the equivalent of turning to your
     * right-facing, increasing the scale of the next respective axis, and
     * decreasing the scale of the previous axis.
     *
     * @param yaw 自转角(偏航角)
     */
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    /**
     * 获取本位置的偏航角(yaw), 以度为单位.
     * <ul>
     * <li>偏航角为0或360°时表示z轴正方向.
     * <li>偏航角为180°时表示z轴负方向.
     * <li>偏航角为90°时表示x轴负方向.
     * <li>偏航角为270°时表示x轴正方向.
     * </ul>
     * 增加偏航角值相当于使你转向右侧,
     * 增加偏向下一个坐标轴的比例并减少偏向前一个轴的比例.
     * <p>
     * 原文:Gets the yaw of this location, measured in degrees.
     * <ul>
     * <li>A yaw of 0 or 360 represents the positive z direction.
     * <li>A yaw of 180 represents the negative z direction.
     * <li>A yaw of 90 represents the negative x direction.
     * <li>A yaw of 270 represents the positive x direction.
     * </ul>
     * Increasing yaw values are the equivalent of turning to your
     * right-facing, increasing the scale of the next respective axis, and
     * decreasing the scale of the previous axis.
     *
     * @return 自转角(偏航角)
     */
    public float getYaw() {
        return yaw;
    }

    /**
     * 设置本位置的俯仰角(pitch), 以度为单位.
     * <ul>
     * <li>俯仰角为0时表示水平朝向.
     * <li>俯仰角为90°时表示向下的朝向,或y轴的负方向
     * <li>俯仰角为-90°时表示向上的朝向,或y轴的正方向
     * </ul>
     * 增加俯仰角值相当于俯视的效果.
     * <p>
     * 原文:Sets the pitch of this location, measured in degrees.
     * <ul>
     * <li>A pitch of 0 represents level forward facing.
     * <li>A pitch of 90 represents downward facing, or negative y
     *     direction.
     * <li>A pitch of -90 represents upward facing, or positive y direction.
     * </ul>
     * Increasing pitch values the equivalent of looking down.
     *
     * @param pitch 倾斜角(俯仰角)
     */
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    /**
     * 获取本位置的俯仰角(pitch), 以度为单位.
     * <ul>
     * <li>俯仰角为0时表示水平朝向.
     * <li>俯仰角为90°时表示向下的朝向,或y轴的负方向
     * <li>俯仰角为-90°时表示向上的朝向,或y轴的正方向
     * </ul>
     * 增加俯仰角值相当于俯视的效果.
     * <p>
     * 原文:Gets the pitch of this location, measured in degrees.
     * <ul>
     * <li>A pitch of 0 represents level forward facing.
     * <li>A pitch of 90 represents downward facing, or negative y
     *     direction.
     * <li>A pitch of -90 represents upward facing, or positive y direction.
     * </ul>
     * Increasing pitch values the equivalent of looking down.
     *
     * @return 倾斜角(俯仰角)
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * 获取本位置所面向的方向的单位向量.
     * <p>
     * 原文:Gets a unit-vector pointing in the direction that this Location is
     * facing.
     *
     * @return 指向此位置的{@link
     *     #getPitch() 偏航角}和{@link #getYaw() 俯仰角}的向量
     */
    public Vector getDirection() {
        Vector vector = new Vector();

        double rotX = this.getYaw();
        double rotY = this.getPitch();

        vector.setY(-Math.sin(Math.toRadians(rotY)));

        double xz = Math.cos(Math.toRadians(rotY));

        vector.setX(-xz * Math.sin(Math.toRadians(rotX)));
        vector.setZ(xz * Math.cos(Math.toRadians(rotX)));

        return vector;
    }

    /**
     * 将{@link #getYaw() 偏航角}和{@link #getPitch() 俯仰角}设为指向某一向量的方向.
     * <p>
     * 原文:Sets the {@link #getYaw() yaw} and {@link #getPitch() pitch} to point
     * in the direction of the vector.
     * 
     * @param vector 方向向量
     * @return 相同的位置对象(不是位置相同,但位置对象相同)
     */
    public Location setDirection(Vector vector) {
        /*
         * Sin = Opp / Hyp
         * Cos = Adj / Hyp
         * Tan = Opp / Adj
         *
         * x = -Opp
         * z = Adj
         */
        final double _2PI = 2 * Math.PI;
        final double x = vector.getX();
        final double z = vector.getZ();

        if (x == 0 && z == 0) {
            pitch = vector.getY() > 0 ? -90 : 90;
            return this;
        }

        double theta = Math.atan2(-x, z);
        yaw = (float) Math.toDegrees((theta + _2PI) % _2PI);

        double x2 = NumberConversions.square(x);
        double z2 = NumberConversions.square(z);
        double xz = Math.sqrt(x2 + z2);
        pitch = (float) Math.toDegrees(Math.atan(-vector.getY() / xz));

        return this;
    }

    /**
     * 将本位置的坐标加上另一个位置的坐标.
     * <p>
     * 原文:Adds the location by another.
     *
     * @see Vector
     * @param vec 另一个位置
     * @return 相同的位置对象(不是位置相同,但位置对象相同)
     * @throws IllegalArgumentException 若两个位置所处世界各不相同
     */
    public Location add(Location vec) {
        if (vec == null || vec.getWorld() != getWorld()) {
            throw new IllegalArgumentException("Cannot add Locations of differing worlds");
        }

        x += vec.x;
        y += vec.y;
        z += vec.z;
        return this;
    }

    /**
     * 将本位置的坐标加上一个向量的坐标.
     * <p>
     * 原文:Adds the location by a vector.
     *
     * @see Vector
     * @param vec 向量
     * @return 相同的位置对象(不是位置相同,但位置对象相同)
     */
    public Location add(Vector vec) {
        this.x += vec.getX();
        this.y += vec.getY();
        this.z += vec.getZ();
        return this;
    }

    /**
     * 将本位置的坐标加上另一个位置的坐标. 与位置所处世界无关.
     * <p>
     * 原文:Adds the location by another. Not world-aware.
     *
     * @see Vector
     * @param x X坐标
     * @param y Y坐标
     * @param z Z坐标
     * @return 相同的位置对象(不是位置相同,但位置对象相同)
     */
    public Location add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    /**
     * 将本位置的坐标减去另一个位置的坐标.
     * <p>
     * 原文:Subtracts the location by another.
     *
     * @see Vector
     * @param vec 另一个位置
     * @return 相同的位置对象(不是位置相同,但位置对象相同)
     * @throws IllegalArgumentException 若两个位置所处世界各不相同
     */
    public Location subtract(Location vec) {
        if (vec == null || vec.getWorld() != getWorld()) {
            throw new IllegalArgumentException("Cannot add Locations of differing worlds");
        }

        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }

    /**
     * 从本位置的坐标中减去向量的坐标.
     * <p>
     * 原文:Subtracts the location by a vector.
     *
     * @see Vector
     * @param vec 向量
     * @return 相同的位置对象(不是位置相同,但位置对象相同)
     */
    public Location subtract(Vector vec) {
        this.x -= vec.getX();
        this.y -= vec.getY();
        this.z -= vec.getZ();
        return this;
    }

    /**
     * 从本位置的坐标中减去另一个位置的坐标.
     * 与位置所处世界无关且其方向角独立不参与运算.
     * <p>
     * 原文:Subtracts the location by another. Not world-aware and
     * orientation independent.
     *
     * @see Vector
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @return the same location
     */
    public Location subtract(double x, double y, double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    /**
     * 获取位置的模值,定义为 sqrt(x^2+y^2+z^2).
     * 这个方法的返回值没有被缓存,且使用了开销较大的平方以及开根函数,
     * 所以不要反复调用这个方法来获取向量的模值.
     * 当向量的模过大时,开根函数有可能发生溢出,并会返回{@link Double#NaN}.
     * 与位置所处世界无关且其方向角独立不参与运算.
     * <p>
     * 原文:Gets the magnitude of the location, defined as sqrt(x^2+y^2+z^2). The
     * value of this method is not cached and uses a costly square-root
     * function, so do not repeatedly call this method to get the location's
     * magnitude. NaN will be returned if the inner result of the sqrt()
     * function overflows, which will be caused if the length is too long. Not
     * world-aware and orientation independent.
     *
     * @see Vector
     * @return 模
     */
    public double length() {
        return Math.sqrt(NumberConversions.square(x) + NumberConversions.square(y) + NumberConversions.square(z));
    }

    /**
     * 获取位置长度(又称模)的平方 (三个坐标分别平方然后加起来).
     * 与位置所处世界无关且其方向角独立不参与运算.
     * <p>
     * 原文:Gets the magnitude of the location squared. Not world-aware and
     * orientation independent.
     *
     * @see Vector
     * @return 模的平方
     */
    public double lengthSquared() {
        return NumberConversions.square(x) + NumberConversions.square(y) + NumberConversions.square(z);
    }

    /**
     * 获取本位置与与另一个位置之间的距离. 
     * 这个方法的返回值没有被缓存,且使用了开销较大的平方以及开根函数,
     * 所以不要反复调用这个方法来获取位置的模值.
     * 当位置的距离过大时,开根函数有可能发生溢出,并会返回{@link Double#NaN}.
     * <p>
     * 原文:Get the distance between this location and another. The value of this
     * method is not cached and uses a costly square-root function, so do not
     * repeatedly call this method to get the location's magnitude. NaN will
     * be returned if the inner result of the sqrt() function overflows, which
     * will be caused if the distance is too long.
     *
     * @see Vector
     * @param o The other location
     * @return the distance
     * @throws IllegalArgumentException for differing worlds
     */
    public double distance(Location o) {
        return Math.sqrt(distanceSquared(o));
    }

    /**
     * 获取本位置与与另一个位置之间的距离的平方.
     * <p>
     * 原文:Get the squared distance between this location and another.
     *
     * @see Vector
     * @param o 另一个位置
     * @return 距离的平方
     * @throws IllegalArgumentException 若两个位置所处世界各不相同
     */
    public double distanceSquared(Location o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null location");
        } else if (o.getWorld() == null || getWorld() == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null world");
        } else if (o.getWorld() != getWorld()) {
            throw new IllegalArgumentException("Cannot measure distance between " + getWorld().getName() + " and " + o.getWorld().getName());
        }

        return NumberConversions.square(x - o.x) + NumberConversions.square(y - o.y) + NumberConversions.square(z - o.z);
    }

    /**
     * 坐标数乘, 将所有坐标轴上扩展某个倍数.
     * <p>
     * 原文:Performs scalar multiplication, multiplying all components with a
     * scalar. Not world-aware.
     *
     * @param m 因数,即数乘的倍数,整数
     * @see Vector
     * @return 相同的位置对象(不是位置相同,但位置对象相同)
     */
    public Location multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    /**
     * 清零此位置的xyz坐标数值. 与位置所处世界无关.
     * <p>
     * 原文:Zero this location's components. Not world-aware.
     *
     * @see Vector
     * @return 相同的位置对象(不是位置相同,但位置对象相同)
     */
    public Location zero() {
        x = 0;
        y = 0;
        z = 0;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;

        if (this.world != other.world && (this.world == null || !this.world.equals(other.world))) {
            return false;
        }
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        if (Float.floatToIntBits(this.pitch) != Float.floatToIntBits(other.pitch)) {
            return false;
        }
        if (Float.floatToIntBits(this.yaw) != Float.floatToIntBits(other.yaw)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 19 * hash + (this.world != null ? this.world.hashCode() : 0);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        hash = 19 * hash + Float.floatToIntBits(this.pitch);
        hash = 19 * hash + Float.floatToIntBits(this.yaw);
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "world=" + world + ",x=" + x + ",y=" + y + ",z=" + z + ",pitch=" + pitch + ",yaw=" + yaw + '}';
    }

    /**
     * 基于此位置构造一个新的{@link Vector 向量}.
     * <p>
     * 原文:Constructs a new {@link Vector} based on this Location
     *
     * @return 包含该位置坐标的向量表示
     */
    public Vector toVector() {
        return new Vector(x, y, z);
    }

    @Override
    public Location clone() {
        try {
            return (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    /**
     * 检测该Location的xyz坐标和偏航角、俯仰角是否合法
     * (限制的最大值为Double.MAX_VALUE).
     * <p>
     * 原文:Check if each component of this Location is finite.
     *
     * @throws IllegalArgumentException 若有任意一个坐标/角度值不合法时抛出
     */
    public void checkFinite() throws IllegalArgumentException {
        NumberConversions.checkFinite(x, "x not finite");
        NumberConversions.checkFinite(y, "y not finite");
        NumberConversions.checkFinite(z, "z not finite");
        NumberConversions.checkFinite(pitch, "pitch not finite");
        NumberConversions.checkFinite(yaw, "yaw not finite");
    }

    /**
     * 把double类型数值(位置坐标)安全地转换为int类型数值(方块坐标).
     * <p>
     * 原文:Safely converts a double (location coordinate) to an int (block
     * coordinate)
     *
     * @param loc 精确坐标
     * @return 方块坐标
     */
    public static int locToBlock(double loc) {
        return NumberConversions.floor(loc);
    }

    @Utility
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("world", this.world.getName());

        data.put("x", this.x);
        data.put("y", this.y);
        data.put("z", this.z);

        data.put("yaw", this.yaw);
        data.put("pitch", this.pitch);

        return data;
    }

    /**
     * 实现配置序列化与反序列化所需方法.
     * <p>
     * 原文:Required method for deserialization
     *
     * @param args 需要反序列化的map
     * @return 反序列化后的位置
     * @throws IllegalArgumentException 如果位置所处世界不存在
     * @see ConfigurationSerializable
     */
    public static Location deserialize(Map<String, Object> args) {
        World world = Bukkit.getWorld((String) args.get("world"));
        if (world == null) {
            throw new IllegalArgumentException("unknown world");
        }

        return new Location(world, NumberConversions.toDouble(args.get("x")), NumberConversions.toDouble(args.get("y")), NumberConversions.toDouble(args.get("z")), NumberConversions.toFloat(args.get("yaw")), NumberConversions.toFloat(args.get("pitch")));
    }
}