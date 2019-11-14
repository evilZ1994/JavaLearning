package BaseKnowledge.Package;

public class Demo {
    // 包
    // package com.example.demo // 如果出现"."，表示子目录

    // 打包
    // 创建包时，不要手动创建目录，应该使用命令生成：
    // 打包编译：javac -d . Hello.java
    //      - "-d": 生成目录，根据类文件中package关键字后的定义生成
    //      - ".": 设置保存的路径，如果为"."，表示在当前所在路径下
    // 所有的类文件都要定义在包之中，完整的类名就是"包.类"

    // 包的导入
    // import 包.类
    // 关于public class和class 声明类的完整区别：
    // 1. public class: 文件名称必须与类名称保持一致，在一个*.java文件里面只能够有一个public class定义的类
    //                  如果类需要被不同的包所访问，一定要定义public class
    // 2. class: 文件名称可以与类名不一致，并且一个*.java文件可以有个class定义的类，如果一个类使用的是class定义，那么表示这个类只能被本包所访问
    // 在编译时，编译顺序应该是先编译导入的类文件，再编译当前类文件

    // java编译器考虑到多个*.java文件的相互引用，于是提供了通配符"*"
    // javac -d . *.java

    // 一次导入一个包中的多个类：
    // import 包.*
    // 这并不是全部导入，而是导入程序里面所需要的类，而不需要考虑性能问题

    // 导包时可能会出现同名类
    // 在这种情况下为了可以明确的找到所需要的类，可以在使用类时写上完整的类名称：
    // com.example.demo.Test test = new com.example.demo.Test();

    // 系统常见包：
    // java.lang: 包含了String, BaseKnowledge.Object, Integer等类，从JDK1.1开始此包自动导入
    // java.lang.reflect: 反射开发包
    // java.util: Java的工具包，提供了大量的工具类
    // java.util.regex: 正则工具包
    // java.text: 国际化处理程序包
    // java.io: 进行输入、输出处理及文件操作
    // java.net: 网络编程开发包
    // java.sql: 数据库程序开发包

    // jar命令
    // 打包编译后会形成"包.类"的形式，里面有很多*.class文件，要交付用户使用的话需要使用jar命令进行压缩
    // 输入命令jar可以看到相关的使用参数
    // 示例：jar -cvf my.jar cn
    // 生成的my.jar并不能够直接使用，必须配置CLASSPATH才可以加载
    // 输入命令：
    // SET CLASSPATH = .;E:\demo\my.jar
    // 在开发中会使用大量的第三方jar文件，那么所有的jar文件必须配置CLASSPATH才可以使用
    // 最简单的配置方式可以直接环境变量中完成
}
