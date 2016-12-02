package Test;
/*
 * 工人类
 */
public class Worker implements java.lang.Comparable<Worker>{
	private String type; //工种
	private int salary;
	public Worker() {
	
	}
	public Worker(String type, int salary) {
		super();
		this.type = type;
		this.salary = salary;
	}
	/*
	 * 重写compareTo方法
	 * 升序
	 */
	public int compareTo(Worker o){
		return this.salary>o.salary?1:(this.salary==o.salary?0:-1);
	}
	/*
	 * 按照自己的格式输出
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "职业："+this.type+" "+"工资："+this.salary;
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
