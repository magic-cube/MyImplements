package Test2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class M {
	//空白分区链
	List<Partition> list = new LinkedList<Partition>();
	int G;
	int index=0;
	public void menu(){
		Scanner in= new Scanner(System.in);
		M f = new M();
		f.printfInfo();
		while(true){
			System.out.println("请选择要使用的分配算法：");
			System.out.println("1.首次适应算法");
			System.out.println("2.循环首次适应算法");
			System.out.println("3.最佳适应算法");
			System.out.println("4.最坏适应算法");
			int x=in.nextInt();
			System.out.println("请输入作业的大小：");
			int plength=in.nextInt();
			switch(x){
				case 1:f.FF(plength); break;
				case 2:f.NF(plength);break;
				case 3:f.BF(plength); break;
				case 4:f.F(plength); break;
				
			}
			System.out.println("空闲分区表剩余情况：");
			for(Partition i:list){
				System.out.print(i.size+"---->");
			}
			System.out.println();
			System.out.println("是否继续输入：");
			System.out.println("1.继续    0.退出");
			int c=in.nextInt();
			if(c!=1){
				break;
			}
		}
	}
	public void printfInfo(){
		Scanner in= new Scanner(System.in);
		System.out.println("请输入参数G：");
		G=in.nextInt();
		System.out.println("请输入空白分区的个数：");
		int num=in.nextInt();
		System.out.println("请依次输入每个空白分区的起始地址以及大小：");
		for(int i=0;i<num;i++){
			int startAddress=in.nextInt();
			int size=in.nextInt();
			Partition temp=partitionFactory(startAddress, size);
			list.add(temp);
		}
		
	}
	
	/*
	 * 分区工厂类
	 */
	public Partition partitionFactory(int start,int size){
		return new Partition(size,start);
	}
	
	public void show(List list){
		System.out.println(list);
	}
	public void m(int pLength){
		//作业大小
		int pSize=pLength;
		//空闲分区大小
		int size;
		System.out.println("当前情况为：");
		show(list);
		for(int i=0;i<list.size();i++){
			size=list.get(i).size;
			if(size-pSize>=G){
				list.get(i).size-=pSize;
				break;
			}else{
				list.get(i).size=0;
				break;
			}
		}
		System.out.println("分配后情况为：");
		show(list);
	}
	/*
	 * 首次适应算法
	 */
	public void FF(int pLength){
		Collections.sort(list);
		m(pLength);
	}
	
	/*
	 * 循环首次适应算法
	 */
	public void NF(int pLength){
		//作业大小
		int pSize=pLength;
		//空闲分区大小
		int size;
		Collections.sort(list);
		System.out.println("当前情况为：");
		show(list);
		for(int i=index;i<list.size();i++){
			size=list.get(i).size;
			if(size-pSize>=G){
				list.get(i).size-=pSize;
				index++;
				if(index==list.size()){
					index=0;
				}
				break;
			}else{
				list.get(i).size=0;
				index++;
				if(index==list.size()){
					index=0;
				}
				break;
			}
		}
		System.out.println("分配后情况为：");
		show(list);
	}
	
	/*
	 * 最佳适应算法
	 */
	public void BF(int pLength){
		Collections.sort(list,new java.util.Comparator<Partition>(){
			public int compare(Partition o1,Partition o2){
				return o1.size-o2.size;
			}
		});
		m(pLength);
	}
	
	/*
	 * 最坏适应算法
	 */
	public void F(int pLength){
		Collections.sort(list,new java.util.Comparator<Partition>(){
			public int compare(Partition o1,Partition o2){
				return -o1.size-o2.size;
			}
		});
		m(pLength);
	}
	public static void main(String args[]){
		M m= new M();
		m.menu();
	}
}
