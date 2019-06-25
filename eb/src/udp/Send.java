package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Send implements Runnable{
    @SuppressWarnings("resource")
	public void run(byte [] bytes) {
        //创建一个发送消息的套接字
        DatagramSocket sendSocket = null;
        try {
            sendSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        
        try {
//            System.out.println("发送端发送消息");
//            Scanner sc = new Scanner(System.in);
//            String msg = sc.next();
//
//            byte [] bytes = msg.getBytes();//发送的内容转化为字节数组
            InetAddress ip = InetAddress.getByName("127.0.0.1");//接受内容的Ip地址

            //创建要发送的数据包，然后用套接字发送
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,ip,9090);
            //用套接字发送数据包
            sendSocket.send(datagramPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Send s = new Send();
//        Thread thread = new Thread(s);
//        thread.start();
    	s.run("123".getBytes());
    	
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}