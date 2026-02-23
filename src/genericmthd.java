public class genericmthd {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"Hello", "World"};

        printArray(intArray);
        printArray(stringArray);
    }

    public static <T> void printArray(T[] array) {

        for (T element : array) {
            System.out.print(element + " ");
        }

        System.out.println();
    }
}