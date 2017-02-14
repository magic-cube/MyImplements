package threaddemo;
/*
 * ���Զ���߳�ͬʱ����һ������ʱ,�����߳�δͬ�������ֵĴ���
 */
public class TraditonSynchronized {
	/*
	 * �ھ�̬�����в���new�ڲ����ʵ������
	 */
	public static void main(String[] args) {
		new TraditonSynchronized().init();
	}
	
	class Outputer{
		public void output(String name){
			int len=name.length();
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i)+" ");
			}
			System.out.println();
		}
	}
	
	/*
	 * �����ھ�̬������new�ڲ����ʵ������
	 * �ڲ�����Է����ⲿ��ĳ�Ա����,��ֻ���ڱ�ʵ������Ż�Ϊ��Ա��������ռ�
	 * ����̬�������Բ���ȥ������Ķ���,���������ì��
	 * ��ʱ,ʹ�ñ�ķ���ȥ��ɴ����ڲ������Ķ���,�㲻�ᷢ������
	 */
	private void init(){
		final Outputer out=new Outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("zhangxiaoxiang");
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("xihuoming");
				}
			}
		}).start();

	}
	
}
