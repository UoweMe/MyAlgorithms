package com.dgl.basic.others;

import com.dgl.basic.common.BasicUtils;

import java.util.Arrays;

/**
 * 左旋数组：123456左旋2各单位变为345612
 *
 * @author guandata
 */
public class ArrayLeftRotation {

    /**
     * 常规旋转思路，直接依次转移位置，优点是非常直观，缺点是另外开辟空间
     *
     * @param nums
     * @param n
     * @return 旋转后的数组
     */
    public static int[] rotateLeftNormal(int[] nums, int n) {
        int size = nums.length;
        n = n % size;
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = nums[n];
            n = (n + 1) % size;
        }
        return ans;
    }

    /**
     * 更加优异的方式：时间换空间，反转前a个字符，反转后b个字符，整体反转
     *
     * @param nums
     * @param n
     * @return
     */
    public static int[] rotateLeftQuick(int[] nums, int n) {
        int size = nums.length;
        n = n % size;
        BasicUtils.reverse(nums, 0, n - 1);
        BasicUtils.reverse(nums, n, size - 1);
        BasicUtils.reverse(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateLeftNormal(nums, 4)));
        System.out.println(Arrays.toString(rotateLeftQuick(nums, 4)));
    }

}
