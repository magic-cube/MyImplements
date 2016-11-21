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
	static final int LENGTH=997;
	MyLinkedList [] arr = new MyLinkedList[LENGTH];

	private int size;
	public void put(Object key,Object value){
		
		//��ΪhashCode����Ŀ���Ϊ���������Զ������д���	
		int hash=key.hashCode();
		hash=hash<0?-hash:hash;         //hashС���㷵�������෴��
		
		
		int a=hash%LENGTH;       //��ʵ�ֵ�ɢ����
		
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
			
			//����ֵ�Ƿ��ظ�����������
			MyLinkedList list=arr[a];
			for(int i=0;i<list.size();i++){
				Entry e2=(Entry)arr[a].get(i);
				if(e2.key.equals(key)){
					e2.value=value;                //��ֵ�ظ���ֱ�Ӹ���
					return ;
				}
			}
			arr[a].add(e);                      //���������������
		}
		size++;
	}
	public Object get(Object key){
		//��ѯһ��ֵ�Ĺ��̱�Ϊ�ˣ��ȼ���ɢ���룬Ȼ��ʹ��ɢ�����ѯ����
		
		int hash=key.hashCode();
		hash=hash<0?-hash:hash;          
		int a=hash%LENGTH;                //ɢ����ļ������
		
		if(key!=null){
			
			if(arr[a]!=null){
				for(int i=0;i<arr[a].size();i++){
					Entry e =(Entry)arr[a].get(i);
					if(e.key.equals(key)){
						return e.value;
					}
				}
			}
			
		}
		return null;
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
