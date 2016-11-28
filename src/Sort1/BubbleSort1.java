package Sort1;
/**
 * 冒泡排序
 * @author hc
 *
 */
public class BubbleSort1 {
	
	//排序过后会改变数组内元素顺序，三个版本，为保证验证三次个版本的排序，因而需三个数组
	static int [] a= {3,7,5,2,8,4};
	static int [] b= {3,7,5,1,8,4};
	static int [] c= {8,1,2,3,4,5};
	/*
	 * 初级版
	 */
	public static int[] sort1(int []a){
		for(int j=0;j<a.length-1;j++){			//需要a.length-1趟      六个数比五趟
			for(int i=0;i<a.length-1;i++){          //第一趟	
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
	 * 优化版
	 * 发现有些已经比较过了，会出现重复比较情况
	 * 减少每趟次数
	 */
	public static int[] sort2(int []b){
		for(int j=0;j<b.length-1;j++){			//趟数
			for(int i=0;i<b.length-1-j;i++){         //次数           跟趟数挂钩，减去趟数  
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
	 * 最终版
	 * 考虑有序，减少趟数
	 * 假设数据已经有序，或经过某趟后有序
	 * 如 
	 * 8 1 2 3 4
	 * 第一趟：1 2 3 4 8 
	 * 第二趟：1 2 3 4 8	发现没有交换，停止循环
	 */
	public static int[] sort3(int[] c){
		boolean sorted=true;
		for(int j=0;j<c.length-1;j++){			//趟数
			sorted=true;        //假定有序
			for(int i=0;i<c.length-1-j;i++){         //次数           减少每趟次数
				if(c[i]<c[i+1]){  //交换
					int temp=c[i];
					c[i]=c[i+1];
					c[i+1]=temp;
					sorted=false;      //如果发生过交换，将sorted置为false
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
		//测试   排序结果从大到小
		System.out.print("初级版：");
		for(int i=0;i<arr1.length;i++){
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		System.out.println("-------------------");
		
		System.out.print("优化版：");
		for(int i=0;i<arr2.length;i++){
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		System.out.println("--------------------");
		
		System.out.print("最终版：");
		for(int i=0;i<arr3.length;i++){
			System.out.print(arr3[i]+" ");
		}
	}

}
