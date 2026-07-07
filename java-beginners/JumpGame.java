public class JumpGame {

    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index cannot be reached
            if (i > farthest) {
                return false;
            }

            // Update farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);

            // Already can reach the end
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        JumpGame obj = new JumpGame();

        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(obj.canJump(nums));
    }
}