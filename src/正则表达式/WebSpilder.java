package 正则表达式;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

/**
 * 网络爬虫取数据
 * @author hc
 *
 */
public class WebSpilder {
	/**
	 * 该方法接收一个String类型的字符串，（网址URL）
	 * 返回该网址下的源码内容
	 */
	public static String getURLContent(String urlStr){
		StringBuilder sb=new StringBuilder();
		try {
			URL url=new URL(urlStr);
			BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
			//临时字符串，用于存数据
			String temp="";
			while((temp=reader.readLine())!=null){
				sb.append(temp);//添加字符串
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String desStr=getURLContent("http://www.163.com");
		
	}
	
	@Test
	public void test(){
		
	}
	
	
	
}
