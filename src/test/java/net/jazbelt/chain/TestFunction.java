package net.jazbelt.chain;

import net.jazbelt.chain.function.Function;
import net.jazbelt.chain.util.FakeOut;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFunction {

    @Test
    public void testFunctionalFunctions() {
        Function<Integer, String> f1 = i -> i % 2 == 0 ? "EVEN" : "ODD";
        Function<String, Integer> f2 = String::length;

        String s1 = f1.apply(28);
        String s2 = f1.apply(3457);

        FakeOut.print("s1 is " + s1);
        FakeOut.print("s2 is " + s2);

        assertEquals("EVEN", s1);
        assertEquals("ODD", s2);

        Function<Integer, Integer> f3 = f1.andThen(f2);

        int i1 = f3.apply(8);
        int i2 = f3.apply(9);

        FakeOut.print("i1 is " + i1);
        FakeOut.print("i2 is " + i2);

        assertEquals(4, i1);
        assertEquals(3, i2);
    }
}
