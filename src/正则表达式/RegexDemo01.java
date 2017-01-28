package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 测试正则表达式
 * 两个类Pattern，Matcher
 * Pattern是正则表达式引擎，使用Matcher将字符串与正则表达式关联起来
 * @author hc
 *
 */
/*
 * 1.将正则表达式表示成java中的一个对象
 * 2.将正则表达式与字符串关联起来
 */
public class RegexDemo01 {
	public static void main(String[] args) {
		/*
		 * 在这个字符串：asdsdf232323，验证是否符合正则表达式：\w+
		 * TIPS：java中的正则，一个\变为两个\\
		 */
		
		//目标字符串
		String str="asdsdf23&&232323";
		
		//表达式对象
		Pattern p=Pattern.compile("\\w+");
		
		//创建Matcher对象
		Matcher m=p.matcher(str);
//		
//		boolean result=m.matches();//尝试将真个字符序列与该模式匹配
//		
//		/*
//		 * 通过find方法，查找下一个子序列
//		 * 可以多次调用
//		 */
//		boolean yesorno=m.find(); //该方法扫描输入的序列，查找与该模式匹配的下一个自学咧
//		
//		System.out.println(result);
		
		while(m.find()){
			System.out.println(m.group());
		}
		
		
	}
	@Test
	public void test(){
		System.out.println("测试JUnit");
	}
}





