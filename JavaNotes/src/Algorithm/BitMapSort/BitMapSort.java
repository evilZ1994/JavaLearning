package Algorithm.BitMapSort;

/**
 * 假设我们要对0-7内的5个元素(4,7,2,5,3)排序（这里假设这些元素没有重复）。那么我们就可以采用Bit-map的方法来达到排序的目的。要表示8个数
 * ，我们就只需要8个Bit（1Bytes），首先我们开辟1Byte的空间，将这些空间的所有Bit位都置为0
 * 　　然后遍历这5个元素，首先第一个元素是4，那么就把4对应的位置为1。
 * 　　然后再处理第二个元素7，将第八位置为1,，接着再处理第三个元素，一直到最后处理完所有的元素，将相应的位置为1。
 *
 * 　　然后我们现在遍历一遍Bit区域，将该位是一的位的编号输出（2，3，4，5，7），这样就达到了排序的目的。
 *
 * @author peng.jia
 *
 */
public class BitMapSort {

    public static void main(String[] args) {
        // 字符串排序可以考虑将字符串按照每个char与数字的转换关系来排序,同时要考虑字母大小写问题
        // String[] strArray = { "a", "b", "x", "ar", "yy", "zz" };
        int[] intArray = { 1000, 2, 9, 56, 4, 100 };

        BitMapSort bms = new BitMapSort();
        bms.intBitMap(intArray);
    }

    public void intBitMap(int[] intArray) {
        // 找出最大值
        int max = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            }
        }

        // 计算需要的字节数
        int bitMapSize = max * 8;
        byte[] bitMap = new byte[bitMapSize];

        // 将array中的每个数所对应的bit下标设置为1
        for (int i = 0; i < intArray.length; i++) {
            bitMap[intArray[i] / 8] = (byte) (bitMap[intArray[i] / 8] | (0x1 << (7 - intArray[i] % 8)));
        }
        // 输出结果
        for (int i = 0; i < bitMap.length; i++) {
            // 遍历每个unsigned char中的bit
            for (int j = 7; j >= 0; j--) {
                // 如果指定的unsigned char bitmap[i]的第j位（从低位往高位数）不为0，输出该bit的下标
                if ((bitMap[i] & (0x1 << j)) != 0) {
                    System.out.print(i * 8 + (7 - j) + ",");
                }
            }
        }
    }
}
