package Map;
/**
 * 基本实现Map功能，但get时每次都需要遍历，效率较低
 * @author hc
 *
 */
public class SxtMap {
	 SxtEntry [] arr= new SxtEntry[100];
	 private int size;
	 //解决键重复问题的put
	 public void put(Object key,Object value){
		 //直接覆盖
		 for(int i=0;i<size;i++){
			 if(arr[i].key.equals(key)){
				 arr[i].value=value;
			 }
		 }
		 SxtEntry s=new SxtEntry(key,value);
		 arr[size++]=s;
		 
	 }
	 public Object get(Object key){
		 for(int i=0;i<size;i++){
			 if(arr[i].key.equals(key)){
				 return arr[i].value;
			 }
		 }
		 return null;
	 }
	 public boolean containKey(Object key){
		 for(int i=0;i<size;i++){
			 if(arr[i].key.equals(key)){
				 return true;
			 }
		 }
		 return false;
	 }
	 public boolean containValue(Object value){
		 for(int i=0;i<size;i++){
			 if(arr[i].value.equals(value)){
				 return true;
			 }
		 }
		 return false;
	 }
	public static void main(String[] args) {
		SxtMap sm =new SxtMap();
		sm.put("a", "haochuan");
		sm.put("b", "chuan");
		//测试覆盖
		sm.put("a", "hao");
		sm.get("a");
		System.out.println(sm.get("b"));

	}

}
class SxtEntry{
	Object key;
	Object value;
	SxtEntry(){
		
	}
	SxtEntry(Object key,Object value){
		this.key=key;
		this.value=value;
	}
}