package List;
//节点类
public class Node {
	private Node previous; //上一个结点
	private Object obj;
	private Node next;	//下一个结点   使用结点类型
	
	public Node(){
		
	}
	public Node(Node previous,Object obj,Node next){
		this.previous=previous;
		this.obj=obj;
		this.next=next;
	}
	
	public Node getPrevious(){
		return previous;
	}
	public void setPrevious(Node previous){
		this.previous=previous;
	}
	
	public Object getObj(){
		return obj;
	}
	public void setObj(Object obj){
		this.obj=obj;
	}
	
	public Node getNext(){
		return next;
	}
	public void setNext(Node next){
		this.next=next;
	}
	
}
