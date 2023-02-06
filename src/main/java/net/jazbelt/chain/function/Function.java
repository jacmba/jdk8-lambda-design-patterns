package net.jazbelt.chain.function;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> other) {
        return (T t) -> {
            R r = apply(t);
            return other.apply(r);
        };
    }
}
