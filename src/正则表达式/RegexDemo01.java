package ������ʽ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * ����������ʽ
 * ������Pattern��Matcher
 * Pattern��������ʽ���棬ʹ��Matcher���ַ�����������ʽ��������
 * @author hc
 *
 */
/*
 * 1.��������ʽ��ʾ��java�е�һ������
 * 2.��������ʽ���ַ�����������
 */
public class RegexDemo01 {
	public static void main(String[] args) {
		/*
		 * ������ַ�����asdsdf232323����֤�Ƿ����������ʽ��\w+
		 * TIPS��java�е�����һ��\��Ϊ����\\
		 */
		
		//Ŀ���ַ���
		String str="asdsdf23&&232323";
		
		//���ʽ����
		Pattern p=Pattern.compile("\\w+");
		
		//����Matcher����
		Matcher m=p.matcher(str);
//		
//		boolean result=m.matches();//���Խ�����ַ��������ģʽƥ��
//		
//		/*
//		 * ͨ��find������������һ��������
//		 * ���Զ�ε���
//		 */
//		boolean yesorno=m.find(); //�÷���ɨ����������У��������ģʽƥ�����һ����ѧ��
//		
//		System.out.println(result);
		
		while(m.find()){
			System.out.println(m.group());
		}
		
		
	}
	@Test
	public void test(){
		System.out.println("����JUnit");
	}
}





