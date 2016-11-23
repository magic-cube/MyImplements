package Stack;
/**
 * 自实现
 * 栈的链式存储结构
 * （内部链式存储机制）
 * 使用了 末端哨兵 来判断堆栈何时为空，这个哨兵是在构建list时创建的
 * 每调用一次push()方法，就会创建一个Node<T>对象，并将其链接到前一个Node<T>对象
 * 当你调用pop()时，总是返回top.item ，然后丢弃当前top所指的Node<T>对象，并将top转移到下一个对象
 * 除非你碰到末端哨兵，这时候就不再移动top了，
 * 如果已经到达了末端，客户端程序还继续调用pop方法，它只能得到null，说明堆栈已经空了
 * @author hc
 *
 */
public class MyStack<T> {
	//以静态内部类的形式实现更为方便
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
	
	//top 栈顶元素指针
	private Node<T> top = new Node<T>();
	
	//出栈
	public void push(T item){
		top=new Node<T>(item,top);
	}
	
	//出栈  删除栈顶元素并返回
	public T pop(){
		T result = top.item;
		if(!top.end()){
			top=top.next;
		}
		return result;
	}
	
	//判空操作
	public boolean empty(){
		return top.end();
	}
	
	//测试
	public static void main(String args[]){
		MyStack<String> ms = new MyStack<String>();
		//逆序输出的字符串
		for(String s:"enoemos rof , gnihtemos rof gnihcraes syawla ma i ekil leef i".split("")){
			ms.push(s);
		}
		String s;
		while((s=ms.pop())!=null){
			System.out.print(s);
		}
	}
}
