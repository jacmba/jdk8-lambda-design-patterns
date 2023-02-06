package net.jazbelt.chain.comparator;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);
}
