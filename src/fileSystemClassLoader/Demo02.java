package fileSystemClassLoader;
/**
 * ���Խ����������
 * @author hc
 *
 */
public class Demo02 {
	
	public static void main(String agrs[]) throws ClassNotFoundException{
		//���ܺ��class�ļ�����������������޷�����,��classFormtError����
//		MyFileClassLoader loader=new MyFileClassLoader("C:/my/temp");
//		Class<?> c=loader.loadClass("HelloWorld");
//		System.out.println(c);
		
		
		//�ɹ�����
		DecrptClassLoader loader2=new DecrptClassLoader("C:/my/temp");
		Class<?> c2=loader2.loadClass("HelloWorld");
		System.out.println(c2);
		
	}
}
