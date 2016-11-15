package List;
//ֻʵ�ֲ��ֳ��÷���
public class MyArrayList /*implements List */{
	private Object[] elementData;
	private int size;
	
	MyArrayList() {
		this(10);
	}
	MyArrayList(int initialCapacity){
		if(initialCapacity<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.elementData=new Object[initialCapacity];
		}
	}
	
	public void add(String s){
		elementData[size++]=s;
		//size++;
	}
	//����add�������������Ԫ��
	public void add(int index,String s){
		//��Χ���
		if(index>=size||index<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//���������
		Object[] newArray = new Object[size*2+1];
		//System.arraycopy��ʹ��
		//System.arraycopy(elementData, 0, newArray, 0, elementData.length);
		//�Լ�ʵ��arraycopy
		//ʵ�������Ԫ�صĿ���
		for(int i=0;i<elementData.length;i++){
			newArray[i]=elementData[i];
		}
		//���½����齻��elementData����ʹ��
		elementData=newArray;
		size++;
	}
	public void remove(int index){
		
	}
	public String get(int index){
		//��Χ���
		if(index>size||index<0){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//δӦ�÷���֮ǰ���һ���ǿ��ת��һ�°ɡ�����
		String s = (String)elementData[index];
		return s;
	}
	
	public String set(int index,String s){
		//��Χ���
		if(index>size||index<0){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		elementData[index]=s;
		return s;
	}
	
	public void clean(){
		for(int i=0;i<size;i++){
			elementData[i]=null;
		}
		size=0;
	}
	
	
	public static void main(String[] args) {
		MyArrayList  m = new MyArrayList(4);
		m.add("haochuan");
		m.add("madiao");
		m.add("shuaike");
		m.add("aguang");
		//�������ȣ���һ���쳣����֤
		//m.add("sdasd");
		System.out.println(m.get(0));
		System.out.println(m.get(1));
		System.out.println(m.get(2));
		System.out.println(m.get(3));
	}

}






