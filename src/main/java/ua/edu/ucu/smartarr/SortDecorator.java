package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private Object[] elements;
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        super(smartArray);
        elements = super.toArray();
        comparator = myComparator;
        for (int i = 0; i < elements.length -1; i++) {
            for (int j = i; j < elements.length; j++) {
                if (comparator.compare(elements[i], elements[j]) > 0) {
                    Object elem = elements[i];
                    elements[i] = elements[j];
                    elements[j] = elem;
                }
            }
        }
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }

    @Override
    public String operationDescription() {
        return "SortDecorator: sorts elements using given comparator; ";
    }

    @Override
    public int size() {
        return super.size();
    }
}
