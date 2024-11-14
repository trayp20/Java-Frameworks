package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {

    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        // Initialization code if needed
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part == null) {
            return true; // Null values are handled by @NotNull
        }

        boolean valid = part.getInv() >= part.getMinInv() && part.getInv() <= part.getMaxInv();

        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Inventory must be between " + part.getMinInv() + " and " + part.getMaxInv() + ".")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
        }

        return valid;
    }
}
