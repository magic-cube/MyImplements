package Iterator;

import java.util.Iterator;

/**
 * ���������ԭ��
 * һ�����������Դ����������������
 * @author hc
 *
 */
public class DeepIterator implements Iterator{
	
	String s[]={"a","b","c"};
	int cursor=-1;
	int size=s.length;
	//�ж��Ƿ�����һ��
	public boolean hasNext(){
		if(cursor+1<size){
			return true;
		}else{
			return false;
		}
		
	}
	//������һ��Ԫ��
	public String next(){
		cursor++;
		return s[cursor];
	}
	//ɾ����һ��
	public void remove(){
		System.arraycopy(s, cursor+1, s, cursor, size-(cursor+1));
		size--;
		cursor--;
	}
	//�������������ÿ�α�������ʱ���������Լ�ȥ����һ�������Ķ���
	public Iterator iterator1(){
		return new DeepIterator();
	}
	
	//ʹ�������ڲ����ʵ��
	public Iterator iterator(){
		return new Iterator(){        //����Iterator�������ӿ�ʵ����(����)�Ķ���
			String s[]={"a","b","c"};
			int cursor=-1;
			int size=s.length;
			//�ж��Ƿ�����һ��
			public boolean hasNext(){
				if(cursor+1<size){
					return true;
				}else{
					return false;
				}
				
			}
			//������һ��Ԫ��
			public String next(){
				cursor++;
				return s[cursor];
			}
			//ɾ����һ��
			public void remove(){
				System.arraycopy(s, cursor+1, s, cursor, size-(cursor+1));
				size--;
				cursor--;
			}
		};
	}
	public static void main(String[] args) {
		DeepIterator i= new DeepIterator();
		
		Iterator it1=i.iterator1();
		while(it1.hasNext()){
			System.out.println(it1.next());
			
		}
		
		System.out.println("-----------------");
		
		//ֻ��Ҫ�ٴ���һ���������Ķ��󣬶�����ȥ����һ����������
		Iterator it =i.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		

	}

}
