package collection.task1;

public class FilterMain {
    public void run() {
        MyFilter<Integer> filterImpl = new MyFilter<>();
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        Integer[] filtered = filterImpl.filter(array, Integer::reverseBytes);

        for (Integer num: filtered) {
            System.out.println(num);
        }
    }
}
