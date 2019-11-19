package tw.org.iii.myreview;

public class Rev066_02_ClientCode {

	public static void main(String[] args) {
		/*	1. read local file
		 * 	2. send TCP data
		 */
		new Rev066_02_ClientThreadCode("172.20.10.3", 8000).start();
	}

}
