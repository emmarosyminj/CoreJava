package evenOdd;

public class EvenOddPrintThreadJava implements Runnable{
	
	Object object;
	static int i=1;
	
	

	
	EvenOddPrintThreadJava(Object object) {
		super();
		this.object = object;
	}

	
	public static void main(String[] args) {

		Object obj = new Object();     // This constructor is required for the identification of wait/notify
	    // communication
		//Runnable th1 = EvenOddPrintThreadJava(obj);
		//Runnable th2 = EvenOddPrintThreadJava(obj);
		//new Thread(th1,"even").start();
		//new Thread(th2,"odd").start();
	}


	@Override
	public void run() {
		
		while(i<=10) {
			if(i%2==0 &&  Thread.currentThread().getName().equals("even")) {
				synchronized (object) {
					System.out.println(Thread.currentThread().getName()+ " : " +i);
					i++;
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			if(i%2==0 &&  Thread.currentThread().getName().equals("odd")) {
				synchronized (object) {
					System.out.println(Thread.currentThread().getName()+ " : " +i);
					i++;
					object.notify();
			
		}
		
	}

  }
		
}
	



	
}
