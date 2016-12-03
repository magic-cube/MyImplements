package Map;

import java.util.EnumMap;

/**
 * EnumMap
 * 要求键必须是枚举类型
 * @author hc
 *
 */
public class EnumMaoDemo {
	public static void main(String args[]){
		EnumMap<Season,String> map= new EnumMap<Season,String>(Season.class);
		map.put(Season.SPRING, "春困");
		map.put(Season.SUMMER, "夏乏");
		map.put(Season.AUTOMN, "秋盹");
		map.put(Season.WITER, "冬眠");
		
		System.out.println(map.size());
	}
}
enum Season{
	SPRING,SUMMER,AUTOMN,WITER
}