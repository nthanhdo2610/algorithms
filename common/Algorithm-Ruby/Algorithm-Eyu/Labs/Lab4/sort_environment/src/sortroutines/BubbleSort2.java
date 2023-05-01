package sortroutines;

import java.util.Arrays;

import runtime.Sorter;

/**
 * This is the slowest version of BubbleSort
 * No optimization for already sorted arrays.
 * Doesn't take into account the fact that
 * largest elements are pushed to the right.
 *
 */
public class BubbleSort2 extends Sorter {
	
	int[] arr;
	public int[] sort(int[] array){
		this.arr = array;
		bubbleSort2();
		return arr;
		
	}
	private void bubbleSort2(){
		
		int len = arr.length;
		if(isSorted()){
			return;
		}
		for(int i = 0; i < len; ++i) {
			for(int j = 0; j < len-1-i; ++j) {
				if(arr[j]> arr[j+1]){
					swap(j,j+1);
				}
			}
		}
	}
	
	int[] swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
		
	}
	
	boolean isSorted(){
		int index = arr.length - 1;
		while(index > 0){
			if(arr[index - 1] > arr[index]){
				return false;
			}
			index--;
		}
		return true;		
	}
	
	public static void main(String[] args){
		int[] test = {21,13,1,-22, 51, 5, 18};
		BubbleSort2 bs = new BubbleSort2();
		
		System.out.println(Arrays.toString(bs.sort(test)));
		
	}

}
