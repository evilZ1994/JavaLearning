package Thread.demo01.practice;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    static public <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray = new ArrayList<>();
        for (int i=0; i<page; i++) {
            List<T> subList = new ArrayList<>();
            for (int j=0; j<pageSize; j++) {
                int index = i * pageSize + j;
                if (index >= listSize) {
                    break;
                }
                subList.add(list.get(index));
            }
            listArray.add(subList);
        }

        return listArray;
    }
}
