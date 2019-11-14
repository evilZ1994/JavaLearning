package DataStructure.Tree.HuffmanTree.HuffmanCoding;

import java.io.*;
import java.util.*;

public class HuffmanCoding {
    // 原始byte数组
    private byte[] bytes;
    // 赫夫曼树的根节点
    private Node root;
    // 压缩后的byte数组
    private byte[] encodedBytes;
    // 保存编码表
    private Map<Byte, String> huffCodes = new HashMap<>();

    /**
     * 压缩byte数组
     */
    public HuffmanCoding(byte[] bytes) {
        this.bytes = bytes;
    }

    /**
     * 压缩文件
     * @param file 文件路径
     */
    public HuffmanCoding(String file) {
        try {
            // 创建一个输入流
            InputStream is = new FileInputStream(file);
            // 初始化bytes数组，和输入流指向的文件大小一样
            bytes = new byte[is.available()];
            // 读取文件内容
            is.read(bytes);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 进行赫夫曼压缩的方法
     * @return 压缩后的字节数组
     */
    public byte[] huffmanCoding() {
        if (this.encodedBytes != null) {
            return encodedBytes;
        }
        // 先统计每一个byte出现的次数，并存入一个集合中
        List<Node> nodes = getNodes(bytes);
        // 创建一颗赫夫曼树
        this.root = createHuffmanTree(nodes);
        // 创建一个赫夫曼编码表，保存在huffCodes中
        getCodes();
        // 编码
        zip();
        return this.encodedBytes;
    }

    /**
     * 输出到文件
     */
    public void out2file(String file) {
        try {
            byte[] bytes = huffmanCoding();
            // 输出流
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            // 把压缩后的byte数组写入文件
            oos.writeObject(bytes);
            // 把赫夫曼编码表写入文件
            oos.writeObject(this.huffCodes);
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解码文件
     * @param out 输出文件的路径
     */
    public void decodeFile(String file, String out) {
        try {
            // 读取文件数据
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            // 读取byte数组
            byte[] b = (byte[]) ois.readObject();
            // 读取赫夫曼编码表
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
            ois.close();
            is.close();
            // 解码
            byte[] bytes = huffmanDecoding(b, codes);
            // 创建一个输出流
            OutputStream os = new FileOutputStream(out);
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解码
     * @param bytes
     * @return
     */
    public byte[] huffmanDecoding(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        // 把byte数组转为一个二进制的字符串
        for (int i=0; i<bytes.length; i++) {
            byte b = bytes[i];
            // 最后一个数不用补0
            boolean flag = !(i == bytes.length - 1);
            sb.append(byte2bitStr(b, flag));
        }
        // 把字符串按照指定的赫夫曼编码进行解码
        // 把赫夫曼编码表的键值对进行调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // 由于新的byte数组长度不确定，用一个list集合保存byte
        List<Byte> decodedList = new ArrayList<>();
        // 处理字符串
        for (int i=0; i<sb.length();) {
            int count = 1;
            while (true) {
                String key = sb.substring(i, i + count);
                Byte b = map.get(key);
                if (b != null) {
                    decodedList.add(b);
                    break;
                }
                count++;
            }
            i += count;
        }
        // 把集合转为数组
        byte[] decodedBytes = new byte[decodedList.size()];
        for (int i=0; i<decodedBytes.length; i++) {
            decodedBytes[i] = decodedList.get(i);
        }
        return decodedBytes;
    }

    /**
     * 将字节转为8位二进制的字符串
     * 对于负数，取最后8位，对于正数，前面几位要补0
     * @param flag 是否补0（最后一个数不用补0）
     */
    private String byte2bitStr( byte b, boolean flag) {
        int temp = b;
        if (flag) {
            // 按位或 256
            temp |= 256;
        }
        String s = Integer.toBinaryString(temp);
        if (flag) {
            return s.substring(s.length() - 8);
        }
        return s;
    }

    /**
     * 进行赫夫曼编码
     */
    private void zip() {
        StringBuilder sb = new StringBuilder();
        // 把需要压缩的byte数组处理成一个二进制的字符串
        for (byte b : this.bytes) {
            sb.append(this.huffCodes.get(b));
        }
        // 定义长度
        int len = (int)Math.ceil(sb.length() / 8.0);
        // 初始化encodedBytes
        encodedBytes = new byte[len];
        int index = 0;
        for (int i=0; i<sb.length(); i+=8) {
            String strByte;
            if (i+8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            byte byt = (byte) Integer.parseInt(strByte, 2);
            encodedBytes[index++] = byt;
        }
    }

    /**
     * 创建赫夫曼编码表
     * @return
     */
    private void getCodes() {
        if (this.root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        getCodes(this.root.getLeft(), "0", sb);
        getCodes(this.root.getRight(), "1", sb);
    }

    private void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.getData() == null) {
            getCodes(node.getLeft(), "0", sb2);
            getCodes(node.getRight(), "1", sb2);
        } else {
            huffCodes.put(node.getData(), sb2.toString());
        }
    }

    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
            // 取出两个权值最低的二叉树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            // 创建一棵新的二叉树
            Node parent = new Node(null, left.getWeight() + right.getWeight());
            // 把之前取出来的两棵二叉树设置为新创建的二叉树的子树
            parent.setLeft(left);
            parent.setRight(right);
            // 把之前取出来的两棵二叉树删除
            nodes.remove(left);
            nodes.remove(right);
            // 把新创建的二叉树放入集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转为node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        // 统计每一个byte出现的次数
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count+1);
            }
            // 以上代码在1.8中的实现
            // 参数1是key值，参数2是新的value值，参数3是value更新的函数
            // 参数3的函数有两个参数，第一个参数为旧value值（如果key不存在则直接赋予新value值），第二个参数为新value值
            // counts.merge(b, 1, (a, a2) -> a + 1);
        }
        // 把每一个键值对转换为node对象
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public Node getRoot() {
        return root;
    }

    public Map<Byte, String> getHuffCodes() {
        return huffCodes;
    }
}
