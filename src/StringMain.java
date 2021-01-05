public class StringMain {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";

        System.out.println(makeAnagram(a, b));

        String q = "AAABB";
        System.out.println(alternatingCharacters(q));
    }

    public static int makeAnagram(String a, String b) {
        String newA = a;
        String newB = b;
        int i = 0;
        while (i < a.length()) {
            char charInA = a.charAt(i);
            int indexInB = b.indexOf(String.valueOf(charInA));

            if (indexInB >= 0) {
                newA = a.substring(0, i);
                newA += a.substring(i +1);
                newB = b.substring(0, indexInB);
                newB += b.substring(indexInB +1);

                a = newA;
                b = newB;
            } else {
                ++i;
            }
        }

        return newA.length() + newB.length();
    }

    public static int alternatingCharacters(String s) {
        int counter = 0;
        char comparable = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if(comparable == s.charAt(i)){
                ++counter;
            }
            comparable = s.charAt(i);
        }
        return counter;
    }


}
