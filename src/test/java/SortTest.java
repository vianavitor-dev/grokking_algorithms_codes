import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.vianavitor.algorithms.sort.QuickSort;

public class SortTest {
    @Test
    @Tag("Sort")
    @DisplayName("Quicksort - Array ")
    public void QuickSortTest() {
        int[] unordered = {5, 3, 2, 1, 4, 7, 0};
        int[] ordered = QuickSort.sort(unordered);

        for (int n : ordered) {
            System.out.print(n + "\t");
        }

        int[] expected = {0, 1, 2, 3, 4, 5, 7};
        
        Assertions.assertArrayEquals(expected, ordered);
    }
}
