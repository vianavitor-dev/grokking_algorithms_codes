package com.vianavitor.algorithms.recursion;

import java.util.Stack;

/*
    This Java class aims to apply a simple example recorded in the book,
    on page 67, the algorithm to verify if a box indeed has a key inside.

    As well as the algorithm of the book, this one are going to be applied
    using the recursion.
 */
public class BoxAnalyser {
    public static boolean isThereAKeyInside(Box currentBox, Stack<Box> analyseAfter) {
        System.out.println("#" + currentBox.getName());

        // base-case: finish the recursion after it finds the key
        if (currentBox.hasKey()) {
            System.out.println(" - has the key");
            return true;
        }

        // 1° recursion-case: if there are any boxes inside the current box
        if (currentBox.hasAnyBoxInside()) {
            System.out.println("- has boxes inside");

            // push all the boxes that were found inside the current box into the "analyseAfter" stack
            for (Box b : currentBox.getAllBoxesInside()) {
                System.out.println(" -> " + b.getName());
                analyseAfter.push(b);
            }

            // use the first element saved in the stack due to the possibility of having more elements inside
            currentBox = analyseAfter.pop();
            return isThereAKeyInside(currentBox, analyseAfter);
        }

        // 2° recursion-case: if the "analyseAfter" is empty (neither the key nor the boxes were found)
        if (analyseAfter.empty()) {
            System.out.println("- empty - not found key");
            return false;
        }

        // 3° recursion-case: if there is something to analyse in the list
        System.out.println("- empty");
        System.out.println("- next - using list");
        return isThereAKeyInside(analyseAfter.pop(), analyseAfter);
    }
}
