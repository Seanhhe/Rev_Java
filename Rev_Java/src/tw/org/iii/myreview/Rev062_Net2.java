package tw.org.iii.myreview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*		20180818AM1		網路基本概論 00:54:00  
 * 
 * 		接收端
 * 
 * 		Brad60 (DatagramSocket 接收端)
 * 		
 * 		cmd ping --> 可以證明對方在，但不能證明對方不在
 * 
 * 		網段中封包連續發生16次碰撞 (同時間有兩個封包發出)，網段crash
 * 		同一個網段間才能進行資料交換
 * 		router-->網路位址交換
 * 
 * 		UDP/TCP
 * 		傳送的可靠性又將封包格式分為連接導向的 TCP 及非連接導向的 UDP 封包格式
 * 		DNS最常用的是UDP (90%)
 * 		TCP: 三方交握 / 三方驗證 (可靠性較高)
 * 
 * 		Port: 0~65535
 * 		[0~1024預設port盡量不要用
 * 			(DNS: 53; POP3: 101; FTP: 21, 22; Telnet: 23)]
 * 		
 * 		UDP: java.net.DatagramSocket
 * 		封包的接收與傳送
 * 		DatagramSocket: This class represents a socket for sending and receiving datagram packets
 * 
 * 		DatagramPacket
 * 		接收方不需IP
 * 
 * 		讀取資料要找接收端的packet(詳細的發送端資料) & buffer(傳送的封包內容)
 * 
 * 		*如果要持續接收，可跑無窮迴圈？
 * 
 */
public class Rev062_Net2 {

	public static void main(String[] args) {
		
		// 接收用的陣列 
		byte[] buf = new byte[1024]; // 指定接收用陣列之長度
		
		try {
			// 接收一次性的封包 (建立物件並指定通訊port)
			DatagramSocket socket = new DatagramSocket(9999);
			
			// 接收用封包 (建立物件封包並指定 接收的陣列物件 & 其陣列物件的長度 )
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			
			System.out.println("Before");
			// 啟動接收封包
			socket.receive(packet);
			
			System.out.println("After");
			
			// 關閉封包
			socket.close(); // 是不是要關閉封包後，才可以存取封包內容？
			
			// 存取接收到的封包內容
			byte[] data = packet.getData();
			// 封包資料長度
			int len = packet.getLength();
			//
			int dataLen = data.length;
			InetAddress ip = packet.getAddress();
			System.out.println(ip.getHostAddress() + " : " + len + " : " + new String(data) + "封包長度：" + dataLen);
			
		} catch (SocketException e) {
			//	SocketException | IOException 非直系血親可這樣用
			//	例外發生：該port號被占用			
			System.out.println("SocketException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
	}

}
