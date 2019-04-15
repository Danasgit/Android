# Android
一个简单的自定义进度条
他是一个自定义组合控件

目前有以下组件
1、LinearProgress 线性进度条
      略微的区别是他
      1>可以通过setRound来设置是否为圆角，圆角的半径为组件的高度
      2>如果设置为圆角,他的右侧在非100%时显示为直角
2、LinearDotProgress 线性圆点进度条
      设置一系列的点来表示进度。
      主要方法：
      1>setDefultColor(int) 圆点默认的颜色
      2>setSelectColor(int) 圆点被选中的color
      3>setDotCount(int) 您希望的圆点数量
      
 使用示例：
 DanasCustomProgress pregress = new DanasCustomProgress(this);//控件初始化
 pregress.add(new LinearProgress(this).//添加一个线性控件
 setBgCoclor(0xff00ff00).
 setProgressCoclor(0xffff0000).
 setHeightPX(20).
 setRound(true).
 setMax(100).
 setProgress(60));
 pregress.add(new LinearDotProgress(this).//添加一个圆点控件
 setDotCount(3).
 setDefultColor(0xff00ff00).
 setSelectColor(0xffff0000).
 setMax(100).
 setProgress(60).
 setHeightPX(45));
 
 
 如果您希望与我取得联系，请发送邮件到 zhenzhangApp@163.com ，感谢您的支持。
