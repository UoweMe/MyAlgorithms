package com.dgl.basic.common;

public class BasicUtils {

    /**
     * 数组部分旋转算法
     *
     * @param nums
     * @param left
     * @param right
     * @return 部分旋转后的数组
     */
    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    /**
     * 数组全旋转算法
     *
     * @param nums
     * @return 部分旋转后的数组
     */
    public static void reverse(int[] nums) {
        reverse(nums, 0, nums.length - 1);
    }
}
