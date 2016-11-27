package Iterator;

import java.util.Arrays;
import java.util.Iterator;

public class DeepList {
	Object [] arr ;
	int size=0;  //������С
	
	
	DeepList(){
		arr=new Object[10];
	}
	DeepList(int i){
		arr=new Object[i];
	}
	
	//��ӷ�������һ������
	public void add(Object obj){
		if(size==arr.length){
			arr=Arrays.copyOf(arr, size*2+1);
			//����ʹ��
//			Object newArray=new Object[size*2+1];
//			System.arraycopy(arr, 0, newArray, 0, arr.length);
//			arr=newArray;
		}
		arr[size++]=obj;
	}
	
	//List�ĵ���������
	public Iterator iterator(){
		return new Iterator(){
			int cursor=-1;
			public boolean hasNext(){
				if(cursor+1<size){
					return true;
				}else{
					return false;
				}
			}
			public Object next(){
				cursor++;
				return arr[cursor];
			}
			public void remove(){
				System.arraycopy(arr, cursor+1, arr, cursor, size-(cursor+1));
				size--;
				cursor--;
			}
		};
	}
	public static void main(String[] args) {
		DeepList list = new DeepList();
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator it = list.iterator();
		while(it.hasNext()){
			//�ó�������object
			//System.out.println((int)it.next());
			
			System.out.println(it.next());
			
			//System.out.println((String)it.next());
		}
				
	}

}
