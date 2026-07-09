import java.util.Arrays;
public class HIndex {
    public int hIndex(int[] citations) {
       Arrays.sort(citations);
       int n = citations.length;
       for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
   }
   public static void main(String[] args) {
       HIndex obj = new HIndex();
       int[] citations1 = {3, 0, 6, 1, 5};
       int[] citations2 = {1, 3, 1};
       System.out.println("Example 1 Output: " + obj.hIndex(citations1));
       System.out.println("Example 2 Output: " + obj.hIndex(citations2));
    }
}
    

