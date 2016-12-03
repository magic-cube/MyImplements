package Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/*
 * 模拟银行存款业务
 * Queue
 * 先进先出
 */
public class QueueDemo {
	//面向接口编程，具体实现类也可以是ArrayList
	static Queue<Request> que = new ArrayDeque<Request>();
	public static void main(String[] args) {
		Random rand =new Random();
		for(int i=0;i<10;i++){
			int num=i;
			que.offer(new Request(){
				public void deposit(){
					System.out.println("第"+num+"位顾客存款："+rand.nextInt(10000));
				}
			});
		}
		dealWith(que);
	}
	
	//这么写。。。。我表示很迷茫。。。
	public static void dealWith(Queue<Request> que){
		Request req=null;
		
		while(null!=(req=que.poll())){
			req.deposit();
		}
	}

}
interface Request{
	void deposit();
}
