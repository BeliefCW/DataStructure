package OneQuestionEveryDay.Package_07.字串判断;

/**
 * 该题目描述看似非常复杂，实际上问题难点并不是特别大。化繁为简，题目表达的意思就是一个字符串数组p
 * 中每一个元素是否是字符串s的子串，将字符串数组p中每个元素遍历判断的结果true或者false组成数组返回
 */
public class Substr {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/917a800d4de1423394827932f4725c68
     * 来源：牛客网
     * 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，请设计一个高效算法，对于p中的每一个较短字符串，
     * 判断其是否为s的子串。
     *
     * 给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，每个元素代表p中的对应字符串是否为s的子串。
     * 保证p中的串长度小于等于8，且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
     *
     * 测试样例：
     * ["a","b","c","d"],4,"abc"
     * 返回：[true,true,true,false]
     * @param p String数组p
     * @param n 大小n
     * @param s 母串
     * @return
     */
    public boolean[] chkSubStr(String[] p, int n, String s) {
         boolean[] array = new boolean[p.length];
         for(int i = 0; i < p.length; i++){
             array[i] = s.contains(p[i]);
         }
         return array;
    }

}
