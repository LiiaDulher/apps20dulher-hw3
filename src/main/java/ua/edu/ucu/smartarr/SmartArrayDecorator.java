package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    private SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public Object[] toArray() {
        return smartArray.toArray();
    }

    public abstract String operationDescription();

    public int size() {
        return smartArray.size();
    }

}
