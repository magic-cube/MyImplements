package Others;

import java.util.Properties;

/*
 * Properties
 * 作用：读取资源配置文件
 * 要求键与值只能为字符串
 * 
 */
public class PropetiesDomo {
	public static void main(String args[]){
		//创建对象
		Properties p= new Properties();
		//存储
		p.setProperty("dirver", "oracle.jdbc.dirver.OracleDriver");
		p.setProperty("url","jdbc:oracle:thin:@loaclhost:1521:oracle");
		p.setProperty("user", "scott");
		p.setProperty("pwd","tiger");
		//获取
		//获取 url，如果没有，使用test
		String url=p.getProperty("url","test");
		System.out.println(url);
		
	}
}
