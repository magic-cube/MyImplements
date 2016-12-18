package socket;
import java.net.*;
import java.io.*;
/**
 * ���������߳�
 * @author hc
 *
 */
public class Receive implements Runnable{
	//������
	private DataInputStream dis;
	//�̴߳��ı�ʶ
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
	 * ��������
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
		//�߳���
		while(isRunning){
			receive();
		}
	}
	
}
