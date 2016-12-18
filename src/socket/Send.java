package socket;
import java.io.*;
import java.net.*;
/**
 * 发送数据线程
 * @author hc
 *
 */
public class Send implements Runnable{
	//控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	//线程存活的标识
	private boolean isRunning=true;//线程是否运行中，默认为true
	
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
			//如存在异常就关闭通道
			isRunning=false;
			CloseUtil.close(dos,console);
		}
	}
	/*
	 * 私有方法，从控制台获取数据
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
	 * 发送数据
	 */
	public void send(String msg){
		if(null!=msg){
			try {
				//记住喽！写完write就写flush，强制刷新！
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				//如存在异常就关闭通道
				isRunning=false;
				CloseUtil.close(dos,console);
			}
		}
	}
	/**
	 * 线程体
	 */
	public void run(){
		while(isRunning){
			send(getMsgFromConsole());
		}
	}
}
