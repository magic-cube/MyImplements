package Test;

import java.util.TreeSet;

public class TreeSetDemo01 {

	public static void main(String[] args) {
		Person p1 = new Person("ºÂ´¨",10000);
		Person p2 = new Person("Áº³¯Î°",800);
		Person p3 = new Person("½ğ³ÇÎä",1000);
		Person p4 = new Person("ÀèÃ÷",900);
		TreeSet<Person> persons = new TreeSet<Person>(
				new java.util.Comparator<Person>(){
					public int compare(Person p1,Person p2){
						return p1.getHandsome()-p2.getHandsome();
					}
				}
				);
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		System.out.println(persons);
	}

}
