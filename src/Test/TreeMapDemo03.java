package Test;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * ʵ���Լ���ҵ��������
 * @author hc
 *
 */
public class TreeMapDemo03 {
	private TreeSet<Worker> workers = new TreeSet<Worker>();
	//��ʼ��
	public void printfInfo(){
		Worker w1= new Worker("ũ��",3000);
		Worker w2= new Worker("����Ա",2000);
		Worker w3= new Worker("��ʦ",8000);
		Worker w4= new Worker("ҽ��",10000);
		workers.add(w4);
		workers.add(w3);
		workers.add(w2);
		workers.add(w1);
	}
	//����treeMap
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
