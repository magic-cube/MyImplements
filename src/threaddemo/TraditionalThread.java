package threaddemo;

public class TraditionalThread {
	public static void main(String[] args) {
		//��ʽһ:������̳�Thread��
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
		
		//��ʽ��:ʵ��Runnable�ӿ�,ͨ�����췽������һ��Runnable����
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













