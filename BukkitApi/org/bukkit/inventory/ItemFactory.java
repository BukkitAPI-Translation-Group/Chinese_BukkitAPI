package org.bukkit.inventory;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * ItemFactory的一个实例可以通过{@link Server#getItemFactory()}来获得.
 * <p>
 * ItemFactory类用于创建物品元数据以应用在物品上.
 * <p>
 * 译者注: 本类中的元数据意为{@link ItemMeta}
 * <p>
 * 原文: An instance of the ItemFactory can be obtained with {@link
 * Server#getItemFactory()}.
 * <p>
 * The ItemFactory is solely responsible for creating item meta containers to
 * apply on item stacks.
 */
public interface ItemFactory {

    /**
     * 该方法能够为给定的{@link Material}创建一个新的元数据。
     * <p>
     * 原文: This creates a new item meta for the material.
     *
     * @param material 给定的材质
     * @return 利用给定的{@link Material}返回这个{@link Material}所对应的ItemMeta, 并且只能用于Type为给定的{@link Material}的ItemStack上
     */
    ItemMeta getItemMeta(final Material material);

    /**
     * 该方法用于检查元数据是否能够适用于指定的ItemStack上(如果适用则物品不会丢失之前的数据).
     * <p>
     * 一个{@link SkullMeta}对于一把剑来说是无效的, 但是一个普通的附魔泥土块的{@link ItemMeta}会有效。
     * 原文: This method checks the item meta to confirm that it is applicable (no
     * data lost if applied) to the specified ItemStack.
     * <p>
     * A {@link SkullMeta} would not be valid for a sword, but a normal {@link
     * ItemMeta} from an enchanted dirt block would.
     *
     * @param meta  需要检查的元数据
     * @param stack 元数据将应用于的ItemStack
     * @return 如果ItemStack可以应用元数据并且不丢失数据, 则返回true, 否则返回false
     * @throws IllegalArgumentException 如果元数据不是由ItemFactory创建出来的则抛出此异常
     */
    boolean isApplicable(final ItemMeta meta, final ItemStack stack) throws IllegalArgumentException;

    /**
     * 该方法用于检查元数据是否能够适用于指定的{@link Material}上(如果适用则不会丢失数据).
     * <p>
     * 一个{@link SkullMeta}对于一把剑来说是无效的, 但是一个普通的附魔泥土块的{@link ItemMeta}会有效。
     * <p>
     * 原文: This method checks the item meta to confirm that it is applicable (no
     * data lost if applied) to the specified Material.
     * <p>
     * A {@link SkullMeta} would not be valid for a sword, but a normal {@link
     * ItemMeta} from an enchanted dirt block would.
     *
     * @param meta     需要检查的元数据
     * @param material 元数据将应用于的Material
     * @return 如果可以应用元数据并且不丢失数据，则返回true，否则返回false
     * @throws IllegalArgumentException 如果元数据不是由ItemFactory创建出来的则抛出此异常
     */
    boolean isApplicable(final ItemMeta meta, final Material material) throws IllegalArgumentException;

    /**
     * 该方法用于比较两个ItemStack的元数据对象.
     * <p>
     * 原文: This method is used to compare two item meta data objects.
     *
     * @param meta1 第一个要比较的元数据, 元数据为null则表明没有数据
     * @param meta2 第二个要比较的元数据, 元数据为null则表明没有数据
     * @return 如果其中一个元数据有数据而另一个没有, 则返回false, 否则返回true
     * @throws IllegalArgumentException 如果两个元数据都不是由ItemFactory创建出来的则抛出此异常
     */
    boolean equals(final ItemMeta meta1, final ItemMeta meta2) throws IllegalArgumentException;

    /**
     * 返回一个适用于给定的ItemStack的ItemMeta
     * <p>
     * 返回的元数据将始终是指定材质的给定ItemStack的有效元数据.
     * 它可能是一个或多或少的特定元数据，也可以是与参数相同的元数据或元类型.
     * 返回的ItemMeta始终是最适用的Meta
     * <p>
     * 例子:
     * 如果将{@link SkullMeta}作应用于书本，
     * 此方法将返回包含指定Meta的所有数据的{@link BookMeta}，
     * 该数据适用于最高公共接口{@link ItemMeta}.
     * 原文: Returns an appropriate item meta for the specified stack.
     * <p>
     * The item meta returned will always be a valid meta for a given
     * ItemStack of the specified material. It may be a more or less specific
     * meta, and could also be the same meta or meta type as the parameter.
     * The item meta returned will also always be the most appropriate meta.
     * <p>
     * Example, if a {@link SkullMeta} is being applied to a book, this method
     * would return a {@link BookMeta} containing all information in the
     * specified meta that is applicable to an {@link ItemMeta}, the highest
     * common interface.
     *
     * @param meta  需要转换的元数据
     * @param stack 给定的ItemStack
     * @return 返回一个适用于给定的ItemStack的ItemMeta.
     * 不保证返回的ItemMeta是一个拷贝.
     * 当ItemStack为AIR时, 此方法将会返回null
     * @throws IllegalArgumentException 如果元数据不是由ItemFactory创建出来的则抛出此异常
     */
    ItemMeta asMetaFor(final ItemMeta meta, final ItemStack stack) throws IllegalArgumentException;

    /**
     * 返回一个适用于给定的Material的ItemMeta
     * <p>
     * 返回的元数据将始终是指定材质的给定{@link Material}的有效元数据.
     * 它可能是一个或多或少的特定元数据，也可以是与参数相同的元数据或元类型.
     * 返回的ItemMeta始终是最适用的Meta
     * <p>
     * 例子:
     * 如果将{@link SkullMeta}作应用于书本，
     * 此方法将返回包含指定Meta的所有数据的{@link BookMeta}，
     * 该数据适用于最高公共接口{@link ItemMeta}.
     * 原文: Returns an appropriate item meta for the specified material.
     * <p>
     * The item meta returned will always be a valid meta for a given
     * ItemStack of the specified material. It may be a more or less specific
     * meta, and could also be the same meta or meta type as the parameter.
     * The item meta returned will also always be the most appropriate meta.
     * <p>
     * Example, if a {@link SkullMeta} is being applied to a book, this method
     * would return a {@link BookMeta} containing all information in the
     * specified meta that is applicable to an {@link ItemMeta}, the highest
     * common interface.
     *
     * @param meta     需要转换的ItemMeta
     * @param material 给定的Material
     * @return 返回一个适用于给定的Material的ItemMeta.
     * 不保证返回的ItemMeta是一个拷贝.
     * 当ItemStack为AIR时, 此方法将会返回null
     * @throws IllegalArgumentException 如果元数据不是由ItemFactory创建出来的则抛出此异常
     */
    ItemMeta asMetaFor(final ItemMeta meta, final Material material) throws IllegalArgumentException;

    /**
     * 返回所有皮甲的默认颜色.
     * <p>
     * 原文: Returns the default color for all leather armor.
     *
     * @return 所有皮甲的默认颜色.
     */
    Color getDefaultLeatherColor();

    /**
     * Apply a material change for an item meta. Do not use under any
     * circumstances.
     *
     * @param meta
     * @param material
     * @return updated material
     * @throws IllegalArgumentException
     * @deprecated for internal use only
     */
    @Deprecated
    Material updateMaterial(final ItemMeta meta, final Material material) throws IllegalArgumentException;
}
