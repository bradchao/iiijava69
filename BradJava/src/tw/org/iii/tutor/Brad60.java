package tw.org.iii.tutor;

public class Brad60 {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
		MyRunnable mr1 = new MyRunnable("C");
		Thread t1 = new Thread(mr1);
		mt1.start();
		mt2.start();
		t1.start();
		System.out.println("OK");
	}
}

class MyThread extends Thread {
	private String name;
	MyThread(String name){this.name = name;}
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				
			}
		}
	}
}

class MyRunnable implements Runnable {
	private String name;
	MyRunnable(String name){this.name = name;}
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
