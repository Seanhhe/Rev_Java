package tw.org.iii.myreview;

/*		20180825AM2 Brad80
 * 		執行緒應用_生產者與消費者 => 提款機
 * 
 * 		重點：執行緒同時存取同物件該如何處理？
 * 
 * 		=> 執行緒們同時發生，且同時存取相同的物件
 * 		=> 要記得做鎖定的動作 synchronized (同步)
 * 
 * 		First Run
 * 		=> 提款機可以同時被領 --> 造成金額不合理
 * 
 * 		Second Run	(嘗試解決問題)
 * 		=> 1. 在領錢方法前加上 synchronized 修飾字 (鎖定該方法，使其只能被一個人使用)
 * 		=> 2. 在Client類別中的領錢動作加上 synchronized block，
 * 				鎖定該資料結構物件 (當該方法非自己寫的時候)
 */

public class Rev082_ATM01 {

	public static void main(String[] args) {
		ATM atm1 = new ATM();
		Bank bank1 = new Bank(atm1);
		Client p1 = new Client(atm1, "John");
		Client p2 = new Client(atm1, "Allen");
		Client p3 = new Client(atm1, "Brad");
		
		bank1.start();
		p1.start();
		p2.start();
		p3.start();
	}

}

class ATM {
	private int limit = 1000;
	private int money;
	
	// ATM deposit(存款方法)
	void deposit(int add) {
		if (money + add > limit) {
			System.out.println("Deposit Failed");
		}else {
			money += add;
			System.out.println("Add: " + add + " => " + money);
		}
	}
	
	// ATM withdraw(提款方法)
	// 避免同時存取：如果方法是自己設計的 => 在那個方法前加上 synchronized 即可鎖定
	void withdraw(int get, String name) {
		if (money < get) {
			// 存款不足請回去
			System.out.println(name + " Not Enougn Money");
		}else {
			money -= get;
			System.out.println(name + " withdraw " + get + " => " + money);
		}
	}
}

class Bank extends Thread {
	// 銀行隨時會來存錢
	private ATM atm; // 針對哪一台ATM
	
	public Bank(ATM atm) {
		this.atm = atm;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (atm) {
				atm.deposit(500); // 一次補500
			}
			
			try {
				Thread.sleep(1000); // 補完錢睡一下
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class Client extends Thread {
	// 客戶隨時會來領錢
	private ATM atm; // 到哪一台領
	private String name;
	
	public Client(ATM atm, String name) {
		this.atm = atm;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (atm) {
				// 鎖定被存取的資料結構
				atm.withdraw((int)(Math.random()*100 +1), name);
				// 亂數領錢
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}