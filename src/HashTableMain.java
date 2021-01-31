import Sorting.Node;

import java.util.Hashtable;

public class HashTableMain {

    public static int[][] endResult;
    public static int j = 0;
        public static void main(String[] args) {
            String[] magazine = {"give", "me", "one", "grand", "today", "night"};
            String[] note = {"give", "one", "grand", "today"};

            checkMagazine(magazine, note);

            int[] cost = {1, 4, 5, 3, 2};
            int money = 5;

            whatFlavorsOpt(cost, money);

            int[][] indexes = {{2, 3}, {-1, -1}, {-1, -1}};
            int[][] indexes2 = {{2, 3},
                    {4, 5},
                    {6, -1},
                    {-1, 7},
                    {8, 9},
                    {10, 11},
                    {12, 13},
                    {-1, 14},
                    {-1, -1},
                    {15, -1},
                    {16, 17},
                    {-1, -1},
                    {-1, -1},
                    {-1, -1},
                    {-1, -1},
                    {-1, -1},
                    {-1, -1}};
            int[] queries = {1, 1};
            int[] queries2 = {2, 3};
            int[][] indexes3 = {{2, 3},
                    {4, -1},
                    {5, -1},
                    {6, -1},
                    {7, 8},
                    {-1, 9},
                    {-1, -1},
                    {10, 11},
                    {-1, -1},
                    {-1, -1},
                    {-1, -1}};
            int[] queries3 = {2, 4};

            int[][] indexes4 = {{-1,2},
                    {3,4},
                    {5,6},
                    {7,-1},
                    {8,-1},
                    {9,10},
                    {11,12},
                    {-1,13},
                    {14,15},
                    {-1,-1},
                    {-1,16},
                    {17,-1},
                    {18,19},
                    {20,21},
                    {22,23},
                    {-1,-1},
                    {24,25},
                    {26,-1},
                    {27,28},
                    {29,30},
                    {31,-1},
                    {32,33},
                    {34,35},
                    {36,37},
                    {38,39},
                    {-1,40},
                    {-1,41},
                    {-1,42},
                    {-1,-1},
                    {43,44},
                    {-1,-1},
                    {45,46},
                    {47,48},
                    {-1,-1},
                    {-1,49},
                    {-1,50},
                    {51,52},
                    {-1,53},
                    {54,55},
                    {-1,56},
                    {57,-1},
                    {-1,58},
                    {59,-1},
                    {60,61},
                    {-1,62},
                    {-1,63},
                    {-1,-1},
                    {-1,64},
                    {65,-1},
                    {66,-1},
                    {-1,67},
                    {-1,-1},
                    {-1,68},
                    {-1,69},
                    {70,-1},
                    {71,-1},
                    {72,73},
                    {74,75},
                    {-1,-1},
                    {76,-1},
                    {77,-1},
                    {-1,-1},
                    {78,-1},
                    {-1,-1},
                    {79,80},
                    {81,82},
                    {-1,83},
                    {84,-1},
                    {85,-1},
                    {86,-1},
                    {-1,87},
                    {-1,-1},
                    {-1,-1},
                    {-1,88},
                    {-1,-1},
                    {89,90},
                    {-1,-1},
                    {91,-1},
                    {-1,92},
                    {93,-1},
                    {94,95},
                    {-1,-1},
                    {96,97},
                    {98,-1},
                    {-1,99},
                    {100,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1},
                    {-1,-1}
            };
            int[] queries4 = {8,6,2,3,5,7,7,5,7,1,5,6,2,8,4,6,8,12,10,6,12,11,12,8,1,7,9,3,8,7,2,7,8,3,8,9,7,9,9,8,11,10,4,12,4};

            int[][] result = swapNodes(indexes4, queries4);

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

    public static void whatFlavors(int[] cost, int money){
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] < money) {
                int numb = money - cost[i];
                for (int j = i+1; j < cost.length; j++) {
                    if (cost[j] == numb) {
                        System.out.println((i+1) + " " + (j+1));
                        return;
                    }
                } //TODO Ne legyen egybeagyazott for loop
                //TODO hasznalj hashtable-t
            }
        }
    }

    public static void whatFlavorsOpt(int[] cost, int money) {
        Hashtable<Integer, Integer> flavorsAndRemainders = new Hashtable<>();
        for (int i = 0; i < cost.length; i++) {
            int num = money - cost[i];
            Integer numIndex = flavorsAndRemainders.get(num);
            if (numIndex != null) {
                System.out.println((numIndex+1)+ " " + (i+1));
                break;
            }
            flavorsAndRemainders.put(cost[i], i);
        }
    }
    public static int indexOf(int[] arr, int l) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == l){
                return i;
            }
        }
        return -1;
    }

    public static Node findNodeById(Node root, int id){
        if(root == null) {
            return null;
        }
        if(root.id == id) {
            return root;
        }
        Node insideLeft = findNodeById(root.leftNode, id);
        if (insideLeft == null) {
            return findNodeById(root.rightNode, id);
        } else {
            return insideLeft;
        }
    }

    public static int[][] swapNodes(int[][] indexes, int[] queries) {
        endResult = new int[queries.length+2][indexes.length+2];

        Node root = new Node();
        root.id = 1;
        root.level = 1;


        if(indexes[0][0] != -1) {
            root.leftNode = new Node();
            root.leftNode.id = indexes[0][0];
            root.leftNode.level = 2;
        }
        if(indexes[0][1] != -1) {
            root.rightNode = new Node();
            root.rightNode.id = indexes[0][1];
            root.rightNode.level = 2;
        }
        for (int i = 0; i < indexes.length; i++) {
            int indexI = i+1;
            Node node = findNodeById(root, indexI);
            if (indexes[i][0] != -1) {
                node.leftNode = new Node();
                node.leftNode.id = indexes[i][0];
                node.leftNode.level = node.level + 1;
            }
            if (indexes[i][1] != -1) {
                node.rightNode = new Node();
                node.rightNode.id = indexes[i][1];
                node.rightNode.level = node.level + 1;

            }
        }

        for (int i = 0; i < queries.length; i++) {
            int k = queries[i];
            swapNodes2(root, k);
            System.out.println();
            j = 0;
            recursivePrint(root, i);
        }
        return endResult;
    }
    public static void swapNodes2(Node n, int k){
        if(n == null){
            return;
        }
        if(n.level % k== 0){
            Node swapRoot = n.leftNode;
            n.leftNode = n.rightNode;
            n.rightNode = swapRoot;
        }
            swapNodes2(n.leftNode, k);
            swapNodes2(n.rightNode, k);
    }

    public static void printTree(int[][] result){
        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
               System.out.print((String.valueOf(result[resultRowItr][resultColumnItr])));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    System.out.print(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                System.out.print("\n");
            }
        }

        System.out.print("\n");

    }

    public static void recursivePrint(Node node, int i) {
        if(node == null) {
            return;
        }
        recursivePrint(node.leftNode, i);
        endResult[i][j] = node.id;
        ++j;
        recursivePrint(node.rightNode, i);
    }

}