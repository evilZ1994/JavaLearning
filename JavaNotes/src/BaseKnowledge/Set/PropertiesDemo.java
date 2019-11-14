package BaseKnowledge.Set;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        // Properties类
        // 是Hashtable的子类
        // 主要是进行属性的操作
        // public class Properties extends Hashtable<BaseKnowledge.Object, BaseKnowledge.Object>
        // 在使用Properties类的时候不需要设置泛型类型，因为它从一开始出现就只能够保存字符串类型

        // 常用方法：
        // 1. 设置属性：public BaseKnowledge.Object setProperty(BaseKnowledge.String key, BaseKnowledge.String value)
        // 2. 取得属性：public BaseKnowledge.String getProperty(BaseKnowledge.String key)
        // 3. 取得属性：public BaseKnowledge.String getProperty(BaseKnowledge.String key, BaseKnowledge.String defaultValue), 如果key不存在，则返回默认值

        Properties properties = new Properties();
        properties.setProperty("BJ", "北京");
        properties.setProperty("TJ", "天津");
        System.out.println(properties.getProperty("BJ"));
        System.out.println(properties.getProperty("GD", "广东"));

        // 在Properties类中提供有数据输出操作：public void store(OutputStream out, BaseKnowledge.String comments) throws IOException
        properties.store(new FileOutputStream(new File("area.properties")), "地区");
        // 从指定的输入流读取数据：public void load(InputStream in) throws IOException
        Properties proper2 = new Properties();
        proper2.load(new FileInputStream(new File("area.properties")));
        System.out.println(proper2);
    }
}
