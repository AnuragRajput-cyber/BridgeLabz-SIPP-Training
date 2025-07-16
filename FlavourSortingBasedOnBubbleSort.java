package com.gla;

import java.util.*;
class Flavor{
	String flavorName;
	int quantitySold;
	Flavor(){};
	Flavor(String flavorName,int sells){
		this.flavorName=flavorName;
		this.quantitySold=sells;
	}
}
public class FlavourSortingBasedOnBubbleSort {
	public void sorting(Flavor[]arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j].quantitySold>arr[j+1].quantitySold) {
					Flavor temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public void displaySorted(Flavor[]arr) {
		System.out.println("flavor:"+"\t\t"+"quantity:");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].flavorName+"\t\t"+arr[i].quantitySold);
		}
	}
	
	public static void main(String[] args) {
		FlavourSortingBasedOnBubbleSort fs=new FlavourSortingBasedOnBubbleSort();
		Flavor[]flavor={
				new Flavor("mango",43),
				new Flavor("orange",2),
				new Flavor("pineapple",56),
				new Flavor("blubarry",12),
				new Flavor("banana",10)
		};
		fs.sorting(flavor);
		fs.displaySorted(flavor);
		
	}
}
