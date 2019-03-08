# VestTemplate
简单的马甲包，实现基础彩票数据的基础模版包。

### 项目开发概述
1. 基于简单的MVP模式实现
MVP基础项目可参考：[ProjectMVP](https://github.com/vivek-wo/ProjectMVP)

2. 启动页面的思考
涉及Android冷启动和热启动知识，实现启动白屏或者黑屏的优化。
* 设置窗体背景为透明
更改Activity Theme `windowBackground`为透明。

* 设置Activity Theme `windowBackground` 为背景图。
背景图会一直占用内存资源，应使用 **.9** 图，然后在资源布局中再次布置界面或者实现动画功能。

  启动页涉及底部导航，应直接选择隐藏，如设置Theme `windowTranslucentNavigation`为**true**，则会导致底部导航闪烁问题。

3. 引导页的实现
通过ViewPager实现引导功能页，圆形指示器设计为LinearLayout直接动态设置。

4. 数据爬取
通过JSoup实现数据爬取功能。掌握数据爬取方法。

5. Design包`NestedScrollView`的简单实现
6. 基于GIMP的矢量图制作
7. PS图片资源的简单制作

### 待设计功能
未知时间延期实现功能。
1. 基于33选6和16选1的多点选择器实现，通过自定义View实现。
2. 基于布局归一动画和随机分布动画，实现点击翻转动画。
3. 服务器功能的设计和实现。
