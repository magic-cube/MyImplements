package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象
 * 替换
 * @author hc
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		//正则表达式对象
		Pattern p=Pattern.compile("[0-9]");
		
		String str="aa232**ssd445sds223";
		
		//创建Matcher对象
		Matcher m=p.matcher(str);
		
		//替换,将str中符合正则表达式的全部替换为#，并返回新的字符串
		String newStr=m.replaceAll("#");
		
		//之前的字符串
		System.out.println(str);
		//替换后返回的新的字符串,字符串是常量，并不能修改之前的字符串,只能新new一个字符串出来
		System.out.println(newStr);
		
		
	}

}
