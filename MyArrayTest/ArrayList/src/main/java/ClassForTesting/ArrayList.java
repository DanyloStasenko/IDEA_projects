package ClassForTesting;


public class ArrayList<T> {

    private int currentSize = 0;
    int maxSize = 10;
    private Object data[];

    public ArrayList() {
        data = new Object[maxSize];
    }

    public ArrayList(int size) {
        data = new Object[size];
        maxSize = size;
    }

    public void add(T value) {
        if (currentSize == maxSize) {

            int newSize = (maxSize * 3) / 2 + 1;
            Object[] tempArray = data;
            data = new Object[newSize];
            maxSize = newSize;

            for (int i = 0; i < tempArray.length; i++) {
                data[i] = tempArray[i];
            }

        }
        data[currentSize++] = (T) value;
    }

    @SuppressWarnings("unchecked")
    public T getById(int id) {
        return (T) data[id];
    }

    public void removeById(int id) {
        data[id] = null;
    }

}
