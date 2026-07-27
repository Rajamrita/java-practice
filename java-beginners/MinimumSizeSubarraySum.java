public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0; // No valid subarray found
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(obj.minSubArrayLen(target, nums)); // Output: 2
    } 
}
