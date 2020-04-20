package algorithm.快排;

public class NetherlandsFalg {
    public static int[] partition(int[] arr,int less,int more,int num){
        int L = less-1;
        int R = more+1;
        int cur = L;
        while (cur < R){
            if(arr[L] < num){
                swap(arr,++L,cur++);
            }else if(arr[cur] > num){
                swap(arr,--R,cur);
            }else { // == num
                cur++;
            }
        }
        return new int[]{L+1,R-1};
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
