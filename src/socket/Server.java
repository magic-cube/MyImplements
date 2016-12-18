package socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * 聊天室
 * 服务端
 * 为每一个客户端新建一个线程，相互独立
 *
 * 启一个服务端，启多个客户端，实现了群聊和私聊的功能，服务器中转，发送给所有人
 * 私聊格式 @用户名： 要发的信息 
 * @author hc
 *
 */
public class Server {
	//存放线程,每个客户端一个线程
	private List<MyChannel> list=new ArrayList<MyChannel>();
	
	public static void main(String[] args) {
		new Server().start();
	}
	 
	public void start(){
		ServerSocket server=null;
		try {
			/*
			 * 这样写，会存在所谓的客户的先后顺序
			 * while(true) 必须得等一个客户与服务器交流完了，另一个才可以与服务区交流
			 * 再次引入多线程
			 */
			server=new ServerSocket(8887);
			while(true){
				Socket client=server.accept();
				//一个客户端启一条线程
				MyChannel channel=new MyChannel(client);
				//将其添加至容器中
				list.add(channel);
				new Thread(channel).start();;
				
			}
		} catch (IOException e) {
			System.out.println("服务端粗大事了");
			e.printStackTrace();
		}
	}
	/**
	 * 内部类
	 * 一个客户端一个线程
	 */
	private class MyChannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning=true;
		private boolean flag=true;
		//名称
		public String name;
		public MyChannel(Socket client){
			try {
				dis=new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
				this.name=dis.readUTF();
				this.send("欢迎进入聊天室");
				this.sendOther(this.name+"进入了聊天室",true);
				//测试
				//System.out.println(this.name);
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.close(dis,dos);
				isRunning=false;
			}
		}
		/*
		 * 接收数据
		 */
		public String receive(){
			String msg=null;
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.close(dis);
				isRunning=false;
				//有异常，从容器中移除自身
				list.remove(this);
			}
			return msg;
		}
		
		/*
		 * 发送数据
		 * 参数为Receive的返回值，接收到便发送给其他人
		 */
		public void send(String msg){
			if(null!=msg){
				try {
					//有write，记住写flush。。。
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					//e.printStackTrace();
					CloseUtil.close(dos);
					isRunning=false;
					//有异常，从容器中移除自身
					list.remove(this);
				}
			}
		}
		/*
		 * 发送给其他客户端
		 */
		public void sendOther(String msg,boolean sys){
			//判断是否为私聊,约定
			if(msg.startsWith("@")&&msg.indexOf(":")>-1){ //以@开头并且存在冒号的为私聊
				//从第一个字符开始到冒号为名字,第零个字符为@
				String name=msg.substring(1,msg.indexOf(":"));
				//从冒号加1的地方是要私聊的话
				String content=msg.substring(msg.indexOf(":")+1);
				
				for(MyChannel channel:list){
					if(channel.name.equals(name)){
						channel.send(this.name+"对你悄悄的说："+content);
					}
				}
			}else{
				for(MyChannel channel:list){
					//不给发自己
					if(channel==this){
						continue;
					}
					if(sys){//系统信息
						channel.send("系统信息："+msg);
					}else{
						channel.send(this.name+"对所有人说："+msg);
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
