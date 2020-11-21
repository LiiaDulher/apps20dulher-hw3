package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    private Object[] elements;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        Object[] uniqueElements = new Object[super.size()];
        int i = 0;
        for (Object elem: super.toArray()) {
            boolean notExists = true;
            for (Object unique: uniqueElements){
                if (elem.equals(unique)) {
                    notExists = false;
                    break;
                }
            }
            if (notExists) {
                uniqueElements[i] = elem;
                i++;
            }
        }
        elements = new Object[i];
        for (int j = 0; j < i; j++){
            elements[j] = uniqueElements[j];
        }
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator: removes all duplicates; ";
    }

    @Override
    public int size() {
        return elements.length;
    }
}
