# Bukkit 中文文档
![Logo](Chinese_BukkitAPI.png)

文档地址：https://docs.windit.net/Chinese_BukkitAPI/ | http://jd.0myun.com/Bukkit/

离线版：https://docs.windit.net/Chinese_BukkitAPI/release.zip

**遇到问题请发Issues或PR，以帮助我们解决相关问题。**
# 项目说明
本项目的目标是翻译BukkitAPI的Javadoc，推进中国原创MC插件的发展，项目由andylizi发起。
# Javadoc注释规范
Javadoc是Sun公司提供的一个技术，它从程序源代码中抽取类、方法、成员等注释形成一个和源代码配套的API帮助文档。      
你所看到的Javadoc，是通过特定格式的注释生成的，利用Java提供的javadoc工具可以生成与源码配套的API文档。   
在开始翻译前, 请先掌握Javadoc文档注释. 
参阅:           
1.http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html (英文)       
2.http://www.cnblogs.com/xt0810/p/3630996.html    
3.http://openwares.net/java/javadoc_convention.html             
# 翻译规范
## 原文保留
为了使文档更严谨、方便比对，必须保留原文。例如：
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
分为三部分, 第一部分为简述: 使用简短的语言描述的用途.    
使用 . 号加一个空格给简述结尾. JavaDoc工具使用". "(英文句号后跟一个空格)来区分简单描述与详细描述, **但不会自动在这两种描述之间添加换行**   

请**统一使用英文标点符号**.    

第二部分为详细描述, 用于详细说明方法用途, 或举一些简单的例子.    

第三部分为JavaDoc标签, 其中有: 参数说明 @param, 返回值说明 @return, 抛出异常说明 @throws 等, 后面会详细说明.    

**请在需要换行的地方请使用 &lt;p&gt; 否则不会换行**

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
如果注释中出现了你不能理解的内容，或翻译过来难以理解，请在原文之前加上译注，用自己的理解继续说明，比如：
```java
/**
 * 获取指定坐标的最顶上的方块的Y坐标(不是空气).  
 * 
 * 译注：意思是获取某个坐标最上面的方块的高度(Y坐标). Essentials插件的top命令就是这个原理.
 * 原文：Gets the highest non-air coordinate at the given coordinates
 *
 * @param x 给定的X坐标
 * @param z 给定的Z坐标
 * @return 在x,y位置的最高的方块的高度(忽略空气)
 */
public int getHighestBlockYAt(int x, int z);
```
-----
## 标签
你之前已经了解了一些javadoc的标签，比如@param、@return、@see、@deprecated等等，这里详细解释下一些特别的标签该如何翻译：    
### **@param 参数名 参数说明**
> @param loc 一个位置({@link Location})    

注意: 参数名不用翻译, 对应的是方法中的参数.
   
   
### **@return 返回值说明**   
> @return 此方块的位置
   
### **@throws 异常类型 在什么情况下会抛出这个异常**    
> @throws IllegalArgumentException 如果PlayerListName超过16个字符
  
注意别把异常的类名去掉. @throws 标签的说明通常以"if"或"如果"开头.
   
### **@deprecated 原因**  
这个标签代表此方法已过时被弃用/不推荐使用, 并说明了原因.    
例如 java.awt.Window 类中的 show() 方法:    
```java
    /**
     * 使窗口可见. 
     * 如果窗口和/或其所有者还不能显示, 则都不显示. 
     * 在使窗口可见之前将验证它. 如果窗口已经可见, 则此方法将窗口带到最前面. 
     * 
     * @see Component#isDisplayable
     * @see #toFront
     * @deprecated 从 JDK 1.5 版开始, 由 {@link #setVisible(boolean)} 取代. 
     */
    @Deprecated
    public void show(); 
```
BukkitAPI中出现的大部分 @deprecated 标签一般是这样的   
> @deprecated Magic value     

Magic value具体是什么意思有点难以解释, 请查阅百度百科 "Magic number" 里 "程序开发中的含义".     
一般出现在 getTypeId() setTypeId() setData() 一类的"方法参数或返回值使用数字来表示类型"的方法.    
为什么不推荐使用? 因为如果使用这些数字, 那么你的代码看起来会是这样的:   
> block.setTypeId(137); 

阅读代码的人: "把这个方块的类型设为..诶等等, 137是哪个方块? 我去查查方块列表..哦原来是命令方块啊"  
如果不使用ID而使用 Material 枚举  
> block.setType(Material.COMMAND_BLOCK);

阅读代码的人: "一看就明白这代码的意思是把这个方块的类型设置为命令方块"  
   
   
### **@see 另请参见**   
不必翻译. 
  
  
### **@since 版本号**  
自从哪个版本加入的这个成员.  
如果只有一个版本号, 不必翻译. 
  
  
### **{@link 类名#成员名}**   
在最终生成的JavaDoc里添加一个指向某类中某成员的超链接.  
如果此文档注释所在的类有 import, 那么@link 里无需写包名, 例如   
```java
    import org.bukkit.Location;
    
    //....此处略
    
    /**
     * 获得此方块所在的{@link Location}.  
     /
    public Location getLocation();
```
但如果没有 import, 则必须写全名   
> 获得此方块所在的 {@link org.bukkit.Location}.  

想指向某类里具体的成员(例如方法, 字段等), 可以使用 #  
> @deprecated 请使用 {@link Block#getType()} 方法代替  

如果成员所在的类就是本类还可以简写为
> @deprecated 请使用 {@link #getType()} 方法代替  

如果有多个名字一样的重载方法可在括号内加参数类型
> @deprecated 从 JDK 1.5 版开始, 由 {@link Window#setVisible(boolean)} 取代. 
  
   
### **{@linkplain 类名#成员名 显示名}**   
跟 @link 相似, 但区别是可以自定义显示的名称. ***显示名称需要进行翻译***.  
(注: @link 也是可以定义显示名的, 所以在某种意义上 @link 与 @linkplain 功能是一样的, 但在 @link 里定义显示名并不是规范的用法.)  
> 获得此 {@link org.bukkit.Block} 的类型, 如果为空气则返回 {@linkplain Material#AIR AIR}.   

会被JavaDoc工具解析为
```html
获得此 <a href="Block.html">Block</a> 的类型, 如果为空气则返回 <a href="Material.html#AIR">AIR</a>.   
```
-----
# 译名标准
如果看到了一些Minecraft上的专有名词，请前往[Minecraft Wiki](http://minecraft-zh.gamepedia.com/Minecraft_Wiki:%E8%AF%91%E5%90%8D%E6%A0%87%E5%87%86%E5%8C%96)查阅，尽量使用官译名。
# 翻译须知
## 翻译质量  
**严禁直接机翻, 若实在不会*请以单词和句子结构为单位进行查询*, 加入自己的理解, 重新组织语言. 否则将撤回**
为什么要以单词为单位? 因为也许电脑程序能当成一本合格的字典来使用, 但绝无法进行合理的语法组织.
## 遇到问题？
如果您翻译时遇到了某些您不能理解的单词、专有名词、段落、概念等等，欢迎在群内提问, **在不能肯定的情况下请别擅下定论**.  
# 提交翻译
Fork本项目并作出您的修改，之后向我们发 Pull Request.
或者您可以申请成员权限，成为成员后可以自由编辑.
