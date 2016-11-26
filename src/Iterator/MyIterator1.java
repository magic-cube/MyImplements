package Iterator;
/**
 * 迭代器的粗糙实现
 * 理解迭代器原理
 * @author hc
 *
 */
public class MyIterator1 {
	String [] s={"a","b","c"};
	private int cursor=-1;  //指针，即游标       游标指向第一个元素的前面
	private int size=s.length;
	public int getSize(){
		return this.size;
	}
	//判断是否有下一个
	public boolean hasNext(){
		//游标加一小于size
		if(cursor+1<size){
			return true;
		}else{
			return false;
		}
	}
	
	//获取下一个元素
	public String next(){
		cursor++;
		return s[cursor];
	}
	
	//删除下一个元素
	public void remove(){
		//数组移动，移除元素
		//要复制的数组   从哪开始复制   复制到哪个数组    从哪开始粘贴    复制的长度
		System.arraycopy(s, cursor, s, cursor+1, this.size-(cursor+1));
		//实际大小-1
		this.size--;
		//游标回退一个
		this.cursor--;
	}
	public static void main(String[] args) {
		MyIterator1 mi=new MyIterator1();
		//先判断，后获取
		while(mi.hasNext()){
			System.out.println(mi.next());
			mi.remove();
		}
		System.out.println(mi.getSize());
	}

}
