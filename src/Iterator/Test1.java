package Iterator;
/**
 * Iterator�Ļ����÷�
 * ʹ��Iterator����List��Set
 * ��ʵ�ʿ����У��������ʹ�õ���������������
 * ����ʵ����Collection�ӿڵ������඼��һ��Iterator�������Է���һ��ʵ����Iterator�ӿڵĶ���
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test1 {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			String s=(String)it.next();
			System.out.println(s);
		}
		
		System.out.println("----------");
		
		for(int i=0;i<list.size();i++){
			System.out.println((String)list.get(i));
		}
		
		System.out.println("***********");
		
		
		Set set = new HashSet();
		set.add("hc");
		set.add("guang");
		
		Iterator it2 = set.iterator();
		while(it2.hasNext()){
			String s =(String)it2.next();
			System.out.println(s); 
		}
		System.out.println("@@@@@@@@@@");
		
		for(Iterator it3=set.iterator();it3.hasNext();){
			String s =(String)it3.next();
			System.out.println(s); 
		}
	}

}
