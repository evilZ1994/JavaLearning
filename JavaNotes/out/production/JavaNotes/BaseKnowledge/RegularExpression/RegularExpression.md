# 正则标记

所有的正则可以使用的标记都在java.util.regex.Pattern类里面定义

- 单个字符（数量：1）
  - 字符：表示由一位字符所组成
  - \\\\：表示转义字符"\\"
  - \t：表示制表符"\t"
  - \n：匹配换行符"\n"
- 字符集（数量：1）
  - \[abc\]：表示可能是字符a或者是字符b或者是字符c中的任意一位
  - \[^abc\]：表示不是a, b, c中的任意一位
  - [a-z]：所有的小写字母
  - \[a-zA-Z\]: 表示任意的一位字母，不区分大小写
  - [0-9]：表示任意的一位数字
- 简化的字符集表达式（数量：1）
  - .：表示任意的一位字符
  - \d：等价于“\[0-9\]"，属于简化写法（在字符串中使用时，斜线需要转义，即写作"\\\d"）
  - \D：等价于“\[^0-9\]”，属于简化写法
  - \s：表示任意的空白字符，例如："\t", "\n"
  - \S：表示任意的非空白字符
  - \w：等价于"\[a-zA-Z_0-9\]"，表示由任意的字母，数字或下划线_所组成
  - \W：等价于"\[^a-zA-Z_0-9\]"，表示不是由任意的字母，数字或下划线_所组成
- 边界匹配（不要在Java中使用，在JavaScript里使用）
  - ^：正则的开始
  - $：正则的结束
- 数量表达
  - 正则?：表示此正则可以出现**0**次或**1**次
  - 正则+：表示此正则可以出现**1**次或**1次以上**
  - 正则*：表示此正则可以出现**0**次，**1**次或**多**次
  - 正则{n}：表示此正则正好出现**n**次
  - 正则{n,}：表示此正则出现**n次**或**n次以上**
  - 正则{n,m}：表示此正则出现**n~m**次
- 逻辑运算
  - 正则1正则2：正则1判断完成之后继续判断正则2（“与”）
  - 正则1|正则2：正则1或者正则2有一组满足即可（“或”）
  - (正则)：将多个正则作为一组，可以为这一组单独设置出现的次数

# String类对正则的支持

- public boolean matcher(String regex)

  正则验证，使用指定的字符串判断其是否符合给出的正则表达式结构

- public String replaceAll(String regex, String replacement)

  全部替换

- public String replaceFirst(String regex, String replacement)

  替换首个

- public String[] split(String regex)

  全部拆分

- public String[] split(String regex, int limit)

  部分拆分

## 示例

```java
package BaseKnowledge.RegularExpression;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RegexDemo {
    public static void main(String[] args) throws ParseException {
        // 示例1：字符串替换
        // 仅保留以下字符串中的小写字符
        String str = "sdfAkdsf=DsdASa239DSg0sd";
        String regex = "[^a-z]";  // 匹配非小写字母
        System.out.println(str.replaceAll(regex, ""));

        // 示例2：字符串拆分
        // 按数字拆分以下字符串
        str = "sdfs879sFg28=fh8Mhh13LJ";
        regex = "\\d+";  // 匹配一个或多个数字
        String[] result = str.split(regex);
        System.out.println(Arrays.toString(result));

        // 示例3：验证一个字符串是否是数字，如果是则将其变为double类型
        // 数字可能是整数(10)，也可能是小数(10.2)
        str = "10.22";
        regex = "\\d+(\\.\\d+)?";  // 小数部分作为一个整体，出现0次或1次
        if (str.matches(regex)) {
            System.out.println(Double.parseDouble(str));
        }

        // 示例4：判断给定的字符串是否是一个IP地址(IPV4)
        // IP地址：192.168.1.1，每一个段最大长度为3
        str = "192.168.1.1";
        regex = "(\\d{1,3}\\.){3}\\d{1,3}";  // 数字加点出现3次，再出现一次数字
        System.out.println(str.matches(regex));

        // 示例5：给定一个字符串，判断其是否是日期格式，如果是则将其转换为Date类型
        str = "2009-03-23";
        regex = "\\d{4}-\\d{2}-\\d{2}";
        if (str.matches(regex)) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            System.out.println(date);
        }

        // 示例6：判断电话号码，一般要编写电话号码，以下几种格式都是满足的：
        // 格式一：51283346，一般长度是7~8位的数字是电话号码 "\\d{7,8}"
        // 格式二：010-51283346，区号一般是3~4位，而且区号和电话之间的"-"只有在出现区号时才出现 "(\\d{3,4}-)?\\d{7,8}"
        // 格式三：(010)-51283346
        str = "(010)-51283346";
        regex = "((\\d{3,4}-)|(\\(\\d{3,4}\\)-))?\\d{7,8}";
        System.out.println(str.matches(regex));

        // 示例7：验证e-mail地址
        // 格式：
        // 用户名由数字，字母，下划线_或点.组成，其中必须以字母开头，以字母或数字结尾，
        // 用户名长度不超过30
        // 最后的根域名只能够是.com, .cn, .net, .com.cn, .net.cn, .edu, .gov, .org
        str = "hello_123world@gmail.com";
        // [\.]与[.]作用相同，所以"."在中括号中不需要转义(表示匹配点而不是匹配任意字符）
        regex = "[a-zA-Z][a-zA-Z0-9_.]{0,28}[a-zA-Z0-9]@\\w+\\.(com|cn|net|com.cn|net.cn|edu|gov|org)";
        System.out.println(str.matches(regex));
    }
}
```

# java.util.regex

在java.util.regex包中定义了两个主要的类：

- Pattern类：使用Pattern.complie()方法才能取得该类对象，方法的功能是编译正则表达式
- Matcher类：通过Pattern类对象调用matcher()方法取得。

## 示例

```java
package BaseKnowledge.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUtilRegexDemo {
    public static void main(String[] args) {
        // 示例：按数字拆分
        String str = "as87fh08ghsd87fc0w4xcb08fdh";
        String regex = "\\d+";
        // 编译正则
        Pattern pattern = Pattern.compile(regex);
        // 进行正则匹配
        Matcher matcher = pattern.matcher(str);
        // 匹配结果
        System.out.println(matcher.matches());
    }
}
```

