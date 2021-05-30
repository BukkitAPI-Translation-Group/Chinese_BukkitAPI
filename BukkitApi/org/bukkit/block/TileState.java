package org.bukkit.block;

import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.jetbrains.annotations.NotNull;

/**
 * 代表持有指定位置的 tile entity 的方块状态.
 *
 * 接口本身只是一个不提供任何数据的类型标记.
 *
 * 有关 tile entities 的数据由各自 tile entity 类型对应的接口提供.
 *
 * 在修改由 TileState 提供的数据后, 别忘了使用{@link #update()}来存储修改的数据.
 */
public interface TileState extends BlockState, PersistentDataHolder {

    /**
     * 返回一个可在此对象上存储标签的自定义标签容器.
     *
     * 注意:存储于此容器的标签全部存储于它们自己自定义的命名空间,
     * 因此使用本{@link PersistentDataHolder}修改默认标签是不可能的.
     * <p>
     * 本 {@link PersistentDataHolder} 对象只与由 {@link BlockState} 存储的快照实例相关联
     * (另注:实际的 tile entity 上数据更新时也不会反应到此容器中, 也就是说, 本方法获取到的容器也是一种快照).
     * 当更新存储于 {@link PersistentDataHolder} 中的内容时,
     * 更新的内容需要调用{@link #update()}方法才会应用于实际的 tile entity.
     * 
     * <p>
     * 原文:Returns a custom tag container capable of storing tags on the object.
     *
     * Note that the tags stored on this container are all stored under their
     * own custom namespace therefore modifying default tags using this
     * {@link PersistentDataHolder} is impossible.
     * <p>
     * This {@link PersistentDataHolder} is only linked to the snapshot instance
     * stored by the {@link BlockState}.
     *
     * When storing changes on the {@link PersistentDataHolder}, the updated
     * content will only be applied to the actual tile entity after one of the
     * {@link #update()} methods is called.
     *
     * @return 自定义标签容器
     */
    @NotNull
    @Override
    PersistentDataContainer getPersistentDataContainer();
}
