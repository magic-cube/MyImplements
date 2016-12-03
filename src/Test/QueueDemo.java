package Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/*
 * ģ�����д��ҵ��
 * Queue
 * �Ƚ��ȳ�
 */
public class QueueDemo {
	//����ӿڱ�̣�����ʵ����Ҳ������ArrayList
	static Queue<Request> que = new ArrayDeque<Request>();
	public static void main(String[] args) {
		Random rand =new Random();
		for(int i=0;i<10;i++){
			int num=i;
			que.offer(new Request(){
				public void deposit(){
					System.out.println("��"+num+"λ�˿ʹ�"+rand.nextInt(10000));
				}
			});
		}
		dealWith(que);
	}
	
	//��ôд���������ұ�ʾ����ã������
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
