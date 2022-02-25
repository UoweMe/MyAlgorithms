package com.dgl.basic.others;

/**
 * @author Anirudh Buvanesh
 * @description 求斐波那契数列第n个数的大小
 *
 */
public class Fibonacci {

    // 斐波那契指数矩阵
    private static final int[][] fibMatrix = {{1, 1}, {1, 0}};
    private static final int[][] identityMatrix = {{1, 0}, {0, 1}};
    // 斐波那契数组
    private static final int[][] baseFibNumbers = {{1}, {0}};

    /**
     * 执行2个矩阵的乘法
     *
     * @param matrix1
     * @param matrix2
     * @return 矩阵1和矩阵2的乘积
     *
     * @link https://blog.csdn.net/flyfish1986/article/details/48014523
     */
    private static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
        // 检测矩阵是否能够相乘
        int rowsInMatrix1 = matrix1.length;
        int columnsInMatrix1 = matrix1[0].length;

        int rowsInMatrix2 = matrix2.length;
        int columnsInMatrix2 = matrix2[0].length;

        assert columnsInMatrix1 == rowsInMatrix2;
        int[][] product = new int[rowsInMatrix1][columnsInMatrix2];
        for (int rowIndex = 0; rowIndex < rowsInMatrix1; rowIndex++) {
            for (int colIndex = 0; colIndex < columnsInMatrix2; colIndex++) {
                int matrixEntry = 0;
                for (int intermediateIndex = 0; intermediateIndex < columnsInMatrix1; intermediateIndex++) {
                    matrixEntry += matrix1[rowIndex][intermediateIndex] * matrix2[intermediateIndex][colIndex];
                }
                product[rowIndex][colIndex] = matrixEntry;
            }
        }
        return product;
    }

    /**
     * 使用矩阵求幂技术计算斐波那契数
     *
     * @param n 斐波那契数的输入n, 输出第n个斐波那契数
     * @return 一个2 * 1的数组 {{F_n+1}, {F_n}}
     */
    public static int[][] fib(int n) {
        assert n >= 0;
        if (n == 0) {
            return Fibonacci.identityMatrix;
        } else {
            int[][] cachedResult = fib(n / 2);
            int[][] matrixExpResult = matrixMultiplication(cachedResult, cachedResult);
            if (n % 2 == 0) {
                return matrixExpResult;
            } else {
                return matrixMultiplication(Fibonacci.fibMatrix, matrixExpResult);
            }
        }
    }

    /**
     * 递归计算
     *
     * @param n
     * @return
     */
    public static int calByRecursion(int n) {
        assert n >= 0;
        if (n == 0 || n == 1) {
            return n;
        } else {
            return calByRecursion(n - 1) + calByRecursion(n - 2);
        }
    }

    /**
     * 非递归计算
     *
     * @param n
     * @return
     */
    public static int calByNonRecursion(int n) {
        assert n >= 0;
        int b = 1;
        int ans = 0;
        while (n-- > 0) {
            ans = ans + b;
            b = ans - b;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入 n = [0, 1, 2, 3, 4, 5.. ] 输出 [0, 1, 1, 2, 3, 5 ..]
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] result = matrixMultiplication(fib(n), baseFibNumbers);
//        System.out.println("Fib(" + n + ") = " + result[1][0]);
//        sc.close();
    }
}
