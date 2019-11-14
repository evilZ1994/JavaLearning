import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list = list.subList(list.indexOf('a') + 1, list.size());
        System.out.println(list);
    }
}
