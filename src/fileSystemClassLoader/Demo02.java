package fileSystemClassLoader;
/**
 * 测试解密类加载器
 * @author hc
 *
 */
public class Demo02 {
	
	public static void main(String agrs[]) throws ClassNotFoundException{
		//机密后的class文件，正常的类加载器无法加载,报classFormtError错误
//		MyFileClassLoader loader=new MyFileClassLoader("C:/my/temp");
//		Class<?> c=loader.loadClass("HelloWorld");
//		System.out.println(c);
		
		
		//成功加载
		DecrptClassLoader loader2=new DecrptClassLoader("C:/my/temp");
		Class<?> c2=loader2.loadClass("HelloWorld");
		System.out.println(c2);
		
	}
}
