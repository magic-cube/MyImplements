package Test;
/*ͨ�����������ΪjavaBean,Ҳ�г���ʵ����
 * 
 * javaBean������,ֻ�����Ժ�set()   get() ����
 * 
 */

public class Person { 
	//����
	private String name;
	//˧��ָ��
	private int handsome;
	
	Person(String name,int hansome){
		this.name=name;
		this.handsome=handsome;
	}
	public int getHandsome(){
		return this.handsome;
	}
	
	//��дtoString�������Լ���Ҫ�ĸ�ʽ���
	public String toString(){
		return "������"+this.name+"˧��ָ����"+this.handsome+"\n";
	}
	
	
	
//	
//	private String id;
//	private String cls;
//	Person(){
//		
//	}
//	Person(String name,String id,String cls){
//		this.name=name;
//		this.id=id;
//		this.cls=cls;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getCls() {
//		return cls;
//	}
//	public void setCls(String cls) {
//		this.cls = cls;
//	}
//	
}
