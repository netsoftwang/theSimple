package com.palace.seeds.sort;

import org.junit.Test;

public class SortTest {

	
	
	@Test
	public void testMaoPao(){
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]<arr[j+1]){
					int tep= arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tep;
				}
			}
		}
		String des="";
		for(int k=0;k<arr.length;k++)
			des+=arr[k]+",";
		System.out.println("maoPao:"+des);
	}
	
	@Test
	public void testXuanzhe(){
		for(int i=0;i<arr.length-1;i++){
			int tep=arr[i];
			for(int j=i+1;j<arr.length;j++){
				if(tep > arr[j]){
					int swp=arr[j];
					arr[i]=swp;
					arr[j]=tep;
					tep=swp;
				}else{
					continue;
				}
			}
		}
		String des="";
		for(int k=0;k<arr.length;k++)
			des+=arr[k]+",";
		System.out.println("xuanzhe:"+des);
	}
	
	
	@Test
	public void testChaRu(){
		for(int i=1;i<arr.length;i++){
			int tmp=arr[i];
			int j=0;
			for(j=i-1;j>=0;j--){
				if(tmp<arr[j]){
					arr[j+1]=arr[j];
				}else{
					break;
				}
			}
			arr[j+1]=tmp;
				
		}
		String des="";
		for(int k=0;k<arr.length;k++)
			des+=arr[k]+",";
		System.out.println("charu:"+des);
		
	}
	
	@Test
	public void testKuaiSu(){
		
	
	}
	Integer[] arr=new Integer[]{34,56,12,125,12,3,345,13,33,67,222};
	public int par(Integer[] myArr ,int low,int high){
		int m=myArr[low];
		int p=low;
		while(low<=high){
			if(myArr[low]>m&&low<p){
				int pm=myArr[p];
				int mp=p;
				while(mp>low){
					myArr[mp]=myArr[--mp];
				}
				p++;
				myArr[p]=pm;
			}else if(myArr[low]<m&&low>p){
				int lowm=myArr[low];
				int lowp=low;
				while(lowp>p){
					myArr[lowp]=myArr[--lowp];
				}
				myArr[p]=lowm;
				p++;
			}
			
			low++;
		}
		return p;
	}
	
	public void kaiSu(Integer[] arr,int low ,int high){
		while(low<high){
			int m = this.par(arr,low, high);
				kaiSu(arr,low,m-1);
				kaiSu(arr,m+1,high);
			low++;
		}
	
	}
	public static void main(String[] args) {
		SortTest st=new SortTest();
		st.kaiSu(st.arr, 0,st.arr.length-1);
		String des="";
		for(int k=0;k<st.arr.length;k++)
			des+=st.arr[k]+",";
		System.out.println("temp:"+des);
	}
	
}
