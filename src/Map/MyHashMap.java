package Map;

import List.MyLinkedList;

/**
 * ��ʵ�ֵ�HashMap
 * �����ɢ�г�ͻ����
 * Map�ײ��ʵ�֣�����+����
 * ֮ǰ���������д�Ŷ��󣬳���ɢ��
 * �������������д�������������д�Ŷ��󣬽��ɢ�г�ͻ���������Ĵ�СҲ�Ͳ�����Ҫ��
 * ������ʽ���������±���������������д��ڶ��Ԫ�����������������ɢ�г�ͻ������ֻ��һ��Ԫ�أ�����
 * @author hc
 *
 */
public class MyHashMap {
	//�õ������Լ�ʵ�ֵ�����������List��С��MyLinkedList����ȻҲ����java.util���µ�LinkedList������ͺ�
	MyLinkedList [] arr = new MyLinkedList[999];

	private int size;
	public void put(Object key,Object value){
		int a=key.hashCode()%999;       //��ʵ�ֵ�ɢ����
		
		// MyLinkedList list = new MyLinkedList();     //�½�������                                     ****�˴�ע�ⲻ�ܷ������棬��Ȼÿ�ζ��Ὠ��һ������
		
		//��ֵ�Զ���
		Entry e =new Entry(key,value);
		
		//��һ�η�ʱ�ж��Ƿ�Ϊ�գ�Ϊ�շ�������Ϊ��ֱ����������add
		if(arr[a]==null){
			MyLinkedList list = new MyLinkedList();
			arr[a]=list;				//���������������
			list.add(e);                        //���������������
		}else{    
			//a r r [a] ���Ǹ��������
			arr[a].add(e);                      //���������������
		}
		size++;
	}
	public static void main(String[] args) {

	}

}
class Entry{
	Object key;
	Object value;
	Entry(){
		
	}
	Entry(Object key,Object value){
		this.key=key;
		this.value=value;
	}
}
