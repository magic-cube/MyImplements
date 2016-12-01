package Test;
/**
 * 以list的方式存储
 */
import java.util.ArrayList;
import java.util.List;

public class Test1 {
	private List<Person> l1 = new ArrayList<Person>();
	public static void main(String args[]){
		Test1 t1= new Test1();
//		Person p1 =new Person("haochuan","14060102104","14060102");
//		Person p2 =new Person("huxindi","14060102105","14060102");
//		Person p3 =new Person("pangpu","14060102106","14060102");
		
//		t1.l1.add(p1);
//		t1.l1.add(p2);
//		t1.l1.add(p3);
//		t1.printInfo();
	}
	public void printInfo(){
		for(int i=0;i<l1.size();i++){
//			System.out.println(l1.get(i).getName());
		}
	}
}
