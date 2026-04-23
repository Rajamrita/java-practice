public class CountVowels {
    public static void main(String[] args) {

        String str = "hello world";
        int count = 0;

        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count++;
            }
        }

        System.out.println("Vowels: " + count);
    }
}
