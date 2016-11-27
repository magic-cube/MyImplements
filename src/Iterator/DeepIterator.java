package Iterator;

import java.util.Iterator;

/**
 * 深入迭代器原理
 * 一个容器，可以创建多个迭代器对象
 * @author hc
 *
 */
public class DeepIterator implements Iterator{
	
	String s[]={"a","b","c"};
	int cursor=-1;
	int size=s.length;
	//判断是否有下一个
	public boolean hasNext(){
		if(cursor+1<size){
			return true;
		}else{
			return false;
		}
		
	}
	//返回下一个元素
	public String next(){
		cursor++;
		return s[cursor];
	}
	//删除下一个
	public void remove(){
		System.arraycopy(s, cursor+1, s, cursor, size-(cursor+1));
		size--;
		cursor--;
	}
	//返回这个方法，每次遍历容器时，不用再自己去创建一个容器的对象
	public Iterator iterator1(){
		return new DeepIterator();
	}
	
	//使用匿名内部类的实现
	public Iterator iterator(){
		return new Iterator(){        //创建Iterator迭代器接口实现类(匿名)的对象
			String s[]={"a","b","c"};
			int cursor=-1;
			int size=s.length;
			//判断是否有下一个
			public boolean hasNext(){
				if(cursor+1<size){
					return true;
				}else{
					return false;
				}
				
			}
			//返回下一个元素
			public String next(){
				cursor++;
				return s[cursor];
			}
			//删除下一个
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
		
		//只需要再创建一个迭代器的对象，而不必去创建一个容器对象
		Iterator it =i.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		

	}

}
