package ������ʽ;
/**
 * ����������ʽ����Ļ����÷�
 * ���Ҳ���
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo02 {
	/*
	 * ����Ĵ���
	 */
	public static void main(String[] args) {
		String str="aa232**ssd445*sds223";
		
		//���ʽ����
		Pattern p=Pattern.compile("([a-z]+)([0-9]+)");
		
		//����Matcher����
		Matcher m=p.matcher(str);
		
		while(m.find()){
			/*
			 * �ֱ��Ӧ
			 */
			//�������ʽ��һ��(�������Ժ�)ƥ�䵽��
			System.out.println(m.group());
			//��һ�������һ��(�������Ժ�)ƥ�䵽��
			System.out.println(m.group(1));
			//�ڶ��������һ��(�������Ժ�)ƥ�䵽��
			System.out.println(m.group(2));
		}

	}
}
