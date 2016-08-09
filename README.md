# Chinese_BukkitAPI 翻译规范 v1.4
__翻译前必须阅读此页！！！__
# 项目说明
本项目的目标是翻译BukkitAPI的Javadoc，推进中国原创MC插件的发展，项目由andylizi发起。
# Javadoc注释规范
Javadoc是Sun公司提供的一个技术，它从程序源代码中抽取类、方法、成员等注释形成一个和源代码配套的API帮助文档。
你所看到的Javadoc，是通过特定格式的注释生成的，利用Java提供的javadoc工具可以生成与源码配套的API文档。在开始翻译前，请先掌握Javadoc注释格式。
参阅：
1.http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html (英文)
2.http://www.cnblogs.com/xt0810/p/3630996.html
3.http://openwares.net/java/javadoc_convention.html
# 翻译规范
## 原文保留
为了使文档更严谨、方便比对，必须保留原文。
方法注释必须保留原文，例如：
```java
/**
 * 获取世界当前的PVP设置.
 * <p>
 * 原文：
 * Gets the current PVP setting for this world.
 *
 * @return 如果允许PVP则返回true
 */
public boolean getPVP();
```
关于换行：使用"<p>"进行换行。
原文与译文用<p>分开换行。
原文与译文必须是连贯的，译文一句原文一句是错误的。
例外：类注释、枚举注释、标签一般不需要保留原文，若是比较难懂的、一大串的则需要保留。
## 类注释
类注释即为类的描述，介绍了类的作用等，比如：
```java
/**
 * Represents a Command, which executes various tasks upon user input
 */
public abstract class Command {
...
}
```
## 枚举注释
即枚举类中对一些字段的注释，例如：
```java
/**
 * 橡树
 */
TREE,
...
```
## 方法注释
一个例子：
```java
/**
 * (1)Checks if this player is currently online
 *
 * (2)@return true if they are online
 */
public boolean isOnline();
```
(1)处为方法的描述，是需要翻译的地方。
(2)处为javadoc的标签，javadoc的标签以"@"开头，对应的标签就有对应的说明。关于标签在下一部分详细说明。
如果注释中出现了你不能理解的、或翻译过来难以理解，在原文之前加上译注，用自己的理解继续说明，比如：
```java
/**
 * 获取指定坐标的最顶上的方块的Y坐标(不是空气).
 * <p>
 * 译注：就是说,获取某个坐标最上面的方块的高度(Y坐标).Essentials插件的top命令就是这个原理.
 * <p>
 * 原文：Gets the highest non-air coordinate at the given coordinates
 *
 * @param x 给定的X坐标
 * @param z 给定的Z坐标
 * @return 在x,y位置的最高的方块的高度(忽略空气)
 */
public int getHighestBlockYAt(int x, int z);
```
## 标签
你之前已经了解了一些javadoc的标签，比如@param、@return、@see、@deprecated等等，这里详细解释下一些特别的标签该如何翻译：
### @param
param标签用来说明方法中各个参数的含义
格式：
@param 参数名 参数说明
参数说明部分就是这里要翻译的部分。
例子：
> @param address 要封禁的IP地址

有时没有说明，那就保留原样
### @return
return标签用来说明方法返回值的含义。
格式：
> @return 返回值说明

例子：
> @return 踢出消息

### @see
see标签用来引用相关链接
格式：
> @see 链接

例子：
> @see #getOfflinePlayer(java.util.UUID)
> @see Bukkit
> @see <a href="xxx">xxx</a>

### @deprecated
deprecated标签用来解释这个方法被弃用的原因
格式：
> @deprecated 弃用理由

例子：
> @deprecated 请使用{@link #getPlayer(UUID)}，因为玩家名不能保证是唯一的

### @throws
throws标签用来说明抛出错误在哪些情况等
格式：
> @throws Throwable 解释

例子：
> @throws IllegalArgumentException 如果图像是空的

这里要特别提一下，Bukkit源码里大量的弃用标示是这样的：
> @deprecated Magic value

Magic value直译即为魔法值，意义大概就是不明确的数值，这些数值一般都难以理解，所以叫做“魔法值”，在程序中不应该出现这些东西。
在这里统一译作“不安全的参数”。
### @link
link标签是一个比较特殊的标签之一，可以直接用在描述注释里，可以用这个标签直接引向一个类、方法等。
格式：
> {@link 链接 链接文本}

链接文本是非必要的，如果出现了链接文本，翻译链接文本部分
例子：
> {@link Bukkit}
> {@link Player 玩家}

其他标签就大同小异了
# 翻译须知
## 任务
任务是为了更好规划整体进度和便于统计.
大家可以主动申请任务，翻译完成后在之后加上“待校验”以及挂上标签以便识别。
**注意：不可以私自设置为完成状态**，此任务**必须被校对后才可以算完成.**
例如：
“翻译org.bukkit.Bukkit类”
“翻译org.bukkit.event.entity包”
“翻译org.bukkit.entity.Player类 待校验”
## 翻译质量
**严禁直接机翻，若机翻请加入自己的理解，重新组织语言，否则将撤回**
## 遇到问题？
如果您翻译时遇到了某些您不能理解的单词、专有名词、段落、概念等等，可以在群内提问。
# 提交翻译
方法有两种，一是通过在线编辑器直接编辑，最直接。二是将项目仓库克隆下来，编辑完后推送上去。根据您的喜好选择其中一种方式吧。
感谢您阅读本规范，祝您工作愉快^_^