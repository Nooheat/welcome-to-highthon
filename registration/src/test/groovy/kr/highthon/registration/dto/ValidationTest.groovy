package kr.highthon.registration.dto

import spock.lang.Specification

import javax.validation.Validation
import javax.validation.Validator

abstract class ValidationTest extends Specification {
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator()

    protected <T> int validate(T t, Class... groups) {
        def violations = validator.validate(t, groups)
        violations.forEach { violation -> System.out.println(String.format("%s : %s", violation.getPropertyPath(), violation.getMessage())) }
        return violations.size()
    }
}
