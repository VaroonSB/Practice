import java.util.Arrays;

class CustomArrayList {
    private final int DEFAULT_SIZE = 10;
    private int[] data;
    private int size = 0;

    CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    void add(int value) {
        if (isFull()) {
            resize();
        }
        data[size++] = value;
    }

    private void resize () {
        int[] temp = new int[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    int remove() {
        return data[size--];
    }

    int length() {
        return size;
    }

    void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
               "data=" + Arrays.toString(data) +
               ", size=" + size +
               '}';
    }
}

class Main {
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();

        for (int i = 0; i < 14; i++) {
            list.add(i+1);
        }
        System.out.println(list);
    }
}