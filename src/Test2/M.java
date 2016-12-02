package Test2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class M {
	//�հ׷�����
	List<Partition> list = new LinkedList<Partition>();
	int G;
	int index=0;
	public void menu(){
		Scanner in= new Scanner(System.in);
		M f = new M();
		f.printfInfo();
		while(true){
			System.out.println("��ѡ��Ҫʹ�õķ����㷨��");
			System.out.println("1.�״���Ӧ�㷨");
			System.out.println("2.ѭ���״���Ӧ�㷨");
			System.out.println("3.�����Ӧ�㷨");
			System.out.println("4.���Ӧ�㷨");
			int x=in.nextInt();
			System.out.println("��������ҵ�Ĵ�С��");
			int plength=in.nextInt();
			switch(x){
				case 1:f.FF(plength); break;
				case 2:f.NF(plength);break;
				case 3:f.BF(plength); break;
				case 4:f.F(plength); break;
				
			}
			System.out.println("���з�����ʣ�������");
			for(Partition i:list){
				System.out.print(i.size+"---->");
			}
			System.out.println();
			System.out.println("�Ƿ�������룺");
			System.out.println("1.����    0.�˳�");
			int c=in.nextInt();
			if(c!=1){
				break;
			}
		}
	}
	public void printfInfo(){
		Scanner in= new Scanner(System.in);
		System.out.println("���������G��");
		G=in.nextInt();
		System.out.println("������հ׷����ĸ�����");
		int num=in.nextInt();
		System.out.println("����������ÿ���հ׷�������ʼ��ַ�Լ���С��");
		for(int i=0;i<num;i++){
			int startAddress=in.nextInt();
			int size=in.nextInt();
			Partition temp=partitionFactory(startAddress, size);
			list.add(temp);
		}
		
	}
	
	/*
	 * ����������
	 */
	public Partition partitionFactory(int start,int size){
		return new Partition(size,start);
	}
	
	public void show(List list){
		System.out.println(list);
	}
	public void m(int pLength){
		//��ҵ��С
		int pSize=pLength;
		//���з�����С
		int size;
		System.out.println("��ǰ���Ϊ��");
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
		System.out.println("��������Ϊ��");
		show(list);
	}
	/*
	 * �״���Ӧ�㷨
	 */
	public void FF(int pLength){
		Collections.sort(list);
		m(pLength);
	}
	
	/*
	 * ѭ���״���Ӧ�㷨
	 */
	public void NF(int pLength){
		//��ҵ��С
		int pSize=pLength;
		//���з�����С
		int size;
		Collections.sort(list);
		System.out.println("��ǰ���Ϊ��");
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
		System.out.println("��������Ϊ��");
		show(list);
	}
	
	/*
	 * �����Ӧ�㷨
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
	 * ���Ӧ�㷨
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
