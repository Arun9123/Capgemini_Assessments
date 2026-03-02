package Advanced_Java.Multithreading;

class Demo20 implements Runnable{
	int count = 0;
	synchronized public void show() {
		count++;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i<500; i++) {
			show();
		}
	}
	
}
public class SyncDemo {
	public static void main(String[] args) {
		Demo20 d = new Demo20();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d.count);
	}
}
