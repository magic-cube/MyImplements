package Test;
/*通常将这种类称为javaBean,也有称作实体类
 * 
 * javaBean这种类,只有属性和set()   get() 方法
 * 
 */

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
