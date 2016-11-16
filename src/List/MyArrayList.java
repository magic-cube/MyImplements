package List;
//只实现部分常用方法
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
	//范围检查
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
		//数组的扩容
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
	//重载add，根据索引添加元素
	public void add(int index,Object obj){
		//范围检查
//		if(index>=size||index<0){
//			try {
//				throw new Exception();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		rangeCheck(index);
		//数组的扩容
		if(size==elementData.length){	
			Object[] newArray = new Object[size*2+1];
			//System.arraycopy的使用(被复制的数组，从第几个元素开始复制，要复制到的数组，从第几个元素开始粘贴，要复制的元素的个数)
			System.arraycopy(elementData,  0, newArray, 0, elementData.length);
			//自己实现arraycopy
			//实现数组的元素的拷贝
//			for(int i=0;i<elementData.length;i++){     /
//				newArray[i]=elementData[i];
//			}
			//将新建数组交给elementData继续使用
			elementData=newArray;
		}
		//实现向给定索引添加元素
		//拷贝
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index]=obj;
		
		size++;
	}
	
	public void remove(int index){
		rangeCheck(index);
		//arrayCopy(被复制的数组，从第几个元素开始复制，要复制到的数组，从第几个元素开始粘贴，要复制的元素个数)
		System.arraycopy(elementData, index+1, elementData, index,size-index-1);
		//将最后一个位置置为空，之后size--
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
		//范围检查
		if(index>size||index<0){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//未应用泛型
		String s = (String)elementData[index];
		return s;
	}
	
	public String set(int index,String s){
		//范围检查
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
	
	//测试数据
	public static void main(String[] args) {
		MyArrayList  m = new MyArrayList(5);
		m.add("haochuan");
		m.add("madiao");
		m.add("shuaike");
		m.add("aguang");
		//超出长度，抛一个异常，验证
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






