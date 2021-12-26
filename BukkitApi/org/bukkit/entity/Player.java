package org.bukkit.entity;

import java.net.InetSocketAddress;
import java.util.UUID;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.WeatherType;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversable;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 玩家对象
 */
public interface Player extends HumanEntity, Conversable, OfflinePlayer, PluginMessageRecipient {

    /**
     * 获得玩家在聊天信息中的昵称.
     * <p>
     * 这个昵称只显示在聊天信息中，能以颜色加以修饰.
     * <p>
     * 原文:Gets the "friendly" name to display of this player. This may include
     * color.
     * <p>
     * Note that this name will not be displayed in game, only in chat and
     * places defined by plugins.
     *
     * @return 显示的名称.
     */
    @NotNull
    public String getDisplayName();

    /**
     * 设置玩家在聊天信息中的昵称.
     * <p>
     * 这个名字只显示在聊天信息中,能以颜色加以修饰.
     * <p>
     * 原文Sets the "friendly" name to display of this player. This may include
     * color.
     * <p>
     * Note that this name will not be displayed in game, only in chat and
     * places defined by plugins.
     *
     * @param name 显示的名称.
     */
    public void setDisplayName(@Nullable String name);

    /**
     * 得到玩家显示在tab列表中的名称.
     * <p>
     * 原文:Gets the name that is shown on the player list.
     * 
     * @return 玩家名(显示于tab列表)
     */
    @NotNull
    public String getPlayerListName();

    /**
     * 设置玩家显示在Tab列表中的名称.
     * <p>
     * 如果设置为null则此名字与{@link #getName()}相同.
     * <p>
     * 原文:Sets the name that is shown on the in-game player list.
     * <p>
     * If the value is null, the name will be identical to {@link #getName()}.
     *
     * @param name 新的显示在玩家列表中的名字
     */
    public void setPlayerListName(@Nullable String name);

    /**
     * Gets the currently displayed player list header for this player.
     *
     * @return player list header or null
     */
    @Nullable
    public String getPlayerListHeader();

    /**
     * Gets the currently displayed player list footer for this player.
     *
     * @return player list header or null
     */
    @Nullable
    public String getPlayerListFooter();

    /**
     * Sets the currently displayed player list header for this player.
     *
     * @param header player list header, null for empty
     */
    public void setPlayerListHeader(@Nullable String header);

    /**
     * Sets the currently displayed player list footer for this player.
     *
     * @param footer player list footer, null for empty
     */
    public void setPlayerListFooter(@Nullable String footer);

    /**
     * Sets the currently displayed player list header and footer for this
     * player.
     *
     * @param header player list header, null for empty
     * @param footer player list footer, null for empty
     */
    public void setPlayerListHeaderFooter(@Nullable String header, @Nullable String footer);

    /**
     * 设置玩家指南针的指向的位置({@link Location}).
     * <p>
     * 原文:Set the target of the player's compass.
     *
     * @param loc 指向
     */
    public void setCompassTarget(@NotNull Location loc);

    /**
     * 得到玩家指南针的指向的位置({@link Location}).
     * <p>
     * 译注:默认为出生点.
     * <p>
     * 原文: Get the previously set compass target.
     *
     * @return 指向
     */
    @NotNull
    public Location getCompassTarget();

    /**
     * 得到一个Address对象,包括这个玩家的IP以及登入端口.
     * <p>
     * 原文:Gets the socket address of this player
     *
     * @return 玩家的Address对象
     */
    @Nullable
    public InetSocketAddress getAddress();

    /**
     * 发送一条不含颜色代码的消息.
     * <p>
     * 译注:就是会把颜色代码过滤掉然后{@link #sendMessage}
     * <p>
     * 原文:Sends this sender a message raw
     *
     * @param message 要发送的消息
     */
    @Override
    public void sendRawMessage(@NotNull String message);

    /**
     * 踢出玩家,并且发送一条自定义的踢出消息.
     * <p>
     * 原文:Kicks player with custom kick message.
     *
     * @param message 踢出消息
     */
    public void kickPlayer(@Nullable String message);

    /**
     * 强制玩家发送一个聊天消息,或强制使用命令(需要在内容前加 "/").
     * <p>
     * 原文:Says a message (or runs a command).
     *
     * @param msg 要发送的聊天消息
     */
    public void chat(@NotNull String msg);

    /**
     * 强制玩家执行某个命令.
     * <p>
     * 原文:Makes the player perform the given command
     *
     * @param command 要执行的命令(不带'/')
     * @return JavaPlugin内的onCommand()方法的返回值
     */
    public boolean performCommand(@NotNull String command);

    /**
     * Returns true if the entity is supported by a block.
     *
     * This value is a state updated by the client after each movement.
     *
     * @return True if entity is on ground.
     * @deprecated This value is controlled only by the client and is therefore
     * unreliable and vulnerable to spoofing and/or desync depending on the
     * context/time which it is accessed
     */
    @Override
    @Deprecated
    public boolean isOnGround();

    /**
     * 判断玩家是否在潜行中.
     * <p>
     * 原文:Returns if the player is in sneak mode
     *
     * @return 如果在潜行模式返回true
     */
    public boolean isSneaking();

    /**
     * 设置玩家潜行模式开启/取消.
     * <p>
     * 原文:Sets the sneak mode the player
     *
     * @param sneak true表示在潜行,false反之
     */
    public void setSneaking(boolean sneak);

    /**
     * 判断玩家是否在疾跑.
     * <p>
     * 原文:Gets whether the player is sprinting or not.
     *
     * @return true表示玩家在疾跑,false反之
     */
    public boolean isSprinting();

    /**
     * 设置玩家疾跑状态开启/取消.
     * <p>
     * 原文:Sets whether the player is sprinting or not.
     *
     * @param sprinting true表示在疾跑,false反之
     */
    public void setSprinting(boolean sprinting);

    /**
     * 保存玩家数据(位置,血量,背包,移动方向
     * 及其他信息至在world/player文件夹中的"玩家名.dat"文件).
     * <p>
     * 原文:Saves the players current location, health, inventory, motion, and
     * other information into the username.dat file, in the world/player
     * folder
     */
    public void saveData();

    /**
     * 加载上一次保存的数据(从在world/player文件夹中的玩家名.dat文件中加载
     * 位置,血量,背包,移动方向及其他信息).<p>
     * 这将会覆盖当前内存中的数据. <p>
     * 原文:Loads the players current location, health, inventory, motion, and
     * other information from the username.dat file, in the world/player
     * folder.
     * <p>
     * Note: This will overwrite the players current inventory, health,
     * motion, etc, with the state from the saved dat file.
     */
    public void loadData();

    /**
     * 是否忽略该玩家.如果设置为true,不需要该玩家睡觉,只需其他人睡觉,时间也能改变. <p>
     * 如果所有玩家都把这个项设置为true但是没有人睡觉,则什么事也不会发生.<p>
     * 原文:Sets whether the player is ignored as not sleeping. If everyone is
     * either sleeping or has this flag set, then time will advance to the
     * next day. If everyone has this flag set but no one is actually in bed,
     * then nothing will happen.
     *
     * @param isSleeping 是否忽略该玩家
     */
    public void setSleepingIgnored(boolean isSleeping);

    /**
     * 查看{@link #setSleepingIgnored(boolean) }方法所设置的值. <p>
     * 默认为false.<p>
     * 原文:Returns whether the player is sleeping ignored.
     *
     * @return 判断是否全部睡觉时是否忽略该玩家
     */
    public boolean isSleepingIgnored();

    /**
     * Gets the Location where the player will spawn at their bed, null if
     * they have not slept in one or their current bed spawn is invalid.
     *
     * @return Bed Spawn Location if bed exists, otherwise null.
     */
    @Nullable
    @Override
    public Location getBedSpawnLocation();

    /**
     * Sets the Location where the player will spawn at their bed.
     *
     * @param location where to set the respawn location
     */
    public void setBedSpawnLocation(@Nullable Location location);

    /**
     * Sets the Location where the player will spawn at their bed.
     *
     * @param location where to set the respawn location
     * @param force whether to forcefully set the respawn location even if a
     *     valid bed is not present
     */
    public void setBedSpawnLocation(@Nullable Location location, boolean force);

    /**
     * Play a note for a player at a location. This requires a note block
     * at the particular location (as far as the client is concerned). This
     * will not work without a note block. This will not work with cake.
     * <p>
     * 译注:貌似就是让一个音符盒播放指定乐器的指定声音..没试过...
     *
     * @param loc 音符盒的位置.
     * @param instrument 乐器ID
     * @param note 音符ID.
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void playNote(@NotNull Location loc, byte instrument, byte note);

    /**
     * Play a note for a player at a location. This requires a note block
     * at the particular location (as far as the client is concerned). This
     * will not work without a note block. This will not work with cake.<p>
     * 译注:貌似就是让一个音符盒播放指定乐器的指定声音..没试过...
     *
     * @param loc 音符盒的位置
     * @param instrument 乐器ID
     * @param note 音符
     */
    public void playNote(@NotNull Location loc, @NotNull Instrument instrument, @NotNull Note note);


    /**
     * 向玩家在某个位置播放一个声音. <p>
     * 当位置或声音为null或玩家的客户端没开启声音时,这个方法无效. <p>
     * 原文:Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location 要播放声音的位置
     * @param sound 要播放的声音
     * @param volume 音量 默认 1F
     * @param pitch 音高 默认 0F
     */
    public void playSound(@NotNull Location location, @NotNull Sound sound, float volume, float pitch);

    /**
     * 向玩家在某个位置播放一个声音. <p>
     * 当位置或声音为null或玩家的客户端没开启声音时,这个方法无效. 玩家客户端不存在指定声音本操作也将无效. <p>
     * 原文:Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null. No
     * sound will be heard by the player if their client does not have the
     * respective sound for the value passed.
     *
     * @param location 要播放声音的位置
     * @param sound 要播放的声音
     * @param volume 音量 默认 1F
     * @param pitch 音高 默认 0F
     */
    public void playSound(@NotNull Location location, @NotNull String sound, float volume, float pitch);

    /**
     * 向玩家在指定位置播放声音.
     * <p>
     * 当位置或声音为null或玩家的客户端没开启声音时,这个方法无效.
     * <p>
     * 原文:Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location 声音播放位置
     * @param sound 要播放的声音
     * @param category 声音的分类
     * @param volume 音量
     * @param pitch 音调
     */
    public void playSound(@NotNull Location location, @NotNull Sound sound, @NotNull SoundCategory category, float volume, float pitch);

    /**
     * 向玩家在指定位置播放声音.
     * <p>
     * 当位置或声音为null或玩家的客户端没开启声音时,这个方法无效. 玩家客户端不存在指定声音本操作也将无效.
     * <p>
     * 原文:Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null. No sound
     * will be heard by the player if their client does not have the respective
     * sound for the value passed.
     *
     * @param location 声音播放位置
     * @param sound 要播放的声音
     * @param category 声音的分类
     * @param volume 音量
     * @param pitch 音调
     */
    public void playSound(@NotNull Location location, @NotNull String sound, @NotNull SoundCategory category, float volume, float pitch);

    /**
     * 停止播放指定的声音.
     * <p>
     * 原文:Stop the specified sound from playing.
     *
     * @param sound 指定声音
     */
    public void stopSound(@NotNull Sound sound);

    /**
     * 停止播放指定的声音.
     * <p>
     * 原文:Stop the specified sound from playing.
     *
     * @param sound 指定声音
     */
    public void stopSound(@NotNull String sound);

    /**
     * 停止播放指定的声音.
     * <p>
     * 原文:Stop the specified sound from playing.
     *
     * @param sound 指定声音
     * @param category 声音类别
     */
    public void stopSound(@NotNull Sound sound, @Nullable SoundCategory category);

    /**
     * 停止播放指定的声音.
     * <p>
     * 原文:Stop the specified sound from playing.
     *
     * @param sound 指定声音
     * @param category 声音类别
     */
    public void stopSound(@NotNull String sound, @Nullable SoundCategory category);

    /**
     * 停止播放所有声音.
     * <p>
     * 原文:Stop all sounds from playing.
     */
    public void stopAllSounds();

    /**
     * 在某个位置({@link Location})向玩家播放一个粒子效果({@link Effect}). <p>
     * 原文:Plays an effect to just this player.
     *
     * @param loc 要播放粒子效果的位置
     * @param effect 要播放的粒子效果
     * @param data 某些效果需要的附加值.
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void playEffect(@NotNull Location loc, @NotNull Effect effect, int data);

    /**
     * 在某个位置({@link Location})向玩家播放一个粒子效果({@link Effect}). <p>
     * 原文:Plays an effect to just this player.<p>
     * 译注1:data参数一般为0就行,但是如果要播放的效果为<p>
     * {@link Effect}.StepSound(方块被打破时的粒子效果),data就为{@link Material}类型.<p>
     * 例:playEffect(loc, {@link Effect}.StepSound, Material.REDSTONE_BLOCK)将
     * 在loc的位置播放一个红石块(REDSTONE_BLOCK)被打破的粒子效果.<p>
     * 译注2:{@link Material}只能表示主ID,不能表示副ID,所以播放绿色羊毛的打破效果貌似是不可能的,
     * 但是由于data是泛型,我们猜测会不会data也可以是能表示任何{@link org.bukkit.block.Block 方块}类型?由于时间关系不能测试,请谅解.
     * 
     * @param <T> {@link Material}
     * @param loc 要播放粒子效果的位置
     * @param effect 要播放的粒子效果
     * @param data Effect.StepSound所需的附加值,一般为{@link Material}
     */
    public <T> void playEffect(@NotNull Location loc, @NotNull Effect effect, @Nullable T data);

    /**
     * Force this player to break a Block using the item in their main hand.
     *
     * This method will respect enchantments, handle item durability (if
     * applicable) and drop experience and the correct items according to the
     * tool/item in the player's hand.
     * <p>
     * Note that this method will call a {@link BlockBreakEvent}, meaning that
     * this method may not be successful in breaking the block if the event was
     * cancelled by a third party plugin. Care should be taken if running this
     * method in a BlockBreakEvent listener as recursion may be possible if it
     * is invoked on the same {@link Block} being broken in the event.
     * <p>
     * Additionally, a {@link BlockDropItemEvent} is called for the items
     * dropped by this method (if successful).
     * <p>
     * The block must be in the same world as the player.
     *
     * @param block the block to break
     *
     * @return true if the block was broken, false if the break failed
     */
    public boolean breakBlock(@NotNull Block block);

    /**
     * 向该玩家发送一个伪造的指定位置的方块({@link org.bukkit.block.Block})更改数据包.这不会改变世界中的方块. <p>
     * 原文:Send a block change. This fakes a block change packet for a user at a
     * certain location. This will not actually change the world in any way.<p>
     * 译注:意思就是,向玩家发送一个伪造的,更新方块的数据包,那个位置本来是石头的,这个玩家看起来那里就变成了钻石矿.<p>
     * 但是这并没有真的在世界中放置一个钻石矿.其他玩家看到的还是石头.挖掉后也不会真的掉钻石.(我想还是举例说明比较好..)<p>
     * 例1:sendBlockChange(loc,Material.DIAMOND_ORE,(byte)0)将让玩家的客户端认为loc的位置是一个钻石矿石(DIAMOND_ORE)
     * 但其实并没有改变.<p>
     * 例2:sendBlockChange(loc,Material.WOOL,(byte)14)将让玩家的客户端认为loc的位置是一个红色羊毛(附加值为14的WOOL).
     *
     * @param loc 要改变的方块的位置
     * @param material 要改变成的方块的类型
     * @param data 要改变成的方块的副ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void sendBlockChange(@NotNull Location loc, @NotNull Material material, byte data);

    /**
     * 向该玩家发送一个伪造的指定位置的方块({@link org.bukkit.block.Block})更改数据包.这不会改变世界中的方块.
     * <p>
     * 原文:Send a block change. This fakes a block change packet for a user at a
     * certain location. This will not actually change the world in any way.
     *
     * @param loc 要改变的方块的位置
     * @param block 新方块
     */
    public void sendBlockChange(@NotNull Location loc, @NotNull BlockData block);

    /**
     * Send block damage. This fakes block break progress for a user at a
     * certain location. This will not actually change the block's break
     * progress in any way.
     *
     * @param loc the location of the damaged block
     * @param progress the progress from 0.0 - 1.0 where 0 is no damage and
     * 1.0 is the most damaged
     */
    public void sendBlockDamage(@NotNull Location loc, float progress);

    /**
     * 向玩家发送某个实体的盔甲槽变化数据包. 本方法可针对指定玩家伪造某个实体的盔甲,
     * 且不会实际改变指定实体的盔甲槽内容.
     * <p>
     * 原文:Send the equipment change of an entity. This fakes the equipment change
     * of an entity for a user. This will not actually change the inventory of
     * the specified entity in any way.
     *
     * @param entity 玩家会看到哪个实体的变化
     * @param slot 要伪造哪一盔甲槽的变化
     * @param item 玩家将看到的盔甲物品
     */
    public void sendEquipmentChange(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack item);

    /**
     * 向该玩家发送一个伪造的牌子({@link org.bukkit.block.Sign})上的字的更改数据包.这不会改变世界中的任何方块. <p>
     * 如果那个位置没有牌子,这个方法将用{@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte) }
     * 方法在那个位置伪造一个牌子然后更改它.<p>
     * 如果客户端认为在指定的位置没有牌子,则会显示一个错误给玩家.<p>
     * 原文:Send a sign change. This fakes a sign change packet for a user at
     * a certain location. This will not actually change the world in any way.
     * This method will use a sign at the location's block or a faked sign
     * sent via
     * {@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte)}.
     * <p>
     * If the client does not have a sign at the given location it will
     * display an error message to the user. <p>
     * 译注:该方法类似于{@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte) },
     * 只不过sendBlockChange是伪装一个方块成其他方块,而它只是伪装牌子上的字.
     *
     * @param loc 要让玩家看起来改变了的牌子的位置
     * @param lines null或大小等于4的String数组;数组中每个元素都代表一行
     * @throws IllegalArgumentException 如果location参数为null
     * @throws IllegalArgumentException 如果lines数组的长度小于4
     */
    public void sendSignChange(@NotNull Location loc, @Nullable String[] lines) throws IllegalArgumentException;

    /**
     * 向该玩家发送一个伪造的牌子({@link org.bukkit.block.Sign})上的字的更改数据包.这不会改变世界中的任何方块. <p>
     * 如果那个位置没有牌子,这个方法将用{@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte) }
     * 方法在那个位置伪造一个牌子然后更改它.<p>
     * 如果客户端认为在指定的位置没有牌子,则会显示一个错误给玩家.
     * <p>
     * 原文:Send a sign change. This fakes a sign change packet for a user at
     * a certain location. This will not actually change the world in any way.
     * This method will use a sign at the location's block or a faked sign
     * sent via
     * {@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte)}.
     * <p>
     * If the client does not have a sign at the given location it will
     * display an error message to the user.
     *
     * @param loc 要让玩家看起来改变了的牌子的位置
     * @param lines null或大小等于4的String数组;数组中每个元素都代表一行
     * @param dyeColor 告示牌的颜色(文字的颜色)
     * @throws IllegalArgumentException 如果location参数为null
     * @throws IllegalArgumentException 如果dyeColor参数为null
     * @throws IllegalArgumentException 如果lines数组的长度小于4
     */
    public void sendSignChange(@NotNull Location loc, @Nullable String[] lines, @NotNull DyeColor dyeColor) throws IllegalArgumentException;

    /**
     * 向该玩家发送一个伪造的牌子({@link org.bukkit.block.Sign})上的字的更改数据包.这不会改变世界中的任何方块. <p>
     * 如果那个位置没有牌子,这个方法将用{@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte) }
     * 方法在那个位置伪造一个牌子然后更改它.<p>
     * 如果客户端认为在指定的位置没有牌子,则会显示一个错误给玩家.
     * <p>
     * 原文:Send a sign change. This fakes a sign change packet for a user at
     * a certain location. This will not actually change the world in any way.
     * This method will use a sign at the location's block or a faked sign
     * sent via
     * {@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte)}.
     * <p>
     * If the client does not have a sign at the given location it will
     * display an error message to the user.
     *
     * @param loc 要让玩家看起来改变了的牌子的位置
     * @param lines null或大小等于4的String数组;数组中每个元素都代表一行
     * @param dyeColor 告示牌的颜色(文字的颜色)
     * @param hasGlowingText 文字是否发光
     * @throws IllegalArgumentException 如果location参数为null
     * @throws IllegalArgumentException 如果dyeColor参数为null
     * @throws IllegalArgumentException 如果lines数组的长度小于4
     */
    public void sendSignChange(@NotNull Location loc, @Nullable String[] lines, @NotNull DyeColor dyeColor, boolean hasGlowingText) throws IllegalArgumentException;

    /**
     * Render a map and send it to the player in its entirety. This may be
     * used when streaming the map in the normal manner is not desirable.
     *
     * @param map The map to be sent
     */
    public void sendMap(@NotNull MapView map);

    /**
     * 刷新玩家的背包.确保玩家的背包和服务器内存中玩家的背包一致. <p>
     * 译注:在以前的版本(好吧我也不知道是什么版本)中假如不调用该方法当更改背包时会出现莫名其妙的事情,比如
     * 背包看起来是空的,点一下空的格突然出现了东西之类的.... <p>
     * 原文:Forces an update of the player's entire inventory.
     */
    //@Deprecated // Spigot - undeprecate
    public void updateInventory();

    /**
     * 设置该玩家客户端的时间,单位为tick. <p>
     * 假如relative为true则玩家时间会随着世界时间变动而变动,并且保持一个差值,反之客户端时间固定不动. <p>
     * 注意!如果relative为true,那么time表示的就是客户端的时间与世界的时间之差(相对于世界的时间),而如果为false
     * 那么time表示的就是一个绝对的时间. <p>
     * 原文:Sets the current time on the player's client. When relative is true the
     * player's time will be kept synchronized to its world time with the
     * specified offset.
     * <p>
     * When using non relative time the player's time will stay fixed at the
     * specified time parameter. It's up to the caller to continue updating
     * the player's time. To restore player time to normal use
     * resetPlayerTime().
     *
     * @param time 绝对时间或与世界的时间之差,单位为tick
     * @param relative 是否让玩家的时间和世界的时间保持一个差值
     */
    public void setPlayerTime(long time, boolean relative);

    /**
     * 得到玩家的客户端的当前时间,单位为tick. <p>
     * 原文:Returns the player's current timestamp.
     *
     * @return 玩家客户端的时间,单位为tick
     */
    public long getPlayerTime();

    /**
     * 返回玩家的客户端的当前时间与玩家当前世界时间的差值. <p>
     * 如玩家时间是固定的，则返回玩家时间.
     * 原文:Returns the player's current time offset relative to server time, or
     * the current player's fixed time if the player's time is absolute.
     *
     * @return 玩家当前时间与当前世界时间的差或玩家当前时间.单位为tick
     */
    public long getPlayerTimeOffset();

    /**
     * 如果玩家时间于当前世界时间保持了一定的差值则返回true. <p>
     * 原文:Returns true if the player's time is relative to the server time,
     * otherwise the player's time is absolute and will not change its current
     * time unless done so with setPlayerTime().
     *
     * @return true if the player's time is relative to the server time.
     */
    public boolean isPlayerTimeRelative();

    /**
     * 将玩家时间变为当前世界时间并与世界时间保持同步. <p>
     * 原文 Restores the normal condition where the player's time is synchronized
     * with the server time.
     * <p>
     * Equivalent to calling setPlayerTime(0, true).
     */
    public void resetPlayerTime();

    /**
     * 设置玩家的客户端的天气. <p>
     * 使用{@link #resetPlayerWeather()}来恢复正常. <p>
     * 原文:Sets the type of weather the player will see.  When used, the weather
     * status of the player is locked until {@link #resetPlayerWeather()} is
     * used.
     *
     * @param type 要让玩家看到的天气
     */
    public void setPlayerWeather(@NotNull WeatherType type);

    /**
     * 得到玩家所看到的天气.如果返回null,玩家的天气跟世界的天气一致. <p>
     * 原文:Returns the type of weather the player is currently experiencing.
     *
     * @return 玩家所看到的天气或null
     */
    @Nullable
    public WeatherType getPlayerWeather();

    /**
     * 恢复玩家所看到的天气为世界的天气. <p>
     * 原文:Restores the normal condition where the player's weather is controlled
     * by server conditions.
     */
    public void resetPlayerWeather();

    /**
     * 给玩家指定经验. <p>
     * 原文:Gives the player the amount of experience specified.
     *
     * @param amount 要给的经验
     */
    public void giveExp(int amount);

    /**
     * 增加玩家的等级. <p>
     * 支持负数(减少等级). <p>
     * 原文:Gives the player the amount of experience levels specified. Levels can
     * be taken by specifying a negative amount.
     *
     * @param amount 要增加的等级(正数)或要减少的等级(负数)
     */
    public void giveExpLevels(int amount);

    /**
     * 得到当前级别升到下一级别经验进度的百分比. <p>
     * 0表示毫无进展(0%), 0.99表示差一点点(99%), 1表示要升级了(100%). <p>
     * 原文:Gets the players current experience points towards the next level.
     * <p>
     * This is a percentage value. 0 is "no progress" and 1 is "next level".
     *
     * @return 离下一级的小数形式百分比
     */
    public float getExp();

    /**
     * 设置当前级别升到下一级别经验进度的百分比. <p>
     * 0表示毫无进展(0%), 0.99表示差一点点(99%), 1表示要升级了(100%). <p>
     * Sets the players current experience points towards the next level
     * <p>
     * This is a percentage value. 0 is "no progress" and 1 is "next level".
     *
     * @param exp 新的离下一级的小数形式百分比
     */
    public void setExp(float exp);

    /**
     * 得到玩家的等级. <p>
     * 原文:Gets the players current experience level
     *
     * @return 玩家的经验等级
     */
    public int getLevel();

    /**
     * 设置玩家的等级 <p>.
     * 原文:Sets the players current experience level
     *
     * @param level 新的等级
     */
    public void setLevel(int level);

    /**
     * 得到玩家总共获得了多少经验(等级和经验).
     * <br>
     * 这个数值指玩家随着时间的推移收集的全部经验, 并且此值目前不会在客户端上显示.
     * <p>
     * 原文:Gets the players total experience points.
     * <br>
     * This refers to the total amount of experience the player has collected
     * over time and is not currently displayed to the client.
     *
     * @return 玩家总共有多少经验
     */
    public int getTotalExperience();

    /**
     * 设置玩家的总经验值(等级和经验).
     * <br>
     * 这个数值指玩家随着时间的推移收集的全部经验, 并且此值目前不会在客户端上显示.
     * <p>
     * 原文:
     * Sets the players current experience points.
     * <br>
     * This refers to the total amount of experience the player has collected
     * over time and is not currently displayed to the client.
     *
     * @param exp 总经验值
     */
    public void setTotalExperience(int exp);

    /**
     * Send an experience change.
     *
     * This fakes an experience change packet for a user. This will not actually
     * change the experience points in any way.
     *
     * @param progress Experience progress percentage (between 0.0 and 1.0)
     * @see #setExp(float)
     */
    public void sendExperienceChange(float progress);

    /**
     * Send an experience change.
     *
     * This fakes an experience change packet for a user. This will not actually
     * change the experience points in any way.
     *
     * @param progress New experience progress percentage (between 0.0 and 1.0)
     * @param level New experience level
     *
     * @see #setExp(float)
     * @see #setLevel(int)
     */
    public void sendExperienceChange(float progress, int level);

    /**
     * 判断玩家是否能飞起来.
     * <p>
     * 译注:如果玩家确实在创造模式,那么一般返回true,除非被setAllowFlight(false).
     * <p>
     * 原文:Determines if the Player is allowed to fly via jump key double-tap like
     * in creative mode.
     *
     * @return 玩家能不能飞起来
     */
    public boolean getAllowFlight();

    /**
     * 设置玩家是否能够飞起来(就像创造模式).
     * <p>
     * 译注:如果被设置为false,即便是创造模式也不能飞.
     * <p>
     * 原文:Sets if the Player is allowed to fly via jump key double-tap like in
     * creative mode.
     *
     * @param flight 是否允许该玩家飞行.
     */
    public void setAllowFlight(boolean flight);

    /**
     * 让该玩家看不见某玩家. <p>
     * 原文:Hides a player from this player
     *
     * @param player 要让该玩家看不见的玩家.
     * @deprecated 另请参阅 {@link #hidePlayer(Plugin, Player)}
     */
    @Deprecated
    public void hidePlayer(@NotNull Player player);

    /**
     * 让该玩家看不见某玩家.
     * <p>
     * 原文:Hides a player from this player
     *
     * @param plugin Plugin 要隐藏该玩家的插件
     * @param player Player 要让该玩家看不见的玩家.
     */
    public void hidePlayer(@NotNull Plugin plugin, @NotNull Player player);

    /**
     * 让该玩家能看到某玩家. <p>
     * 原文:Allows this player to see a player that was previously hidden
     *
     * @param player 要让该玩家看得见的玩家.
     * @deprecated 另请参阅 {@link #showPlayer(Plugin, Player)}
     */
    @Deprecated
    public void showPlayer(@NotNull Player player);

    /**
     * 让该玩家能看到之前被隐藏的玩家. 如果另一个插件也隐藏了这个玩家,
     * 那么玩家将继续处于隐藏状态直至其他插件也调用了此方法.
     * <p>
     * 原文:Allows this player to see a player that was previously hidden. If
     * another another plugin had hidden the player too, then the player will
     * remain hidden until the other plugin calls this method too.
     *
     * @param plugin Plugin 要使某玩家现身的插件
     * @param player Player 使某玩家现身
     */
    public void showPlayer(@NotNull Plugin plugin, @NotNull Player player);

    /**
     * 检查该玩家是否能看到某玩家. <p>
     * 原文:Checks to see if a player has been hidden from this player
     *
     * @param player 要检查该玩家是否能看到的玩家
     * @return true表示能看到,false反之.
     */
    public boolean canSee(@NotNull Player player);

    /**
     * 从视觉上隐藏一个实体.
     * <p>
     * 原文:Visually hides an entity from this player.
     *
     * @param plugin 要隐藏此实体的插件实例
     * @param entity 要隐藏的实体
     * @deprecated draft API
     */
    @Deprecated
    public void hideEntity(@NotNull Plugin plugin, @NotNull Entity entity);

    /**
     * Allows this player to see an entity that was previously hidden. If
     * another another plugin had hidden the entity too, then the entity will
     * remain hidden until the other plugin calls this method too.
     *
     * @param plugin Plugin that wants to show the entity
     * @param entity Entity to show
     * @deprecated draft API
     */
    @Deprecated
    public void showEntity(@NotNull Plugin plugin, @NotNull Entity entity);

    /**
     * Checks to see if an entity has been visually hidden from this player.
     *
     * @param entity Entity to check
     * @return True if the provided entity is not being hidden from this
     *     player
     * @deprecated draft API
     */
    @Deprecated
    public boolean canSee(@NotNull Entity entity);

    /**
     * 检查玩家是否在飞. <p>
     * 原文:Checks to see if this player is currently flying or not.
     *
     * @return true表示该玩家在飞,false反之.
     */
    public boolean isFlying();

    /**
     * 设置该玩家飞行状态. <p>
     * 原文:Makes this player start or stop flying.
     *
     * @param value true表示正在飞
     */
    public void setFlying(boolean value);

    /**
     * 设置该玩家飞行速度. <p>
     * 速度为-1~1之间,负数代表玩家会反着飞... <p>
     * 译注:不代表行走的速度!. <p>
     * 原文:Sets the speed at which a client will fly. Negative values indicate
     * reverse directions.
     *
     * @param value 新的飞行速度,在-1~1之间.
     * @throws IllegalArgumentException 如果速度不在-1~1之间则抛出.
     */
    public void setFlySpeed(float value) throws IllegalArgumentException;

    /**
     * 设置该玩家行走速度. <p>
     * 速度在-1~1之间,负数代表玩家会倒着走(整人专用233~)... <p>
     * 译注:不代表飞行的速度!
     * 原文:Sets the speed at which a client will walk. Negative values indicate
     * reverse directions.
     *
     * @param value 新的行走速度.
     * @throws IllegalArgumentException 当速度不在-1~1时间则抛出
     */
    public void setWalkSpeed(float value) throws IllegalArgumentException;

    /**
     * 得到该玩家飞行速度. <p>
     * 译注:不代表行走速度!
     * 原文:Gets the current allowed speed that a client can fly.
     *
     * @return 飞行速度.取值-1~1.
     */
    public float getFlySpeed();

    /**
     * 得到行走速度. <p>
     * 译注:不代表飞行速度!
     * 原文:Gets the current allowed speed that a client can walk.
     *
     * @return 行走速度,取值-1~1
     */
    public float getWalkSpeed();

    /**
     * 设置服务器材质包.(因为已过时所以不详解了). <p>
     * 介绍同{@link #setResourcePack(java.lang.String) }
     * Request that the player's client download and switch texture packs.
     * <p>
     * The player's client will download the new texture pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached the same
     * texture pack in the past, it will perform a file size check against
     * the response content to determine if the texture pack has changed and
     * needs to be downloaded again. When this request is sent for the very
     * first time from a given server, the client will first display a
     * confirmation GUI to the player before proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server textures on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting texture packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is send with "null" as the hash. This might result
     *     in newer versions not loading the pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the texture
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long.
     * @deprecated Minecraft已经不使用材质包了,应该用{@link #setResourcePack(String)}设置资源包(额这不是一个意思么..).
     */
    @Deprecated
    public void setTexturePack(@NotNull String url);

    /**
     * 请求玩家的客户端下载并且使用指定资源包. <p>
     * 玩家的客户端将在后台异步下载新的资源包,并且下载完成后会自动使用那个资源包.如果
     * 这个资源包已经下载好了,客户端先会检查给定URL的资源包跟已经下载的资源包是否一样. 
     * 如果不一样就会重新下载,一样就直接使用. <p>
     * 在开始下载之前,客户端会显示一个GUI确定界面,提示要不要下载资源包.如果玩家选择不要,
     * 就不能下载. <p>
     * 注意:
     * <ul>
     * <li>如果玩家的客户端没有开启"使用服务器资源包"这个方法将失效. 使用
     * {@link PlayerResourcePackStatusEvent} 方法以推断玩家是否加载了你设置的资源包!
     * <li>在Minecraft中没有将资源包重置为默认的概念,所以玩家必须重新登陆才能这么做,或者你必须发送一个空白的资源包.
     * <li>请求以空字符串作hash发送. 这可能导致较新版本的客户端不能正确加载资源包.
     * </ul>
     * <p>
     * 原文:Request that the player's client download and switch texture packs.
     * <p>
     * The player's client will download the new texture pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached the same
     * texture pack in the past, it will perform a file size check against
     * the response content to determine if the texture pack has changed and
     * needs to be downloaded again. When this request is sent for the very
     * first time from a given server, the client will first display a
     * confirmation GUI to the player before proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server textures on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting texture packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is send with empty string as the hash. This might result
     *     in newer versions not loading the pack correctly.
     * </ul>
     *
     * @param url 资源包的URL地址.只能包含US-ASCII字符并且使用RFC 1738编码.
     * @throws IllegalArgumentException 当URL为null时抛出
     * @throws IllegalArgumentException 当URL太长或者不符合规范时抛出
     */
    public void setResourcePack(@NotNull String url);

    // TODO:原文新增一句“If the hash is null...download again”未翻译.
    /**
     * 请求玩家的客户端下载并且使用指定资源包. <p>
     * 玩家的客户端将在后台异步下载新的资源包,并且下载完成后会自动使用那个资源包.如果
     * 这个资源包已经下载好了,客户端先会检查给定URL的资源包跟已经下载的资源包是否一样. 
     * 如果不一样就会重新下载,一样就直接使用. <p>
     * 在开始下载之前,客户端会显示一个GUI确定界面,提示要不要下载资源包.如果玩家选择不要,
     * 就不能下载. <p>
     * 注意:
     * <ul>
     * <li>如果玩家的客户端没有开启"使用服务器资源包"这个方法将失效. 使用
     * {@link PlayerResourcePackStatusEvent} 方法以推断玩家是否加载了你设置的资源包!
     * <li>在Minecraft中没有将资源包重置为默认的概念,所以玩家必须重新登陆才能这么做,或者你必须发送一个空白的资源包.
     * </ul>
     * <p>
     * 原文:Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When this request is sent for the very
     * first time from a given server, the client will first display a
     * confirmation GUI to the player before proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * </ul>
     *
     * @param url 资源包的URL地址.只能包含US-ASCII字符并且使用RFC 1738编码.
     * @param hash 资源包文件的sha1哈希值，被用于正确地应用缓存版本的资源包而不需再重新下载(如果之前下载过).必须是20字节长!
     * @throws IllegalArgumentException 当URL为null时抛出
     * @throws IllegalArgumentException 当URL太长或者不符合规范时抛出
     * @throws IllegalArgumentException 当hash为null时抛出Thrown if the hash is null.
     * @throws IllegalArgumentException 当hash不是20字节长时抛出
     */
    public void setResourcePack(@NotNull String url, @NotNull byte[] hash);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @param prompt The optional custom prompt message to be shown to client.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    public void setResourcePack(@NotNull String url, @Nullable byte[] hash, @Nullable String prompt);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @param force If true, the client will be disconnected from the server
     *     when it declines to use the resource pack.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    public void setResourcePack(@NotNull String url, @Nullable byte[] hash, boolean force);

    /**
     * Request that the player's client download and switch resource packs.
     * <p>
     * The player's client will download the new resource pack asynchronously
     * in the background, and will automatically switch to it once the
     * download is complete. If the client has downloaded and cached a
     * resource pack with the same hash in the past it will not download but
     * directly apply the cached pack. If the hash is null and the client has
     * downloaded and cached the same resource pack in the past, it will
     * perform a file size check against the response content to determine if
     * the resource pack has changed and needs to be downloaded again. When
     * this request is sent for the very first time from a given server, the
     * client will first display a confirmation GUI to the player before
     * proceeding with the download.
     * <p>
     * Notes:
     * <ul>
     * <li>Players can disable server resources on their client, in which
     *     case this method will have no affect on them. Use the
     *     {@link PlayerResourcePackStatusEvent} to figure out whether or not
     *     the player loaded the pack!
     * <li>There is no concept of resetting resource packs back to default
     *     within Minecraft, so players will have to relog to do so or you
     *     have to send an empty pack.
     * <li>The request is sent with empty string as the hash when the hash is
     *     not provided. This might result in newer versions not loading the
     *     pack correctly.
     * </ul>
     *
     * @param url The URL from which the client will download the resource
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @param hash The sha1 hash sum of the resource pack file which is used
     *     to apply a cached version of the pack directly without downloading
     *     if it is available. Hast to be 20 bytes long!
     * @param prompt The optional custom prompt message to be shown to client.
     * @param force If true, the client will be disconnected from the server
     *     when it declines to use the resource pack.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long. The
     *     length restriction is an implementation specific arbitrary value.
     * @throws IllegalArgumentException Thrown if the hash is not 20 bytes
     *     long.
     */
    public void setResourcePack(@NotNull String url, @Nullable byte[] hash, @Nullable String prompt, boolean force);

    /**
     * 获取玩家的计分板. <p>
     * 原文:Gets the Scoreboard displayed to this player
     *
     * @return The current scoreboard seen by this player
     */
    @NotNull
    public Scoreboard getScoreboard();

    /**
     * 设置玩家的计分板. <p>
     * 原文:Sets the player's visible Scoreboard.
     *
     * @param scoreboard 要设置成的计分板
     * @throws IllegalArgumentException 如果计分板为null则抛出
     * @throws IllegalArgumentException 如果计分板不是由
     * {@link org.bukkit.scoreboard.ScoreboardManager scoreboard manager}创建的
     * 则抛出.
     * @throws IllegalStateException 如果没有该玩家的数据,即该玩家没有进入过服务器则抛出.
     */
    public void setScoreboard(@NotNull Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException;

    /**
     * 获取客户端显示的玩家血量是否被"压缩"了. <p>
     * 译注:当玩家的最大血量过多时({@link #setMaxHealth(double) }),每一排血量将会被
     * 挤在一起,以免挡住玩家的视线,这就是"压缩".这个方法就是判断血量是否被压缩了.(完全没用的说..). <p>
     * 原文:Gets if the client is displayed a 'scaled' health, that is, health on a
     * scale from 0-{@link #getHealthScale()}.
     *
     * @return 客户端显示的血量是否被压缩了
     * @see Player#setHealthScaled(boolean)
     */
    public boolean isHealthScaled();

    /**
     * 设置客户端是否要显示一个"压缩"了的血量. <p>
     * 显示的血量遵循一个规则: <code>显示的血量 =
     * getHealth() / getMaxHealth() * getHealthScale()</code>. <p>
     * 译注:当玩家的最大血量过多时({@link #setMaxHealth(double) }),每一排血量将会被
     * 挤在一起,以免挡住玩家的视线,这就是"压缩".这个方法就是设置血量是否要被"压缩".(完全没用的说..). <p>
     * 原文:Sets if the client is displayed a 'scaled' health, that is, health on a
     * scale from 0-{@link #getHealthScale()}.
     * <p>
     * Displayed health follows a simple formula <code>displayedHealth =
     * getHealth() / getMaxHealth() * getHealthScale()</code>.
     *
     * @param scale 血量是否要被压缩
     */
    public void setHealthScaled(boolean scale);

    /**
     * 设置客户端显示的血量的"压缩率". <p>
     * 显示的血量遵循一个规则: <code>显示的血量 =
     * getHealth() / getMaxHealth() * getHealthScale()</code>. <p>
     * 译注:当玩家的最大血量过多时({@link #setMaxHealth(double) }),每一排血量将会被
     * 挤在一起,以免挡住玩家的视线,这就是"压缩".这个方法就是设置血量的"压缩率".(完全没用的说..). <p>
     * 原文:Sets the number to scale health to for the client; this will also
     * {@link #setHealthScaled(boolean) setHealthScaled(true)}.
     * <p>
     * Displayed health follows a simple formula <code>displayedHealth =
     * getHealth() / getMaxHealth() * getHealthScale()</code>.
     *
     * @param scale 血量的"压缩率"
     * @throws IllegalArgumentException 如果scale &lt;0
     * @throws IllegalArgumentException 如果scale为{@link Double#NaN}
     * @throws IllegalArgumentException 如果scale太大了
     */
    public void setHealthScale(double scale) throws IllegalArgumentException;

    /**
     * 获取客户端显示的血量的"压缩率".  <p>
     * 详见{@link #setHealthScale(double) }
     * 原文:Gets the number that health is scaled to for the client.
     *
     * @return 客户端显示的血量条的"压缩率"
     * @see Player#setHealthScale(double)
     * @see Player#setHealthScaled(boolean)
     */
    public double getHealthScale();

    /**
     * 获取旁观者模式下镜头跟随的实体.
     * <p>
     * 原文:Gets the entity which is followed by the camera when in
     * {@link GameMode#SPECTATOR}.
     *
     * @return 正在跟随的实体, 如果未跟随实体或不处于旁观者模式返回null
     */
    @Nullable
    public Entity getSpectatorTarget();

    /**
     * 设置模式下镜头跟随的实体.
     * <p>
     * 原文:Sets the entity which is followed by the camera when in
     * {@link GameMode#SPECTATOR}.
     *
     * @param entity 要跟随的实体, 设为null重置
     * @throws IllegalStateException 若玩家不处于
     * {@link GameMode#SPECTATOR 旁观者模式}
     */
    public void setSpectatorTarget(@Nullable Entity entity);

    /**
     * 向玩家发送屏幕标题.如果标题和副标题内容都为null, 那么标题将不会被发送出去, 玩家的屏幕也不会有变化.
     * 如果这些参数是空字符串(注意空字符串与null有区别), 那么玩家的屏幕将会被更新(本质上讲, 虽然看起来没啥变化)
     * 如果字符串包含多行文本, 那么只有第一行文本才会被发送出去.
     * 标题将以玩家客户端默认的淡入淡出时间显示.
     * <p>
     * 原文:Sends a title and a subtitle message to the player. If either of these
     * values are null, they will not be sent and the display will remain
     * unchanged. If they are empty strings, the display will be updated as
     * such. If the strings contain a new line, only the first line will be
     * sent. be displayed with the client's default timings.
     *
     * @param title 标题文本
     * @param subtitle 副标题文本
     * @deprecated API行为有所改变
     */
    @Deprecated
    public void sendTitle(@Nullable String title, @Nullable String subtitle);

    /**
     * 向玩家发送屏幕标题.如果标题和副标题内容都为null, 那么标题将不会被发送出去, 玩家的屏幕也不会有变化.
     * 如果这些参数是空字符串(注意空字符串与null有区别), 那么玩家的屏幕将会被更新(本质上讲, 虽然看起来没啥变化)
     * 如果字符串包含多行文本, 那么只有第一行文本才会被发送出去.
     * 所有时间值都可以取-1来表示最后一次(或者上一次)发送标题所用的值(如果尚无任何标题曾被显示过则取默认值).
     * <p>
     * 原文:Sends a title and a subtitle message to the player. If either of these
     * values are null, they will not be sent and the display will remain
     * unchanged. If they are empty strings, the display will be updated as
     * such. If the strings contain a new line, only the first line will be
     * sent. All timings values may take a value of -1 to indicate that they
     * will use the last value sent (or the defaults if no title has been
     * displayed).
     *
     * @param title 标题文本
     * @param subtitle 副标题文本
     * @param fadeIn 标题淡入时间,以tick为单位.默认值取10.
     * @param stay 标题停留/展示时长,以tick为单位.默认值取70.
     * @param fadeOut 标题淡出时间,以tick为单位.默认值取20.
     */
    public void sendTitle(@Nullable String title, @Nullable String subtitle, int fadeIn, int stay, int fadeOut);

   /**
     * 重置想转玩家显示的屏幕标题.
     * 这将清除已显示的标题/副标题并重置标题显示计时器至默认值.
     * <p>
     * 原文:Resets the title displayed to the player. This will clear the displayed
     * title / subtitle and reset timings to their default values.
     */
    public void resetTitle();

    /** 
     * 在指定位置产生粒子效果 (the number of times specified by count).
     * <p>
     * 原文:Sawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle 要产生的粒子效果
     * @param location 粒子效果产生位置
     * @param count the number of particles
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count);

    /**
     * 在指定位置产生粒子效果 (the number of times specified by count).
     * <p>
     * 原文:Sawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle 要产生的粒子效果
     * @param x 粒子效果产生位置x轴
     * @param y 粒子效果产生位置y轴
     * @param z 粒子效果产生位置z轴
     * @param count the number of particles
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count);

    /**
     * 在指定位置产生粒子效果 (the number of times specified by count).
     * <p>
     * 原文:Sawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param <T> 粒子效果数据类型 (请参阅 {@link Particle#getDataType()}
     * @param particle 要产生的粒子效果
     * @param location 粒子效果产生位置
     * @param count 粒子数目
     * @param data 粒子效果的数据或null, 其数据类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param <T> 粒子效果数据类型 (请参阅 {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param data 粒子效果的数据或null, 其数据类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子效果数据类型 (请参阅 {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param data 粒子效果的数据或null, 其数据类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子效果数据类型 (请参阅 {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param data 粒子效果的数据或null, 其数据类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     */
    public void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     */
    public void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子效果数据类型 (请参阅 {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     * @param data 粒子效果的数据或null, 其数据类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, @NotNull Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location. The position of each particle will be
     * randomized positively and negatively by the offset parameters
     * on each axis.
     *
     * @param <T> 粒子效果数据类型 (请参阅 {@link Particle#getDataType()}
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param offsetX the maximum random offset on the X axis
     * @param offsetY the maximum random offset on the Y axis
     * @param offsetZ the maximum random offset on the Z axis
     * @param extra the extra data for this particle, depends on the
     *              particle used (normally speed)
     * @param data 粒子效果的数据或null, 其数据类型取决于{@link Particle#getDataType()}
     */
    public <T> void spawnParticle(@NotNull Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, @Nullable T data);

    /**
     * 返回玩家指定进度的完成进度.
     * 原文:Return the player's progression on the specified advancement.
     *
     * @param advancement 进度
     * @return 有关玩家进度的详细信息
     */
    @NotNull
    public AdvancementProgress getAdvancementProgress(@NotNull Advancement advancement);

    /**
     * Get the player's current client side view distance.
     * <br>
     * Will default to the server view distance if the client has not yet
     * communicated this information,
     *
     * @return client view distance as above
     */
    public int getClientViewDistance();

    /**
     * Gets the player's estimated ping in milliseconds.
     *
     * In Vanilla this value represents a weighted average of the response time
     * to application layer ping packets sent. This value does not represent the
     * network round trip time and as such may have less granularity and be
     * impacted by other sources. For these reasons it <b>should not</b> be used
     * for anti-cheat purposes. Its recommended use is only as a
     * <b>qualitative</b> indicator of connection quality (Vanilla uses it for
     * this purpose in the tab list).
     *
     * @return player ping
     */
    public int getPing();

    /**
     * 返回玩家本地语言环境.
     * 语言环境值的格式尚未被适当地定义.
     * <br>
     * 原生 Minecraft 客户端将使用全小写 语言/国家, 用短下划线分隔. 但自定义资源包可能会使用他们想要的任意格式.
     * <p>
     * 原文:Gets the player's current locale.
     *
     * The value of the locale String is not defined properly.
     * <br>
     * The vanilla Minecraft client will use lowercase language / country pairs
     * separated by an underscore, but custom resource packs may use any format
     * they wish.
     *
     * @return 玩家语言环境
     */
    @NotNull
    public String getLocale();

    /**
     * Update the list of commands sent to the client.
     * <br>
     * Generally useful to ensure the client has a complete list of commands
     * after permission changes are done.
     */
    public void updateCommands();

    /**
     * 为玩家打开一本{@link Material#WRITTEN_BOOK 成书}.
     * <p>
     * 原文:Open a {@link Material#WRITTEN_BOOK} for a Player
     *
     * @param book 要为玩家打开的书
     */
    public void openBook(@NotNull ItemStack book);

    /**
     * Open a Sign for editing by the Player.
     *
     * The Sign must be placed in the same world as the player.
     *
     * @param sign The sign to edit
     */
    public void openSign(@NotNull Sign sign);

    /**
     * Shows the demo screen to the player, this screen is normally only seen in
     * the demo version of the game.
     * <br>
     * Servers can modify the text on this screen using a resource pack.
     */
    public void showDemoScreen();

    /**
     * Gets whether the player has the "Allow Server Listings" setting enabled.
     *
     * @return whether the player allows server listings
     */
    public boolean isAllowingServerListings();

    // Spigot start
    public class Spigot extends Entity.Spigot {

        /**
         * 返回该玩家的连接地址, 无论地址的真实与否.
         * <p>
         * 原文:Gets the connection address of this player, regardless of whether it
         * has been spoofed or not.
         *
         * @return 该玩家的连接地址
         */
        @NotNull
        public InetSocketAddress getRawAddress() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 获取玩家是否与其它实体产生碰撞.
         * <p>
         * 原文:Gets whether the player collides with entities
         *
         * @return 玩家的碰撞状态
         * @deprecated 另请参见 {@link LivingEntity#isCollidable()}
         */
        @Deprecated
        public boolean getCollidesWithEntities() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 设置玩家是否与其它实体产生碰撞.
         * <p>
         * 原文:Sets whether the player collides with entities
         *
         * @param collides 玩家是否与其它实体产生碰撞
         * @deprecated {@link LivingEntity#setCollidable(boolean)}
         */
        @Deprecated
        public void setCollidesWithEntities(boolean collides) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 若玩家死亡, 令其重生.
         * <p>
         * 原文:Respawns the player if dead.
         */
        public void respawn() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 获取所有用 {@link #hidePlayer(org.bukkit.entity.Player)} 隐藏的玩家.
         * <p>
         * 原文:Gets all players hidden with {@link #hidePlayer(org.bukkit.entity.Player)}.
         *
         * @return 所有隐藏玩家的集合
         */
        @NotNull
        public java.util.Set<Player> getHiddenPlayers() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void sendMessage(@NotNull net.md_5.bungee.api.chat.BaseComponent component) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void sendMessage(@NotNull net.md_5.bungee.api.chat.BaseComponent... components) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 向玩家发送在指定位置展示的聊天消息组件.
         * <p>
         * 原文:Sends the component to the specified screen position of this player
         *
         * @param position 在屏幕上的位置
         * @param component 要发送的聊天消息组件
         */
        public void sendMessage(@NotNull net.md_5.bungee.api.ChatMessageType position, @NotNull net.md_5.bungee.api.chat.BaseComponent component) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 将多个聊天消息组件作为单条消息发送给玩家, 并指定消息的展示位置.
         * <p>
         * 原文:Sends an array of components as a single message to the specified screen position of this player
         *
         * @param position 在屏幕上的位置
         * @param components 要发送的聊天消息组件
         */
        public void sendMessage(@NotNull net.md_5.bungee.api.ChatMessageType position, @NotNull net.md_5.bungee.api.chat.BaseComponent... components) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 向玩家发送在指定位置展示的聊天消息组件.
         * <p>
         * 原文:Sends the component to the specified screen position of this player
         *
         * @param position 在屏幕上的位置
         * @param sender 消息的发送者
         * @param component 要发送的聊天消息组件
         */
        public void sendMessage(@NotNull net.md_5.bungee.api.ChatMessageType position, @Nullable UUID sender, @NotNull net.md_5.bungee.api.chat.BaseComponent component) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * 将多个聊天消息组件作为单条消息发送给玩家, 并指定消息的展示位置.
         * <p>
         * 原文:Sends an array of components as a single message to the specified screen position of this player
         *
         * @param position 在屏幕上的位置
         * @param sender 消息的发送者
         * @param components 要发送的聊天消息组件
         */
        public void sendMessage(@NotNull net.md_5.bungee.api.ChatMessageType position, @Nullable UUID sender, @NotNull net.md_5.bungee.api.chat.BaseComponent... components) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @NotNull
    @Override
    Spigot spigot();
    // Spigot end
}
