package fileSystemClassLoader;
/**
 * �����Զ�����������
 * @author �´�
 *
 */
public class DemoClassLoader01 {
	/**
	 * ע�⣡
	 * һ���౻�������Σ��������Ǹ���...
	 * ��������������������ص�ͬһ���࣬JVM����Ϊ����ͬ����
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyFileClassLoader loader=new MyFileClassLoader("C:/my");
		MyFileClassLoader loader2=new MyFileClassLoader("C:/my");
		try {
			Class<?> c=loader.loadClass("HelloWorld");
			Class<?> c2=loader2.loadClass("HelloWorld");
			//����java��������е��࣬�ᱻ���������������
			Class<?> c3=loader2.loadClass("java.lang.String");
			
			System.out.println(c.hashCode());
			System.out.println(c2.hashCode());
			System.out.println(c3.hashCode());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
