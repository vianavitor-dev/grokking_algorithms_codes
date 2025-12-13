import com.vianavitor.algorithms.search.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTest {

    @Test
    @Tag("Search")
    @DisplayName("Binary Search - ArrayList ")
    public void testBinarySearch() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 8, 12, 20, 26, 70));

        int index = BinarySearch.search(list, 26);

        if (index == -1) {
            System.out.println("Not found number");
        }

        assert(index == 6);
    }

    @Test
    @Tag("Search")
    @DisplayName("Dummy Search - ArrayList ")
    public void testDummySearch() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 8, 12, 20, 26, 70));
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 26) {
                index = i;
            }
        }

        if (index == -1) {
            System.err.println("Not found number");
        }

        assert(index == 6);
    }
}
