package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InventoryValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInventory {
    String message() default "Invalid inventory";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
