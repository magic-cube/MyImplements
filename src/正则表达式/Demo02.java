package 正则表达式;
/**
 * 测试正则表达式对象的基本用法
 * 查找操作
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo02 {
	/*
	 * 分组的处理
	 */
	public static void main(String[] args) {
		String str="aa232**ssd445*sds223";
		
		//表达式对象
		Pattern p=Pattern.compile("([a-z]+)([0-9]+)");
		
		//创建Matcher对象
		Matcher m=p.matcher(str);
		
		while(m.find()){
			/*
			 * 分别对应
			 */
			//整个表达式第一次(二，及以后)匹配到的
			System.out.println(m.group());
			//第一个分组第一次(二，及以后)匹配到的
			System.out.println(m.group(1));
			//第二个分组第一次(二，及以后)匹配到的
			System.out.println(m.group(2));
		}

	}
}
