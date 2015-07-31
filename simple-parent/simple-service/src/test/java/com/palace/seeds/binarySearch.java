package com.palace.seeds;

public class binarySearch {

	public static void main(String[] args) {
	}
	
	public void search(int arr[] ,int val){
		int len=arr.length;
		int mid=arr[len/2];
		int begin=0;
		while(val!=arr[mid]){
			if(arr[mid]>val){
				len=mid;
			}else if(arr[mid]<val){
				begin=mid;
			}
			mid=(len-begin/2);
		}
	}
}
