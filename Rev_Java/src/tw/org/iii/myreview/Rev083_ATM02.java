package tw.org.iii.myreview;

/*		20180825AM2 Brad81 ATM v2
 * 		執行緒應用_生產者與消費者 => 提款機
 * 
 * 		重點：執行緒同時存取同物件該如何處理？
 * 
 * 		=> 執行緒們同時發生，且同時存取相同的物件
 * 		=> 要記得做鎖定的動作 synchronized
 * 
 * 		First Run
 * 		=> 提款機可以同時被領 --> 造成金額不合理
 * 
 * 		Second Run (試解決問題)
 * 		=> 1. 在領錢方法
 * 		=> 2. 在Client類別中的領錢動作加上 synchronized block 鎖定該資料結構 (當該方法非自己寫的時候)
 * 
 * 		版本二：重點加入 wait();
 * 		=> 錢不夠會進入等待，錢夠了再進來
 * 		=> 等待要搭配 notifyAl(); 通知所有人;
 * 		notify 只會通知門口等的那個
 * 
 * 		wait() & notify() & notifyAll() 要注意搭配使用，
 * 		避免發生類似範例的程式死結(DeadLock)
 * 
 * 		參考網址：
 * 		https://openhome.cc/Gossip/JavaGossip-V2/WaitNotify.htm
 */

public class Rev083_ATM02 {

	public static void main(String[] args) {
		ATM2 atm1 = new ATM2();
		Bank2 bank1 = new Bank2(atm1);
		Client2 p1 = new Client2(atm1, "Allen");
		Client2 p2 = new Client2(atm1, "Brad");
		Client2 p3 = new Client2(atm1, "Charlie");
		Client2 p4 = new Client2(atm1, "Danny");
		
		bank1.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}

}

class ATM2 {
	private int limit = 1000;
	private int money;
	
	// deposit (存款方法)
	void deposit(int add) {
		while(money + add > limit) {
			try {
				// 錢夠了就等
				System.out.println("Bank : " + add + " : waiting( " + money + " )");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		money += add;
		System.out.println("Add : " + add + " => " + money);
		notifyAll(); // 通知其他人
	}
	
	// withdraw 提款方法
	// 避免同時存取：如果方法是自己設計的	=> 在那個方法前 家上synchronized 即可鎖定
	void withdraw(int get, String name) {
		while(money < get) {
			// 錢不夠領 => wait
			try {
				System.out.println(name + " / " + get + " waiting: " + money);
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		money -= get;
		System.out.println(name + " Withdraw " + get + " => " + money);
		notifyAll();
	}
}

class Bank2 extends Thread {
	// 銀行隨時會來存錢
	private ATM2 atm; // 針對哪一台ATM
	
	public Bank2(ATM2 atm) {
		this.atm = atm;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
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

class Client2 extends Thread {
	// 客戶隨時會來領錢
	private ATM2 atm; // 到哪一台領
	private String name;
	
	public Client2(ATM2 atm, String name) {
		this.atm = atm;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			synchronized (atm) {
				atm.withdraw((int)(Math.random()*100)+1, name);
				// 亂數領錢
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}