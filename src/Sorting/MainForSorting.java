package Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainForSorting {
    public static void main (String[] args) throws IOException {
       /* int [] input = {1, 12, 5, 111, 200, 1000, 10};
        System.out.println(maximumToys(input, 50)); */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static int maximumToys(int []prices, int k) {
        int b = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                if(prices[i] > prices[j]){
                    int a = prices[i];
                    prices[i] = prices[j];
                    prices[j] = a;
                }

            }
            if(k - prices[i] > 0) {
                k -= prices[i];
                b++;
            } else {
                return b;
            }
        }
        return b;
    }
}
