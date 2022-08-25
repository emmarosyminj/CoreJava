package java8Features;

import java.util.stream.IntStream;

public class StreamAndParallelStream {

	public static void main(String[] args) {

		//Stream
		IntStream.rangeClosed(0, 10).forEach(t->System.out.println(Thread.currentThread().getName()+t));
		System.out.println("--------------");
		//Parallel Stream
		IntStream.rangeClosed(0, 10).parallel().forEach(t->System.out.println(Thread.currentThread().getName()+" : " +t));
	}

}
