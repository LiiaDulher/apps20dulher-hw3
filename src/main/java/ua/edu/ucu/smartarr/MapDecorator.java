package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private Object[] elements;
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(smartArray);
        elements = super.toArray();
        function = myFunction;
        for (int i = 0; i < super.size(); i++) {
            elements[i] = function.apply(elements[i]);
        }
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator: applies given function to each element; ";
    }

    @Override
    public int size() {
        return elements.length;
    }
}
