package net.jazbelt.chain;

import net.jazbelt.chain.function.Predicate;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPredicate {
    @Test
    public void testPredicates() {
        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isHigh = i -> i > 10;

        assertTrue(isEven.test(18));
        assertTrue(isHigh.test(35));
        assertFalse(isHigh.test(5));
        assertFalse(isEven.test(23));

        assertTrue(isEven.and(isHigh).test(16));
        assertFalse(isEven.and(isHigh).test(17));
        assertFalse(isEven.and(isHigh).test(8));
        assertFalse(isEven.and(isHigh).test(-3));

        assertTrue(isEven.or(isHigh).test(18));
        assertTrue(isEven.or(isHigh).test(8));
        assertTrue(isEven.or(isHigh).test(17));
        assertFalse(isEven.or(isHigh).test(5));
    }
}
