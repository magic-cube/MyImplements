package Test2;

public class Partition implements java.lang.Comparable<Partition>{
	int size;//�հ׷�����С
	int startAddress; //��ʼ��ַ
	public Partition() {
	
	}
	public Partition(int size, int startAddress) {
		super();
		this.size = size;
		this.startAddress = startAddress;
	}
	public int compareTo(Partition o){
		return this.startAddress>o.startAddress?1:(this.startAddress==o.startAddress?0:-1);
	}
	public String toString(){
		return " "+this.size+" ";
	}
	
}
