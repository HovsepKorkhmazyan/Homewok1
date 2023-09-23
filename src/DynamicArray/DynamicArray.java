package DynamicArray;

public class DynamicArray {
    private int[] array = new int[10];
    private int size = 0;

    public void add(int value) {
        if (size >= 10) {
            extend();
        } else {
            array[size++] = value;
        }
    }

    private void extend() {
        int[] secondArray = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            secondArray[i] = array[i];
        }
        array = secondArray;
    }

    public int getByIndex(int index) {
        if (index <= size) {
            return array[index];
        } else {
            return -1;
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
            return;
        }
        int[] result = new int[array.length - 1];
        int resultIndex = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (i != index) {
                result[resultIndex] = array[i];
                resultIndex++;
            }
        }
        array = result;
        size--;

    }

    public void set(int index, int value) {
        if (index < 0 || index > array.length - 1) {
            System.out.println("Invalid Index");
        } else {
            array[index] = value;
        }
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
        } else {
            array[index] = value;
        }
    }

    public boolean exists(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }

        }
        return -1;
    }
}