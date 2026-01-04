package com.vianavitor.algorithms.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {
    public static int[] sort(int[] array) {
        // base-case: if there's only one element or it's empty
        if (array.length < 2) {
            return array;
        }

        // recursive-case: based on the pivot make 2 subarrays (lesser and greater than pivot),
        // then call itself as: quicksort(lesser) + pivot + quicksort(greater)
        int pivot = array[0];
        int[] arrayWithoutPivot = Arrays.copyOfRange(array, 1, array.length);

        int[] lesser = Arrays.stream(arrayWithoutPivot).filter((value) -> value < pivot).toArray();
        int[] greater = Arrays.stream(arrayWithoutPivot).filter((value) -> value > pivot).toArray();

        int[] orderedLesser = QuickSort.sort(lesser);
        int[] orderedGreater = QuickSort.sort(greater);

        return IntStream.concat(
            Arrays.stream(orderedLesser), 
            IntStream.concat(
                IntStream.of(pivot), 
                Arrays.stream(orderedGreater)
            )
        ).toArray();
    } 
}
