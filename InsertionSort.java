
public class InsertionSort {
	public static void main(String[]args){
		int[] a = {2,3,7,5,10,6,8,1,4,9};
		int itemSorted;
		for(itemSorted=1; itemSorted<a.length; itemSorted++){
			int temp = a[itemSorted];
			int loc = itemSorted-1;
			while(loc>=0 && a[loc]>temp){
				a[loc+1]=a[loc];
				loc--;
			}
			a[loc+1]=temp;
		}
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]);
	}

}
