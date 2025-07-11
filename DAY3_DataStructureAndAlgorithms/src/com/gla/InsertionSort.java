package com.gla;

import java.util.Scanner;

public class InsertionSort {
	public int[] insertionSort(int[]arr) {
		for(int i=1;i<arr.length;i++) {
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		return arr;
	}
	public static void main(String[] args) {
		InsertionSort bs=new InsertionSort();
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		int[] empId=new int[n];
//		for(int i:empId) {
//			empId[i]=sc.nextInt();
//		}
		int[]empId= {12,11,13,5,6};
		int[]ans=bs.insertionSort(empId);
		for(int i:ans) {
			System.out.print(i+" ");
		}
		
	}
}
