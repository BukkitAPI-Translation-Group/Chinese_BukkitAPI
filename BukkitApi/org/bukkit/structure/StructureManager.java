package org.bukkit.structure;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface StructureManager {

    /**
     * 获取当前已注册的结构。
     * <p>
     * 原文：
     * Gets the currently registered structures.
     * <p>
     * These are the currently loaded structures that the StructureManager is
     * aware of. When a structure block refers to a structure, these structures
     * are checked first. If the specified structure is not found among the
     * currently registered structures, the StructureManager may dynamically
     * read the structure from the primary world folder, DataPacks, or the
     * server's own resources. Structures can be registered via {@link
     * #registerStructure(NamespacedKey, Structure)}
     *
     * @return 当前已注册结构的不可修改的浅拷贝。
     */
    @NotNull
    Map<NamespacedKey, Structure> getStructures();

    /**
     * 获取已注册的结构。
     * <p>
     * 原文：
     * Gets a registered Structure.
     *
     * @param structureKey 要获取结构的键。
     * @return 属于该键的结构，如果没有注册该键的结构则返回 <code>null</code>。
     */
    @Nullable
    Structure getStructure(@NotNull NamespacedKey structureKey);

    /**
     * 注册给定的结构。参见 {@link #getStructures()}。
     * <p>
     * 原文：
     * Registers the given structure. See {@link #getStructures()}.
     *
     * @param structureKey 要注册结构的键。
     * @param structure 要注册的结构。
     * @return 指定键的结构，如果找不到结构则返回 <code>null</code>。
     */
    @Nullable
    Structure registerStructure(@NotNull NamespacedKey structureKey, @NotNull Structure structure);

    /**
     * 注销结构。注销指定的结构。如果结构仍然存在于主世界文件夹、数据包中，
     * 或是服务器自身资源的一部分，当插件或服务器本身请求时，它可能会被重新加载和注册。
     * <p>
     * 原文：
     * Unregisters a structure. Unregisters the specified structure. If the
     * structure still exists in the primary world folder, a DataPack, or is
     * part of the server's own resources, it may be loaded and registered again
     * when it is requested by a plugin or the server itself.
     *
     * @param structureKey 要注销结构的键。
     * @return 该键注册的结构，如果没有则返回 <code>null</code>。
     */
    @Nullable
    Structure unregisterStructure(@NotNull NamespacedKey structureKey);

    /**
     * 为指定键加载结构，并可选择 {@link #registerStructure(NamespacedKey, Structure) 注册} 它。
     * <p>
     * 原文：
     * Loads a structure for the specified key and optionally {@link
     * #registerStructure(NamespacedKey, Structure) registers} it.
     * <p>
     * This will first check the already loaded {@link #getStructures()
     * registered structures}, and otherwise load the structure from the primary
     * world folder, DataPacks, and the server's own resources (in this order).
     * <p>
     * When loading the structure from the primary world folder, the given key
     * is translated to a file as specified by
     * {@link #getStructureFile(NamespacedKey)}.
     *
     * @param structureKey 要加载结构的键。
     * @param register 是否注册加载的结构。
     * @return 结构，如果未找到指定键的结构则返回 <code>null</code>。
     */
    @Nullable
    Structure loadStructure(@NotNull NamespacedKey structureKey, boolean register);

    /**
     * 加载指定键的结构并自动注册它。参见 {@link #loadStructure(NamespacedKey, boolean)}。
     * <p>
     * 原文：
     * Loads the structure for the specified key and automatically registers it.
     * See {@link #loadStructure(NamespacedKey, boolean)}.
     *
     * @param structureKey 要加载结构的键。
     * @return 指定键的结构，如果找不到结构则返回 <code>null</code>。
     */
    @Nullable
    Structure loadStructure(@NotNull NamespacedKey structureKey);

    /**
     * 将当前 {@link #getStructures() 已注册的结构} 保存到主世界文件夹，
     * 按照 {#getStructureFile(NamespacedKey} 指定的方式。
     * <p>
     * 原文：
     * Saves the currently {@link #getStructures() registered structure} for the
     * specified {@link NamespacedKey key} to the primary world folder as
     * specified by {#getStructureFile(NamespacedKey}.
     *
     * @param structureKey 要保存结构的键。
     */
    void saveStructure(@NotNull NamespacedKey structureKey);

    /**
     * 将具有给定键的结构保存到主世界文件夹。
     * <p>
     * 原文：
     * Saves a structure with a given key to the primary world folder.
     *
     * @param structureKey 要保存结构的键。
     * @param structure 要为此键保存的结构。
     */
    void saveStructure(@NotNull NamespacedKey structureKey, @NotNull Structure structure) throws IOException;

    /**
     * 注销指定结构并从主世界文件夹中删除其 {@link #getStructureFile(NamespacedKey) 结构文件}。
     * 注意：此方法不能用于删除原版 Minecraft 结构或数据包中的结构。但注销这些结构是可以的。
     * <p>
     * 原文：
     * Unregisters the specified structure and deletes its {@link
     * #getStructureFile(NamespacedKey) structure file} from the primary world
     * folder. Note that this method cannot be used to delete vanilla Minecraft
     * structures, or structures from DataPacks. Unregistering these structures
     * will however work fine.
     *
     * @param structureKey 要删除的结构的键。
     * @throws IOException 如果文件因某种原因无法删除。
     */
    void deleteStructure(@NotNull NamespacedKey structureKey) throws IOException;

    /**
     * 从主世界文件夹中删除指定结构的 {@link #getStructureFile(NamespacedKey) 结构文件}。
     * 注意：此方法不能用于删除原版 Minecraft 结构或数据包中的结构。但注销这些结构是可以的。
     * <p>
     * 原文：
     * Deletes the {@link #getStructureFile(NamespacedKey) structure file} for
     * the specified structure from the primary world folder. Note that this
     * method cannot be used to delete vanilla Minecraft structures, or
     * structures from DataPacks. Unregistering these structures will however
     * work fine.
     *
     * @param structureKey 要删除的结构的键。
     * @param unregister 是否同时注销当前已加载的指定结构。
     * @throws IOException 如果文件因某种原因无法删除。
     */
    void deleteStructure(@NotNull NamespacedKey structureKey, boolean unregister) throws IOException;

    /**
     * 根据 NamespacedKey 获取结构文件在主世界目录中的位置，使用格式
     * world/generated/{NAMESPACE}/structures/{KEY}.nbt。此方法总是返回一个文件，
     * 即使当前不存在。
     * <p>
     * 原文：
     * Gets the location where a structure file would exist in the primary world
     * directory based on the NamespacedKey using the format
     * world/generated/{NAMESPACE}/structures/{KEY}.nbt. This method will always
     * return a file, even if none exists at the moment.
     *
     * @param structureKey 用于构建文件路径的键。
     * @return 该键对应的文件位置。
     */
    @NotNull
    File getStructureFile(@NotNull NamespacedKey structureKey);

    /**
     * 从磁盘读取结构。
     * <p>
     * 原文：
     * Reads a Structure from disk.
     *
     * @param file 结构的文件。
     * @return 读取的结构。
     * @throws IOException 当给定文件无法读取时。
     */
    @NotNull
    Structure loadStructure(@NotNull File file) throws IOException;

    /**
     * 从流中读取结构。
     * <p>
     * 原文：
     * Reads a Structure from a stream.
     *
     * @param inputStream 结构的输入流。
     * @return 读取的结构。
     */
    @NotNull
    Structure loadStructure(@NotNull InputStream inputStream) throws IOException;

    /**
     * 将结构保存到文件。如果文件已存在，将被覆盖.
     * <p>
     * 原文：
     * Save a structure to a file. This will overwrite a file if it already
     * exists.
     *
     * @param file 要保存到的目标文件.
     * @param structure 要保存的结构.
     * @throws IOException 当给定文件无法写入时.
     */
    void saveStructure(@NotNull File file, @NotNull Structure structure) throws IOException;

    /**
     * 将结构保存到流.
     * <p>
     * 原文：
     * Save a structure to a stream.
     *
     * @param outputStream 要写入的流.
     * @param structure 要保存的结构.
     * @throws IOException 当给定文件无法写入时.
     */
    void saveStructure(@NotNull OutputStream outputStream, @NotNull Structure structure) throws IOException;

    /**
     * 创建一个新的空结构.
     * <p>
     * 原文：
     * Creates a new empty structure.
     *
     * @return 一个空结构.
     */
    @NotNull
    Structure createStructure();

    /**
     * 创建此结构的副本.
     * <p>
     * 原文：
     * Creates a copy of this structure.
     *
     * @param structure 要复制的结构.
     * @return 结构的副本.
     */
    @NotNull
    Structure copy(@NotNull Structure structure);
}
