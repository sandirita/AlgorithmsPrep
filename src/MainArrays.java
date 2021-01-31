import java.util.Arrays;

public class MainArrays {
    public static void main(String[] args) {
        int arr[][] = new int[6][6];

        arr[0][0] = -9;
        arr[0][1] = -9;
        arr[0][2] = -9;
        arr[0][3] = 1;
        arr[0][4] = 1;
        arr[0][5] = 1;

        arr[1][0] = 0;
        arr[1][1] = 9;
        arr[1][2] = 0;
        arr[1][3] = 4;
        arr[1][4] = 3;
        arr[1][5] = 2;

        arr[2][0] = -9;
        arr[2][1] = -9;
        arr[2][2] = -9;
        arr[2][3] = 1;
        arr[2][4] = 2;
        arr[2][5] = 3;

        arr[3][0] = 0;
        arr[3][1] = 0;
        arr[3][2] = 8;
        arr[3][3] = 6;
        arr[3][4] = 6;
        arr[3][5] = 0;

        arr[4][0] = 0;
        arr[4][1] = 0;
        arr[4][2] = 0;
        arr[4][3] = -2;
        arr[4][4] = 0;
        arr[4][5] = 0;

        arr[5][0] = 0;
        arr[5][1] = 0;
        arr[5][2] = 1;
        arr[5][3] = 2;
        arr[5][4] = 4;
        arr[5][5] = 0;

        System.out.println(hourglassSum(arr));

        int[] a = new int[]{1, 2, 3, 4, 5};
        ;
        int d = 4;

        System.out.println(rotLeft(d, a));

        int[] input = new int[]{4, 3, 1, 2};
        // 1,3,4,2
        // 1,2,4,3

        System.out.println(minimumSwaps(input));
    }

    public static int hourglassSum(int[][] arr) {
        int rowOffset = 0;
        int highestSum = Integer.MIN_VALUE;
        int sum = 0;
        while (rowOffset < 4) {
            int columnOffset = 0;
            while (columnOffset < 4) {
                sum = sumOfOneHourglass(arr, rowOffset, columnOffset);
                if (sum > highestSum) {
                    highestSum = sum;
                }
                ++columnOffset;
            }
            ++rowOffset;
        }

        return highestSum;
    }

    public static int sumOfOneHourglass(int[][] arr, int row, int column) {
        int sum = arr[row][column] + arr[row][column + 1] + arr[row][column + 2] + arr[row + 1][column + 1] + arr[row + 2][column] + arr[row + 2][column + 1] + arr[row + 2][column + 2];
        return sum;
    }

    public static int[] rotLeft(int d, int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[(i + d) % a.length]; //use modulus to rotate index
        }
        return b;
    }

    public static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int position = 0; position < arr.length; position++) {
            if (arr[position] != position + 1) {
                int index = indexOf(arr, position+1);
                swap(arr, position, index);
                ++count;
            }
        }
        return count;
    }

    public static int indexOf(int[] arr, int l) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == l){
                return i;
            }
        }
        assert false;
        return -1;
    }

    public static void swap(int[]a, int indexB, int indexC) {
        int savedVar = a[indexB];
        a[indexB] = a[indexC];
        a[indexC] = savedVar;
    }

}
