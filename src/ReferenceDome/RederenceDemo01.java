package ReferenceDome;

import java.lang.ref.WeakReference;

/**
 * 引用分类 强 软 弱 虚
 * 强引用：StrongReference    gc运行时不会回收
 * 软引用：SoftReference    gc运行时可能回收(jvm内存不够时)
 * 弱引用：WeakReference    gc运行时立即回收
 * 虚引用：。。。
 * @author hc
 *
 */
public class RederenceDemo01 {

	public static void main(String[] args) {
		f();
		System.out.println();
		//字符串常量池  堆中
		String str=new String("hello");
		//使用弱引用管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str=null;
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("---------------");
		System.out.println("gc运行后："+wr.get());
		//因为字符串常量池是强引用，所以gc运行时不会回收
		
	}
	public static void f(){
		//字符串常量池  共享 （不可回收）
		String str="hello";
		//使用弱引用管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str=null;
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("---------------");
		System.out.println("gc运行后："+wr.get());
		//因为字符串常量池是强引用，所以gc运行时不会回收

	}

}
