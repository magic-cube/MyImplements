package Set;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.runner.notification.RunNotifier;
/**
 * TreeSet
 * @author hc
 *
 */
public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet ts=new TreeSet();
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
class Student implements Comparable{
	private String name;
	private int age;
	public Student(String name,int age) {
		this.age=age;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Student)){
			throw new RuntimeException("");
		}
		Student s=(Student)o;
		if(this.age>s.age){
			return 1;
		}
		if(this.age==s.age){
			return this.name.compareTo(s.name);
		}
		return -1;
	}
}






