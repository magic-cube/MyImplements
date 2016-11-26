package Iterator;
/**
 * �������Ĵֲ�ʵ��
 * ��������ԭ��
 * @author hc
 *
 */
public class MyIterator1 {
	String [] s={"a","b","c"};
	private int cursor=-1;  //ָ�룬���α�       �α�ָ���һ��Ԫ�ص�ǰ��
	private int size=s.length;
	public int getSize(){
		return this.size;
	}
	//�ж��Ƿ�����һ��
	public boolean hasNext(){
		//�α��һС��size
		if(cursor+1<size){
			return true;
		}else{
			return false;
		}
	}
	
	//��ȡ��һ��Ԫ��
	public String next(){
		cursor++;
		return s[cursor];
	}
	
	//ɾ����һ��Ԫ��
	public void remove(){
		//�����ƶ����Ƴ�Ԫ��
		//Ҫ���Ƶ�����   ���Ŀ�ʼ����   ���Ƶ��ĸ�����    ���Ŀ�ʼճ��    ���Ƶĳ���
		System.arraycopy(s, cursor, s, cursor+1, this.size-(cursor+1));
		//ʵ�ʴ�С-1
		this.size--;
		//�α����һ��
		this.cursor--;
	}
	public static void main(String[] args) {
		MyIterator1 mi=new MyIterator1();
		//���жϣ����ȡ
		while(mi.hasNext()){
			System.out.println(mi.next());
			mi.remove();
		}
		System.out.println(mi.getSize());
	}

}
