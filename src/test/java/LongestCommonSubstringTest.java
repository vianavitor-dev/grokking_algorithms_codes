import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.vianavitor.algorithms.dp.LongestCommonSubstring;

public class LongestCommonSubstringTest {
    
    @ParameterizedTest()
    @CsvSource({
        "blue, clues, 3",
        "hish, fish, 3",
        "forth, fish, 1",
        "fosh, fish, 2"
    })
    public void testAlgorithm(String str1, String str2, int expectedResult) {
        System.out.println("NEW TEST: " + str1 + ", " + str2);
        assertEquals(expectedResult, LongestCommonSubstring.execute(str1, str2));
    }
}
