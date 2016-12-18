package socket;
import java.io.*;
import java.net.*;
/**
 * �ͻ���
 * �������ݣ������
 * �������ݣ�������
 *	Ŀǰ���������������ͬһ�߳��ڣ�Ӧʹ���Ǳ˴˶���
 *  �����������������֣��ִ���ͬ�߳�
 * @author hc
 *
 */
public class Client {

	public static void main(String[] args) {
		Socket client=null;
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("����������:");
			String name=br.readLine();
			if(name.equals("")){  //nameΪ�շ���
				return ;
			}
			client=new Socket("localhost",8887);
			//������
			new Thread(new Send(client,name)).start();
			
			//�������ݵ��߳�
			new Thread(new Receive(client)).start();
	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
