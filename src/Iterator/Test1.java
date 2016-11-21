package Iterator;
/**
 * Iterator的基本用法
 * 使用Iterator遍历List和Set
 * 在实际开发中，更多的是使用迭代器来遍历容器
 * 所有实现了Collection接口的容器类都有一个Iterator方法用以返回一个实现了Iterator接口的对象
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
