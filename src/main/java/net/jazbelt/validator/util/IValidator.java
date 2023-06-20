package net.jazbelt.validator.util;

import net.jazbelt.validator.model.Person;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface IValidator {
    IValidatorSupplier on(Person p);

    default  IValidator thenValidate(Predicate<Person> predicate, String errMsg) {
        return p -> {
            try {
                on(p).validate();
                if (predicate.test(p)) {
                    return () -> p;
                } else {
                    return () -> {
                        ValidationException exception = new ValidationException("The object is not valid");
                        exception.addSuppressed(new IllegalArgumentException(errMsg));
                        throw exception;
                    };
                }
            } catch (ValidationException e) {
                if (predicate.test(p)) {
                    return () -> {
                        throw e;
                    };
                } else {
                    e.addSuppressed(new IllegalArgumentException(errMsg));
                    return () -> {
                        throw e;
                    };
                }
            }
        };
    }
    
    static IValidator validate(Predicate<Person> predicate, String errMsg) {
        return p -> {
            if (predicate.test(p)) {
                return () -> p;
            } else {
                return () -> {
                    ValidationException exception = new ValidationException("The object is not valid");
                    exception.addSuppressed(new IllegalArgumentException(errMsg));
                    throw exception;
                };
            }
        };
    }

    interface IValidatorSupplier extends Supplier<Person> {
        default Person validate() {
            return get();
        }
    }

    static class ValidationException extends RuntimeException {
        public ValidationException(String msg) {
            super(msg);
        }
    }
}
