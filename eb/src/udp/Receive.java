package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Receive implements Runnable {
    @Override
    public void run() {
        System.out.println("接收端");
        //创建接受消息的套接字
        DatagramSocket receviceSocket = null;
        try {
            receviceSocket = new DatagramSocket(9090);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                byte [] bytes = new byte[2048];
                //创建一个数据包来接受消息
                DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
                //用套接字接受数据包
                receviceSocket.receive(datagramPacket);
                //得到发送端的ip地址对象
                InetAddress ip = datagramPacket.getAddress();
                //将接受到的消息转换为字符串
                String rec = new String(datagramPacket.getData()) ;
                System.out.println(ip.getHostAddress()+"发送的消息为："+rec);

            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Receive r = new Receive();
        Thread thread = new Thread(r);
        thread.start();
    }
}