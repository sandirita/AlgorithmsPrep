

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] input = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(input));
        System.out.println(sockMerchant2(input));

        int steps = 8;
        String path = "UDDDUDUU";
        System.out.println(countingValleys(steps, path));

        int[]c = {0, 1, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(c));

        String s = "aba";
        int n = 10;
        System.out.println(repeatedString(s, n));
    }

    public static int sockMerchant(int[] input) {
        int count = 0;
        ArrayList<Integer> inputList = new ArrayList(Arrays.asList());

        for (int i : input) {
            inputList.add(i);
        }
        int indexComparable = 0;
        while (indexComparable < inputList.size()) {
            int comparable = inputList.get(indexComparable);
            int i = 1;
            while (i < inputList.size()) {
                if (indexComparable != i && comparable == inputList.get(i)) {
                    assert i > indexComparable;
                    inputList.remove(i);
                    inputList.remove(indexComparable);
                    count++;
                    indexComparable = 0;
                    break;
                } else {
                    i++;
                }
            }
            indexComparable++;
        }
        return count;
    }

    public static int sockMerchant2(int[] input) {
        HashMap<Integer, Integer> hashList = new HashMap<>();
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            Integer nrOfColors = hashList.get(input[i]);
            if (nrOfColors == null) {
                hashList.put(input[i], 1);
            } else if (nrOfColors % 2 != 0) {
                hashList.put(input[i], nrOfColors + 1);
                count++;
            } else {
                hashList.put(input[i], nrOfColors + 1);
            }
        }
        return count;
    }

    public static int countingValleys(int s, String p) {
        int hikersAlt = 0;
        int counter = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'U') {
                ++hikersAlt;
                if (hikersAlt == 0) {
                    ++counter;
                }
            } else {
                --hikersAlt;
            }
        }
        return counter;
    }
// int[]c = {0, 1, 0, 0, 0, 1, 0}
    public static int jumpingOnClouds(int[] c) {
        int counter = 0;
        int step = 0;
        while (step < c.length - 1){
            if (step + 1 == c.length - 1) {
                ++counter;
                break;
            }
            else if (c[step+2] == 0) {
                ++counter;
                step += 2;
            } else {
                assert c[step+1] == 0;
                ++counter;
                ++step;
            }
        }
        return counter;
    }
// String s = "aba"; n = 10;
    public static long repeatedString(String s, long n) {
        long nrOfAs= 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                ++nrOfAs;
            }
        }
        long multiplier = n / s.length();
        long remainder = n % s.length();
        long plus = 0;

        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                ++plus;
            }
        }
        return (nrOfAs * multiplier) + plus;
    }
}


