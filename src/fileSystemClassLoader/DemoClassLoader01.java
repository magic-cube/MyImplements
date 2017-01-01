package fileSystemClassLoader;
/**
 * 测试自定义的类加载器
 * @author 郝川
 *
 */
public class DemoClassLoader01 {
	/**
	 * 注意！
	 * 一个类被加载两次，他还是那个类...
	 * 但！被两个类加载器加载的同一个类，JVM不认为是相同的类
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyFileClassLoader loader=new MyFileClassLoader("C:/my");
		MyFileClassLoader loader2=new MyFileClassLoader("C:/my");
		try {
			Class<?> c=loader.loadClass("HelloWorld");
			Class<?> c2=loader2.loadClass("HelloWorld");
			//加载java核心类库中的类，会被引导类加载器加载
			Class<?> c3=loader2.loadClass("java.lang.String");
			
			System.out.println(c.hashCode());
			System.out.println(c2.hashCode());
			System.out.println(c3.hashCode());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
