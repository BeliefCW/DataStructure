package OneQuestionEveryDay.Package_07.最难的问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char[] chars = new char[string.length()];
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if('c' >= 65 && 'c' <= 90 ){
                 if(90 - 'c' < 5){
                     c = 'c' -21;
                 }
                 c = 'c' + '5';
            }
        }
    }
}
