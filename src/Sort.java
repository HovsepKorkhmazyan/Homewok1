public class Sort {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 3, 9, 0, 2};
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();

        int temp;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - i; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }

        }
        System.out.println();
        for (int x : array) {
            System.out.print(x + " ");
        }

    }
}

