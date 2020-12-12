package lambda;

import java.util.HashMap;
import java.util.Scanner;

public class InterviewQuestion03 {
	
	/*
	 Size verilen bir String'de tekrarli character'leri ve kac kere tekrar ettigini ekrana yazdiriniz
	 Ornegin; String "Ali baba" ==> a=2, b=2
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Tekrarli characterleri gormek icin bir String giriniz");
		String str = scan.nextLine();
		
		tekrarliCharBul(str);
		
	}
	
	public static void tekrarliCharBul(String str) {
		
		String harf[] = str.split("");
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String w:harf) {
			if(map.containsKey(w)) {
				int harfSayisi = map.get(w);
				map.put(w, harfSayisi+1);
			}else {
				map.put(w, 1);
			}
		}
		
		HashMap<String, Integer> mapSon = new HashMap<>();
		
		for(String w:harf) {
			if(map.get(w)>1) {
				mapSon.put(w, map.get(w));
			}
		}
		
		System.out.println(mapSon);

	}

}
