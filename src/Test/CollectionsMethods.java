package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 模拟洗牌过程
 * @author hc
 *
 */
public class CollectionsMethods {

	public static void main(String[] args) {
		List<Integer> cards = new ArrayList<Integer>();
		//54张牌
		for(int i=0;i<54;i++){
			cards.add(i);
		}
		//洗牌，随机排序
		Collections.shuffle(cards);
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		//三个人，此时牌已经是乱序，每人依次给一张
		for(int i=0;i<51;i+=3){
			list1.add(cards.get(i));
			list2.add(cards.get(i+1));
			list3.add(cards.get(i+2));
		}
		//输出发牌结果
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}

}
