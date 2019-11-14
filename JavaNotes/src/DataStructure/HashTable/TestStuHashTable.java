package DataStructure.HashTable;

public class TestStuHashTable {
    public static void main(String[] args) {
        StuHashTable hashTable = new StuHashTable();
        hashTable.put(new StuInfo(10, 24));
        hashTable.put(new StuInfo(9, 32));
        hashTable.put(new StuInfo(11, 54));
        hashTable.put(new StuInfo(8, 21));
        hashTable.put(new StuInfo(12, 35));

        System.out.println(hashTable.get(8).getNumber());
    }
}
