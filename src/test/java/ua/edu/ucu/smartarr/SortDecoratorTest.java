package ua.edu.ucu.smartarr;

import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;

import static org.junit.Assert.assertEquals;

public class SortDecoratorTest {
    @Test
    public void onlyOperationDescriptionTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray arr = new BaseArray(integers);
        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object objA, Object objB) {
                return ((Integer) objA) - ((Integer) objB);
            }
        };
        arr = new SortDecorator(arr, cmp);
        assertEquals(arr.operationDescription(), "SortDecorator: sorts elements using given comparator; ");
    }

    @Test
    public void operationDescriptionTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray arr = new BaseArray(integers);
        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object objA, Object objB) {
                return ((Integer) objA) - ((Integer) objB);
            }
        };
        arr = new DistinctDecorator(arr);
        arr = new SortDecorator(arr, cmp);
        assertEquals(arr.operationDescription(), "SortDecorator: sorts elements using given comparator; ");
    }
}
