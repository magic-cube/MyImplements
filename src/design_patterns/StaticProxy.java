package design_patterns;
/**
 * 静态代理模式
 * 1.真实角色
 * 2.代理角色
 * 3.二者实现相同的接口
 * 4.代理角色持有真实角色的引用
 * 	例：	使用Runnable接口创建并启动一个线程的过程
 * 		真实角色，自己的类
 * 		代理角色，Thread类
 * @author hc
 *
 */
public class StaticProxy {
	public static void main(String atgs[]){
		You you=new You();
		Daili dl=new Daili(you);
		dl.run();
	}
}
//接口
interface A{
	void run();
}
//自己的类
class You implements A{
	public void run(){
		System.out.println("我创建了一个线程");
	}
}
//代理角色
class Daili implements A{
	//持有真实角色的引用
	private You you;
	Daili(You you){
		this.you=you;
	}
	public void before(){
		System.out.println("代理帮你完成了准备工作");
	}
	public void after(){
		System.out.println("代理帮你完成了善后工作");
	}
	public void run(){
		before();
		you.run();
		after();
	}
}