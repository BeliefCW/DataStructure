package OneQuestionEveryDay.Package_07.神奇的口袋;

/**
 *问题：
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。John现在有n个想要得到的物品，
 * 每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，
 * John就可以得到这些物品。现在的问题是，John有多少种不同的选择物品的方式。
 *
 * 输入：
 * 输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值。
 * 比如：
 *
 * 4（4个不同的物品）
 *
 * 2 （以下是每种物品的重量）
 * 2
 * 2
 * 2
 *
 * 输出：
 * 输出不同的选择物品的方式的数目。 比如之前的输入的输出应该为6
 *
 */

import java.util.Scanner;

public class MagicPockets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //temp表示多少种商品
        int temp = scanner.nextInt();
        int[] data = new int[temp];
        for(int i = 0; i < data.length; i++){
            data[i] = scanner.nextInt();
        }
        //val表示容器体积
        int n = countNumb(data,temp,40);
        System.out.println(n);
    }
    public static int countNumb(int[] data,int temp,int val){
        //递归终止条件  1.容器体积等于0时
        if(val == 0){
            return 1;
        }else if (temp == 1) {
            //2.当只要一种商品时，若商品体积恰好等于容器剩下的体积
            if (val == data[temp - 1]) {
                return 1;
                //不等于时
            } else {
                return 0;
            }
            //3.当前商品体积大于容器体积
        }else if(val < data[temp-1]){
            return countNumb(data,temp-1,val);
        }else{
            return countNumb(data,temp-1,val)+countNumb(data,temp-1,val-data[temp-1]);
        }
    }
}
