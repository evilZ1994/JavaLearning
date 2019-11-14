package basic.socket;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        // 客户端发送数据给服务端
        DatagramSocket socket = new DatagramSocket();
        // 要发送的数据
        byte[] buff = "hello world".getBytes();
        // 将IP地址封装成InetAddress对象
        InetAddress address = InetAddress.getByName("127.0.0.1");
        // 将要发送给服务端的数据封装成DatagramPacket对象，需要填写上ip地址和端口号
        DatagramPacket packet = new DatagramPacket(buff, buff.length, address, 65001);
        // 发送数据给服务端
        socket.send(packet);

        // 客户端接收服务端发送过来的数据
        byte[] data = new byte[100];
        // 创建DatagramPacket对象用来存储服务端发送过来的数据
        DatagramPacket receivePacket = new DatagramPacket(data, data.length);
        // 将接收到的数据存储在DatagramPacket对象中
        socket.receive(receivePacket);
        // 将服务器端发送过来的数据取出来并打印到控制台
        String content = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println(content);
    }
}
