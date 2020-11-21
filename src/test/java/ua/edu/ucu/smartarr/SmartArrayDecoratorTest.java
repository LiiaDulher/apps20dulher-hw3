package ua.edu.ucu.smartarr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmartArrayDecoratorTest {
    @Test
    public void onlyOperationDescriptionTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray arr = new BaseArray(integers);
        arr = new DistinctDecorator(arr);
        assertEquals(arr.operationDescription(), "DistinctDecorator: removes all duplicates; ");
    }
}
