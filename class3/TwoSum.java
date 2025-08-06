import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[] { 1,2,1,2,1};
        System.out.println("Brute Force : " + bruteForce(arr, 3));
        System.out.println("Better : " + ans(arr, 3));
        System.out.println("Optimal  : " + optimal(arr, 3));
    }

    static int bruteForce(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    static int better(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                int lc = 0;
                int rc = 0;
                int l = nums[left];
                int r = nums[right];
                int n = 0;
                if(l==r){
                    int total = right - left + 1;
                    n = (total * (total-1))/2;
                }
                while (left <= right && nums[left] == l) {
                    lc++;
                    left++;
                }
                while (left <= right && nums[right] == r) {
                    rc++;
                    right--;
                }
                count += lc * rc + n;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    static int optimal(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    static int ans(int[] num , int target) throws InterruptedException{
        Thread.sleep(5000);
        return optimal(num, target);
    }
}