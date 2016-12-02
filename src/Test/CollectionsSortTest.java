package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSortTest {
	List<Worker> list = new ArrayList<Worker>();
	public static void main(String[] args) {
		Worker w1 = new Worker("a",123);
		Worker w2 = new Worker("b",456);
		Worker w3 = new Worker("c",789);
		CollectionsSortTest c1 = new CollectionsSortTest();
		c1.list.add(w3);
		c1.list.add(w2);
		c1.list.add(w1);
		//未排序之前，按插入顺序保存
		System.out.println(c1.list);
		
		Collections.sort(c1.list);
		System.out.println(c1.list);

	}

}
