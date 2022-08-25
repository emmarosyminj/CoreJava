package evenOdd;

public class ThreadImplementation1 implements Runnable {

    boolean isOdd= false;
    @Override
    public void run() {
        System.out.println("thread started :: Thread name :: " + Thread.currentThread());
        try {
           for(int i = 1 ; i < 10 ; i++) {
               if(i %2 ==0) {
                   printEven(i);
               }
               else {
                   printOdd(i);
               }
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





    synchronized void printEven(int number)throws InterruptedException  {
        while(!isOdd){
            try {

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even:"+number);
        isOdd = false;
        notifyAll();
    }
    synchronized void printOdd(int number) throws InterruptedException {

        while (isOdd) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Odd :"+number);

        isOdd = true;
        notifyAll();
    }

}