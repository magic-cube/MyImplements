package threaddemo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * ��ʱ��
 */
public class TraditionTimerTest {
	public static void main(String[] args) {
		
		/*
		 * ��ʱ����һ������,��ʱ��������һ������
		 * ��һ��5���ִ��,֮��ÿ3��ִ��һ��
		 */
		/*new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}, 5000,3000);*/
		
		
		
		/*
		 * ��ʱ��,��һ�������ִ��,ÿ��6����ִ��һ��
		 * ��ʱִ��һ�������ִ�еĶ�ʱ��,
		 * Ч��Ϊ������ִ��һ��,��������ִ��һ��,��������ִ��һ��
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
