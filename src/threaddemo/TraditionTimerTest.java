package threaddemo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 定时器
 */
public class TraditionTimerTest {
	public static void main(String[] args) {
		
		/*
		 * 定时器是一个对象,定时器任务是一个对象
		 * 第一次5秒后执行,之后每3秒执行一次
		 */
		/*new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}, 5000,3000);*/
		
		
		
		/*
		 * 定时器,第一次两秒后执行,每隔6秒再执行一次
		 * 此时执行一个四秒后执行的定时器,
		 * 效果为两秒钟执行一次,再四秒钟执行一次,再两秒钟执行一次
		 */
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing");
				new Timer().schedule(new TimerTask() {
					
					@Override
					public void run() {
						System.out.println("boom!!!!!");
					}
				}, 4000);
			}
		}, 2000,6000);
		
//		class MyTimerTask extends TimerTask{
//			@Override
//			public void run() {
//				System.out.println("boom");
//				new Timer().schedule(new MyTimerTask(), 200);
//			}
//		}
//		new Timer().schedule(new MyTimerTask(),2000);;
		while(true){
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
