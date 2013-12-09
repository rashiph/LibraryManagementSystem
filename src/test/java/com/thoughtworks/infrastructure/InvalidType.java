package com.thoughtworks.infrastructure;

import com.google.common.base.Function;
import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import org.springframework.hateoas.Identifiable;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.transform;
import static com.natpryce.makeiteasy.MakeItEasy.*;

public class InvalidType<T extends Identifiable, U> {
  private final T instance;
  private Set<ConstraintViolation<T>> constraintViolations;
  private Validator validator;

  public InvalidType(Instantiator<T> instance, Property<T, U> field, U value, Validator validator) {
    this.validator = validator;
    this.instance = make(a(instance, with(field, value)));
  }

  public boolean isValid(Class<?>... groups) {
    constraintViolations = validator.validate(instance, groups);
    return constraintViolations.isEmpty();
  }

  public List<String> failingProperties() {
    return transform(new ArrayList<ConstraintViolation<T>>(constraintViolations), toProperties());
  }

  public List<String> errorMessages() {
    return transform(new ArrayList<ConstraintViolation<T>>(constraintViolations), toErrorMessages());
  }

  public String failingProperty() {
    return firstViolation().getPropertyPath().toString();
  }

  public String errorMessage() {
    return firstViolation().getMessage();
  }

  private ConstraintViolation<T> firstViolation() {
    return constraintViolations.iterator().next();
  }

  private Function<? super ConstraintViolation<T>, String> toProperties() {
    return new Function<ConstraintViolation<T>, String>() {
      @Override
      public String apply(ConstraintViolation<T> violation) {
        return violation.getPropertyPath().toString();
      }
    };
  }

  private Function<? super ConstraintViolation<T>, String> toErrorMessages() {
    return new Function<ConstraintViolation<T>, String>() {
      @Override
      public String apply(ConstraintViolation<T> violation) {
        return violation.getMessage();
      }
    };
  }
}

