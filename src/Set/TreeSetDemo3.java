package Set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * 当元素自身不具备比较性时,或具备的比较性不是我们所需要的时,需要让集合自身具备比较性
 * 使用指定的比较器Comparator
 */
public class TreeSetDemo3 {
	public static void main(String[] args) {
		TreeSet<String> ts=new TreeSet<String>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				String s1=(String)o1;
				String s2=(String)o2;
				if(s1.length()>s2.length()){
					return 1;
				}
				if(s1.length()==s2.length()){
					
					return s1.compareTo(s2);
				}
				return -1;
			}
		});
		
		
		
		ts.add("abcd");
		ts.add("cc");
		ts.add("cba");
		ts.add("aaa");
		ts.add("z");
		Iterator it=ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
