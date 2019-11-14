package DataStructure.Tree.HuffmanTree.HuffmanCoding;

import java.util.Arrays;

public class TestHuffmanCoding {
    public static void main(String[] args) {
        // {32=11, 97=11, 114=1, 99=7, 115=1, 117=1, 101=1, 121=1, 110=8, 111=1}
        String msg = "can you can a can as a can canner can a can";
        byte[] bytes = msg.getBytes();

        // 进行赫夫曼编码
        HuffmanCoding tree = new HuffmanCoding(bytes);
        byte[] encodedBytes = tree.huffmanCoding();
        System.out.println(Arrays.toString(tree.getBytes()));
        System.out.println(Arrays.toString(tree.huffmanDecoding(encodedBytes, tree.getHuffCodes())));
        System.out.println(new String(tree.huffmanDecoding(encodedBytes, tree.getHuffCodes())));

        // 测试文件压缩
        String path = "src/DataStructure/Tree/HuffmanTree/HuffmanCoding/";
        HuffmanCoding fileTree = new HuffmanCoding(path + "test.jpg");
        // 压缩后图片变大了？因为编码表内容也比较多？
        // 图片越复杂压缩率越低，越单一的图片压缩率越高
        fileTree.out2file(path + "encoded.jpg");
        System.out.println(fileTree.getBytes().length);
        System.out.println(fileTree.huffmanCoding().length);
        // 解压缩文件
        fileTree.decodeFile(path + "encoded.jpg", path + "decoded.jpg");
    }
}
