package Others;
/**
 * �ȽϹ��ϵĽӿ�Enumeration �� Vector
 */
import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo01 {
	public static void main(String args[]){
		Vector<String> vector = new Vector<String>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		
		//ʹ��enumeration����vector
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
