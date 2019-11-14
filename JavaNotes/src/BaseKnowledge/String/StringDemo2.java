package BaseKnowledge.String;

public class StringDemo2 {
    public static void main(String[] args) {
        // BaseKnowledge.String 类常用方法：与char的关系
        // 1. 字符数组转String对象
        // public BaseKnowledge.String(char[] value)
        // public BaseKnowledge.String(char[] value, int offset, int count)
        char charArr[] = new char[]{'H', 'e', 'l', 'l', 'o'};
        String s = new String(charArr);
        // 2.返回指定索引的字符
        // public char charAt(int index)
        char c = s.charAt(0);
        // 2. 字符串转字符数组
        // public char[] toCharArray()
        char charArr2[] = s.toCharArray();

        // 范例：给定一个字符串，判断其是否由数字组成
        String s2 = "12938323450";
        System.out.println(isNumbers(s2));

        // BaseKnowledge.String 类常用方法：与byte的关系
        // 1.字节数组转字符串
        // public BaseKnowledge.String(byte[] bytes)
        // public BaseKnowledge.String(byte[] bytes, int offset, int count)
        // 2.字符串转字节数组(用于进行编码转换)
        // public byte[] getBytes(BaseKnowledge.String charsetName) throws UnsupportedEncodingException
    }

    private static boolean isNumbers(String data) {
        for (char c : data.toCharArray()) {
            if (c > '9' || c < '0') {
                return false;
            }
        }
        return true;
    }
}
