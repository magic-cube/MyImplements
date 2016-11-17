package List;

public class MyLinkedList {
	//头结点与尾结点
	private Node first;
	private Node last;
	
	//size 用以记录结点的个数
	private int size;
	
	public void add(Object obj){
		Node n= new Node();
		if(first==null){  //第一个结点
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			//此时头结点也是尾结点，将新建的结点赋给头结点
			first=n;
			last=n;
			
		}else{
			//头结点不为空
			//直接往last后添加新的结点
			 n.setPrevious(last);
			 n.setObj(obj);
			 n.setNext(null);
			 //让新添加的这个结点成为尾结点
			 last=n;
		}
		size++;
	}
	public void rangeCheck(int index){
		if(index<0||index>=size){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public Object get(int index){
		rangeCheck(index);
		Node temp=null;
		if(first!=null){
			temp=first;
			for(int i=0;i<index;i++){
				temp=temp.getNext();
			}
		}
		//用户需要的是obj 而不是结点
		return temp.getObj();
	}
	
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) {
		MyLinkedList ml = new MyLinkedList();
		ml.add("aaa");
		ml.add("bbb");
		//打印size，测试之前的两次添加是否成功
		System.out.println(ml.size);
	}

}
