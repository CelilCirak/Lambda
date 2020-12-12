package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MountainArrayTr {
	
	/*
	    Bu Mountain Array'dir ==> [0, 2, 5, 3, 1]
	    Maximum degere kadar surekli artiyor, maximum degerden sonra surekli azaliyor.
	    Bu tip array'lere mountain array dersek; verilen bir array'in mountain array olup olmadigina
	    karar veren bir program yaziniz
	    
	    Bu Mountain Array degildir ==> [5, 2, 7, 1, 4]
    */

	public static void main(String[] args) {
	
		int a[] = {0, 2, 5, 3, 2, 1};
		
		//Array'i liste cevir
		List<Integer> l1 = new ArrayList<>();
		
		for(Integer w:a) {
			l1.add(w);
		}
		System.out.println(l1);
		
		//Array'deki maximum elemani bul
		Arrays.sort(a);
		int maxEl = a[a.length-1];
		System.out.println(maxEl);
		
		//Ilk kismi al ve bir list'in icine yerlestir
		List<Integer> l11 = new ArrayList<>();
		for(int i=0; i<=l1.indexOf(maxEl); i++) {
			l11.add(l1.get(i));
		}
		System.out.println(l11);
		
		//Ilk kismi baska bir list'in icine koy ve sort et
		List<Integer> l11Sorted = new ArrayList<>();
		for(Integer w:l11) {
			l11Sorted.add(w);
		}
		Collections.sort(l11Sorted);
		System.out.println(l11Sorted);
		
		//sort etmeden once ve sort ettikten sonra list'ler esit ise tamam yaz degil ise tamam degil yaz
		if(l11.equals(l11Sorted)) {
			System.out.println("Birinci sart tamam");
		}else {
			System.out.println("Birinci sart tamam degil");
		}
		
		//Ikinci kismi al ve bir list'in icine yerlestir
		List<Integer> l12 = new ArrayList<>();
		for(int i=l1.indexOf(maxEl); i<=l1.size()-1; i++) {
			l12.add(l1.get(i));
		}
		System.out.println(l12);
		
		//Ikinci kismi baska bir list'in icine koy ve reverse sort et
		List<Integer> l12ReverseSorted = new ArrayList<>();
		for(Integer w:l12) {
			l12ReverseSorted.add(w);
		}
		Collections.sort(l12ReverseSorted);
		Collections.reverse(l12ReverseSorted);
		System.out.println(l12ReverseSorted);
		
		//Reverse sort etmeden once ve reverse sort ettikten sonra list'ler esit ise tamam yaz degil ise tamam degil yaz
		if(l12.equals(l12ReverseSorted)) {
			System.out.println("Ikinci sart tamam");
		}else {
			System.out.println("Ikinci sart tamam degil");
		}
		
		//Son karar
		if(l11.equals(l11Sorted) && l12.equals(l12ReverseSorted)) {
			System.out.println("Bu array Mountain Array'dir");
		}else {
			System.out.println("Bu array Mountain Array degildir");
		}
	
	}

}
