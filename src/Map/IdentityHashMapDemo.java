package Map;
/**
 * IdentityHashMap
 * ��ֻ�Ե�ַȥ�أ������ǱȽ�hashCode��equals
 */
import java.util.IdentityHashMap;

public class IdentityHashMapDemo {
	public static void main(String args[]){
		IdentityHashMap<String,String> map = new IdentityHashMap<>();
		//���ڼ���ȡ   ��
		//�������е�a
		map.put("a", "aaa");
		map.put("a", "bbb");
		
		System.out.println(map.size());
		//bbb�Ḳ�ǵ�aaa
		System.out.println(map.get("a"));
		
		//IdentityHashMapֻ�Ե�ַȥ�أ��ֱ�new������a  ��ַ��ͬ�����Դ�ʱmap�Ĵ�СΪ3
		map.put(new String("a"), "a3");
		map.put(new String("a"), "a4");
		System.out.println(map.size());
		
		System.out.println(map.get("a"));
	}
}
