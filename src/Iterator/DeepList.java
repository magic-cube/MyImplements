package Iterator;
/**
 * ���list�ĵ���������
 * ʹ���������ڲ���ʵ�ֵ���������
 * ����˷���-->ʹ�ÿ��Բ��ݶ�������
 */
import java.util.Arrays;
import java.util.Iterator;

public class DeepList<E> implements java.lang.Iterable{    //ʵ������ӿ���Ϊ���ܹ�ʹ����ǿforѭ��
	private Object [] arr ;
	private int size=0;  //������С
	
	
	DeepList(){
		arr=new Object[10];
	}
	DeepList(int i){
		arr=new Object[i];
	}
	
	//��ӷ�������һ������
	public void add(E obj){
		if(size==arr.length){      //��������������
			arr=Arrays.copyOf(arr, size*2+1);
			//����ʹ��
//			Object newArray=new Object[size*2+1];
//			System.arraycopy(arr, 0, newArray, 0, arr.length);
//			arr=newArray;
		}
		arr[size++]=obj;
	}
	public int size(){
		return this.size;
	}
	//List�ĵ���������
	public Iterator<E> iterator(){
		return new Iterator<E>(){
			int cursor=-1;
			public boolean hasNext(){
				if(cursor+1<size){
					return true;
				}else{
					return false;
				}
			}
			public E next(){
				cursor++;
				return (E)arr[cursor];          //�˴������ǿ������ת�� 	תΪE����
			}
			public void remove(){
				System.arraycopy(arr, cursor+1, arr, cursor, size-(cursor+1));
				size--;
				cursor--;
			}
		};
	}
	public static void main(String[] args) {
		DeepList<String> list = new DeepList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			//�ó�������object
			//System.out.println((int)it.next());
			System.out.println(it.next());
			//System.out.println((String)it.next());
		}
		System.out.println("--------");
		for(Object obj:list){
			System.out.println(obj);
		}
	}

}
