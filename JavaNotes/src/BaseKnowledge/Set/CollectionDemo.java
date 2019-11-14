package BaseKnowledge.Set;

public class CollectionDemo {
    public static void main(String[] args) {
        // Collection是整个类集之中单值保存的最大父接口。即：每一次可以向集合里面保存一个对象
        // Collection的定义：
        // public interface Collection<E> extends Iterable<E>

        // 在Collection接口里定义有如下几个常用方法：
        // 1. public boolean add(E e)
        // 2. public boolean addAll(Collection<? extends E> c)
        // 3. public void clear()
        // 4. public boolean contains(BaseKnowledge.Object o)
        // 5. public boolean isEmpty()
        // 6. public boolean remove(BaseKnowledge.Object o)
        // 7. public int size()
        // 8. public BaseKnowledge.Object[] toArray()
        // 9. public Iterator<E> iterator()

        // contains()和remove()方法一定要依靠equals()支持

        // Collection的两个子接口：List, BaseKnowledge.Set
        // List与Set的区别：List允许重复，Set不允许重复
    }
}
