package Map;

import java.util.EnumMap;

/**
 * EnumMap
 * Ҫ���������ö������
 * @author hc
 *
 */
public class EnumMaoDemo {
	public static void main(String args[]){
		EnumMap<Season,String> map= new EnumMap<Season,String>(Season.class);
		map.put(Season.SPRING, "����");
		map.put(Season.SUMMER, "�ķ�");
		map.put(Season.AUTOMN, "����");
		map.put(Season.WITER, "����");
		
		System.out.println(map.size());
	}
}
enum Season{
	SPRING,SUMMER,AUTOMN,WITER
}