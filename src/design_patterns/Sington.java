package design_patterns;
/**
 * 单例设计模式
 * 			1.懒汉式
 * 			2.饿汉式
 * @author hc
 *
 */
public class Sington {
	public static void main(String args[]){
		
	}
}

/*
 * 懒汉式
 * 1.构造器私有化
 * 2.声明私有的静态变量
 * 3.提供对外的静态方法访问该变量
 */
class MyJvm1{
	private static MyJvm1 instance=null;
	private MyJvm1(){
		
	}
	public static MyJvm1 getInstance(){
		//经典的双层检查机制
		if(instance==null){ //为了效率
			synchronized(MyJvm1.class){
				if(instance==null){ //为了安全
					instance=new MyJvm1();
				}
			}
		}
		return instance;
	}
}

/*
 * 饿汉式
 * 1.构造器私有化
 * 2.声明私有的静态变量,同时创建该对象
 * 3.提供对外的访问该属性的静态方法
 */
class MyJvm2{
	private static MyJvm2 instance=new MyJvm2();
	private MyJvm2(){
		
	}
	public static MyJvm2 getInstance(){
		return instance;
	}
}

/*
 * 饿汉式
 * 提高效率
 * 类在被使用的时候才加载
 * 使用内部类，延缓类加载的时机
 */
class MyJvm3{
	//内部类，延缓类加载的时机
	public static class Jvmholder{
		private static MyJvm3 instance=new MyJvm3();
	}
	private MyJvm3(){
		
	}
	public static MyJvm3 getInstance(){
		return Jvmholder.instance;
	}
}

