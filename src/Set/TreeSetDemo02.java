package Set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * 当元素自身不具备比较性时,或具备的比较性不是我们所需要的时,需要让集合自身具备比较性
 * 使用指定的比较器Comparator
 */
public class TreeSetDemo02 {
	public static void main(String[] args) {
		TreeSet<Student> ts=new TreeSet<Student>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				Student s1=(Student)o1;
				Student s2=(Student)o2;
				int num= s1.getName().compareTo(s2.getName());
				
				if(num==0){
					return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
				}
				
				return num;
			}
		});
		
		
		
		ts.add(new Student("lisi02",22));
		ts.add(new Student("lisi007",20));
		ts.add(new Student("lisi09",19));
		//ts.add(new Student("lisi01",40));
		Iterator it=ts.iterator();
		while(it.hasNext()){
			Student s=(Student)it.next();
			System.out.println(s.getName()+" "+s.getAge());
		}
	}
}
