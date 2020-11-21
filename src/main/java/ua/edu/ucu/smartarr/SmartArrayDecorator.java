package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public Object[] toArray() {
        return smartArray.toArray();
    }

    public String operationDescription() {
        return "SmartArrayDecorator; ";
    }

    public int size() {
        return smartArray.size();
    }

}
