package Map;
/**
 * WeakHashMap
 * 键为弱引用，GC（Garbage Collection）运行时立即回收
 * 如果你的map中存放了大量的数据，占用了大量的存储中间，并且你希望在之后能够回收这部分内存，WeakHashMap可以做到
 */
import java.util.WeakHashMap;

public class WeakHashMapDeom {
	public static void main(String args[]){
		WeakHashMap<String,String> wh = new WeakHashMap<String,String>();
		//测试数据
		//常量池对象，不会回收
		wh.put("aaa", "a");
		wh.put("bbb", "b");
		wh.put("ccc", "c");
		//gc运行时会被立即回收
		wh.put(new String("ddd"), "d");
		wh.put(new String("eee"), "e");
		
		
		//gc运行前
		System.out.println("gc运行前wh的大小："+wh.size());
		
		//通知回收
		System.gc();
		System.runFinalization();
		
		//gc运行后    因为WeakHashMap的原因new出来的String被回收
		System.out.println("gc运行后wh的大小："+wh.size());
	}
}
