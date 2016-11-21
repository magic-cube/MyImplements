package Test;

public class Person {
	private String name;
	private String id;
	private String cls;
	Person(){
		
	}
	Person(String name,String id,String cls){
		this.name=name;
		this.id=id;
		this.cls=cls;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	
}
