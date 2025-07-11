package com.gla;

import java.util.Scanner;

public class BubbleSort {
	public int[] bubbleSort(int[]arr) {
		for(int i=0;i<arr.length;i++) {
			boolean swap=false;
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swap=true;
				}
			}
			if(!swap) {
				break;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		BubbleSort bs=new BubbleSort();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] marks=new int[n];
		for(int i:marks) {
			marks[i]=sc.nextInt();
		}
		int[]ans=bs.bubbleSort(marks);
		for(int i:ans) {
			System.out.print(i+" ");
		}
		
	}
}
