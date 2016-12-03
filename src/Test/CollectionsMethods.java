package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 模拟洗牌过程
 * Collections.shuffle()的使用
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
		
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		List<Integer> p3 = new ArrayList<Integer>();
		//底牌
		List<Integer> last = new ArrayList<Integer>();
		//三个人，此时牌已经是乱序，每人依次给一张
		for(int i=0;i<51;i+=3){
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
		}
		//底牌给三张
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		//输出发牌结果
		System.out.println("P1:"+p1);
		System.out.println("P2:"+p2);
		System.out.println("P3:"+p3);
		System.out.println("底牌为："+last);
		
	}

}
