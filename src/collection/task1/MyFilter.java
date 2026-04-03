package collection.task1;

import java.lang.reflect.Array;
import java.util.ArrayList;

class MyFilter<T> {
    @SuppressWarnings("unchecked")
    T[] filter(T[] array, Filter<T> filterImpl) {
        ArrayList<T> filtered = new ArrayList<>();

        for(T elem : array) {
            filtered.add(filterImpl.apply(elem));
        }

        return filtered.toArray((T[]) Array.newInstance(array.getClass().getComponentType(), filtered.size()));
    }
}
