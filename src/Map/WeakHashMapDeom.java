package Map;
/**
 * WeakHashMap
 * ��Ϊ�����ã�GC��Garbage Collection������ʱ��������
 * ������map�д���˴��������ݣ�ռ���˴����Ĵ洢�м䣬������ϣ����֮���ܹ������ⲿ���ڴ棬WeakHashMap��������
 */
import java.util.WeakHashMap;

public class WeakHashMapDeom {
	public static void main(String args[]){
		WeakHashMap<String,String> wh = new WeakHashMap<String,String>();
		//��������
		//�����ض��󣬲������
		wh.put("aaa", "a");
		wh.put("bbb", "b");
		wh.put("ccc", "c");
		//gc����ʱ�ᱻ��������
		wh.put(new String("ddd"), "d");
		wh.put(new String("eee"), "e");
		
		
		//gc����ǰ
		System.out.println("gc����ǰwh�Ĵ�С��"+wh.size());
		
		//֪ͨ����
		System.gc();
		System.runFinalization();
		
		//gc���к�    ��ΪWeakHashMap��ԭ��new������String������
		System.out.println("gc���к�wh�Ĵ�С��"+wh.size());
	}
}
