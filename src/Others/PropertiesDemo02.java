package Others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Properties��HashMap�����ࣩ������ļ�
 * (д)
 * store
 * storeToXML
 * ��Դ�����ļ���
 * һ������£�дһ�Σ������
 * @author hc
 *
 */
public class PropertiesDemo02 {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		//��������
		Properties p= new Properties();
		//�洢
		p.setProperty("dirver", "oracle.jdbc.dirver.OracleDriver");
		p.setProperty("url","jdbc:oracle:thin:@loaclhost:1521:oracle");
		p.setProperty("user", "scott");
		p.setProperty("pwd","tiger");
		
		//�洢��c:/my   ����·�����̷�
		//p.store(new FileOutputStream(new File("c:/my/db.properties")), "db����");
		//p.storeToXML(new FileOutputStream(new File("c:/my/db.xml")), "db����");
		
		//���·��   Ĭ�ϵ�ǰ������
		//p.store(new FileOutputStream(new File("db.properties")), "db����");
		p.store(new FileOutputStream(new File("src/db.properties")), "db����");
	}
}
