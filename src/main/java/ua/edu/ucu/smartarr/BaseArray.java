package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] elements;

    public BaseArray(Object[] elms){
        elements = elms.clone();
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return elements.length;
    }
}
