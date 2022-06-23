package Java.dz2;

import java.util.Arrays;
public class sort_merge {
    public static void main(String[] args) {
        int[] array1 = { 8, 0, -3, 5, 6, 9, 8, -4, 2, -99, 43 };
        int[] result = mergesort(array1);
        System.out.println(Arrays.toString(result));
    }
 
    public static int[] mergesort(int[] array1) {
        int[] a = Arrays.copyOf(array1, array1.length);//массив для сортировки
        int[] b = new int[array1.length];
        int[] result = mergesortInner(a, b, 0, array1.length);
        //startIndex Начальный индекс в a для сортировки.
        //endIndex Конечный индекс в a для сортировки.
        return result;
    }  
        
    public static int[] mergesortInner(int[] a, int[] b,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return a;
        }
        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(a, b, startIndex, middle);
        int[] sorted2 = mergesortInner(a, b, middle, endIndex);
        
        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == a ? b : a;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}


