public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println(numbers[0]);

        System.out.println();

        System.out.println(numbers.length - 1);

        System.out.println();

        System.out.println(numbers.length);

        System.out.println();


        int smallestNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallestNumber){
                smallestNumber = numbers[i];
            }

        }
        System.out.println(smallestNumber);

        System.out.println();

        int evenNumbers = 0; int oddNumbers=0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0){
                evenNumbers +=1;

            } else {
                oddNumbers += 1;
            }
        }
        System.out.println("Even Number Count: " + evenNumbers);
        System.out.println("Odd Number Count: " + oddNumbers);

        System.out.println();

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Sum is: " + sum);

        System.out.println();

        int length = numbers.length;

        double average = sum / length;
        System.out.println("The Average is: " + average);

        System.out.println();

        if (numbers.length > 2){
            System.out.println(numbers.length - 5);
        } else if (numbers.length <= 2) {
            System.out.println("Can not print the middle value");
        } else if (numbers.length == evenNumbers) {
            System.out.println(numbers.length - 5);
            System.out.println(numbers.length - 4);
        } else {
            System.out.println(numbers.length - 5);
        }

        System.out.println();


        int middleIndex = length / 2;
        System.out.println(numbers[middleIndex]);

    }
}
