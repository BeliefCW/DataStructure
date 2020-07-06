package 剑指offer.数组中重复的数字;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 *
 * 要求时间复杂度为o(n),空间复杂度为o(1)
 */

//在这种数组为元素在[0,n-1]范围内的问题，可以将值为 i 的元素调整到第 i 的位置上进行求解
public class Main {

    public boolean duplicate(int[] nums,int length,int[] duplication){
        if(nums == null || length < 0){
            return false;
        }
        for (int i = 0; i < length; i++){
            while (nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    duplication[0] = nums[i];
                    return true;
                }
            }
            Swap(nums,nums[i],i);
        }
        return false;

    }

    private void Swap(int[] nums,int i,int j) {
         int temp = i;
         i = j;
         j = temp;
    }
}
