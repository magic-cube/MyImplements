package ������ʽ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����������ʽ����
 * �滻
 * @author hc
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		//������ʽ����
		Pattern p=Pattern.compile("[0-9]");
		
		String str="aa232**ssd445sds223";
		
		//����Matcher����
		Matcher m=p.matcher(str);
		
		//�滻,��str�з���������ʽ��ȫ���滻Ϊ#���������µ��ַ���
		String newStr=m.replaceAll("#");
		
		//֮ǰ���ַ���
		System.out.println(str);
		//�滻�󷵻ص��µ��ַ���,�ַ����ǳ������������޸�֮ǰ���ַ���,ֻ����newһ���ַ�������
		System.out.println(newStr);
		
		
	}

}
