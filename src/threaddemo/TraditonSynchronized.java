package threaddemo;
/*
 * 测试多个线程同时访问一个方法时,由于线程未同步而出现的错误
 */
public class TraditonSynchronized {
	/*
	 * 在静态方法中不能new内部类的实例对象
	 */
	public static void main(String[] args) {
		new TraditonSynchronized().init();
	}
	
	class Outputer{
		public void output(String name){
			int len=name.length();
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i)+" ");
			}
			System.out.println();
		}
	}
	
	/*
	 * 不能在静态方法中new内部类的实例对象
	 * 内部类可以访问外部类的成员变量,类只有在被实例化后才会为成员变量分配空间
	 * 而静态方法可以不用去创建类的对象,因而产生了矛盾
	 * 这时,使用别的方法去完成创建内部类对象的动作,便不会发生错误
	 */
	private void init(){
		final Outputer out=new Outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("zhangxiaoxiang");
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("xihuoming");
				}
			}
		}).start();

	}
	
}
