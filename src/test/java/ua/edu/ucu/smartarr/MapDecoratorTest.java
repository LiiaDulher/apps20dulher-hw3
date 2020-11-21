package ua.edu.ucu.smartarr;

import org.junit.Test;
import ua.edu.ucu.functions.MyFunction;

import static org.junit.Assert.assertEquals;

public class MapDecoratorTest {
    @Test
    public void onlyOperationDescriptionTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray arr = new BaseArray(integers);
        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };
        arr = new MapDecorator(arr, func);
        assertEquals(arr.operationDescription(), "MapDecorator: applies given function to each element; ");
    }

    @Test
    public void operationDescriptionTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray arr = new BaseArray(integers);
        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };
        arr = new DistinctDecorator(arr);
        arr = new MapDecorator(arr, func);
        assertEquals(arr.operationDescription(), "MapDecorator: applies given function to each element; ");
    }

    @Test
    public void sizeTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray arr = new BaseArray(integers);
        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };
        arr = new MapDecorator(arr, func);
        assertEquals(arr.size(), 6);
    }
}
