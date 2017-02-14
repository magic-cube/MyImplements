package threaddemo;

/**
 * 子线程先循环十次,然后主线程循环一百次,再子线程循环十次,主线程循环一百次,依此循环五十次
 * @author hc
 *
 */
public class TraditionalThreadCom {
	public static void main(String[] args) {
		Businesss b=new Businesss();
		new Thread(new Runnable() {
			@Override
			public void run() {
				//synchronized (TraditionalThreadCom.class) {
					for(int i=1;i<=50;i++){
						b.sub(i);
					}
				//}
			}
		}).start();
		
		for(int i=1;i<=50;i++){
			//synchronized (TraditionalThreadCom.class) {
				b.main(i);
			//}
		}
		
	}
	
}

class Businesss{
	
	private boolean bShouldSub=true;
	
	public synchronized void sub(int i){
		if(!bShouldSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=1;j<=10;j++){
			System.out.println("sub "+j+" of"+i);
			//System.out.println("sub :"+(i*10+j));
		}
		bShouldSub=false;
		this.notify();
	}
	
	public synchronized void main(int i){
		if(bShouldSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=1;j<=100;j++){
			System.out.println("main "+j+" of"+i);
			//System.out.println("main "+(i*10+j));
		}
		bShouldSub=true;
		this.notify();
	}
	
}





