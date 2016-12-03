package ReferenceDome;

import java.lang.ref.WeakReference;

/**
 * ���÷��� ǿ �� �� ��
 * ǿ���ã�StrongReference    gc����ʱ�������
 * �����ã�SoftReference    gc����ʱ���ܻ���(jvm�ڴ治��ʱ)
 * �����ã�WeakReference    gc����ʱ��������
 * �����ã�������
 * @author hc
 *
 */
public class RederenceDemo01 {

	public static void main(String[] args) {
		f();
		System.out.println();
		//�ַ���������  ����
		String str=new String("hello");
		//ʹ�������ù������
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc����ǰ��"+wr.get());
		//�Ͽ�����
		str=null;
		//֪ͨ����
		System.gc();
		System.runFinalization();
		System.out.println("---------------");
		System.out.println("gc���к�"+wr.get());
		//��Ϊ�ַ�����������ǿ���ã�����gc����ʱ�������
		
	}
	public static void f(){
		//�ַ���������  ���� �����ɻ��գ�
		String str="hello";
		//ʹ�������ù������
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc����ǰ��"+wr.get());
		//�Ͽ�����
		str=null;
		//֪ͨ����
		System.gc();
		System.runFinalization();
		System.out.println("---------------");
		System.out.println("gc���к�"+wr.get());
		//��Ϊ�ַ�����������ǿ���ã�����gc����ʱ�������

	}

}
