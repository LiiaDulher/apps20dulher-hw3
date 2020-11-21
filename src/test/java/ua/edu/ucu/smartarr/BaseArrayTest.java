package ua.edu.ucu.smartarr;

import org.junit.Test;
import ua.edu.ucu.smartarr.BaseArray;

import static org.junit.Assert.*;

public class BaseArrayTest {
    @Test
    public void equalsNullTest() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        BaseArray arr = new BaseArray(integers);
        assertEquals(arr.operationDescription(), null);
    }
}
