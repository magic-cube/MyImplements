package threaddemo;

public class TraditionalThread {
	public static void main(String[] args) {
		//方式一:让子类继承Thread类
		Thread thread=new Thread(){
			@Override
			public void run(){
				while(true){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("1:"+Thread.currentThread());
					System.out.println("2:"+this.getName());
				}
			}
		};
		//thread.start();
		
		//方式二:实现Runnable接口,通过构造方法传入一个Runnable对象
		Thread thread2=new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread());
				}
			}
			
		});
		//thread2.start();
		
		
		
		new Thread(new Runnable() {
					public void run() {
						while(true){
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("runnable:"+Thread.currentThread());
						}
					}
				}
		){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("thread:"+Thread.currentThread());
				}
			}
		}.start();;
		
	}
}













