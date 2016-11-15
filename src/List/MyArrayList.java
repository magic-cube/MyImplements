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
	
	public void add(String s){
		elementData[size++]=s;
		//size++;
	}
	//重载add，根据索引添加元素
	public void add(int index,String s){
		//范围检查
		if(index>=size||index<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//数组的扩容
		Object[] newArray = new Object[size*2+1];
		//System.arraycopy的使用
		//System.arraycopy(elementData, 0, newArray, 0, elementData.length);
		//自己实现arraycopy
		//实现数组的元素的拷贝
		for(int i=0;i<elementData.length;i++){
			newArray[i]=elementData[i];
		}
		//将新建数组交给elementData继续使用
		elementData=newArray;
		size++;
	}
	public void remove(int index){
		
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
		//未应用泛型之前，我还是强制转换一下吧。。。
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
	
	
	public static void main(String[] args) {
		MyArrayList  m = new MyArrayList(4);
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
	}

}






