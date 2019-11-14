# 哈希表

>  散列表（Hash table，也叫哈希表），是根据关键码值(Key value)而直接进行访问的数据结构。也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数，存放记录的数组叫做散列表。
>
> 给定表M，存在函数f(key)，对任意给定的关键字值key，代入函数后若能得到包含该关键字的记录在表中的地址，则称表M为哈希(Hash）表，函数f(key)为哈希(Hash) 函数。

哈希表基于数组实现。普通的数组在查找时需要遍历整个数组，查找时间级为O(n)，而哈希表通过把关键字映射为数组下标，查找时间级仅为O(1)。

![](http://upyun.ishavanti.top/img/HashTable1.png)

# 哈希函数的构造方法

- 直接定址法：
  取关键字或关键字的某个线性函数值为哈希地址：H(key) = key 或 H(key) = a·key + b 
  其中a和b为常数，这种哈希函数叫做自身函数。

  注意：由于直接定址所得地址集合和关键字集合的大小相同。因此，对于不同的关键字不会发生冲突。但实际中能使用这种哈希函数的情况很少。

- 相乘取整法：
  首先用关键字key乘上某个常数A(0 < A < 1)，并抽取出key.A的小数部分；然后用m乘以该小数后取整。

  注意：该方法最大的优点是m的选取比除余法要求更低。比如，完全可选择它是2的整数次幂。虽然该方法对任何A的值都适用，但对某些值效果会更好。Knuth建议选取 0.61803……。

- 平方取中法：
  取关键字平方后的中间几位为哈希地址。

  通过平方扩大差别，另外中间几位与乘数的每一位相关，由此产生的散列地址较为均匀。这是一种较常用的构造哈希函数的方法。

  将一组关键字(0100，0110，1010，1001，0111) 
  平方后得(0010000，0012100，1020100，1002001，0012321) 
  若取表长为1000，则可取中间的三位数作为散列地址集：(100，121，201，020，123)。

- 除留余数法：
  取关键字被数p除后所得余数为哈希地址：H(key) = key MOD p (p ≤ m)。

  注意：这是一种最简单，也最常用的构造哈希函数的方法。它不仅可以对关键字直接取模(MOD)，也可在折迭、平方取中等运算之后取模。值得注意的是，在使用除留余数法时，对p的选择很重要。一般情况下可以选p为质数或不包含小于20的质因素的合数。

- 随机数法：
  选择一个随机函数，取关键字的随机函数值为它的哈希地址，即 H(key) = random (key)，其中random为随机函数。通常，当关键字长度不等时采用此法构造哈希函数较恰当。

# 散列冲突的解决方案

## 开放定址法

开放地址法的基本思想是：把记录都存储在散列表数组中，当某一记录关键字key的初始散列地址H0=H（key）发生冲突时，以H0为基础，采取合适方法计算得到另一个地址H1，如果H1仍然发生冲突 ，以H1为基础再求下一个地址H2，若H2仍然冲突，再求H3.依次类推，直至Hk不发生冲突为止，则Hk为记录在表中的散列地址。

这种方法在寻找“下一个”空的散列地址时，原来的数组空间对所有的元素都是开放的，所以称为开放地址法。通常把寻找“下一个”空位的过程称为探测，上述方法可用如下公式表示

　　　　Hi=（H（key）+di）%m     i=1,2,...,k (k<=m-1)

其中，H（key）为散列函数，m为散列表表长，di为增量序列。根据di取值的不同，可以分为以下三种探测方法：

### 线性探测法

di=1，2，3，。。。，m-1

这种探测方法可以将散列表假想成一个循环表，发生冲突时，从冲突地址的下一个单元顺序寻找空单元，如果到最后一个位置也没有找到空单元，则回到表头开始继续查找 ，直到找到一个空位，就把此元素放入空位中，如果找不到空位，则说明散列表已满，需要进行溢出处理。

### 二次探测法

di=1^2, -1^2,  2^2, -2^2,...,+k^2 ,-k^2（k<=m/2）

### 伪随机探测法

di=伪随机数序列

### 总结

如果用线性探测再散列处理冲突，下一个哈希地址为H1=（3 + 1）% 11 = 4，仍然冲突，再找下一个哈希地址为H2=（3 + 2）% 11 = 5，还是冲突，继续找下一个哈希地址为H3=（3 + 3）% 11 = 6，此时不再冲突，将69填入5号单元。

如果用二次探测再散列处理冲突，下一个哈希地址为H1=（3 + 12）% 11 = 4，仍然冲突，再找下一个哈希地址为H2=（3 - 12）% 11 = 2，此时不再冲突，将69填入2号单元。

如果用伪随机探测再散列处理冲突，且伪随机数序列为：2，5，9，……..，则下一个哈希地址为H1=（3 + 2）% 11 = 5，仍然冲突，再找下一个哈希地址为H2=（3 + 5）% 11 = 8，此时不再冲突，将69填入8号单元。

从上述线性探测法处理的过程中可以看到一个现象：当表中 i,i+1,i+2位置上已填有记录时，下一个散列地址为i、i+1、i+2和i+3的记录都将填入i+3的位置，这种在处理冲突过程中发生的两个第一散列地址不同的记录争夺同一个后续散列地址的现象称作“二次聚集（或称作“堆积”）”即在处理同义词的冲突过程中又添加了非同义词的冲突。

可以看出，上述三种处理方法各有优缺点。线性探测法的优点是：只要散列表未填满，总能找到一个不发生冲突的地址：缺点是：会产生“二次聚集”现象。而二次聚集探测法和伪随机探测法的优点是：可以避免“二次聚集”现象；缺点也很显然：不能保证一定找到不发生冲突的地址。

## 再哈希法

这种方法是同时构造多个不同的哈希函数：

Hi=RH1（key）  i=1，2，…，k

当哈希地址Hi=RH1（key）发生冲突时，再计算Hi=RH2（key）……，直到冲突不再产生。这种方法不易产生聚集，但增加了计算时间。

## 链地址法

链表法就是在发生冲突的地址处，挂一个单向链表，然后所有在该位置冲突的数据，都插入这个链表中。插入数据的方式有多种，可以从链表的尾部向头部依次插入数据，也可以从头部向尾部依次插入数据，也可以依据某种规则在链表的中间插入数据，总之保证链表中的数据的有序性。Java的HashMap类就是采取链表法的处理方案。

例：已知一组关键字为(19，14，23，01，68，20，84，27，55，11，10，79)，则按哈希函数 H(key) = key MOD13 和链地址法处理冲突构造所得的哈希表为：

![](http://upyun.ishavanti.top/img/HashTable2.png)

## 建立一个公共溢出区

建立一个基本表，基本表的大小等于哈希表的大小。建立一个溢出表，所有哈希地址的第一个记录都存在基本表中，所有发生冲突的数据，不管哈希算法得到的地址是什么，都放入溢出表中。

但是有一个缺点就是，必须事先知道哈希表的可能大小，而且溢出表里的数据不能太多，否则影响溢出表的查询效率。实际上就是要尽量减少冲突。