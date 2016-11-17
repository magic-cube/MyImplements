package Map;
/*
 * Map�ļ�ʵ��
 * ��������
 */
public class SimpleImplementMap<K,V> {
	private Object[][] pairs;
	
	//���Լ�¼Ԫ�ظ���
	private int index;
	
	//���ù������Լ���Map������
	public SimpleImplementMap(int length) {
		//����Ϊlength ����Ϊ2
		pairs=new Object [length][2];
	}
	
	public void put(K key,V value){
		if(index>=pairs.length){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//�ӵ����п�ʼ�����������key-value��ֵ�� index++
		pairs[index++]=new Object[]{key,value};
		//��ִ�и�ֵ������Ȼ��index++;
	}
	
	public V get(K key){
		for(int i=0;i<index;i++){
			//��������������equals�����key��equals����õ�true�����ظ�key��Ӧ��value
			//�Ƚ����ε�һ���취������δ�õ�hashCode()��������ΪMap�Ĳ�������Ϊ     HashMap<Integer,String>,key��Value��ֵ����equals
			//String���equals��������д���Ƚϵ���String��������ݣ�
			//��Ĭ�ϵ�equals�Ƚϵ��Ƕ�������ã������Ҫ�õ�hashCode(),��������Ϊ��String�����ñȽ϶�������
			if(key.equals(pairs[i][0])){
				//����V���ͣ�ǿת
				return (V)pairs[i][1];
			}
		}
		return null;   //û�ҵ�
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(int i=0;i<index;i++){
			result.append(pairs[i][0].toString());
			result.append(":");
			result.append(pairs[i][1].toString());
			if(i<index-1){
				result.append("\n");
			}
		}
		return result.toString();
	}
	public static void main(String[] args) {
		SimpleImplementMap<String,String> sim=new SimpleImplementMap<String,String>(3);
		sim.put("sky","blue");
		sim.put("glass","green");
		sim.put("sun","yellow");
//		try{
//			sim.put("haochuan","sb");
//		}catch(Exception e){
//			System.out.println("haochuanbushide ");
//		}
		//system.out   �����toString����
		System.out.println(sim);
		System.out.println("---------");
		System.out.println(sim.get("sky"));
		
	}

}
