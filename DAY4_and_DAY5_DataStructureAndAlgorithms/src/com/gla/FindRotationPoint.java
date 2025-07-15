package com.gla;

public class FindRotationPoint {
    public static int findRotation(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int index = findRotation(nums);
        System.out.println("Rotation point index: " + index);
    }
}

