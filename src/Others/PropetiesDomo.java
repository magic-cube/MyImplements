package Others;

import java.util.Properties;

/*
 * Properties
 * ���ã���ȡ��Դ�����ļ�
 * Ҫ�����ֵֻ��Ϊ�ַ���
 * 
 */
public class PropetiesDomo {
	public static void main(String args[]){
		//��������
		Properties p= new Properties();
		//�洢
		p.setProperty("dirver", "oracle.jdbc.dirver.OracleDriver");
		p.setProperty("url","jdbc:oracle:thin:@loaclhost:1521:oracle");
		p.setProperty("user", "scott");
		p.setProperty("pwd","tiger");
		//��ȡ
		//��ȡ url�����û�У�ʹ��test
		String url=p.getProperty("url","test");
		System.out.println(url);
		
	}
}
