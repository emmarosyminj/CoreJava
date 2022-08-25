package evenOdd;

public class ThreadBasic1 {

    public static void main(String[] args) {


       Thread t1 = new Thread(new ThreadImplementation1());
       Thread t2 = new Thread(new ThreadImplementation1());

       t1.start();
       t2.start();

    }
}


