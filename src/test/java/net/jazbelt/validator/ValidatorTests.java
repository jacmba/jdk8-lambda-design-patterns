package net.jazbelt.validator;

import net.jazbelt.validator.model.Person;
import net.jazbelt.validator.util.IValidator;
import org.junit.Test;

public class ValidatorTests {
    @Test
    public void testStuffWithValidators() {
        Person jdoe = new Person("John Doe", 30);
        Person james = new Person(null, 25);
        Person mary = new Person("Mary", -10);
        Person jane = new Person("Jane", 1000);

        IValidator validator = IValidator.validate(p -> p.getName() != null, "The name should not be null")
                .thenValidate(p -> p.getAge() >= 0 && p.getAge() <= 150, "Age should be between 0 and 150");

        jdoe = validator.on(jdoe).validate();
        System.out.println(jdoe);

        try {
            james = validator.on(james).validate();
            throw new RuntimeException("Shouldn't reach this");
        } catch (IValidator.ValidationException e) {
            e.printStackTrace();
        }

        try {
            mary = validator.on(mary).validate();
            throw new RuntimeException("Shouldn't reach this");
        } catch (IValidator.ValidationException e) {
            e.printStackTrace();
        }

        try {
            jane = validator.on(jane).validate();
            throw new RuntimeException("Shouldn't reach this");
        } catch (IValidator.ValidationException e) {
            e.printStackTrace();
        }
    }
}
