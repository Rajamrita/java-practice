public class FindFirstOccurrence {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    FindFirstOccurrence obj = new FindFirstOccurrence();
    String haystack = "sadbutsad";
    String needle = "sad";
    System.out.println(obj.strStr(haystack, needle));
    }  
}
