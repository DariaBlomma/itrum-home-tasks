package collection.task2;

import tests.Testable;
import java.util.Map;

public class OccurrenceCounterTest implements Testable {
    public boolean ifArrayContainsOnlyUniqueElemsThenItReturns1ForEachElem() {
        Integer[] uniqueArray = {10, 20, 30, 40, 50};
        OccurrenceCounter<Integer> counter = new OccurrenceCounter<>();
        Map<Integer, Integer> map = counter.count(uniqueArray);

        Map<Integer, Integer> expected = Map.of(
                10, 1,
                20, 1,
                30, 1,
                40, 1,
                50, 1
        );
        return map.equals(expected);
    }

    public boolean ifArrayContainsOfSeveralRepeatedElemsThenItReturnsCorrectCountForEachElem() {
        Integer[] repeatedArray = {10, 20, 19, 40, 20, 20, 10, 40};
        OccurrenceCounter<Integer> counter = new OccurrenceCounter<>();
        Map<Integer, Integer> map = counter.count(repeatedArray);

        Map<Integer, Integer> expected = Map.of(
                10, 2,
                20, 3,
                19, 1,
                40, 2
        );
        return map.equals(expected);
    }
}
