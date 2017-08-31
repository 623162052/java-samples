package javase.collections.list;

import java.util.Arrays;

/**
 * Êý×é¸´ÖÆ¡¢ÉýÐò
 */
public class ArraySort {
    public static void main(String[] args) {
        int arrayOne[] = {3, 5, 1, 7, 8, 11, 22};
        int arrayTwo[] = new int[14];
        System.arraycopy(arrayOne, 0, arrayTwo, 0, 7);
        Arrays.sort(arrayTwo); //ÅÅÐò
        for (int i = 0; i < arrayTwo.length; i++) {
            System.out.println("arrayThree[" + i + "]=" + arrayTwo[i]);
        }
    }
}
