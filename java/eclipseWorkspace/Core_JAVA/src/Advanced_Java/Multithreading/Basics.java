package Advanced_Java.Multithreading;

class D1 extends Thread{
	
	@Override
	public void run() {
		int a,b;
		a=10;
		b=20;
		System.out.println(a+b);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class D2 extends Thread{
	@Override
	public void run() {
		System.out.println("Printing characters: ");
		for(int i=65; i<70; i++) {
			System.out.println((char)i);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class D3 extends Thread{
	@Override
	public void run() {
		System.out.println("Printing numbers: ");
		for(int i=65; i<70; i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Basics{
	public static void main(String[] args) {
		D1 o1 = new D1();
		D2 o2 = new D2();
		D3 o3 = new D3();
		
		o1.start();
		o2.start();
		o3.start();
	}
}