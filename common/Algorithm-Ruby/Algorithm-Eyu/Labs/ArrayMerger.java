package lab2;

import java.util.Arrays;

public class ArrayMerger {
	int[] merge(int[] arr1, int[] arr2){
		int[] arr = combine(arr1, arr2);
		minSort(arr);
		return arr;
	}
	int[] combine(int[] arr1, int[] arr2){
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[] arr = new int[len1 + len2];
		for(int i = 0; i < len1; i++){
			arr[i] = arr1[i];			
		}
		for(int i = 0; i < len2; i++){
			arr[len1 + i] = arr2[i];			
		}
		return arr;
	}
	
	void minSort(int[] arr){
		int min;
		for(int i = 0; i < arr.length - 2; i++){
			min = arr[i];
			for(int j = i + 1; j < arr.length - 1; j++){
				if(arr[j] < min){
					min = arr[j];
					arr[j] = arr[i];
				}
			}
			arr[i] = min;
		}
		
	}
	public static void main(String[] args){
		int[] arr1 = {1, 4, 5, 8, 17};
		int[] arr2 = {2, 4, 8, 11, 13, 21, 23, 25};
		ArrayMerger am = new ArrayMerger();
		int[] arr = am.merge(arr1, arr2);
		System.out.println(Arrays.toString(arr));
	}

}
