package collection.task1;

@FunctionalInterface
interface Filter<T> {
    T apply(T o);
}
