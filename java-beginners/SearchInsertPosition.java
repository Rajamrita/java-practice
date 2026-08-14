public class SearchInsertPosition {

    // Binary search method to find target or insertion index
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    // Main method to test locally in VS Code
    public static void main(String[] args) {
        SearchInsertPosition sol = new SearchInsertPosition();

        int[] nums1 = {1, 3, 5, 6};
        System.out.println("Output 1: " + sol.searchInsert(nums1, 5)); // Expected: 2
        System.out.println("Output 2: " + sol.searchInsert(nums1, 2)); // Expected: 1
        System.out.println("Output 3: " + sol.searchInsert(nums1, 7)); // Expected: 4
    }
}