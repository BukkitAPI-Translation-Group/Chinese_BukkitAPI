package org.bukkit;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * RegionAccessor 提供了获取、修改和生成 {@link Biome 生物群系}、{@link BlockState 方块状态} 和 {@link Entity 实体} 的能力，
 * 同时也支持生成一些基础结构。
 */
public interface RegionAccessor {

    /**
     * 获取指定{@link Location 位置}的{@link Biome 生物群系}.
     * <p>
     * 原文:Gets the {@link Biome} at the given {@link Location}.
     *
     * @param location 位置
     * @return 此位置处的生物群系
     */
    @NotNull
    Biome getBiome(@NotNull Location location);

    /**
     * 获取指定坐标的生物群系.
     * <p>
     * 原文:Gets the {@link Biome} at the given coordinates.
     *
     * @param x 方块的x坐标
     * @param y 方块的y坐标
     * @param z 方块的z坐标
     * @return 指定坐标位置处的生物群系
     */
    @NotNull
    Biome getBiome(int x, int y, int z);

    /**
     * 设置指定{@link Location 位置}的{@link Biome 生物群系}.
     * <p>
     * 原文:Sets the {@link Biome} at the given {@link Location}.
     *
     * @param location 位置
     * @param biome 此方块的新生物群系
     */
    void setBiome(@NotNull Location location, @NotNull Biome biome);

    /**
     * 设置指定方块坐标的{@link Biome 生物群系}.
     * <p>
     * 原文：Sets the {@link Biome} for the given block coordinates.
     *
     * @param x 方块的x坐标
     * @param y 方块的y坐标
     * @param z 方块的z坐标
     * @param biome 此方块的新生物群系
     */
    void setBiome(int x, int y, int z, @NotNull Biome biome);

    /**
     * 获取指定{@link Location 位置}的{@link BlockState 方块状态}.
     * <p>
     * 原文：Gets the {@link BlockState} at the given {@link Location}.
     *
     * @param location 方块状态的位置
     * @return 指定位置的方块状态
     */
    @NotNull
    BlockState getBlockState(@NotNull Location location);

    /**
     * 获取指定坐标的{@link BlockState 方块状态}.
     * <p>
     * 原文：Gets the {@link BlockState} at the given coordinates.
     *
     * @param x 方块状态的x坐标
     * @param y 方块状态的y坐标
     * @param z 方块状态的z坐标
     * @return 指定坐标处的方块状态
     */
    @NotNull
    BlockState getBlockState(int x, int y, int z);

    /**
     * 获取指定{@link Location 位置}的{@link BlockData 方块数据}.
     * <p>
     * 原文：Gets the {@link BlockData} at the given {@link Location}.
     *
     * @param location 方块数据的位置
     * @return 指定位置的方块数据
     */
    @NotNull
    BlockData getBlockData(@NotNull Location location);

    /**
     * 获取指定坐标的{@link BlockData 方块数据}.
     * <p>
     * 原文：Gets the {@link BlockData} at the given coordinates.
     *
     * @param x 方块数据的x坐标
     * @param y 方块数据的y坐标
     * @param z 方块数据的z坐标
     * @return 指定坐标处的方块数据
     */
    @NotNull
    BlockData getBlockData(int x, int y, int z);

    /**
     * 获取指定{@link Location 位置}的方块{@link Material 类型}.
     * <p>
     * 原文：Gets the type of the block at the given {@link Location}.
     *
     * @param location 方块的位置
     * @return 指定坐标处的材质类型
     */
    @NotNull
    Material getType(@NotNull Location location);

    /**
     * 获取指定坐标的方块{@link Material 类型}.
     * <p>
     * 原文：Gets the type of the block at the given coordinates.
     *
     * @param x 方块的x坐标
     * @param y 方块的y坐标
     * @param z 方块的z坐标
     * @return 指定坐标处的材质类型
     */
    @NotNull
    Material getType(int x, int y, int z);

    /**
     * 设置指定{@link Location 位置}的{@link BlockData 方块数据}.
     * <p>
     * 原文：Sets the {@link BlockData} at the given {@link Location}.
     *
     * @param location 方块的位置
     * @param blockData 要设置的方块数据
     */
    void setBlockData(@NotNull Location location, @NotNull BlockData blockData);

    /**
     * 设置指定坐标的{@link BlockData 方块数据}.
     * <p>
     * 原文：Sets the {@link BlockData} at the given coordinates.
     *
     * @param x 方块的x坐标
     * @param y 方块的y坐标
     * @param z 方块的z坐标
     * @param blockData 要设置的方块数据
     */
    void setBlockData(int x, int y, int z, @NotNull BlockData blockData);

    /**
     * 设置指定{@link Location 位置}的{@link Material 方块类型}.
     * <p>
     * 原文：Sets the {@link Material} at the given {@link Location}.
     *
     * @param location 方块的位置
     * @param material 要设置的方块类型
     */
    void setType(@NotNull Location location, @NotNull Material material);

    /**
     * 设置指定坐标的{@link Material 方块类型}.
     * <p>
     * 原文：Sets the {@link Material} at the given coordinates.
     *
     * @param x 方块的x坐标
     * @param y 方块的y坐标
     * @param z 方块的z坐标
     * @param material 要设置的方块类型
     */
    void setType(int x, int y, int z, @NotNull Material material);

    /**
     * 在指定{@link Location 位置}创建一棵树.
     * <p>
     * 原文：Creates a tree at the given {@link Location}.
     *
     * @param location 生成树的位置
     * @param random 用于生成树的随机数生成器
     * @param type 要创建的树的类型
     * @return 如果树创建成功则返回true，否则返回false
     */
    boolean generateTree(@NotNull Location location, @NotNull Random random, @NotNull TreeType type);

    /**
     * 在指定{@link Location 位置}创建一棵树.
     * <p>
     * 提供的 consumer 会在因树木生成而改变的每个方块上调用。当 consumer 被调用时，
     * 世界尚未被修改。这意味着在 consumer 中调用 {@link #getBlockState(Location)}
     * 会返回生成前方块的状态。
     * <p>
     * 在 consumer 中对 {@link BlockState 方块状态} 的修改会被保留，
     * 因此无需调用 {@link BlockState#update()}.
     * <p>
     * 原文：Creates a tree at the given {@link Location}. The provided consumer gets called
     * for every block which gets changed as a result of the tree generation. When the consumer
     * gets called no modifications to the world are done yet. Which means, that calling
     * {@link #getBlockState(Location)} in the consumer while return the state of the block
     * before the generation. Modifications done to the {@link BlockState} in the consumer
     * are respected, which means that it is not necessary to call {@link BlockState#update()}.
     *
     * @param location 生成树的位置
     * @param random 用于生成树的随机数生成器
     * @param type 要创建的树的类型
     * @param stateConsumer 在每个被改变的方块上调用的 consumer
     * @return 如果树创建成功则返回true，否则返回false
     */
    boolean generateTree(@NotNull Location location, @NotNull Random random, @NotNull TreeType type, @Nullable Consumer<? super BlockState> stateConsumer);

    /**
     * 在指定{@link Location 位置}创建一棵树.
     * <p>
     * 提供的 predicate 会在因树木生成而改变的每个方块上调用。当 predicate 被调用时，
     * 世界尚未被修改。这意味着在 predicate 中调用 {@link #getBlockState(Location)}
     * 会返回生成前方块的状态。
     * <p>
     * 如果 predicate 返回 {@code true}，则该方块会被设置到世界中。
     * 如果返回 {@code false}，则该方块不会被设置到世界中。
     * <p>
     * 原文：Creates a tree at the given {@link Location}. The provided predicate gets called
     * for every block which gets changed as a result of the tree generation. When the predicate
     * gets called no modifications to the world are done yet. Which means, that calling
     * {@link #getBlockState(Location)} in the predicate will return the state of the block
     * before the generation. If the predicate returns {@code true} the block gets set in the
     * world. If it returns {@code false} the block won't get set in the world.
     *
     * @param location 生成树的位置
     * @param random 用于生成树的随机数生成器
     * @param type 要创建的树的类型
     * @param statePredicate 用于测试是否应设置方块的 predicate
     * @return 如果树创建成功则返回true，否则返回false
     */
    boolean generateTree(@NotNull Location location, @NotNull Random random, @NotNull TreeType type, @Nullable Predicate<? super BlockState> statePredicate);

    /**
     * 在指定的{@link Location 位置}创建一个实体.
     * <p>
     * 原文：
     * Creates a entity at the given {@link Location}
     *
     * @param location 生成实体的位置
     * @param type 生成的实体
     * @return 生成成功则返回此方法创建的实体
     */
    @NotNull
    Entity spawnEntity(@NotNull Location location, @NotNull EntityType type);

    /**
     * 在指定{@link Location 位置}创建一个新实体.
     * <p>
     * 原文：Creates a new entity at the given {@link Location}.
     *
     * @param loc 实体将被生成的位置
     * @param type 决定要生成的实体类型的实体类型
     * @param randomizeData 是否应在生成前随机化实体的数据。默认情况下，实体在生成前会根据其装备、年龄、
     *                      属性等进行随机化。随机化的例子包括羊的颜色、怪物装备上的随机附魔，
     *                      甚至僵尸成为骑鸡小僵尸。如果设置为false，实体在生成前不会被随机化，
     *                      这意味着它们的所有数据将保持默认状态，不会对实体进行进一步修改。
     *                      值得注意的是，只有继承 {@link org.bukkit.entity.Mob} 接口的实体
     *                      才提供生成随机化逻辑，因此此参数对其他类型的实体无效。
     * @return 生成的实体实例
     */
    @NotNull
    public Entity spawnEntity(@NotNull Location loc, @NotNull EntityType type, boolean randomizeData);

    /**
     * 获取此 RegionAccessor 中所有实体的列表.
     * <p>
     * 原文：Get a list of all entities in this RegionAccessor.
     *
     * @return 当前驻留在此世界访问器中的所有实体的列表
     */
    @NotNull
    List<Entity> getEntities();

    /**
     * 获取此 RegionAccessor 中所有生物实体的列表.
     * <p>
     * 原文：Get a list of all living entities in this RegionAccessor.
     *
     * @return 当前驻留在此世界访问器中的所有生物实体的列表
     */
    @NotNull
    List<LivingEntity> getLivingEntities();

    /**
     * 获取此 RegionAccessor 中匹配给定类/接口的所有实体的集合.
     * <p>
     * 原文：Get a collection of all entities in this RegionAccessor matching the given class/interface.
     *
     * @param <T> 实体子类
     * @param cls 表示要匹配的实体类型的类
     * @return 当前驻留在此世界访问器中的所有匹配给定类/接口的实体的列表
     */
    @NotNull
    <T extends Entity> Collection<T> getEntitiesByClass(@NotNull Class<T> cls);

    /**
     * 获取此 RegionAccessor 中匹配给定任意类/接口的所有实体的集合.
     * <p>
     * 原文：Get a collection of all entities in this RegionAccessor matching any of the given classes/interfaces.
     *
     * @param classes 表示要匹配的实体类型的类
     * @return 当前驻留在此世界访问器中的所有匹配给定一个或多个类/接口的实体的列表
     */
    @NotNull
    Collection<Entity> getEntitiesByClasses(@NotNull Class<?>... classes);

    /**
     * 在指定{@link Location 位置}创建一个特定类的实体，但不会将其生成到世界中.
     * <p>
     * <b>注意：</b>创建的实体会保持对其创建时所在世界的引用，
     * 应注意确保实体的生命周期不超过世界实例，否则会导致内存泄漏。
     * <p>
     * 原文：Creates an entity of a specific class at the given {@link Location} but
     * does not spawn it in the world. Note: The created entity keeps a reference
     * to the world it was created in, care should be taken that the entity does
     * not outlive the world instance as this will lead to memory leaks.
     *
     * @param <T> 要创建的{@link Entity 实体}的类
     * @param location 创建实体的{@link Location 位置}
     * @param clazz 要生成的{@link Entity 实体}的类
     * @return 创建的{@link Entity 实体}实例
     * @see #addEntity(Entity)
     * @see Entity#createSnapshot()
     */
    @NotNull
    <T extends Entity> T createEntity(@NotNull Location location, @NotNull Class<T> clazz);

    /**
     * 在指定的{@link Location 位置}根据给定的类生成一个实体.
     * <p>
     * 原文:Spawn an entity of a specific class at the given {@link Location}
     *
     * @param location 生成实体的{@link Location 位置}
     * @param clazz 生成{@link Entity 实体}的类
     * @param <T> 生成{@link Entity 实体}的类
     * @return 一个生成的{@link Entity 实体}实例
     * @throws IllegalArgumentException 如果参数为空或被要求生成的{@link Entity 实体}不能被生成则抛出错误
     */
    @NotNull
    <T extends Entity> T spawn(@NotNull Location location, @NotNull Class<T> clazz) throws IllegalArgumentException;

    /**
     * 在指定{@link Location 位置}根据给定的类生成一个实体，并在实体被添加到世界之前运行提供的函数.
     * <br>
     * 请注意，当函数运行时，实体实际上尚未进入世界。在此函数返回之前，
     * 任何涉及传送实体等操作都是未定义的。
     * <p>
     * 原文：Spawn an entity of a specific class at the given {@link Location}, with
     * the supplied function run before the entity is added to the world. Note that
     * when the function is run, the entity will not be actually in the world. Any
     * operation involving such as teleporting the entity is undefined until after
     * this function returns.
     *
     * @param location 生成实体的{@link Location 位置}
     * @param clazz 要生成的{@link Entity 实体}的类
     * @param function 在实体生成前运行的函数
     * @param <T> 要生成的{@link Entity 实体}的类
     * @return 生成的{@link Entity 实体}实例
     * @throws IllegalArgumentException 如果参数为空或被要求生成的{@link Entity 实体}不能被生成则抛出错误
     */
    @NotNull
    <T extends Entity> T spawn(@NotNull Location location, @NotNull Class<T> clazz, @Nullable Consumer<? super T> function) throws IllegalArgumentException;

    /**
     * 在指定{@link Location 位置}创建一个新实体.
     * <p>
     * 提供的函数会在实体被添加到世界之前运行。
     * <br>
     * 请注意，当函数运行时，实体实际上尚未进入世界。在此函数返回之前，
     * 任何涉及传送实体等操作都是未定义的。
     * 传入的函数在潜在的实体生成随机化之后运行，因此已经允许访问 mob 的值，
     * 无论这些值是否已被随机化，例如属性或实体装备。
     * <p>
     * 原文：Creates a new entity at the given {@link Location} with the supplied function
     * run before the entity is added to the world. Note that when the function is run,
     * the entity will not be actually in the world. Any operation involving such as teleporting
     * the entity is undefined until after this function returns. The passed function however
     * is run after the potential entity's spawn randomization and hence already allows access
     * to the values of the mob, whether or not those were randomized, such as attributes
     * or the entity equipment.
     *
     * @param location 实体将被生成的位置
     * @param clazz 要生成的{@link Entity 实体}的类
     * @param randomizeData 是否应在生成前随机化实体的数据。默认情况下，实体在生成前会根据其装备、年龄、
     *                      属性等进行随机化。随机化的例子包括羊的颜色、怪物装备上的随机附魔，
     *                      甚至僵尸成为骑鸡小僵尸。如果设置为false，实体在生成前不会被随机化，
     *                      这意味着它们的所有数据将保持默认状态，不会对实体进行进一步修改。
     *                      值得注意的是，只有继承 {@link org.bukkit.entity.Mob} 接口的实体
     *                      才提供生成随机化逻辑，因此此参数对其他类型的实体无效。
     * @param function 在实体生成前运行的函数
     * @param <T> 要生成的{@link Entity 实体}的泛型类型
     * @return 生成的实体实例
     * @throws IllegalArgumentException 如果 world 或 clazz 参数为空
     */
    @NotNull
    public <T extends Entity> T spawn(@NotNull Location location, @NotNull Class<T> clazz, boolean randomizeData, @Nullable Consumer<? super T> function) throws IllegalArgumentException;

    /**
     * 获取指定坐标处最高非空（不可通过）方块的坐标.
     * <p>
     * 原文：Gets the highest non-empty (impassable) coordinate at the given coordinates.
     *
     * @param x 方块的x坐标
     * @param z 方块的z坐标
     * @return 最高非空方块的y坐标
     */
    public int getHighestBlockYAt(int x, int z);

    /**
     * 获取指定{@link Location 位置}处最高非空（不可通过）方块的坐标.
     * <p>
     * 原文：Gets the highest non-empty (impassable) coordinate at the given {@link Location}.
     *
     * @param location 方块的位置
     * @return 最高非空方块的y坐标
     */
    public int getHighestBlockYAt(@NotNull Location location);

    /**
     * 获取指定坐标处对应于{@link HeightMap 高度图}的最高坐标.
     * <p>
     * 原文：Gets the highest coordinate corresponding to the {@link HeightMap} at the given coordinates.
     *
     * @param x 方块的x坐标
     * @param z 方块的z坐标
     * @param heightMap 用于确定最高点的高度图
     * @return 对应于{@link HeightMap 高度图}的最高方块的y坐标
     */
    public int getHighestBlockYAt(int x, int z, @NotNull HeightMap heightMap);

    /**
     * 获取指定{@link Location 位置}处对应于{@link HeightMap 高度图}的最高坐标.
     * <p>
     * 原文：Gets the highest coordinate corresponding to the {@link HeightMap} at the given {@link Location}.
     *
     * @param location 方块的位置
     * @param heightMap 用于确定最高点的高度图
     * @return 对应于{@link HeightMap 高度图}的最高方块的y坐标
     */
    public int getHighestBlockYAt(@NotNull Location location, @NotNull HeightMap heightMap);

    /**
     * 在世界中生成一个先前创建的实体.
     * <br>
     * 提供的实体必须尚未在世界中生成。
     * <p>
     * 原文：Spawns a previously created entity in the world. The provided entity must not have already been spawned in a world.
     *
     * @param <T> 要添加的实体的泛型类型
     * @param entity 要添加的实体
     * @return 现在位于世界中的实体
     */
    @NotNull
    public <T extends Entity> T addEntity(@NotNull T entity);
}
