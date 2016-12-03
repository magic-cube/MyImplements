package Others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties（HashMap的子类）输出到文件
 * (写)
 * store
 * storeToXML
 * 资源配置文件：
 * 一般情况下，写一次，读多次
 * @author hc
 *
 */
public class PropertiesDemo02 {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		//创建对象
		Properties p= new Properties();
		//存储
		p.setProperty("dirver", "oracle.jdbc.dirver.OracleDriver");
		p.setProperty("url","jdbc:oracle:thin:@loaclhost:1521:oracle");
		p.setProperty("user", "scott");
		p.setProperty("pwd","tiger");
		
		//存储到c:/my   绝对路径，盘符
		//p.store(new FileOutputStream(new File("c:/my/db.properties")), "db配置");
		//p.storeToXML(new FileOutputStream(new File("c:/my/db.xml")), "db配置");
		
		//相对路径   默认当前工程下
		//p.store(new FileOutputStream(new File("db.properties")), "db配置");
		p.store(new FileOutputStream(new File("src/db.properties")), "db配置");
	}
}
