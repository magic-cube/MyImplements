package Iterator;
/**
 * 添加list的迭代器方法
 * 使用了匿名内部类实现迭代器方法
 * 添加了泛型-->使得可以操纵多种类型
 */
import java.util.Arrays;
import java.util.Iterator;

public class DeepList<E> implements java.lang.Iterable{    //实现这个接口是为了能够使用增强for循环
	private Object [] arr ;
	private int size=0;  //容器大小
	
	
	DeepList(){
		arr=new Object[10];
	}
	DeepList(int i){
		arr=new Object[i];
	}
	
	//添加方法接受一个对象
	public void add(E obj){
		if(size==arr.length){      //容量不够，扩容
			arr=Arrays.copyOf(arr, size*2+1);
			//或者使用
//			Object newArray=new Object[size*2+1];
//			System.arraycopy(arr, 0, newArray, 0, arr.length);
//			arr=newArray;
		}
		arr[size++]=obj;
	}
	public int size(){
		return this.size;
	}
	//List的迭代器方法
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
				return (E)arr[cursor];          //此处需进行强制类型转换 	转为E类型
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
			//拿出来的是object
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
