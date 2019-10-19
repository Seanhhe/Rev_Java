package tw.org.iii.myreview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*		20180818	網路基本概論	0:54	Brad61
 * 		封包的接收與傳送
 * 		DatagramSocket
 * 		DatagramPacket
 * 		
 * 		發送方
 */

public class Rev063_Net3 {

	public static void main(String[] args) {
		//	發送方：port號選擇any available
		byte[] buf = "Hello".getBytes();
		
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(buf
							, buf.length
							, InetAddress.getByName("192.169.1.2")
							, 9999);
			//	發送封包
			socket.send(packet);
			
			//	關閉封包
			socket.close();
			System.out.println("Message Sent (訊息已傳送)");
			
		} catch (SocketException e) {
			System.out.println("SocketException : " + e);
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
	}

}
