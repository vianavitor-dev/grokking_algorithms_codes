import com.vianavitor.algorithms.recursion.Box;
import com.vianavitor.algorithms.recursion.BoxAnalyser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class BoxAnalyserTest {
    @Test
    public void testisThereAKeyInside() {
        Box b1 = new Box(true, null, "B1");
        Box b2 = new Box(false, null, "B2");

        Stack<Box> stack1 = new Stack<>();
        stack1.push(b1);
        stack1.push(b2);

        Box b3 = new Box(false, stack1, "B3");

        Box b4 = new Box(false, null, "B4");

        Stack<Box> stack2 = new Stack<>();
        stack2.push(b4);

        Box b5 = new Box(false, stack2, "B5");

        Stack<Box> stack3 = new Stack<>();
        stack3.push(b3);
        stack3.push(b5);

        Box b6 = new Box(false, stack3, "B6");

        boolean result = BoxAnalyser.isThereAKeyInside(b6, new Stack<>());
        boolean expected = true;

        Assertions.assertEquals(expected, result, "Unexpected outcome ");
    }
}
