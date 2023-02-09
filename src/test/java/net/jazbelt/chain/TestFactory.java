package net.jazbelt.chain;

import net.jazbelt.chain.factory.CircleFactory;
import net.jazbelt.chain.factory.Factory;
import net.jazbelt.chain.model.Circle;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.function.Supplier;

public class TestFactory {

    @Test
    public void testBasicSupplierFactory() {
        Supplier<Circle> factory = Circle::new;

        Circle circle = factory.get();
        assertEquals("Circle [white]", circle.toString());
    }

    @Test
    public void testGetCircleWithCircleFactory() {
        CircleFactory factory = Circle::new;

        Circle circle = factory.get();
        assertEquals("Circle [white]", circle.toString());
    }

    @Test
    public void testGetCircleWithCircleFactoryNewInstance() {
        CircleFactory factory = Circle::new;

        Circle circle = factory.newInstance();
        assertEquals("Circle [white]", circle.toString());
    }

    @Test
    public void testCreate5CirclesWithFactory() {
        CircleFactory factory = Circle::new;

        List<Circle> circles = factory.create5Circles();
        assertEquals(5, circles.size());
        for(int i = 0; i < 5; i++) {
            assertEquals("Circle [white]", circles.get(i).toString());
        }
    }

    @Test
    public void testCreateCircleWithGenericFactory() {
        Factory<Circle> factory = Circle::new;

        Circle circle = factory.newInstance();
        assertEquals("Circle [white]", circle.toString());
    }

    @Test
    public void testCreate5CirclesWithGenericFactory() {
        Factory<Circle> factory = Circle::new;

        List<Circle> circles = factory.create5();
        assertEquals(5, circles.size());
        for(int i = 0; i < 5; i++) {
            assertEquals("Circle [white]", circles.get(i).toString());
        }
    }

    @Test
    public void testCreateCircleWithStaticFactory() {
        Factory<Circle> factory = Factory.createFactory();

        Circle circle = factory.newInstance();
        assertEquals("Circle [white]", circle.toString());
    }

    @Test
    public void testCreateDifferentColorCircleWithStaticFactory() {
        Factory<Circle> factory = Factory.createFactory("red");

        Circle circle = factory.newInstance();
        assertEquals("Circle [red]", circle.toString());
    }
}
