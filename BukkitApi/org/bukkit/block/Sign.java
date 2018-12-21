package org.bukkit.block;

/**
 * 代表一个告示牌或者墙上告示牌(快照).
 */
public interface Sign extends BlockState {

    /**
     * 获取这个告示牌上当前的文本.
     * <p>
     * 原文:
     * Gets all the lines of text currently on this sign.
     *
     * @return 每行文本字符串数组
     */
    public String[] getLines();

    /**
     * 获取指定行的文本.
     * <p>
     * 例如, getLine(0)将返回告示牌第一行的文本.
     *  <p>
     * 原文:
     * Gets the line of text at the specified index.
     * <p>
     * For example, getLine(0) will return the first line of text.
     *
     * @param index 要获取的文本的行数,从0开始
     * @throws IndexOutOfBoundsException 在此行没有文本的时候抛出这个错误
     * @return 这个行的文本
     */
    public String getLine(int index) throws IndexOutOfBoundsException;

    /**
     * 设置指定索引行的文本.
     * <p>
     * 例如,setLine(0, "行1") 将设置告示牌第一行的文本为"行1".
     * <p>
     * 请注意:从0开始数行.
     * <p>
     * 原文:
     * Sets the line of text at the specified index.
     * <p>
     * For example, setLine(0, "Line One") will set the first line of text to
     * "Line One".
     *
     * @param index 要设置的文本的行数,从0开始
     * @param line 新的指定的文本索引
     * @throws IndexOutOfBoundsException 如果索引超出了0-3的范围
     */
    public void setLine(int index, String line) throws IndexOutOfBoundsException;

    /**
     * Marks whether this sign can be edited by players.
     * <br>
     * This is a special value, which is not persisted. It should only be set if
     * a placed sign is manipulated during the BlockPlaceEvent. Behaviour
     * outside of this event is undefined.
     *
     * @return if this sign is currently editable
     */
    public boolean isEditable();

    /**
     * Marks whether this sign can be edited by players.
     * <br>
     * This is a special value, which is not persisted. It should only be set if
     * a placed sign is manipulated during the BlockPlaceEvent. Behaviour
     * outside of this event is undefined.
     *
     * @param editable if this sign is currently editable
     */
    public void setEditable(boolean editable);
}
