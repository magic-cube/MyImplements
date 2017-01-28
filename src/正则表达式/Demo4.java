package 正则表达式;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象
 * 分割
 * 使用正则表达式可以用于切割非常复杂的边界
 * @author hc
 *
 */
public class Demo4 {

	public static void main(String[] args) {
		String str="a12bb223cr254";
		//根据逗号切割字符串
		String[] arrs=str.split(",");
		System.out.println(Arrays.toString(arrs));
		//根据正则表达式切割字符串,去除正则表达式中的内容,一下为去除数字
		String[] arrs2=str.split("(\\d+)");
		System.out.println(Arrays.toString(arrs2));
	}

}
