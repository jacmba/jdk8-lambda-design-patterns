package net.jazbelt.chain;

import net.jazbelt.chain.function.Consumer;
import net.jazbelt.chain.util.FakeOut;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDefaultMethods {
    @Test
    public void defaultMethodsTest() {
        Consumer<String> c1 = s -> FakeOut.print("c1 = " + s);
        Consumer<String> c2 = s -> FakeOut.print("c2 = " + s);

        c1.accept("Hello");
        assertEquals("c1 = Hello", FakeOut.read());

        c2.accept("world");
        assertEquals("c2 = world", FakeOut.read());

        Consumer<String> c3 = c1.andThen(c2);
        c3.accept("Lorem ipsum");
        assertEquals("c2 = Lorem ipsum", FakeOut.read());
    }
}
