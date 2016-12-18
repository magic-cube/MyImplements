package socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * ������
 * �����
 * Ϊÿһ���ͻ����½�һ���̣߳��໥����
 *
 * ��һ������ˣ�������ͻ��ˣ�ʵ����Ⱥ�ĺ�˽�ĵĹ��ܣ���������ת�����͸�������
 * ˽�ĸ�ʽ @�û����� Ҫ������Ϣ 
 * @author hc
 *
 */
public class Server {
	//����߳�,ÿ���ͻ���һ���߳�
	private List<MyChannel> list=new ArrayList<MyChannel>();
	
	public static void main(String[] args) {
		new Server().start();
	}
	 
	public void start(){
		ServerSocket server=null;
		try {
			/*
			 * ����д���������ν�Ŀͻ����Ⱥ�˳��
			 * while(true) ����õ�һ���ͻ���������������ˣ���һ���ſ��������������
			 * �ٴ�������߳�
			 */
			server=new ServerSocket(8887);
			while(true){
				Socket client=server.accept();
				//һ���ͻ�����һ���߳�
				MyChannel channel=new MyChannel(client);
				//���������������
				list.add(channel);
				new Thread(channel).start();;
				
			}
		} catch (IOException e) {
			System.out.println("����˴ִ�����");
			e.printStackTrace();
		}
	}
	/**
	 * �ڲ���
	 * һ���ͻ���һ���߳�
	 */
	private class MyChannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning=true;
		private boolean flag=true;
		//����
		public String name;
		public MyChannel(Socket client){
			try {
				dis=new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
				this.name=dis.readUTF();
				this.send("��ӭ����������");
				this.sendOther(this.name+"������������",true);
				//����
				//System.out.println(this.name);
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.close(dis,dos);
				isRunning=false;
			}
		}
		/*
		 * ��������
		 */
		public String receive(){
			String msg=null;
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.close(dis);
				isRunning=false;
				//���쳣�����������Ƴ�����
				list.remove(this);
			}
			return msg;
		}
		
		/*
		 * ��������
		 * ����ΪReceive�ķ���ֵ�����յ��㷢�͸�������
		 */
		public void send(String msg){
			if(null!=msg){
				try {
					//��write����סдflush������
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					//e.printStackTrace();
					CloseUtil.close(dos);
					isRunning=false;
					//���쳣�����������Ƴ�����
					list.remove(this);
				}
			}
		}
		/*
		 * ���͸������ͻ���
		 */
		public void sendOther(String msg,boolean sys){
			//�ж��Ƿ�Ϊ˽��,Լ��
			if(msg.startsWith("@")&&msg.indexOf(":")>-1){ //��@��ͷ���Ҵ���ð�ŵ�Ϊ˽��
				//�ӵ�һ���ַ���ʼ��ð��Ϊ����,������ַ�Ϊ@
				String name=msg.substring(1,msg.indexOf(":"));
				//��ð�ż�1�ĵط���Ҫ˽�ĵĻ�
				String content=msg.substring(msg.indexOf(":")+1);
				
				for(MyChannel channel:list){
					if(channel.name.equals(name)){
						channel.send(this.name+"�������ĵ�˵��"+content);
					}
				}
			}else{
				for(MyChannel channel:list){
					//�������Լ�
					if(channel==this){
						continue;
					}
					if(sys){//ϵͳ��Ϣ
						channel.send("ϵͳ��Ϣ��"+msg);
					}else{
						channel.send(this.name+"��������˵��"+msg);
					}
				}
			}
		}
		
		public void run(){
			while(isRunning){
				sendOther(receive(),false);
			}
		}
	}
}
