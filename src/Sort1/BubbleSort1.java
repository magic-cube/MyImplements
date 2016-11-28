package Sort1;
/**
 * ð������
 * @author hc
 *
 */
public class BubbleSort1 {
	
	//��������ı�������Ԫ��˳�������汾��Ϊ��֤��֤���θ��汾�������������������
	static int [] a= {3,7,5,2,8,4};
	static int [] b= {3,7,5,1,8,4};
	static int [] c= {8,1,2,3,4,5};
	/*
	 * ������
	 */
	public static int[] sort1(int []a){
		for(int j=0;j<a.length-1;j++){			//��Ҫa.length-1��      ������������
			for(int i=0;i<a.length-1;i++){          //��һ��	
				if(a[i]<a[i+1]){
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
		}
		return a;
	}
	/*
	 * �Ż���
	 * ������Щ�Ѿ��ȽϹ��ˣ�������ظ��Ƚ����
	 * ����ÿ�˴���
	 */
	public static int[] sort2(int []b){
		for(int j=0;j<b.length-1;j++){			//����
			for(int i=0;i<b.length-1-j;i++){         //����           �������ҹ�����ȥ����  
				if(b[i]<b[i+1]){
					int temp=b[i];
					b[i]=b[i+1];
					b[i+1]=temp;
				}
			}
		}
		return b;
	}
	/*
	 * ���հ�
	 * �������򣬼�������
	 * ���������Ѿ����򣬻򾭹�ĳ�˺�����
	 * �� 
	 * 8 1 2 3 4
	 * ��һ�ˣ�1 2 3 4 8 
	 * �ڶ��ˣ�1 2 3 4 8	����û�н�����ֹͣѭ��
	 */
	public static int[] sort3(int[] c){
		boolean sorted=true;
		for(int j=0;j<c.length-1;j++){			//����
			sorted=true;        //�ٶ�����
			for(int i=0;i<c.length-1-j;i++){         //����           ����ÿ�˴���
				if(c[i]<c[i+1]){  //����
					int temp=c[i];
					c[i]=c[i+1];
					c[i+1]=temp;
					sorted=false;      //�����������������sorted��Ϊfalse
				}
			}
			if(sorted){      //sorted==true
				break;
			}
		}
		return c;
	}
	public static void main(String[] args) {
		int arr1[]=sort1(a);
		int arr2[]=sort2(b);
		int arr3[]=sort3(c);
		//����   �������Ӵ�С
		System.out.print("�����棺");
		for(int i=0;i<arr1.length;i++){
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		System.out.println("-------------------");
		
		System.out.print("�Ż��棺");
		for(int i=0;i<arr2.length;i++){
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		System.out.println("--------------------");
		
		System.out.print("���հ棺");
		for(int i=0;i<arr3.length;i++){
			System.out.print(arr3[i]+" ");
		}
	}

}
