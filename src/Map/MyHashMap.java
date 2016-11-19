package Map;

import List.MyLinkedList;

/**
 * 自实现的HashMap
 * 解决了散列冲突问题
 * Map底层的实现：数组+链表
 * 之前是在数组中存放对象，初步散列
 * 现在是在数组中存放链表，在链表中存放对象，解决散列冲突，因而数组的大小也就不再重要了
 * 访问形式：用数组下标访问链表，若链表中存在多个元素则遍历链表（即存在散列冲突），若只有一个元素，则不用
 * @author hc
 *
 */
public class MyHashMap {
	//用的是我自己实现的链表，导入了List包小的MyLinkedList，当然也可用java.util库下的LinkedList，导入就好
	MyLinkedList [] arr = new MyLinkedList[999];

	private int size;
	public void put(Object key,Object value){
		int a=key.hashCode()%999;       //自实现的散列码
		
		// MyLinkedList list = new MyLinkedList();     //新建的链表                                     ****此处注意不能放在外面，不然每次都会建立一个链表
		
		//键值对对象，
		Entry e =new Entry(key,value);
		
		//第一次放时判断是否为空，为空放链表，不为空直接往链表里add
		if(arr[a]==null){
			MyLinkedList list = new MyLinkedList();
			arr[a]=list;				//将链表放入数组中
			list.add(e);                        //将对象放入链表中
		}else{    
			//a r r [a] 即那个链表对象
			arr[a].add(e);                      //将对象放入链表中
		}
		size++;
	}
	public static void main(String[] args) {

	}

}
class Entry{
	Object key;
	Object value;
	Entry(){
		
	}
	Entry(Object key,Object value){
		this.key=key;
		this.value=value;
	}
}
