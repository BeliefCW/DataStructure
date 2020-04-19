package OneQuestionEveryDay.Package_01;
/**
 * 牛客网在线编程：n个数中出现次数大于等于n/2的数
 * 题目描述：
 *
 * 输入n个整数，输出出现次数大于等于数组长度一半的数。
 * 输入描述:
 * 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
 * 输出描述:
 * 输出出现次数大于等于n/2的数。
 * 示例1
 * 输入
 *
 * 3 9 3 2 5 6 7 3 2 3 3 3
 * 输出
 *
 * 3
 *
 * 思路：
 *
 * 1.每次输入，使用数组a[n]记录n出现的次数，num记录总数。然后判断a[i]是否大于等于num/2。是的话返回i即可
 * 2.保存两个值，当接下来出现的下一个数与前一个数相同时，计数加一，否则减一。当计数为0时，保存下一个数字，并把计数记为1.由于
 * 要找的数出现的次数比其他数的和还要多，所有要找的数就是最后一次把数设为1的那个数字。
 */

import java.util.Scanner;

public class MathDataCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int[] data = new int[100];
        int n = 0;
        while (scanner.hasNextInt()){
            int val = scanner.nextInt();
            data[val]++;
            n++;
        }
        for(int j = 0; j < n; j++){
            if(data[j] >= (n/2)){
                System.out.println(j);
            }
        }
    }
}
