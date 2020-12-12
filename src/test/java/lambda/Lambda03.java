package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambda03 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(9);
        list.add(-13);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(-12);
        list.add(15);
        
        ciftKareMax(list);
        toplamEl(list);
        toplamEl2(list);
        carpimEl(list);
        carpimEl2(list);
        min1(list);
        min2(list);
        min3(list);
        min4(list);
        OndanKucukEnBuyuk(list);
        tekKupSirala(list);
        System.out.println();
        ciftKareTersSira(list);
        

	}
	
	//List'teki cift sayi olan elemanlarin karelerini aliniz en buyuk olanini console'a yazdiriniz
	public static void ciftKareMax(List<Integer> list) {
		Optional<Integer> max = list.stream().filter(Lambda01::isCift).
				map(t->t*t).reduce(Integer::max);
		System.out.println(max);
	}
	
	//List'teki tum elemanlarin toplamini console'a yazdiriniz
	//Lambda Expression
	public static void toplamEl(List<Integer> list) {
		int toplam  = list.stream().reduce(0,(x, y)->x+y);
		System.out.println(toplam);
	}
	//Method Reference
	public static void toplamEl2(List<Integer> list) {
		Optional<Integer> toplam  = list.stream().reduce(Integer::sum);
		System.out.println(toplam);
	}

	//List'teki cift sayi olan elemanlarin carpimini console'a yazdiriniz
	public static void carpimEl(List<Integer> list) {
		int carpim = list.stream().
				filter(Lambda01::isCift).reduce(1,(x,y)->x*y);//-23040
		System.out.println(carpim);		
	}
	
	//Method Reference
	public static void carpimEl2(List<Integer> list) {
		Optional<Integer> carpim = list.stream().
				filter(Lambda01::isCift).
				reduce(Math::multiplyExact);
		System.out.println(carpim);		
	}
	
	//Listteki elemanlardan en kucugunu 4 farkli yol kullanarak bulalim
	//1)Method Reference methodlar Java'dan al
	public static void min1(List<Integer> list) {
		Optional<Integer> min = list.stream().reduce(Integer::min);
		System.out.println(min);
	}
	//2)Method Reference methodlar Java'dan al
	public static void min2(List<Integer> list) {
		Optional<Integer> min = list.stream().reduce(Math::min);
		System.out.println(min);
	}
	//3)Method Reference method'lar kendimizden
	public static int minBul(int x, int y) {
		return x<y ? x : y;
	}
	public static void min3(List<Integer> list) {
		Optional<Integer> min = list.stream().reduce(Lambda03::minBul);
		System.out.println(min);
	}
	//4)Lambda Expression
	public static void min4(List<Integer> list) {
		int min = list.stream().reduce(Integer.MAX_VALUE, (x,y)-> x<y ? x : y);
		System.out.println(min);
	}
	
	// Odev: Listteki elemanlardan en buyugunu 4 farkli yol kullanarak bulalim
	
	//List'teki elemanlardan 10 dan kucuk en buyuk sayiyi bulunuz
	public static void OndanKucukEnBuyuk(List<Integer> list) {
		Optional<Integer> max = list.stream().filter(t->t<10).reduce(Integer::max);
		System.out.println(max);
	}
	
	//List'teki elemanlardan tek sayi olanlarin kuplerini kucukten buyuge console'a yazdiriniz
	public static void tekKupSirala(List<Integer> list) {
		list.stream().filter(t->t%2!=0).map(t->t*t*t).sorted().forEach(Lambda01::printEl);
	}
	
	//List'teki elemanlardan cift sayi olanlarin karelerini buyukten kucuge console'a yazdiriniz
	public static void ciftKareTersSira(List<Integer> list) {
		list.stream().filter(Lambda01::isCift).
				map(t->t*t).sorted(Comparator.reverseOrder()).
				forEach(Lambda01::printEl);
	}

}
