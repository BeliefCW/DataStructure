package algorithm.快排;

public class quickSort {
    public static void main(String[] args) {
         int[] arr = {2,5,3,4,8,6};
    }
    public static void quicksort(int[] arr,int L,int R){

        if(L < R){
           swap(arr, L + (int)(Math.random() * (R-L+1)),R);
           int[] P = partition(arr,L,R);
           quicksort(arr,L,P[0]-1);
           quicksort(arr,P[1]+1,R);
        }
    }

    public static int[] partition(int[] arr,int less,int more){
        int L = less-1;
        int R = more+1;
        int cur = L;
        while (cur < R){
            if(arr[L] < arr[R]){
                swap(arr,++L,cur++);
            }else if(arr[cur] > arr[R]){
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
