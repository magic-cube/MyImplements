package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * ģ��ϴ�ƹ���
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
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		//�����ˣ���ʱ���Ѿ�������ÿ�����θ�һ��
		for(int i=0;i<51;i+=3){
			list1.add(cards.get(i));
			list2.add(cards.get(i+1));
			list3.add(cards.get(i+2));
		}
		//������ƽ��
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}

}
