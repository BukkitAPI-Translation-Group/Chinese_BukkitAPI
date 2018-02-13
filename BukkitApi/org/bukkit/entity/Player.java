package org.bukkit.entity;

import java.net.InetSocketAddress;

import org.bukkit.Achievement;
import org.bukkit.ChatColor;
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
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.Conversable;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.map.MapView;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.scoreboard.Scoreboard;

/**
 * 玩家对象
 */
public interface Player extends HumanEntity, Conversable, CommandSender, OfflinePlayer, PluginMessageRecipient {

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
    public void setDisplayName(String name);

    /**
     * 得到玩家显示在tab列表中的名称.
     * <p>
     * 原文:Gets the name that is shown on the player list.
     * 
     * @return 玩家名(显示于tab列表)
     */
    public String getPlayerListName();

    /**
     * 设置玩家显示在Tab列表中的名称.
     * <p>
     * 不允许超过16个字符,不允许重复.但支持{@link ChatColor}颜色代码.
     * <p>
     * 如果设置为null则不在玩家列表中显示.(玩家自己还是看得到的,只不过别人看不到).
     * <p>
     * ("list name"指代“玩家显示在Tab列表中的名称”)(以下解释的是服务器如何处理冲突玩家名，你用代码违法操作肯定是会抛出异常的)
     * 这个名字区分大小写且唯一，也就意味着两个字母相同但字母大小写有别的名字被当作为两个不同的人.
     * 如果一玩家以与某个游戏内玩家的自定义的"list name"相冲突的名字加入游戏，
     * 则追加一个随机数字至这个玩家的"list name".
     * 如果这个玩家的名字较长，那么名字末尾的部分会被截除.
     * <p>
     * 原文:Sets the name that is shown on the in-game player list.
     * <p>
     * The name cannot be longer than 16 characters, but {@link ChatColor} is
     * supported.
     * <p>
     * If the value is null, the name will be identical to {@link #getName()}.
     * <p>
     * This name is case sensitive and unique, two names with different casing
     * will appear as two different people. If a player joins afterwards with
     * a name that conflicts with a player's custom list name, the joining
     * player's player list name will have a random number appended to it (1-2
     * characters long in the default implementation). If the joining player's
     * name is 15 or 16 characters long, part of the name will be truncated at
     * the end to allow the addition of the two digits.
     *
     * @param name 新的显示在玩家列表中的名字
     * @throws IllegalArgumentException 当有名称相同时抛出
     * @throws IllegalArgumentException 当名称超过16个字符时抛出
     */
    public void setPlayerListName(String name);

    /**
     * 设置玩家指南针的指向的位置({@link Location}).
     * <p>
     * 原文:Set the target of the player's compass.
     *
     * @param loc 指向
     */
    public void setCompassTarget(Location loc);

    /**
     * 得到玩家指南针的指向的位置({@link Location}).
     * <p>
     * 译注:默认为出生点.
     * <p>
     * 原文: Get the previously set compass target.
     *
     * @return 指向
     */
    public Location getCompassTarget();

    /**
     * 得到一个Address对象,包括这个玩家的IP以及登入端口.
     * <p>
     * 原文:Gets the socket address of this player
     *
     * @return 玩家的Address对象
     */
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
    public void sendRawMessage(String message);

    /**
     * 踢出玩家,并且发送一条自定义的踢出消息.
     * <p>
     * 原文:Kicks player with custom kick message.
     *
     * @param message 踢出消息
     */
    public void kickPlayer(String message);

    /**
     * 强制玩家发送一个聊天消息,或强制使用命令(需要在内容前加 "/").
     * <p>
     * 原文:Says a message (or runs a command).
     *
     * @param msg 要发送的聊天消息
     */
    public void chat(String msg);

    /**
     * 强制玩家执行某个命令.
     * <p>
     * 原文:Makes the player perform the given command
     *
     * @param command 要执行的命令(不带'/')
     * @return JavaPlugin内的onCommand()方法的返回值
     */
    public boolean performCommand(String command);

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
    public void playNote(Location loc, byte instrument, byte note);

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
    public void playNote(Location loc, Instrument instrument, Note note);


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
    public void playSound(Location location, Sound sound, float volume, float pitch);

    /**
     * 向玩家在某个位置播放一个声音. <p>
     * 当位置或声音为null或玩家的客户端没开启声音时,这个方法无效. <p>
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
    public void playSound(Location location, String sound, float volume, float pitch);

    /**
     * Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null.
     *
     * @param location The location to play the sound
     * @param sound The sound to play
     * @param category The category of the sound
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    public void playSound(Location location, Sound sound, SoundCategory category, float volume, float pitch);

    /**
     * Play a sound for a player at the location.
     * <p>
     * This function will fail silently if Location or Sound are null. No sound
     * will be heard by the player if their client does not have the respective
     * sound for the value passed.
     *
     * @param location the location to play the sound
     * @param sound the internal sound name to play
     * @param category The category of the sound
     * @param volume the volume of the sound
     * @param pitch the pitch of the sound
     */
    public void playSound(Location location, String sound, SoundCategory category, float volume, float pitch);

    /**
     * Stop the specified sound from playing.
     *
     * @param sound the sound to stop
     */
    public void stopSound(Sound sound);

    /**
     * Stop the specified sound from playing.
     *
     * @param sound the sound to stop
     */
    public void stopSound(String sound);


    /**
     * Stop the specified sound from playing.
     *
     * @param sound the sound to stop
     * @param category the category of the sound
     */
    public void stopSound(Sound sound, SoundCategory category);

    /**
     * Stop the specified sound from playing.
     *
     * @param sound the sound to stop
     * @param category the category of the sound
     */
    public void stopSound(String sound, SoundCategory category);

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
    public void playEffect(Location loc, Effect effect, int data);

    /**
     * 在某个位置({@link Location})向玩家播放一个粒子效果({@link Effect}). <p>
     * 原文:Plays an effect to just this player.<p>
     * 译注1:data参数一般为0就行,但是如果要播放的效果为<p>
     * {@link Effect}.StepSound(方块被打破时的粒子效果),data就为{@link Material}类型.<p>
     * 例:playEffect(loc, {@link Effect}.StepSound, Material.REDSTONE_BLOCK)将
     * 在loc的位置播放一个红石块(REDSTONE_BLOCK)被打破的粒子效果.<p>
     * 译注2:{@link Material}只能表示主ID,不能表示副ID,所以播放绿色羊毛的打破效果貌似是不可能的,
     * 但是由于data是泛型,我们猜测会不会data也可以是能表示任何{@link Block 方块}类型?由于时间关系不能测试,请谅解.
     * 
     * @param <T> {@link Material}
     * @param loc 要播放粒子效果的位置
     * @param effect 要播放的粒子效果
     * @param data Effect.StepSound所需的附加值,一般为{@link Material}
     */
    public <T> void playEffect(Location loc, Effect effect, T data);

    /**
     * 向该玩家发送一个伪造的指定位置的方块({@link Block})更改数据包.这不会改变世界中的方块. <p>
     * 原文:Send a block change. This fakes a block change packet for a user at a
     * certain location. This will not actually change the world in any way.<p>
     * 译注:意思就是,向玩家发送一个伪造的,更新方块的数据包,那个位置本来是石头的,这个玩家看起来那里就变成了钻石矿.<p>
     * 但是这并没有真的在世界中放置一个钻石矿.其他玩家看到的还是石头.挖掉后也不会真的掉钻石.(我想还是举例说明比较好..)<p>
     * 例1:sendBlockChange(loc,Material.DIAMOND_ORE,(byte)0)将让玩家的客户端认为loc的位置是一个钻石矿石(DIAMOND_ORE)
     * 但其实并没有改变.<p>
     * 例2:sendBlockChange(loc,Material.WOOL,(byte)14)将让玩家的客户端认为loc的位置是一个红色羊毛(附加值为14的WOOL).
     *
     * @param loc 要改变的方块
     * @param material 要改变成的方块的类型
     * @param data 要改变成的方块的副ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void sendBlockChange(Location loc, Material material, byte data);

    /**
     * 向该玩家发送一个伪造的指定位置的长方体的更改数据包.这不会改变世界中的方块.<p>
     * 原文:Send a chunk change. This fakes a chunk change packet for a user at a
     * certain location. The updated cuboid must be entirely within a single
     * chunk. This will not actually change the world in any way.
     * <p>
     * At least one of the dimensions of the cuboid must be even. The size of
     * the data buffer must be 2.5*sx*sy*sz and formatted in accordance with
     * the Packet51 format.<p>
     * 译注:这..很难解释耶,就是说,这个方法可以让玩家的客户端显示这个长方体内全是钻石矿石233~<p>
     * 具体请看{@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte) }方法.
     * 它其实就是sendBlockChange方法的简单变体.sendBlockChange是伪装一个方块,而这个方法是伪装一堆方块.<p>
     * 例: <p>
     *    byte data = new Byte[27];   //由于我们要发送的是3*3*3的立方体,所以为27<p>
     *    for(int i=0;i&lt;data.lenth;i++) data[i] = (byte)11 //由于我们想把这个立方体里填满岩浆,所以都为11 <p>
     *    player.sendBlockChange(player.getLocation(),3,3,3,data); //完成~上帝保佑那个玩家233 <p>
     *
     * @param loc The location of the cuboid
     * @param sx The x size of the cuboid
     * @param sy The y size of the cuboid
     * @param sz The z size of the cuboid
     * @param data The data to be sent
     * @return true if the chunk change packet was sent
     * @deprecated 不安全的参数
     */
    @Deprecated
    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data);

    /**
     * 类似于 {@link #sendBlockChange(Location loc, Material material, byte data)}方法. <p>
     * Send a block change. This fakes a block change packet for a user at a
     * certain location. This will not actually change the world in any way.
     *
     * @param loc 要改变的方块的位置
     * @param material 要改变成的方块的ID
     * @param data 要改变成的方块的副ID
     * @deprecated 不安全的参数
     */
    @Deprecated
    public void sendBlockChange(Location loc, int material, byte data);

    /**
     * 向该玩家发送一个伪造的牌子({@link Sign})上的字的更改数据包.这不会改变世界中的任何方块. <p>
     * 如果那个位置没有牌子,这个方法将用{@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte) }
     * 方法在那个位置伪造一个牌子然后更改它.<p>
     * 如果客户端认为在指定的位置没有牌子,则会显示一个错误给玩家.<p>
     * 原文:Send a sign change. This fakes a sign change packet for a user at
     * a certain location. This will not actually change the world in any way.
     * This method will use a sign at the location's block or a faked sign
     * sent via {@link #sendBlockChange(org.bukkit.Location, int, byte)} or
     * {@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte)}.
     * <p>
     * If the client does not have a sign at the given location it will
     * display an error message to the user. <p>
     * 译注:该方法类似于{@link #sendBlockChange(org.bukkit.Location, org.bukkit.Material, byte) },
     * 只不过sendBlockChange是伪装一个方块成其他方块,而它只是伪装牌子上的字.
     *
     * @param loc 要让玩家看起来改变了的牌子的位置
     * @param lines null或大小等于4的String数组;数组中每个元素都代表一行
     * @throws IllegalArgumentException 如果该位置没有牌子
     * @throws IllegalArgumentException 如果lines的长度大于4或小于1
     */
    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException;

    /**
     * Render a map and send it to the player in its entirety. This may be
     * used when streaming the map in the normal manner is not desirable. <p>
     * 译注:额...没搞懂...不过一般用不上吧?
     *
     * @param map 要发送的地图
     */
    public void sendMap(MapView map);

    /**
     * 刷新玩家的背包.确保玩家的背包和服务器内存中玩家的背包一致. <p>
     * 译注:在以前的版本(好吧我也不知道是什么版本)中假如不调用该方法当更改背包时会出现莫名其妙的事情,比如
     * 背包看起来是空的,点一下空的格突然出现了东西之类的.... <p>
     * 原文:Forces an update of the player's entire inventory.
     *
     * @deprecated 不需要调用(谁知道呢..保险起见..反正不会报错).
     */
    @Deprecated
    public void updateInventory();

    /**
     * 给予玩家一个成就{@link Achievement}和这个成就所需的父成就. <p>
     * 原文:Awards the given achievement and any parent achievements that the
     * player does not have. <p>
     * 译注:比如,给玩家"这是?工作台!"成就,这个方法就会先给玩家它的父成就"获得木头!"
     *
     * @param achievement 要给玩家的成就(不包括父成就)
     * @throws IllegalArgumentException 当成就为null时抛出.
     * @deprecated 未来版本的Minecraft将不会有成就(取而代之的是进度).
     */
    @Deprecated
    public void awardAchievement(Achievement achievement);

    /**
     * 删除玩家的一个成就及其子成就. <p>
     * 原文:Removes the given achievement and any children achievements that the
     * player has. <p>
     * 译注:假如移除玩家的"获得木头!"成就,同时也会移除"这是?工作台"和后面的所有成就.因为没有"获得木头!"成就,就没后面的成就.
     *
     * @param achievement 要移除的成就
     * @throws IllegalArgumentException 当成就为null时抛出.
     * @deprecated 未来版本的Minecraft将不会有成就(取而代之的是进度).
     */
    @Deprecated
    public void removeAchievement(Achievement achievement);

    /**
     * 判断玩家是否有该成就. <p>
     * 原文:Gets whether this player has the given achievement.
     *
     * @param achievement 被判断的成就
     * @return 玩家是否有该成就
     * @throws IllegalArgumentException 当成就为null时抛出.
     */
    public boolean hasAchievement(Achievement achievement);

    /**
     * 把该玩家的统计信息里的某项+1. <p>
     * 这相当于下面的代码: <p>
     * <code>incrementStatistic(Statistic, 1)</code> <p>
     * 原文:Increments the given statistic for this player.
     * <p>
     * This is equivalent to the following code: <p>
     * <code>incrementStatistic(Statistic, 1)</code> <p>
     *
     * @param statistic 要+1的统计项
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果这个statictic需要一个额外的参数??
     */
    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息里的某项-1. <p>
     * 这相当于下面的代码: <p>
     * <code>decrementStatistic(Statistic, 1)</code>
     * 原文:Decrements the given statistic for this player.
     * <p>
     * This is equivalent to the following code:
     * <code>decrementStatistic(Statistic, 1)</code> <p>
     *
     * @param statistic 要减少的统计项目
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数??
     */
    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息里的某项加上指定的值. <p>
     * 原文:Increments the given statistic for this player. <p>
     *
     * @param statistic 要增加的统计项
     * @param amount 要增加多少
     * @throws IllegalArgumentException 当statistic为null
     * @throws IllegalArgumentException 当amount无效
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数?
     */
    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息里的某项减少指定的值. <p>
     * 原文:Decrements the given statistic for this player. <p>
     *
     * @param statistic 要减少的统计项
     * @param amount 要减少多少
     * @throws IllegalArgumentException 当statistic为null
     * @throws IllegalArgumentException 当amount无效
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数??
     */
    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException;

    /**
     * 设置该玩家的统计信息里的某项的值. <p>
     * 原文:Sets the given statistic for this player. <p>
     *
     * @param statistic 要设置的统计项
     * @param newValue 要把statistic设置成的值
     * @throws IllegalArgumentException 当statistic为null
     * @throws IllegalArgumentException 当amount无效
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数??
     */
    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException;

    /**
     * 得到该玩家的统计信息中某项的值. <p>
     * 原文:Gets the value of the given statistic for this player. <p>
     *
     * @param statistic 要获取值的统计项
     * @return statistic的值
     * @throws IllegalArgumentException 当statistic为null
     * @throws IllegalArgumentException 当amount无效
     * @throws IllegalArgumentException 如果这个统计需要一个额外的参数??
     */
    public int getStatistic(Statistic statistic) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟方块/物品有关的统计项加上一个{@link Material}. <p>
     * 这相当于下面的代码:
     * <code>incrementStatistic(Statistic, Material, 1)</code>
     * 原文:Increments the given statistic for this player for the given material.
     * <p>
     * This is equivalent to the following code:
     * <code>incrementStatistic(Statistic, Material, 1)</code>
     * 译注:比如,要想给玩家的"已破坏过的方块数量"统计里增加一个石头,就用incrementStatistic(统计, Material.STONE)
     *
     * @param statistic 要操纵的统计
     * @param material 要给statistic增加的Material
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果这个成就项使用的不是Material
     */
    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟方块/物品有关的统计项减少一个{@link Material}. <p>
     * 原文:Decrements the given statistic for this player for the given material.
     * <p>
     * This is equivalent to the following code:
     * <code>decrementStatistic(Statistic, Material, 1)</code>
     * 译注:比如,要想给玩家的"已破坏过的方块数量"统计里减少一个石头,就用decrementStatistic(统计, Material.STONE);
     *
     * @param statistic 要操纵的统计
     * @param material 要给statistic减少的Material
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果这个成就项使用的不是Material
     */
    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException;

    /**
     * 获取该玩家的统计信息中跟方块/物品有关的统计项的某{@link Material}有多少. <p>
     * 原文:Gets the value of the given statistic for this player. <p>
     * 译注:译注:比如,要想获得玩家的"已破坏过的方块数量"统计里有多少石头,就用getStatistic(统计,Material.STONE);
     *
     * @param statistic 要获取的统计项
     * @param material statistic中,要获取值的Material
     * @return statistic中,material的数量
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果这个成就项使用的不是Material
     */
    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟方块/物品有关的统计项中的某{@link Material}加上指定的值. <p>
     * 原文:Increments the given statistic for this player for the given material. <p>
     * 译注:比如,要想给玩家的"已破坏过的方块数量"统计里增加指定数量的石头,就用incrementStatistic(统计, Material.STONE, 数量);
     *
     * @param statistic 要操作的统计项
     * @param material statistic里要操作的某个Material
     * @param amount 要把statistic中的material增加多少
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果amount无效
     * @throws IllegalArgumentException 如果statistic跟方块/物品无关
     */
    public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟方块/物品有关的统计项中的某{@link Material}减少指定的值. <p>
     * 原文:Decrements the given statistic for this player for the given material. <p>
     * 译注:该方法与{@link #incrementStatistic(org.bukkit.Statistic, org.bukkit.Material, int) }相反.
     *
     * @param statistic 要减少的统计项
     * @param material statistic中要操作的某个Material
     * @param amount 要把statistic中的material减少多少
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果amount无效
     * @throws IllegalArgumentException 如果这个statistic的值不是Material
     */
    public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中的某个跟方块/物品有关的统计项中的某{@link Material}的数量设定为某值. <p>
     * 原文:Sets the given statistic for this player for the given material. <p>
     * 译注:比如,要想给玩家的"已破坏过的方块数量"统计里的石头破坏数设定为指定数量,就用setStatistic(统计, Material.STONE, 数量);
     *
     * @param statistic 要设置的统计项
     * @param material statistic中的某个Material
     * @param newValue 要把statistic中的material设置的值
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果material为null
     * @throws IllegalArgumentException 如果newVaule无效
     * @throws IllegalArgumentException 如果statistic跟方块/物品无关
     */
    public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟实体有关的统计项中的某种实体({@link EntityType})的数量+1. <p>
     * 这相当于下面的代码: <p>
     * <code>incrementStatistic(Statistic, EntityType, 1)</code> <p>
     * 原文:Increments the given statistic for this player for the given entity.
     * <p>
     * This is equivalent to the following code:
     * <code>incrementStatistic(Statistic, EntityType, 1)</code> <p>
     * 译注:比如,要项给玩家的"已杀过的生物数量"统计里的僵尸数量加上1,就用incrementStatistic(Statistic,EntityType.Zombie);
     *
     * @param statistic 要更改的统计项
     * @param entityType statistic中的某种实体
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entityType为null
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException;

    /**
     * 把该玩家的统计信息中跟实体有关的统计项中的某种实体({@link EntityType})的数量-1. <p>
     * 这相当于下面的代码: <p>
     * <code>decrementStatistic(Statistic, EntityType, 1)</code> <p>
     * 原文:Decrements the given statistic for this player for the given entity.
     * <p>
     * This is equivalent to the following code:
     * <code>decrementStatistic(Statistic, EntityType, 1)</code> <p>
     * 译注:该方法与{@link #incrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType) }相反,可以参见该方法.
     *
     * @param statistic 要更改的统计项
     * @param entityType statistic中的某种实体
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entityType为null
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException;

    /**
     * 获得该玩家的统计信息中跟实体有关的统计项中的某实体({@link EntityType})数量. <p>
     * 原文:Gets the value of the given statistic for this player. <p>
     * 译注:比如,要获得玩家杀过多少僵尸,就用getStatistic(记录玩家杀实体的统计项,EntityType.Zombie);
     *
     * @param statistic 要获得某实体数的统计项
     * @param entityType 要获取数量的statistic的某实体
     * @return statistic中entitytype中的值
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entitytype为null
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException;

    /**
     * 将该玩家的统计信息中的某个跟实体有关的统计项的某实体类型({@link EntityType})加上指定的数值. <p>
     * 原文:Increments the given statistic for this player for the given entity. <p>
     * 译注:跟{@link #incrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType) }类似.只不过这个方法可以指定每次加多少.
     *
     * @param statistic 要操作的统计项
     * @param entityType 要增加的statistic中的某实体
     * @param amount 要增加的数量
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entitytype为null
     * @throws IllegalArgumentException 如果amount无效
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount) throws IllegalArgumentException;

    /**
     * 将该玩家的统计信息中某个跟实体有关的统计项中的某实体类型({@link EntityType})减少指定的值. <p>
     * 原文:Decrements the given statistic for this player for the given entity. <p>
     * 译注:与{@link #incrementStatistic(org.bukkit.Statistic, org.bukkit.entity.EntityType, int) }相反.
     *
     * @param statistic 要操作的统计项
     * @param entityType 要减少的statistic中的某实体
     * @param amount 要减少的数量
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entitytype为null
     * @throws IllegalArgumentException 如果amount无效
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount);

    /**
     * 设置该玩家的统计信息中某个跟实体有关的统计项的某实体类型({@link EntityType})为某个数值. <p>
     * 原文:Sets the given statistic for this player for the given entity. <p>
     *
     * @param statistic 要设置的统计项
     * @param entityType 要设置的statistic中的某实体类型
     * @param newValue 要把statistic中entitytype的数量设置成的值
     * @throws IllegalArgumentException 如果statistic为null
     * @throws IllegalArgumentException 如果entitytype为null
     * @throws IllegalArgumentException 如果newValue无效
     * @throws IllegalArgumentException 如果statistic与实体无关
     */
    public void setStatistic(Statistic statistic, EntityType entityType, int newValue);

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
    public void setPlayerWeather(WeatherType type);

    /**
     * 得到玩家所看到的天气.如果返回null,玩家的天气跟世界的天气一致. <p>
     * 原文:Returns the type of weather the player is currently experiencing.
     *
     * @return 玩家所看到的天气或null
     */
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
     * 得到总共的经验值(等级和经验).
     * <br>
     * 这个数值指玩家随着时间的推移收集的全部经验，并只在玩家死亡时显示为玩家的"得分".
     * <p>
     * 原文:Gets the players total experience points
     * <br>
     * This refers to the total amount of experience the player has collected
     * over time and is only displayed as the player's "score" upon dying.
     *
     * @return 玩家总共有多少经验
     */
    public int getTotalExperience();

    /**
     * 设置总共的经验值. <p>
     * 原文:Sets the players current experience level
     *
     * @param exp 新的玩家总经验
     */
    public void setTotalExperience(int exp);

    /**
     * 得到玩家的疲劳度. <p>
     * 疲劳度控制者玩家的饥饿消耗.当玩家达到一定的疲劳度时,你的饱食度就会下降,并且疲劳度归零. <p>
     * 译注:如果饱食度为0,那么就扣饥饿度. <p>
     * 注释2:运动会产生疲劳度. <p>
     * 原文:Gets the players current exhaustion level.
     * <p>
     * Exhaustion controls how fast the food level drops. While you have a
     * certain amount of exhaustion, your saturation will drop to zero, and
     * then your food will drop to zero.
     *
     * @return 疲劳度
     */
    public float getExhaustion();

    /**
     * 设置玩家的疲劳度. <p>
     * 关于疲劳度,请参见{@link #getExhaustion() }. <p>
     * 原文:Sets the players current exhaustion level
     *
     * @param value 新的疲劳度
     */
    public void setExhaustion(float value);

    /**
     * 得到玩家的饱食度(不是饥饿度). <p>
     * 饱食度是一个饥饿度的缓存.当你的饱食度 {@literal  >}0的时候,饥饿度是不会下降的. <p>
     * 译注:就是说,吃东西的时候,你的饥饿度被填满了,而多出来的部分就是隐藏的饱食度.当你的疲劳值(见{@link #getExhaustion() })
     * 达到一定程度时,如果饱食度不为0,那么先扣饱食度.只有当没饱食度时,才会扣饥饿度.其实饱食度就是饥饿度,只不过是隐藏的. <p>
     * 原文:Gets the players current saturation level.
     * <p>
     * Saturation is a buffer for food level. Your food level will not drop if
     * you are saturated {@literal >} 0.
     *
     * @return 饱食度
     */
    public float getSaturation();

    /**
     * 设置玩家的饱食度(不是饥饿度). <p>
     * 关于饱食度,请参见{@link #getSaturation() }. <p>
     * 原文:Sets the players current saturation level
     *
     * @param value 要设置成的饱食度
     */
    public void setSaturation(float value);

    /**
     * 得到玩家的饥饿度(不是饱食度). <p>
     * 原文:Gets the players current food level
     *
     * @return 饥饿度
     */
    public int getFoodLevel();

    /**
     * 设置玩家的饥饿度(不是饱食度). <p>
     * 原文:Sets the players current food level
     *
     * @param value 新的饥饿度
     */
    public void setFoodLevel(int value);

    /**
     * 得到玩家上一次睡觉的床的位置({@link Location}). <p>
     * 如果玩家没有睡过觉或床已被拆除则返回null. <p>
     * 原文:Gets the Location where the player will spawn at their bed, null if
     * they have not slept in one or their current bed spawn is invalid.
     *
     * @return 玩家上一次睡觉的床的位置,或null
     */
    public Location getBedSpawnLocation();

    /**
     * 设置玩家上一次睡觉的床的位置({@link Location}). <p>
     * 原文:Sets the Location where the player will spawn at their bed.
     *
     * @param location 要设置成的位置
     */
    public void setBedSpawnLocation(Location location);

    /**
     * 设置玩家上一次睡觉的床的位置. <p>
     * 原文:Sets the Location where the player will spawn at their bed.
     *
     * @param location 要设置成的位置
     * @param force true为强制设置,不管那个位置有没有床.
     */
    public void setBedSpawnLocation(Location location, boolean force);

    /**
     * 判断玩家是否能飞起来<p>
     * 译注:如果玩家确实在创造模式,那么一般返回true,除非被setAllowFlight(false);
     * 原文:Determines if the Player is allowed to fly via jump key double-tap like
     * in creative mode.
     *
     * @return 玩家能不能飞起来
     */
    public boolean getAllowFlight();

    /**
     * 设置玩家是否能够飞起来(就像创造模式). <p>
     * 译注:如果被设置为false,即便是创造模式也不能飞.
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
     */
    public void hidePlayer(Player player);

    /**
     * 让该玩家能看到某玩家. <p>
     * 原文:Allows this player to see a player that was previously hidden
     *
     * @param player 要让该玩家看得见的玩家.
     */
    public void showPlayer(Player player);

    /**
     * 检查该玩家是否能看到某玩家. <p>
     * 原文:Checks to see if a player has been hidden from this player
     *
     * @param player 要检查该玩家是否能看到的玩家
     * @return true表示能看到,false反之.
     */
    public boolean canSee(Player player);

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
     * <ul>
     *
     * @param url The URL from which the client will download the texture
     *     pack. The string must contain only US-ASCII characters and should
     *     be encoded as per RFC 1738.
     * @throws IllegalArgumentException Thrown if the URL is null.
     * @throws IllegalArgumentException Thrown if the URL is too long.
     * @deprecated Minecraft已经不使用材质包了,应该用{@link #setResourcePack(String)}设置资源包(额这不是一个意思么..).
     */
    @Deprecated
    public void setTexturePack(String url);

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
     * <li>请求以"null"作hash发送. 这可能导致较新版本的客户端不能正确加载资源包.
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
     * <li>The request is send with "null" as the hash. This might result
     *     in newer versions not loading the pack correctly.
     * </ul>
     *
     * @param url 资源包的URL地址.只能包含US-ASCII字符并且使用RFC 1738编码.
     * @throws IllegalArgumentException 当URL为null时抛出
     * @throws IllegalArgumentException 当URL太长或者不符合规范时抛出
     */
    public void setResourcePack(String url);

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
     * directly apply the cached pack. When this request is sent for the very
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
     *     long.
     */
    public void setResourcePack(String url, byte[] hash);

    /**
     * 获取玩家的计分板. <p>
     * 原文:Gets the Scoreboard displayed to this player
     *
     * @return The current scoreboard seen by this player
     */
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
    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException;

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
     * Gets the entity which is followed by the camera when in
     * {@link GameMode#SPECTATOR}.
     *
     * @return the followed entity, or null if not in spectator mode or not
     * following a specific entity.
     */
    public Entity getSpectatorTarget();

    /**
     * Sets the entity which is followed by the camera when in
     * {@link GameMode#SPECTATOR}.
     *
     * @param entity the entity to follow or null to reset
     * @throws IllegalStateException if the player is not in
     * {@link GameMode#SPECTATOR}
     */
    public void setSpectatorTarget(Entity entity);

    /**
     * Sends a title and a subtitle message to the player. If either of these
     * values are null, they will not be sent and the display will remain
     * unchanged. If they are empty strings, the display will be updated as
     * such. If the strings contain a new line, only the first line will be
     * sent. The titles will be displayed with the client's default timings.
     *
     * @param title Title text
     * @param subtitle Subtitle text
     * @deprecated API behavior subject to change
     */
    @Deprecated
    public void sendTitle(String title, String subtitle);

    /**
     * Sends a title and a subtitle message to the player. If either of these
     * values are null, they will not be sent and the display will remain
     * unchanged. If they are empty strings, the display will be updated as
     * such. If the strings contain a new line, only the first line will be
     * sent. All timings values may take a value of -1 to indicate that they
     * will use the last value sent (or the defaults if no title has been
     * displayed).
     *
     * @param title Title text
     * @param subtitle Subtitle text
     * @param fadeIn time in ticks for titles to fade in. Defaults to 10.
     * @param stay time in ticks for titles to stay. Defaults to 70.
     * @param fadeOut time in ticks for titles to fade out. Defaults to 20.
     */
    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut);

    /**
     * Resets the title displayed to the player. This will clear the displayed
     * title / subtitle and reset timings to their default values.
     */
    public void resetTitle();

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     */
    public void spawnParticle(Particle particle, Location location, int count);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     */
    public void spawnParticle(Particle particle, double x, double y, double z, int count);

    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param location the location to spawn at
     * @param count the number of particles
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, Location location, int count, T data);


    /**
     * Spawns the particle (the number of times specified by count)
     * at the target location.
     *
     * @param particle the particle to spawn
     * @param x the position on the x axis to spawn at
     * @param y the position on the y axis to spawn at
     * @param z the position on the z axis to spawn at
     * @param count the number of particles
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, T data);

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
    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ);

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
    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, T data);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data);

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
    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra);

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
    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data);

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
     * @param data the data to use for the particle or null,
     *             the type of this depends on {@link Particle#getDataType()}
     */
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data);

    /**
     * Return the player's progression on the specified advancement.
     *
     * @param advancement advancement
     * @return object detailing the player's progress
     */
    public AdvancementProgress getAdvancementProgress(Advancement advancement);

    /**
     * Gets the player's current locale.
     *
     * The value of the locale String is not defined properly.
     * <br>
     * The vanilla Minecraft client will use lowercase language / country pairs
     * separated by an underscore, but custom resource packs may use any format
     * they wish.
     *
     * @return the player's locale
     */
    public String getLocale();
}
