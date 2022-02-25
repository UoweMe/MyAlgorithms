package com.dgl.easy;

import com.dgl.basic.others.Fibonacci;

/**
 * @author donggenlei
 *
 */
public class Solution509 {

    public static int calFibonacci(int n) {
        return Fibonacci.calByNonRecursion(n);
        //return Fibonacci.calByRecursion(n);
    }
}
