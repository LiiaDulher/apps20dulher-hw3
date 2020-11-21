package ua.edu.ucu.smartarr;

import org.junit.Test;
import ua.edu.ucu.functions.MyPredicate;

import static org.junit.Assert.assertEquals;

public class DistinctDecoratorTest {
    @Test
    public void onlyOperationDescriptionTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray arr = new BaseArray(integers);
        arr = new DistinctDecorator(arr);
        assertEquals(arr.operationDescription(), "DistinctDecorator: removes all duplicates; ");
    }

    @Test
    public void operationDescriptionTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray arr = new BaseArray(integers);
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };
        arr = new FilterDecorator(arr, pr);
        arr = new DistinctDecorator(arr);
        assertEquals(arr.operationDescription(), "DistinctDecorator: removes all duplicates; ");
    }
}
