package tw.org.iii.myreview;
/*		20180818AM1		網路基本概論 00:54:00  
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
 * 		*
 * 
 */
public class Rev062_Net2 {

	public static void main(String[] args) {
		
	}

}
