package lambda;

import java.math.BigInteger;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lambda08 {

	public static void main(String[] args) {
		System.out.println(sum1(20));
		System.out.println(sum2(20));
		System.out.println(sum3(20));
		System.out.println(sumCift(20));
		System.out.println(sumIlkXCift1(20));
		System.out.println(sumIlkXCift2(20));
		System.out.println(sumIlkXTek1(20));
		System.out.println(sumIlkXTek2(20));
		kuvvet2Yazdir(5);
		System.out.println();
		istenenSayininKuvvetYazdir(3,6);//3 9 27 81 243 729
		System.out.println();
		System.out.println(istenenSayininIstenenKuvvet(2, 3));
		System.out.println();
		System.out.println(factorial(5));
		System.out.println();
		System.out.println(factorialBigInteger(50));
	}
	
	//1'den x'e kadar tamsayilari toplayan bir program yaziniz
	//Structured Programming
	public static int sum1(int x) {
		int sum = 0;
		for(int i=1; i<=x; i++) {
			sum = sum + i;
		}
		return sum;
	}
	//Functional Programming
	public static int sum2(int x) {
		return IntStream.range(1, x+1).sum();
	}
	public static int sum3(int x) {
		return IntStream.rangeClosed(1, x).sum();
	}
	
	//1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
	public static int sumCift(int x) {
		return IntStream.rangeClosed(1, x).filter(t->t%2==0).sum();
	}
	
	//Ilk X pozitif cift tamsayiyi toplayan programi yaziniz
	//1.yol:
	public static int sumIlkXCift1(int x) {
		return IntStream.rangeClosed(1, 2*x).filter(t->t%2==0).sum();
	}
	//2.yol: Recommended
	public static int sumIlkXCift2(int x) {
		return IntStream.iterate(2, t->t+2).limit(x).sum();
	}
	//Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
	//1.Yol: Recommended
	public static int sumIlkXTek1(int x) {
		return IntStream.iterate(1, t->t+2).limit(x).sum();
	}
	//2.Yol:
	public static int sumIlkXTek2(int x) {
		return IntStream.rangeClosed(1, 2*x-1).filter(t->t%2!=0).sum();
	}
	
	//2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz ==> 2 4 8 16 32 ...
	public static void kuvvet2Yazdir(int x) {
		IntStream.iterate(2, t->t*2).limit(x).forEach(Lambda01::printEl);
	}
	//Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
	public static void istenenSayininKuvvetYazdir(int a, int x) {
		IntStream.iterate(a, t->t*a).limit(x).forEach(Lambda01::printEl);
	}
	//Istenilen bir sayinin istenilen kuvvetini ekrana yazdiran programi yaziniz
	public static int istenenSayininIstenenKuvvet(int a, int x) {	
		return IntStream.iterate(a, t->t*a).limit(x).reduce(0,(m,n)->n);		
	}
	//Istenilen bir sayinin factorial'ini hesaplayan programi yaziniz. 5! = 1x2x3x4x5
	public static OptionalInt factorial(int x) {
		return IntStream.rangeClosed(1, x).reduce(Math::multiplyExact);//reduce(1, (m,n)->m*n) olur
	}
	//Buyuk sayilarla calisabilmek...
	public static BigInteger factorialBigInteger(int x) {
		return IntStream.rangeClosed(1, x).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply);	
	}

}
