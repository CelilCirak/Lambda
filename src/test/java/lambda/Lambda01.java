package lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda01 {
	
	/*
	   1)Lambda "Functional Programming"
	     "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	   2)"Structured Programming" de "Ne yaparim?" dan cok "Nasil yaparim?" dusunulur.
	   3)"Functional Programming" hiz, kod kisaligi, kod okunabilirligi ve hatasiz kod yazma 
	     acilarindan cok faydalidir
	   4)Lambda sadece collection'larda(List, Queue ve Set) kullanilabilir.  
	*/

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(9);
        list.add(13);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(12);
        list.add(15);
        
        printElStructured(list);
        System.out.println();// Ikinci method alt satira 
						 // yazması icin kullanıyoruz.
        printElFunctional1(list);
        System.out.println();
        printElFunctional2(list);
        System.out.println();
        printElFunctional3(list);
        System.out.println();
        printCiftElStructured(list);
        System.out.println();
        printCiftElFunctional1(list);
        System.out.println();
        printCiftElFunctional2(list);
        System.out.println();
        printKucukOnTekFunctional(list);
        System.out.println();
        printKucukOnVeyaCiftFunctional(list);

	}
	
	//"Structured Programming" ile list elemanlarinin tamamini ayni satirda, aralarina bosluk birakarak console'a yazdiriniz.
	public static void printElStructured(List<Integer> list) {
		for(Integer w:list) {
			System.out.print(w + " ");
		}
	}
	//"Functional Programming" ile list elemanlarinin tamamini ayni satirda, aralarina bosluk birakarak console'a yazdiriniz.
	//Lambda Expression
	public static void printElFunctional1(List<Integer> list) {
//Parantez icine Lambda Expression denir, kullanılması pek tavsiye edilmez.		
list.stream().forEach(t->System.out.print(t + " "));		
	}
	//Method Reference kendi olusturdugum method ile...
	//Method Reference ===> Class Ismi :: Method Ismi
	public static void printEl(int t) {
		System.out.print(t + " ");
	}
	public static void printElFunctional2(List<Integer> list) {
		list.stream().forEach(Lambda01::printEl);		
	}
	
	//Method Reference Java'nin olusturdugu methodlar ile...
	public static void printElFunctional3(List<Integer> list) {
		list.stream().forEach(System.out::print);
	}
	
	//"Structured Programming" ile cift sayi olan list elemanlarinin tamamini ayni satirda, 
	//aralarina bosluk birakarak console'a yazdiriniz.
	public static void printCiftElStructured(List<Integer> list) {
		for(Integer w:list) {
			if(w%2==0) {
				System.out.print(w + " ");
			}
		}
	}
	//"Functional Programming" ile cift sayi olan list elemanlarinin tamamini ayni satirda, 
	//aralarina bosluk birakarak console'a yazdiriniz.
	//Lambda Expression
	public static void printCiftElFunctional1(List<Integer> list) {
		list.stream().filter(t->t%2==0).forEach(t->System.out.print(t + " "));
	}
	//Method Reference kendi methodum ile
	public static boolean isCift(int t) {
		return t%2==0;
	}
	public static void printCiftElFunctional2(List<Integer> list) {
		list.stream().filter(Lambda01::isCift).forEach(Lambda01::printEl);
	}
	
	//"Functional Programming" ile 10'dan kucuk ve tek sayi olan list elemanlarinin tamamini ayni satirda, 
	//aralarina bosluk birakarak console'a yazdiriniz.
	public static void printKucukOnTekFunctional(List<Integer> list) {
		list.stream().filter(t->(t%2!=0 && t<10)).forEach(Lambda01::printEl);
	}
	
	//"Functional Programming" ile 10'dan kucuk veya cift sayi olan list elemanlarinin tamamini ayni satirda, 
	//aralarina bosluk birakarak console'a yazdiriniz.
	public static void printKucukOnVeyaCiftFunctional(List<Integer> list) {
		list.stream().filter(t->(t%2==0 || t<10)).forEach(Lambda01::printEl);
	}

}
