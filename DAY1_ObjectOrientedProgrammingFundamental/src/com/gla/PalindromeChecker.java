package com.gla;

public class PalindromeChecker {
	private String text;
	public PalindromeChecker(String text) {
		this.text=text;
	}
	public boolean ifPalindrome(String text) {
		StringBuilder str = new StringBuilder();
		str.append(text);
		str.reverse();
		String str2 = str.toString();
		if(str2.equals(text)) {
			return true;
		}
		return false;
	}
	public void display() {
		System.out.println("result : "+ifPalindrome(text));
	}
	public static void main(String[] args) {
		PalindromeChecker plc=new PalindromeChecker("Anurag");
		plc.display();
	}
}
