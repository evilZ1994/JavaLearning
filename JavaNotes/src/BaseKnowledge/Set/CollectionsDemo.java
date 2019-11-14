package BaseKnowledge.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        // Collections是对集合操作的一个工具类
        // public class Collections extends BaseKnowledge.Object

        // 为集合追加数据：public static <T> boolean addAll(Collection<? super T> c, T... elements)
        List<String> all = new ArrayList<>();
        Collections.addAll(all, "A", "B", "B");
        System.out.println(all);
        // 反转：public static void reverse(List<T> c)
        Collections.reverse(all);
        System.out.println(all);

        // 注意区分Collection与Collections的区别
        // Collection是集合操作的接口
        // Collections是集合操作的辅助工具类
    }
}
