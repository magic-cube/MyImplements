package design_patterns;
/**
 * ��̬����ģʽ
 * 1.��ʵ��ɫ
 * 2.�����ɫ
 * 3.����ʵ����ͬ�Ľӿ�
 * 4.�����ɫ������ʵ��ɫ������
 * 	����	ʹ��Runnable�ӿڴ���������һ���̵߳Ĺ���
 * 		��ʵ��ɫ���Լ�����
 * 		�����ɫ��Thread��
 * @author hc
 *
 */
public class StaticProxy {
	public static void main(String atgs[]){
		You you=new You();
		Daili dl=new Daili(you);
		dl.run();
	}
}
//�ӿ�
interface A{
	void run();
}
//�Լ�����
class You implements A{
	public void run(){
		System.out.println("�Ҵ�����һ���߳�");
	}
}
//�����ɫ
class Daili implements A{
	//������ʵ��ɫ������
	private You you;
	Daili(You you){
		this.you=you;
	}
	public void before(){
		System.out.println("������������׼������");
	}
	public void after(){
		System.out.println("�������������ƺ���");
	}
	public void run(){
		before();
		you.run();
		after();
	}
}