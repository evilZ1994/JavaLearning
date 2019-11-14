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
