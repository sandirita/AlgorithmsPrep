import java.util.Hashtable;

public class Optimization {

    public static void main(String[] args) {
        String a = "cde";
        String b = "dcf";

        System.out.println(makeAnagram(a, b));
    }

    public static int makeAnagram(String a, String b) {
        Hashtable<Character, Integer> frequenciesA = new Hashtable<>();
        Hashtable<Character, Integer> frequenciesB = new Hashtable<>();

        for(char c : a.toCharArray()) {
            Integer i = frequenciesA.get(c);
            if( i == null) {
                frequenciesA.put(c, 1);
            } else {
                frequenciesA.put(c, i+1);
            }
        }
        for(char d : b.toCharArray()) {
            Integer i = frequenciesB.get(d);
            if(i == null) {
                frequenciesB.put(d, 1);
            } else {
                frequenciesB.put(d, i+1);
            }
        }
        int counter = 0;
        for(char character = 'a'; character <= 'z'; character++) {
            int odd = Math.abs(frequenciesA.getOrDefault(character, 0) - frequenciesB.getOrDefault(character, 0));

            counter += odd;
        }
        return counter;
    }
}