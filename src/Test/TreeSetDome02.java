package Test;

import java.util.TreeSet;

public class TreeSetDome02 {
	public static void main(String args[]){
		Animal a1 = new Animal("猫",30);
		Animal a2 = new Animal("狗",20);
		Animal a3 = new Animal("猪",50);
		Animal a4 = new Animal("鸭",10);
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
		//未重写toString之前会输出他的hashcode，要想按照自己的格式输出，需要重写toString（）方法
		System.err.println(animal);
		for(Animal a:animal){
			System.out.print(a.name+" ");
		}
	}
}
