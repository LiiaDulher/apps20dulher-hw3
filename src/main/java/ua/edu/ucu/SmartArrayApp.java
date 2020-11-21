package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;

public class SmartArrayApp {

    private static final double GRADE = 4.0;

    public static int[]
            filterPositiveIntegersSortAndMultiplyByTwo(Object[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object objA, Object objB) {
                return ((Integer) objA) - ((Integer) objB);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        //return Arrays.copyOf(result, result.length, int[].class);
        int[] res = new int[result.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) result[i];
        }
        return res;
    }

    public static String[]
    findDistinctStudentNamesFromSecondYearWithGPAgtFourAndOrderedBySurname(
                    Student[] students) {
        MyPredicate prY = new MyPredicate() {
            @Override
            public boolean test(Object s) {
                Student st = (Student) s;
                return st.getYear() == 2;
            }
        };

        MyPredicate prG = new MyPredicate() {
            @Override
            public boolean test(Object s) {
                Student st = (Student) s;
                return st.getGPA() >= GRADE;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object objA, Object objB) {
                Student stA = (Student) objA;
                Student stB = (Student) objB;
                return stA.getSurname().compareTo(stB.getSurname());
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object s) {
                Student st = (Student) s;
                return st.getSurname() + " " + st.getName();
            }
        };

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);

        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new DistinctDecorator(studentSmartArray);
        studentSmartArray = new FilterDecorator(studentSmartArray, prY);
        studentSmartArray = new FilterDecorator(studentSmartArray, prG);
        studentSmartArray = new SortDecorator(studentSmartArray, cmp);
        studentSmartArray = new MapDecorator(studentSmartArray, func);
        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
