package ������ʽ;

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
 * ��������ȡ����
 * @author hc
 *
 */
public class WebSpilder {
	/**
	 * �÷�������һ��String���͵��ַ���������ַURL��
	 * ���ظ���ַ�µ�Դ������
	 */
	public static String getURLContent(String urlStr){
		StringBuilder sb=new StringBuilder();
		try {
			URL url=new URL(urlStr);
			BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
			//��ʱ�ַ��������ڴ�����
			String temp="";
			while((temp=reader.readLine())!=null){
				sb.append(temp);//����ַ���
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
