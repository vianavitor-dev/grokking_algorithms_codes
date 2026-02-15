import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.vianavitor.algorithms.dp.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {
    
    @ParameterizedTest()
    @CsvSource({
        "blue, clues, 3",
        "hish, fish, 3",
        "forth, fish, 2",
        "fosh, fish, 3"
    })
    public void testAlgorithm(String str1, String str2, int expectedResult) {
        System.out.println("NEW TEST: " + str1 + ", " + str2);
        assertEquals(expectedResult, LongestCommonSubsequence.execute(str1, str2));
    }
}
