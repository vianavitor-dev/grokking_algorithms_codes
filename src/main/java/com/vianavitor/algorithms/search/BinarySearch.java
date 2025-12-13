package com.vianavitor.algorithms.search;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static int search(List<Integer> list, int value) {
        int left = 0;
        int right = list.size() - 1;

        int middle;

        while (left <= right) {
            middle = (left + right) / 2;

            if (list.get(middle) == value) {
                return middle;
            }
            else if (list.get(middle) > value) {
                right = middle - 1;
            } else if (list.get(middle) < value) {
                left = middle + 1;
            }
        }

        return -1;
    }
}
