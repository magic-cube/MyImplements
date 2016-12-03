package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * ģ��ϴ�ƹ���
 * Collections.shuffle()��ʹ��
 * @author hc
 *
 */
public class CollectionsMethods {

	public static void main(String[] args) {
		List<Integer> cards = new ArrayList<Integer>();
		//54����
		for(int i=0;i<54;i++){
			cards.add(i);
		}
		//ϴ�ƣ��������
		Collections.shuffle(cards);
		
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		List<Integer> p3 = new ArrayList<Integer>();
		//����
		List<Integer> last = new ArrayList<Integer>();
		//�����ˣ���ʱ���Ѿ�������ÿ�����θ�һ��
		for(int i=0;i<51;i+=3){
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
		}
		//���Ƹ�����
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		//������ƽ��
		System.out.println("P1:"+p1);
		System.out.println("P2:"+p2);
		System.out.println("P3:"+p3);
		System.out.println("����Ϊ��"+last);
		
	}

}
