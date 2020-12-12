package lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaReview1 {

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
        
        //Listteki tum tek sayilari ekrana yazdiriniz
        list.stream().filter(t->t%2!=0).forEach(Lambda01::printEl);
        System.out.println();
        //Listteki 6 ile 14 arasindaki tum sayilarin karesini ekrana yazdiriniz
        list.stream().filter(t->t>6 && t<14).map(t->t*t).forEach(Lambda01::printEl);
        System.out.println();
        //Listteki tek tamsayilarin karekoklerinin toplamini ekrana yazdiriniz
        //1.Yol
        System.out.println(list.stream().filter(t->t%2!=0).map(Math::sqrt).reduce(Double::sum));
        System.out.println();
        //2.Yol
        System.out.println(list.stream().filter(t->t%2!=0).mapToDouble(Math::sqrt).sum());


	}

}
