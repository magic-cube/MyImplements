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
	//��Χ���
	private void rangeCheck(int index){
		if(index<0||index>=size){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public int size(){
		return size;
	}
	
	public void add(String s){
		//���������
		if(size==elementData.length){
			Object[] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
//			for(int i=0;i<elementData.length;i++){
//				newArray[i]=elementData[i];
//			}
			elementData=newArray;
		}
		elementData[size++]=s;
		//size++;
	}
	//����add�������������Ԫ��
	public void add(int index,Object obj){
		//��Χ���
//		if(index>=size||index<0){
//			try {
//				throw new Exception();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		rangeCheck(index);
		//���������
		if(size==elementData.length){	
			Object[] newArray = new Object[size*2+1];
			//System.arraycopy��ʹ��(�����Ƶ����飬�ӵڼ���Ԫ�ؿ�ʼ���ƣ�Ҫ���Ƶ������飬�ӵڼ���Ԫ�ؿ�ʼճ����Ҫ���Ƶ�Ԫ�صĸ���)
			System.arraycopy(elementData,  0, newArray, 0, elementData.length);
			//�Լ�ʵ��arraycopy
			//ʵ�������Ԫ�صĿ���
//			for(int i=0;i<elementData.length;i++){     /
//				newArray[i]=elementData[i];
//			}
			//���½����齻��elementData����ʹ��
			elementData=newArray;
		}
		//ʵ��������������Ԫ��
		//����
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index]=obj;
		
		size++;
	}
	
	public void remove(int index){
		rangeCheck(index);
		//arrayCopy(�����Ƶ����飬�ӵڼ���Ԫ�ؿ�ʼ���ƣ�Ҫ���Ƶ������飬�ӵڼ���Ԫ�ؿ�ʼճ����Ҫ���Ƶ�Ԫ�ظ���)
		System.arraycopy(elementData, index+1, elementData, index,size-index-1);
		//�����һ��λ����Ϊ�գ�֮��size--
		elementData[size--]=null;
	}
	public void remove(Object obj){
		for(int i=0;i<size;i++){
			if(get(i).equals(obj)){
				remove(i);
			}
		}
		size--;
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
		//δӦ�÷���
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
	
	//��������
	public static void main(String[] args) {
		MyArrayList  m = new MyArrayList(5);
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
		m.add(2,"adsd");
		m.set(2,"aaaa");
		System.out.println("--------");
		for(int i = 0;i<m.size();i++){
			System.out.println(m.get(i));
		}
	}

}






