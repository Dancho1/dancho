/**
 * Created by asus on 28.03.2017.
 */
public class OwnArrayList<T> {

    private final int DEFAULT_SIZE = 16;
    private Object[] array;
    private int size;

    public OwnArrayList() {
        array = new Object[DEFAULT_SIZE];
    }
    public OwnArrayList(int length) {
        array = new Object[length];
    }


    private void checkIndex(int index) {   //сомневался, но решил всё-таки написать. не сделал хуже?
        if(index < 0 || index > size) {
            System.out.println("IllegalIndex");
            throw new IllegalArgumentException();
        }
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }


    public void add(T value) {
        if(size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

    public void add(int index, T value) {
        checkIndex(index);
        if(size  == array.length) {
            resize();
        }
        for(int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    public void clear() {
        for(int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 1;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T ans = (T) array[index];
        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return ans;
    }


}
