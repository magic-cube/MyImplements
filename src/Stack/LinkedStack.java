package Stack;

import java.util.LinkedList;

/**
 * LinkedList�����ܹ�ֱ��ʵ��Stack�����й��ܵķ���ʱ
 * ��˿���ֱ�ӽ�LinkedList��Ϊջʹ�ã���������ʱ��һ��������ջ�����ܰ����齲���
 * @author hc
 *
 */
public class LinkedStack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	
	//push ��ջ�����Ԫ����ջ��
	public void push(T t){
		storage.addFirst(t);
	}
	
	//peek ��ȡջ��Ԫ��
	public T peek(){
		return storage.getFirst();
	}
	
	//��ջ��ɾ��������ջ��Ԫ��
	public T pop(){
		return storage.removeFirst();
	}
	
	//empty �пղ���
	public boolean empty(){
		return storage.isEmpty();
	}
	
	//toString
	public String toString(){
		return storage.toString();
	}
	
	
	
	


}
