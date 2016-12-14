package design_patterns;
/**
 * �������ģʽ
 * 			1.����ʽ
 * 			2.����ʽ
 * @author hc
 *
 */
public class Sington {
	public static void main(String args[]){
		
	}
}

/*
 * ����ʽ
 * 1.������˽�л�
 * 2.����˽�еľ�̬����
 * 3.�ṩ����ľ�̬�������ʸñ���
 */
class MyJvm1{
	private static MyJvm1 instance=null;
	private MyJvm1(){
		
	}
	public static MyJvm1 getInstance(){
		//�����˫�������
		if(instance==null){ //Ϊ��Ч��
			synchronized(MyJvm1.class){
				if(instance==null){ //Ϊ�˰�ȫ
					instance=new MyJvm1();
				}
			}
		}
		return instance;
	}
}

/*
 * ����ʽ
 * 1.������˽�л�
 * 2.����˽�еľ�̬����,ͬʱ�����ö���
 * 3.�ṩ����ķ��ʸ����Եľ�̬����
 */
class MyJvm2{
	private static MyJvm2 instance=new MyJvm2();
	private MyJvm2(){
		
	}
	public static MyJvm2 getInstance(){
		return instance;
	}
}

/*
 * ����ʽ
 * ���Ч��
 * ���ڱ�ʹ�õ�ʱ��ż���
 * ʹ���ڲ��࣬�ӻ�����ص�ʱ��
 */
class MyJvm3{
	//�ڲ��࣬�ӻ�����ص�ʱ��
	public static class Jvmholder{
		private static MyJvm3 instance=new MyJvm3();
	}
	private MyJvm3(){
		
	}
	public static MyJvm3 getInstance(){
		return Jvmholder.instance;
	}
}

