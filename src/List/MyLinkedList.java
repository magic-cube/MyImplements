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
			 last.setNext(n);
			 //让新添加的这个结点成为尾结点
			 last=n;
		}
		size++;
	}
	
	public void add(int index,Object obj){
		rangeCheck(index);
		Node findNode=node(index);            //找到的下标为index的Node
		Node upFindNode=findNode.previous;		//找到结点的上一个结点
		Node insertNode= new Node();		//新建的要插入的结点
		
		//插入结点的过程
		insertNode.previous=upFindNode;
		upFindNode.next=insertNode;
		
		insertNode.next=findNode;
		findNode.previous=insertNode;
		
		//将元素交给obj
		insertNode.obj=obj;
		
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
				//temp.setNext(temp);
				//temp=temp.next;
			}
		}
		//用户需要的是obj 而不是结点
		return temp.getObj();
	}
	
	public Node node(int index){
		Node temp=null;
		if(first!=null){
			temp=first;
			for(int i=0;i<index;i++){
				temp=temp.getNext();
			}
		}
		return temp;
	}
	
	public void remove(int index){
		rangeCheck(index);
		Node newNode=node(index);
		if(newNode!=null){
			Node up=newNode.getPrevious();
			Node down=newNode.getNext();
			up.setNext(down);
			down.setPrevious(up);
		}
		size--;
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) {
		MyLinkedList ml = new MyLinkedList();
		ml.add("aaa");
		ml.add("bbb");
		ml.add(1,"insert");
		
		//打印size，测试之前的添加是否成功
		System.out.println(ml.size);
		System.out.println(ml.get(1));        //输出结果为insert即插入成功
	}

}
