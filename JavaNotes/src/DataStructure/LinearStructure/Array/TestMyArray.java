package DataStructure.LinearStructure.Array;

public class TestMyArray {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        array.add(2);
        array.add(4);
        array.add(6);
        array.add(1);
        System.out.println(array.size());  // 4
        array.show();  // [2, 4, 6, 1]

        array.delete(0);
        array.show();  // [4, 6, 1]

        System.out.println(array.get(0));  // 4

        array.insert(0, 10);
        array.show();  // [10, 4, 6, 1]
        array.insert(array.size(), 11);
        array.show();  // [10, 4, 6, 1, 11]

        array.set(0, 12);
        array.show();  // [12, 4, 6, 1, 11]

        System.out.println(array.search(4));
    }
}
