package Stack;
/**
 * ��ʵ��
 * ջ����ʽ�洢�ṹ
 * ���ڲ���ʽ�洢���ƣ�
 * ʹ���� ĩ���ڱ� ���ж϶�ջ��ʱΪ�գ�����ڱ����ڹ���listʱ������
 * ÿ����һ��push()�������ͻᴴ��һ��Node<T>���󣬲��������ӵ�ǰһ��Node<T>����
 * �������pop()ʱ�����Ƿ���top.item ��Ȼ������ǰtop��ָ��Node<T>���󣬲���topת�Ƶ���һ������
 * ����������ĩ���ڱ�����ʱ��Ͳ����ƶ�top�ˣ�
 * ����Ѿ�������ĩ�ˣ��ͻ��˳��򻹼�������pop��������ֻ�ܵõ�null��˵����ջ�Ѿ�����
 * @author hc
 *
 */
public class MyStack<T> {
	//�Ծ�̬�ڲ������ʽʵ�ָ�Ϊ����
	private static class Node<U>{
		U item;
		Node<U> next;
		
		Node(){
			item=null;
			next=null;
		}
		Node(U item,Node<U> next){
			this.item=item;
			this.next=next;
		}
		
		boolean end(){
			return item==null&&next==null;
		}
	}
	
	//top ջ��Ԫ��ָ��
	private Node<T> top = new Node<T>();
	
	//��ջ
	public void push(T item){
		top=new Node<T>(item,top);
	}
	
	//��ջ  ɾ��ջ��Ԫ�ز�����
	public T pop(){
		T result = top.item;
		if(!top.end()){
			top=top.next;
		}
		return result;
	}
	
	//�пղ���
	public boolean empty(){
		return top.end();
	}
	
	//����
	public static void main(String args[]){
		MyStack<String> ms = new MyStack<String>();
		//����������ַ���
		for(String s:"enoemos rof , gnihtemos rof gnihcraes syawla ma i ekil leef i".split("")){
			ms.push(s);
		}
		String s;
		while((s=ms.pop())!=null){
			System.out.print(s);
		}
	}
}
