package Others;
/**
 * 比较古老的接口Enumeration 和 Vector
 */
import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo01 {
	public static void main(String args[]){
		Vector<String> vector = new Vector<String>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		
		//使用enumeration遍历vector
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
