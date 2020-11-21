package ua.edu.ucu;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void equalsNullTest() {
        Student st1 = new Student("Ivar", "Grimstad", 3.9, 2);
        Student st2 = null;
        assertFalse(st1.equals(st2));
    }

    @Test
    public void equalsOtherClassTest() {
        Student st1 = new Student("Ivar", "Grimstad", 3.9, 2);
        Integer st2 = 2;
        assertFalse(st1.equals(st2));
    }
}
