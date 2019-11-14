package DataStructure.HashTable;


/**
 * 简单的哈希表示例
 */
public class StuHashTable {
    private StuInfo[] data = new StuInfo[100];

    public void put(StuInfo info) {
        // 调用散列函数获取存储位置
        int index = hash(info.getAge());
        // 添加元素
        data[index] = info;
    }

    public int hash(int key) {
        // 简单的散列函数
        return key%100;
    }

    public StuInfo get(int key) {
        return data[hash(key)];
    }
}
