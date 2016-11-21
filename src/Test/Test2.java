package Test;
import java.util.ArrayList;
/**
 * 用Map来保存数据的思路
 * 一个map对象，对应一行数据，再将map放入list中
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
	//一个map对应一行数据
	Map m1 = new HashMap();
	Map m2 = new HashMap();
	Map m3 = new HashMap();
	
	List<Map> list = new ArrayList<Map>();
	
	public static void main(String args[]){
		Test2 t2 = new Test2();
		t2.m1.put("id", "0301");
		t2.m1.put("name","hc");
		t2.m1.put("cls","012");
		
		t2.m2.put("id", "0302");
		t2.m2.put("name","guang");
		t2.m2.put("cls","013");
		
		t2.m3.put("id", "0303");
		t2.m3.put("name","pangpu");
		t2.m3.put("cls","013");
		
		t2.list.add(t2.m1);
		t2.list.add(t2.m2);
		t2.list.add(t2.m3);
		
		t2.printInfo();
	}
	public void printInfo(){
		for(int i=0;i<list.size();i++){
			Map temMap = list.get(i);
			System.out.println(temMap.get("id")+"----"+temMap.get("name"));
		}
	}
}
