import java.util.Hashtable;

public class HashTableMain {

    public static void main(String[] args) {
        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand", "today"};

        checkMagazine(magazine, note);
    }

    public static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> magazineWords = new Hashtable<>();
        for (String a : magazine) {
            Integer i = magazineWords.get(a);
            if (i == null) {
                magazineWords.put(a, 1);
            } else {
                magazineWords.put(a, i + 1);
            }
        }
        boolean answer = false;
        for (String b : note) {
            Integer i = magazineWords.get(b);
            if (i == null) {
                answer = false;
                break;
            } else if (i == 0) {
                answer = false;
                break;
            } else {
                magazineWords.put(b, i - 1);
                answer = true;
            }
        }
        if (answer) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}