package DynamicArray;

public class DynamicArrayTestDemo {
    public static void main(String[] args) {
        DynamicArray arrayDemo = new DynamicArray();
        arrayDemo.add(3);
        arrayDemo.add(5);
        arrayDemo.add(7);
        arrayDemo.add(9);

        System.out.println(arrayDemo.getByIndex(0));
        System.out.println();
        arrayDemo.print();


    }
}
