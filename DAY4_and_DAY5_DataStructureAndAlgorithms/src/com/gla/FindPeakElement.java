package com.gla;

public class FindPeakElement {
    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,3,1};
        int peakIndex = findPeak(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}

