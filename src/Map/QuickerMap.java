package Map;
/**
 * Map��Ч�������汾
 * Map�ײ�ʵ�֣�����+����
 * @author hc
 *
 */
public class QuickerMap {
	SxtEntry1 [] arr = new SxtEntry1[999];
	private int size;
	public void put(Object key,Object value){
		SxtEntry1 e = new SxtEntry1(key,value);
		//��key��hashCode ��999ȡ��  �õ�0~998��Χ��һ������ ����Ϊ������±꣬ÿ��ȡֵ��ֵ��ʱ��ֱ��arr[key.hashcode()%999]
		//����ʱ������һ�����⣬hashCode()ȡ���õ���ֵ�����ظ�
		int a=key.hashCode()%999;
		arr[a]=e;
	}
	public Object get(Object key){
		return arr[key.hashCode()%999].value;
	}
	
	
	
	//���������編���Ƽ��ɣ��˴����پ���ʵ��
	
	
	
	public static void main(String[] args) {
	

	}

}
class SxtEntry1{
	Object key;
	Object value;
	SxtEntry1(){
		
	}
	SxtEntry1(Object key,Object value){
		this.key=key;
		this.value=value;
	}
}
