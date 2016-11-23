package Stack;

import java.util.LinkedList;

/**
 * LinkedList具有能够直接实现Stack的所有功能的方法时
 * 因此可以直接将LinkedList作为栈使用，不过，有时候一个真正的栈，更能把事情讲清楚
 * @author hc
 *
 */
public class LinkedStack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	
	//push 入栈，添加元素至栈顶
	public void push(T t){
		storage.addFirst(t);
	}
	
	//peek 获取栈顶元素
	public T peek(){
		return storage.getFirst();
	}
	
	//出栈，删除并返回栈顶元素
	public T pop(){
		return storage.removeFirst();
	}
	
	//empty 判空操作
	public boolean empty(){
		return storage.isEmpty();
	}
	
	//toString
	public String toString(){
		return storage.toString();
	}
	
	
	
	


}
