package ������ʽ;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����������ʽ����
 * �ָ�
 * ʹ��������ʽ���������и�ǳ����ӵı߽�
 * @author hc
 *
 */
public class Demo4 {

	public static void main(String[] args) {
		String str="a12bb223cr254";
		//���ݶ����и��ַ���
		String[] arrs=str.split(",");
		System.out.println(Arrays.toString(arrs));
		//����������ʽ�и��ַ���,ȥ��������ʽ�е�����,һ��Ϊȥ������
		String[] arrs2=str.split("(\\d+)");
		System.out.println(Arrays.toString(arrs2));
	}

}
