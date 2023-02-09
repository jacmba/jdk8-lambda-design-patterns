package net.jazbelt.chain.factory;

import net.jazbelt.chain.model.Circle;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    default List<T> create5() {
        return IntStream.range(0, 5)
                .mapToObj(i -> newInstance())
                .collect(Collectors.toList());
    }

    static Factory<Circle> createFactory() {
        return Circle::new;
    }

    static Factory<Circle> createFactory(String color) {
        return () -> new Circle(color);
    }
}
