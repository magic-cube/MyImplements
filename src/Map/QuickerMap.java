package Map;
/**
 * Map的效率提升版本
 * Map底层实现，数组+链表
 * @author hc
 *
 */
public class QuickerMap {
	SxtEntry1 [] arr = new SxtEntry1[999];
	private int size;
	public void put(Object key,Object value){
		SxtEntry1 e = new SxtEntry1(key,value);
		//让key的hashCode 对999取余  得到0~998范围的一个整数 ，作为数组的下标，每次取值放值得时候直接arr[key.hashcode()%999]
		//但此时还存在一个问题，hashCode()取余后得到的值可能重复
		int a=key.hashCode()%999;
		arr[a]=e;
	}
	public Object get(Object key){
		return arr[key.hashCode()%999].value;
	}
	
	
	
	//其他方法如法炮制即可，此处不再具体实现
	
	
	
	public static void main(String[] args) {
	

	}

}
class SxtEntry1{
	Object key;
	Object value;
	SxtEntry1(){
		
	}
	SxtEntry1(Object key,Object value){
		this.key=key;
		this.value=value;
	}
}
