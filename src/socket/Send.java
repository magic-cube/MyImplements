package socket;
import java.io.*;
import java.net.*;
/**
 * ���������߳�
 * @author hc
 *
 */
public class Send implements Runnable{
	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	//�̴߳��ı�ʶ
	private boolean isRunning=true;//�߳��Ƿ������У�Ĭ��Ϊtrue
	
	private String name;
	public Send(){
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client,String name){
		this();
		
		try {
			dos=new DataOutputStream(client.getOutputStream());
			this.name=name;
			this.send(name);
			
		} catch (IOException e) {
			//e.printStackTrace();
			//������쳣�͹ر�ͨ��
			isRunning=false;
			CloseUtil.close(dos,console);
		}
	}
	/*
	 * ˽�з������ӿ���̨��ȡ����
	 */
	private String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return null;
	}
	/*
	 * ��������
	 */
	public void send(String msg){
		if(null!=msg){
			try {
				//��סඣ�д��write��дflush��ǿ��ˢ�£�
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				//������쳣�͹ر�ͨ��
				isRunning=false;
				CloseUtil.close(dos,console);
			}
		}
	}
	/**
	 * �߳���
	 */
	public void run(){
		while(isRunning){
			send(getMsgFromConsole());
		}
	}
}
