package Set;

import java.util.HashMap;

/**
 * ��ʵ�ֵ�HashSet
 * set�ײ�ʵ���ǻ���map�ģ���Ϊmap�Ĳ����ظ�������setҲ�����ظ�
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
