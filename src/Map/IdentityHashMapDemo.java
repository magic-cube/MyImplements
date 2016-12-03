package Map;
/**
 * IdentityHashMap
 * 键只以地址去重，而不是比较hashCode和equals
 */
import java.util.IdentityHashMap;

public class IdentityHashMapDemo {
	public static void main(String args[]){
		IdentityHashMap<String,String> map = new IdentityHashMap<>();
		//存在即获取   就
		//常量池中的a
		map.put("a", "aaa");
		map.put("a", "bbb");
		
		System.out.println(map.size());
		//bbb会覆盖掉aaa
		System.out.println(map.get("a"));
		
		//IdentityHashMap只以地址去重，分别new出来的a  地址不同，所以此时map的大小为3
		map.put(new String("a"), "a3");
		map.put(new String("a"), "a4");
		System.out.println(map.size());
		
		System.out.println(map.get("a"));
	}
}
