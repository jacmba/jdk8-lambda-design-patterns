package net.jazbelt.chain.function;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        return (T t) -> test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<T> other) {
        return (T t) -> test(t) || other.test(t);
    }
}
