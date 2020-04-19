package OneQuestionEveryDay.Package_01;

/**
 * A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
 * A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 * 输入描述:
 * 输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。
 * 范围均在-30到30之间(闭区间)。
 * 输出描述:
 * 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。
 * 如果不存在这样的整数A，B，C，则输出No
 * 输入例子:
 * 1 -2 3 4
 * 输出例子:
 * 2 1 3
 */

import java.util.Scanner;

public class Candycalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
             int[] data = new int[4];
             data[0] = scanner.nextInt();
             data[1] = scanner.nextInt();
             data[2] = scanner.nextInt();
             data[3] = scanner.nextInt();
             if((data[0]+data[2]) % 2 != 0 || (data[1] + data[3]) % 2 != 0 || (data[0]+data[2]) <0 ||
                     (data[1]+data[3])<0){
                 System.out.println("NO");
             }else {
                 int A = (data[0] + data[2])/2;
                 int B = (data[1] + data[3])/2;
                 int D = data[1] + data[2];
                 int C = 2*B + A - D;
                 System.out.print(A);
                 System.out.print(" ");
                 System.out.print(B);
                 System.out.print(" ");
                 System.out.print(C);
                 System.out.print(" ");
             }

        }
    }
}
