import java.util.*;

public class generic_deep {

    // Generic Class
    static class Box<T> {
        private T value;

        public void set(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }

    //  Generic Method
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //  Upper Bound (Producer)
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // Lower Bound (Consumer)
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {

        // Generic Class
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println("Box contains: " + stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Box contains: " + intBox.get());

        //  Generic Method
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"A", "B", "C"};

        printArray(intArray);
        printArray(strArray);

        //  Upper Bound Example
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.5, 2.5);

        System.out.println("Sum of integers: " + sumNumbers(intList));
        System.out.println("Sum of doubles: " + sumNumbers(doubleList));

        //  Lower Bound Example
        List<Object> objList = new ArrayList<>();
        addIntegers(objList);

        System.out.println("After adding integers: " + objList);

        //  Raw Type Danger
        List rawList = new ArrayList(); // BAD
        rawList.add("Hello");
        rawList.add(123);

        String s = (String) rawList.get(0); // works
        // String x = (String) rawList.get(1); // Runtime ClassCastException
    }
}