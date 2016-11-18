package List;

public class MyLinkedList {
	//ͷ�����β���
	private Node first;
	private Node last;
	
	//size ���Լ�¼���ĸ���
	private int size;
	
	public void add(Object obj){
		Node n= new Node();
		if(first==null){  //��һ�����
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			//��ʱͷ���Ҳ��β��㣬���½��Ľ�㸳��ͷ���
			first=n;
			last=n;
			
		}else{
			//ͷ��㲻Ϊ��
			//ֱ����last������µĽ��
			 n.setPrevious(last);
			 n.setObj(obj);
			 n.setNext(null);
			 last.setNext(n);
			 //������ӵ��������Ϊβ���
			 last=n;
		}
		size++;
	}
	
	public void rangeCheck(int index){
		if(index<0||index>=size){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	

	public Object get(int index){
		rangeCheck(index);
		Node temp=null;
		if(first!=null){
			temp=first;
			for(int i=0;i<index;i++){
				temp=temp.getNext();
				//temp.setNext(temp);
				//temp=temp.next;
			}
		}
		//�û���Ҫ����obj �����ǽ��
		return temp.getObj();
	}
	
	public Node node(int index){
		Node temp=null;
		if(first!=null){
			temp=first;
			for(int i=0;i<index;i++){
				temp=temp.getNext();
			}
		}
		return temp;
	}
	
	public void remove(int index){
		rangeCheck(index);
		Node newNode=node(index);
		if(newNode!=null){
			Node up=newNode.getPrevious();
			Node down=newNode.getNext();
			up.setNext(down);
			down.setPrevious(up);
		}
		size--;
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) {
		MyLinkedList ml = new MyLinkedList();
		ml.add("aaa");
		ml.add("bbb");
		//��ӡsize������֮ǰ����������Ƿ�ɹ�
		System.out.println(ml.size);
		System.out.println(ml.get(1));
	}

}
