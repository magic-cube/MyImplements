package Map;
/**
 * ����ʵ��Map���ܣ���getʱÿ�ζ���Ҫ������Ч�ʽϵ�
 * @author hc
 *
 */
public class SxtMap {
	 SxtEntry [] arr= new SxtEntry[100];
	 private int size;
	 //������ظ������put
	 public void put(Object key,Object value){
		 //ֱ�Ӹ���
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
		//���Ը���
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