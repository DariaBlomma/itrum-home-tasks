package collection.task2;

import java.util.HashMap;
import java.util.Map;

class OccurrenceCounter<T> {
    Map<T, Integer> count(T[] array) {
        HashMap<T, Integer> hashMap = new HashMap<>();
        for (T elem: array) {
            if (hashMap.containsKey(elem)) {
                hashMap.merge(elem, 1, Integer::sum);
            } else {
                hashMap.put(elem, 1);
            }
        }
        return hashMap;
    }
}
