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
