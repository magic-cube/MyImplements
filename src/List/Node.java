package List;
//�ڵ���
public class Node {
	private Object previous;
	private Object obj;
	private Object next;
	
	public Object getPrevious(){
		return previous;
	}
	public void setPrevious(Object previous){
		this.previous=previous;
	}
	
	public Object getObj(){
		return obj;
	}
	public void setObj(Object obj){
		this.obj=obj;
	}
	
	public Object getNext(){
		return next;
	}
	public void setNext(Object next){
		this.next=next;
	}
	
}
