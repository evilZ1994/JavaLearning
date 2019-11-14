package BaseKnowledge.Set;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // Stream数据流

        // Iterable接口提供了一个forEach方法可以取出数据，接收一个函数式方法Consumer<? super T>
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.forEach(System.out::println);

        // 除了Iterator，Collection接口还提供了一个取出数据的方法：public Stream<T> stream()
        // java.uitl.stream.Stream
        List<String> all = new ArrayList<>();
        all.add("Hello");
        all.add("World");
        all.add("Hello");
        all.add("World");
        all.add("!");
        Stream<String> stream = all.stream();
        // BaseKnowledge.System.out.println(stream.count());  // 5

        // Stream类提供的数据处理方法：
        // 消除重复数据：public Stream<T> distinct()
        // BaseKnowledge.System.out.println(stream.distinct().count());  // 3

        // 收集器（最后收集）：public <R,A> R collect(Collector<? super T,A,R> collector)
        //      - Collectors类：public static <T> Collector<T, ?, List<T>> toList()
        // 去除掉所有的重复数据后形成新的集合数据
        List<String> newAll = stream.distinct().collect(Collectors.toList());
        newAll.forEach(System.out::println);

        System.out.println();
        // 数据过滤：public Stream<T> filter(Predicate<? super T> predicate)
        List<String> list1 = new ArrayList<>();
        list1.add("Android");
        list1.add("Java");
        list1.add("Python");
        list1.add("JavaScript");
        list1.add("Perl");
        Stream<String> stream1 = list1.stream();
        // 增加了数据过滤操作，使用了断言型函数式接口
        List<String> newList1 = stream1.distinct().filter((x) -> x.contains("a")).collect(Collectors.toList());
        newList1.forEach(System.out::println);

        System.out.println();
        // 数据处理：Map
        // public <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        Stream<String> stream2 = list1.stream();
        // 加上数据预处理，全部字符转小写
        // List<BaseKnowledge.String> newList2 = stream2.distinct().map((x) -> x.toLowerCase()).filter((x) -> x.contains("a")).collect(Collectors.toList());
        List<String> newList2 = stream2.distinct().map(String::toLowerCase).filter((x) -> x.contains("a")).collect(Collectors.toList());
        newList2.forEach(System.out::println);

        System.out.println();
        // 数据集合分页：
        //      设置跳过的数据行数：public Stream<T> skip(long n)
        //      设置取出的数据个数：public Stream<T> limit(long maxSize)
        Stream<String> stream3 = list1.stream();
        List<String> newList3 = stream3.distinct().map(String::toLowerCase).skip(1).limit(2).collect(Collectors.toList());
        newList3.forEach(System.out::println);

        System.out.println();
        // 进行数据的全匹配或部分匹配
        //     全匹配：public boolean allMatch(Predicate<? super T> predicate
        //     匹配任意一个：public boolean anyMatch(Predicate<? super T> predicate
        Stream<String> stream4 = list1.stream();
        if (stream4.anyMatch((x) -> x.contains("Java"))) {
            System.out.println("数据存在");
        }
        // 实际操作中可能会出现多个匹配条件，在断言型函数式接口里提供有以下方法：
        // 或操作：default Predicate<T> or(Predicate<? super T> other)
        // 与操作：default Predicate<T> and(Predicate<? super T> other)
        Predicate<String> p1 = (x) -> x.contains("Java");
        Predicate<String> p2 = (x) -> x.contains("Python");
        Stream<String> stream5 = list1.stream();
        if (stream5.anyMatch(p1.or(p2))) {
            System.out.println("多条件 数据存在");
        }

        // 数据统计：Reduce
        // public Optional<T> reduce(BinaryOperator<T> accumulator)
        // map做数据处理，reduce做数据统计
        // 实现一个MapReduce
        List<ShopCar> products = new ArrayList<>();
        products.add(new ShopCar("p1", 800.0, 20));
        products.add(new ShopCar("p2", 600.0, 30));
        products.add(new ShopCar("p3", 400.0, 15));
        products.add(new ShopCar("p4", 700.0, 30));
        products.stream().map((x) -> x.getAmount() * x.getPrice()).forEach(System.out::println);
        // 此时针对每一个商品进行了处理，计算出了每个商品的总价。但是没有统计所有商品的总价
        // reduce
        double total = products.stream().map((x) -> x.getAmount() * x.getPrice()).reduce((sum, m) -> sum + m).get();
        System.out.println("商品总价：" + total);

        // 以上只是实现了一个简单的MapReduce
        // 要实现比较完整的统计处理，需要使用Stream接口里面定义的以下方法：
        // 按照Double处理：public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
        // 按照Int处理：public IntStream mapToInt(ToIntFunction<? super T> mapper)
        // 按照Long处理：public LongStream mapToLong(ToLongFunction<? super T> mapper)
        // Stream, DoubleStream, IntStream, LongStream都是BaseStream的子接口
        DoubleSummaryStatistics dStatistics = products.stream().mapToDouble((x) -> x.getAmount() * x.getPrice()).summaryStatistics();
        System.out.println("商品个数：" + dStatistics.getCount());
        System.out.println("总费用：" + dStatistics.getSum());
        System.out.println("平均费用：" + dStatistics.getAverage());
        System.out.println("最高费用：" + dStatistics.getMax());
        System.out.println("最低费用：" + dStatistics.getMin());
    }
}

class ShopCar {
    private String pName;
    private Double price;
    private int amount;

    public ShopCar(String pName, Double price, int amount) {
        this.pName = pName;
        this.price = price;
        this.amount = amount;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
