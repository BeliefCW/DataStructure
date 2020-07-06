package 剑指offer.替换空格;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Main {
    public String replaceSpace(StringBuffer str){
        int oldLength = str.length() - 1;
        for(int i = 0; i <= oldLength; i++){
            if(str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //计算出字符串替换完空格后的长度
        int newLength = str.length() - 1;
        while (oldLength >= 0 && newLength > oldLength){
            char c = str.charAt(oldLength--);
            if(c == ' '){
                str.setCharAt(newLength--,'0');
                str.setCharAt(newLength--,'2');
                str.setCharAt(newLength--,'%');
            }else {
                str.setCharAt(newLength--,c);
            }
        }
        return str.toString();
    }
}
