package net.jazbelt.chain;

import net.jazbelt.chain.comparator.Comparator;
import net.jazbelt.chain.model.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestComparator {

    @Test
    public void testComparatorStuff() {
        Person john = new Person("John", 30);
        Person mcCluskey = new Person("McCluskey", 45);
        Person zack = new Person("Zack", 23);

        Comparator<Person> compByName = (p1, p2) -> p1.getName().compareTo(p2.getName());

        assertEquals(3, compByName.compare(mcCluskey, john));
        assertEquals(13, compByName.compare(zack, mcCluskey));

        Comparator<Person> compByAge = (p1, p2) -> p1.getAge() - p2.getAge();

        assertEquals(15, compByAge.compare(mcCluskey, john));
        assertEquals(-7, compByAge.compare(zack, john));
    }
}
