package Set;

import java.util.HashMap;

/**
 * 自实现的HashSet
 * set底层实现是基于map的，因为map的不可重复，所以set也不可重复
 * @author hc
 *
 */
public class MyHashSet {
	HashMap map;
	private static final Object PRESENT=new Object();
	
	public MyHashSet() {
		map=new HashMap();
	}
	
	public void add(Object o){
		map.put(o, PRESENT);
	}
	
	public int size(){
		return map.size();
	}
	/*
	public void remove(){
		
	}
	
	public boolean contains(Object o){
		return false;
	}
	*/
	public static void main(String[] args) {
		MyHashSet ms= new MyHashSet();
		ms.add("aaa");
		ms.add(new String("aaa"));
		
		System.out.println(ms.size());

	}

}
