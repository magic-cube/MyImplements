package Test;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * 实现自己的业务排序类
 * @author hc
 *
 */
public class TreeMapDemo03 {
	private TreeSet<Worker> workers = new TreeSet<Worker>();
	//初始化
	public void printfInfo(){
		Worker w1= new Worker("农民工",3000);
		Worker w2= new Worker("程序员",2000);
		Worker w3= new Worker("教师",8000);
		Worker w4= new Worker("医生",10000);
		workers.add(w4);
		workers.add(w3);
		workers.add(w2);
		workers.add(w1);
	}
	//遍历treeMap
	public  void show(){
		Iterator<Worker> it=workers.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public static void main(String[] args) {
		TreeMapDemo03 t3= new TreeMapDemo03();
		t3.printfInfo();
		t3.show();
	}

}
