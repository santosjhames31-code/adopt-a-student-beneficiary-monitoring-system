package Java.src.DSA;

import java.util.Scanner;

public class SearchingAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        
        int[] arrNum = new int[sc.nextInt()];
        System.out.println("Enter array elements:");
        for (int i = 0; i < arrNum.length; i++) {
            System.out.print("Element " + i + ": ");
            arrNum[i] = sc.nextInt();
        }

        System.out.print("Enter value to search: ");
        int val = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for (int i = 0; i < arrNum.length; i++) {
            if (arrNum[i] == val) {
                if (found) sb.append(", ");
                sb.append(i);
                found = true;
            }
        }

        if (found) System.out.println("Value " + val + " found at index: " + sb);
        else  System.out.println("Value " + val + " not found");

    }
}