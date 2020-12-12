package Batz.二维数组.二维数组中的查找;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Main {
    public boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix.length == 0)
            return false;
        //行
        int M = matrix.length;
        //列
        int N = matrix[0].length;
        int r = 0, l = N-1;
        //从右上角开始遍历
        while (r < M && l > 0){
           if(target == matrix[r][l]){
               return true;
           }
           if(target < matrix[r][l]){
               l--;
           }else {
               r++;
           }
        }
        return false;
    }
}
