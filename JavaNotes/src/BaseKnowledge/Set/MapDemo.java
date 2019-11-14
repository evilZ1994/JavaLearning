package BaseKnowledge.Set;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        // Map
        // public interface Map<K, V>
        // 保存键值对
        // 常用方法：
        // 保存数据：public V put(K key, V value)
        // 根据key查找对应的value：public V get(BaseKnowledge.Object key)
        // 将Map集合转化为Set集合：public BaseKnowledge.Set<Map.Entry<K, V>> entrySet()
        // 取出全部的key：public BaseKnowledge.Set<K> keySet()

        // 两个常用子类：HashMap, Hashtable

        // HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("壹", 1);
        hashMap.put("贰", 2);
        hashMap.put("叁", 33);
        hashMap.put("叁", 3);
        System.out.println(hashMap);  // {贰=2, 叁=3, 壹=1}
        // HashMap定义的Map集合是无序的
        // 如果出现了重复的key，会进行覆盖，使用新的内容替换掉旧的内容。
        hashMap.put(null, 0);
        System.out.println(hashMap.get("壹"));  // 1
        System.out.println(hashMap.get("伍"));  // null
        System.out.println(hashMap.get(null));  // 0

        Set<String> set = hashMap.keySet();
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // Hashtable
        Map<String, Integer> hashTable = new Hashtable<>();
        hashTable.put("壹", 1);
        hashTable.put("贰", 2);
        hashTable.put("叁", 33);
        hashTable.put("叁", 3);
        // Hashtable里面对于key和value的值都不能为空

        // HashMap是异步的，Hashtable是同步的

        // 每当用户使用put方法保存数据的时候，所有的数据都被自动封装为Map.Entry接口对象
        // public static interface Map.Entry<K,V>
        // 这个接口里有两个主要方法：
        // public K getKey()
        // public V getValue()

        // Map集合里可以将Map集合转为Set集合：public BaseKnowledge.Set<Map.Entry<K, V>> entrySet()
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
        }

        // Map可以使用自定义的任意类型来作为Key或Value。
        // 作为Key的自定义类必须要覆写Object类的hashCode()和equals()方法
    }
}
