package socket;
import java.io.*;
import java.net.*;
/**
 * 客户端
 * 发送数据：输出流
 * 接收数据：输入流
 *	目前输入流与输出流在同一线程内，应使他们彼此独立
 *  将输入流与输出流拆分，分处不同线程
 * @author hc
 *
 */
public class Client {

	public static void main(String[] args) {
		Socket client=null;
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入名称:");
			String name=br.readLine();
			if(name.equals("")){  //name为空返回
				return ;
			}
			client=new Socket("localhost",8887);
			//输入流
			new Thread(new Send(client,name)).start();
			
			//接收数据的线程
			new Thread(new Receive(client)).start();
	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
