package Test;
/*
 * ������
 */
public class Worker implements java.lang.Comparable<Worker>{
	private String type; //����
	private int salary;
	public Worker() {
	
	}
	public Worker(String type, int salary) {
		super();
		this.type = type;
		this.salary = salary;
	}
	/*
	 * ��дcompareTo����
	 * ����
	 */
	public int compareTo(Worker o){
		return this.salary>o.salary?1:(this.salary==o.salary?0:-1);
	}
	/*
	 * �����Լ��ĸ�ʽ���
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "ְҵ��"+this.type+" "+"���ʣ�"+this.salary;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	
}
