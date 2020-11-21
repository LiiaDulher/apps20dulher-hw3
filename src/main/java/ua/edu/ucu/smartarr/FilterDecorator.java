package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private Object[] elements;
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        predicate = myPredicate;
        Object[] filteredElements = new Object[super.size()];
        int i = 0;
        for (Object elem: super.toArray()) {
            if (predicate.test(elem)) {
                filteredElements[i] = elem;
                i++;
            }
        }
        elements = new Object[i];
        for (int j = 0; j < i; j++){
            elements[j] = filteredElements[j];
        }
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }

    @Override
    public String operationDescription() {
        return "FilterDecorator: removes all items, which doesn't satisfy" +
                " given predicate; ";
    }

    @Override
    public int size() {
        return elements.length;
    }
}
