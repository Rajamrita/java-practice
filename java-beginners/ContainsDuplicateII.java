import java.util.HashMap;
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicateII obj = new ContainsDuplicateII();
        int[] nums = {1, 2, 3, 1};
        int K = 3;
        System.out.println(obj.containsNearbyDuplicate(nums, K));
    }
}
