package DynamicArray;

public class DynamicArrayTestDemo {
    public static void main(String[] args) {
        DynamicArray arrayDemo = new DynamicArray();
        arrayDemo.add(3);
        arrayDemo.add(5);
        arrayDemo.add(7);
        arrayDemo.add(9);
        arrayDemo.add(10);
        arrayDemo.add(12);
        arrayDemo.add(14);


        System.out.println(arrayDemo.getByIndex(2));

        System.out.println();

        arrayDemo.print();

        arrayDemo.deleteByIndex(0);

        arrayDemo.print();

        arrayDemo.set(0, 6);

        arrayDemo.print();

        arrayDemo.add(1, 4);

        arrayDemo.print();


    }
}
