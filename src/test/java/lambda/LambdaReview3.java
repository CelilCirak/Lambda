package lambda;

import java.util.stream.IntStream;

public class LambdaReview3 {

	public static void main(String[] args) {
		
		//Ilk 10, 7 ile bolunebilen pozitif tamsayilarin toplamini ekrana yazdiriniz
		// 7+14+21+28+35+42+49+56+63+70=?
		//1.Yol
		System.out.println(IntStream.rangeClosed(1, 70).filter(t->t%7==0).sum());
		//2.Yol
		System.out.println(IntStream.iterate(7, t->t+7).limit(10).sum());

	}

}
