public class ForExamples {
    public static void main(String[] args) {
        int num = 1000;
        for (int i = 1; i <= num; i++) {
            System.out.print(" " + i);

        }

        System.out.println();
        System.out.println();

        int num2 = 100;
        for (int i = 1; i <= num2; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }


        }
        System.out.println();
        System.out.println();

        int[] array = {2, 5, 8, 4, 9, 3, 7};
        int largestNum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largestNum) {
                largestNum = array[i];
            }


        }

        System.out.print("The Largest Number Is:" + " " + largestNum);

    }
}
