public class CheckAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }
        for (int num : count) {
            if (num != 0) {
                if (num != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        CheckAnagram obj = new CheckAnagram();
        System.out.println(obj.isAnagram("anagram", "nagaram"));
        System.out.println(obj.isAnagram("rat", "car"));
    }
}