package BaseKnowledge.Java5NewFeatures;

// import BaseKnowledge.Temp.MyMath;

// 静态导入所有的静态方法
import static BaseKnowledge.Temp.MyMath.*;

/**
 * 静态导入
 */
public class StaticImportDemo {
    public static void main(String[] args) {
        // MyMath类中的方法全是静态方法

        // 之前的静态方法的基本使用方法，用类名调用
        // BaseKnowledge.System.out.println(MyMath.add(10, 20));

        // 静态导入后，直接用方法名就可以调用
        System.out.println(add(10, 20));
    }
}
