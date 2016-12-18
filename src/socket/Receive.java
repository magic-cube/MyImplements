package socket;
import java.net.*;
import java.io.*;
/**
 * 接收数据线程
 * @author hc
 *
 */
public class Receive implements Runnable{
	//输入流
	private DataInputStream dis;
	//线程存活的标识
	private boolean isRunning=true;
	
	public Receive(){
		
	}
	public Receive(Socket client){
		this();
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			isRunning=false;
			CloseUtil.close(dis);
		}
	}
	
	/*
	 * 接收数据
	 */
	public String receive(){
		String msg=null;  
		try {
			msg=dis.readUTF();
			System.out.println(msg);
		} catch (IOException e) {
			//e.printStackTrace();
			isRunning=false;
			CloseUtil.close(dis);
		}
		return msg;
	}
	public void run(){
		//线程体
		while(isRunning){
			receive();
		}
	}
	
}
