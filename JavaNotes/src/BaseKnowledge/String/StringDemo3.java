package BaseKnowledge.String;

public class StringDemo3 {
    public static void main(String[] args) {
        // 字符串常用方法：字符串的比较
        // public boolean equals(BaseKnowledge.Object obj) // 区分大小写
        // public boolean equalsIgnoreCase(BaseKnowledge.Object obj) // 不区分大小写

        // public int compareTo(BaseKnowledge.String anotherStr)
        // 比较两个字符串的大小（按照字符编码比较）
        // 返回：
        // 0： 表示两个字符串内容相等
        // >0：表示大于的结果
        // <0：表示小于的结果


        // 字符串常用方法：字符串的查找
        // jdk1.5之后
        // public boolean contains(CharSequence s) // 判断指定内容是否存在
        // jdk1.5之前
        // public int indexOf(BaseKnowledge.String str) // 由前往后查找指定字符串的位置，查到则返回第一个字母位置的索引，否则返回-1
        // public int indexOf(BaseKnowledge.String str, int fromIndex)
        // public int lastIndexOf(BaseKnowledge.String str) // 由后往前查找
        // public int lastIndexOf(BaseKnowledge.String str, int fromIndex) // 从指定位置由后向前

        // public boolean startsWith(BaseKnowledge.String prefix) // 判断是否以指定字符串开头
        // public boolean startsWith(BaseKnowledge.String prefix, int toOffset) // 从指定位置开始判断
        // public boolean endsWith(BaseKnowledge.String suffix) // 判读是否以指定字符串结尾


        // 字符串常用方法：字符串的替换
        // public BaseKnowledge.String replace(CharSequence target, CharSequence replacement) // 替换每一个和target相同的子串
        // public BaseKnowledge.String replaceAll(BaseKnowledge.String regex, BaseKnowledge.String replacement) // regex(正则)，替换全部满足条件的内容
        // public BaseKnowledge.String replaceFirst(BaseKnowledge.String regex, BaseKnowledge.String replacement) // 替换首个满足条件的内容


        // 字符串常用方法：字符串的截取
        // public BaseKnowledge.String subString(int beginIndex) // 截取从指定索引到结尾
        // public BaseKnowledge.String subString(int beginIndex, int endIndex) // 截取从开始索引到结束索引

        // 字符串常用方法：字符串的拆分
        // public BaseKnowledge.String[] split(BaseKnowledge.String regex)
        // public BaseKnowledge.String[] split(BaseKnowledge.String regex, int limit) // 部分拆分，见下面的示例
        String s = "hello";
        String arr[] = s.split(""); // 返回["h","e","l","l","o"]
        String arr2[] = s.split("", 3); // 返回["h", "e", "llo"]

        // 范例，拆分IP地址
        String ip = "111.231.233.146";
        String ipArr1[] = ip.split("."); // 返回 [] 空矩阵
        String ipArr2[] = ip.split("\\."); // 返回["111", "231", "233", "146"]
        // 一些正则标记无法拆分，需要使用"\\"转义后才能拆分
    }
}
