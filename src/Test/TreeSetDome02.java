package Test;

import java.util.TreeSet;

public class TreeSetDome02 {
	public static void main(String args[]){
		Animal a1 = new Animal("è",30);
		Animal a2 = new Animal("��",20);
		Animal a3 = new Animal("��",50);
		Animal a4 = new Animal("Ѽ",10);
		TreeSet<Animal> animal=new TreeSet<Animal>(
				new java.util.Comparator<Animal>(){
					public int compare(Animal a1,Animal a2){
						return a1.age-a2.age;
					}
				}
				);
		
		animal.add(a1);
		animal.add(a2);
		animal.add(a3);
		animal.add(a4);
		//δ��дtoString֮ǰ���������hashcode��Ҫ�밴���Լ��ĸ�ʽ�������Ҫ��дtoString��������
		System.err.println(animal);
		for(Animal a:animal){
			System.out.print(a.name+" ");
		}
	}
}
