package Map;
/*
 * Map的简单实现
 * 关联数组
 */
public class SimpleImplementMap<K,V> {
	private Object[][] pairs;
	
	//用以记录元素个数
	private int index;
	
	//利用构造器自己给Map赋长度
	public SimpleImplementMap(int length) {
		//行数为length 列数为2
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
		//从第零列开始，依次往里放key-value键值对 index++
		pairs[index++]=new Object[]{key,value};
		//先执行赋值操作，然后index++;
	}
	
	public V get(K key){
		for(int i=0;i<index;i++){
			//遍历，挨个进行equals，如果key的equals结果得到true，返回该key对应的value
			//比较无奈的一个办法。。。未用到hashCode()方法，因为Map的测试类型为     HashMap<Integer,String>,key与Value的值进行equals
			//String类对equals进行了重写，比较的是String对象的内容，
			//而默认的equals比较的是对象的引用，因而需要用到hashCode(),而这里因为是String，不用比较对象引用
			if(key.equals(pairs[i][0])){
				//返回V类型，强转
				return (V)pairs[i][1];
			}
		}
		return null;   //没找到
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
		//system.out   会调用toString方法
		System.out.println(sim);
		System.out.println("---------");
		System.out.println(sim.get("sky"));
		
	}

}
